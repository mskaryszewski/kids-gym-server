# kids-gym-server
Enterprise Application Skeleton

A multi-module Maven enterprise application designed for extensibility, maintainability, and structured development. It integrates key features such as database connectivity, REST API exposure, and EJB-based services.

Integration Methods

This application supports two integration approaches:

RESTful Web Services – Direct API calls for seamless interaction.

Remote EJB – Enables distributed service execution.

Project Purpose

Unlike a fully developed business application, this project serves as a scalable framework rather than implementing specific functionalities like those in the kids-gym-app. The goal is to establish a robust foundation with well-defined communication to RDBMS and NoSQL databases (Cassandra), RESTful services, and remote EJBs, making future business logic implementation effortless.

Application Structure
- kids-gym-restful - Exposes web services via REST API
- kids-gym-entities - Defines EJB entities for database persistence, accessed via DAO and dedicated services:
	- Example:
		- ChildDAO implements an interface with save(), get(), and update() methods
		- ChildBean accesses ChildDAO via RemoteChild interface
	- ApplicationServer Manages database connections, configured via JBoss.
- kids-gym-ejb - Implements business logic and entity operations
- kids-gym-library - Houses shared utilities like StringUtils, logging, and dependencies
- kids-gym-resources - Stores application resources
- kids-gym-config - Contains configuration files not included in the .ear package (e.g., standalone.xml for JBoss)
- kids-gym-app - Aggregates dependencies and builds the .ear file for deployment on the application server
- kids-gym-client-standalone - Provides a standalone client for remote service calls, relying solely on interfaces rather than full kids-gym-ejb implementations
- kids-gym-server - Serves as the parent module, ensuring compilation of all submodules and defining the required Java version
