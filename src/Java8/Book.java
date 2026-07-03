package Java8;

import java.util.*;
import java.util.stream.Collectors;

class Book {
    String category;
    int copiesSold;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }

    public Book(String category, int copiesSold) {
        this.category = category;
        this.copiesSold = copiesSold;
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Fiction", 1200),
                new Book("Science", 800),
                new Book("Fiction", 700),
                new Book("History", 450)
        );

        Map<String, Integer> map = books.stream().collect(Collectors.groupingBy(Book::getCategory, Collectors.summingInt(Book::getCopiesSold)));
map.forEach((k,v)->{
    System.out.println(k+"="+v);
});

//max copy sold out of present different category
        Map<String, Optional<Book>> map1 =books.stream().collect(Collectors.groupingBy(Book::getCategory, Collectors.maxBy(Comparator.comparingDouble(Book::getCopiesSold))));
               map1.forEach((k,v)->{
                   System.out.println(k+"="+v.get().getCopiesSold());
               });
    }



}