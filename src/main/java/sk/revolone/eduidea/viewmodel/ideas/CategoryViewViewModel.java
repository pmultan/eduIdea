package sk.revolone.eduidea.viewmodel.ideas;

import java.util.List;

import sk.revolone.eduidea.data.entity.Category;
import sk.revolone.eduidea.viewmodel.BaseViewModel;

public class CategoryViewViewModel extends BaseViewModel {

	private List<Category> subCategories;

	public List<Category> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<Category> subCategories) {
		this.subCategories = subCategories;
	}
	
	
}
