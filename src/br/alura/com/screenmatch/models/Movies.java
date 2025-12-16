package br.alura.com.screenmatch.models;

import br.alura.com.screenmatch.calculator.Ranked;

public class Movies extends Title implements Ranked {
    private String director;

    public Movies(String name, int releaseYear) {
        super(name, releaseYear);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getRank() {
        return (int) mediaReviews() / 2;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getName() + " (" + this.getReleaseYear() + ") ";
    }
}


