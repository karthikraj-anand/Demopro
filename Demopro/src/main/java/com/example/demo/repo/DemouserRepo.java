package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Demouser;

public interface DemouserRepo extends JpaRepository<Demouser, Integer>{
	Demouser findByEmailAndPassword(String email,String password);
	
	@Query("SELECT coalesce(max(u.userId), 0) FROM Demouser u")
	Integer getMaxUserId();

	Demouser findByEmail(String email);
}
