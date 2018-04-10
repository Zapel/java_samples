package Collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class PersonNew {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PersonNew(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonNew{" +
                "age=" + age +
                '}';
    }
}

class ComparePerson implements Comparator<PersonNew> {
    @Override
    public int compare(PersonNew o1, PersonNew o2) {
        return o1.getAge() - o2.getAge();
    }
}

public class SortMainCompare {
    public static void main(String[] args) {
        Set set = new TreeSet( new ComparePerson());
        set.add(new PersonNew(4));
        set.add(new PersonNew(6));
        set.add(new PersonNew(5));
        set.add(new PersonNew(2));

        for(Object o : set) {
            System.out.println(o);
        }
    }
}
