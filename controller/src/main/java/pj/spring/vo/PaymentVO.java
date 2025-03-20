package pj.spring.vo;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pj.spring.controller.KakaoPayController;

public class PaymentVO extends OrderedDetailVO {
	private String payment_no;				// ������ȣ
	private String payment_price;			// �����ݾ�
	private String payment_refund_price;	// ȯ�ұݾ�
	private String payment_balance_price;	// �ܿ��ݾ�
	private String payment_service_fee;		// �����̿������
	private String payment_date;			// ������
	private String payment_refund_date;		// ȯ����
	private String payment_type;			// ����Ÿ��
	private String payment_method;			// ��������
	private String payment_create_at;		// �����
	private String payment_create_id;		// ���id
	private String payment_create_ip;		// ���ip
	private String payment_update_at;		// ������
	private String payment_update_id;		// ����id
	private String payment_update_ip;		// ����ip
	private String user_id;
	private String guest_no;
	
	
	private String paymentTotalAmount;
	
	
	
	private int cart_product_quantity;		// ī�� ��ǰ ����
	
	private String product_price;			// ��ǰ �ݾ�
	
	private String ordered_detail_total_price;	// �ֹ� �ѱݾ�
	
	private static final Logger log = LoggerFactory.getLogger(KakaoPayController.class);
	
	public PaymentVO insertPaymentData(Map<String, Object> paymentData, String userId) {
	    log.debug("Received paymentData: {}", paymentData);
	    log.debug("Received userId: {}", userId);

	    try {
	        // ������ ����
	        if (!paymentData.containsKey("amount") || paymentData.get("amount") == null) {
	            log.error("Missing or null amount in paymentData");
	            return null;
	        }

	        PaymentVO paymentVO = new PaymentVO();
	        paymentVO.setPayment_price(paymentData.get("amount").toString()); // �� ���� �ݾ�
	        paymentVO.setPayment_refund_price("0"); // ȯ�� �ݾ� �⺻��
	        paymentVO.setPayment_balance_price("0"); // �ܾ� �⺻��
	        paymentVO.setPayment_service_fee("0"); // ���� ������ �⺻��
	        paymentVO.setPayment_create_id(userId); // ������ ID
	        paymentVO.setUser_id(userId); // ����� ID
	        // payment_type, payment_method, payment_date�� DB default ���� ����

	        log.debug("Created PaymentVO: {}", paymentVO);
	        return paymentVO;
	    } catch (Exception e) {
	        log.error("Error while constructing PaymentVO: {}", e.getMessage(), e);
	        return null;
	    }
	}

	
	
	
	
	public String getPaymentTotalAmount() {
		return paymentTotalAmount;
	}
	public void setPaymentTotalAmount(String paymentTotalAmount) {
		this.paymentTotalAmount = paymentTotalAmount;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getGuest_no() {
		return guest_no;
	}
	public void setGuest_no(String guest_no) {
		this.guest_no = guest_no;
	}
	public String getOrdered_detail_total_price() {
		return ordered_detail_total_price;
	}
	public void setOrdered_detail_total_price(String ordered_detail_total_price) {
		this.ordered_detail_total_price = ordered_detail_total_price;
	}
	public int getCart_product_quantity() {
		return cart_product_quantity;
	}
	public void setCart_product_quantity(int cart_product_quantity) {
		this.cart_product_quantity = cart_product_quantity;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	public String getPayment_no() {
		return payment_no;
	}
	public void setPayment_no(String payment_no) {
		this.payment_no = payment_no;
	}
	public String getPayment_price() {
		return payment_price;
	}
	public void setPayment_price(String payment_price) {
		this.payment_price = payment_price;
	}
	public String getPayment_refund_price() {
		return payment_refund_price;
	}
	public void setPayment_refund_price(String payment_refund_price) {
		this.payment_refund_price = payment_refund_price;
	}
	public String getPayment_balance_price() {
		return payment_balance_price;
	}
	public void setPayment_balance_price(String payment_balance_price) {
		this.payment_balance_price = payment_balance_price;
	}
	public String getPayment_service_fee() {
		return payment_service_fee;
	}
	public void setPayment_service_fee(String payment_service_fee) {
		this.payment_service_fee = payment_service_fee;
	}
	public String getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}
	public String getPayment_refund_date() {
		return payment_refund_date;
	}
	public void setPayment_refund_date(String payment_refund_date) {
		this.payment_refund_date = payment_refund_date;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public String getPayment_create_at() {
		return payment_create_at;
	}
	public void setPayment_create_at(String payment_create_at) {
		this.payment_create_at = payment_create_at;
	}
	public String getPayment_create_id() {
		return payment_create_id;
	}
	public void setPayment_create_id(String payment_create_id) {
		this.payment_create_id = payment_create_id;
	}
	public String getPayment_create_ip() {
		return payment_create_ip;
	}
	public void setPayment_create_ip(String payment_create_ip) {
		this.payment_create_ip = payment_create_ip;
	}
	public String getPayment_update_at() {
		return payment_update_at;
	}
	public void setPayment_update_at(String payment_update_at) {
		this.payment_update_at = payment_update_at;
	}
	public String getPayment_update_id() {
		return payment_update_id;
	}
	public void setPayment_update_id(String payment_update_id) {
		this.payment_update_id = payment_update_id;
	}
	public String getPayment_update_ip() {
		return payment_update_ip;
	}
	public void setPayment_update_ip(String payment_update_ip) {
		this.payment_update_ip = payment_update_ip;
	}
	
	
}
