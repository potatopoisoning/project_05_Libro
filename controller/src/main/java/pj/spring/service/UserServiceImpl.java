package pj.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj.spring.dao.UserDAO;
import pj.spring.vo.AddressBookVO;
import pj.spring.vo.CartVO;
import pj.spring.vo.ContactVO;
import pj.spring.vo.GuestVO;
import pj.spring.vo.OrderedVO;
import pj.spring.vo.ProductVO;
import pj.spring.vo.RecentlyproductVO;
import pj.spring.vo.ReviewVO;
import pj.spring.vo.UserVO;
import pj.spring.vo.WishlistVO;

@Service // ���������� ����ϴ� ���� ��ü�� �������� �����Ͽ� ����
public class UserServiceImpl implements UserService {
	
	//-------------------------------------------------------------------------------------------------------------------------------	
	// ȸ��
	
	@Autowired
	public UserDAO userDAO;
	
	// ȸ������
	@Override
	public int insert(UserVO userVO){
		return userDAO.insert(userVO);
	}

	// ȸ��Ż��
	@Override
	public int deleteAccount(String user_id) {
		return userDAO.deleteAccount(user_id);
	}
	
//	// �α���
//	@Override
//	public UserVO selectLogin(String username){
//		return userDAO.selectLogin(username);
//	}
	
	// ��ȸ�� �α���
	@Override
	public GuestVO selectGuestLogin(GuestVO guestVO) {
		return userDAO.selectGuestLogin(guestVO);
	}

	// ���̵� �ߺ� üũ
	@Override
	public int selectCntByUid(String user_id) {
		return userDAO.selectCntByUid(user_id);
	}
	
	// �ּҷ� ���
	@Override
	public List<AddressBookVO> list(String user_id) {
		return userDAO.list(user_id);
	}

	// �ּҷ� ���
	@Override
	public int addrinsert(AddressBookVO addressbookVO) {
		return userDAO.addrinsert(addressbookVO);
	}

	// �ּҷ� ����
	@Override
	public int addrdelete(String address_book_no) {
		return userDAO.addrdelete(address_book_no);
	}

	// �ּҷ� ����
	@Override
	public AddressBookVO addrmodify(String address_book_no) {
		return userDAO.addrmodify(address_book_no);
	}
	
	// �⺻ �ּҷ� ������Ʈ
	@Override
	public int updateAddrTop(String user_id) {
		return userDAO.updateAddrTop(user_id);
	}

	// �ּҷ� ������Ʈ
	@Override
	public int addrmodifyOk(AddressBookVO addressbookVO) {
		return userDAO.addrmodifyOk(addressbookVO);
	}

	// ȸ�� ����
	@Override
	public UserVO memberinfoselect(String user_id) {
		return userDAO.memberinfoselect(user_id);
	}

	// ȸ�� ���� ������Ʈ
	@Override
	public int memberinfomodify(UserVO userVO) {
		return userDAO.memberinfomodify(userVO);
	}

	// �����ϱ�
	@Override
	public int insertcontact(ContactVO contactVO) {
		return userDAO.insertcontact(contactVO);
	}

	// �����ϱ� ÷������
	@Override
	public int insertattachment(ContactVO contactVO) {
		return userDAO.insertattachment(contactVO);
	}

	// �����ϱ� ÷������ ��
	@Override
	public int insertattachmentdetail(ContactVO contactVO) {
		return userDAO.insertattachmentdetail(contactVO);
	}

	// �����ϱ� ���
	@Override
	public List<ContactVO> selectcontactlist(String user_id) {
		return userDAO.selectcontactlist(user_id);
	}

	// �����ϱ� ��
	@Override
	public ContactVO selectcontact(String contact_no) {
		return userDAO.selectcontact(contact_no);
	}

	// �����ϱ� ��
	@Override
	public List<ContactVO> selectContactAttachment(String contact_no) {
		return userDAO.selectContactAttachment(contact_no);
	}

	// �����ϱ� ����
	@Override
	public ContactVO updateContact(String contact_no) {
		return userDAO.updatecontact(contact_no);
	}

