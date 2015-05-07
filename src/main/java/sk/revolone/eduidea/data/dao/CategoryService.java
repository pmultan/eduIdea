package sk.revolone.eduidea.data.dao;

import java.util.List;

import sk.revolone.eduidea.data.entity.Category;
import sk.revolone.eduidea.exception.EntityNotFound;

public interface CategoryService {
	public Category create(Category category);

	public Category delete(int id) throws EntityNotFound;

	public List<Category> findAll();

	public Category update(Category category) throws EntityNotFound;

	public Category findById(int id);

	public List<Category> findAllOrderByNameAsc();

	public List<Category> findRootCategories();
}
