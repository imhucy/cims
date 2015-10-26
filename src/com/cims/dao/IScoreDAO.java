package com.cims.dao;

import java.util.List;

import com.cims.vo.Score;

public interface IScoreDAO {
	//¼����Ϣ
	public boolean doAdd(Score score) throws Exception;
	//�޸���Ϣ
	public boolean doUpdateInfo(Score score,int student_id,int course_id ) throws Exception;
	//ͨ��ѧ�Ų鿴�ɼ���Ϣ
	public List<Score> findAll() throws Exception;
	//ͨ�����ѧ��ѧ�Źؼ��ֲ鿴
	public Score finByld(int student_id) throws Exception;
}
