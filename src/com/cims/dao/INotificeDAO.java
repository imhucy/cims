package com.cims.dao;

import java.util.List;

import com.cims.vo.Notifice;

public interface INotificeDAO {
	//发布通知
	public boolean doAdd(Notifice notifice) throws Exception;
	//通过班级号查看所有通知
	public List<Notifice> findAll(int class_id) throws Exception;
	//查找关键字
	public Notifice findByld(int notifice_id) throws Exception;

}
