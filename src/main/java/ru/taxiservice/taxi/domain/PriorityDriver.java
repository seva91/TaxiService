package ru.taxiservice.taxi.domain;

/* Приоритетный водитель */
public enum PriorityDriver {
	Nearest(1), // Ближайший (по расстоянию)
	Best(2), // Лучший (по рейтингу)
	Smart(3); // Смарт (оценка расстояния и рейтинга)
	
	private int value;
    private PriorityDriver(int value){
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(Integer v) {
    	value = v;
    }
    
    public static PriorityDriver valueOf(int value) {
    	switch(value) {
	    	case 1: return Nearest;
	    	case 2: return Best;
	    	case 3: return Smart;
	    	default: return Nearest;
    	}
    }
}