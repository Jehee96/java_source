package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// sangdata 테이블과 연결

@Entity // sangdata 테이블과 매핑하겠다는 뜻
@Table(name = "sangdata")	// 
public class SangpumTable {
	@Id // PK칼럼이라는 것을 알려줌
	@Column(name = "code")
	private int code;
	
	@Column(name = "sang", nullable = false) // name은 null을 허용하지 않음
	private String name;
	private int su;
	private int dan;
	
	
	public SangpumTable() {
		// JPA에서는 생성자 필수
		
	}
	
	public SangpumTable(int code, String name, int su, int dan) {
		this.code = code;
		this.name = name;
		this.su = su;
		this.dan = dan;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSu() {
		return su;
	}

	public void setSu(int su) {
		this.su = su;
	}

	public int getDan() {
		return dan;
	}

	public void setDan(int dan) {
		this.dan = dan;
	}

}
