package pack;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {						  // 내부적으로 new 실행
	 public static SqlSessionFactory sqlSession;  // SqlSessionFactory : DB의 SQL명령을 실행시킬 때 필요한 메소드를 갖고 있다.
	 
	  static{
	     String resource = "pack/Configuration.xml";
	     try {
	         Reader reader = Resources.getResourceAsReader(resource);
	         sqlSession = new SqlSessionFactoryBuilder().build(reader);
	         reader.close();
	     } catch (Exception e) {
	     System.out.println("SqlMapConfig 오류 : " + e);
	  }
	}
	 
	public static SqlSessionFactory getSqlSession(){ // 클래스 이름으로 sqlSession 호출?
	     return sqlSession;
	  }
}
