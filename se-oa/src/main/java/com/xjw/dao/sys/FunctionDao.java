package com.xjw.dao.sys;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.sys.Function;

@Repository
public class FunctionDao extends BaseDaoImpl<Function>{

	public List<Function> selectAllByRole(Object params) {
		return getSqlSession().selectList("Function.selectAllByRole", params);
	}
}
