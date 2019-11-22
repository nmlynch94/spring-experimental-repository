package com.example.demo.entities;

import com.example.demo.domain.DomainObject;
import org.hibernate.annotations.Cascade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class User {
public class User extends DomainObject  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	@OneToMany (
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	@JoinColumn(name = "user_id")
	private Collection<Privilege> grantedRoles;

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}

	public String getUsername(){
		return username;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public Collection<Privilege> getGrantedRoles(){
		return grantedRoles;
	}

	public void setGrantedRoles(Collection<Privilege> grantedRoles){
		this.grantedRoles = grantedRoles;
	}
}
