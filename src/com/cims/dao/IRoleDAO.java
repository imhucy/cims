package com.cims.dao;

import java.util.List;

import com.cims.vo.Role;

public interface IRoleDAO {
	/**
	 * 查找所有的角色
	 * @return
	 * @throws Exception
	 */
	public List<Role> findAll() throws Exception;
}
