package com.my.controller;

import com.my.domain.PoemQueryDo;
import com.my.entity.PoemWithBLOBs;
import com.my.service.AuthorService;
import com.my.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/poem/")
public class PoemController extends BaseController {

	@Autowired
	private PoemService poemService;
	@Autowired
	private AuthorService authorService;


	@RequestMapping(value = "add",method = RequestMethod.GET)
	public String toAdd(ModelMap modelMap) {
		modelMap.addAttribute("authors", authorService.listAuthors(null));
		return "poem/add";
	}

	@ResponseBody
	@RequestMapping(value = "add",method = RequestMethod.POST)
	public String add(PoemWithBLOBs poem) {
		poemService.addPoem(poem);
		return "ok";
	}

	@RequestMapping(value = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public String list(ModelMap modelMap, PoemQueryDo queryDo) {
		modelMap.addAttribute("poems", poemService.listPoems(queryDo));
		return "poem/list";
	}
}
