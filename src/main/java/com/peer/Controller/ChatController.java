package com.peer.Controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.peer.Service.IChatService;
import com.peer.Service.IFriendService;
import com.peer.Service.IUserService;
import com.peer.model.Chat;
import com.peer.model.User;


@Controller
public class ChatController {
	
	@Autowired
	IChatService iChatService;

	@Autowired
	IUserService iUserService;
	
	int trackid;

	@Autowired
	IFriendService iFriendService;
	
	
	@RequestMapping(value = {"/startChat" })
	public ModelAndView startChat(HttpServletRequest request,HttpServletResponse response){
		System.out.println("started chatting");
		trackid=Integer.parseInt(request.getParameter("frdid"));
		//System.out.println("asdfgh"+friend.getUserid());
		System.out.println("sdfghj"+trackid);
		return new ModelAndView("viewchat", "command", new Chat()).addObject("msgs",iChatService.viewChat(iUserService.get().getUid(),trackid)).addObject("chatusers", iFriendService.viewAllFriends(iUserService.get()));
	}
	
	@RequestMapping(value = {"/storechat" })
	public ModelAndView reChat(HttpServletRequest request,ModelMap model,@ModelAttribute("peers") Chat c,BindingResult result){
		System.out.println("pom");
		c.setFromUser(iUserService.get().getUid());
		System.out.println("from user");
		//c.setMessage("Hi");
		System.out.println("hola");
		c.setToUser(trackid);
		System.out.println("track contro");
		iChatService.addChat(c);
		System.out.println("cchat");
		return new ModelAndView("viewchat", "command", new Chat()).addObject("msgs",iChatService.viewChat(iUserService.get().getUid(),trackid)).addObject("chatusers",iFriendService.viewAllFriends(iUserService.get()));
	}
	
	//this is for view chat
	@RequestMapping(value={ "viewchat"})
	public ModelAndView viewchat(HttpServletRequest request,@Valid @ModelAttribute("peers") Chat c,BindingResult result) 
	{
		System.out.println("view chat");
		ModelAndView mv=new ModelAndView("viewchat","command",new Chat());
		System.out.println("Friens "+iFriendService.viewAllFriends(iUserService.get()).size());
		mv.addObject("chatusers", iFriendService.viewAllFriends(iUserService.get()));
		System.out.println("chatting users");
		return  mv; 
	}
	
	//this mehtod is used to search the chat
	public String toJson(List data){
		String jsonData="";
		ObjectMapper mapper=new ObjectMapper();
		try {
			jsonData=mapper.writeValueAsString(data);
			System.out.println(jsonData);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonData;
	}
}

