package net.codejava.spring.model;

import java.util.HashSet;
import java.util.Set;//note that set is there is hibernate.mapping too but we need to refer util.set

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="project")
public class Project{/// why  serializable?
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="pid")
	private long id;
	
	
	@Column(name="code")
	private String code;
	
	@Column(name="description")
	private String description;
	//private Set<Sector> sectors;//= new HashSet<Sector>(0); //? why  n why set--->one to many but didbn't understand the reason.
	public Project()
	{
		
	}
	public Project(int id, String code, String description/*, Set<Sector> sectors*/) {
		//super();
		this.id=id;
		this.code = code;
		this.description = description;
		//this.sectors = sectors;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	/*public Set<Sector> getSectors() {
		return sectors;
	}
	public void setSectors(Set<Sector> sectors) {
		this.sectors = sectors;
	}*/
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}


	

}
