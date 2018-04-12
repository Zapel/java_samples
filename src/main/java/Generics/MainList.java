package Generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Parent {

}

class Child extends Parent{

}

public class MainList <T extends MainList & Comparable & Serializable>{
    public static void main(String[] args) throws Exception {
        //List<Parent> list = new ArrayList<>();
        List<Child> list = new ArrayList<>();
        //list.add(new Parent());
        list.add(new Child());
        MainList main = new MainList();
        main.method(list);
    }

    void method(List<? extends Parent> list) {
        for(Parent parent : list) {
            System.out.println(parent);
        }
        //list.add(new Child());
    }
}
