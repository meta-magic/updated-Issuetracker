package com.issuetracker.exceptions;

/**
 * @author metamagic
 *
 */
public class DataConstraintFailureException extends BaseException {

	private static final long serialVersionUID = -1047015671372925113L;

	public DataConstraintFailureException(String messageId, Throwable throwable) {
		super(messageId, throwable);
	}

	public DataConstraintFailureException(String messageId) {
		super(messageId);
	}
}
