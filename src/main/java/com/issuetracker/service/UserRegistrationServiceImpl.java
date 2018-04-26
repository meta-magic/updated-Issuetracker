
package com.issuetracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issuetracker.dto.Registration;
import com.issuetracker.exceptions.BaseException;
import com.issuetracker.exceptions.PersistenceFailureException;
import com.issuetracker.model.Login;
import com.issuetracker.model.User;
import com.issuetracker.repository.LoginRepository;
import com.issuetracker.repository.UserRepository;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private UserRepository reUserRepository;

	@Override
	public void save(Registration registration) throws BaseException {
		try {
			if(registration.getLoginId()!=null) {
				Login loginobj = loginRepository.findByLoginId(registration.getLoginId());
				if (loginobj != null) {
					throw new BaseException("Email id already exits");
				}	
			}
			
		} catch (PersistenceFailureException e1) {
			e1.printStackTrace();
		}
		Login login = new Login(registration.getLoginId(), registration.getPassword());

		try {
			loginRepository.save(login);
			// loginRepository.findByLoginId(login);
		} catch (PersistenceFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("in User RegisterImpl for user");
		User user = new User(registration.getFirstName(), registration.getLastName(), login.getId(), 1);
		try {

			reUserRepository.save(user);
		} catch (PersistenceFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// private void saveUser(Registration registration) {
	// Save User Credentials
	/*
	 * User user = new User(registration.getFirstName(),
	 * registration.getLastName()); try { reUserRepository.save(user); } catch
	 * (PersistenceFailureException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 */

	// Find by Login_id

	// private void saveLogin(Registration registration) {
	// Save Login Credentials
	/*
	 * Login login = new Login(registration.getLoginId(),
	 * registration.getPassword()); try { loginRepository.save(login);
	 * 
	 * } catch (PersistenceFailureException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 */
}
