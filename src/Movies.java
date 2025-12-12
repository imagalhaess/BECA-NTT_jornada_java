import java.util.Scanner;

public class Movies {
    String name;
    int releaseYear;
    boolean includedInPlan;
    double sumOfReviews;
    int durationInMinutes;
    int totalReviews;


    void details(){
        System.out.println("O nome do filme é: " + name);
        System.out.println("Foi lançado no ano " + releaseYear);
        System.out.println("Tem duração de " + durationInMinutes + " minutos.");
        System.out.println("Nota de avaliação: " + sumOfReviews);
    }

    void setReview(double grade){
        sumOfReviews += grade;
        totalReviews++;
    }

    double mediaReviews(){
        return sumOfReviews / totalReviews;
    }
    }

