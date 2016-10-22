package com.peer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peer.DAO.EventDAO;
import com.peer.model.Event;


@Service("EventService")
public class EventService implements IEventService {
	@Autowired(required=true)
	 private EventDAO ed;

	public void addevent(Event e) {
		ed.addevent(e);
	}

	public void deleteevent(int id) {
		ed.deleteevent(id);
	}

	public List<Event> viewEvent() {
		
		return ed.viewEvent();
	}

	

	


}
