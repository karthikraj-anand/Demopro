package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.bean.DemouserBean;
import com.example.demo.common.ResponseMessageBean;
import com.example.demo.entity.Demouser;
import com.example.demo.repo.DemouserRepo;
import com.example.demo.service.LoginService;
import com.example.demo.service.RegistrationService;

@RestController
////@Controller
public class DemoController {

	/*
	 * @Autowired private DemouserRepo demouserRepo;
	 */
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private DemouserRepo demouserRepo;
	
	@GetMapping(value = "/login")
	public ModelAndView showLoginPage(ModelAndView map) {
		map.setViewName("login");
		return map;
	}
	
	@GetMapping(value = "/signup")
	public ModelAndView showRegisterPage(ModelAndView map) {
		map.setViewName("register");
		return map;
	}
	
	
	  @GetMapping(value = "/getUserList") 
	  public List<DemouserBean> getRegisterdUsers(ModelAndView map) {
	  
		  List<DemouserBean> demouserBeanList = new ArrayList<>();
		  List<Demouser> demouserList= demouserRepo.findAll();
		  
		  if(!demouserList.isEmpty()) {
			  for(Demouser demouserTemp : demouserList) {
				  DemouserBean demouserBean = new DemouserBean();
				  demouserBean.setEmail(demouserTemp.getEmail());
				  demouserBean.setPassword(demouserTemp.getPassword());
				  demouserBeanList.add(demouserBean);
			  }
		  }
		  
		  return demouserBeanList;
	  
	  }
	 
	
	@PostMapping(value = "/auth", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String auth(@RequestBody DemouserBean demouserBean) {
System.out.println(":::"+demouserBean.getEmail());
System.out.println(":::"+demouserBean.getPassword());
		////return loginService.auth(demouserBean);
		if(loginService.auth(demouserBean)) {
			System.out.println(":::Inside:::if:::loginService.auth");
			////map.setViewName("success");
			return "success";
		}else {
			////map.setViewName("error");
			System.out.println(":::Inside:::else:::loginService.auth");
			return "error";
		}
		
	}
	
	@PostMapping(value = "/register")
	public String register(@RequestBody DemouserBean demouserBean) {
		////return registrationService.register(demouserBean);
		if(registrationService.register(demouserBean)) {
			System.out.println(":::Inside:::if:::registrationService.register");
			////map.setViewName("success");
			return "success";
		}else {
			////map.setViewName("error");
			System.out.println(":::Inside:::else:::registrationService.register");
			return "error";
		}
	}
	
	
	@GetMapping(value = "/emailUniqueCheck")
	public String emailCheck(@RequestParam String email) {
		if(!registrationService.emailCheck(email)) {
			System.out.println(":::Inside:::if:::registrationService.emailCheck");
			return "yes";
		}else {
			System.out.println(":::Inside:::else:::registrationService.emailCheck");
			return "no";
		}
	}
	
	@GetMapping(value = "/success")
	public ModelAndView successPage(ModelAndView map) {

		map.setViewName("success");
		return map;

	}
	
	@GetMapping(value = "/error")
	public ModelAndView errorPage(ModelAndView map) {

		map.setViewName("error");
		return map;

	}
}
