package com.xug.recommandermovie.repository;

import com.xug.recommandermovie.domain.Score;
import org.springframework.data.repository.CrudRepository;

/**
 * @author hadoop
 * @description:
 * @date 19-4-7
 */
public interface ScoreRepository extends CrudRepository<Score,Integer> {
}
