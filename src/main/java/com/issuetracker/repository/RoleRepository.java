package com.issuetracker.repository;

import com.issuetracker.exceptions.PersistenceFailureException;
import com.issuetracker.model.Role;


public interface RoleRepository {
	
public Role findbyroleId(Long roleId) throws PersistenceFailureException ;
public Role save(Long roleId) throws PersistenceFailureException;

public void update(Long roleId) throws PersistenceFailureException;

public void delete(Long roleId) throws PersistenceFailureException;
}
