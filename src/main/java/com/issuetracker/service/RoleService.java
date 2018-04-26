package com.issuetracker.service;

import com.issuetracker.exceptions.PersistenceFailureException;
import com.issuetracker.model.Role;

public interface RoleService {
	public Role findbyroleId(Long roleId) throws PersistenceFailureException ;

	public Role savebyroleId(Long  roleId)throws PersistenceFailureException;
}
