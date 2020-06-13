package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.DemouserBean;
import com.example.demo.common.ResponseMessageBean;
import com.example.demo.entity.Demouser;
import com.example.demo.repo.DemouserRepo;
import com.example.demo.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	private DemouserRepo demouserRepo;
	
	@Override
	public boolean register(DemouserBean demouserBean) {
		int maxUserId = 0;
		String email =demouserBean.getEmail();
		String password = demouserBean.getPassword();
		
		System.out.println(":::demouserRepo.getMaxUserId():::"+ demouserRepo.getMaxUserId());
		
		Demouser demouser = new Demouser(); 
		Demouser demouserTemp =null;
		
		if(!email.isEmpty() && !password.isEmpty()) {
			maxUserId= demouserRepo.getMaxUserId();
			demouser.setUserId(maxUserId+1);
			demouser.setEmail(demouserBean.getEmail());
			demouser.setPassword(demouserBean.getPassword());
			demouserTemp = demouserRepo.save(demouser);
		}
		
		if(demouserTemp!=null) {
			return true;
		}else {
			return false;
		}
	
		
	}

	@Override
	public boolean emailCheck(String email) {
		
		Demouser demouser = null;
		
		if(!email.isEmpty()) {
			demouser=demouserRepo.findByEmail(email.trim());
		}
		
		if(demouser!=null) {
			System.out.println(":::Service:::EmailId already exists:::");
			return true;
		}else {
			return false;
		}
	}
	
}
