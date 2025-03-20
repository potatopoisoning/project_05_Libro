package pj.spring.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pj.spring.service.MenuService;
import pj.spring.service.UserService;
import pj.spring.util.PagingUtil;
import pj.spring.vo.CartVO;
import pj.spring.vo.ProductVO;
import pj.spring.vo.RecentlyproductVO;
import pj.spring.vo.ReviewVO;
import pj.spring.vo.SearchVO;
import pj.spring.vo.WishlistVO;

@Controller
public class MenuController {
	
	@Autowired
	public MenuService menuService;
	
	@Autowired
	public UserService userService;
	
	@RequestMapping(value = "/newList.do", method = RequestMethod.GET)
	public String newList(Model model, SearchVO searchVO, @RequestParam(value="nowPage", required = false, defaultValue="1") int nowpage, HttpServletRequest request) {
		
		/* System.out.println(searchVO.getCategoryType()); */
		
		int total = menuService.selectTotal(searchVO);
		
		PagingUtil paging = new PagingUtil(nowpage, total, 10);
		
		searchVO.setStart(paging.getStart());
		searchVO.setPerPage(paging.getPerPage());
		
		List<ProductVO> newList = menuService.selectNewList(searchVO);
		/* System.out.println(newList.size()); */
		
		List<ProductVO> recommend = menuService.selectRecommend();
		
		model.addAttribute("paging", paging);
		model.addAttribute("newList", newList);
		model.addAttribute("recommend", recommend);
		
		return "user/menu/newList";
	}
	
	@ResponseBody
	@RequestMapping(value = "/category.do", produces = "application/json; charset=UTF-8")
	public Map<String, Object> ajaxCategory(Model model, SearchVO searchVO, @RequestParam(value="nowPage", required = false, defaultValue="1") int nowpage) {
	    
		int total = menuService.selectTotal(searchVO);
	    
	    PagingUtil paging = new PagingUtil(nowpage, total, 10);
		
		searchVO.setStart(paging.getStart());
		searchVO.setPerPage(paging.getPerPage());
		
	    List<ProductVO> ajaxCategory = menuService.selectNewList(searchVO);
	    
	    Map<String, Object> result = new HashMap<>();
	    result.put("categoryData", ajaxCategory);
	    result.put("paging", paging);
	    
	    return result;
	}

	@RequestMapping(value = "/bestsellerList.do", method = RequestMethod.GET)
	public String bestsellerList(Model model, SearchVO searchVO, @RequestParam(value="nowPage", required = false, defaultValue="1") int nowpage) {
		
		int total = menuService.selectTotal(searchVO);
		
		PagingUtil paging = new PagingUtil(nowpage, total, 10);
		
		searchVO.setStart(paging.getStart());
		searchVO.setPerPage(paging.getPerPage());
		
		List<ProductVO> bestsellerList = menuService.selectBestsellerList(searchVO);
		List<ProductVO> recommend = menuService.selectRecommend();
		
		model.addAttribute("paging", paging);
		model.addAttribute("bestsellerList", bestsellerList);
		model.addAttribute("recommend", recommend);
		
		return "user/menu/bestsellerList";
	}
	
	@RequestMapping(value = "/totalList.do", method = RequestMethod.GET)
	public String totalList(Model model, SearchVO searchVO, @RequestParam(value="nowPage", required = false, defaultValue="1") int nowpage) {
		
		int total = menuService.selectTotal(searchVO);
		
		PagingUtil paging = new PagingUtil(nowpage, total, 10);
		
		searchVO.setStart(paging.getStart());
		searchVO.setPerPage(paging.getPerPage());
		
		List<ProductVO> totalList = menuService.selectTotalList(searchVO);
		List<ProductVO> recommend = menuService.selectRecommend();
		
		model.addAttribute("paging", paging);
		model.addAttribute("totalList", totalList);
		model.addAttribute("recommend", recommend);
		
		return "user/menu/totalList";
	}
	
	
	@RequestMapping(value= "/product.do", method = RequestMethod.GET)
	public String productDetail(Model model, int product_no, RecentlyproductVO vo, HttpServletRequest request, HttpServletResponse response) {
		
		ProductVO productDetail = menuService.selectProductDetail(product_no);
		ReviewVO reviewDetail = menuService.selectReviewDetail(product_no);

		model.addAttribute("productDetail", productDetail);
		model.addAttribute("reviewDetail", reviewDetail);
		
		// �ֱ� �� ��ǰ ��� ���� �߰�
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();

		if ("anonymousUser".equals(username)) { 
		    if (product_no <= 0) {
		        System.out.println("�߸��� ��ǰ ��ȣ: " + product_no);
		        return "redirect:/errorPage";
		    }
			// ��ȸ��: ��Ű�� �ֱ� �� ��ǰ �߰�
			userService.addGuestRecentlyProductToCookies(vo.getProduct_no(), request, response);
		} else { 
			vo.setUser_id(username);
			vo.setProduct_no(vo.getProduct_no());
			vo.setRecentlyproduct_no(vo.getRecentlyproduct_no());
			int result1 = userService.selectDedupeRecentlyproduct(vo);
			System.out.println("re?" + result1);
			
			if(result1 > 0) {
				System.out.println("vo.getRecentlyproduct_no()" + vo.getRecentlyproduct_no());
				int result2 = userService.deleteRecentlyproduct(vo);
				System.out.println("�ֱ� ����");
			}
			
			int result3 = userService.insertRecentlyproduct(vo);
			
			if (result3 > 0) {
				System.out.println("ȸ�� �ֱٺ���ǰ ��� �Ϸ�");
			} else {
				System.out.println("ȸ�� �ֱٺ���ǰ ��� ����");
			}
		}
		
		
		return "user/menu/productDetail";
	}
	
