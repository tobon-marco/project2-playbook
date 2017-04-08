package com.revature.kkoders.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.kkoders.beans.UserImpl;

/**
 * Handles signing the user into the application.
 * 
 * @author 
 *
 */
@Controller
@RequestMapping(value="/login")
public class LoginController
{
	@Autowired
	UserImpl emptyUser;
	
	//@Autowired
	//UserService userService;
	
	//PARAMETER NAME IS CALLED someInfo
		//REQUEST.GETPARAM('someInfo')
	@ModelAttribute("someInfo")
	public String addInfoToRequestScope()
	{
		System.out.println("Adding something to the modelmap");
		return "This is the info added";
	}
	
	/**
	 * Handles bringing up the login page.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String getLoginPage(ModelMap modelMap)
	{
		System.out.println(modelMap.get("someInfo"));
		System.out.println("This was a get request");
		modelMap.addAttribute("user", emptyUser); 
		
		//RETURN LOGIN TO TAKE US TO PREFIX: WEB-INF
		//LOGIN
		//SUFFIX: .jsp
		return "login";
	}
	
	/**
	 * Handles login details that were submitted.
	 * 
	 * @param user
	 * @param bindingResult
	 * @param modelMap
	 * @param seesion
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String doLogin(@Valid UserImpl user, BindingResult bindingResult, ModelMap modelMap, HttpSession seesion)
	{
		System.out.println("This was a post request");
		if(bindingResult.hasErrors())
		{
			return "login";
		}
	/*	User authUser = userService.auth(user);
		if (authUser != null)
		{
			System.out.println(user.getUsername());
			modelMap.addAttribute("user", user);
			seesion.setAttribute("alsoUser", user);
			//NEW VIEW
			return "home";
		}
		else
		{
			modelMap.addAttribute("errorMessage", "Username/password incorrect");
			return "login";
		}*/
		return "account"; //the user was logged in.
	}
}
