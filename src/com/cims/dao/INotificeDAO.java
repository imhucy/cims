package com.cims.dao;

import java.util.List;

import com.cims.vo.Notifice;

public interface INotificeDAO {
	//����֪ͨ
	public boolean doAdd(Notifice notifice) throws Exception;
	//ͨ���༶�Ų鿴����֪ͨ
	public List<Notifice> findAll(int class_id) throws Exception;
	//���ҹؼ���
	public Notifice findByld(int notifice_id) throws Exception;

}
