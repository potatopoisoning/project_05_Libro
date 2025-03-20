package pj.spring.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import pj.spring.service.AdminService;
import pj.spring.util.PagingUtil;
import pj.spring.vo.ContactVO;
import pj.spring.vo.OrderedDetailVO;
import pj.spring.vo.OrderedVO;
import pj.spring.vo.PaymentVO;
import pj.spring.vo.ProductVO;
import pj.spring.vo.ReviewVO;
import pj.spring.vo.UserVO;

@RequestMapping(value = "/admin")
@Controller
public class AdminController {

	@Autowired
	public AdminService adminService;

	// ��ú���
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String index(Model model,
			@RequestParam(required = false) String startDate, 
            @RequestParam(required = false) String endDate) {

		Map<String, Object> orderCount = adminService.orderCount();
		model.addAttribute("orderCount", orderCount);
		
		Map<String, Object> cancelCount = adminService.cancelCount();
		model.addAttribute("cancelCount", cancelCount);

		Map<String, Object> contentCount = adminService.contentCount();
		model.addAttribute("contentCount", contentCount);

		Map<String, Object> params = new HashMap<>();
        params.put("startDate", startDate);
        params.put("endDate", endDate);

        Map<String, Object> statistics = adminService.getSalesStatistics(params);

        model.addAttribute("statistics", statistics);

		return "admin/index";
	}
	
	

	// ȸ�� ����
	@RequestMapping(value = "/membership.do", method = RequestMethod.GET)
	public String membership(Model model,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage) {

		int total = adminService.selectTotal();

		PagingUtil paging = new PagingUtil(nowPage, total, 10);

		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", paging.getStart());
		pagingParam.put("perPage", paging.getPerPage());

		// �����Ͻ� ���� : DB�� �ִ� ��ü ȸ�� ��� �����Ͱ�������
		List<UserVO> list = adminService.userList(pagingParam);

		// �� ��ü ����Ͽ� ��ȸ ������ ȭ������ ������
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);

