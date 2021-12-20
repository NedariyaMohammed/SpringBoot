package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.User;
import com.example.repository.UserRepository;

 
@Controller
@RequestMapping("/user")
public class UserController 
{
	@Autowired
    UserRepository repo;
	
	//Displaying data
	@RequestMapping(value = "/")
		public String m1(ModelMap map)
			  {
				 map.addAttribute("usrs" ,repo.findAll());
				  return "users";
			  }
		
	//creates empty user data object and send it to the next page
	 @GetMapping(value = "/add")
		  public String m2(ModelMap map)
		  {
			  map.addAttribute("user",new User());
			  return "adduser";
		  }
		
	//Adding user data and displaying on next page
	 @PostMapping(value = "/add")
			  public String m3(@Valid @ModelAttribute("user") User user ,BindingResult br)
	 {
			if(!br.hasErrors())
			{
				user.setAuthority("user");
				user.setEnabled(true);
				user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
				repo.save(user);
				return "redirect:/user/";
			}

			return "adduser";
		}
	 
	 //Delete Method
	@GetMapping(value = "/delete/{userid}")
	public String m4(@PathVariable("userid") int userid)
	{
		User u=new User();
		u.setUserid(userid);
		repo.delete(u);
		
	 return "redirect:/user/";
	}
	
	//Edit Method
	@GetMapping(value = "/edit/{userid}")
	public String m5(@PathVariable("userid") int userid , ModelMap map)
	{
		
		User user=repo.findByUserid(userid);
		map.addAttribute("u" ,user);
	     return "adduser";
	}
	
	//Update Method
	 @PostMapping(value = "/update")
	  public String m6(@Valid @ModelAttribute("user") User user ,BindingResult br)
	  {
		 if(!br.hasErrors())
		 {
		  repo.save(user);
		  return "redirect:/user/";
		 }
		 return "adduser";
	  }
	 
	 @GetMapping("/login")
		public String m6()
		{
			return "login";
		}
		
		@GetMapping("/login-error")
		@ResponseBody
		public String m7()
		{
			return "<script>"
					+ "alert('Username or password is incorrect');"
					+ "window.location='/user/login';"
					+ "</script>";
		}
}
