package com.xug.recommandermovie.repository;

import com.xug.recommandermovie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

/**
 * @author hadoop
 * @description:
 * @date 19-4-7
 */
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    /**
     * 这样写查询效率很低，我需要换一种方式才行，nativeQuery = true是什么意思？
     * @param userId
     * @return
     */
    @Query(nativeQuery = true,value = "select m.title,m.genres,s.score from score s,movie m where s.movieId=m.id and s.userId=?1 order by s.score desc")
    List<Map<String,Object>> getMovieByUserId(@Param("userId") Integer userId);
}
