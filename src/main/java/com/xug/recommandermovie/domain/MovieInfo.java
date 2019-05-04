package com.xug.recommandermovie.domain;

/**
 * @author hadoop
 * @description:
 * @date 19-4-7
 */
public class MovieInfo {

    private String title;

    private String genres;

    private Double score;

    public MovieInfo() {
    }

    public MovieInfo(String title, String genres, Double score) {
        this.title = title;
        this.genres = genres;
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
