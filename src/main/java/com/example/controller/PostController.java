package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Post;
import com.example.model.User;
import com.example.repository.PostRepository;
import com.example.repository.UserRepository;

@Controller
@RequestMapping("/post")
public class PostController 
{
	@Autowired
	UserRepository repo;
	
	 @Autowired
     PostRepository postrepo;
	
	
	@RequestMapping("/add")
   public String m1(ModelMap map)
      {
		
			map.addAttribute("post", new Post());
		    return "addpost";
		}
		
  
	@PostMapping("/add")
	public String m2(@Valid @ModelAttribute("post") Post post ,BindingResult br)
	{
		Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principle instanceof UserDetails)
		{
			UserDetails user =((UserDetails)principle);
			User u=repo.findByUsername(user.getUsername());
	        
			    post.setUser(u);
		
				postrepo.save(post);
				return "redirect:/";
		}
		else
		{
			return "addpost";
		}
		
	}
	
	@RequestMapping("/")
	public String m3(ModelMap map)
	{
		Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principle instanceof UserDetails)
		{
			UserDetails user =((UserDetails)principle);
			User u=repo.findByUsername(user.getUsername());
	        
		 map.addAttribute("psts" ,u.getPosts());
		 
		  return "post";
		}
		else
		{
			return "redirect:/";
		}
		
	}
	
}
