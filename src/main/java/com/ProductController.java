package com;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Product;
import com.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ServletContext srv;

	@Autowired
	ProductService pservice;

	static String deleteRedirectPath = "";

	@RequestMapping(value = "/adview", method = RequestMethod.GET, produces = "application/json")
	public ModelAndView viewProduct(@RequestParam("id") int id) {
		Product prod = pservice.getProductById(id);
		System.out.println(prod.getId());
		System.out.println(prod.getPrdName());
		System.out.println(prod.getImgPath());
		return new ModelAndView("admin/viewProduct", "viewrow", prod);
	}

	/*
	 * @RequestMapping(value = "/addelete", method = RequestMethod.GET) public
	 * String delProduct(@RequestParam("id") int id) { pservice.deleteRow(id);
	 * // return new ModelAndView("index"); System.out.println("redirect:" +
	 * deleteRedirectPath);
	 * 
	 * return "redirect:" + deleteRedirectPath; }
	 */

	// --------------------------------------------------------------------------start_edit-save
	@RequestMapping(value = "/adedit", method = RequestMethod.GET) // edit link
																	// clicked
	public ModelAndView editProduct(@RequestParam("id") int id) {
		Product prod = pservice.getProductById(id);
		return new ModelAndView("admin/editProduct", "editrow", prod);
	}

	@ModelAttribute("cmd_save_editedProduct")
	public Product constructEditedProduct() {
		return new Product();
	}

	@RequestMapping(value = "/saveEditedProduct", method = RequestMethod.POST)
	public String editProduct(@Valid @ModelAttribute("cmd_save_editedProduct") Product product, BindingResult result) {
		if (result.hasErrors()) {
			for (ObjectError lst : result.getAllErrors()) {
				System.out.println(lst.toString());
			}
			return "redirect:admin/editProduct";
		} else {
			System.out.println("Product Name=" + product.getPrdName());
			System.out.println("Price=" + product.getPrice());
			System.out.println("Image Path=" + product.getImgPath());
			if (product.getImgPath() != "") {
				String path = srv.getRealPath("/");
				System.out.println(path);
				System.out.println(srv.getContextPath());
				String res = product.getFilePath(path, srv.getContextPath(), product.getCategory());

				// String path = srv.getRealPath("/");
				// String res = product.getFilePath(path,
				// srv.getContextPath(),product.getCategory());
				// System.out.println(res);
				if (res == "fail")
					return "redirect:admin/editProduct";
				else {
					pservice.updateRow(product);
					deleteRedirectPath = "adlp1?cat=" + product.getCategory().toString();
					return "redirect:adlp1?cat=" + product.getCategory().toString();
				}
			} else {
				product.setImgPath("/mySpringApp/resources\\images\\NoImage.jpg");
				pservice.updateRow(product);
				deleteRedirectPath = "adlp1?cat=" + product.getCategory().toString();
				return "redirect:adlp1?cat=" + product.getCategory().toString();
			}
		}
	}

	// ------------------------------------------------------------------------------end_edit-save
	// ------------------------------------------------------------------------------start_save

	@ModelAttribute("cmdProduct")
	public Product constructProduct() {
		return new Product();
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public ModelAndView Product_Add() {
		Product prd = new Product();
		// ModelAndView obj = new ModelAndView("ProductAdd");
		ModelAndView obj = new ModelAndView("admin/addProduct");
		obj.addObject(prd);
		return obj;
	}

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public String saveProduct(@Valid @ModelAttribute("Product") Product product, BindingResult result)
	// public ModelAndView saveProduct(@ModelAttribute("Product") Product
	// product, BindingResult result)
	{
		System.out.println(product.getId());
		System.out.println(product.getPrdName());
		System.out.println(product.getCategory());
		/*
		 * if (product.getCategory().equals("camera")) {
		 * product.setImgPath("/resources/images/cameras/"); } else if
		 * (product.getCategory().equals("ehdd")) {
		 * product.setImgPath("/resources/images/ehdds/"); } else if
		 * (product.getCategory().equals("tablet")) {
		 * product.setImgPath("/resources/images/tablets/"); } else {
		 * product.setImgPath("/resources/images/others/"); }
		 */

		if (result.hasErrors()) {
			return "redirect:addProduct";
		} else {
			if (product.getImgPath() != "") {
				String path = srv.getRealPath("/");
				System.out.println(path);
				System.out.println(srv.getContextPath());
				String res = product.getFilePath(path, srv.getContextPath(), product.getCategory());
				// System.out.println(res);
				if (res == "fail")
					return "redirect:admin/addProduct";
				else {
					pservice.insertRow(product);
					// return new ModelAndView("addProduct");
					//return "redirect:admin/listProducts?cat=" + product.getCategory().toString();
					return "redirect:adlp?cat=" + product.getCategory().toString();
				}
			} else {
				product.setImgPath("/springapp/resources\\images\\NoImage.jpg");
				pservice.insertRow(product);
				// return new ModelAndView("addProduct");
				return "redirect:adlp?cat=" + product.getCategory().toString();
			}
		}
	}
	// -------------------------------------------------------------------------------------end_save

}