	// �����ϱ� ������Ʈ
	@Override
	public int updateokcontact(ContactVO contactVO) {
		return userDAO.updateokcontact(contactVO);
	}
	
	// �����ϱ� ÷������ ������Ʈ
	@Override
	public List<ContactVO> selectattachment(String contact_no) {
		return userDAO.selectattachment(contact_no);
	}
	
	// �����ϱ� ÷������ �� ������Ʈ
	@Override
	public int deletetattachment(String attachment_no) {
		return userDAO.deleteAttachment(attachment_no);
	}
	
	// �����ϱ� ÷������ �� ������Ʈ
	@Override
	public int deletetattachmentdetail(String attachment_no) {
		return userDAO.deleteAttachmentDetail(attachment_no);
	}
	
	// �����ϱ� ����
	@Override
	public int deletetcontact(String contact_no) {
		return userDAO.deletecontact(contact_no);
	}
	
	// �ֹ����� ���
	@Override
	public List<OrderedVO> selectorderhistory(String user_id) {
		return userDAO.selectorderhistory(user_id);
	}
	
	// ��ȸ�� �ֹ����� ���
	@Override
	public List<OrderedVO> selectOrderhistoryGuest(String guest_no) {
		return userDAO.selectOrderhistoryGuest(guest_no);
	}
	
	// �ּ� ��û
	@Override
	public int updateOrderstatus1(String ordered_no) {
		return userDAO.updateOrderstatus1(ordered_no);
	}

	// �ּ� ��û
	@Override
	public int updateOrderstatus2(String payment_no) {
		return userDAO.updateOrderstatus2(payment_no);
	}
	
	// ����� ����
	@Override
	public OrderedVO selectAddr(String ordered_no) {
		return userDAO.selectAddr(ordered_no);
	}

	// ����� ����
	@Override
	public int updateAddr(OrderedVO orderedVO) {
		return userDAO.updateAddr(orderedVO);
	}

	// ��ҳ��� ���
	@Override
	public List<OrderedVO> selectorderhistorycancel(String user_id) {
		return userDAO.selectorderhistorycancel(user_id);
	}
	
	// ��ȸ�� ��ҳ��� ���
	@Override
	public List<OrderedVO> selectOrderhistoryCancelGuest(String guest_no) {
		return userDAO.selectOrderhistoryCancelGuest(guest_no);
	}

	// �ֹ����� ��
	@Override
	public OrderedVO selectorderhistorydetail(String ordered_no) {
		return userDAO.selectOrderhistorydetail(ordered_no);
	}

	// �ֹ����� ��(��ǰ)
	@Override
	public List<OrderedVO> selectorderhistorydetailp(String ordered_no) {
		return userDAO.selectOrderhistorydetailp(ordered_no);
	}

	// ���� ������ ���
	@Override
	public List<ReviewVO> selectReviewPossibleList(String user_id) {
		return userDAO.selectReviewPossibleList(user_id);
	}

	// ���� �ۼ��� ���
	@Override
	public List<ReviewVO> selectReviewList(String user_id) {
		return userDAO.selectReviewList(user_id);
	}

	// ���� ��� �� ��ǰ ��ȸ
	@Override
	public ProductVO selectProduct(String product_no) {
		return userDAO.selectProduct(product_no);
	}

	// ���� ���
	@Override
	public int insertReview(ReviewVO reviewVO) {
		return userDAO.insertReview(reviewVO);
	}
	
	// ���� ���� �� ��ȸ
	@Override
	public ReviewVO selectReview(String review_no) {
		return userDAO.selectReview(review_no);
	}

	// ���� ����
	@Override
	public int updateReview(ReviewVO reviewVO) {
		return userDAO.updateReview(reviewVO);
	}

	// ����   ����
	@Override
	public int deleteReview(String review_no) {
		return userDAO.deleteReview(review_no);
	}

	// īƮ�� �̵�
	@Override
	public int insertCart(CartVO cartVO) {
		return userDAO.insertCart(cartVO);
	}

	// īƮ�� �̵�
	@Override
	public int insertCart_(CartVO cartVO) {
		return userDAO.insertCart_(cartVO);
	}
	
