package pj.spring.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1) // �������� ���� �� ���� ���� ����
@WebFilter({"/inquiryOk.do"}) // �ش� ������̼����� �ڵ����� filter ����(web.xml �۾� X)
//@WebFilter("/board/**") // ���� ��� ����
//@WebFilter(urlPatterns = "/board/**") // ���� ��� ����
//@WebFilter(urlPatterns = {"/board/**", "/free/**"}) // ���� ��� ����
@Component
public class ContentFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// ���ͻ��� ���� ȣ��
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// ��ν� �ϳ��� ���� ��ο� ���� get, post�� ������ �� �����Ƿ� �ϳ��� �����ο��� post�� ���͸� ������ �� ����.
		
		String contact_content = request.getParameter("contact_content");
		
		contact_content = contact_content.replaceAll("<", "&lt;");
		contact_content = contact_content.replaceAll(">", "&gt;");
		contact_content = contact_content.replaceAll("\n", "<br>");
		
		request.setAttribute("contact_content", contact_content);
		
		System.out.println("Filter contact_content : " + contact_content);
		
		chain.doFilter(request, response); // ���� ��û���� ���� 
	}

	@Override
	public void destroy() {
		
	}
	
}
