package pack;

import java.util.List;

import javax.sound.sampled.SourceDataLine;

import domain.SangpumTable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class SangpumCrud {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gojpa");
		
		// EntityManager : 내부적으로 thread 단위로 작업(절대적)
		EntityManager em = emf.createEntityManager();
		// EntityTransaction : Transaction 처리가 목적
		EntityTransaction transaction = em.getTransaction();
		
		
		// 02. INSERT 자료 추가
//		try {
//			transaction.begin();
//			SangpumTable sangtab = new SangpumTable(8, "도시락", 3, 6000);
//			em.persist(sangtab);
//			transaction.commit();
//			
//		} catch (Exception e) {
//			System.out.println("ins error : " + e);
//			transaction.rollback();
//			return;
//		}
		
		
		// 03. UPDATE 자료 수정
//		try {
//			transaction.begin();
//			SangpumTable sangtab = em.find(SangpumTable.class, "8"); // 대상을 읽어야 한다.
//			if(sangtab == null) {
//				System.out.println("해당 없음");
//			}else {
//				String newName = "마스크";
//				sangtab.setName(newName);
//				transaction.commit();
//			}
//			
//		} catch (Exception e) {
//			System.out.println("up error : " + e);
//			transaction.rollback();
//			return;
//		}
		

		
		// 04. DELETE 자료 삭제
		try {
			transaction.begin();
			
			int findCode = 6;
			SangpumTable sangtab = em.find(SangpumTable.class, findCode);
			if(sangtab == null) {
				System.out.println("해당 없음");
				transaction.rollback();
			}else {
				em.remove(sangtab);
				System.out.printf("자료 삭제됨 : %s", findCode);
				transaction.commit();
			}
			
		} catch (Exception e) {
			System.out.println("del error : " + e);
			transaction.rollback();
			return;
		}
		
		

		// JPA를 사용한 DML 처리(SELECT, DELETE, UPDATD)
		// 01. SELECT
		try {
			System.out.println("전체 자료 읽기 1");
			CriteriaBuilder cb = em.getCriteriaBuilder();
			
			CriteriaQuery<SangpumTable> query = cb.createQuery(SangpumTable.class);
			
			// 조회의 시작임을 의미하는 Root 객체 생성
			Root<SangpumTable> root = query.from(SangpumTable.class); // 조회가 이루어짐
			query.select(root);
			List<SangpumTable> resultList = em.createQuery(query).getResultList(); // SELECT의 결과를 resultList가 가진다.
			
			for(SangpumTable st:resultList) {
				System.out.println(st.getCode() + " " + st.getName() + " " + st.getSu() + " " + st.getDan());
						
			}
			
			System.out.println("\n전체 자료 읽기 2");
			// TypedQuery를 이용해 JPQL 사용
			// select s from SangpumTable s은 SQL문이 아닌JPQL이다.
			// TypedQuery<SangpumTable> queryql1 = em.createQuery("select s from SangpumTable s", SangpumTable.class);
			// List<SangpumTable> list = queryql1.getResultList();
			
			// 위 두줄을 한줄로 표현
			List<SangpumTable> list = em.createQuery("select s from SangpumTable s", SangpumTable.class).getResultList();
			
			for(SangpumTable st:list) {
				System.out.println(st.getCode() + " " + st.getName() + " " + st.getSu() + " " + st.getDan());
						
			}
			
			
			System.out.println("\n부분 자료 읽기 1");
			int findId = 1; // String findId = "1"; PK 칼럼이 대상이다. 아무나 못 들어옴
			SangpumTable sangtab = em.find(SangpumTable.class, findId);
			if(sangtab == null) {
				System.out.println("자료 없음");
			}else {
				System.out.printf("%s %s %s %s \n", sangtab.getCode(), sangtab.getName(), sangtab.getSu(), sangtab.getDan());
			}
			
			System.out.println("\n부분 자료 읽기 2");
			TypedQuery<SangpumTable> typedQuery = em.createQuery(query.where(cb.equal(root.get("name"), "장갑")));
			List<SangpumTable> resultList2 = typedQuery.getResultList();
			for(SangpumTable sangtab2:resultList2) {
				System.out.printf("%s %s %s %s \n", sangtab.getCode(), sangtab.getName(), sangtab.getSu(), sangtab.getDan());
			}

		} catch (Exception e) {
			System.out.println("error : " + e);
			em.close();
			emf.close();	// 필수
		}
	}

}
