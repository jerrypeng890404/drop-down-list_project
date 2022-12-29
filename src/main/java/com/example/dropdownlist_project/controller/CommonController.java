package com.example.dropdownlist_project.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dropdownlist_project.constans.CommonRtnCode;
import com.example.dropdownlist_project.ifs.CommonService;
import com.example.dropdownlist_project.vo.CommonReq;
import com.example.dropdownlist_project.vo.CommonRes;

//跨網域用
@CrossOrigin
@RestController
public class CommonController {
	
	@Autowired
	private CommonService commonService ;
	
	//検索機能
	@PostMapping("getGroupNameAndLabelIdAndLabel")
	public CommonRes getGroupNameAndLabelIdAndLabel(@RequestBody CommonReq req) {
		Map<Map<String, String>, Set<String>> result = new LinkedHashMap<>();
		try {
			result = commonService.getGroupNameAndLabelIdAndLabelByGroupId(req);
		} catch (Exception e) {
			return new CommonRes(
					CommonRtnCode.FAILED.getCode(),
					CommonRtnCode.FAILED.getMessage()
					);
		}
		return new CommonRes(
				CommonRtnCode.SUCCESSFUL.getCode(),
				CommonRtnCode.SUCCESSFUL.getMessage(),
				result);
	}

}