	// īƮ �ߺ� ��ȸ
	@Override
	public int selectDedupeCart(CartVO cartVO) {
		return userDAO.selectDedupeCart(cartVO);
	}

	// ���ø���Ʈ ��ȸ
	@Override
	public List<WishlistVO> selectWishlist(String user_id) {
		return userDAO.selectWishlist(user_id);
	}
	
	// ���ø���Ʈ �ߺ� ��ȸ
	@Override
	public int selectDedupeWishlist(WishlistVO wishlistVO) {
		return userDAO.selectDedupeWishlist(wishlistVO);
	}

	// ���ø���Ʈ ���
	@Override
	public int insertWishlist(WishlistVO wishlistVO) {
		return userDAO.insertWishlist(wishlistVO);
	}

	// ���ø���Ʈ ����
	@Override
	public int deleteWishlist(String wishlist_no) {
		return userDAO.deleteWishlist(wishlist_no);
	}
	
	// �ֱٺ���ǰ �ߺ� ��ȸ
	@Override
	public int selectDedupeRecentlyproduct(RecentlyproductVO recentlyproductVO) {
		return userDAO.selectDedupeRecentlyproduct(recentlyproductVO);
	}
	
	// �ֱٺ���ǰ ��ȸ
	@Override
	public List<RecentlyproductVO> selectRecentlyproduct(String user_id) {
		return userDAO.selectRecentlyproduct(user_id);
	}
	
	// �ֱٺ���ǰ ���
	@Override
	public int insertRecentlyproduct(RecentlyproductVO recentlyproductVO) {
		return userDAO.insertRecentlyproduct(recentlyproductVO);
	}

	// �ֱٺ���ǰ ����
	@Override
	public int deleteRecentlyproduct(RecentlyproductVO recentlyproductVO) {
		return userDAO.deleteRecentlyproduct(recentlyproductVO);
	}
	
	// �ֱٺ���ǰ ����
	@Override
	public int deleteRecentlyproduct_(String recentlyproduct_no) {
		return userDAO.deleteRecentlyproduct_(recentlyproduct_no);
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------	
	// ��ȸ��
	
	// �ֱ� �� ��ǰ ��ȸ
	@Override
	public List<RecentlyproductVO> getGuestRecentlyProductFromCookies(HttpServletRequest request) {
		List<RecentlyproductVO> list = new ArrayList<RecentlyproductVO>();
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			for (int i = cookies.length - 1; i >= 0; i--) {
				Cookie cookie = cookies[i];
				if (cookie.getName().startsWith("recentlyproduct_")) {
					String product_no = cookie.getValue();
					
					// product_no�� null���� Ȯ��
					if (product_no == null || product_no.isEmpty()) {
						System.out.println("��Ű�� ����� product_no�� ��� �ֽ��ϴ�.");
						continue;
					}
					
					ReviewVO product = userDAO.selectProductForGuest(product_no);
					
					// product�� null���� Ȯ��
					if (product == null) {
						System.out.println("��ǰ ������ ã�� �� �����ϴ�. product_no: " + product_no);
						continue;
					}
					
					RecentlyproductVO vo = new RecentlyproductVO();
					vo.setProduct_no(product.getProduct_no());
					vo.setProduct_name(product.getProduct_name());
					vo.setProduct_author(product.getProduct_author());
					vo.setProduct_publisher(product.getProduct_publisher());
					vo.setProduct_price(product.getProduct_price());
					vo.setReview_starrating_avg(product.getReview_starrating_avg());
					vo.setReview_cnt(product.getReview_cnt());
					vo.setReview_starrating(product.getReview_starrating());
					vo.setProduct_status(product.getProduct_status());
					vo.setAttachment_detail_new_name(product.getAttachment_detail_new_name());
					vo.setRecentlyproduct_no(cookie.getName().substring("recentlyproduct_".length()));
					
					list.add(vo);
				}
			}
		} else {
			System.out.println("��û�� ��Ű�� �����ϴ�.");
		}
		return list;
	}
	
