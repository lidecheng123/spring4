package com.cplh.test.controller;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.cplh.test.data.JpaSpitterRepository;
import com.cplh.test.data.Spittle;
import com.cplh.test.data.SpittleRepository;
import com.cplh.test.exception.DuplicateSpittrException;



@Controller
@RequestMapping("/spittles")
public class SpittlerController {

  private static final String MAX_LONG_AS_STRING = "0";
  
//  @Autowired
//  private MultipartFile profilePicture;

  private JpaSpitterRepository spitterRepository;

  @Autowired
  public SpittlerController(JpaSpitterRepository spitterRepository) {
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
	  List<Spittle> spittles=spitterRepository.findList(max, count);
    return spittles;
  }
  
//  @RequestMapping(method=RequestMethod.GET)
//  public String spittles(Model model){
//	  model.addAllAttributes(spitterRepository.findList(1000,20));
//	  return "spittles";
//  }
  
  
  	@RequestMapping(value="/{spittleId}",method=RequestMethod.GET)
  	public String showSpittle(@PathVariable(value="spittleId") long spittleId,Model model){
  		Spittle spittle=spitterRepository.findByid(spittleId);
  		model.addAttribute(spittle);
  		return "show";
  	}
  
  	@RequestMapping(value="/save",method=RequestMethod.POST)
  	public String show(@RequestPart("profilePicture") MultipartFile profilePicture,@Valid Spittle spittle,Errors errors) {
  		if(errors.hasErrors()){
  			System.out.println(errors);
  			throw new DuplicateSpittrException("故意抛的一个异常");
//  		return "show";
  		}
  		
  		System.out.println(profilePicture.getName());
  		spitterRepository.save(spittle);
  		return "redirect:/";
  	}
  
  
}
