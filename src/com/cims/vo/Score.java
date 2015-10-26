package com.cims.vo;
//������
public class Score {
	//����
	private int score_id;
	private int student_id;
	private int course_id;
	private int score;
	//���췽��
	public Score() {
		
	}
	
	@Override
	public String toString() {
		return "Score [score_id=" + score_id + ", student_id=" + student_id
				+ ", course_id=" + course_id + ", score=" + score + "]";
	}

	public Score(int score_id, int student_id, int course_id, int score) {
		this();
		setScore_id(score_id);
		setStudent_id(student_id);
		setCourse_id(course_id);
		setScore(score);
	}
	//get��set����
	public int getScore_id() {
		return score_id;
	}
	public void setScore_id(int score_id) {
		this.score_id = score_id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
