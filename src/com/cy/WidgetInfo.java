package com.cy;

public class WidgetInfo {

	/**
	 * 控件id名称
	 */
	private String idName;
	/**
	 * 控件类型
	 */
	private String type;
	/**
	 * 输出内容
	 */
	private String content;
	/**
	 * 排序优先级，数值低的排在前面
	 */
	private int level;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIdName() {
		return idName;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
