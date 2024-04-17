package pack04;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor	// 아규먼트 없는 생성자
//@AllArgsConstructor	// 아규먼트 있는 생성자
@Data	// 별걸 다 만들어준다
public class Ex31_StuDto {
	private String name;
	private int kor, eng;

}