package pj.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pj.spring.vo.*;

@Repository
public class UserDAO {
	
	@Autowired
	public SqlSession sqlSession;
	
	private final String namespace = "pj.spring.mapper.userMapper";
	
	// ȸ������
	public int insert(UserVO userVO) {
		return sqlSession.insert(namespace + ".userInsert", userVO);
	}

	// ȸ��Ż��
	public int deleteAccount(String user_id) {
		return sqlSession.update(namespace + ".deleteAccount", user_id);
	}
 
	// ���̵� �ߺ� üũ
	public int selectCntByUid(String user_id) {
		return sqlSession.selectOne(namespace + ".selectCntByUid", user_id);
	}

//	// ȸ�� �α���
//	public UserVO selectLogin(String username) {
//		return sqlSession.selectOne(namespace + ".selectUserByLogin", username);
//	}

	// ��ȸ�� �α���
	public GuestVO selectGuestLogin(GuestVO guestVO) {
		return sqlSession.selectOne(namespace + ".selectGuestLogin", guestVO);
	}
	
	// �ּҷ� ���
	public List<AddressBookVO> list(String user_id) {
		return sqlSession.selectList(namespace + ".addrlistSelect", user_id);
	}

	// �ּҷ� ���
	public int addrinsert(AddressBookVO addressbookVO) {
		return sqlSession.insert(namespace + ".addrInsert", addressbookVO);
	}
	
	// �ּҷ� ����
	public int addrdelete(String address_book_no) {
		return sqlSession.delete(namespace + ".addrDelete", address_book_no);
	}

	// �ּҷ� ����
	public AddressBookVO addrmodify(String address_book_no) {
		return sqlSession.selectOne(namespace + ".addrModify", address_book_no);
	}

	// �⺻ �ּҷ� ������Ʈ
	public int updateAddrTop(String user_id) {
		return sqlSession.update(namespace + ".updateAddrTop", user_id);
	}

	// �ּҷ� ������Ʈ
	public int addrmodifyOk(AddressBookVO addressbookVO) {
		return sqlSession.update(namespace + ".addrModifyOk", addressbookVO);
	}
	
	// ȸ�� ����
	public UserVO memberinfoselect(String user_id) {
		return sqlSession.selectOne(namespace + ".memberinfoSelect", user_id);
	}

	// ȸ�� ����  ������Ʈ
	public int memberinfomodify(UserVO userVO) {
		return sqlSession.update(namespace + ".memberinfoModify", userVO);
	}

	// �����ϱ�
	public int insertcontact(ContactVO contactVO) {
		return sqlSession.insert(namespace + ".insertContact", contactVO);
	}
	
	// �����ϱ� ÷������
	public int insertattachment(ContactVO contactVO) {
		return sqlSession.insert(namespace + ".insertAttachment", contactVO);
	}
	
	// �����ϱ� ÷������ ��
	public int insertattachmentdetail(ContactVO contactVO) {
		return sqlSession.insert(namespace + ".insertAttachmentDetail", contactVO);
	}
	
	// �����ϱ� ���
	public List<ContactVO> selectcontactlist(String user_id) {
		return sqlSession.selectList(namespace + ".selectContactList", user_id);
	}

	// �����ϱ� ��
	public ContactVO selectcontact(String contact_no) {
		return sqlSession.selectOne(namespace + ".selectContact", contact_no);
	}

	// �����ϱ� ��
	public List<ContactVO> selectContactAttachment(String contact_no) {
		return sqlSession.selectList(namespace + ".selectContactAttachment", contact_no);
	}

	// �����ϱ� ����
	public ContactVO updatecontact(String contact_no) {
		return sqlSession.selectOne(namespace + ".updateContact", contact_no);
	}
	
	// �����ϱ� ������Ʈ
	public int updateokcontact(ContactVO contactVO) {
		return sqlSession.update(namespace + ".updateOkContact", contactVO);
	}
	
	// �����ϱ� ÷������ ������Ʈ
	public List<ContactVO> selectattachment(String contact_no) {
		return sqlSession.selectList(namespace + ".selectAttachment", contact_no);
	}
	
	// �����ϱ� ÷������ ����
	public int deleteAttachment(String attachment_no) {
		return sqlSession.delete(namespace + ".deleteAttachment", attachment_no);
	}
	
	// �����ϱ� ÷������ �� ����
	public int deleteAttachmentDetail(String attachment_no) {
		return sqlSession.delete(namespace + ".deleteAttachmentDetail", attachment_no);
	}
	
	// �����ϱ� ����
	public int deletecontact(String contact_no) {
		return sqlSession.delete(namespace + ".deleteContact", contact_no);
	}
	
	// �ֹ����� ���
	public List<OrderedVO> selectorderhistory(String user_id) {
		return sqlSession.selectList(namespace + ".selectOrderhistory", user_id);
	}
	
	// ��ȸ�� �ֹ����� ���
	public List<OrderedVO> selectOrderhistoryGuest(String guest_no) {
		return sqlSession.selectList(namespace + ".selectOrderhistoryGuest", guest_no);
	}
	
	// ��� ��û
	public int updateOrderstatus1(String ordered_no) {
		return sqlSession.update(namespace + ".updateOrderstatus1", ordered_no);
	}

	// ��� ��û
	public int updateOrderstatus2(String payment_no) {
		return sqlSession.update(namespace + ".updateOrderstatus2", payment_no);
	}
	
