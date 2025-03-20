package pj.spring.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pj.spring.vo.ContactAlarmVO;
import pj.spring.vo.ContactVO;
import pj.spring.vo.OrderedDetailVO;
import pj.spring.vo.OrderedVO;
import pj.spring.vo.PaymentVO;
import pj.spring.vo.ProductVO;
import pj.spring.vo.ReviewVO;
import pj.spring.vo.UserVO;

@Repository
public class AdminDAO {

	@Autowired
	public SqlSession sqlSession;

	private final String namespace = "pj.spring.mapper.adminMapper";

	// ��ú��� �ֹ� ���� �� ��
	public Map<String, Object> orderCount() {
		return sqlSession.selectOne(namespace + ".orderCount");
	}

	// ��ú��� ��� ���� �� ��
	public Map<String, Object> cancelCount() {
		return sqlSession.selectOne(namespace + ".cancelCount");
	}

	// ��ú��� ����/���� ���� �� ��
	public Map<String, Object> contentCount() {
		return sqlSession.selectOne(namespace + ".contentCount");
	}
	
	// ���� ��� �޼���
    public Map<String, Object> getSalesStatistics(Map<String, Object> params) {
        // 1. �� ���� �� �� �ֹ� �� ��������
        Map<String, Object> summary = sqlSession.selectOne(namespace + ".salesStatistics", params);

        // 2. ��¥�� ���� �� �ֹ� �� ��������
        List<Map<String, Object>> dailyData = sqlSession.selectList(namespace + ".salesStatisticsByDate", params);

        // 3. ���� ��� ����
        summary.put("dailyData", dailyData);
        return summary;
    }

	// ȸ�� ���� list
	public List<UserVO> userList(Map<String, Integer> pagingParam) {
		return sqlSession.selectList(namespace + ".userList", pagingParam);
	}

	// ȸ�� ��ü ��
	public int selectTotal() {
		return sqlSession.selectOne(namespace + ".selectTotal");
	}
	
	// ȸ�� ���� ���� (AJAX ��û ó��)
	public int saveUserReply(UserVO userVO) {
		return sqlSession.update(namespace + ".saveUserReply", userVO);
	}
	
	// ȸ�� ���� �˻�(AJAX)
	public List<UserVO> searchMembers(Map<String, Object> searchParams) {
		return sqlSession.selectList(namespace + ".searchMembers", searchParams);
	}

	// ��ǰ ���
	public int insertProduct(ProductVO productVO) {
		return sqlSession.insert(namespace + ".insertProduct", productVO);
	}

	// ��ǰ ÷������
	public int insertAttachment(ProductVO productVO) {
		return sqlSession.insert(namespace + ".insertAttachment", productVO);
	}

	// ��ǰ ÷������ ��
	public int insertAttachmentDetail(ProductVO productVO) {
		return sqlSession.insert(namespace + ".insertAttachmentDetail", productVO);
	}

	// ��ǰ ���� List
	public List<ProductVO> productList(Map<String, Integer> pagingParam) {
		return sqlSession.selectList(namespace + ".productList", pagingParam);
	}

	// ��ǰ ��ü ��
	public int productTotal() {
		return sqlSession.selectOne(namespace + ".productTotal");
	}

	// ��ǰ ���� ��
	public ProductVO productModify(int product_no) {
		return sqlSession.selectOne(namespace + ".productModify", product_no);
	}

	// ��ǰ ����
	public int productModifyUpdate(ProductVO productVO) {
		return sqlSession.update(namespace + ".productModifyUpdate", productVO);
	}
	
	// ���� �� ÷������ �̸� select
	public List<ProductVO> productAttachmentName(int product_no) {
		return sqlSession.selectList(namespace + ".productAttachmentName", product_no);
	}
	
	// ��ǰ ÷������ ����
	public int updateProductAttachment(ProductVO productVO) {
		return sqlSession.update(namespace+".updateProductAttachment", productVO);
	}
	
