package designPattern.factoryMethodPattern;

public class Dog extends Animal {
    @Override
    AnimalToy getToy() {
        return new DogToy();
    }
}
