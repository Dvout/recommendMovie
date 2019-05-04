package com.xug.recommandermovie.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author hadoop
 * @description: 电影详细信息表
 * @date 19-4-7
 */
@Entity
public class Movie {

    @Id
    private int id;

    private String title;

    private String genres;

    public Movie(int id, String title, String genres) {
        this.id = id;
        this.title = title;
        this.genres = genres;
    }

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
