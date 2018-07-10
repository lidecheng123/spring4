package com.cplh.test.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JpaSpittleRepositoryImpl implements JpaSpittleRepositoryCustom{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Spittle> findRecent() {		
		return findRecent(10);
	}

	@Override
	public List<Spittle> findRecent(int count) {
		String queryString="select spittle from Spittle spittle where id<"+count;
		List<Spittle> spittles=em.createQuery(queryString).getResultList();
		return spittles;
	}

	@Override
	public List<Spittle> findList(long max, int count) {
		return findRecent((int)(max+count));
	}

}
