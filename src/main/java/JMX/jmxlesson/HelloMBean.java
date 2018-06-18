package JMX.jmxlesson;

public interface HelloMBean {
    void sayHello();
    int addIntegers (int a, int b);

    //Person getPerson();
    Person returnPerson();

    String getName();
    void setName(String name);
}
