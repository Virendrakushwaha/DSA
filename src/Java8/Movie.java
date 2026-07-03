package Java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


class Movie {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimesRented() {
        return timesRented;
    }

    public void setTimesRented(int timesRented) {
        this.timesRented = timesRented;
    }

    int timesRented;
    public Movie(String name, int timesRented) {
        this.name = name;
        this.timesRented = timesRented;
    }
    @Override
    public String toString() {
        return name + " (Rented " + timesRented + " times)";
    }

    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Inception", 320),
                new Movie("Interstellar", 410),
                new Movie("The Dark Knight", 290)
        );

        //Each movie has a name and a rental count. The platform wants to find the single
        //most rented movie.
       List<String> list =  movies.stream().sorted(Comparator.comparingInt(Movie::getTimesRented)).map(Movie::getName).collect(Collectors.toList());

       //average price
        movies.stream().collect(Collectors.groupingBy(Movie::getName,Collectors.averagingDouble(Movie::getTimesRented)));
    }






}