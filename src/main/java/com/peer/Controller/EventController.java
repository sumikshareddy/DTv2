package com.peer.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.peer.Service.IEventService;
import com.peer.model.Event;
@Controller
public class EventController {
	@Autowired
	IEventService iEventService;
	
	
	@RequestMapping(value = { "event" })
	public ModelAndView addCategory(@Valid @ModelAttribute("peers")  Event e,BindingResult result) {
		System.out.println("add Event");
		String jsonData="";
		ObjectMapper mapper=new ObjectMapper();
		try {
			jsonData=mapper.writeValueAsString(iEventService.viewEvent());
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

		
		return new ModelAndView("event", "command", new Event()).addObject("events", jsonData);
		}	

	/*to store the product*/
	@RequestMapping(value={"storeevent"})
	 public ModelAndView store(HttpServletRequest request,@ModelAttribute("peers") Event e,BindingResult result)
	 {
		 System.out.println("store");
		 iEventService.addevent(e);
		 //String name=Util.removeComma(c.getCname());
			//c.setCname(name);
			ModelAndView mv=new ModelAndView("event");
			if(result.hasErrors())
			{
				mv=new ModelAndView("event", "command", new Event());/*.addObject("addsupplier", iSupplierService.viewAllSupplier());*/
						mv.addObject("errors", result.getAllErrors());
						for(ObjectError s1:result.getAllErrors())
						{
							System.out.println(s1);
						}
			}
			return new ModelAndView("event", "command", new Event()).addObject("events", iEventService.viewEvent()).addObject("stat","Add Event");
		}
	@RequestMapping(value = { "/Event/storeevent" })
	public String updateProduct(HttpServletRequest request, @ModelAttribute("peers") Event e,BindingResult result) 
	{
		System.out.println("Store Event");
		Integer eid = 0;
		//Object teid;
		e.setEid(eid);
		return "redirect:/event";
		//return new ModelAndView("event", "command", new Product()).addObject("event", iProductService.viewAllProducts());
	}

	@RequestMapping(value = { "Event/delete" })
	public String delete(HttpServletRequest request) 
	{
		String eid = request.getParameter("e");
		iEventService.deleteevent(Integer.parseInt(eid));
		System.out.println("Delete eventimpl");
		return "redirect:/event";
		//return new ModelAndView("event", "command", new Product()).addObject("products",iProductService.viewAllProducts());
	}

/*	@RequestMapping(value=  {"Viewevent"})
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
		}*/
		//return new ModelAndView("Viewevent","command",new Event()).addObject("events", jsonData);
	

	
	/*@RequestMapping(value = { "event" })
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

*/}
