public class Principal {
    public static void main (String[] args){
        Movies myMovies = new Movies();
        myMovies.name = "O Poderoso Chefão";
        myMovies.releaseYear = 1980;
        myMovies.durationInMinutes = 180;


        myMovies.setReview(8.5);
        myMovies.setReview(5.4);
        myMovies.setReview(9.1);
        myMovies.details();
        System.out.println(myMovies.mediaReviews());
    }
}
