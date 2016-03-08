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

//测试类

public class StudentsTest {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@Before
	public void init() {
		// 创建配置对象
		Configuration config = new Configuration().configure();
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		// 创建会话工厂对象
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		// 创建会话对象
		session = sessionFactory.openSession();
		// 开启事务
		transaction = session.beginTransaction();
	}

	@After
	public void destroy() {
		transaction.commit();// 提交事务
		session.close();// 关闭会话
		sessionFactory.close();// 关闭会话工厂
	}

	@Test
	public void testSaveStudent() {
		// 生成学生对象
		Students s = new Students(1, "张三丰", "女", new Date());
		Address address = new Address("200237", "64251041", "上海");
		s.setAddress(address);
		session.save(s);// 保存对象进入数据库
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
		students.setGender("男");
		session.update(students);
	}

	@Test
	public void testDeleteStudent() {
		Students students = (Students) session.get(Students.class, 1);
		session.delete(students);
	}
}
