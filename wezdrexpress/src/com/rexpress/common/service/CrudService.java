package com.rexpress.common.service;

public interface CrudService <ENTITY , PK>{
	
	public void create(ENTITY entity) throws Exception;
}
