package com;

import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Register;
import com.service.RegisterService;
import com.service.UserRolesService;
import com.model.UserRoles;

@Controller
public class RegisterController {

	@Autowired
	RegisterService rservice;
	
	@Autowired
	UserRolesService uroleService;
	
	@Autowired
	private SessionFactory sf;
	
	@ModelAttribute("cmdRegister")
	public Register constructRegister() {
		return new Register();
	}

	@RequestMapping(value = "/addRegister", method = RequestMethod.GET)
	public ModelAndView Register_Add() {
		Register reg = new Register();
		ModelAndView obj = new ModelAndView("register");
		obj.addObject(reg);
		return obj;
	}

	@RequestMapping(value = "/saveRegister", method = RequestMethod.POST)
	public ModelAndView saveRegister(@Valid @ModelAttribute("cmdRegister") Register reg, BindingResult result)
	{
		System.out.println(reg.getId());
		System.out.println(reg.getEmail());
		System.out.println(reg.getPassword());
		System.out.println(reg.getFirstName());
		System.out.println(reg.getLastName());
		reg.setEnabled(true);
		ModelAndView mv;
		if (result.hasErrors()) {
			/*
			List <Register> li= (List<Register>) result.getAllErrors();
			String errs="";
			for(String e : li)
			{
				errs = errs + e.toString() + "\n";
			}
			return  errs;*/
			//return "redirect:addRegister";
			mv=new ModelAndView("msg","message","Unable to register, some error has occured. Please try again.");
		} 
		else 
		{
			if(rservice.insertRow(reg)==1)
			{
				UserRoles ur=new UserRoles();
				ur.setReg(reg);
				ur.setAuthority("ROLE_USER");
				sf.openSession().save(ur);
				
			}
			//return "redirect:index";
			
			mv=new ModelAndView("msg","message","Registration successfull....");
		}
		return mv;
	}
	// -------------------------------------------------------------------------------------end_save

}
