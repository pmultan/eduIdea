package sk.revolone.eduidea.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sk.revolone.eduidea.data.dao.NewsService;
import sk.revolone.eduidea.exception.NewsNotFound;
import sk.revolone.eduidea.viewmodel.EditNewsListViewModel;

@Controller
public class NewsController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private NewsService newsService;

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "admin/edit-news-list", method = RequestMethod.GET)
	public ModelAndView editNewsList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("news/editNewsList");

		EditNewsListViewModel model = new EditNewsListViewModel();
		model.setNewsList(newsService.findAll());

		mav.addObject("model", model);
		return mav;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "admin/edit-news", method = RequestMethod.GET)
	public ModelAndView editNews() {
		return wipView("Edit news");
	}

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "admin/remove-news", method = RequestMethod.GET)
	public ModelAndView removeNews(@RequestParam("id") int id) {
		try {
			newsService.delete(id);
		} catch (NewsNotFound e) {
			return errorView("Requested news were not found", e);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("news/editNewsList :: newsGrid");

		EditNewsListViewModel model = new EditNewsListViewModel();
		model.setNewsList(newsService.findAll());
		
		mav.addObject("model", model);
		return mav;
	}

	/*
	 * @PreAuthorize("hasRole('ADMIN')")
	 * 
	 * @RequestMapping(value = "admin/remove-news", method = RequestMethod.POST)
	 * public ModelAndView removeNews(@RequestParam("id") int id) { try {
	 * newsService.delete(id); } catch (NewsNotFound e) { return
	 * errorView("Requested news were not found", e); } return
	 * this.editNewsList(); }
	 */
}
