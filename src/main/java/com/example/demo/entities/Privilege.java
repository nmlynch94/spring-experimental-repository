package com.example.demo.entities;

import com.example.demo.entities.enums.Authorities;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Privilege implements GrantedAuthority {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String authority;

	public void setAuthority(Authorities authorities) {
		this.authority = authorities.getRoleName();
	}

	@Override public String getAuthority(){
		return authority;
	}
}
