package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.bean.DemouserBean;
import com.example.demo.common.ResponseMessageBean;

@Service
public interface LoginService {
	
	public boolean auth(DemouserBean demouserBean);
}
