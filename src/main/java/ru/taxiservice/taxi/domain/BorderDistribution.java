package ru.taxiservice.taxi.domain;

/* Граница распределения */
public enum BorderDistribution {
	InsideParking(1),
	AdjacentParking(2),
	Through2ParkingLots(3);
	
	private int value;
    private BorderDistribution(int value){
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(Integer v) {
    	value = v;
    }
    
    public static BorderDistribution valueOf(int value) {
    	switch(value) {
	    	case 1: return InsideParking;
	    	case 2: return AdjacentParking;
	    	case 3: return Through2ParkingLots;
	    	default: return InsideParking;
    	}
    }
}
