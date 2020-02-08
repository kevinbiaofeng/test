package com.xjw.base.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xjw.base.dao.BaseDao;
import com.xjw.base.entity.BasePo;
import com.xjw.utility.BeanToMapUtil;
import com.xjw.utility.BizException;
import com.xjw.utility.CurrentUserHolder;

public abstract class BaseDaoImpl<T extends BasePo> extends XjwDaoSupport implements BaseDao<T> {
	private static Logger logger = LoggerFactory.getLogger(BaseDaoImpl.class.getName());
	
	public T save(String mapId, T t) throws BizException {
		setCreateInfo(t);
		int row = getSqlSession().insert(mapId, t);
		if (row != 1)
			throw new BizException("save data is fail!");
		return t;
	}

	public int saveRecordBatch(String mapId, List<T> list) throws BizException {
		setListCreateInfo(list);
		return getSqlSession().insert(mapId, list);
	}

	public int deleteOne(String mapId, Object params) throws BizException {
		return getSqlSession().delete(mapId, params);
	}

	public List<T> selectAll(String mapId, Object params) {
		return getSqlSession().selectList(mapId, params);
	}

	public T selectById(String mapId, Long id) {
		Map<String, Long> params = new HashMap<String, Long>();
		params.put("id", id);
		return getSqlSession().selectOne(mapId, params);
	}

	public long selectAllCount(String mapId, Object params) {
		Long count = (Long) getSqlSession().selectOne(mapId, params);
		if (count == null) {
			return 0;
		} else {
			return count.longValue();
		}
	}

	@SuppressWarnings("unchecked")
	public int update(String mapId, T t) throws BizException {
		setUpdateInfo(t);
		Map<String, Object> m = BeanToMapUtil.convertBean(t);
		return getSqlSession().update(mapId, m);
	}

	public int update(String mapId, Map<String, Object> params)
			throws BizException {
		return getSqlSession().update(mapId, params);
	}

	public int delete(String mapId, Object params) throws BizException {
		return getSqlSession().update(mapId, params);
	}

	private void setListCreateInfo(List<T> list) {
		for (T po : list) {
			if (po.getCreateTime() == null) {
				po.setCreateTime(new Date());
			}
			if (po.getUpdateTime() == null) {
				po.setUpdateTime(new Date());
			}
			try {
				Long userId = CurrentUserHolder.getCurrentUserId();
				if (po.getCreateUser() == null) {
					po.setCreateUser(userId);
				}
				if (po.getUpdateUser() == null) {
					po.setUpdateUser(userId);
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
	}

	private void setCreateInfo(T po) {
		if (po.getCreateTime() == null) {
			po.setCreateTime(new Date());
		}
		if (po.getUpdateTime() == null) {
			po.setUpdateTime(new Date());
		}
		Long userId = CurrentUserHolder.getUserId();
		if (po.getCreateUser() == null && userId != null) {
			po.setCreateUser(userId);
		}
		if (po.getUpdateUser() == null) {
			po.setUpdateUser(userId);
		}
	}

	private void setUpdateInfo(Object object) {
		if (object instanceof BasePo) {
			BasePo po = (BasePo) object;
			if (po.getUpdateTime() == null) {
				po.setUpdateTime(new Date());
			}
			if (po.getUpdateUser() == null) {
				try {
					po.setUpdateUser(CurrentUserHolder.getCurrentUserId());
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
	}

}
