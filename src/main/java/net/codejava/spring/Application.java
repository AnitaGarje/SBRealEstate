package net.codejava.spring;
import net.codejava.spring.services.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements ApplicationRunner {
 
    @Autowired
    private ProjectService projectService;
 
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
 
    public void run(ApplicationArguments arg0) throws Exception {
        projectService.doService("insertBatch");
    }
 
}