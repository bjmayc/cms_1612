package com.bawei.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bawei.cms.dao.ChannelDao;
import com.bawei.cms.domain.Article;
import com.bawei.cms.domain.Category;
import com.bawei.cms.domain.Channel;
import com.bawei.cms.util.PageModel;

@Service
@Transactional
public class ChannelServiceImpl implements ChannelService {
	@Autowired
	private ChannelDao dao; 
	
	@Override
	public List<Channel> findAll() {
		List<Channel> list  = dao.findAll();
		return list;
	}
	
	@Override
	public List<Article> findArticle(PageModel pm,Integer channel_id,Integer category_id,String like) {
		List<Article>  list = dao.findArticlesByChannelAndCategory(channel_id, category_id, like,pm.getPageRecord(),pm.getPageSize());
		return list;
	}


	@Override
	public int count(Integer channel_id, Integer category_id,String like) {
		return dao.count(channel_id, category_id,like);
	}


	@Override
	public List<Category> findCate(Integer channel_id) {
		List<Category> list= dao.findCate(channel_id);
		return list;
	}

	@Override
	public List<Article> findHot() {
		return dao.findHot();
	}


	@Override
	public void save(Article a) {
		dao.addArticle(a);
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
	}
}
