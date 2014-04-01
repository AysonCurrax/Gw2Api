package gw2.api.webapp.controller;

import java.util.List;

import gw2.api.webapp.json.api.dao.EventNameDao;
import gw2.api.webapp.json.api.domain.EventName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/eventnames")
public class EventNameController {

	@Autowired
	private EventNameDao dao;
	
	@RequestMapping(value = "/{lang}", method = RequestMethod.GET)
	@ResponseBody
	public List<EventName> getAllEventNames(@PathVariable String lang) {
		List<EventName> result = dao.getAllEventNames(lang);
		return result;
	}
	
	@RequestMapping(value = "/{lang}/{id}", method = RequestMethod.GET)
	@ResponseBody
	public EventName getEventNameById(@PathVariable String lang, @PathVariable String id) {
		EventName result = dao.getEventNameById(lang, id);
		return result;
	}
}