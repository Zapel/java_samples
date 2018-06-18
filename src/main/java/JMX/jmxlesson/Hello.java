package JMX.jmxlesson;

public class Hello implements HelloMBean {
    private  String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello from jmx.");
    }

    @Override
    public int addIntegers(int a, int b) {
        return a + b;
    }

    @Override
    public Person returnPerson() {
        return new Person();
    }
}
