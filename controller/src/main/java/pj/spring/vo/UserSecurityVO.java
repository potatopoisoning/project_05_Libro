package pj.spring.vo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/*
	�ش� VO ��ü�� security���� �α��� �Ǵ� ���� �����ÿ��� ����ϴ� ��ü Ÿ�����μ�
	������ ����� �������δ� ����� �� ����.
	�ʿ�� Ÿ VO�� �߰��Ͽ� ����� ���� �����Ѵ�.
*/
public class UserSecurityVO extends User{

	private String user_id;
	private String user_type;
	private boolean user_status;
	
	public UserSecurityVO(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities,
			String authority) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		
		this.user_id = username;
		this.user_type = authority;
		this.user_status = enabled;
		
	}

	// �����ڿ��� ���� �߱� ������ getter�� �־ ��
	public String getUserid()    { return user_id;     }
	public String getAuthority() { return user_type;   }
	public boolean isEnabled()   { return user_status; }

}
