package com.example.dropdownlist_project.constans;

public enum CommonRtnCode {
	
	SUCCESSFUL("200", "成功しました！"),

	PARAMETER_REQUIRED("400", "必要なパラメータがありません。もう一度試してください!"),

	FAILED("500", "エラーが発生しました。もう一度やり直してください！"),

	DATA_REQUIRED("417", "情報を完全に入力してください。");

	private String code;

	private String message;

	private CommonRtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