	// ��ǰ ÷������ ����
	public int deleteAttachment(int attachment_no) {
		return sqlSession.delete(namespace + ".deleteAttachment", attachment_no);
	}

	// ��ǰ ���� 
	public int productDelete(ProductVO productVO) { 
		return sqlSession.update(namespace+".productDelete", productVO); 
	}
	 
	// �ֹ� ���� List
	public List<Map<String, Object>> orderList(Map<String, Integer> pagingParam) {
		return sqlSession.selectList(namespace + ".orderList", pagingParam);
	}

	// �ֹ� ��ü ��
	public int orderTotal() {
		return sqlSession.selectOne(namespace + ".orderTotal");
	}

	// ordered_status ���� ajax
	public int updateOrderStatus(OrderedVO orderedVO) {
		return sqlSession.update(namespace + ".updateOrderStatus", orderedVO);
	}
	
	// ��ǰ�ֹ���ȣ ���â
	public Map<String, Object> getOrderDetails(String ordered_detail_no) {
		return sqlSession.selectOne(namespace+".getOrderDetails", ordered_detail_no);
	}
	
	// �ֹ� ��� ���� List
	public List<Map<String, Object>> orderCancelList(Map<String, Integer> pagingParam) {
		return sqlSession.selectList(namespace + ".orderCancelList", pagingParam);
	}

	// �ֹ� ��� ��ü ��
	public int orderCancelTotal() {
		return sqlSession.selectOne(namespace + ".orderCancelTotal");
	}

	// payment_type ���� ajax
	public int updateRefundStatus(PaymentVO paymentVO) {
		return sqlSession.update(namespace + ".updateRefundStatus", paymentVO);
	}

	// ���� ���� list
	public List<Map<String, Object>> reviewList(Map<String, Integer> pagingParam) {
		return sqlSession.selectList(namespace + ".reviewList", pagingParam);
	}

	// ���� ��ü ��
	public int reviewTotal() {
		return sqlSession.selectOne(namespace + ".reviewTotal");
	}

	// review_status ���� ���� ajax
	public int reviewStatus(ReviewVO reviewVO) {
		return sqlSession.update(namespace + ".reviewStatus", reviewVO);
	}

	// ���� ���� list
	public List<Map<String, Object>> contactList(Map<String, Integer> pagingParam) {
		return sqlSession.selectList(namespace + ".contactList", pagingParam);
	}

	// ���� ��ü ��
	public int contactTotal() {
		return sqlSession.selectOne(namespace + ".reviewTotal");
	}
	
	// ���� �亯 ���� (AJAX ��û ó��)
	public int saveContactReply(ContactVO contactVO) {
		return sqlSession.update(namespace+".saveContactReply", contactVO);
	}
	
	// �˸� ����
	/*
	 * public int insertContactAlarm(ContactAlarmVO contactAlarmVO) { return
	 * sqlSession.insert(namespace + ".insertContactAlarm", contactAlarmVO); }
	 */
	
	// ������ �˸� ��ȸ
	/*
	 * public List<ContactAlarmVO> getUnreadNotifications(String user_id) { return
	 * sqlSession.selectList(namespace + ".getUnreadNotifications", user_id); }
	 */

	//������� ���� �հ�
	//�� �ŷ��ݾ�
	public OrderedDetailVO orderTotalAmount() {
		return sqlSession.selectOne(namespace+".orderTotalAmount");
	}
	
	//�� �����ݾ�
	public PaymentVO paymentTotalAmount() {
		return sqlSession.selectOne(namespace+".paymentTotalAmount");
	}
	
	//�� �Ǹż���
	public OrderedDetailVO orderTotalQuantity() {
		return sqlSession.selectOne(namespace+".orderTotalQuantity");
	}
	
	//������� list
	public List<Map<String, Object>>salesList(Map<String, Integer> pagingParam) {
		return sqlSession.selectList(namespace + ".salesList", pagingParam);
	}
	
	//���� ���� ��ü ��
	public int salesTotal() {
		return sqlSession.selectOne(namespace + ".salesTotal");
	}	
	
}