	@PostMapping("/directPurchase")
    public String directPurchase(
        @RequestParam("product_no") int productNo,
        @RequestParam("product_name") String productName,
        @RequestParam("product_price") int productPrice,
        @RequestParam("quantity") int quantity,
        HttpSession session
    ) {
        // ������ ��ǰ ������ VO�� ����
        Map<String, Object> purchaseInfo = new HashMap<>();
        purchaseInfo.put("product_no", productNo);
        purchaseInfo.put("product_name", productName);
        purchaseInfo.put("product_price", productPrice);
        purchaseInfo.put("quantity", quantity);
        purchaseInfo.put("total_price", productPrice * quantity);

        // ���ǿ� ����
        session.setAttribute("directPurchase", purchaseInfo);

        // payment.jsp�� �����̷�Ʈ
        return "redirect:/payment";
    }
	
	@ResponseBody
	@RequestMapping(value = "/addToCart.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public Map<String, Object> addToCart(CartVO cartVO, @RequestParam("product_no") String product_no, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {

	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String userId = authentication.getName();
	    String cartCreateId = authentication.getName();

	    System.out.println("user_id : " + userId);
	    System.out.println("cart_create_id : " + cartCreateId);
	    System.out.println("product_no : " + product_no);

	    Map<String, Object> response1 = new HashMap<>();

	    if (!userId.equals("anonymousUser")) {
	        cartVO.setUser_id(userId);
	        cartVO.setCart_create_id(cartCreateId);
	        cartVO.setProduct_no(product_no);
	        cartVO.setCart_product_quantity(1);

	        // �ߺ� Ȯ��
	        if (menuService.checkCart(cartVO)) {
	            response1.put("success", false);
	            response1.put("message", "�̹� �߰��� ��ǰ�Դϴ�."); // �ߺ� ��ǰ �޽���
	        } else {
	            int result = menuService.addToCart(cartVO);
	            if (result > 0) {
	                response1.put("success", true);
	                System.out.println("success result : ����");
	            } else {
	                response1.put("success", false);
	                response1.put("message", "��ٱ��� �߰��� �����Ͽ����ϴ�."); // ���� ���� �޽���
	            }
	        }
	    } else {
	        // ��Ű���� �ߺ� Ȯ��
	        Cookie[] cookies = request.getCookies();
	        boolean isDuplicate = false;
	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                if (cookie.getName().startsWith("cart_") && product_no.equals(cookie.getValue())) {
	                    isDuplicate = true;
	                    break;
	                }
	            }
	        }
	        
	        if (isDuplicate) {
	            response1.put("success", false);
	            response1.put("message", "�̹� �߰��� ��ǰ�Դϴ�."); // �ߺ� ��ǰ �޽���
	        } else {
	            // �ߺ��� �ƴ϶�� ��Ű�� �߰�
	            userService.addGuestCartToCookies(product_no, request, response);
	            response1.put("success", true);
	        }
	    }
	    return response1;
	}
	
	@ResponseBody
	@RequestMapping(value = "/addToWishlist.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public Map<String, Object> addToWishlist(WishlistVO wishlistVO, @RequestParam("product_no") String product_no, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userId = authentication.getName();
		String wishlistCreateId = authentication.getName();
		
		System.out.println("user_id : " + userId);
		System.out.println("wishlist_create_id : " + wishlistCreateId);
		System.out.println("product_no : " + product_no);
		
		Map<String, Object> response1 = new HashMap<>();
		
		if(!userId.equals("anonymousUser")) {
			
	        wishlistVO.setUser_id(userId);
	        wishlistVO.setWishlist_create_id(wishlistCreateId);
	        wishlistVO.setProduct_no(product_no);
	        wishlistVO.setWishlist_product_quantity(1);

	     // �ߺ� Ȯ��
	        if (menuService.checkWishlist(wishlistVO)) {
	            response1.put("success", false);
	            response1.put("message", "�̹� �߰��� ��ǰ�Դϴ�."); // �ߺ� ��ǰ �޽���
	        } else {
	            int result = menuService.addToWishlist(wishlistVO);
	            if (result > 0) {
	                response1.put("success", true);
	                System.out.println("success result : ����");
	            } else {
	                response1.put("success", false);
	                response1.put("message", "��ٱ��� �߰��� �����Ͽ����ϴ�."); // ���� ���� �޽���
	            }
	        }
	    } else {
	        // ��Ű���� �ߺ� Ȯ��
	        Cookie[] cookies = request.getCookies();
	        boolean isDuplicate = false;
	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                if (cookie.getName().startsWith("wishlist_") && product_no.equals(cookie.getValue())) {
	                    isDuplicate = true;
	                    break;
	                }
	            }
	        }
	        
	        if (isDuplicate) {
	            response1.put("success", false);
	            response1.put("message", "�̹� �߰��� ��ǰ�Դϴ�."); // �ߺ� ��ǰ �޽���
	        } else {
	            // �ߺ��� �ƴ϶�� ��Ű�� �߰�
	            userService.addGuestWishlistToCookies(product_no, request, response);
	            response1.put("success", true);
	        }
	    }
	    return response1;
	}
}
