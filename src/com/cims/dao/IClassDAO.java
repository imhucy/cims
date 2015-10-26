package com.cims.dao;

public interface IClassDAO {
	/*
	 * 更新班费数额
	 * 
	 * */
	public boolean doUpdateSumMoney(int class_id,float active_number) throws Exception;
	/*
	 * 按 id 查找
	 */
	public com.cims.vo.Class findById(int class_id) throws Exception;
}
