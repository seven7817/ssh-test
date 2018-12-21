package hx.com.services;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;


import hx.com.utils.HibernateUtil;

import hx.com.modle.User;

@Service
public class ServiceImpl implements IService {
	public void addUser(User user) {
		// TODO Auto-generated method stub
		//获取entityManager对象
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		s.save(user);
		tx.commit();
		s.close();
	}
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		User user = s.get(User.class, Integer.parseInt(userId));
		System.out.println(userId);
		System.out.println(user);
		s.delete(user);
		tx.commit();
		s.close();
	}
	@SuppressWarnings("unchecked")
	public ArrayList<User> getAllUsers() {
		ArrayList<User> list ;
		Session s = HibernateUtil.getCurrentSession();
		Transaction t = s.beginTransaction();
		// 1.获取Query对象
		org.hibernate.Query q = s.createQuery("from User");
		// 1.执行获取结果集
		list = (ArrayList<User>) q.list();
		t.commit();
		return list;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<User> getAllUsersByName(String name) {
		ArrayList<User> list ;
		Session s = HibernateUtil.getCurrentSession();
		Transaction t = s.beginTransaction();
		// 1.获取Query对象
		String strSQL="from User where name like :name";
		org.hibernate.Query q = s.createQuery(strSQL);
		// 1.执行获取结果集
		q.setString("name", "%"+name+"%");
		list = (ArrayList<User>) q.list();
		/*for (User user : list) {
			System.out.println(user);
		}*/
		t.commit();
		return list;
	}
	public void updateUser(User user) {
		Session s = HibernateUtil.getCurrentSession();
		Transaction t = s.beginTransaction();
		// 1.获取Query对象
		User newuser = s.get(User.class, user.getId());
		newuser.setName(user.getName());
		// 1.执行获取结果集
		t.commit();

	}
	

}
