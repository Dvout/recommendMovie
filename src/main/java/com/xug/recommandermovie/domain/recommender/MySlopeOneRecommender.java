package com.xug.recommandermovie.domain.recommender;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.slopeone.SlopeOneRecommender;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.List;

public class MySlopeOneRecommender {
	public List<RecommendedItem> mySlopeOneRecommender(long userID,int size){
		List<RecommendedItem> recommendations = null;
		try {
			/*Configuration conf = new Configuration();
			FileSystem fs = FileSystem.get(new URI("hdfs://localhost:9000"), conf);
			Path file = new Path("/movieData/movie_preferences.txt");
			FSDataInputStream getIt = fs.open(file);*/
			DataModel model = new FileDataModel(new File("/home/hadoop/ml-1m/movie_preferences.txt"));//构造数据模型
		/*	File file = (File) getIt;

			DataModel model = new FileDataModel(d);//构造数据模型*/
			Recommender recommender = new CachingRecommender(new SlopeOneRecommender(model));//构造推荐引擎
			recommendations = recommender.recommend(userID, size);//得到推荐结果
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return recommendations;
	}

}
