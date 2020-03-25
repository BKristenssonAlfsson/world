package se.snowcatsystems.traveldiary.user;

import org.springframework.security.core.GrantedAuthority;


enum Role implements GrantedAuthority {
    ROLE_ADMIN, ROLE_USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
