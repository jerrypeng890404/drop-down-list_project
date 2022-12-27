package com.example.dropdownlist_project.entity;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.dropdownlist_project.vo.CommonReq;

@Entity
@Table(name = "common_list")
public class CommonList {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "group_id")
	private String groupId;

	@Column(name = "group_name")
	private String groupName;

	@Column(name = "label_id")
	private String labelId;

	@Column(name = "label")
	private String label;

	@Column(name = "status")
	private boolean status;

	@Column(name = "creator")
	private String creator;

	@Column(name = "create_date")
	private LocalDateTime createDate;

	@Column(name = "modifier")
	private String modifier;

	@Column(name = "modify_date")
	private LocalDateTime modifyDate;

	public CommonList() {
	}
	
	public CommonList(CommonReq req) {
		this.id = req.getId();
		this.groupId = req.getGroupId();
		this.groupName = req.getGroupName();
		this.labelId = req.getLabelId();
		this.label = req.getLabel();
		this.status = false;
		this.creator = req.getCreator();
		this.createDate = LocalDateTime.now();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getLabelId() {
		return labelId;
	}

	public void setLabelId(String labelId) {
		this.labelId = labelId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public LocalDateTime getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(LocalDateTime modifyDate) {
		this.modifyDate = modifyDate;
	}

}
