package pj.spring.vo;

public class WishlistVO extends ReviewVO {
	private String wishlist_no;					// ���ø���Ʈ ��ȣ
	private int wishlist_product_quantity;	// ��ǰ ����
	private String wishlist_create_at;			// �����
	private String wishlist_create_id;			// ���id
	private String wishlist_create_ip;			// ���ip
	private String wishlist_update_at;			// ������
	private String wishlist_update_id;			// ����id
	private String wishlist_update_ip;			// ����ip
	private String user_id;
	
	private String product_no;					// ��ǰ ��ȣ
	
	
	
	public int getWishlist_product_quantity() {
		return wishlist_product_quantity;
	}
	public void setWishlist_product_quantity(int wishlist_product_quantity) {
		this.wishlist_product_quantity = wishlist_product_quantity;
	}
	public String getProduct_no() {
		return product_no;
	}
	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getWishlist_no() {
		return wishlist_no;
	}
	public void setWishlist_no(String wishlist_no) {
		this.wishlist_no = wishlist_no;
	}
	public String getWishlist_create_at() {
		return wishlist_create_at;
	}
	public void setWishlist_create_at(String wishlist_create_at) {
		this.wishlist_create_at = wishlist_create_at;
	}
	public String getWishlist_create_id() {
		return wishlist_create_id;
	}
	public void setWishlist_create_id(String wishlist_create_id) {
		this.wishlist_create_id = wishlist_create_id;
	}
	public String getWishlist_create_ip() {
		return wishlist_create_ip;
	}
	public void setWishlist_create_ip(String wishlist_create_ip) {
		this.wishlist_create_ip = wishlist_create_ip;
	}
	public String getWishlist_update_at() {
		return wishlist_update_at;
	}
	public void setWishlist_update_at(String wishlist_update_at) {
		this.wishlist_update_at = wishlist_update_at;
	}
	public String getWishlist_update_id() {
		return wishlist_update_id;
	}
	public void setWishlist_update_id(String wishlist_update_id) {
		this.wishlist_update_id = wishlist_update_id;
	}
	public String getWishlist_update_ip() {
		return wishlist_update_ip;
	}
	public void setWishlist_update_ip(String wishlist_update_ip) {
		this.wishlist_update_ip = wishlist_update_ip;
	}
	
	
}
