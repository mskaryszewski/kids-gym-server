package org.kids.gym.restful.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.skaryszewski.kidsgym.beans.ChildBean;
import com.skaryszewski.kidsgym.entity.child.Child;

/**
 * Root resource (exposed at "children" path)
 */
@Path("children")
public class ChildResource {
	
	//TODO: this should be annotated with @EJB to be managed by the container
	ChildBean service = new ChildBean();

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return Child object that will be returned as a xml response.
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Child getChild(@PathParam("id") long childId) {
        return service.getChild(childId);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Child> getChildren() {
        return service.getAllChildren();
    }
}
