package sk.revolone.eduidea.viewmodel;

public class WipViewModel extends BaseViewModel {
	private String pageTitle;

	public WipViewModel(String title)
	{
		setPageTitle(title);
	}
	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
}
