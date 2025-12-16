package br.alura.com.screenmatch.principal;

import br.alura.com.screenmatch.calculator.Calculator;
import br.alura.com.screenmatch.calculator.RecomendationFilter;
import br.alura.com.screenmatch.models.Episode;
import br.alura.com.screenmatch.models.Movies;
import br.alura.com.screenmatch.models.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main (String[] args){
        Movies myMovies = new Movies("O Poderoso Chefão", 1980);
        myMovies.setDurationInMinutes(180);
        myMovies.setIncludedInPlan(true);

        myMovies.setReview(8.5);
        myMovies.setReview(5.4);
        myMovies.setReview(9.1);
        myMovies.details();
        System.out.printf("""
          Média: %.2f | Total de notas: %d.%n""",
                          myMovies.mediaReviews(),
                          myMovies.getTotalReviews());

        Serie serie = new Serie("Lost", 2013);
        serie.setEpisodesPerSeason(10);
        serie.setActive(true);
        serie.setSeasons(6);
        serie.setMinutesPerEpisode(22);

        Movies myMovies1 = new Movies("Avatar", 1980);
        myMovies1.setDurationInMinutes(150);
        myMovies1.setIncludedInPlan(true);


        Calculator calculator = new Calculator();
        calculator.included(myMovies);
        calculator.included(myMovies1);
        calculator.included(serie);
        System.out.println(calculator.getTotalTime());

        RecomendationFilter filter = new RecomendationFilter();
        filter.filter(myMovies);
        filter.filter(myMovies1);

        Episode episode = new Episode();
        episode.setNumber(1);
        episode.setSerie(serie);
        episode.setTotalViews(300);
        filter.filter(episode);

        var myMovies2 = new Movies("Crepusculo", 2010);
        myMovies2.setDurationInMinutes(200);

        ArrayList<Movies> moviesArrayList = new ArrayList<>();
        moviesArrayList.add(myMovies);
        moviesArrayList.add(myMovies1);
        moviesArrayList.add(myMovies2);
        System.out.println("O primeiro filme é: " + moviesArrayList.get(0).getName());
        System.out.println("Tamanho da lista: " + moviesArrayList.size());
        System.out.println(moviesArrayList);


    }

}
