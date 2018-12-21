package hx.com.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author: sun
 * @version:
 * @Description: ��ȡhibernate�Ĺ�����
 * @date: 2018��10��16������2:26:04
 */
public class HibernateUtil {
	private static SessionFactory factory;

	// hibernate�ѿ���Ԥ�����쳣��ת��������ʱ�쳣��
	static {
		try {
			Configuration cfg = new Configuration();
			cfg.configure();
			factory = cfg.buildSessionFactory();
		} catch (ExceptionInInitializerError e) {
			throw new ExceptionInInitializerError("��ʼ��sessionfactoryʧ�ܣ����������ļ�");
		}
	}
	/**
	 * @Description:��ȡһ���µ�session����
	 * ÿ��ʹ��openSession����������õ�һ���µ�session
	 * @return
	 */
	public static Session openSession(){
		return factory.openSession();
	}
	/**
	 * @Description:�ӵ�ǰ�߳��ϻ�ȡsession����
	 * @return
	 */
	public static Session getCurrentSession(){
		return factory.getCurrentSession(); //ֻ�������˰�session���̰߳�֮�󣬲���ʹ�ô˷��������򷵻�ֵ��null
	}
	public static void main(String[] args) {
		getCurrentSession();
	}
	
}
