package be.intecbrussel;

public enum Stack {
//  constants
    SPADE("Spade"),
    CLUB("Club"),
    DIAMOND("Diamond"),
    HEART("Heart");

//  property
    private final String stackName;

//  constructor
    Stack(String stackName) {
        this.stackName = stackName;
    }

//  getter
    public String getStackName() {
        return stackName;
    }
}
