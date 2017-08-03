package util;

import org.hibernate.Session;

public interface DbOperation<T> {
	
	T execute(Session session);

}
