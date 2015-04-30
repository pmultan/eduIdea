package sk.revolone.eduidea.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sk.revolone.eduidea.data.dao.NewsService;
import sk.revolone.eduidea.exception.NewsNotFound;
import sk.revolone.eduidea.exception.UsernameOrEmailTaken;
import sk.revolone.eduidea.viewmodel.AddEditNewsViewModel;
import sk.revolone.eduidea.viewmodel.EditNewsListViewModel;
import sk.revolone.eduidea.viewmodel.SignUpViewModel;

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
	@RequestMapping(value = "admin/add-edit-news", method = RequestMethod.GET)
	public ModelAndView addEditNews(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("news/addEditNews :: addEditNewsBody");
		AddEditNewsViewModel model = new AddEditNewsViewModel(id, newsService);
		mav.addObject("model", model);
		return mav;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "admin/remove-news", method = RequestMethod.GET)
	public ModelAndView removeNews(@RequestParam("id") int id) {
		try {
			newsService.delete(id);
		} catch (NewsNotFound e) {
			return errorView("Requested news were not found", e);
		}
		
		return renderNewsListBody();
	}

	@RequestMapping(value = "admin/submit-news", method = RequestMethod.POST)
	public ModelAndView submitNews(AddEditNewsViewModel model) {
		ModelAndView mav = new ModelAndView("news/addEditNews");
		mav.addObject("model", model);
		try {
			if(model.getNews().getId() == null)
			{
				newsService.create(model.getNews());
			}
			else
			{
				newsService.update(model.getNews());
			}
		} catch (NewsNotFound e) {
			mav.addObject("message", "taken");
			return errorView("News entry you are trying to edit was not found.", e);
		}

		return renderNewsListBody();
	}
	
	@RequestMapping(value = "admin/add-edit-news-partial", method = RequestMethod.GET)
	public ModelAndView addEditNewsPartial() {
		return renderNewsListBody();
	}
	
	public ModelAndView renderNewsListBody()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("news/editNewsList :: editNewsListBody");

		EditNewsListViewModel model = new EditNewsListViewModel();
		model.setNewsList(newsService.findAll());
		
		mav.addObject("model", model);
		return mav;
	}
}
