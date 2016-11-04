package net.codejava.spring;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.codejava.spring.dao.ProjectDAO;
import net.codejava.spring.model.Project;
import net.codejava.spring.model.ResponseObject;
import net.codejava.spring.services.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Handles requests for the application home page.
 */
@RestController  //note this for REST ful API
public class ProjectController {
	
	
	 @Autowired
	 private ProjectService projectService;

 
	 //-------------------Retrieve All projects--------------------------------------------------------
     
	 	@SuppressWarnings("unchecked")
	    @RequestMapping(value = "/projects", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<Project> projectInfo() throws Exception {
	        return (List<Project>) projectService.doService("getAll");
	    }
	    
	  
	  //-------------------Create a Project--------------------------------------------------------
	      
	    @RequestMapping(value = "/projects", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseObject createProject(@RequestBody Project project) throws Exception {
	        return getResponseObject((Integer) projectService.doService("insert", project));
	    }
	
	    
	  //------------------- Update a Project --------------------------------------------------------
	      
	    @RequestMapping(value = "/projects", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseObject updateProject(@RequestBody Project project) throws Exception {
	        return getResponseObject((Integer) projectService.doService("update", project));
	    }
	     
	    //------------------- Delete a Project --------------------------------------------------------
	      
	    @RequestMapping(value = "/projects", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseObject deleteProject(@RequestBody String id) throws Exception {
	        return getResponseObject((Integer) projectService.doService("delete", id));
	    }
	    
	    private ResponseObject getResponseObject(Integer output){
	        return new ResponseObject(output == 1 ? true : false, output == 1 ? "successful" : "failed");
	    }
	  
	      
	     
	
	 
}
