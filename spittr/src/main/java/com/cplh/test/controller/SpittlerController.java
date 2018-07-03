package com.cplh.test.controller;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cplh.test.data.Spittle;
import com.cplh.test.data.SpittleRepository;



@Controller
@RequestMapping("/spittles")
public class SpittlerController {

  private static final String MAX_LONG_AS_STRING = "9223372036854775807";

  private SpittleRepository spitterRepository;

  @Autowired
  public SpittlerController(SpittleRepository spitterRepository) {
    this.spitterRepository = spitterRepository;
  }
  
  @RequestMapping(value="/register", method=GET)
  public String showRegistrationForm() {
    return "registerForm";
  }
  
  @RequestMapping(method=RequestMethod.GET)
  public List<Spittle> spittles(
      @RequestParam(value="max",defaultValue=MAX_LONG_AS_STRING) long max,
      @RequestParam(value="count", defaultValue="20") int count) {
    return spitterRepository.findList(max, count);
  }
  
//  @RequestMapping(method=RequestMethod.GET)
//  public String spittles(Model model){
//	  model.addAllAttributes(spitterRepository.findList(1000,20));
//	  return "spittles";
//  }
  
  
  	@RequestMapping(value="/{spittleId}",method=RequestMethod.GET)
  	public String showSpittle(@PathVariable(value="spittleId") long spittleId,Model model){
  		Spittle spittle=spitterRepository.findOne(spittleId);
  		model.addAttribute(spittle);
  		return "show";
  	}
  
  	@RequestMapping(value="/save",method=RequestMethod.POST)
  	public String show(Spittle spittle){
  		System.out.println(spittle.getName());
  		spitterRepository.save(spittle);
  		return "redirect:/";
  	}
  
  
}
