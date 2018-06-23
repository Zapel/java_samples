package Patterns;

public class FactoryMethodLesson {
    public static void main(String[] args) {
        Person person = Person.create();
    }
}

class Person {
    private Person() {
        System.out.println("Person create!");
    }
    public static Person create() {
        return new Person();
    }
}
