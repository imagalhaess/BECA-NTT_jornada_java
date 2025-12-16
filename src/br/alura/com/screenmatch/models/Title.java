package br.alura.com.screenmatch.models;

public class Title implements Comparable <Title>{
    private String name;
    private int releaseYear;
    private boolean includedInPlan;
    private double sumOfReviews;
    private int durationInMinutes;
    private int totalReviews;

    public Title (String name, int releaseYear){
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public boolean isIncludedInPlan() {
        return includedInPlan;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public void setIncludedInPlan(boolean includedInPlan) {
        this.includedInPlan = includedInPlan;
    }

    public void details() {
        System.out.println("Nome: " + name);
        System.out.println("Ano de lançamento: " + releaseYear);
    }

    public void setReview(double grade) {
        sumOfReviews += grade;
        totalReviews++;
    }

    public double mediaReviews() {
        return sumOfReviews / totalReviews;
    }

    @Override
    public int compareTo(Title anotherTitle) {
        return this.getName().compareTo(anotherTitle.getName());
    }
}
