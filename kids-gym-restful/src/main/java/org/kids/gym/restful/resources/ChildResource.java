package org.kids.gym.restful.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.kids.gym.restful.exception.DataNotFoundException;

import javax.ws.rs.core.UriInfo;

import com.skaryszewski.kidsgym.beans.ChildBean;
import com.skaryszewski.kidsgym.entity.child.Child;

@Path("children")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChildResource {
	
	//TODO: this should be annotated with @EJB to be managed by the container
	ChildBean service = new ChildBean();

    @GET
    @Path("/{id}")
    public Response getChild(@PathParam("id") long childId) {
    	Child child = service.getChild(childId);
    	if(null == child) {
    		throw new DataNotFoundException(String.format("Child with id [%d] not found", childId));
    	}
    	return Response
    			.status(Status.CREATED)
    			.entity(child)
    			.build();
    }
    
    @GET
    public List<Child> getChildren(@QueryParam("age") int age) {
    	if(age > 0) {
    		return service.getChildrenOlderThan(age);
    	} else {
    		return service.getAllChildren();    		
    	}
    }
    
    @POST
    public Response addChild(Child child, @Context UriInfo uriInfo) {
    	
    	Child newChild = service.saveChild(child);
    	
    	URI uri = uriInfo
    			.getAbsolutePathBuilder()
    			.path(String.valueOf(child.getId()))
    			.build();
    	
    	return Response.created(uri)
    			.entity(newChild)
    			.build();
    }
    
    @PUT
    @Path("/{id}")
    public Child update(@PathParam("id") long childId, Child child) {
    	child.setId(childId);
    	service.update(child);
    	return child;
    }
    
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") long id) {
    	service.delete(id);
    }
}
