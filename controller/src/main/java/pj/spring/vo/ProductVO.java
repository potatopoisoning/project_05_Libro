package pj.spring.vo;

import java.util.List;

public class ProductVO extends AttachmentDetailVO {
	private String product_no;					// ��ǰ��ȣ
	private String product_name; 				// ��ǰ��
	private String product_description;			// ��ǰ�Ұ�
	private String product_author;				// ����
	private String product_author_description;	// ���� �Ұ�
	private String product_publisher;           // ���ǻ�
	private String product_price;				// ����
	private String product_isbn;				// ����ǥ�ص�����ȣ
	private String product_page;				// �ʼ�
	private String product_stock;				// ���
	private String product_status;				// ����
	private String product_created_at;			// �����
	private String product_create_id;			// ���id
	private String product_create_ip;			// ���ip
	private String product_update_at;			// ������
	private String product_update_id;			// ����id
	private String product_update_ip;			// ����ip
	private String user_id;                     // ID
	private String guest_no;					// guest��ȣ
	
	private String category_name;				// ī�װ� �̸�

	private String attachment_no;               // ÷������ ��ȣ
	private String attachment_product_no;       // ��ǰ ��ȣ
	private String attachment_type; 			// ÷������ Ÿ��
	private String attachment_detail_new_name;  // ÷������ �̸�
	private List<Integer> other_attachment_no;  // ��Ÿ �̹��� ��ȣ ����Ʈ
	
	
	
	private String review_starrating_avg;		// ���� ��� (�� ��ǰ�� ����)
	private String review_cnt;					// ���� ���� (�� ��ǰ�� ����)
	
	private String cart_no;						// ��ٱ��� ��ȣ
	private int cart_product_quantity;		// ��ٱ��� ��ǰ ����
	

	
	

	
	public String getAttachment_product_no() {
		return attachment_product_no;
	}
	public void setAttachment_product_no(String attachment_product_no) {
		this.attachment_product_no = attachment_product_no;
	}
	public List<Integer> getOther_attachment_no() {
		return other_attachment_no;
	}
	public void setOther_attachment_no(List<Integer> other_attachment_no) {
		this.other_attachment_no = other_attachment_no;
	}
	public int getCart_product_quantity() {
		return cart_product_quantity;
	}
	public void setCart_product_quantity(int cart_product_quantity) {
		this.cart_product_quantity = cart_product_quantity;
	}
	public String getGuest_no() {
		return guest_no;
	}
	public void setGuest_no(String guest_no) {
		this.guest_no = guest_no;
	}
	public String getCart_no() {
		return cart_no;
	}
	public void setCart_no(String cart_no) {
		this.cart_no = cart_no;
	}
	public String getProduct_publisher() {
		return product_publisher;
	}
	public void setProduct_publisher(String product_publisher) {
		this.product_publisher = product_publisher;
	}
	public String getAttachment_detail_new_name() {
		return attachment_detail_new_name;
	}
	public void setAttachment_detail_new_name(String attachment_detail_new_name) {
		this.attachment_detail_new_name = attachment_detail_new_name;
	}
	public String getProduct_no() {
		return product_no;
	}
	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public String getProduct_author() {
		return product_author;
	}
	public void setProduct_author(String product_author) {
		this.product_author = product_author;
	}
	public String getProduct_author_description() {
		return product_author_description;
	}
	public void setProduct_author_description(String product_author_description) {
		this.product_author_description = product_author_description;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	public String getProduct_isbn() {
		return product_isbn;
	}
	public void setProduct_isbn(String product_isbn) {
		this.product_isbn = product_isbn;
	}
	public String getProduct_page() {
		return product_page;
	}
	public void setProduct_page(String product_page) {
		this.product_page = product_page;
	}
	public String getProduct_stock() {
		return product_stock;
	}
	public void setProduct_stock(String product_stock) {
		this.product_stock = product_stock;
	}
	public String getProduct_status() {
		return product_status;
	}
	public void setProduct_status(String product_status) {
		this.product_status = product_status;
	}
	public String getProduct_created_at() {
		return product_created_at;
	}
	public void setProduct_created_at(String product_created_at) {
		this.product_created_at = product_created_at;
	}
	public String getProduct_create_id() {
		return product_create_id;
	}
	public void setProduct_create_id(String product_create_id) {
		this.product_create_id = product_create_id;
	}
	public String getProduct_create_ip() {
		return product_create_ip;
	}
	public void setProduct_create_ip(String product_create_ip) {
		this.product_create_ip = product_create_ip;
	}
	public String getProduct_update_at() {
		return product_update_at;
	}
	public void setProduct_update_at(String product_update_at) {
		this.product_update_at = product_update_at;
	}
	public String getProduct_update_id() {
		return product_update_id;
	}
	public void setProduct_update_id(String product_update_id) {
		this.product_update_id = product_update_id;
	}
	public String getProduct_update_ip() {
		return product_update_ip;
	}
	public void setProduct_update_ip(String product_update_ip) {
		this.product_update_ip = product_update_ip;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getAttachment_no() {
		return attachment_no;
	}
	public void setAttachment_no(String attachment_no) {
		this.attachment_no = attachment_no;
	}
	public String getAttachment_type() {
		return attachment_type;
	}
	public void setAttachment_type(String attachment_type) {
		this.attachment_type = attachment_type;
	}
	public String getReview_starrating_avg() {
		return review_starrating_avg;
	}
	public void setReview_starrating_avg(String review_starrating_avg) {
		this.review_starrating_avg = review_starrating_avg;
	}
	public String getReview_cnt() {
		return review_cnt;
	}
	public void setReview_cnt(String review_cnt) {
		this.review_cnt = review_cnt;
	}
	
	
	
	
}