	// ����� ����
	public OrderedVO selectAddr(String ordered_no) {
		return sqlSession.selectOne(namespace + ".selectAddr", ordered_no);
	}
	
	// ����� ����
	public int updateAddr(OrderedVO orderedVO) {
		return sqlSession.update(namespace + ".updateAddr", orderedVO);
	}

	// ��ҳ��� ���
	public List<OrderedVO> selectorderhistorycancel(String user_id) {
		return sqlSession.selectList(namespace + ".selectOrderhistoryCancel", user_id);
	}

	// ��ȸ�� ��ҳ��� ���
	public List<OrderedVO> selectOrderhistoryCancelGuest(String guest_no) {
		return sqlSession.selectList(namespace + ".selectOrderhistoryCancelGuest", guest_no);
	}
	
	// �ֹ����� ��
	public OrderedVO selectOrderhistorydetail(String ordered_no) {
		return sqlSession.selectOne(namespace + ".selectOrderhistorydetail", ordered_no);
	}

	// �ֹ����� ��(��ǰ)
	public List<OrderedVO> selectOrderhistorydetailp(String ordered_no) {
		return sqlSession.selectList(namespace + ".selectOrderhistorydetailp", ordered_no);
	}
	
	// ���� ������ ���
	public List<ReviewVO> selectReviewPossibleList(String user_id) {
		return sqlSession.selectList(namespace + ".selectReviewPossibleList", user_id);
	}

	// ���� �ۼ��� ���
	public List<ReviewVO> selectReviewList(String user_id) {
		return sqlSession.selectList(namespace + ".selectReviewList", user_id);
	}
	
	// ���� ��� �� ��ǰ ��ȸ
	public ProductVO selectProduct(String product_no) {
		return sqlSession.selectOne(namespace + ".selectProduct", product_no);
	}

	// ���� ���
	public int insertReview(ReviewVO reviewVO) {
		return sqlSession.insert(namespace + ".insertReview", reviewVO);
	}
	
	// ���� ���� �� ��ȸ
	public ReviewVO selectReview(String review_no) {
		return sqlSession.selectOne(namespace + ".selectReview", review_no);
	}

	// ���� ����
	public int updateReview(ReviewVO reviewVO) {
		return sqlSession.update(namespace + ".updateReview", reviewVO);
	}

	// ����  ���� 
	public int deleteReview(String review_no) {
		return sqlSession.update(namespace + ".deleteReview", review_no);
	}

	// īƮ �ߺ� ��ȸ
	public int selectDedupeCart(CartVO cartVO) {
		return sqlSession.selectOne(namespace + ".selectDedupeCart", cartVO);
	} 
	
	// īƮ ���
	public int insertCart(CartVO cartVO) {
		return sqlSession.insert(namespace + ".insertCart", cartVO);
	}

	// īƮ ���
	public int insertCart_(CartVO cartVO) {
		return sqlSession.insert(namespace + ".insertCart_", cartVO);
	}
	
	// ���ø���Ʈ ��ȸ
	public List<WishlistVO> selectWishlist(String user_id) {
		return sqlSession.selectList(namespace + ".selectWishlist", user_id);
	} 

	// ���ø���Ʈ �ߺ� ��ȸ
	public int selectDedupeWishlist(WishlistVO wishlistVO) {
		return sqlSession.selectOne(namespace + ".selectDedupeWishlist", wishlistVO);
	} 
	
	// ���ø���Ʈ ���
	public int insertWishlist(WishlistVO wishlistVO) {
		return sqlSession.insert(namespace + ".insertWishlist", wishlistVO);
	}
	
	// ���ø���Ʈ ����
	public int deleteWishlist(String wishlist_no) {
		return sqlSession.delete(namespace + ".deleteWishlist", wishlist_no);
	}

	// īƮ �ߺ� ��ȸ
	public int selectDedupeRecentlyproduct(RecentlyproductVO recentlyproductVO) {
		return sqlSession.selectOne(namespace + ".selectDedupeRecentlyproduct", recentlyproductVO);
	} 
	
	// �ֱٺ���ǰ ��ȸ
	public List<RecentlyproductVO> selectRecentlyproduct(String user_id) {
		return sqlSession.selectList(namespace + ".selectRecentlyproduct", user_id);
	};
	
	// �ֱٺ���ǰ ���
	public int insertRecentlyproduct(RecentlyproductVO recentlyproductVO) {
		return sqlSession.insert(namespace + ".insertRecentlyproduct", recentlyproductVO);
	};
	
	// �ֱٺ���ǰ ����
	public int deleteRecentlyproduct_(String recentlyproduct_no) {
		return sqlSession.delete(namespace + ".deleteRecentlyproduct_", recentlyproduct_no);
	};
	
	// �ֱٺ���ǰ ����
	public int deleteRecentlyproduct(RecentlyproductVO recentlyproductVO) {
		return sqlSession.delete(namespace + ".deleteRecentlyproduct", recentlyproductVO);
	};
	
	// ��ȸ���� ��ǰ����
	public ReviewVO selectProductForGuest(String product_no) {
		return sqlSession.selectOne(namespace + ".selectProductForGuest", product_no);
	}
	
	// ��ȸ���� ��ǰ����
	public ProductVO selectCartListGuest(String product_no) {
		return sqlSession.selectOne(namespace + ".selectCartListGuest", product_no);
	}

}
