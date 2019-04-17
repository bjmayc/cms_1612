package com.bawei.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bawei.cms.domain.Article;
import com.bawei.cms.domain.Category;
import com.bawei.cms.domain.Channel;

public interface ChannelDao {
	//查询所有的栏目
	public  List<Channel> findAll();
	//根据 栏目id查询   所有的这个栏目下的种类 
	public   List<Category> findCategorysByChannelId(@Param("channel_id")int channel_id);
	//发布 文章内容 
	public   void   addArticle(@Param("ar")Article ar);
	//查询 我发布的文章内容 
	public   List<Article>     findArticlesByUserId(@Param("user_id")int  user_id);
	//根据栏目id和种类id查询 文章内容
	public   List<Article>  findArticlesByChannelAndCategory(@Param("channel_id")Integer channel_id,@Param("category_id")Integer category_id,@Param("like")String like,@Param("from")int   from,@Param("pageSize")int pageSize);
	//统计  符合  栏目 和种类条件的  文章
	public  int   count(@Param("channel_id")Integer channel_id,@Param("category_id")Integer category_id,@Param("like")String like);
	//根据 栏目id 查询  所有种类
	public List<Category> findCate(@Param("channel_id")Integer channel_id);
	//查询 热门头条文章
	public  List<Article> findHot();
	//删除 id对应得文章
	public void deleteById(@Param("id")int id);
}
