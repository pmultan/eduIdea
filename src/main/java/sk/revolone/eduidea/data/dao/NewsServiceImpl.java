package sk.revolone.eduidea.data.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sk.revolone.eduidea.data.entity.News;
import sk.revolone.eduidea.data.repository.NewsRepository;
import sk.revolone.eduidea.exception.NewsNotFound;

@Service
public class NewsServiceImpl implements NewsService {

	@Resource
	private NewsRepository newsRepository;

	@Override
	@Transactional
	public News create(News news) {
		News createdNews = news;
		return newsRepository.save(createdNews);
	}

	@Override
	@Transactional(rollbackFor = NewsNotFound.class)
	public News delete(int id) throws NewsNotFound {
		News deletedNews = newsRepository.findOne(id);
		if (deletedNews == null) 
			throw new NewsNotFound("News entry that you are trying to remove was not found in DB.");
		newsRepository.delete(deletedNews);
		return deletedNews;
	}

	@Override
	public List<News> findAll() {
		return newsRepository.findAll();
	}

	@Override
	@Transactional
	public News update(News news) throws NewsNotFound {
		News updatedNews = newsRepository.findOne(news.getId());
		if (updatedNews == null) 
			throw new NewsNotFound("News entry that you are trying to update was not found in DB.");
		
		updatedNews.setText(news.getText());
		updatedNews.setTitle(updatedNews.getTitle());
		
		return updatedNews;
	}

	@Override
	public News findById(int id) {
		return newsRepository.findOne(id);
	}

}
