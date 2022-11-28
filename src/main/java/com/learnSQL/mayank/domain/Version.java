package com.learnSQL.mayank.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "version")
public class Version {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "version_id")
	private Integer id;
	
	@Column(name = "version_family")
	private String family;
	
	@Column(name = "version_name")
	private String name;
	
	@Column(name = "version_usage")
	private Integer usage;
	
	@Column(name = "vulnerabilities")
	private String vulnerabilities;
	
	@Column(name = "version_date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "repo_id", nullable = false)
	private Repositories repository;

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
		return repository;
	}

	public void setRepositories(Repositories repositories) {
		this.repository = repositories;
	}
	
	

	public Version() {
		super();
	}

	public Version(Integer id, String family, String name, Integer usage, String vulnerabilities, Date date,
			Repositories repositories) {
		super();
		this.id = id;
		this.family = family;
		this.name = name;
		this.usage = usage;
		this.vulnerabilities = vulnerabilities;
		this.date = date;
		this.repository = repositories;
	}

	@Override
	public String toString() {
		return "Version [id=" + id + ", family=" + family + ", name=" + name + ", usage=" + usage + ", vulnerabilities="
				+ vulnerabilities + ", date=" + date + ", repositories=" + repository + ", getId()=" + getId()
				+ ", getFamily()=" + getFamily() + ", getName()=" + getName() + ", getUsage()=" + getUsage()
				+ ", getVulnerabilities()=" + getVulnerabilities() + ", getDate()=" + getDate() + ", getRepositories()="
				+ getRepositories() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
