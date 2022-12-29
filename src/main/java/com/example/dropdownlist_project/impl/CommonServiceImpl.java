package com.example.dropdownlist_project.impl;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dropdownlist_project.entity.CommonList;
import com.example.dropdownlist_project.ifs.CommonService;
import com.example.dropdownlist_project.repository.CommonDao;
import com.example.dropdownlist_project.vo.CommonReq;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonDao commonDao;

	@Override
	public Map<Map<String, String>, Set<String>> getGroupNameAndLabelIdAndLabelByGroupId(CommonReq req) throws Exception {
		
		Map<Map<String, String>, Set<String>> result = new LinkedHashMap<>();
		
		Set<String> groupNameSet = new LinkedHashSet<>();
		Set<String> labelSet = new LinkedHashSet<>();
		Map<String, String> mapInMap = new LinkedHashMap<>();
		
		List<CommonList> commonList = commonDao.findAllByGroupIdIn(req.getGroupId());
		for (CommonList commonItem : commonList) {
			
			if (req.getGroupId().equalsIgnoreCase(commonItem.getGroupId())) {
				groupNameSet.add(commonItem.getGroupName());
				labelSet.add(commonItem.getLabel());
			}
			
		}
		
		mapInMap.put(req.getGroupId(), groupNameSet.toString());
		
		result.put(mapInMap, labelSet);
		
		return result;
	}

}
