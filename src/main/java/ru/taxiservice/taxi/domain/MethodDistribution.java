package ru.taxiservice.taxi.domain;

/* Способ распределения */
public enum MethodDistribution {
	InTurn(1), // По очереди
	Avalanche(2), // Лавина
	OpenAir(3); // Открытый эфир
	
	private int value;
    private MethodDistribution(int value){
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(Integer v) {
    	value = v;
    }
    
    public static MethodDistribution valueOf(int value) {
    	switch(value) {
	    	case 1: return InTurn;
	    	case 2: return Avalanche;
	    	case 3: return OpenAir;
	    	default: return InTurn;
    	}
    }
}
