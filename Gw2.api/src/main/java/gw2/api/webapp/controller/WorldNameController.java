package gw2.api.webapp.controller;

import java.util.List;

import gw2.api.webapp.json.api.dao.WorldNameDao;
import gw2.api.webapp.json.api.domain.WorldName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/worldnames")
public class WorldNameController {

	@Autowired
	private WorldNameDao dao;
	
	@RequestMapping(value = "/{lang}", method = RequestMethod.GET)
	@ResponseBody
	public List<WorldName> getAllWorldNames(@PathVariable String lang) {
		List<WorldName> result = dao.getAllWorldNames(lang);
		return result;
	}
	
	@RequestMapping(value = "/{lang}/{id}", method = RequestMethod.GET)
	@ResponseBody
	public WorldName getWorldNameById(@PathVariable String lang, @PathVariable String id) {
		WorldName result = dao.getWorldNameById(lang, id);
		return result;
	}
}