package com.api.bai5.model2;

import com.api.bai5.entity.UsersEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
//chuyển đổi từ đối tượng UsersEntity sang đối tượng UserDetails
// được sử dụng bởi Spring Security để xác thực và ủy quyền người dùng.
public class UserDetailsAdapter implements UserDetails {
    private UsersEntity usersEntity;

    public UserDetailsAdapter(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();
        usersEntity.getUserRoleEntities().forEach(ur -> {
            roles.add(new SimpleGrantedAuthority(ur.getRolesByRoleId().getName()));
        });
        return roles;
    }

    @Override
    public String getPassword() {
        return this.usersEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return this.usersEntity.getUsername();
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
        return this.usersEntity.getStatus();
    }

}
