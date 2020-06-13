package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.DemouserBean;
import com.example.demo.common.ResponseMessageBean;
import com.example.demo.entity.Demouser;
import com.example.demo.repo.DemouserRepo;
import com.example.demo.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private DemouserRepo demouserRepo;

	@Override
	public boolean auth(DemouserBean demouserBean) {
		
		Demouser demouser = null;
		
		String email =demouserBean.getEmail();
		String password = demouserBean.getPassword();
		
		if(!email.isEmpty() && !password.isEmpty()) {
			demouser=demouserRepo.findByEmailAndPassword(email, password);
		}
		
		if(demouser!=null) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
}
