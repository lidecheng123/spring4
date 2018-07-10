package com.cplh.test.data;

import java.util.List;

public interface JpaSpittleRepositoryCustom {
	public List<Spittle> findRecent();
	public List<Spittle> findRecent(int count);
	public List<Spittle> findList(long max,int count);

}
