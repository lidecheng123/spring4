package com.cplh.test.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//@Repository
public class JdbcSpittleRepository implements SpittleRepository {

	private JdbcOperations jdbcOperations;
	
	public JdbcSpittleRepository() {
	}
	
	@Inject
	public JdbcSpittleRepository(JdbcOperations jdbcOperations) {
		this.jdbcOperations=jdbcOperations;
	}

	@Override
	public List<Spittle> findList(long max, int count) {
		List<Spittle> spittles=new ArrayList<Spittle>();
		spittles=jdbcOperations.query("select id,message from Spittle where id < ? and id> ? ", new Object[]{max+count,max}, new RowMapper(){
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Spittle spittle=new Spittle(null,null,null,null,null);
			
				long id=rs.getLong(1);
				String message=rs.getString(2);
				spittle.setId(id);
				spittle.setMessage(message);
				
				return spittle;
			}});
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
