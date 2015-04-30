package sk.revolone.eduidea.viewmodel;

import sk.revolone.eduidea.data.dao.NewsService;
import sk.revolone.eduidea.data.entity.News;

public class AddEditNewsViewModel extends BaseViewModel {
	
	private News news;

	public AddEditNewsViewModel(Integer id, NewsService service)
	{
		if(id != null)
		{
			this.setNews(service.findById(id));
		}
	}
	
	public AddEditNewsViewModel()
	{
		
	}
	
	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
}
