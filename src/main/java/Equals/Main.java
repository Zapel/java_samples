package Equals;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Book x = new Book("one");
        Book y = new Book("one");
        Book z = new Book("one");

        //reflexive
        System.out.println("reflexive");
        System.out.println(x.equals(x));//true
        System.out.println();

        //symmetric
        System.out.println("symmetric");
        System.out.println(x.equals(y));
        System.out.println(y.equals(x));
        System.out.println();

        //transitive
        System.out.println("transitive");
        System.out.println(x.equals(y));
        System.out.println(y.equals(z));
        System.out.println(x.equals(z));
        System.out.println();

        //consistent
        System.out.println("consistent");
        System.out.println(x.equals(y));
        System.out.println(x.equals(y));
        System.out.println(x.equals(y));
        System.out.println(x.equals(y));
        System.out.println();

        //not null
        System.out.println("not null");
        System.out.println(x.equals(null));//false
        System.out.println();
    }
}

class Book {
    String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            return obj != null && this.title.equals(((Book) obj).title);
        }
        return false;
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
    */
}
