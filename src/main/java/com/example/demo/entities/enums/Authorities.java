package com.example.demo.entities.enums;

public enum Authorities {
	LOGIN("AUTHORITY_LOGIN"),
	CREATE_ACCOUNT("AUTHORITY_CREATE_ACCOUNT");

	private String roleName;

	Authorities(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}
}
