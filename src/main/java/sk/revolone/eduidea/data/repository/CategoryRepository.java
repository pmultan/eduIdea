package sk.revolone.eduidea.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sk.revolone.eduidea.data.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
		List<Category> findByParentCategory(Category category);
}