		return "admin/membership";
	}
	
	//ȸ�� ���� ���� (AJAX ��û ó��)
	@ResponseBody
    @RequestMapping(value = "/updateUser.do", method = RequestMethod.POST)
    public Map<String, Object> saveUserReply(@RequestBody UserVO userVO) {
        Map<String, Object> response = new HashMap<>();

        try {
            int result = adminService.saveUserReply(userVO);

            if (result > 0) {
                response.put("status", "success");
                response.put("message", "����Ǿ����ϴ�.");
            } else {
                response.put("status", "fail");
                response.put("message", "���忡 �����߽��ϴ�.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status", "error");
            response.put("message", "���� ������ �߻��߽��ϴ�.");
        }

        return response;
    }
	
	// ȸ�� ���� �˻� (AJAX)
	@PostMapping("/search.do")
	public ResponseEntity<List<UserVO>> searchMembers(@RequestBody Map<String, Object> searchParams) {
		 List<UserVO> members = adminService.searchMembers(searchParams);
		    return ResponseEntity.ok(members);
    }
	
	// ��ǰ ����
	@RequestMapping(value = "/product.do", method = RequestMethod.GET)
	public String product(Model model,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage) {

		int total = adminService.productTotal();

		PagingUtil paging = new PagingUtil(nowPage, total, 10);

		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", paging.getStart());
		pagingParam.put("perPage", paging.getPerPage());

		// �����Ͻ� ���� : DB�� �ִ� ��ü ȸ�� ��� �����Ͱ�������
		List<ProductVO> list = adminService.productList(pagingParam);

		// �� ��ü ����Ͽ� ��ȸ ������ ȭ������ ������
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);

		return "admin/product";
	}

	// ��ǰ ���
	@RequestMapping(value = "/productWrite.do", method = RequestMethod.GET)
	public String productWrite() {

		return "admin/productWrite";
	}

	@RequestMapping(value = "/productWrite.do", method = RequestMethod.POST)
	public String productWrite(ProductVO productVO, MultipartFile topFile,
			@RequestParam(value = "multiFile") List<MultipartFile> multiFile, HttpServletRequest request,Principal principal)
			throws IllegalStateException, IOException {

		//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user_id = principal.getName();

		productVO.setUser_id(user_id);
		productVO.setProduct_no(productVO.getProduct_no());
		productVO.setProduct_status(productVO.getProduct_status());
		productVO.setCategory_name(productVO.getCategory_name());
		productVO.setProduct_price(productVO.getProduct_price());
		productVO.setProduct_stock(productVO.getProduct_stock());
		productVO.setProduct_name(productVO.getProduct_name());
		productVO.setProduct_isbn(productVO.getProduct_isbn());
		productVO.setProduct_page(productVO.getProduct_page());
		productVO.setProduct_description(productVO.getProduct_description());
		productVO.setProduct_author(productVO.getProduct_author());
		productVO.setProduct_author_description(productVO.getProduct_author_description());

		int resultInt = adminService.insertProduct(productVO);
		
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println("upload path -> " + path);

		File dir = new File(path);

		if (!dir.exists()) {
			dir.mkdirs();
		}

		String topNewFileName = "";

		if (!topFile.getOriginalFilename().isEmpty()) {
			UUID uuid = UUID.randomUUID();
			String fileRealPath = uuid + topFile.getOriginalFilename();

			topFile.transferTo(new File(path, fileRealPath));

			topNewFileName = fileRealPath;

			productVO.setAttachment_detail_name(topFile.getOriginalFilename()); // ��ǥ�̹��� ���ε��̸�
			productVO.setAttachment_detail_new_name(topNewFileName); // ��ǥ�̹��� ���� ���ε� �̸�
			productVO.setAttachment_type("PT");
			productVO.setAttachment_detail_create_id(user_id);
			adminService.insertAttachment(productVO);
			adminService.insertAttachmentDetail(productVO);

		}

		String newFileName = "";

		if (multiFile.size() > 0) {
			productVO.setAttachment_type("PD");
			adminService.insertAttachment(productVO);
		}
		for (MultipartFile file : multiFile) {
			if (!file.getOriginalFilename().isEmpty()) {
				UUID uuid = UUID.randomUUID();
				String fileRealName = uuid.toString() + file.getOriginalFilename();

				file.transferTo(new File(path, fileRealName));

				newFileName = fileRealName;

				productVO.setAttachment_detail_name(file.getOriginalFilename()); // ��ǰ �� �̹��� ���ε� �̸�
				productVO.setAttachment_detail_new_name(newFileName); // ��ǰ �� �̹��� ���� ���ε� �̸�
				productVO.setAttachment_detail_create_id(user_id);
				
				adminService.insertAttachmentDetail(productVO);

			}
		}

		if(resultInt>0) {
			System.out.println("��ϿϷ�");
			return "redirect:product.do";
		}else {
			System.out.println("��� ���� ");
			return "redirect:productWrite.do";
		}

	}

	// ��ǰ ��� ����
	@RequestMapping(value = "/productModify.do", method = RequestMethod.GET)
	public String productModify(Model model, @RequestParam(value = "product_no") int product_no) {

		ProductVO vo = adminService.productModify(product_no);
		
		List<ProductVO> attachmentInfoList  = adminService.productAttachmentName(product_no);
		
		
		model.addAttribute("vo", vo);
		model.addAttribute("attachmentInfoList", attachmentInfoList);

		return "admin/productModify";
	}

	@RequestMapping(value = "/productModify.do", method = RequestMethod.POST)
	public String productModify(ProductVO productVO, @RequestParam("topFile") MultipartFile topFile, 
	                            @RequestParam("multiFile") MultipartFile[] multiFile, 
	                            Principal principal, HttpServletRequest request) {
	    String user_id = principal.getName();
	    productVO.setProduct_update_id(user_id);

	    // ���� ���ε� ��� ����
	    String path = request.getSession().getServletContext().getRealPath("/resources/upload");
	    System.out.println("upload path -> " + path);
	    
	    File dir = new File(path);
	    
	    if (!dir.exists()) {
	        dir.mkdirs();
	    }

	    // ��ǥ �̹��� ó��
	    if (!topFile.getOriginalFilename().isEmpty()) {
	    	// ���� ��ǥ �̹��� ����
	        if (productVO.getAttachment_no() != null && "PT".equals(productVO.getAttachment_type())) {
	        	String oldFilePath = path + "/" + productVO.getAttachment_detail_new_name(); // ���� ���� ���
	            File oldFile = new File(oldFilePath);
	            if (oldFile.exists()) {
	                oldFile.delete(); // ���� ����
	            }
	        }
	    	 
	    	UUID uuid = UUID.randomUUID();
	        String fileRealPath = uuid + topFile.getOriginalFilename();
	        
	        try {
	            topFile.transferTo(new File(path, fileRealPath));  // ���� ����
	        } catch (IOException e) {
	            e.printStackTrace();
            }
	        
	        productVO.setAttachment_detail_name(topFile.getOriginalFilename());
	        productVO.setAttachment_detail_new_name(fileRealPath);
	        productVO.setAttachment_type("PT");
	        productVO.setAttachment_detail_update_id(user_id);
	        adminService.updateProductAttachment(productVO);
	    }

	    // ��Ÿ �̹��� ó��
	    if (multiFile != null && multiFile.length > 0) {
	    	// ���� ��Ÿ �̹��� ���� (���� �̹����� ������ ����)
	        if (productVO.getOther_attachment_no() != null && !productVO.getOther_attachment_no().isEmpty()) {
	            for (Integer attachment_no : productVO.getOther_attachment_no()) {
	                String oldFilePath = path + "/" + attachment_no;  // ���� ���� ���
	                File oldFile = new File(oldFilePath);
	                if (oldFile.exists()) {
	                    oldFile.delete();  // ���� ���� ����
	                }
	            }
	        }
	        
	        for (MultipartFile file : multiFile) {
	        	if (!file.getOriginalFilename().isEmpty()) {
	        		UUID uuid = UUID.randomUUID();
	        		String fileRealName = uuid.toString() + file.getOriginalFilename();
	        		
	        		try {
	                    file.transferTo(new File(path, fileRealName));  // ���� ����
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	        		
	        		productVO.setAttachment_detail_name(file.getOriginalFilename());
	    	        productVO.setAttachment_detail_new_name(fileRealName);
	    	        productVO.setAttachment_type("PD");
	    	        productVO.setAttachment_detail_update_id(user_id);
	    	        adminService.updateProductAttachment(productVO);
		            }
		        }
		    }

		    int result = adminService.productModifyUpdate(productVO);
		    if (result > 0) {
		        return "redirect:product.do";
		    } else {
		        return "redirect:productModify.do";
		    }
    
    }

	 // ��ǰ ����
	 @ResponseBody
	 @RequestMapping(value = "/deleteProduct.do", method = RequestMethod.POST)
	 public String productDelete(@RequestBody ProductVO productVO) {
	 
		// �ֹ� ���¸� �����ϴ� ���� ȣ��
		    int result = adminService.productDelete(productVO);
		    
		    // ���� ���� ���� ���ο� ���� ��� ��ȯ
		    if(result > 0) {
		        return "success";  // ����
		    } else {
		        return "failure";  // ����
		    }
	 }
	 

	// �ֹ� ����
	@RequestMapping(value = "/order.do", method = RequestMethod.GET)
	public String order(Model model,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage) {

		int total = adminService.orderTotal();

		PagingUtil paging = new PagingUtil(nowPage, total, 10);

		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", paging.getStart());
		pagingParam.put("perPage", paging.getPerPage());

		List<Map<String, Object>> orderList = adminService.orderList(pagingParam);
		
		model.addAttribute("orderList", orderList);
		model.addAttribute("paging", paging);

		return "admin/order";
	}
	
	// ordered_status ���� ajax
	@ResponseBody
	@RequestMapping(value = "/updateStatus.do", method = RequestMethod.POST)
	public String updateStatus(@RequestBody OrderedVO orderedVO) {
		
		// �ֹ� ���¸� �����ϴ� ���� ȣ��
	    int result = adminService.updateOrderStatus(orderedVO);
	    
	    // ���� ���� ���� ���ο� ���� ��� ��ȯ
	    if(result > 0) {
	        return "success";  // ����
	    } else {
	        return "failure";  // ����
	    }
	
	}
	
	// ��ǰ�ֹ���ȣ ���â
	@ResponseBody
	@RequestMapping(value = "/getOrderDetails.do", method = RequestMethod.GET)
	public Map<String, Object> getOrderDetails(Model model,
	        @RequestParam("ordered_detail_no") String ordered_detail_no) {
	    // ��: ���񽺿��� �ֹ� �� ���� ��ȸ
	    Map<String, Object> orderDetail = adminService.getOrderDetails(ordered_detail_no);
	    
	    // ���� ������ ����
	    Map<String, Object> response = new HashMap<>();
	    if (orderDetail != null) {
	        // �ֹ� �� ������ ���� �ʿ� �ֱ�
	        response.put("ordered_status", orderDetail.get("ordered_status")); // �ֹ� ����
	        response.put("ordered_name", orderDetail.get("ordered_name")); // �����ڸ�
	        response.put("ordered_phone", orderDetail.get("ordered_phone")); // ����ó
	        response.put("ordered_address", orderDetail.get("ordered_address")); //�ּ�
	        response.put("ordered_note", orderDetail.get("ordered_note")); // ��� �޸�
	        response.put("ordered_delivery_fee", orderDetail.get("ordered_delivery_fee")); // ��ۺ�
	        response.put("ordered_create_at", orderDetail.get("ordered_create_at")); // �ֹ�������
	        response.put("ordered_detail_quantity", orderDetail.get("ordered_detail_quantity")); // ����
	        response.put("product_name", orderDetail.get("product_name")); // ��ǰ��
	        response.put("product_price", orderDetail.get("product_price")); // ��ǰ����
	        response.put("payment_date", orderDetail.get("payment_date")); // ������
	        response.put("payment_method", orderDetail.get("payment_method")); // ��������
	        response.put("payment_price", orderDetail.get("payment_price")); // �����ݾ�
	    } else {
	        response.put("error", "Order details not found");
	    }

	    return response;
	}


	// ��� ����
	@RequestMapping(value = "/cancel.do", method = RequestMethod.GET)
	public String cancel(Model model,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage) {

		int total = adminService.orderCancelTotal();

		PagingUtil paging = new PagingUtil(nowPage, total, 10);

		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", paging.getStart());
		pagingParam.put("perPage", paging.getPerPage());

		List<Map<String, Object>> orderCancelList = adminService.orderCancelList(pagingParam);
		
		model.addAttribute("orderCancelList", orderCancelList);
		model.addAttribute("paging", paging);

		
		return "admin/cancel";
	}
	
	// payment_type ���� ���� ajax
	@ResponseBody
	@RequestMapping(value = "/updateRefundStatus.do", method = RequestMethod.POST)
	public String changeRefundStatus(@RequestBody PaymentVO paymentVO) {
		
		// �ֹ� ���¸� �����ϴ� ���� ȣ��
	    int result = adminService.updateRefundStatus(paymentVO);
	    
	    // ���� ���� ���� ���ο� ���� ��� ��ȯ
	    if(result > 0) {
	        return "success";  // ����
	    } else {
	        return "failure";  // ����
	    }
	
	}

	// ���� ����
	@RequestMapping(value = "/sales.do", method = RequestMethod.GET)
	public String sales(Model model,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage) {
		
		int total = adminService.salesTotal();

		PagingUtil paging = new PagingUtil(nowPage, total, 10);

		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", paging.getStart());
		pagingParam.put("perPage", paging.getPerPage());

		List<Map<String, Object>> salesList = adminService.salesList(pagingParam);
		
		
		// �� �ŷ��ݾ�
        OrderedDetailVO orderTotalAmount = adminService.orderTotalAmount();
        // �� �����ݾ�
        PaymentVO paymentTotalAmount = adminService.paymentTotalAmount();
        // �� �Ǹż���
        OrderedDetailVO orderTotalQuantity = adminService.orderTotalQuantity();

        // ���� ���� �𵨿� ��Ƽ� �信 ����
        model.addAttribute("orderTotalAmount", orderTotalAmount);
        model.addAttribute("paymentTotalAmount", paymentTotalAmount);
        model.addAttribute("orderTotalQuantity", orderTotalQuantity);
        model.addAttribute("salesList", salesList);
		
		
		

		return "admin/sales";
	}

	// ���� ����
	@RequestMapping(value = "/review.do", method = RequestMethod.GET)
	public String review(Model model,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage) {

		int total = adminService.reviewTotal();

		PagingUtil paging = new PagingUtil(nowPage, total, 10);

		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", paging.getStart());
		pagingParam.put("perPage", paging.getPerPage());

		List<Map<String, Object>> reviewList = adminService.reviewList(pagingParam);
		
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("paging", paging);
		
		return "admin/review";
	}

	// review_status ���� ���� ajax
	@ResponseBody
	@RequestMapping(value = "/reviewStatus.do", method = RequestMethod.POST)
	public String reviewStatus(@RequestBody ReviewVO reviewVO) {
		
		// �ֹ� ���¸� �����ϴ� ���� ȣ��
		int result = adminService.reviewStatus(reviewVO);
		
		// ���� ���� ���� ���ο� ���� ��� ��ȯ
		if(result > 0) {
			return "success";  // ����
		} else {
			return "failure";  // ����
		}
		
	}

	// ���� ����
	@RequestMapping(value = "/contact.do", method = RequestMethod.GET)
	public String contact(Model model, OrderedDetailVO orderedDetailVO, PaymentVO paymentVO,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage) {

		OrderedDetailVO orderTotalAmount = adminService.orderTotalAmount();
	    PaymentVO paymentTotalAmount = adminService.paymentTotalAmount();
	    OrderedDetailVO orderTotalQuantity = adminService.orderTotalQuantity();
	    
		int total = adminService.contactTotal();

		PagingUtil paging = new PagingUtil(nowPage, total, 10);

		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", paging.getStart());
		pagingParam.put("perPage", paging.getPerPage());

		// �����Ͻ� ���� : DB�� �ִ� ��ü ȸ�� ��� �����Ͱ�������
		List<Map<String, Object>> contactList = adminService.contactList(pagingParam);
		
		
		
		// �� ��ü ����Ͽ� ��ȸ ������ ȭ������ ������
		model.addAttribute("contactList", contactList);
		model.addAttribute("paging", paging);
		model.addAttribute("orderTotalAmount", orderTotalAmount);
		model.addAttribute("paymentTotalAmount", paymentTotalAmount);
		model.addAttribute("orderTotalQuantity", orderTotalQuantity);
		
		return "admin/contact";
	}
	
	// ���� �亯 ���� (AJAX ��û ó��)
    @ResponseBody
    @RequestMapping(value = "/saveReply.do", method = RequestMethod.POST)
    public Map<String, Object> saveContactReply(@RequestBody ContactVO contactVO) {
        Map<String, Object> response = new HashMap<>();

        try {
            // ���� �亯 ����
            int result = adminService.saveContactReply(contactVO);

            if (result > 0) {
                response.put("status", "success");
                response.put("message", "�亯�� ���������� ����Ǿ����ϴ�.");
            } else {
                response.put("status", "fail");
                response.put("message", "�亯 ���忡 �����߽��ϴ�.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status", "error");
            response.put("message", "���� ������ �߻��߽��ϴ�.");
        }

        return response;
    }
	
	
	
	
	
	
	

}
