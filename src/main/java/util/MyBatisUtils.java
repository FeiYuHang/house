package util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;







public class MyBatisUtils {
    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

	static {		
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
	/**
	 * 同一线程获得同一session
	 * @return
	 */
	public static SqlSession getSession() {
			
		SqlSession session = threadLocal.get();	//从自己的线程中获取对应session
		if(session == null) {
			session = getFactory().openSession();
			threadLocal.set(session);
		}
		
		return session;
	}
	
	public static void close() {
		SqlSession session = threadLocal.get();
		if(session != null) {
			session.close();
			session = null;
		}
		threadLocal.set(null);
	}
}
