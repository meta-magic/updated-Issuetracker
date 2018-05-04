package com.issuetracker.dto;

public class UserDTO {
	private int userId;

	private String tokenId;

	public UserDTO(int userId, String tokenId) {
		super();
		this.userId = userId;
		this.tokenId = tokenId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

}
