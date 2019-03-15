package com.rexpress.common.dao;

public interface CrudDao <ENTITY , PK>  {
	
	public Class<ENTITY> getDaoTypeClass();
	
	public void create(ENTITY entity);
	
	
	
}
