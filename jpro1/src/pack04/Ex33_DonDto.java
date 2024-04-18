package pack04;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ex33_DonDto {
	private int sabun;			// 사번
	private String name;		// 이름
	private int gibon, ipsa;	// 기본급, 입사년도
}
