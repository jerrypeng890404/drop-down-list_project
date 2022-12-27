package com.example.dropdownlist_project.ifs;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.dropdownlist_project.entity.CommonList;
import com.example.dropdownlist_project.vo.CommonReq;

public interface CommonService {

	//検索機能（パラメータ：なし）
	public List<CommonList> getCommonList() throws Exception;
	
	//検索機能（パラメータ：groupId）
	public Map<Map<String, String>, Set<String>> getGroupNameAndLabelIdAndLabelByGroupId(CommonReq req) throws Exception;
	
	//増加機能
	public void createCommonList(CommonReq req);
	
	//状態の変更機能
	public void inactiveCommonList(CommonReq req) throws Exception;
	
	//編集機能
	public void updateCommonList(CommonReq req) throws Exception;
	
}
