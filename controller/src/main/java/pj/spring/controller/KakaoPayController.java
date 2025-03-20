package pj.spring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pj.spring.service.KakaoPayService;
import pj.spring.service.PaymentService;
import pj.spring.vo.KakaoPayResponse;
import pj.spring.vo.OrderedVO;

@Controller
@RequestMapping("/kakaoPay")
public class KakaoPayController {

    private static final Logger log = LoggerFactory.getLogger(KakaoPayController.class);

    private final KakaoPayService kakaoPayService;
    
    public PaymentService paymentService;

    @Autowired
    public KakaoPayController(KakaoPayService kakaoPayService) {
        this.kakaoPayService = kakaoPayService;
    }

    /**
     * īī������ ���� �غ� ��û
     * ����ڷκ��� ���� ������ �޾� īī�����̿� ��û�� �����ϴ�.
     * @param paymentData ���� ���� ������
     * @param session HTTP ����
     * @return īī������ ���� �غ� ����
     */
    @PostMapping("/ready")
    @ResponseBody
    public ResponseEntity<?> kakaoPayReady(@RequestBody Map<String, Object> paymentData, HttpServletRequest req) {
        try {
            log.info("īī������ ��û ������: {}", paymentData);

            // ���� ������ ��ȿ�� ����
            if (!paymentData.containsKey("amount")) {
                return ResponseEntity.badRequest().body("Invalid payment data");
            }

            // ���� ������ ����� ID ��������
            String userId = getAuthenticatedUserId();
            // ��Ʈ�� �ֹ� ��ȣ ���� (UUID ���)
            String partnerOrderId = UUID.randomUUID().toString();

            // īī������ ��û ������ ����
            Map<String, Object> kakaoPayRequest = createKakaoPayRequest(paymentData, userId, partnerOrderId);

            // īī�����̿� ���� �غ� ��û
            KakaoPayResponse response = kakaoPayService.kakaoPayReady(kakaoPayRequest);

            // ���ǿ� TID �� �ֹ� ��ȣ ����
            req.getSession().setAttribute("tid", response.getTid());
            req.getSession().setAttribute("partner_order_id", partnerOrderId);

            return ResponseEntity.ok(response); // ���� ���� ��ȯ
        } catch (Exception e) {
            log.error("īī������ �غ� ��û ����: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("���� ��û �� ������ �߻��߽��ϴ�.");
        }
    }

    /**
     * īī������ ���� ���� ��û
     * ������ ���������� ���εǾ����� Ȯ���ϰ� ����� ��ȯ�մϴ�.
     * @param pgToken īī������ PG ��ū
     * @param session HTTP ����
     * @param model UI�� ������ ������
     * @return ���� ���� �Ǵ� ���� ������
     */
    @GetMapping("/success")
    public String paymentSuccess(@RequestParam("pg_token") String pgToken, HttpServletRequest req, Model model) {
        try {
            // ���ǿ��� TID�� �ֹ� ��ȣ ��ȸ
            String tid = (String) req.getSession().getAttribute("tid");
            String partnerOrderId = (String) req.getSession().getAttribute("partner_order_id");

            // ���� ������ ��ȿ�� ����
            validateSessionData(tid, partnerOrderId);

            // ���� ������ ����� ID ��������
            String userId = getAuthenticatedUserId();

            // ���� ���� ��û ������ ����
            Map<String, String> approvalRequest = createApprovalRequest(tid, partnerOrderId, userId, pgToken);

            // īī�����̿� ���� ���� ��û
            KakaoPayResponse approvalResponse = kakaoPayService.kakaoPayApprove(approvalRequest);
            log.info("īī������ ���� ����: {}", approvalResponse);

            // �ֹ� �����͸� �����ͺ��̽��� ����
			/*
			 * OrderedVO order = new OrderedVO(); order.setOrdered_no(partnerOrderId); // �ֹ�
			 * ��ȣ order.setOrdered_date(new
			 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())); // �ֹ� ��¥
			 * order.setOrdered_status("���� �Ϸ�"); // �ֹ� ���� order.setOrdered_address((String)
			 * session.getAttribute("deliveryAddress")); // �����
			 * order.setOrdered_name((String) session.getAttribute("deliveryName")); // �ֹ���
			 * �̸� order.setOrdered_phone((String) session.getAttribute("deliveryPhone")); //
			 * �ֹ��� �޴��� order.setOrdered_note((String) session.getAttribute("deliveryMemo"));
			 * // ��� �޸� order.setOrdered_create_id(userId); // ������ ID
			 * order.setUser_id(userId); // ����� ID
			 */
            // �����ͺ��̽��� ����
			/* paymentService.insertOrder(order); */

            // �𵨿� ������ �߰�
			/* model.addAttribute("order", order); */
            // ���� ������ �𵨿� �߰��Ͽ� ���� �������� ����
            model.addAttribute("approvalResponse", approvalResponse);

            return "user/payment/paymentSuccess"; // ���� ���� �������� �̵�
        } catch (Exception e) {
            log.error("���� ���� �� ���� �߻�: {}", e.getMessage(), e);
            model.addAttribute("errorMessage", e.getMessage());
            return "user/payment/paymentError"; // ���� �������� �̵�
        }
    }

    
    /**
     * ���� ���� ������ ���� �� ��ȸ �޼���
     */
    private String getSessionAttribute(HttpSession session, String attributeName) {
        Object value = session.getAttribute(attributeName);
        if (value == null) {
            log.error("{} ���� �����Ͱ� �����Ǿ����ϴ�.", attributeName);
            throw new RuntimeException(attributeName + " ���� �����Ͱ� �����Ǿ����ϴ�.");
        }
        return value.toString();
    }
    
    /**
     * ���� ������ ����� ID�� ��ȯ
     * @return ����� ID
     */
    private String getAuthenticatedUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();
        if (userId == null) {
            throw new RuntimeException("User ID�� ���ǿ� �����ϴ�.");
        }
        return userId;
    }

