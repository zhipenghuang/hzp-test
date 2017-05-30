package com.springmvc.model;

import java.util.ArrayList;
import java.util.List;

public class Localtion{
    private Long id;

    private String name;

    private Long parentId;
    
    private List<Localtion> children = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public List<Localtion> getChildren() {
		return children;
	}

	public void setChildren(List<Localtion> children) {
		this.children = children;
	}

}