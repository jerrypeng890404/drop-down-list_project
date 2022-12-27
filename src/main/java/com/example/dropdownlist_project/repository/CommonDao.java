package com.example.dropdownlist_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.dropdownlist_project.entity.CommonList;

public interface CommonDao extends JpaRepository<CommonList, Integer> {

//	@Modifying                                     //パラメータによる
//	@Query(" SELECT c FROM Common c where c.groupId= :groupId group by groupId ")
//	public List<Common> findGroupNameBygroupId(@Param("groupId") String groupId);
	
	//使用状態はfalseの限り
	@Query(" SELECT c FROM CommonList c WHERE c.status=false ")
	public List<CommonList> findAllByGroupIdIn(String groupId);
	
}
