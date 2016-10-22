package com.peer.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.peer.Service.IBlogService;
import com.peer.model.Blog;
import com.peer.model.Chat;
import com.peer.model.Comment;
@Controller
public class BlogController {
	@Autowired
	IBlogService iBlogService;
	
	@RequestMapping(value=  { "addblog"})
	public ModelAndView addblog() {
		System.out.println("addblog");
		return new ModelAndView("addblog","command",new Blog());
	}
	
	@RequestMapping(value=  { "addchat"})
	public ModelAndView addchat() {
		System.out.println("addchat");
		return new ModelAndView("addchat","command",new Chat());
	}
	


	@RequestMapping(value=  {"blog"})
	public ModelAndView blog() {
		System.out.println("blog");
		return new ModelAndView("blog","command",new Blog());
	}
	@RequestMapping(value = "store3", method=RequestMethod.POST)
	public ModelAndView addblog(HttpServletRequest request,@Valid @ModelAttribute("peers") Blog b,BindingResult result) {
		System.out.println("addblog");
		iBlogService.addblog(b);
		System.out.println("blg");
		ModelAndView mv=new ModelAndView("store3");
		System.out.println("store4");
		if(result.hasErrors()){

			mv=new ModelAndView("blog", "command", new Blog());
					mv.addObject("errors", result.getAllErrors());
					for(ObjectError s:result.getAllErrors()){
						System.out.println(s);
					}
		}
		else{
			iBlogService.addblog(b);
		mv=new ModelAndView("blog", "command", new Blog());
		}
		return mv;
		//return new ModelAndView("home","command",new User()).addObject("login", true);
	}
	@RequestMapping(value=  {"viewblog"})
	public ModelAndView viewblog() {
		System.out.println("viewblog");
		String jsonData="";
		ObjectMapper mapper=new ObjectMapper();
		try {
			jsonData=mapper.writeValueAsString(iBlogService.viewBlog());
			System.out.println(jsonData);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("viewblog","command",new Blog()).addObject("blogs", jsonData);
	}

}
