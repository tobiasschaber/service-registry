package de.codecentric.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.codecentric.domain.Service;
import de.codecentric.repository.ServiceRepository;

@Controller
public class ServiceRegistryController {

	@Autowired
	ServiceRepository repository;

	@RequestMapping("/api/services")
	public @ResponseBody
	List<Service> showServices() {
		List<Service> services = new ArrayList<Service>();
		for (Service service : repository.findAll()) {
			services.add(service);
		}
		return services;
	}

	@RequestMapping(value = "/api/services", method = RequestMethod.POST)
	public @ResponseBody
	Service saveService(@RequestBody Service service) {
		return repository.save(service);
	}

	@RequestMapping("/api/services/{name}/versions/{version}")
	public @ResponseBody
	String showServiceUrl(@PathVariable(value = "name") String name,
			@PathVariable(value = "version") String version) {
		Service service = repository.findByNameAndVersion(name, version);
		return service.getUrl();
	}

}
