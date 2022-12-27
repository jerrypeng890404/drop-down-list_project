package com.example.dropdownlist_project.impl;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
	public List<CommonList> getCommonList() throws Exception {
		List<CommonList> result = new LinkedList<>();
		Set<CommonList> commonSet = new LinkedHashSet<>();
		List<CommonList> commonList = commonDao.findAll();
		commonSet.addAll(commonList);
		result.addAll(commonSet);
		if (result == null || result.isEmpty())
			return null;
		return result;
	}

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

	@Override
	public void createCommonList(CommonReq req){
		CommonList toCreateCommon = new CommonList(req.getGroupId(), req.getGroupName(), req.getLabelId(), req.getLabel(),
				false, req.getCreator(), LocalDateTime.now());
		commonDao.save(toCreateCommon);
	}

	@Override
	public void inactiveCommonList(CommonReq req) throws Exception {
		Optional<CommonList> commonOp = commonDao.findById(req.getId());
		if (!commonOp.isPresent())
			throw new Exception("To set status of Common is null");
		CommonList commonStatus = commonOp.get();
		commonStatus.setStatus(req.isStatus());
		commonDao.save(commonStatus);
	}

	@Override
	public void updateCommonList(CommonReq req) throws Exception {
		Optional<CommonList> commonOp = commonDao.findById(req.getId());
		if (!commonOp.isPresent())
			throw new Exception("To update Common is null");
		CommonList toUpdateCommon = commonOp.get();
		toUpdateCommon.setGroupId(req.getGroupId());
		toUpdateCommon.setGroupName(req.getGroupName());
		toUpdateCommon.setLabelId(req.getLabelId());
		toUpdateCommon.setLabel(req.getLabel());
		toUpdateCommon.setModifier(req.getModifier());
		toUpdateCommon.setModifyDate(LocalDateTime.now());
		commonDao.save(toUpdateCommon);
	}

}
