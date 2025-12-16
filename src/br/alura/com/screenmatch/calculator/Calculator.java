package br.alura.com.screenmatch.calculator;

import br.alura.com.screenmatch.models.Movies;
import br.alura.com.screenmatch.models.Serie;
import br.alura.com.screenmatch.models.Title;

public class Calculator {
    private int totalTime;

    public int getTotalTime() {
        return totalTime;
    }

    public void included (Title title){
        this.totalTime += title.getDurationInMinutes();
    }
}
