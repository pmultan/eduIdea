package sk.revolone.eduidea.viewmodel;

import java.util.List;

import sk.revolone.eduidea.data.entity.News;

public class EditNewsListViewModel extends BaseViewModel{

	private List<News> newsList;

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
	
	
}
