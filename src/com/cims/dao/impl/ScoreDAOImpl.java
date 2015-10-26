package com.cims.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cims.dao.IScoreDAO;
import com.cims.vo.Score;

public class ScoreDAOImpl implements IScoreDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public ScoreDAOImpl(Connection conn){
		this.conn = conn;
	}
	//ʵ�ֳɼ���Ϣ�����
	public boolean doAdd(Score score) throws Exception {
		boolean flag = false;

		String sql = "insert into score(student_id,course_id,score) values(?,?,?);";
		
		this.pstmt = this.conn.prepareStatement(sql);
		
		this.pstmt.setInt(1, score.getStudent_id());
		this.pstmt.setInt(2, score.getCourse_id());
		this.pstmt.setInt(3, score.getScore());
		
		if(this.pstmt.executeUpdate() > 0){
			flag  = true;
		}
		this.pstmt.close();
		return flag;
	}

	
	public boolean doUpdateInfo(Score score ,int student_id,int course_id) throws Exception {
		boolean flag = false;
		String sql = "update score set student_id = ?,course_id = ?," +
				"score = ? where student_id = ? and course_id = ?;";
		
		this.pstmt = this.conn.prepareStatement(sql);
		
		this.pstmt.setInt(1, score.getStudent_id());
		this.pstmt.setInt(2, score.getCourse_id());
		this.pstmt.setInt(3, score.getScore());
		this.pstmt.setInt(4, student_id);
		this.pstmt.setInt(5, course_id);
		int aa = this.pstmt.executeUpdate();
		
		if( aa > 0){
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	//ͨ��ѧ�Ų�ѯ�ɼ���
	public Score finByld(int student_id) throws Exception {
		Score score = null;//����Score����
		String sql = "select * from score where student_id = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, student_id);//���ò�ѯ�ؼ���
		ResultSet rs = this.pstmt.executeQuery();//ִ�в�ѯ����
		if(rs.next()){//��ѯ���Ľ��
			 score = new Score();//ʵ���µ�Score����
			 score.setScore_id(rs.getInt(1));//����score_id����
			 score.setStudent_id(rs.getInt(2));//����student_id����
			 score.setCourse_id(rs.getInt(3));//����course_id����
			 score.setScore(rs.getInt(4));//����score����
		}
		this.pstmt.close();//�رղ���	
		return score;
	}

	public List<Score> findAll() throws Exception {
		List<Score> all = new ArrayList<Score>();//���巵�صļ��ϣ�����ȫ�����
		String sql = "select * from score;";
		
		this.pstmt = this.conn.prepareStatement(sql);
		
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			Score score = new Score();
			
			score.setScore_id(rs.getInt("score_id"));
			score.setStudent_id(rs.getInt("student_id"));
			score.setCourse_id(rs.getInt("course_id"));
			score.setScore(rs.getInt("score"));
			
			all.add(score);
		}
		this.pstmt.close();
		return all;
	}
}
