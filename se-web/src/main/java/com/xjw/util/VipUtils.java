package com.xjw.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xjw.entity.po.sys.VipConfig;

public class VipUtils {

	public static Map<Integer, VipConfig> toMap(List<VipConfig> vipList){
		Map<Integer, VipConfig> vipMap = new HashMap<Integer, VipConfig>();
		
		for(VipConfig vip : vipList){
			vipMap.put(vip.getLevel(), vip);
		}
		
		return vipMap;
	}
}
