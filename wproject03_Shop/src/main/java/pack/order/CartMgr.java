package pack.order;

import java.util.Hashtable;

public class CartMgr {
	private Hashtable<String, OrderBean> hCart = new Hashtable<String, OrderBean>();
	
	// 장바구니 담기
	public void addCart(OrderBean oBean) {
		String product_no = oBean.getProduct_no(); // product_no 읽기
		int quantity = Integer.parseInt(oBean.getQuantity());
		
		if(quantity > 0) {
			// 동일 상품 주문인 경우 주문 수량만 증가시키기
			if(hCart.containsKey(product_no)) { // 이미 1회 이상 주문된 상품인 경우
				OrderBean temp = hCart.get(product_no);
				quantity += Integer.parseInt(temp.getQuantity());
				temp.setQuantity(Integer.toString(quantity));
				hCart.put(product_no, temp);
				
			}else {
				hCart.put(product_no, oBean); // Cart에 담기는 최초의 상품(상품의 종류는 다름)
			}
		}
		
	}

	
	// 장바구니 읽기
	public Hashtable<String, OrderBean> getCartList() {
		return hCart;
	}
	
	
	// 장바구니 내역 수정
	public void updateCart(OrderBean oBean) {
		String product_no = oBean.getProduct_no();
		hCart.put(product_no, oBean);
	}
	
	
	// 장바구니 내역 삭제
	public void deleteCart(OrderBean oBean) {
		String product_no = oBean.getProduct_no();
		hCart.remove(product_no); // DB X, RAM에 존재
	}
}
