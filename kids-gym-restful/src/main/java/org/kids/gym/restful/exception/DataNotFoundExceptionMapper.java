package org.kids.gym.restful.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.kids.gym.restful.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException e) {
		ErrorMessage message = new ErrorMessage(e.getMessage(), 404);
		return Response.status(Status.NOT_FOUND).
				entity(message).
				build();
	}
}