    /**
     * ���� �������� ��ȿ���� ����
     * @param tid TID (Transaction ID)
     * @param partnerOrderId ��Ʈ�� �ֹ� ��ȣ
     */
    private void validateSessionData(String tid, String partnerOrderId) {
        if (tid == null || partnerOrderId == null) {
            throw new RuntimeException("���� �����Ͱ� ��ȿ���� �ʽ��ϴ�.");
        }
    }

    /**
     * īī������ �غ� ��û ������ ����
     * @param paymentData ���� ���� ������
     * @param userId ����� ID
     * @param partnerOrderId ��Ʈ�� �ֹ� ��ȣ
     * @return īī������ �غ� ��û ������
     */
    private Map<String, Object> createKakaoPayRequest(Map<String, Object> paymentData, String userId, String partnerOrderId) {
        Map<String, Object> kakaoPayRequest = new HashMap<>();
        kakaoPayRequest.put("cid", "TC0ONETIME");
        kakaoPayRequest.put("partner_order_id", partnerOrderId);
        kakaoPayRequest.put("partner_user_id", userId);
        kakaoPayRequest.put("item_name", paymentData.get("itemName"));
        kakaoPayRequest.put("quantity", paymentData.get("quantity"));
        kakaoPayRequest.put("total_amount", paymentData.get("amount"));
        kakaoPayRequest.put("vat_amount", 0);
        kakaoPayRequest.put("tax_free_amount", 0);
        kakaoPayRequest.put("approval_url", "http://192.168.0.64:8080/controller/kakaoPay/success");
        kakaoPayRequest.put("cancel_url", "http://192.168.0.64:8080/controller/kakaoPay/cancel");
        kakaoPayRequest.put("fail_url", "http://192.168.0.64:8080/controller/kakaoPay/fail");
        return kakaoPayRequest;
    }

    /**
     * īī������ ���� ��û ������ ����
     * @param tid TID (Transaction ID)
     * @param partnerOrderId ��Ʈ�� �ֹ� ��ȣ
     * @param userId ����� ID
     * @param pgToken PG ��ū
     * @return ���� ��û ������
     */
    private Map<String, String> createApprovalRequest(String tid, String partnerOrderId, String userId, String pgToken) {
        Map<String, String> approvalRequest = new HashMap<>();
        approvalRequest.put("cid", "TC0ONETIME");
        approvalRequest.put("tid", tid);
        approvalRequest.put("partner_order_id", partnerOrderId);
        approvalRequest.put("partner_user_id", userId);
        approvalRequest.put("pg_token", pgToken);
        return approvalRequest;
    }
}