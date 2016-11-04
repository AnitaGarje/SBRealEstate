package net.codejava.spring.services;

import java.util.ArrayList;
import java.util.List;







import net.codejava.spring.dao.ProjectDAO;
import net.codejava.spring.model.Project;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.util.Assert;


@Service("projectService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProjectServiceImpl implements ProjectService{
	
	 @Autowired
	    private ProjectDAO projectDAO;
	 
	    public Object doService(Object... args) throws Exception {
	        Assert.notNull(args[0]);
	        if (args[0].equals("insertBatch")) {
	            projectDAO.save(projectData());
	            return true;
	        } else if (args[0].equals("insert")) {
	            projectDAO.save((Project) args[1]);
	            return 1;
	        } else if (args[0].equals("update")) {
	            projectDAO.save((Project) args[1]);
	            return 1;
	        } else if (args[0].equals("delete")) {
	            long id = Long.parseLong((String) args[1]);
	            projectDAO.delete(id);
	            return 1;
	        } else if (args[0].equals("getAll")) {
	            return projectDAO.findAll();
	        }
	        return null;
	    }
	    private List<Project> projectData() {
	        List<Project> projects = new ArrayList<Project>();
	        projects.add(new Project(1, "PR001", "Proejct1111111"));
	        projects.add(new Project(3, "PR002", "Proejct22222"));
	        return projects;
	    }
}
