package com;

import org.springframework.stereotype.Controller;
import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Register;
import com.service.RegisterService;

@Controller

public class LoginController {
	
	@Autowired
	RegisterService rservice;

	// ---------------------------------------------------------------
	// start-login

	@RequestMapping(value = "/login")
	public String doLogin() {
		return "login";
	}
	
	/*@RequestMapping(value = "/lgscs")
	public String doLogoutSuccess() {
		return "logoutseccess";
	}

	
	 * @RequestMapping(value = "/processLogin")
	 * 
	 * //@RequestMapping(value = { "/processLogin", "/admin*", "/admin",
	 * "/admin/**" }) public String mylogin(@RequestParam(value = "error",
	 * required = false) String error,
	 * 
	 * @RequestParam(value = "logout", required = false) String logout, Model
	 * model) { String ret = ""; Authentication auth =
	 * SecurityContextHolder.getContext().getAuthentication();
	 * 
	 * System.out.println("in admin login" + error); if (error != null) { ret =
	 * "error"; System.out.println("errrr"); model.addAttribute("err",
	 * "Invalid username and password!"); } else if (error == null) {
	 * System.out.println("succ"); ret = "/admin/addProduct";
	 * model.addAttribute("err", "Success!"); }
	 * 
	 * if (logout != null) { model.addAttribute("msg",
	 * "You have been logged out successfully."); } return ret; }
	 

	@RequestMapping(value = "/welcome2", method = RequestMethod.GET)
	public ModelAndView printWelcome(ModelMap model, Principal principal) throws SQLException {

		// ModelAndView mav = new ModelAndView();
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String n = auth.getName();
			String r = auth.getAuthorities().toString();

			System.out.println("the value of username is " + n);
			System.out.println("the value of role is  " + r);
			if (r.equals("[ROLE_ADMIN]"))
				return new ModelAndView("/admin/index", "message", n);
			// return "/admin/index";
			else if (r.equals("[ROLE_USER]"))
				// return "/user/index";
				return new ModelAndView("/user/index", "message", n);
			else
				return new ModelAndView("/admin/index", "message", n);
			// return "index";
		} finally {

		}
	}*/

	
	@RequestMapping(value="/welcome")
	public ModelAndView doProcessLogin(Model model, @RequestParam(required = false) String authfailed, String logout,
			String denied, HttpServletRequest request) throws SQLException  
	{
		ModelAndView mav=null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("in Login controller");
		System.out.println("authfailed="+authfailed);
		System.out.println("logout="+logout);
		System.out.println("denied="+denied);
		System.out.println("the value of username is " + auth.getName());
		System.out.println("the value of role is  " + auth.getPrincipal());
		String message = "";
		try 
		{
		if (authfailed != null) {
			message = "Invalid username or password. Please try again !!!";
			// message="in Login";
			mav = new ModelAndView("/msg", "message", message);
		} else if (logout != null) {
			message = "You have been logged out successfully.";
			mav =  new ModelAndView("/msg", "message", message);
		} else if (denied != null) {
			message = "Access denied for this user !";
			mav =  new ModelAndView("/msg", "message", message);
		}
		else if (authfailed == null) 
		{
				
				String n = auth.getName();
				String r = auth.getAuthorities().toString();
				List<Register> rlist = rservice.getRegisterId(n);
				Register r1=rlist.get(0);
				
				System.out.println("In LoginController regid="+r1.getId());
				System.out.println("the value of username is " + n);
				System.out.println("the value of role is  " + r);
				
				if (r.equals("[ROLE_ADMIN]"))
				{
					mav =  new ModelAndView("admin/index", "message", n);
					request.getSession().setAttribute("sess_registerid", r1.getId());
				}
				// return "/admin/index";
				else if (r.equals("[ROLE_USER]"))
				{
					// return "/user/index";
					mav =  new ModelAndView("user/index", "message", n);
					request.getSession().setAttribute("sess_registerid", r1.getId());
				}
				//else
				//	return new ModelAndView("/admin/index", "message", n);
				//// return "index";
		} 
			
		}
		finally { }
		return mav;
	}

	/*@RequestMapping("403page")
	public String ge403denied() {
		return "redirect:login?denied";
	}

	@RequestMapping(value = "/enter", method = RequestMethod.GET)
	public String enterPage(ModelMap model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("message", "Spring Security Basic Form Example");
		return "enter";
	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			System.out.println(auth.getName());
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "/index";
		// You can redirect wherever you want, but generally
		// it's a good practice to show login screen again​
	}
*/
	// --------------------------------------------------------------- end-login

}
