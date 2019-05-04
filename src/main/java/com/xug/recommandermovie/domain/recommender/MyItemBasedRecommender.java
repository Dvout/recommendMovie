package com.xug.recommandermovie.domain.recommender;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

import java.io.File;
import java.util.List;


public class MyItemBasedRecommender {
	
	public List<RecommendedItem> myItemBasedRecommender(long userID,int size){
		List<RecommendedItem> recommendations = null;
		try {
			// 基于物品相似度
			DataModel model = new FileDataModel(new File("/home/hadoop/ml-1m/movie_preferences.txt"));//构造数据模型，File-based
			ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);//构造内容相似度类
			Recommender recommender =new CachingRecommender( new GenericItemBasedRecommender(model, similarity));//计算内容相似度,并构造推荐引擎
			recommendations = recommender.recommend(userID, size);//得到推荐结果
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return recommendations;
	}

}
