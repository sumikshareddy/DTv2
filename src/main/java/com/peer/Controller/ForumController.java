package com.peer.Controller;

import java.io.IOException;
import java.util.Date;

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

import com.peer.Service.IForumService;
import com.peer.model.Blog;
import com.peer.model.Event;
import com.peer.model.Forum;
@Controller
public class ForumController {

	
	@Autowired
	IForumService iForumService;
	@RequestMapping(value = { "forum" })
	public ModelAndView addforum(@Valid @ModelAttribute("peers")  Event e,BindingResult result) {
		System.out.println("add forum");
		String jsonData="";
		ObjectMapper mapper=new ObjectMapper();
		try {
			jsonData=mapper.writeValueAsString(iForumService.viewForum());
			System.out.println(jsonData);
		} catch (JsonGenerationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		return new ModelAndView("forum", "command", new Forum()).addObject("forums", jsonData);
		}	

	

	@RequestMapping(value = "store2", method=RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request,@Valid @ModelAttribute("peer") Forum f,BindingResult result) {
		System.out.println("addforum");
		f.setDate(new Date());
		iForumService.addquestion(f);
		ModelAndView mv=new ModelAndView("store1");
		System.out.println("store2");
		if(result.hasErrors()){

			mv=new ModelAndView("forum", "command", new Forum());
					mv.addObject("errors", result.getAllErrors());
					for(ObjectError s:result.getAllErrors()){
						System.out.println(s);
					}
		}
		else{
			iForumService.addquestion(f);
		mv=new ModelAndView("forum", "command", new Event());
		}
		return mv;
	}
	
	@RequestMapping(value = { "forum/delete" })
	public String delete(HttpServletRequest request) 
	{
		String fid = request.getParameter("f");
		iForumService.deletequestion(Integer.parseInt(fid));
		System.out.println("Delete forumcntrl");
		return "redirect:/forum";
		//return new ModelAndView("event", "command", new Product()).addObject("products",iProductService.viewAllProducts());
	}

	/*@RequestMapping(value=  {"viewforum"})
	public ModelAndView Viewforum() {
		System.out.println("viewforum");
		String jsonData="";
		ObjectMapper mapper=new ObjectMapper();
		try {
			jsonData=mapper.writeValueAsString(iForumService.viewForum());
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
		return new ModelAndView("viewforum","command",new Forum()).addObject("forums", jsonData);
	}
*/
}
