package com.peer.Controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.peer.Service.IBlogService;
import com.peer.Service.ICommentService;
import com.peer.Service.IEventService;
import com.peer.Service.IFriendService;
import com.peer.Service.IMailService;
import com.peer.Service.IUserService;
import com.peer.model.Blog;
import com.peer.model.Comment;
import com.peer.model.Event;
import com.peer.model.Friend;
import com.peer.model.Friends;
import com.peer.model.User;

@Controller
public class HomeController {
	@Autowired
	IUserService iUserService;
	

	@Autowired
	IBlogService iBlogService;
	
	@Autowired
	IEventService iEventService;
	
	@Autowired
	IFriendService iFriendService;
	
		@Autowired
	ICommentService iCommentService;
		@Autowired
		IMailService iMailService;
		
	@RequestMapping(value=  { "/" , "home"})
	public ModelAndView home() {
		System.out.println("home");
		return new ModelAndView("home").addObject("Welcome", iUserService.get());
	}
	
	
	
	@RequestMapping(value=  { "comment"})
	public ModelAndView comment() {
		System.out.println("comment");
		return new ModelAndView("comment","command",new Comment());
	}
	
		
	@RequestMapping(value = { "login" })
	public ModelAndView Login() {
		System.out.println("Login");
		return new ModelAndView("login","command",new User()).addObject("login", true);
	}
	@RequestMapping(value = { "logout" })
	public ModelAndView logout() {
		System.out.println("logout");
		return new ModelAndView("home","command",new User()).addObject("logout", true);
	}
		
	@RequestMapping(value = { "signup" })
	public ModelAndView signup() {
		System.out.println("signup");
		System.out.println("uid");
		User u=new User();
		u.setDate(new Date());
		return new ModelAndView("signup","command",u).addObject("signup", true);
	}
	
	
	@RequestMapping(value = "store", method=RequestMethod.POST)
	public ModelAndView signup(HttpServletRequest request,@Valid @ModelAttribute("peers") User u,BindingResult result) throws MessagingException {
		System.out.println("Register"+u.getDate());
		u.setDate(new Date());
		ModelAndView mv=new ModelAndView("store");
		System.out.println("store");
		boolean flag=true;
		if(result.hasErrors()){
			flag=false;
			System.out.println("duster");
			mv=new ModelAndView("signup", "command", new User());
			System.out.println("controller");
					mv.addObject("errors", result.getAllErrors());
					for(ObjectError s:result.getAllErrors()){
						System.out.println(s.toString());
						if(s.toString().contains("date") && result.getAllErrors().size()==1 ){
							System.out.println("jennifer"
									+ "");
							flag=true;
						}
					}
					
		}
		if(flag){
			System.out.println("chalk");
			iUserService.adduser(u);
			System.out.println("teddy");
			iMailService.send(u, "Welcome to Peers", "Hi Welcome to Peers");
			mv=new ModelAndView("login", "command", new User());
		}
		return mv;
		//return new ModelAndView("home","command",new User()).addObject("login", true);
	}
	
	//@modelattribute An annotated method parameter can be mapped to an attribute in a model .
	
	@RequestMapping(value = { "LoginUser" })
	public ModelAndView Login(HttpServletRequest request,@ModelAttribute("peer") User u,BindingResult result) throws MessagingException {
		System.out.println("Login");
		User user=iUserService.verifyuser(u);
		
		ModelAndView mv=new ModelAndView("home","Welcome",user);
		return mv;
	}
	
	@RequestMapping(value=  {"viewfriend"})
	public ModelAndView viewfriend() {
		System.out.println("viewfriend");
		
		int fndid;
		ModelAndView mv=new ModelAndView("viewfriend","command",new User());
		//System.out.println("hi frds "+iFriendService.viewAllRequest(iUserService.get().getUid()).get(0).getFriend().getUser().getFirstname());
		mv.addObject("users", toJson(iUserService.viewUser()));
		//mv.addObject("friendRequests",iFriendService.viewAllRequest(iUserService.get().getUid()));
		return  mv; 
		
	}
	
	User user;

	@RequestMapping(value = { "/addasfriend" })
	public ModelAndView view(HttpServletRequest request, @ModelAttribute("peers") Friends f,BindingResult result) 
	{
		System.out.println("addfnd");
		String fid = request.getParameter("u");
		System.out.println(fid);
		int Uid = 0;
		int fndid = 0;
		System.out.println("user n frds");
		System.out.println(iUserService.get().getFirstname());
		iFriendService.addFriend(iUserService.get(),Integer.parseInt(fid));
		System.out.println("siri red");
		System.out.println("contro");
    
		/*System.out.println(user.getFirstname()); */
    	Friends userFriends=new Friends();
    	System.out.println("what the fish...!!!!");
    	userFriends.setStatus("Requested");
    	Friend friend=new Friend();
    	System.out.println("fishyy it field");
		friend.setUser(user);
    	List<User> frnd=iUserService.viewUser();
        friend.setUser(user);;
    	System.out.println("i hate eclipse");
    	userFriends.setFriend(friend);
    	System.out.println("pichhhiiiiii.......");
    	
		return new ModelAndView("home","welcome",iUserService.get());
	}



	@RequestMapping(value = { "/acceptfriend" })
	public String view(HttpServletRequest request, @ModelAttribute("peers") Friend f,BindingResult result) 
	{
		System.out.println("accfnd");
		String fid = request.getParameter("f");
		iFriendService.updateFriend(Integer.parseInt(fid));
		System.out.println("teddy");
		return "redirect:/viewfriend";
	}
	
	public String toJson(List data){
		String jsonData="";
		ObjectMapper mapper=new ObjectMapper();
		try {
			jsonData=mapper.writeValueAsString(data);
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
		return jsonData;
	}
}