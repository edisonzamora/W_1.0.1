package com.rexpress.common.service;

public interface CrudService <ENTITY , PK>{
	
	public void createCrudService(ENTITY entity) throws Exception;
}
