package manymap;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Emp {
	@Id
	private int eId;
	private String ename;
	@ManyToMany
	private List<Project> projects;
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(int eId, String ename, List<Project> projects) {
		super();
		this.eId = eId;
		this.ename = ename;
		this.projects = projects;
	}
	@Override
	public String toString() {
		return "Emp [eId=" + eId + ", ename=" + ename + ", projects=" + projects + "]";
	}
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
}
