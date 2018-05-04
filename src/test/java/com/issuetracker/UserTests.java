/*package com.issuetracker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.issuetracker.dto.Registration;
import com.issuetracker.exceptions.PersistenceFailureException;
import com.issuetracker.model.Issue;
import com.issuetracker.model.User;
import com.issuetracker.repository.IssueRrepository;
import com.issuetracker.repository.UserRepository;
import com.issuetracker.service.UserRegistrationService;*/

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
/*public class UserTests {

	// @Autowired
	private UserRepository userRepository;

	@Autowired
	private IssueRrepository issueRrepository;*/
	//
	// @Autowired
	// private UserRegistrationService userReg;

	// @Test
	/*public void save() throws PersistenceFailureException {
		User user = new User("ABC", "yz");

		System.out.println("****Saved Success" + userRepository.save(user));

	}*/

	
	 /*@Test public void saveIssue() throws PersistenceFailureException { 
		 String date_s = " 2011-01-18 00:00:00.0"; 
		 SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss"); 
		 Date date=null;
		try {
			date = dt.parse(date_s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 SimpleDateFormat dt1 = new SimpleDateFormat("yyyyy-mm-dd");
	 Issue issue =new Issue("123", "Server Unavailable", "high", "critical",101, date, "OPEN","server issue");
			 System.out.println("***Saved Issue"+issueRrepository.save(issue)); }*/
	/*@Test
	public void saveIssue()throws PersistenceFailureException{
		Issue issue=new Issue("123","API Unavilable","high","FATAL",1,new Date(),"Open","API Issue");
		System.out.println("*** Saved Issue"+issueRrepository.save(issue));
	}
	*/

	// @Test
	// public void register() throws PersistenceFailureException{
	// Registration reg = new Registration("JJJ", "AAA", "789", "789");
	// userReg.save(reg);
	// System.out.println("%%%");
	// }

//}
