package com.rexpress.common.service;

import com.rexpress.common.dao.CrudDao;

public  abstract class CrudServiceImp<ENTITY, PK> implements CrudService<ENTITY, PK>  {
	
	protected abstract CrudDao <ENTITY, PK> getCrudDao();

	@Override
	public void create(ENTITY entity) throws Exception {
		getCrudDao().create(entity);
	}
}
