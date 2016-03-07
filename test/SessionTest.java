
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class SessionTest {

	@Test
	public void testOpenSession() {
		Configuration config = new Configuration().configure();// 获得配置对象
		// 获取服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		// 获得sessionFactory对象
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		// 获得session对象
		Session session = sessionFactory.openSession();
		if (session != null) {
			System.out.println("session创建成功");
		} else {
			System.out.println("session创建失败");
		}
	}

	@Test
	public void testGetCurrentSession() {
		Configuration config = new Configuration().configure();// 获得配置对象
		// 获取服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		// 获得sessionFactory对象
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		// 获得session对象
		Session session = sessionFactory.getCurrentSession();
		if (session != null) {
			System.out.println("session创建成功");
		} else
			System.out.println("session创建失败");
	}
}
