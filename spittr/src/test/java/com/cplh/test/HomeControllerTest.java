package com.cplh.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import com.cplh.test.controller.SpittlerController;
import com.cplh.test.data.JpaSpitterRepository;
import com.cplh.test.data.Spittle;
import com.cplh.test.data.SpittleRepository;


public class HomeControllerTest {
	
		
	@Test
	public void homeControllerTest() throws Exception {
		List<Spittle> exceptedSpittle=createSpittleList(20);
		JpaSpitterRepository mockRepository=mock(JpaSpitterRepository.class);
		when(mockRepository.findList(Long.MAX_VALUE, 20)).thenReturn(exceptedSpittle);
		
		SpittlerController spittlerController=new SpittlerController(mockRepository);
		MockMvc mockMvc=standaloneSetup(spittlerController).build();
		mockMvc.perform(get("/spittles")).andExpect(view().name("show"));
//		.andExpect(model().attributeExists("spittleList")).andExpect(model().attribute("spittleList", exceptedSpittle));
		
	}
	
	@Test
	public void spittleControllerTest() throws Exception{
		JpaSpitterRepository respository=mock(JpaSpitterRepository.class);
		SpittlerController spittleController=new SpittlerController(respository);
		MockMvc mockMvc=standaloneSetup(spittleController).build();
		mockMvc.perform(post("/spittles/save").param("id", "1").param("name", "test"))
		.andExpect(model().attributeExists("id"));
	}
	
	private List<Spittle> createSpittleList(int count){
		List<Spittle> spittles=new ArrayList<Spittle>();
		for(int i=0;i<20;i++){
			spittles.add(new Spittle("spittle"+i,Long.valueOf(i)));
		}
		return spittles;
	}

}
