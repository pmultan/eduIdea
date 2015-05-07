package sk.revolone.eduidea.data.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import sk.revolone.eduidea.data.entity.Category;
import sk.revolone.eduidea.data.repository.CategoryRepository;
import sk.revolone.eduidea.exception.EntityNotFound;
import sk.revolone.eduidea.utils.CustomSorts;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Resource
	CategoryRepository categoryRepository;

	@Transactional
	@Override
	public Category create(Category category) {
		Category createdCategory = category;
		return categoryRepository.save(createdCategory);
	}

	@Transactional
	@Override
	public Category delete(int id) throws EntityNotFound {
		Category deletedCategory = categoryRepository.findOne(id);
		if (deletedCategory == null)
			throw new EntityNotFound(
					"Category that you are trying to remove was not found in DB.");
		categoryRepository.delete(deletedCategory);
		return deletedCategory;
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Transactional
	@Override
	public Category update(Category category) throws EntityNotFound {
		Category updatedCategory = categoryRepository.findOne(category.getId());
		if (updatedCategory == null) {
			throw new EntityNotFound(
					"Category that you are trying to update was not found in DB.");
		}

		updatedCategory.setName(category.getName());
		updatedCategory.setParentCategory(category.getParentCategory());

		return updatedCategory;
	}

	@Override
	public Category findById(int id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public List<Category> findAllOrderByNameAsc() {
		return categoryRepository.findAll(CustomSorts.sortByNameAsc());
	}

	@Override
	public List<Category> findRootCategories() {
		return categoryRepository.findByParentCategory(null);
	}

}
