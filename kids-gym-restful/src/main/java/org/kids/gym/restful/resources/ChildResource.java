package org.kids.gym.restful.resources;

import java.util.List;

import javax.management.MXBean;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.skaryszewski.kidsgym.beans.ChildBean;
import com.skaryszewski.kidsgym.entity.child.Child;

@Path("children")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_JSON)
public class ChildResource {
	
	//TODO: this should be annotated with @EJB to be managed by the container
	ChildBean service = new ChildBean();

    @GET
    @Path("/{id}")
    public Child getChild(@PathParam("id") long childId) {
        return service.getChild(childId);
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
    public Child addChild(Child child) {
    	return service.saveChild(child);
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
