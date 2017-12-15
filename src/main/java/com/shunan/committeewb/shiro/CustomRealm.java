package com.shunan.committeewb.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import com.shunan.committeewb.po.User;
import com.shunan.committeewb.service.UserService;

/**
 * 自定义realm
 * @author 李琳茹
 *
 */
public class CustomRealm extends AuthorizingRealm{
	
	@Autowired
	private UserService userService;
	
	@Override
	public void setName(String name) {
		super.setName("customRealm");
	}

	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String account = (String) token.getPrincipal();
		System.out.println("account="+account);
		User user = null;
		try {
			user = userService.queryUserByAccount(account);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(user == null){
			return null;
		}
		
		String password = user.getPassword();
		String salt = user.getSalt();
		
		SimpleAuthenticationInfo authenticationInfo = 
				new SimpleAuthenticationInfo(user, password, ByteSource.Util.bytes(salt), this.getName());
	
		return authenticationInfo;
	}
}
