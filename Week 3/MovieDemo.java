class Movie {
    String title;
    String genre;
    double rating;

    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Genre: " + genre);
        System.out.println("Rating: " + rating);
    }
}

public class MovieDemo {
    public static void main(String[] args) {
        Movie m = new Movie();
        m.title = "ATHADU";
        m.genre = "Action Thriller";
        m.rating = 8.8;
        m.displayDetails();
    }
}
