package com.my.service;

import com.my.domain.PoemDo;
import com.my.domain.PoemQueryDo;
import com.my.entity.PoemWithBLOBs;

import java.util.List;

public interface PoemService {
	void addPoem(PoemWithBLOBs poem);

	List<PoemDo> listPoems(PoemQueryDo queryDo);
}
