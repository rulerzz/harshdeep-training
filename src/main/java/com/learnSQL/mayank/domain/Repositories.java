package com.learnSQL.mayank.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.List;



@Entity
@Table(name = "repository")
public class Repositories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "repo_id")
	private Integer id;
	
	@Column(name = "repo_name")
	private String name;
	
	@Column(name = "repo_details")
	private String details;
	
	@Column(name = "repo_URL")
	private String url;

	@Column(name = "repo_license")
	private String license;
	
	@Column(name = "repo_tags")
	private String tags;
	
	@Column(name = "repo_categories")
	private String categories;
	
	@Column(name = "repo_USedBy")
	private Integer usedBy;
	
	@Column(name = "repo_ranking")
	private Integer ranking;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "package_id", referencedColumnName = "package_id")
	private Packages packages;
	
	@OneToMany(mappedBy = "repository")
	private List<Version> version;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public Integer getUsedBy() {
		return usedBy;
	}

	public void setUsedBy(Integer usedBy) {
		this.usedBy = usedBy;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public Packages getPackages() {
		return packages;
	}

	public void setPackages(Packages packages) {
		this.packages = packages;
	}

	public List<Version> getVersion() {
		return version;
	}

	public void setVersion(List<Version> version) {
		this.version = version;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	
	
}
