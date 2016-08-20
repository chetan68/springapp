package com;

import java.security.Principal;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
//import javax.websocket.Session;

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
public class UserController {
	@Autowired
	ServletContext srv;

	@Autowired
	ProductService pservice;

	@Autowired
	CartService cservice;

	static String deleteRedirectPath = "";

	// -----------------------------------------------------------------start_addcart

	@RequestMapping(value = "/addtocart", method = RequestMethod.GET)
	public ModelAndView add2cart(@RequestParam("id") int id) {
		Product prod = pservice.getProductById(id);
		System.out.println(prod.getId());
		System.out.println(prod.getPrdName());
		System.out.println(prod.getImgPath());
		return new ModelAndView("user/add2Cart", "cartrow", prod);
	}

	@ModelAttribute("cmd_save2Cart")
	public Cart constructCart() {
		return new Cart();
	}

	@RequestMapping(value = "/save2Cart", method = RequestMethod.POST)
	public String saveCart(@Valid @ModelAttribute("cmd_save2Cart") Cart ct, BindingResult result, HttpServletRequest request)
	//public String saveCart(@Valid @ModelAttribute("cmd_save2Cart") Cart ct, BindingResult result)
	{
		if (result.hasErrors()) {
			for (ObjectError lst : result.getAllErrors()) {
				System.out.println(lst.toString());
			}
			return "redirect:add2Cart";
		} else {
			float cartamount=(ct.getPrice()*ct.getQuantity()) - ((ct.getPrice()*ct.getQuantity())*ct.getDiscount()/(float)100.0); 
			ct.setCartAmount(cartamount);
			ct.setCartStatus("pending");
			System.out.println("usercontroller..."+request.getSession().getAttribute("sess_registerid"));
			ct.setRegisterId((int)request.getSession().getAttribute("sess_registerid"));
			System.out.println(ct.getProductId());
			System.out.println(ct.getPrdName());
			System.out.println(ct.getPrice());
			System.out.println(ct.getDiscount());
			System.out.println(ct.getWarranty());
			System.out.println(ct.getQuantity());
			System.out.println(ct.getCartAmount());
			System.out.println(ct.getCartStatus());
			System.out.println(ct.getRegisterId());
			Cart c=new Cart();
			c.setCartAmount(ct.getCartAmount());
			c.setCartStatus(ct.getCartStatus());
			c.setRegisterId(ct.getRegisterId());
			c.setProductId(ct.getProductId());
			c.setPrdName(ct.getPrdName());
			c.setPrice(ct.getPrice());
			c.setDiscount(ct.getDiscount());
			c.setWarranty(ct.getWarranty());
			c.setQuantity(ct.getQuantity());
			c.setImgPath(ct.getImgPath());
			
			cservice.insertRow(c);
			return "redirect:ucartlist?rid=" + c.getRegisterId();
			//return "abc";
		}
	}

	@RequestMapping("/ucartlist")
	public ModelAndView doCartList(@ModelAttribute("rid") int rid, BindingResult errors) 
	{
		List<Cart> cartList = cservice.getCartList(rid);
		return new ModelAndView("user/listCart", "cartrow", cartList);
	}
	
	
	@RequestMapping(value = "/payment", method = RequestMethod.GET) // edit link clicked 
	public ModelAndView makePayment(@RequestParam("cartid") int cartid) {
		Cart cart = cservice.getCartById(cartid);
		return new ModelAndView("makePayment", "cartpayrow", cart);
	}

	// -----------------------------------------------------------------end-addcart

	@RequestMapping(value = "/uview", method = RequestMethod.GET, produces = "application/json")
	public ModelAndView viewProduct(@RequestParam("id") int id) {
		Product prod = pservice.getProductById(id);
		System.out.println(prod.getId());
		System.out.println(prod.getPrdName());
		System.out.println(prod.getImgPath());
		return new ModelAndView("user/viewProduct", "viewrow", prod);
	}

	// ------------------------------------------------------------------------------------start-listing
	@RequestMapping(value = "/utablet", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String show(Model model) {
		model.addAttribute("Product", new Product());
		model.addAttribute("tablist", pservice.getByCategory("tablet"));
		String json = new Gson().toJson(pservice.getByCategory("tablet"));
		deleteRedirectPath = "user/listProducts?cat=utablet";
		if (json == "")
			return "No Record Found";
		else
			return json;
	}

	@RequestMapping(value = "/ucamera", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String showcam(Model model) {
		model.addAttribute("Product", new Product());
		model.addAttribute("camlist", pservice.getByCategory("camera"));
		String json = new Gson().toJson(pservice.getByCategory("camera"));
		System.out.println("user/listProducts/ucamera");
		deleteRedirectPath = "user/listProducts?cat=ucamera";
		if (json == "")
			return "No Record Found";
		else
			return json;
	}

	@RequestMapping(value = "/uehdd", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String showehdd(Model model) {
		model.addAttribute("Product", new Product());
		model.addAttribute("ehdlist", pservice.getByCategory("ehdd"));
		String json = new Gson().toJson(pservice.getByCategory("ehdd"));
		deleteRedirectPath = "user/listProducts?cat=uehdd";
		if (json == "")
			return "No Record Found";
		else
			return json;
	}

	@RequestMapping(value = "/uall", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String showall(Model model) {
		model.addAttribute("Product", new Product());
		model.addAttribute("listall", pservice.getList());
		String json = new Gson().toJson(pservice.getList());
		deleteRedirectPath = "user/listProducts";
		System.out.println("all");
		if (json == "")
			return "No Record Found";
		else
			return json;
	}

	@RequestMapping("/user/listProducts")
	public ModelAndView showProducts() {
		ModelAndView model = new ModelAndView("user/listProducts");
		return model;
	}
	// ------------------------------------------------------------------------------------end-listing

	@RequestMapping(value = "/ulp", method = RequestMethod.GET)
	// public String doSearchBy(@RequestParam(value = "searchby", required =
	// true) String sby,
	public String doSearchBy(@ModelAttribute("searchval") String sval, BindingResult errors) {
		String path = "";

		if (sval.equals("camera")) {
			System.out.println("path=camera");
			path = "ulp1?cat=ucamera";
		} else if (sval.equals("tablet")) {
			System.out.println("path=tablet");
			path = "ulp1?cat=utablet";
		} else if (sval.equals("ehdd")) {
			System.out.println("path=ehdd");
			path = "ulp1?cat=uehdd";
		} else {
			path = "ulp1?cat=uall";
		}
		return "redirect:" + path;
		// System.out.println("return" + path);
		// return new ModelAndView("admin/listProducts");
	}

	@RequestMapping("/ulp1")
	public ModelAndView doListProducts() {
		ModelAndView model = new ModelAndView("user/listProducts");
		return model;
	}
}
