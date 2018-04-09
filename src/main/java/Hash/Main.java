package Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Book {
    String author;
    String name;
    String format;
}

class Ticket{
    int number;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return number == ticket.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}

public class Main extends Object{

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        ticket.number = 1123;

        Book book = new Book();
        book.author = "Dale Carnegie";
        book.name = "How to get friends";
        book.format = "Big";

        Map<Ticket, Book> library = new HashMap<Ticket, Book>();
        library.put(ticket, book);

        Ticket ticket2 = new Ticket();
        ticket2.number = 1123;

        //Book daleBook = library.get(ticket);
        //System.out.println(daleBook.author);
        //System.out.println(daleBook.name);
        //System.out.println(daleBook.format);

        Book daleBook = library.get(ticket2);
        System.out.println(daleBook.author);
        System.out.println(daleBook.name);
        System.out.println(daleBook.format);

        //System.out.println(book.hashCode());
        //System.out.println(new Book().hashCode());
    }
}
