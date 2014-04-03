package gw2.api.webapp.controller;

import java.util.List;

import gw2.api.webapp.json.api.dao.MapNameDao;
import gw2.api.webapp.model.MapName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/mapnames")
public class MapNameController {

	@Autowired
	MapNameDao dao;
	
	@RequestMapping(value = "/{lang}", method = RequestMethod.GET)
	@ResponseBody
	public List<MapName> getAllMapNames(@PathVariable String lang) {
		List<MapName> result = dao.getAllMapNames(lang);
		return result;
	}
	
	@RequestMapping(value = "/{lang}/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<MapName> getMapNameById(@PathVariable String lang, @PathVariable String id) {
		List<MapName> result = dao.getMapNameById(lang, id);
		return result;
	}
}