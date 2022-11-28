package com.learnSQL.mayank.dto;

import java.sql.Date;

import com.learnSQL.mayank.domain.Repositories;

public class VersionDto {
     private Integer id;
	
	
	private String family;
	
	
	private String name;
	
	
	private Integer usage;
	
	
	private String vulnerabilities;
	
	
	private Date date;
	
	private Repositories repositories;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFamily() {
		return family;
	}


	public void setFamily(String family) {
		this.family = family;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getUsage() {
		return usage;
	}


	public void setUsage(Integer usage) {
		this.usage = usage;
	}


	public String getVulnerabilities() {
		return vulnerabilities;
	}


	public void setVulnerabilities(String vulnerabilities) {
		this.vulnerabilities = vulnerabilities;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Repositories getRepositories() {
		return repositories;
	}


	public void setRepositories(Repositories repositories) {
		this.repositories = repositories;
	}
	
	

}
