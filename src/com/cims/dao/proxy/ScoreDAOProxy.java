package com.cims.dao.proxy;

import java.util.List;

import com.cims.dao.IScoreDAO;
import com.cims.dao.impl.ScoreDAOImpl;
import com.cims.dbc.DatebaseConnection;
import com.cims.vo.Score;

public class ScoreDAOProxy implements IScoreDAO {

	private DatebaseConnection dbc = null;
	private IScoreDAO dao = null;
	public ScoreDAOProxy() throws Exception{
		this.dbc = new DatebaseConnection();
		this.dao = new ScoreDAOImpl(this.dbc.getConnection());
	}
	
	public boolean doAdd(Score score) throws Exception {
		boolean flag = false;
		try {
			if(this.dao.finByld(score.getScore_id()) == null){
				flag = this.dao.doAdd(score);
			}
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	//����
	public boolean doUpdateInfo(Score score, int student_id, int course_id) throws Exception {
		boolean flag = false;
		try {
			if(this.dao.finByld(score.getScore_id()) != null){
				flag = this.dao.doUpdateInfo(score, student_id, course_id);//����������������
			}
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();//�ر���ݿ�
		}
		return flag;
	}

	//��ѯ
	public Score finByld(int id) throws Exception {
		Score score = null;
		try {
			score = this.dao.finByld(id);
		} catch (Exception e) {
			 throw e;
		}finally{
			this.dbc.close();//�ر���ݿ�
		}
		return score;
	}

	//��ѯ�������
	public List<Score> findAll() throws Exception {
		List<Score> all = null;
		try {
			all = this.dao.findAll();
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}

}
