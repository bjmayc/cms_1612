package com.bawei.cms.service;

import java.util.List;

import com.bawei.cms.domain.Article;
import com.bawei.cms.domain.Category;
import com.bawei.cms.domain.Channel;
import com.bawei.cms.util.PageModel;

public interface ChannelService {
	//查询所有栏目
	public List<Channel> findAll();
	//根据栏目id查询 内容 
	public   List<Article>   findArticle(PageModel pm,Integer channel_id,Integer category_id,String like);
	//统计  符合  栏目 和种类的  总条数 
	public int count(Integer channel_id, Integer category_id,String like);
	//根据栏目id查询   所有种类
	public List<Category> findCate(Integer channel_id);
	//查询 热门头条文章
	public List<Article> findHot();
	//发布
	public void save(Article a);
	//根据 id删除  文章 
	public void deleteById(int id);
	
}
