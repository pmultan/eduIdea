package sk.revolone.eduidea.viewmodel;

import java.text.DateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import sk.revolone.eduidea.data.dao.NewsService;
import sk.revolone.eduidea.data.entity.News;

public class NewsViewModel extends BaseViewModel{

	private List<News> newsList;
	private String serverTime;
	
	public NewsViewModel()
	{
		
	}
	
	public void fillWithBasicValues(NewsService newsService, Locale locale)
	{
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		this.setServerTime(formattedDate);
		
		this.setNewsList(newsService.findAll());
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public String getServerTime() {
		return serverTime;
	}

	public void setServerTime(String serverTime) {
		this.serverTime = serverTime;
	}
}
