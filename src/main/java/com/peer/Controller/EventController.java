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

import com.peer.Service.IEventService;
import com.peer.model.Blog;
import com.peer.model.Event;
@Controller
public class EventController {
	@Autowired
	IEventService iEventService;
	
	@RequestMapping(value = { "event" })
	public ModelAndView event() {
		System.out.println("event");
		return new ModelAndView("event","command",new Event());
		
	}
	@RequestMapping(value = "store1", method=RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request,@Valid @ModelAttribute("peer") Event e,BindingResult result) {
		System.out.println("addevent");
		e.setDate(new Date());
		iEventService.addevent(e);
		ModelAndView mv=new ModelAndView("store1");
		System.out.println("store1");
		if(result.hasErrors()){

			mv=new ModelAndView("event", "command", new Event());
					mv.addObject("errors", result.getAllErrors());
					for(ObjectError s:result.getAllErrors()){
						System.out.println(s);
					}
		}
		else{
			iEventService.addevent(e);
		mv=new ModelAndView("event", "command", new Event());
		}
		return mv;

	}
	@RequestMapping(value=  {"Viewevent"})
	public ModelAndView Viewevent() {
		System.out.println("viewevent");
		String jsonData="";
		ObjectMapper mapper=new ObjectMapper();
		try {
			jsonData=mapper.writeValueAsString(iEventService.viewEvent());
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
		return new ModelAndView("Viewevent","command",new Event()).addObject("events", jsonData);
	}

}
