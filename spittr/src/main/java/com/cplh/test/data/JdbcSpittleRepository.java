package com.cplh.test.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class JdbcSpittleRepository implements SpittleRepository {

	public JdbcSpittleRepository() {
	}

	@Override
	public List<Spittle> findList(long max, int count) {
		List<Spittle> spittles=new ArrayList<Spittle>();
		for(int i=0;i<20;i++){
			Spittle s=new Spittle("我是spittle"+i,Long.valueOf(i));
			spittles.add(s);
		}
		return spittles;
	}

	@Override
	public Spittle findOne(long id) {
		Spittle s=new Spittle("我是spittle"+id,Long.valueOf(id));
		return s;
	}

	@Override
	public void save(Spittle spittle) {
		
	}

}
