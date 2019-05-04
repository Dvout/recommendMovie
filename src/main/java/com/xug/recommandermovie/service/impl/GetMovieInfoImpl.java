package com.xug.recommandermovie.service.impl;

import com.xug.recommandermovie.domain.Movie;
import com.xug.recommandermovie.domain.MovieInfo;
import com.xug.recommandermovie.repository.MovieRepository;
import com.xug.recommandermovie.service.GetMovieInfo;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author hadoop
 * @description:
 * @date 19-4-7
 */
@Service
public class GetMovieInfoImpl implements GetMovieInfo {

    @Autowired
    private MovieRepository movieRepository;

    /**
     * 根据推荐的itemId,即电影id，得到电影的详细信息
     * @param recommendations
     * @return
     */
    @Override
    public List<MovieInfo> getMovieByMovieId(List<RecommendedItem> recommendations) {
        List<MovieInfo> movieInfos = new ArrayList<>();
        for(int i =0;i<recommendations.size();i++){
            Optional<Movie> movie = movieRepository.findById((int) recommendations.get(i).getItemID());
            movieInfos.add(new MovieInfo(movie.get().getTitle(),movie.get().getGenres(),(double)recommendations.get(i).getValue()));
        }
        return movieInfos;
    }

    /**
     * 根据用户id和电影得分表，连接查询，得到用户对电影的评分表
     * @param userId
     * @return
     */
    @Override
    public List<Map<String,Object>> getMovieByUserId(int userId) {
        return movieRepository.getMovieByUserId(userId);
    }
}
