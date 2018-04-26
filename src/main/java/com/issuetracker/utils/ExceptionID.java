package com.issuetracker.utils;

public interface ExceptionID {

	/** SUCCESS MESSAGE ID'S */
	public final String SUCCESS_SAVE = "success.save";
	public final String SUCCESS_UPDATE = "success.update";
	public final String SUCCESS_DELETE = "success.delete";
	public final String SUCCESS_RETRIEVE = "success.retrieve";
	public final String INSTANCE_START = "instance.start";
	public final String INSTANCE_STOP = "instance.stop";
	public final String SUCCESS_APPROVED = "success.approved";
	public final String SUCCESS_REJECTED = "success.rejected";
	public final String SUCCESS_USER_CONSTRAINT_CHECK = "success.userconstraintcheck";
	public final String VALID_USERCREDENTIALS="success.msg";
	
	
	/** TOKEN RELATED ID'S */
	public final String TOKEN_REQUIRED = "token.required";
	public final String TOKEN_EXPIRED = "token.expired";
	public final String TOKEN_INVALID = "token.invalid";

	/** ERROR MESSAGE ID'S */
	public final String ERROR_GLOBAL = "error.global";
	public final String ERROR_SAVE = "error.save";
	public final String ERROR_UPDATE = "error.update";
	public final String ERROR_DELETE = "error.delete";
	public final String ERROR_RETRIEVE = "error.retrieve";
	public final String ERROR_VALIDATION = "error.validation";
	public final String INVALID_USERSESSION = "invalid.usersession";
	public final String USER_NOTFOUND = "user.notfound";
	public final String ERROR_APPROVED = "error.approved";
	public final String ERROR_REJECTED = "error.rejected";
	public final String ERROR_USER_CONSTRAINT_CHECK = "error.userconstraintcheck";
	public final String INVALID_USER_CREDENTIALS="error.msg";

}