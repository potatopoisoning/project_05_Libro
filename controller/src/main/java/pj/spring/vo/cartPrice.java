package pj.spring.vo;

public class cartPrice {
    private int totalProductPrice;  // ��ǰ ���� * ����
    private int totalProductQuantity;  // ��ǰ ����
    
    // �ش� �����ڰ� �־�� �մϴ�
    public cartPrice(int totalProductPrice, int totalProductQuantity) {
        this.totalProductPrice = totalProductPrice;
        this.totalProductQuantity = totalProductQuantity;
    }
    
	public int getTotalProductPrice() {
		return totalProductPrice;
	}
	public void setTotalProductPrice(int totalProductPrice) {
		this.totalProductPrice = totalProductPrice;
	}
	public int getTotalProductQuantity() {
		return totalProductQuantity;
	}
	public void setTotalProductQuantity(int totalProductQuantity) {
		this.totalProductQuantity = totalProductQuantity;
	}

    
}

