package com.xug.recommandermovie.domain.recommender;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.util.List;

/**
 * @author hadoop
 * @description:
 * @date 19-3-24
 */
public class MyUserBaseRecommender {
    public List<RecommendedItem> myTestRecommender(long userID, int size){
        List<RecommendedItem> recommendations = null;
        try {
            // 基于用户相似度
            DataModel model = new FileDataModel(new File("/home/hadoop/ml-1m/movie_preferences.txt"));//构造数据模型，File-based
            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);//构造内容相似度类
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(3, similarity, model);
            Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
            recommendations = recommender.recommend(userID, size);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return recommendations;
    }

}