	// �ֱ� �� ��ǰ ���
	@Override
	public void addGuestRecentlyProductToCookies(String product_no, HttpServletRequest request,
			HttpServletResponse response) {
		// product_no ��ȿ�� �˻�
		if (product_no == null || product_no.trim().isEmpty()) {
			System.out.println("��ȿ���� ���� ��ǰ ��ȣ: " + product_no);
			return;
		}
		
		// ���� ��Ű���� ������ product_no�� �ִ��� Ȯ�� �� ����
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().startsWith("recentlyproduct_") && product_no.equals(cookie.getValue())) {
					System.out.println("�̹� ��ϵ� ��ǰ�Դϴ�. product_no: " + product_no);
					// ���� ��ǰ ��Ű ����
					cookie.setMaxAge(0); // ��Ű ����
					cookie.setPath("/"); // ��� ����
					response.addCookie(cookie); // ������ ��Ű ���信 �߰�
				}
			}
		}
		
		String recentlyproductId = UUID.randomUUID().toString();
		Cookie cookie = new Cookie("recentlyproduct_" + recentlyproductId, product_no);
		cookie.setPath("/");
		cookie.setMaxAge(60 * 60 * 24 * 7);
		cookie.setSecure(request.isSecure());
		
		// ��Ű�� ���信 �߰�
		response.addCookie(cookie);
		
		// HttpOnly �Ӽ��� ���� ����
		String cookieHeader = String.format(
				"recentlyproduct_%s=%s; Path=/; Max-Age=%d; %s HttpOnly",
				recentlyproductId, product_no, 60 * 60 * 24 * 7,
				request.isSecure() ? "Secure;" : ""
				);
		response.addHeader("Set-Cookie", cookieHeader);
		
