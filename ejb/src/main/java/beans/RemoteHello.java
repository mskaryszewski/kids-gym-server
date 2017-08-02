package beans;

import javax.ejb.Remote;

@Remote
public interface RemoteHello {
	
	String hello();

}
