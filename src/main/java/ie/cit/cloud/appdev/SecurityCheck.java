package ie.cit.cloud.appdev;

import java.util.Collection;

import javax.management.relation.Role;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityCheck {

	public SecurityCheck() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean checkIsThisAdmin(){
		for (GrantedAuthority authority : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
			if (authority.getAuthority().equals("ROLE_ADMIN")) {
				return true;
        	}
       }
		return false;
	
	}
}
