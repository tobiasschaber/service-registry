Service Registry for integration platforms
================================================

[![Build Status](https://travis-ci.org/denschu/service-registry.png?branch=master)](https://travis-ci.org/denschu/service-registry)

# Features

* REST-API to lookup services
* Activate/Deactivate endpoint with optional message and HTTP-Status 401
* Basic-Authentification
* Mule Connector for Service Lookup
* Oracle-DB as backend

# Build

	cd service-registry
	mvn clean install

# Run locally

Start JVM

	java -jar target/*.jar --spring.profiles.active=security --server.port=8080

Open GUI in the browser
	
	http://localhost:8080/
	
Access API

	curl http://localhost:8080/api/services/service1/versions/1.0.0 -u user:password
	
# System installation 

Create RPM with Maven

	mvn rpm:rpm

Environment configuration file

	/etc/service-registry/environment.properties
	
System configuration file

	/etc/sysconfig/service-registry
	
# Management

Health Endpoint
	
	http://localhost:8080/health
	
Environment information

	http://localhost:8080/env
	
Logging

Can be customized in "/etc/sysconfig/service-registry"

	--logging.file=/var/log/service-registry.log
		
Host Address

Can be customized in "/etc/sysconfig/service-registry"

	--server.address=localhost

Port

Can be customized in "/etc/sysconfig/service-registry"

	--server.port=8080
	
# TODO

REST Dispatcher? Version? Location Transparency?
Swagger
