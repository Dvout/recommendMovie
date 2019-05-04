package com.xug.recommandermovie.service;

import com.xug.recommandermovie.domain.MovieInfo;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author hadoop
 * @description:
 * @date 19-4-7
 */
public interface GetMovieInfo {

    /**
     *  获得推荐给该id用户的电影
     * @param recommendations
     * @return
     */
    List<MovieInfo> getMovieByMovieId(List<RecommendedItem> recommendations);

    /**
     * 获得该id用户的所有电影
     * @param userId
     * @return
     */
    List<Map<String,Object>> getMovieByUserId(int userId);
}
