package com.issuetracker.repository;

import org.springframework.stereotype.Repository;

import com.issuetracker.exceptions.PersistenceFailureException;
import com.issuetracker.model.User;

@Repository("UserRepository")
public interface UserRepository {
	
	public User findbyloginId(String login_id) throws PersistenceFailureException;
	public User save(User user) throws PersistenceFailureException;

	public void update(String login_id) throws PersistenceFailureException;

	public void delete(String login_id) throws PersistenceFailureException;

}
