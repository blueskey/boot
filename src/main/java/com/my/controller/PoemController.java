package com.my.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.my.domain.PoemDo;
import com.my.domain.PoemQueryDo;
import com.my.entity.PoemWithBLOBs;
import com.my.service.AuthorService;
import com.my.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/poem/")
//@CacheConfig(cacheNames = "mycaffeineCache")
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
//	@CachePut(key = "#poem.id")
	@RequestMapping(value = "add",method = RequestMethod.POST)
	public String add(PoemWithBLOBs poem) {
		poemService.addPoem(poem);
		return "ok";
	}

	@SentinelResource("poemList")
	@RequestMapping(value = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public String list(ModelMap modelMap, PoemQueryDo queryDo) {
		modelMap.addAttribute("poems", poemService.listPoems(queryDo));
		return "poem/list";
	}

	@RequestMapping(value = "detail")
	public String detail(ModelMap modelMap,String id) {
		PoemQueryDo queryDo = new PoemQueryDo();
		queryDo.setId(id);
		List<PoemDo> poems = poemService.listPoems(queryDo);
		modelMap.addAttribute("poem", CollectionUtils.isEmpty(poems)?null:poems.get(0));
		return "poem/detail";
	}
}
