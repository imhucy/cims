package com.cims.dao.proxy;

import java.util.List;

import com.cims.dao.INotificeDAO;
import com.cims.dao.impl.NotificeDAOImpl;
import com.cims.dbc.DatebaseConnection;
import com.cims.vo.Notifice;

public class NotificeDAOProxy implements INotificeDAO {

	private DatebaseConnection dbc = null;//������ݿ�������
	private INotificeDAO dao = null;//����DAO����
	public NotificeDAOProxy() throws Exception{//�ڹ��췽����ʵ�����ӣ�ͬʱʵ��dao����
		this.dbc = new DatebaseConnection();//������ݿ�
		this.dao = new NotificeDAOImpl(this.dbc.getConnection());//ʵ����ʵ�������
	}
	public boolean doAdd(Notifice notifice) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.doAdd(notifice);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	public List<Notifice> findAll(int class_id) throws Exception {
		List<Notifice> all = null;
		try {
			all = this.dao.findAll(class_id);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}

	public Notifice findByld(int notifice_id) throws Exception {
		Notifice notifice = null;//����Notifice����
		try{
			notifice = this.dao.findByld(notifice_id);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();//�ر���ݿ�
		}
		return notifice;
	}

}