//	    // ���ο� ��Ű ����
//	    String recentlyproductId = UUID.randomUUID().toString(); // ������ UUID ����
//	    Cookie cookie = new Cookie("recentlyproduct_" + recentlyproductId, product_no); // ��Ű �̸��� �� ����
//	    cookie.setPath("/"); // ��� ��ο��� ��ȿ
//	    cookie.setMaxAge(60 * 60 * 24 * 7); // 7�� ����
//	    cookie.setHttpOnly(true); // JavaScript���� ���� �Ұ� (���� ��ȭ)
//	    cookie.setSecure(request.isSecure()); // HTTPS ȯ�濡���� ���� (���� ��ȭ)
		
	}
	
	// �ֱ� �� ��ǰ ����
	@Override
	public void removeGuestRecentlyProductFromCookies(String recentlyproduct_no, HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		System.out.println("cookies" + cookies);
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println("name::"+cookie.getName().startsWith("recentlyproduct_"));
				System.out.println("value::"+cookie.getValue());
				System.out.println("recentlyproduct_no::"+recentlyproduct_no);
				if (cookie.getName().startsWith("recentlyproduct_") && cookie.getValue().equals(recentlyproduct_no)) {
					cookie.setMaxAge(0);
					cookie.setPath("/");
					response.addCookie(cookie);
					System.out.println("Deleting cookie: " + cookie.getName());
				}
			}
		}
	}

	// ���ø���Ʈ ��ȸ
	@Override
	public List<WishlistVO> getGuestWishlistFromCookies(HttpServletRequest request) {
		List<WishlistVO> list = new ArrayList<WishlistVO>();
		Cookie[] cookies = request.getCookies();

	    if (cookies != null) {
	    	for (int i = cookies.length - 1; i >= 0; i--) {
	    		Cookie cookie = cookies[i];
	            if (cookie.getName().startsWith("wishlist_")) {
	            	System.out.println(cookie.getValue());
	                String product_no = cookie.getValue();
	                
	                // product_no�� null���� Ȯ��
	                if (product_no == null || product_no.isEmpty()) {
	                    System.out.println("��Ű�� ����� product_no�� ��� �ֽ��ϴ�.");
	                    continue;
	                }

	                ReviewVO product = userDAO.selectProductForGuest(product_no);

	                // product�� null���� Ȯ��
	                if (product == null) {
	                    System.out.println("��ǰ ������ ã�� �� �����ϴ�. product_no: " + product_no);
	                    continue;
	                }

					WishlistVO vo = new WishlistVO();
					vo.setProduct_no(product.getProduct_no());
					vo.setProduct_name(product.getProduct_name());
					vo.setProduct_author(product.getProduct_author());
					vo.setProduct_publisher(product.getProduct_publisher());
					vo.setProduct_price(product.getProduct_price());
					vo.setReview_starrating_avg(product.getReview_starrating_avg());
					vo.setReview_cnt(product.getReview_cnt());
					vo.setProduct_status(product.getProduct_status());
					vo.setAttachment_detail_new_name(product.getAttachment_detail_new_name());
					vo.setWishlist_no(cookie.getName().substring("wishlist_".length()));

	                list.add(vo);
	            }
	        }
	    } else {
	        System.out.println("��û�� ��Ű�� �����ϴ�.");
	    }
	    return list;
	}

	// ���ø���Ʈ ���
	@Override
	public void addGuestWishlistToCookies(String product_no, HttpServletRequest request, HttpServletResponse response) {
		  // product_no ��ȿ�� �˻�
	    if (product_no == null || product_no.trim().isEmpty()) {
	        System.out.println("��ȿ���� ���� ��ǰ ��ȣ: " + product_no);
	        return;
	    }
		
	    Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if (cookie.getName().startsWith("wishlist_") && product_no.equals(cookie.getValue())) {
	                System.out.println("�̹� ��ϵ� ��ǰ�Դϴ�. product_no: " + product_no);
	                return; // �ߺ��� ��ǰ�̸� �߰����� ����
	            }
	        }
	    }
	    
		String wishlistId = UUID.randomUUID().toString(); // ������ UUID ����
		Cookie cookie = new Cookie("wishlist_" + wishlistId, String.valueOf(product_no)); // ��Ű �̸��� �ϰ��ǰ� ����
		cookie.setPath("/"); // ��Ű�� ��� ��ο��� ��ȿ�ϵ��� ����
		cookie.setMaxAge(60 * 60 * 24 * 7); // 7�� ����
		response.addCookie(cookie); // ��Ű�� Ŭ���̾�Ʈ�� ����
	}

	// ���ø���Ʈ ����
	@Override
	public void removeGuestWishlistFromCookies(String wishlist_no, HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		System.out.println("cookies" + cookies);
		if (cookies != null) {
			for (Cookie cookie : cookies) {
//				System.out.println("name::"+cookie.getName().startsWith("wishlist_"));
//				System.out.println("value::"+cookie.getValue());
//				System.out.println("wishlist_no::"+wishlist_no);
				if (cookie.getName().startsWith("wishlist_") && cookie.getValue().equals(wishlist_no)) {
					cookie.setMaxAge(0);
					cookie.setPath("/");
					response.addCookie(cookie);
					System.out.println("Deleting cookie: " + cookie.getName());
				}
			}
		}
	}
	
	// ���̵� īƮ ��ȸ
	@Override
	public List<ProductVO> selectCart(Map<String, Object> params, HttpServletRequest request) {
	    List<ProductVO> list = new ArrayList<ProductVO>();
	    Cookie[] cookies = request.getCookies();

	    if (cookies != null) {
	        for (int i = cookies.length - 1; i >= 0; i--) {
	            Cookie cookie = cookies[i];
	            if (cookie.getName().startsWith("cart_")) {
		            ProductVO product = userDAO.selectCartListGuest(cookie.getValue());
	
		            // ��ǰ�� null�� �ƴϸ� CartVO�� �� ����
		            if (product != null) {
		                CartVO vo = new CartVO();
		                vo.setProduct_no(product.getProduct_no());
		                vo.setProduct_name(product.getProduct_name());
		                vo.setProduct_author(product.getProduct_author());
		                vo.setProduct_publisher(product.getProduct_publisher());
		                vo.setProduct_price(product.getProduct_price());
		                vo.setCategory_name(product.getCategory_name());
		                vo.setProduct_created_at(product.getProduct_created_at());
		                vo.setAttachment_detail_new_name(product.getAttachment_detail_new_name());
	
		                list.add(vo);
		            } else {
		                System.out.println("��ǰ ������ ã�� �� �����ϴ�. product_no: " + cookie.getValue());
		            }
		        }
	        }
	    } else {
        System.out.println("��ٱ��Ͽ� ��ǰ�� �����ϴ�.");
    }
	    return list;
	}
	
	// īƮ ���� ������Ʈ
	@Override
	public void updateCartForGuest(String product_no, int quantity, HttpServletRequest request, HttpServletResponse response) {
	    // ���� ��ٱ��� ��Ű�� �˻� �� ����
	    Cookie[] cookies = request.getCookies();
	    String updatedCartCookieName = null;

	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if (cookie.getName().startsWith("cart_") && cookie.getValue().contains(product_no)) {
	                String cartCookieName = cookie.getName();
	                // ���� ��Ű ���� ������Ʈ
	                updatedCartCookieName = updateProductQuantityInCart(cartCookieName, product_no, quantity);
	                
	                // ���� ��Ű ����
	                cookie.setMaxAge(0);
	                cookie.setPath("/");
	                response.addCookie(cookie);
	                break;
	            }
	        }
	    }

	    // ���ο� ��Ű �̸� ���� (��: cart_ + product_no)
	    String newCookieName = "cart_" + product_no + "_" + quantity;

	    Cookie newCookie = new Cookie(newCookieName, product_no);
	    newCookie.setMaxAge(60 * 60 * 24 * 7); // 7�� ���� ����
	    newCookie.setPath("/"); // ��� ��ο��� ���� ����
	    response.addCookie(newCookie);

	    System.out.println("��ȸ�� ��ٱ��� ������Ʈ: " + newCookie.getName() + ", " + newCookie.getValue());
	}

	// ���� ������Ʈ�� ó���ϴ� �޼���
	private String updateProductQuantityInCart(String cartCookieName, String product_no, int quantity) {
	    String[] cartItems = cartCookieName.split("\\|");
	    StringBuilder updatedCart = new StringBuilder();
	    boolean isUpdated = false;

	    for (String item : cartItems) {
	        String[] itemDetails = item.split("_");
	        if (itemDetails.length < 3) continue; // �߸��� ������ �׸��� ����

	        String itemProductNo = itemDetails[1];
	        System.out.println("itemProductNo" + itemProductNo);
	        int itemQuantity;
	        try {
	            itemQuantity = Integer.parseInt(itemDetails[2]);
	            System.out.println("itemQuantity" + itemQuantity);
	        } catch (NumberFormatException e) {
	            // ���� ���� ���ڰ� �ƴϸ� ����
	            continue;
	        }

	        // ��ǰ ��ȣ�� ��ġ�ϸ� ���� ������Ʈ
	        if (itemProductNo.equals(product_no)) {
	            itemQuantity = quantity;
	            System.out.println("itemQuantity" + itemQuantity);
	            isUpdated = true;
	        }

	        if (updatedCart.length() > 0) {
	            updatedCart.append("|");
	        }
	        updatedCart.append(itemDetails[0]).append("_").append(itemProductNo).append("_").append(itemQuantity);
	    }

	    // ���� �׸��� ���ٸ� �� �׸� �߰�
	    if (!isUpdated) {
	        if (updatedCart.length() > 0) {
	            updatedCart.append("|");
	        }
	        updatedCart.append("cart").append("_").append(product_no).append("_").append(quantity);
	    }

	    return updatedCart.toString();
	}

	// īƮ ��ȸ
	@Override
	public List<CartVO> getGuestCartFromCookies(HttpServletRequest request) {
	    List<CartVO> list = new ArrayList<CartVO>();
	    Cookie[] cookies = request.getCookies();

	    if (cookies != null) {
	        for (int i = cookies.length - 1; i >= 0; i--) {
	            Cookie cookie = cookies[i];
	            if (cookie.getName().startsWith("cart_")) {
	                String cartData = cookie.getName();
	                
	                if (cartData == null || cartData.isEmpty()) {
	                    continue;  // �� ���̸� �ǳʶٱ�
	                }

	                // cartData���� �� ��ǰ ��ȣ�� ������ ����
	                String[] cartItems = cartData.split("\\|");
	                for (String item : cartItems) {
	                    String[] itemDetails = item.split("_");
	                    
	                    if (itemDetails.length < 2) {
	                        System.out.println("�߸��� ������ �׸�: " + item);
	                        continue;  // �߸��� ������ �׸��� �ǳʶݴϴ�.
	                    }

	                    String product_no = cookie.getValue();
	                    int quantity = 1;

	                    // ���� ������ ���� ��� ó��
	                    if (itemDetails.length >= 3) {
	                        try {
	                            quantity = Integer.parseInt(itemDetails[2]);
	                            
	                            System.out.println("quantity : " + quantity);
	                        } catch (NumberFormatException e) {
	                            quantity = 1;  // ������ ��ȿ���� ������ �⺻�� 1�� ����
	                        }
	                    }

	                    ProductVO product = userDAO.selectCartListGuest(product_no);

	                    // ��ǰ�� null�� �ƴϸ� CartVO�� �� ����
	                    if (product != null) {
	                        CartVO vo = new CartVO();
	                        vo.setProduct_no(product.getProduct_no());
	                        vo.setProduct_name(product.getProduct_name());
	                        vo.setProduct_author(product.getProduct_author());
	                        vo.setProduct_publisher(product.getProduct_publisher());
	                        vo.setProduct_price(product.getProduct_price());
	                        vo.setProduct_status(product.getProduct_status());
	                        vo.setCategory_name(product.getCategory_name());
	                        vo.setProduct_created_at(product.getProduct_created_at());
	                        vo.setProduct_status(product.getProduct_status());
	                        
	                        // ������ ������ �⺻�� 1�� ����
	                        System.out.println("quantity : " + quantity);
	                        vo.setCart_product_quantity(quantity > 0 ? quantity : 1);

	                        vo.setAttachment_detail_new_name(product.getAttachment_detail_new_name());
	                        list.add(vo);
	                    } else {
	                        System.out.println("��ǰ ������ ã�� �� �����ϴ�. product_no: " + product_no);
	                    }
	                }
	            }
	        }
	    } else {
	        System.out.println("��û�� ��Ű�� �����ϴ�.");
	    }
	    return list;
	}


	// īƮ  ���
	@Override
	public void addGuestCartToCookies(String product_no, HttpServletRequest request, HttpServletResponse response) {
		// product_no ��ȿ�� �˻�
	    if (product_no == null || product_no.trim().isEmpty()) {
	        System.out.println("��ȿ���� ���� ��ǰ ��ȣ: " + product_no);
	        return;
	    }
		
	    Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if (cookie.getName().startsWith("cart_") && product_no.equals(cookie.getValue())) {
	                System.out.println("�̹� ��ϵ� ��ǰ�Դϴ�. product_no: " + product_no);
	                return; // �ߺ��� ��ǰ�̸� �߰����� ����
	            }
	        }
	    }
	
		String cartId = product_no + "_1"; // ������ UUID ����
		Cookie cookie = new Cookie("cart_" + cartId, String.valueOf(product_no)); // ��Ű �̸��� �ϰ��ǰ� ����
		cookie.setPath("/"); // ��Ű�� ��� ��ο��� ��ȿ�ϵ��� ����
		cookie.setMaxAge(60 * 60 * 24 * 7); // 7�� ����
		response.addCookie(cookie); // ��Ű�� Ŭ���̾�Ʈ�� ����
	}

	// īƮ ����
	@Override
	public int removeGuestCartFromCookies(String cart_no, HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		System.out.println("cookies" + cookies);
		if (cookies != null) {
			for (Cookie cookie : cookies) {
//				System.out.println("name::"+cookie.getName().startsWith("wishlist_"));
//				System.out.println("value::"+cookie.getValue());
//				System.out.println("wishlist_no::"+wishlist_no);
				if (cookie.getName().startsWith("cart_") && cookie.getValue().equals(cart_no)) {
					cookie.setMaxAge(0);
					cookie.setPath("/");
					response.addCookie(cookie);
					System.out.println("Deleting cookie: " + cookie.getName());
				}
			}
		}
		return 1;
	}

	// �α��� �� ��ȸ�� ������ DB�� �̵�
	@Override
	public void migrateGuestDataToDB(HttpServletRequest request, String username, HttpServletResponse response) {
	    Cookie[] cookies = request.getCookies();

	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if (cookie.getName().startsWith("wishlist_")) {
	                // ��Ű�� ���� ��ǰ ��ȣ(product_no)
	                String product_no = cookie.getValue();
	                
	               System.out.println("product_no" + product_no);
	                
	                WishlistVO wishlistVO = new WishlistVO();
	                wishlistVO.setProduct_no(product_no);
	                wishlistVO.setUser_id(username);

	                int result1 = userDAO.selectDedupeWishlist(wishlistVO);
	                
	                if(result1 == 0)
	                {
		                // DB�� ������ ���ø���Ʈ ��ü ����
		                WishlistVO vo = new WishlistVO();
		                vo.setProduct_no(product_no);
		                vo.setUser_id(username);  // �α����� ȸ���� ID
		                vo.setWishlist_create_id(username);
		                vo.setWishlist_update_id(username);
	
		                // DB�� ���ø���Ʈ ����
		                int result = userDAO.insertWishlist(vo);
		                if (result > 0) {
		                    System.out.println("��ȸ�� ���ø���Ʈ DB�� �̵� ����");
		                } else {
		                    System.out.println("��ȸ�� ���ø���Ʈ DB�� �̵� ����");
		                }
	                }
	            } else if (cookie.getName().startsWith("recentlyproduct_")) {
	                // ��Ű�� ���� ��ǰ ��ȣ(product_no)
	                String product_no = cookie.getValue();
	                
	                RecentlyproductVO recentlyproductVO = new RecentlyproductVO();
	                recentlyproductVO.setProduct_no(product_no);
	                recentlyproductVO.setUser_id(username);
	                
	                int result1 = userDAO.selectDedupeRecentlyproduct(recentlyproductVO);

            		if(result1 == 0)
            		{
		                // DB�� ������ �ֱٺ���ǰ ��ü ����
		                RecentlyproductVO vo = new RecentlyproductVO();
		                vo.setProduct_no(product_no);
		                vo.setUser_id(username);  // �α����� ȸ���� ID
		                vo.setWishlist_create_id(username);
		                vo.setWishlist_update_id(username);
	
		                // DB�� ���ø���Ʈ ����
		                int result = userDAO.insertRecentlyproduct(vo);
		                if (result > 0) {
		                    System.out.println("��ȸ�� �ֱ� �� ��ǰ DB�� �̵� ����");
		                } else {
		                    System.out.println("��ȸ�� �ֱ� �� ��ǰ DB�� �̵� ����");
		                }
            		}
	            } else if (cookie.getName().startsWith("cart_")) {
	        	    String[] cartItems = cookie.getName().split("\\|");

	        	    for (String item : cartItems) {
	            		String[] itemDetails = item.split("_");
	            		
	            		if (itemDetails.length == 3) {  // ��ǰ ��ȣ�� ������ �ִ� ��쿡�� ó��
	                        String product_no = itemDetails[1];  // ��ǰ ��ȣ�� �� ��° �׸� ����
	                        int Cart_product_quantity = Integer.parseInt(itemDetails[2]);  // ���� �� ����
			        	
				        	CartVO cartVO = new CartVO();
				        	cartVO.setProduct_no(product_no);
				        	cartVO.setUser_id(username);
				        	
				        	int result1 = userDAO.selectDedupeCart(cartVO);
				        	
				        	if(result1 == 0)
				        	{
				        		// DB�� ������ īƮ ��ü ����
				        		CartVO vo = new CartVO();
				        		
				        		System.out.println("Cart_product_quantity" + Cart_product_quantity);
				        		vo.setCart_product_quantity(Cart_product_quantity);
				        		vo.setProduct_no(product_no);
				        		vo.setUser_id(username);  // �α����� ȸ���� ID
				        		vo.setCart_create_id(username);
				        		vo.setCart_update_id(username);
				        		
				        		// DB�� ���ø���Ʈ ����
				        		int result = userDAO.insertCart(vo);
				        		if (result > 0) {
				        			System.out.println("��ȸ�� īƮ DB�� �̵� ����");
				        		} else {
				        			System.out.println("��ȸ�� īƮ DB�� �̵� ����");
				        		}
				        	}
	            		}
	            	}
	            }
	        }
	    }
	}

}
