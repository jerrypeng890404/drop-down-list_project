package com.example.dropdownlist_project.vo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.dropdownlist_project.entity.CommonList;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonRes {
	
	private String statusCode;

	private String message;

	private List<CommonList> commonList;

	private Map<Map<String, String>, Set<String>> commonMap;
	
	private CommonList commonList2;

	public CommonRes() {
	}
	
	public CommonRes(String statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}
	
	public CommonRes(String statusCode, String message, CommonList commonList2) {
		this.statusCode = statusCode;
		this.message = message;
		this.commonList2 = commonList2;
	}

	public CommonRes(String statusCode, String message, List<CommonList> commonList) {
		this.statusCode = statusCode;
		this.message = message;
		this.commonList = commonList;
	}

	public CommonRes(String statusCode, String message, Map<Map<String, String>, Set<String>> commonMap) {
		this.statusCode = statusCode;
		this.message = message;
		this.commonMap = commonMap;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<CommonList> getCommonList() {
		return commonList;
	}

	public void setCommonList(List<CommonList> commonList) {
		this.commonList = commonList;
	}

	public Map<Map<String, String>, Set<String>> getCommonMap() {
		return commonMap;
	}

	public void setCommonMap(Map<Map<String, String>, Set<String>> commonMap) {
		this.commonMap = commonMap;
	}

	public CommonList getCommonList2() {
		return commonList2;
	}

	public void setCommonList2(CommonList commonList2) {
		this.commonList2 = commonList2;
	}

}
