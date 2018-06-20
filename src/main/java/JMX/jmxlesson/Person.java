package JMX.jmxlesson;

import java.io.Serializable;

public class Person implements Serializable {
    private  String name = "Zapel";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
