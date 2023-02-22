package be.intecbrussel;

public class Card {
//  propertys
    private final Stack stack;
    private final Value value;

//  constructors
    public Card(Stack stack, Value value) {
        this.stack = stack;
        this.value = value;
    }

// getters
    public Value getValue() {
        return value;
    }

//  method
    public String generatedCard() {
        return stack.getStackName() + " - " + value.getValue();
    }
}
