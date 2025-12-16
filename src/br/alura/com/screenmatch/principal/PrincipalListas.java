package br.alura.com.screenmatch.principal;

import br.alura.com.screenmatch.models.Movies;
import br.alura.com.screenmatch.models.Serie;
import br.alura.com.screenmatch.models.Title;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalListas {
    public static void main(String[] args) {
        Movies myMovies = new Movies("O Poderoso Chefão", 1980);
        myMovies.setReview(9);
        var myMovies2 = new Movies("Crepusculo", 2010);
        myMovies2.setReview(3);
        Movies myMovies1 = new Movies("Avatar", 1980);
        myMovies1.setReview(7);
        Serie serie = new Serie("Lost", 2013);

        ArrayList<Title> titlesArrayList = new ArrayList<>();
        titlesArrayList.add(myMovies);
        titlesArrayList.add(myMovies1);
        titlesArrayList.add(myMovies2);
        titlesArrayList.add(serie);
        for (Title item : titlesArrayList) {
            System.out.println(item);
            if (item instanceof Movies movies && movies.getRank() > 2) {
                System.out.println("Classificação: " + movies.getRank());
            }
        }

        System.out.println("Lista de filmes ordenados por nome:");
        Collections.sort(titlesArrayList);
        System.out.println(titlesArrayList);
        System.out.println("Lista de filmes ordenados por ano:");
        titlesArrayList.sort(Comparator.comparing(Title::getReleaseYear));
        System.out.println(titlesArrayList);
    }
}
