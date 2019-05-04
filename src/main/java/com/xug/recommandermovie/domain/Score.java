package com.xug.recommandermovie.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author hadoop
 * @description: 电影评分表
 * @date 19-4-7
 */
@Entity
public class Score {
    @Id
    private Long id;

    private Integer userID;
    private Integer movieID;
    private Float score;
    private Integer commentTime;

    public Score(Long id, Integer userID, Integer movieID, Float score, Integer commentTime) {
        this.id = id;
        this.userID = userID;
        this.movieID = movieID;
        this.score = score;
        this.commentTime = commentTime;
    }

    public Score() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getMovieID() {
        return movieID;
    }

    public void setMovieID(Integer movieID) {
        this.movieID = movieID;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Integer getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Integer commentTime) {
        this.commentTime = commentTime;
    }
}
