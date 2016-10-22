package com.peer.DAO;

import java.util.List;


import com.peer.model.Event;

public interface EventDAO {
	public void addevent(Event e);
	public void deleteevent(int id);
	public List<Event> viewEvent();
	}
