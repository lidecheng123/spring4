package com.cplh.test.data;

import java.util.List;

public interface SpittleRepository {
	public List<Spittle> findList(long max,int count);
	public Spittle findOne(long id);
	public void save(Spittle spittle);
}
