package com;

import java.security.Principal;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.service.CartService;
import com.service.ProductService;
import com.model.Product;
import com.model.Cart;

@Controller
public class HomeController {

	@Autowired
	ServletContext srv;

	@Autowired
	ProductService pservice;

	@Autowired
	CartService cservice;

	static String deleteRedirectPath = "";

	public HomeController() {
	}

	@RequestMapping(value = "/a2c")
	public ModelAndView doA2c() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET, produces = "application/json")
	public ModelAndView viewProduct(@RequestParam("id") int id) {
		Product prod = pservice.getProductById(id);
		System.out.println(prod.getId());
		System.out.println(prod.getPrdName());
		System.out.println(prod.getImgPath());
		return new ModelAndView("viewProduct", "viewrow", prod);
	}

	// ------------------------------------------------------------------------------------start-listing
	@RequestMapping(value = "/tablet", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String show(Model model) {
		model.addAttribute("Product", new Product());
		model.addAttribute("tablist", pservice.getByCategory("tablet"));
		String json = new Gson().toJson(pservice.getByCategory("tablet"));
		deleteRedirectPath = "listProducts?cat=tablet";
		if (json == "")
			return "No Record Found";
		else
			return json;
	}

	@RequestMapping(value = "/camera", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String showcam(Model model) {
		model.addAttribute("Product", new Product());
		model.addAttribute("camlist", pservice.getByCategory("camera"));
		String json = new Gson().toJson(pservice.getByCategory("camera"));
		System.out.println("listProducts/camera");
		deleteRedirectPath = "listProducts?cat=camera";
		if (json == "")
			return "No Record Found";
		else
			return json;
	}

	@RequestMapping(value = "/ehdd", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String showehdd(Model model) {
		model.addAttribute("Product", new Product());
		model.addAttribute("ehdlist", pservice.getByCategory("ehdd"));
		String json = new Gson().toJson(pservice.getByCategory("ehdd"));
		deleteRedirectPath = "listProducts?cat=ehdd";
		if (json == "")
			return "No Record Found";
		else
			return json;
	}

	@RequestMapping(value = "/allp", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String showall(Model model) {
		model.addAttribute("Product", new Product());
		model.addAttribute("listall", pservice.getList());
		String json = new Gson().toJson(pservice.getList());
		// deleteRedirectPath = "admin/listProducts";
		System.out.println("all");
		if (json == "")
			return "No Record Found";
		else
			return json;
	}

	@RequestMapping("/listProducts")
	public ModelAndView showProducts() {
		ModelAndView model = new ModelAndView("listProducts");
		return model;
	}
	// ------------------------------------------------------------------------------------end-listing

	@RequestMapping("/")
	public ModelAndView indexPage() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	@RequestMapping("/index")
	public ModelAndView indexPage2() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	@RequestMapping("/contactUs")
	public ModelAndView contactPage() {
		ModelAndView mv = new ModelAndView("contactUs");
		return mv;
	}

	@RequestMapping("/aboutUs")
	public ModelAndView aboutPage() {
		ModelAndView mv = new ModelAndView("aboutUs");
		return mv;
	}

	/*
	 * @RequestMapping(value = "/edit/{cat}", method = RequestMethod.POST)
	 * public String editProduct(@PathVariable("cat") String cat, Model model) {
	 * model.addAttribute("pr", this.pservice.getByCategory(cat));
	 * model.addAttribute("prlist", this.pservice.getList()); return "pr"; }
	 */
}
