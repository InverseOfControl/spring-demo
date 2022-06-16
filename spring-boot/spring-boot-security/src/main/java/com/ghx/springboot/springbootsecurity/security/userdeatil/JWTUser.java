package com.ghx.springboot.springbootsecurity.security.userdeatil;

import com.ghx.springboot.springbootsecurity.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
public class JWTUser implements UserDetails {
    /**
     * 用户信息
     */
    private User user;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 权限信息字符串
     */
    private String authoritiesStr;

    /**
     * 权限信息
     */
    private List<? extends GrantedAuthority> authorities;

    public JWTUser() {
    }

    public JWTUser(User user, String authoritiesStr) {
        this.user = user;
        this.authoritiesStr = authoritiesStr;
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (null == authorities) {
            List<GrantedAuthority> authorityList = new ArrayList<>();
            if (!StringUtils.isEmpty(authoritiesStr)) {
                Arrays.stream(authoritiesStr.split(",")).forEach(authority -> {
                    authorityList.add(new SimpleGrantedAuthority("ROLE_" + authority));
                });
                this.authorities = authorityList;
            }
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
