package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // 1.
        int sum = IntStream.rangeClosed(1, 10000)
                .filter(i -> i % 3 == 0 && i % 5 == 0 && i % 7 != 0)
                .sum();
        System.out.println("Sum: " + sum);

        // 2.
        Stream.iterate(2, A -> A + 2)
                .filter(A -> A % 8 != 0)
                .limit(100)
                .forEach(System.out::println);

        // 3
        com.main.Book b1 = new com.main.Book("Book1", 100);
        com.main.Book b2 = new com.main.Book("Book22", 20);
        com.main.Book b3 = new com.main.Book("Book3", 30);
        com.main.Book b4 = new com.main.Book("ABook4", 40);
        com.main.Book b5 = new com.main.Book("Bok5", 50);

        List<com.main.Book> list = new ArrayList<>();
        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);
        list.add(b5);


        //3.1
        list.stream()
                .filter(book -> book.getPrice() < 100)
                .map(com.main.Book::getName)
                .sorted()
                .forEach(System.out::println);

        //3.2
        System.out.println("Name shorter than 5 characters have "
                +list.stream()
                .filter(book -> book.getName().length() < 5 )
                .count()
                + " book.");

        //3.3
        System.out.println("Average price of books is "
                +list.stream()
                .mapToInt(com.main.Book::getPrice)
                .average()
                .getAsDouble());

        //3.4
        System.out.println("Are all books in list cheaper than 500? Answer is: "
                +list.stream()
                .allMatch(book -> book.getPrice() < 500));

    }

}