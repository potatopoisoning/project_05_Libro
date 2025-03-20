package pj.spring.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.spring.vo.*; 

public interface UserService {

	//-------------------------------------------------------------------------------------------------------------------------------	
	// ȸ��
	
	// ȸ������
	public int insert(UserVO userVO);
	
	// ȸ��Ż��
	public int deleteAccount(String user_id); 

//	// �α���
//	public UserVO selectLogin(String username);
	
	// ��ȸ�� �α���
	public GuestVO selectGuestLogin(GuestVO guestVO);

	// ���̵� �ߺ� üũ
	public int selectCntByUid(String user_id);
	
	// �ּҷ� ���
	public List<AddressBookVO> list(String user_id);
	
	// �ּҷ� ���
	public int addrinsert(AddressBookVO addressbookVO);
	
	// �ּҷ� ����
	public int addrdelete(String address_book_no);

	// �ּҷ� ����
	public AddressBookVO addrmodify(String address_book_no);

	// �⺻ �ּҷ� ������Ʈ
	public int updateAddrTop(String user_id);
	
	// �ּҷ� ������Ʈ
	public int addrmodifyOk(AddressBookVO addressbookVO);
	
	// ȸ�� ����
	public UserVO memberinfoselect(String user_id);

	// ȸ�� ���� ������Ʈ
	public int memberinfomodify(UserVO userVO);
	
	// �����ϱ�
	public int insertcontact(ContactVO contactVO);

	// �����ϱ� ÷������
	public int insertattachment(ContactVO contactVO);

	// �����ϱ� ÷������ ��
	public int insertattachmentdetail(ContactVO contactVO);
	
	// �����ϱ� ���
	public List<ContactVO> selectcontactlist(String user_id);
	
	// �����ϱ� ��
	public ContactVO selectcontact(String contact_no);

	// �����ϱ� ��
	public List<ContactVO> selectContactAttachment(String contact_no);

	// �����ϱ� ����
	public ContactVO updateContact(String contact_no);
	
	// �����ϱ� ������Ʈ
	public int updateokcontact(ContactVO contactVO);
	
	// �����ϱ� ÷������ ������Ʈ
	public List<ContactVO> selectattachment(String contact_no);
	
	// �����ϱ� ÷������ ����
	public int deletetattachment(String attachment_no);
	
	// �����ϱ� ÷������ �� ����
	public int deletetattachmentdetail(String attachment_no);
	
	// �����ϱ� ����
	public int deletetcontact(String contact_no);
	
	// �ֹ����� ���
	public List<OrderedVO> selectorderhistory(String user_id);
	
	// ��ȸ�� �ֹ����� ���
	public List<OrderedVO> selectOrderhistoryGuest(String guest_no);
	
	// ��� ��û
	public int updateOrderstatus1(String ordered_no);

	// ��� ��û
	public int updateOrderstatus2(String payment_no);
	
	// ����� ����
	public OrderedVO selectAddr(String ordered_no);
	
	// ����� ����
	public int updateAddr(OrderedVO orderedVO);

	// ��ҳ��� ���
	public List<OrderedVO> selectorderhistorycancel(String user_id);
	
	// ��ȸ�� ��ҳ��� ���
	public List<OrderedVO> selectOrderhistoryCancelGuest(String guest_no);

	// �ֹ����� ��
	public OrderedVO selectorderhistorydetail(String ordered_no);

	// �ֹ����� ��(��ǰ)
	public List<OrderedVO> selectorderhistorydetailp(String ordered_no);
	
	// ���� ������ ���
	public List<ReviewVO> selectReviewPossibleList(String user_id);

	// ���� �ۼ��� ���
	public List<ReviewVO> selectReviewList(String user_id);
	
	// ���� ��� �� ��ǰ ��ȸ
	public ProductVO selectProduct(String product_no);
	
	// ���� ���
	public int insertReview(ReviewVO reviewVO);
	
	// ���� ���� �� ��ȸ
	public ReviewVO selectReview(String review_no);
	
	// ���� ����
	public int updateReview(ReviewVO reviewVO);
	
	// ����   ����
	public int deleteReview(String review_no);
	
	// ���ø���Ʈ ��ȸ
	public List<WishlistVO> selectWishlist(String user_id);
	
	// īƮ �ߺ� ��ȸ
	public int selectDedupeCart(CartVO cartVO);

	// īƮ ���
	public int insertCart(CartVO cartVO);

	// īƮ ���
	public int insertCart_(CartVO cartVO);

	// ���ø���Ʈ �ߺ� ��ȸ
	public int selectDedupeWishlist(WishlistVO wishlistVO);
	
	// ���ø���Ʈ ���
	public int insertWishlist(WishlistVO wishlistVO);
	
	// ���ø���Ʈ ����
	public int deleteWishlist(String wishlist_no);
	
	// �ֱٺ���ǰ �ߺ� ��ȸ
	public int selectDedupeRecentlyproduct(RecentlyproductVO recentlyproductVO);
	
	// �ֱٺ���ǰ ��ȸ
	public List<RecentlyproductVO> selectRecentlyproduct(String user_id);
	
	// �ֱٺ���ǰ ���
	public int insertRecentlyproduct(RecentlyproductVO recentlyproductVO);
	
	// �ֱٺ���ǰ ����
	public int deleteRecentlyproduct(RecentlyproductVO recentlyproductVO);
	
	// �ֱٺ���ǰ ����
	public int deleteRecentlyproduct_(String recentlyproduct_no);
	
	//-------------------------------------------------------------------------------------------------------------------------------	
	// ��ȸ��
	
	// �ֱ� �� ��ǰ ��ȸ
	public List<RecentlyproductVO> getGuestRecentlyProductFromCookies(HttpServletRequest request);
	
	// �ֱ� �� ��ǰ ���
	public void addGuestRecentlyProductToCookies(String product_no, HttpServletRequest request, HttpServletResponse response);
	
	// �ֱ� �� ��ǰ ����
	public void removeGuestRecentlyProductFromCookies(String recentlyproduct_no, HttpServletRequest request, HttpServletResponse response);

	// ���ø���Ʈ ��ȸ
	public List<WishlistVO> getGuestWishlistFromCookies(HttpServletRequest request);

	// ���ø���Ʈ ���
	public void addGuestWishlistToCookies(String product_no, HttpServletRequest request, HttpServletResponse response);

	// ���ø���Ʈ ����
	public void removeGuestWishlistFromCookies(String wishlist_no, HttpServletRequest request, HttpServletResponse response);
	
	// ���̵� īƮ ��ȸ
	public List<ProductVO> selectCart(Map<String, Object> params, HttpServletRequest request);

	// īƮ ���� ������Ʈ
	public void updateCartForGuest(String product_no, int quantity, HttpServletRequest request, HttpServletResponse response);

	// īƮ ��ȸ
	public List<CartVO> getGuestCartFromCookies(HttpServletRequest request);
	
	// īƮ ���
	public void addGuestCartToCookies(String product_no, HttpServletRequest request, HttpServletResponse response);
	
	// īƮ ����
	public int removeGuestCartFromCookies(String cart_no, HttpServletRequest request, HttpServletResponse response);

	// �α��� �� ��ȸ�� ���ø���Ʈ DB�� �̵�
	public void migrateGuestDataToDB(HttpServletRequest request, String username, HttpServletResponse response);

}
