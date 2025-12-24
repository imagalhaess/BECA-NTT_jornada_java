package br.alura.com.screenmatch.models;

import br.alura.com.screenmatch.exception.ConversionYearAndRuntimeError;

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

    public Title(TitleOmdb myTitleOmdb) throws ConversionYearAndRuntimeError {
        this.name = myTitleOmdb.title();
        if (myTitleOmdb.year().length() >= 4) {
            this.releaseYear = Integer.valueOf(myTitleOmdb.year().substring(0, 4));
        }
        try {
            var runtime = myTitleOmdb.runtime().substring(0, 3);
            StringBuilder intChars = new StringBuilder();
            for (char ch : runtime.toCharArray()) {
                if (Character.isDigit(ch)) {
                    intChars.append(ch);
                }
            } if (intChars.isEmpty()) {
                throw new ConversionYearAndRuntimeError("Não há informações sobre a duração. Usaremos" +
                                                                " um valor padrão de zero.");
            }
            this.durationInMinutes = Integer.parseInt(intChars.toString());
        } catch (ConversionYearAndRuntimeError e){
            System.out.println(e.getMessage());
            this.durationInMinutes = 0;
        }
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

    @Override
    public String toString() {
            return "(name=" + name +
                    ", releaseYear=" + releaseYear +
                    ", duration=" + durationInMinutes + ")";
        }
    }

