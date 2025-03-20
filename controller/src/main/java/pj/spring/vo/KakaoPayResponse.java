package pj.spring.vo;

import java.util.Map;

import lombok.Data;

@Data
public class KakaoPayResponse { // API ���� ������

    private String tid;                  // ���� ������ȣ
    private Map<String, Integer> amount; // JSON ������ amount ��ü�� Map���� ó��
    private String item_name;
    private String next_redirect_pc_url; // īī�������� ���� ��û �޽���(TMS)�� ������ ���� ����� ���� �Է�ȭ�� Redirect URL (īī�� �� ����)
    private String created_at; // ���� ���� �ð�
	
    @Override
    public String toString() {
        return "KakaoPayResponse{" +
                "tid='" + tid + '\'' +
                ", amount=" + amount +
                ", itemName='" + item_name + '\'' +
                ", createdAt='" + created_at + '\'' +
                '}';
    }

	public Map<String, Integer> getAmount() {
		return amount;
	}

	public void setAmount(Map<String, Integer> amount) {
		this.amount = amount;
	}

	public String getItem_name() {
		return item_name;
	}


	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}


	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getNext_redirect_pc_url() {
		return next_redirect_pc_url;
	}
	public void setNext_redirect_pc_url(String next_redirect_pc_url) {
		this.next_redirect_pc_url = next_redirect_pc_url;
	}
}