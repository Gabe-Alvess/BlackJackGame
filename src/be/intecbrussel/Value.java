package be.intecbrussel;

public enum Value {
//  constatnts
    ACE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("Jack"),
    QUEEN("Queen"),
    KING("King");

//  property
    private final String value;

//  constructor
    Value(String value) {
        this.value = value;
    }

//  getter
    public String getValue() {
        return value;
    }
}
