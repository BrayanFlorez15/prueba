package pruebaAngularSpring.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
@AllArgsConstructor
@Getter

public class Authority implements GrantedAuthority {

    private String authority;

}