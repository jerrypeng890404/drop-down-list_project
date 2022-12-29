package com.example.dropdownlist_project.ifs;

import java.util.Map;
import java.util.Set;

import com.example.dropdownlist_project.vo.CommonReq;

public interface CommonService {
	
	//検索機能（パラメータ：groupId）
	public Map<Map<String, String>, Set<String>> getGroupNameAndLabelIdAndLabelByGroupId(CommonReq req) throws Exception;
	
}
