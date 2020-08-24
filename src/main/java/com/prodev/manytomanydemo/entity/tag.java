package com.prodev.manytomanydemo.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="tag")
public class tag implements Serializable{

private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private long tagId;
private String name;

@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy = "tags")
private Set<post> posts=new HashSet<>();

public tag(String name) {
	super();
	this.name = name;
}

public long getTagId() {
	return tagId;
}

public void setTagId(long tagId) {
	this.tagId = tagId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Set<post> getPosts() {
	return posts;
}

public void setPosts(Set<post> posts) {
	this.posts = posts;
}


}
