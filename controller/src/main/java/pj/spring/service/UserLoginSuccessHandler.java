package pj.spring.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
 
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		// �α��� ���� �� ȣ��!!
		System.out.println("�α��� ����!");
		
	    // ������� ���� Ȯ��
	    boolean isAdmin = authentication.getAuthorities().stream()
	        .anyMatch(authority -> authority.getAuthority().equals("A")); // ROLE_A ���� üũ

	    if (isAdmin) {
	        // Admin ������ ���� ���
	        response.sendRedirect(request.getContextPath() + "/admin/index.do");
	    } else {
	        // �⺻ ���� �������� �̵�
	        response.sendRedirect(request.getContextPath() + "/cookietodb.do");
	    }
	}
}
