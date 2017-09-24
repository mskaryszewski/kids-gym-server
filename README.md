# kids-gym-server
Server Side of "Gym For Children" Application

This is a multimodule Maven Enterprise Application. It's main purpose is to build an easy to extend and maintainable framework.
It is achieved thanks to the fact that different functionalities are shipped into a separated modules which communicate with each other.

You can communicate with this application in 2 ways: either call RESTful web service or call a remote EJB.

While reading the code you might wonder where are the functionalities of kids-gym-app, an application for booking gym classes for children.
You are right, they are not there. Actually it's not the purpose of this project.
I am focused on creation a powerful skeleton of enterprise application which is maintainable and well structured. This is what fascinates me the most - pure architecture, good practices and cooperation between modules. When I achieve that (well defined communication to RDBMS and noSQL database, RESTful Web Service, exposed remote services etc.), coding the logic of (any) application will be a piece of cake.

The structure of the application is as follows:
- kids-gym-restful exposes web services with REST API
- kids-gym-entities - EJB entities to be persisted in a DB, they are exposed by DAO. It is advisable not to use DAO directly, we should use a dedicated service:
	- Example:
		- Child (entity) accessed by ChildDAO implementing interface with save(), get(), update() methods
		- ChildDAO is accessed by ChildBean implementing RemoteChild interface
	- ApplicationServer is responsible for establishing a connection to a DB. In my case it is defined in jboss configuration file.
- kids-gym-ejb which defines EJB which perform operations on entities and implement business logic
- kids-gym-library contains all common logic used by other modules, like StringUtils, logging, guava dependency etc 
- kids-gym-resources contains all resources used by application
- kids-gym-config contains config files that are not shipped to an application - they are not part of .ear file. E.g.: standalone.xml jboss config file which should be versioned but is not a part of application itself
- kids-gym-app is a module which wraps all dependencies and build .ear file to be deployed on application server
- kids-gym-client-standalone is an example of standalone client which by remote calls uses remote services. It is not dependent on full kids-gym-ejb module because it should not be aware of any real implementations. It is only dependent on interfaces - it uses only 'client' version of module containing just the interfaces.
- kids-gym-server is a parent module which forces all other modules to be compiled and defines which java version shall be used