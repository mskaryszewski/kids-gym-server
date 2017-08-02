package beans;

import javax.ejb.Stateless;

@Stateless
public class HelloBean implements RemoteHello {

    /**
     * Default constructor. 
     */
    public HelloBean() {
    }

	@Override
	public String hello() {
		System.out.println("HELLO");
		return null;
	}
}
