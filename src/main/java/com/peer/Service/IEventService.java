package com.peer.Service;

import java.util.List;


import com.peer.model.Event;


public interface IEventService {
	public void addevent(Event e);
	public void deleteevent(int id);
	public List<Event> viewEvent();
	
}
