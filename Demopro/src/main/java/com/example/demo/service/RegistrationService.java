package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.bean.DemouserBean;
import com.example.demo.common.ResponseMessageBean;

@Service
public interface RegistrationService {
	
	public boolean register(DemouserBean demouserBean);

	public boolean emailCheck(String email);
}
