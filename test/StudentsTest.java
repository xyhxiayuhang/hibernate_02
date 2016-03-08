import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//������

public class StudentsTest {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@Before
	public void init() {
		// �������ö���
		Configuration config = new Configuration().configure();
		// ��������ע�����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		// �����Ự��������
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		// �����Ự����
		session = sessionFactory.openSession();
		// ��������
		transaction = session.beginTransaction();
	}

	@After
	public void destroy() {
		transaction.commit();// �ύ����
		session.close();// �رջỰ
		sessionFactory.close();// �رջỰ����
	}

	@Test
	public void testSaveStudent() {
		// ����ѧ������
		Students s = new Students(1, "������", "Ů", new Date());
		Address address = new Address("200237", "64251041", "�Ϻ�");
		s.setAddress(address);
		session.save(s);// �������������ݿ�
	}

	@Test
	public void testGetStudent() {
		Students students = (Students) session.get(Students.class, 1);
		System.out.println(students);
	}

	@Test
	public void testLoadStudent() {
		Students students = (Students) session.load(Students.class, 1);
		System.out.println(students);
	}

	@Test
	public void testUpdateStudent() {
		Students students = (Students) session.get(Students.class, 1);
		students.setGender("��");
		session.update(students);
	}

	@Test
	public void testDeleteStudent() {
		Students students = (Students) session.get(Students.class, 1);
		session.delete(students);
	}
}
