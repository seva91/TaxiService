package ru.taxiservice.taxi.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;


/// Описание запроса на список элементов
public class QueryCriteria {
	
	public static void setWhere(Map<String, Object> parameters, StringBuilder where, FilterCriteriaList fcl, String union) {
		boolean first = true; 
		for (FilterCriteria fc : fcl) {
			FilterAtom atom = fc.getAtom();
			FilterCriteriaList and = fc.getAnd();
			FilterCriteriaList or = fc.getOr();
			if (atom != null) {
				where.append((first ? "" : union) + " " + atom.getField() + " " + atom.getOp() + " :" + atom.getField() + " "); 
				parameters.put(atom.getField(), atom.getValue());
			}
			if (and != null) {
				where.append(union + " (");
				setWhere(parameters, where, and, "and");
				where.append(") ");
			}
			if (or != null) {
				where.append(union + " (");
				setWhere(parameters, where, or, "or");
				where.append(") ");
			}
			first = false;
		}
		
	}
	
	public static void setCriteria(org.hibernate.Criteria criteria, QueryCriteria qc, String union) {
		Queue<Criterion> cList = new LinkedList<Criterion>();
		FilterCriteriaList fcl = qc.getFilter();
		
		// Устанавливаем условие выборки
		if (fcl != null)
			for (FilterCriteria fc : fcl) {
				FilterAtom atom = fc.getAtom();
				FilterCriteriaList and = fc.getAnd();
				FilterCriteriaList or = fc.getOr();
				if (atom != null) {
					Criterion c = null;
					if (atom.getOp().equals("="))
						c = Restrictions.eq(atom.getField(), atom.getValue());
					if (atom.getOp().equals("!="))
						c = Restrictions.not(Restrictions.eq(atom.getField(), atom.getValue()));
					if (atom.getOp().equals("like"))
						c = Restrictions.like(atom.getField(), atom.getValue());
					if (atom.getOp().equals("ilike"))
						c = Restrictions.ilike(atom.getField(), atom.getValue()); 
					if (atom.getOp().equals("in"))
						c = Restrictions.in(atom.getField(), (Object[])atom.getValue());
					if (atom.getOp().equals("is null"))
						c = Restrictions.isNull(atom.getField());
					if (atom.getOp().equals("is not null"))
						c = Restrictions.isNotNull(atom.getField());
					
					if (c != null)
						cList.offer(c);
				}
				if (and != null) {
					setCriteria(criteria, qc, "and");
				}
				if (or != null) {
					setCriteria(criteria, qc, "or");
				}
			}
		
		Criterion _c = getLogicalExpression(cList, union);
		if (_c != null)
			criteria.add(_c);
		
		// Устанавливаем пагинацию
		PagingCriteria pc = qc.getPaging();
		if (pc != null) {
			criteria.setMaxResults(pc.getItemsPerPage());
			criteria.setFirstResult(pc.getItemsPerPage()*pc.getPage());
		}
		
		// Устанавливаем сортировку
		OrderingCriteria oc = qc.getOrdering();
		if (oc != null) {
			if (oc.getAscending()) {
				criteria.addOrder(org.hibernate.criterion.Order.asc(oc.getField()));
			} else {
				criteria.addOrder(org.hibernate.criterion.Order.desc(oc.getField()));
			}
		}
	}
	
	
	public static Criterion getLogicalExpression(Queue<Criterion> cList, String union) {
		if (cList.size() == 0) return null;
		if (cList.size() == 1) return cList.poll();
		Criterion c = cList.poll();
		if (union.equals("and"))
			return Restrictions.and(c, getLogicalExpression(cList, union));
		if (union.equals("or"))
			return Restrictions.or(c, getLogicalExpression(cList, union));
		return null;
	}
	
    /// Пагинация
    private PagingCriteria paging;
    
    /// Фильтр
    private FilterCriteriaList filter;

    /// Сортировка (для обратной совместимости)
    private OrderingCriteria ordering;

