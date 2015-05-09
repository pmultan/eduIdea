package sk.revolone.eduidea.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sk.revolone.eduidea.data.dao.CategoryService;
import sk.revolone.eduidea.data.dao.IdeaService;
import sk.revolone.eduidea.data.entity.Category;
import sk.revolone.eduidea.viewmodel.NewsViewModel;
import sk.revolone.eduidea.viewmodel.ideas.CategoryViewViewModel;

@Controller
public class IdeaController extends BaseController{
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	
	@Autowired
	private IdeaService ideaService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/show-category", method = RequestMethod.GET)
	public ModelAndView home(@RequestParam("id") Integer id, Model model) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ideas/categoryView");

		CategoryViewViewModel newsViewModel = new CategoryViewViewModel();
		Category selectedCategory = new Category(id);
		newsViewModel.setSubCategories(categoryService.findByParentCategory(selectedCategory));
		
		mav.addObject("model", newsViewModel);

		return (mav);
	}
}
