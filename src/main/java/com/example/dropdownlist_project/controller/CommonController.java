package com.example.dropdownlist_project.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dropdownlist_project.constans.CommonRtnCode;
import com.example.dropdownlist_project.entity.CommonList;
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
	
	//増加機能
	@PostMapping("createCommonList")
	public CommonRes createCommonList(@RequestBody CommonReq req) {
		List<CommonList> result = new ArrayList<>();
		try {
			if(!StringUtils.hasText(req.getLabel())) {
				return new CommonRes(
						CommonRtnCode.DATA_REQUIRED.getCode(),
						CommonRtnCode.DATA_REQUIRED.getMessage()
						);
			}
			commonService.createCommonList(req);
			result = commonService.getCommonList();
		} catch (Exception e) {
			return new CommonRes(
					CommonRtnCode.FAILED.getCode(),
					CommonRtnCode.FAILED.getMessage()
					);
		}
		return new CommonRes(
				CommonRtnCode.SUCCESSFUL.getCode(),
				CommonRtnCode.SUCCESSFUL.getMessage(),
				result
				);
	}
	
	//状態の変更機能
	@PostMapping("inactiveCommonList")
	public CommonRes inactiveCommonList(@RequestBody CommonReq req) {
		List<CommonList> result = new LinkedList<>();
		try {
			if(req.getId() == null) {
				return new CommonRes(
						CommonRtnCode.DATA_REQUIRED.getCode(),
						CommonRtnCode.DATA_REQUIRED.getMessage()
						);
			}
			commonService.inactiveCommonList(req);
			result = commonService.getCommonList();
		} catch (Exception e) {
			return new CommonRes(
					CommonRtnCode.FAILED.getCode(),
					CommonRtnCode.FAILED.getMessage()
					);
		}
		return new CommonRes(
				CommonRtnCode.SUCCESSFUL.getCode(),
				CommonRtnCode.SUCCESSFUL.getMessage(),
				result
				);
	}

	//編集機能
	@PostMapping("updateCommonList")
	public CommonRes updateCommonList(@RequestBody CommonReq req) {
		List<CommonList> commonListRes = new LinkedList<>();
		try {
			if(req == null) {
				return new CommonRes(
						CommonRtnCode.DATA_REQUIRED.getCode(),
						CommonRtnCode.DATA_REQUIRED.getMessage(),
						commonListRes
						);
			}
			commonService.updateCommonList(req);
			commonListRes = commonService.getCommonList();
		} catch (Exception e) {
			return new CommonRes(
					CommonRtnCode.FAILED.getCode(),
					CommonRtnCode.FAILED.getMessage()
					);
		}
		return new CommonRes(
				CommonRtnCode.SUCCESSFUL.getCode(),
				CommonRtnCode.SUCCESSFUL.getMessage(),
				commonListRes
				);
	}
	
}
