package ru.taxiservice.taxi.domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;
import org.postgresql.geometric.PGpoint;

public class PointUserType implements UserType
{

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] names, Object owner)
        throws HibernateException, SQLException
    {
    	assert names.length == 1;
    	if (resultSet.wasNull() || resultSet.getObject(names[0]) == null)
    	{
    		return new PGpoint();
    	}
    	
        final PGpoint point = new PGpoint(resultSet.getObject(names[0]).toString());
        return point;
    }

    @Override
    public void nullSafeSet(PreparedStatement statement, Object value, int index)
        throws HibernateException, SQLException
    {
        statement.setObject(index, value);
    }

    @Override
    public int[] sqlTypes()
    {
        return new int[]
        {
            Types.VARCHAR
        };
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Class returnedClass()
    {
        return PGpoint.class;
    }

    @Override
    public boolean equals(Object o, Object o1) throws HibernateException
    {
        boolean isEqual = false;
        if (o == o1)
        {
                isEqual = true;
        }
        if (o == null || o1 == null)
        {
            isEqual = false;
        }
        else
        {
            isEqual = o.equals(o1);
        }
        return isEqual;
   }

    @Override
    public int hashCode(Object o) throws HibernateException
    {
        return o.hashCode();
    }

    @Override
    public Object deepCopy(Object o) throws HibernateException
    {
        return (Serializable) o;
    }

    @Override
    public boolean isMutable()
    {
        return true;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException
    {
        return (Serializable) o;
    }

    @Override
    public Object assemble(Serializable srlzbl, Object o) throws HibernateException
    {
        return srlzbl;
    }

    @Override
    public Object replace(Object o, Object o1, Object o2) throws HibernateException
    {
        return this;
    }

}