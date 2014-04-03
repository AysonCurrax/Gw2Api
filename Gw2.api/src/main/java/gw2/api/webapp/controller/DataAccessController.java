package gw2.api.webapp.controller;

import gw2.api.webapp.model.Data;
import gw2.api.webapp.model.WorldName;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class DataAccessController {

	@Autowired
	Data data;
	
	@RequestMapping
	@ResponseBody
	public List<WorldName> getWorldNames() {
		return data.getWorldNames();
	}
}