	public PagingCriteria getPaging() {
		return paging;
	}

	public void setPaging(PagingCriteria paging) {
		this.paging = paging;
	}

	public FilterCriteriaList getFilter() {
		return filter;
	}

	public void setFilter(FilterCriteriaList filter) {
		this.filter = filter;
	}

	public OrderingCriteria getOrdering() {
		return ordering;
	}

	public void setOrdering(OrderingCriteria ordering) {
		this.ordering = ordering;
	}
	
    
	/// Пагинация.
	public class PagingCriteria {
		
	    /// Номер страницы (начиная с 0)
	    private int page;
	    
	    /// Количество элементов на странице
	    private int itemsPerPage;
	    
	    public PagingCriteria(int page, int itemsPerPage) {
	    	this.page = page;
	    	this.itemsPerPage = itemsPerPage;
	    }

		public int getPage() {
			return page;
		}

		public void setPage(int page) {
			this.page = page;
		}

		public int getItemsPerPage() {
			return itemsPerPage;
		}

		public void setItemsPerPage(int itemsPerPage) {
			this.itemsPerPage = itemsPerPage;
		}
	    
	}

	/// Фильтр
	public class FilterCriteriaList implements Iterable<FilterCriteria> {
		
		/// Список условий
		private List<FilterCriteria> conditions = new ArrayList<QueryCriteria.FilterCriteria>();

		public List<FilterCriteria> getConditions() {
			return conditions;
		}

		public void setConditions(List<FilterCriteria> conditions) {
			this.conditions = conditions;
		}

		@Override
		public Iterator<FilterCriteria> iterator() {
			return new Iterator<QueryCriteria.FilterCriteria>() {
				private int count = 0;
				
				@Override
				public void remove() { }
				
				@Override
				public FilterCriteria next() {
					return conditions.get(count++);
				}
				
				@Override
				public boolean hasNext() {
					return count != conditions.size();
				}
			};
		}
		
	}

	// Фильтр. Заполнять только одно поле.
	public class FilterCriteria {
		
		private FilterCriteriaList and;
		
		private FilterCriteriaList or;
		
		private FilterAtom atom;
		
		public FilterCriteria(FilterCriteriaList and, FilterCriteriaList or, FilterAtom atom) {
			this.and = and;
			this.or = or;
			this.atom = atom;
		}

		public FilterCriteriaList getAnd() {
			return and;
		}

		public void setAnd(FilterCriteriaList and) {
			this.and = and;
		}

		public FilterCriteriaList getOr() {
			return or;
		}

		public void setOr(FilterCriteriaList or) {
			this.or = or;
		}

		public FilterAtom getAtom() {
			return atom;
		}

		public void setAtom(FilterAtom atom) {
			this.atom = atom;
		}
		
	}

	/// Простой фильтр (одно условие)
	public class FilterAtom
	{
		
		/// Поле, по которому идет фильтрация
		private String field;
		
		/// Оператор. Возможные значения: операторы сравнения, in, like, ilike, is null, is not null, any
		private String op;
		  
		/// Значение, с которым сравнивается поле. В случае in значения перечисляются через запятую
		private Object value;
		
		public FilterAtom(String field, String op, Object value) {
			this.field = field;
			this.op = op;
			this.value = value;
		}

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public String getOp()  {
			return op;
		}

		public void setOp(String op) {
			this.op = op;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}
		
	}

	/// Сортировка.
	public class OrderingCriteria {
		
	    /// Поле, по которому идет сортировка
	    private String field;
	    
	    /// По возрастанию или по убыванию
	    private Boolean ascending;
	    
	    public OrderingCriteria(String field, boolean ascending) {
	    	this.field = field;
	    	this.ascending = ascending;
	    }
	    
		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public Boolean getAscending() {
			return ascending;
		}

		public void setAscending(Boolean ascending) {
			this.ascending = ascending;
		}
	    
	}
}






