package com.xug.recommandermovie.controller;

import com.xug.recommandermovie.domain.Movie;
import com.xug.recommandermovie.domain.MovieInfo;
import com.xug.recommandermovie.domain.recommender.MyItemBasedRecommender;
import com.xug.recommandermovie.domain.recommender.MySlopeOneRecommender;
import com.xug.recommandermovie.domain.recommender.MyUserBaseRecommender;
import com.xug.recommandermovie.repository.MovieRepository;
import com.xug.recommandermovie.service.GetMovieInfo;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author xugui
 * @description:
 * @date 19-4-7
 */
@Controller
@RequestMapping()
public class RecommenderController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GetMovieInfo getMovieInfo;


    @RequestMapping("/")
    public String view(){
        return "index";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping("{id}")
    @ResponseBody
    public String getById(@PathVariable Integer id) {
        Optional<Movie> user = movieRepository.findById(id);
        String aa = new String();
        aa=user.get().getTitle();
        return aa;
    }

    @RequestMapping("recommend")
    @ResponseBody
    public ModelAndView login(@RequestParam String recommendType,@RequestParam Integer userId,@RequestParam Integer size,Model model){
        long startTime=System.currentTimeMillis();
        //用户的所有电影
        List<Map<String,Object>> ownMovieInfo = getMovieInfo.getMovieByUserId(userId);
        //推荐电影的List
        List<RecommendedItem> recommendation = null;
        if(recommendType.equals("userBased")){
            //基于用户,现在算是运行成功了
            MyUserBaseRecommender mubr = new MyUserBaseRecommender();
            //拿到推荐的电影
            recommendation = mubr.myTestRecommender(userId,size);
        }else if(recommendType.equals("itemBased")){
            //基于内容
            MyItemBasedRecommender mibr = new MyItemBasedRecommender();
            //拿到推荐的电影
            recommendation = mibr.myItemBasedRecommender(userId,size);
        }else if(recommendType.equals("slopeOne")){
            //slope one
            MySlopeOneRecommender msor = new MySlopeOneRecommender();
            //拿到推荐的电影
            recommendation = msor.mySlopeOneRecommender(userId,size);
        }

        //拿到推荐的电影的详细信息
        List<MovieInfo> recommendMovieInfo = getMovieInfo.getMovieByMovieId(recommendation);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间："+(endTime-startTime)/1000+"s");
        System.out.println("程序运行时间："+(endTime-startTime)/(1000*60)+"minutes");
        //页面跳转


        model.addAttribute("ownMovieInfo",ownMovieInfo);
        model.addAttribute("recommendMovieInfo",recommendMovieInfo);
        return new ModelAndView("recommendResult", "model", model);
    }
}
