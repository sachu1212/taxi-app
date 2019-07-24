package com.sameer.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.sameer.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{

	
	 @Query(value="SELECT * FROM User  where username=?1 and password=?2", nativeQuery=true)
	 public User searchUser(String uname,String password);
	 
	
	 
	 
}
