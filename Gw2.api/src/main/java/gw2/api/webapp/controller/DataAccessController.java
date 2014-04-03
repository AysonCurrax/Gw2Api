package gw2.api.webapp.controller;

import gw2.api.webapp.model.Data;
import gw2.api.webapp.model.Event;
import gw2.api.webapp.model.MapName;
import gw2.api.webapp.model.WorldName;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class DataAccessController {

	@Autowired
	Data data;
	
	@RequestMapping
	public String createPage(Model model) {
		List<WorldName> worldnames = data.getWorldNames();
		List<MapName> mapnames = data.getMapNames();
		List<Event> events = data.getEvents();
		
		List<Event> result = new ArrayList<Event>();
		for(Event event : events) {
			if(event.getWorldId() == 2201 && event.getMapId() == 22 && event.getEventId().equals("ED13FF54-09E4-41DD-9320-9B5FDE67CC3A")) {
				result.add(event);
			}
		}
		model.addAttribute("world_list", worldnames);
		model.addAttribute("map_list", mapnames);
		model.addAttribute("events", result);
		return "search";
	}
}
