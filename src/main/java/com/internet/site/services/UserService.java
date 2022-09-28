package com.internet.site.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.internet.site.repos.ICommentRepo;
import com.internet.site.repos.ILikeRepo;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.internet.site.entitys.User;
import com.internet.site.repos.IUserRepo;

@Service
public class UserService {

	
	IUserRepo iuserRepo;
	ILikeRepo iLikeRepo;
	ICommentRepo iCommentRepo;


	public UserService(IUserRepo iuserRepo, ILikeRepo iLikeRepo,
					   ICommentRepo iCommentRepo) {
		this.iuserRepo = iuserRepo;
		this.iLikeRepo = iLikeRepo;
		this.iCommentRepo = iCommentRepo;
	}

	public List<User> getAllUsers() {
		return iuserRepo.findAll();
	}

	public User saveOneUser(User newUser) {
		return iuserRepo.save(newUser);
	}

	public User getOneUser(Long userId) {
		
		return iuserRepo.findById(userId).orElse(null);
	}

	public User updateUser(Long userId, User newUser) {
		Optional<User> user = iuserRepo.findById(userId);
		if(user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			iuserRepo.save(foundUser);
			return foundUser;
		}else
			return null;
	}

	public void deleteById(Long userId) {
		try{
		iuserRepo.deleteById(userId);
	}catch(
	EmptyResultDataAccessException e) {
		System.out.println("User "+userId+" doesn't exist");
	}
	}
	public User getOneUserByUserName(String userName) {
		return iuserRepo.findByUserName(userName);
	}

	public List<Object> getUserActivity(Long userId) {
		List<Long> commentIds = iCommentRepo.findTopByUserId(userId);
		if(commentIds.isEmpty())
		return null;
		List<Object> likes = iLikeRepo.findUserLikesByCommentId(commentIds);
		List<Object> result = new ArrayList<>();
		result.addAll(likes);
		return result;}
}
