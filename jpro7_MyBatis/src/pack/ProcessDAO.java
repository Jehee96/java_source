package pack;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

// 싱글톤!
public class ProcessDAO {
	private static ProcessDAO dao = new ProcessDAO();
	
	public static ProcessDAO getInstance() {
	
		return dao;
	}
	
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<DataDTO> selectDataAll() throws SQLException {
		SqlSession sqlSession = factory.openSession(); // Session 열기
		List list = sqlSession.selectList("selectDataAll");
		sqlSession.close();
		return list;
	}
	
	public DataDTO selectPart(String para) throws SQLException {
		SqlSession sqlSession = factory.openSession(); // Session 열기
		DataDTO dto = sqlSession.selectOne("selectDataById", para); // para : selectDataById의 code와 매핑됨
		sqlSession.close();
		return dto;
	}
	
	
	// 수동이라 commit이 없으면 추가가 되지 않는다.
	public void insData(DataDTO dto) throws SQLException {
		SqlSession sqlSession = factory.openSession(); // Session 열기
		sqlSession.insert("insertData", dto);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void upData(DataDTO dto) throws SQLException {
		SqlSession sqlSession = factory.openSession(true); // transaction 자동 처리 (insert, delete, update)
		sqlSession.update("updateData", dto);
		sqlSession.close();
	}
	
	public boolean delData(int para) {
		boolean result = false;
		SqlSession sqlSession = factory.openSession();
		
		try {
			int cou = sqlSession.delete("deleteData", para);
			if(cou > 0) result = true;
			
			sqlSession.commit();

		} catch (Exception e) {
			System.out.println("delData error : " + e);
			sqlSession.rollback();
			
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return result;
	}
}
