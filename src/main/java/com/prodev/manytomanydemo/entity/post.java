package com.prodev.manytomanydemo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="post")
public class post implements Serializable{

private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private long potId;
private String title,description,content;
private  Date postedDate,lastedUpdatedDate;

@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
@JoinTable(name="post_tag",
joinColumns = {@JoinColumn(name="postId")},
inverseJoinColumns = {@JoinColumn(name="tagId")})
private Set<tag> tags=new HashSet<>();

public post(String title, String description, String content) {
	this.title = title;
	this.description = description;
	this.content = content;
}
public long getPotId() {
	return potId;
}
public void setPotId(long potId) {
	this.potId = potId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Date getPostedDate() {
	return postedDate;
}
public void setPostedDate(Date postedDate) {
	this.postedDate = postedDate;
}
public Date getLastedUpdatedDate() {
	return lastedUpdatedDate;
}
public void setLastedUpdatedDate(Date lastedUpdatedDate) {
	this.lastedUpdatedDate = lastedUpdatedDate;
}
public Set<tag> getTags() {
	return tags;
}
public void setTags(Set<tag> tags) {
	this.tags = tags;
}


}
