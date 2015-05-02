package sk.revolone.eduidea.data.dao;

import java.util.List;

import sk.revolone.eduidea.data.entity.News;
import sk.revolone.eduidea.exception.NewsNotFound;

public interface NewsService {
	 	public News create(News shop);
	    public News delete(int id) throws NewsNotFound;
	    public List<News> findAll();
	    public News update(News shop) throws NewsNotFound;
	    public News findById(int id);  
	    public List<News> findAllOrderByDateCreatedDesc();
}
