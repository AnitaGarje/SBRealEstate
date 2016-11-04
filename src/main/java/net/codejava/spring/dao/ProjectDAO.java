package net.codejava.spring.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.codejava.spring.model.Project;

public interface ProjectDAO extends CrudRepository<Project, Long>{
		 
}
