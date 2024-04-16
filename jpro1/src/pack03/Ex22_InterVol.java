package pack03;

//public interface Ex22_InterVol {

//인터페이스간 상속(extends)도 가능함
public interface Ex22_InterVol extends Ex22_VolEtc {
	String vol = "볼륨";
	
	void volUp(int v);
	void volDown(int v);
}
