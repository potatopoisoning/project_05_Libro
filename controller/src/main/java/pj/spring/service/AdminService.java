package pj.spring.service;

import java.util.List;
import java.util.Map;

import pj.spring.vo.ContactAlarmVO;
import pj.spring.vo.ContactVO;
import pj.spring.vo.OrderedDetailVO;
import pj.spring.vo.OrderedVO;
import pj.spring.vo.PaymentVO;
import pj.spring.vo.ProductVO;
import pj.spring.vo.ReviewVO;
import pj.spring.vo.UserVO;

public interface AdminService {
	
	// ��ú��� �ֹ� ����  �� ��
	public Map<String, Object> orderCount();
	
	// ��ú��� ��� ����  �� ��
	public Map<String, Object> cancelCount();
	
	// ��ú��� ����/���� ����  �� ��
	public Map<String, Object> contentCount();
	
	// ���� ��� �޼���
    public Map<String, Object> getSalesStatistics(Map<String, Object> params);
	
	// ȸ�� ���� list
	public List<UserVO> userList(Map<String,Integer> pagingParam);
	
	// ȸ�� ��ü ��
	public int selectTotal();
	
	// ȸ�� ���� ���� (AJAX ��û ó��)
	public int saveUserReply(UserVO userVO);
	
	// ȸ�� ���� �˻�(AJAX)
	public List<UserVO> searchMembers(Map<String, Object> searchParams);
	
	// ��ǰ ���
	public int insertProduct(ProductVO productVO);
	
	// ��ǰ ÷������
	public int insertAttachment(ProductVO productVO);
	
	// ��ǰ ÷������ ��
	public int insertAttachmentDetail(ProductVO productVO);
	
	// ��ǰ ���� list
	public List<ProductVO> productList(Map<String,Integer> pagingParam);
	
	// ��ǰ ��ü ��
	public int productTotal();
	
	// ��ǰ ���� ��
	public ProductVO productModify(int product_no);
	
	// ��ǰ ����
	public int productModifyUpdate(ProductVO productVO);
	
	// ���� �� ÷������ �̸� select
	public List<ProductVO> productAttachmentName(int product_no);
	
	// ��ǰ ÷������ ����
	public int updateProductAttachment(ProductVO productVO);
	
	// ��ǰ ÷������ ����
	public int deleteAttachment(int attachment_no);
	
	// ��ǰ ���� 
	public int productDelete(ProductVO productVO);
	
	// �ֹ� ���� List
	public List<Map<String, Object>> orderList(Map<String,Integer> pagingParam);
	
	// �ֹ� ���� ��ü ��
	public int orderTotal();
	
	// ordered_status ���� ajax
	public int updateOrderStatus(OrderedVO orderedVO);
	
	// ��ǰ�ֹ���ȣ ���â
	public Map<String, Object> getOrderDetails(String ordered_detail_no);
	
	// �ֹ� ��� ���� List
	public List<Map<String, Object>> orderCancelList(Map<String,Integer> pagingParam);
	
	// �ֹ� ��� ��ü ��
	public int orderCancelTotal();
	
	// payment_type ���� ajax
	public int updateRefundStatus(PaymentVO paymentVO);
	
	// ���� ���� list
	public List<Map<String, Object>> reviewList(Map<String,Integer> pagingParam);
	
	// ���� ��ü ��
	public int reviewTotal();
	
	// review_status ���� ���� ajax
	public int reviewStatus(ReviewVO reviewVO);
	
	// ���� ���� list
	public List<Map<String, Object>> contactList(Map<String,Integer> pagingParam);
	
	// ���� ��ü ��
	public int contactTotal();
	
	// ���� �亯 ���� (AJAX ��û ó��)
	public int saveContactReply(ContactVO contactVO);
	
	// �˸� ����
	//public int insertContactAlarm(ContactAlarmVO contactAlarmVO);
	
	// ������ �˸� ��ȸ
	//public List<ContactAlarmVO> getUnreadNotifications(String user_id);
	
	//������� ���� �հ�
	//�� �ŷ��ݾ�
	public OrderedDetailVO orderTotalAmount();
		
	//�� �����ݾ�
	public PaymentVO paymentTotalAmount();
	
	//�� �Ǹż���
	public OrderedDetailVO orderTotalQuantity();
		
	//������� list
	public List<Map<String, Object>>salesList(Map<String, Integer> pagingParam);
	
	//���� ���� ��ü ��
	public int salesTotal();
		
		

}
