package com;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.model.Register;

@Controller
public class AdminController {

	@Autowired
	ServletContext srv;

	@Autowired
	ProductService pservice;

	@Autowired
	CartService cservice;

	static String deleteRedirectPath = "";

	public AdminController() {
	}

	// ------------------------------------------------------------------------------start-listing
	@ModelAttribute("adpr")
	public Product addProduct() {
		return new Product();
	}

	@RequestMapping(value = "/adlp", method = RequestMethod.GET)
	// public String doSearchBy(@RequestParam(value = "searchby", required =
	// true) String sby,
	public String doSearchBy(@ModelAttribute("searchval") String sval, BindingResult errors) {
		String path = "";

		if (sval.equals("camera")) {
			System.out.println("path=camera");
			path = "adlp1?cat=adcamera";
		} else if (sval.equals("tablet")) {
			System.out.println("path=tablet");
			path = "adlp1?cat=adtablet";
		} else if (sval.equals("ehdd")) {
			System.out.println("path=ehdd");
			path = "adlp1?cat=adehdd";
		} else {
			path = "adlp1?cat=all";
		}
		return "redirect:" + path;
		// System.out.println("return" + path);
		// return new ModelAndView("admin/listProducts");
	}

	@ModelAttribute("adprd")
	public Product addProduct2() {
		return new Product();
	}

	@RequestMapping("/adlp1")
	public ModelAndView doListProducts() {
		ModelAndView model = new ModelAndView("admin/listProducts");
		return model;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
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

	@RequestMapping(value = "/adcamera", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String showcam(Model model) {
		model.addAttribute("Product", new Product());
		model.addAttribute("camlist", pservice.getByCategory("camera"));
		String json = new Gson().toJson(pservice.getByCategory("camera"));
		deleteRedirectPath = "admin/listProducts?cat=camera";
		if (json == "")
			return "No Record Found";
		else
			return json;
	}

	@RequestMapping(value = "/adtablet", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String showtab(Model model) {
		model.addAttribute("Product", new Product());
		model.addAttribute("tablist", pservice.getByCategory("tablet"));
		String json = new Gson().toJson(pservice.getByCategory("tablet"));
		deleteRedirectPath = "admin/listProducts?cat=tablet";
		if (json == "")
			return "No Record Found";
		else
			return json;
	}

	@RequestMapping(value = "/adehdd", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String showehdd(Model model) {
		model.addAttribute("Product", new Product());
		model.addAttribute("ehdlist", pservice.getByCategory("ehdd"));
		String json = new Gson().toJson(pservice.getByCategory("ehdd"));
		deleteRedirectPath = "admin/listProducts?cat=ehdd";
		if (json == "")
			return "No Record Found";
		else
			return json;
	}

	// ------------------------------------------------------------------------------end-listing

}
