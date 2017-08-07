package beans;

import javax.ejb.Stateless;
import entity.dao.PersonDAO;

@Stateless
public class HelloBean implements RemoteHello {

	/**
	 * Default constructor.
	 */
	public HelloBean() {
	}

	@Override
	public String hello() {
		PersonDAO personDao = new PersonDAO();
		personDao.performMultipleThings();
		return "hello from bean!";
	}
}
