package ru.taxiservice.taxi.domain;

public enum TariffType {
	GPS(1), // GPS-�����������
	TariffSchedule(2); // �������� �����
	
	private int value;
    private TariffType(int value){
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(Integer v) {
    	value = v;
    }
    
    public static TariffType valueOf(int value) {
    	switch(value) {
	    	case 1: return GPS;
	    	case 2: return TariffSchedule;
	    	default: return GPS;
    	}
    }
}
