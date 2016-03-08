
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class SessionTest {

	@Test
	public void testOpenSession() {
		Configuration config = new Configuration().configure();// ������ö���
		// ��ȡ����ע�����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		// ���sessionFactory����
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		// ���session����
		Session session = sessionFactory.openSession();
		if (session != null) {
			System.out.println("session�����ɹ�");
		} else {
			System.out.println("session����ʧ��");
		}
	}

	@Test
	public void testGetCurrentSession() {
		Configuration config = new Configuration().configure();// ������ö���
		// ��ȡ����ע�����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		// ���sessionFactory����
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		// ���session����
		Session session = sessionFactory.getCurrentSession();
		if (session != null) {
			System.out.println("session�����ɹ�");
		} else
			System.out.println("session����ʧ��");
	}

	@Test
	public void testSaveStudentsUseOpenSession() {
		Configuration config = new Configuration().configure();// ������ö���
		// ��ȡ����ע�����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		// ���sessionFactory����
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		// ���session����
		Session session1 = sessionFactory.getCurrentSession();
		Transaction transaction = session1.beginTransaction();
		Students s = new Students(1, "����", "��", new Date());
		session1.save(s);
		// session1.close();
		transaction.commit();// �ύ����

		Session session2 = sessionFactory.openSession();
		transaction = session2.beginTransaction();
		Students s1 = new Students(2, "����", "��", new Date());
		session2.save(s1);
		transaction.commit();// �ύ����
		// session2.close();

	}
}
