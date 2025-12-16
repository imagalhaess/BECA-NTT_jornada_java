package br.alura.com.screenmatch.calculator;

public class RecomendationFilter {
    public void filter (Ranked ranked){
        if (ranked.getRank() >= 4){
            System.out.println("Está entre os mais vistos!");
        } else if (ranked.getRank() >= 2) {
            System.out.println("Muito bem avaliado no momento");
        } else {
            System.out.println("Coloque na sua lista para assistir depois.");
        }
    }
}
