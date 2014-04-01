package gw2.api.webapp.controller;

import java.util.Map;

import gw2.api.webapp.json.api.dao.EventDetailDao;
import gw2.api.webapp.json.api.domain.EventDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/eventdetails")
public class EventDetailController {

	@Autowired
	private EventDetailDao dao;
	
	@RequestMapping(value = "/{lang}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, EventDetail> getAllEventDetails(@PathVariable String lang) {
		Map<String, EventDetail> result = dao.getAllEventDetails(lang);
		return result;
	}
	
	@RequestMapping(value = "/{lang}/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, EventDetail> getEventDetailById(@PathVariable String lang, @PathVariable String id) {
		Map<String, EventDetail> result = dao.getEventDetailById(lang, id);
		return result;
	}
}
