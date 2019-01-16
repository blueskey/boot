package com.my.service.impl;

import com.my.domain.PoemDo;
import com.my.domain.PoemQueryDo;
import com.my.entity.PoemWithBLOBs;
import com.my.mapper.PoemMapper;
import com.my.service.PoemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PoemServiceImpl implements PoemService {

	@Resource
	private PoemMapper poemMapper;

	@Override public void addPoem(PoemWithBLOBs poem) {
		poemMapper.insert(poem);
	}

	@Override public List<PoemDo> listPoems(PoemQueryDo queryDo) {

		return poemMapper.listPoems(queryDo);
	}
}
