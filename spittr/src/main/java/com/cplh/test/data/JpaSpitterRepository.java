package com.cplh.test.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSpitterRepository extends JpaRepository<Spittle,Long>,JpaSpittleRepositoryCustom{
	public Spittle findByid(Long id);
	@Query("select spittle from Spittle where id=:id")
	public List<Spittle> findBySpitterId(@Param("id") long id);
}
