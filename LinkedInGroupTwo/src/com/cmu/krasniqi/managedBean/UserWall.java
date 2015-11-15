package com.cmu.krasniqi.managedBean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.cmu.krasniqi.Login;
import com.cmu.krasniqi.domain.User;

@ManagedBean(name = UserWall.BEAN_NAME)
@ViewScoped
public class UserWall implements Serializable{
	
	public static final String BEAN_NAME = "userWall";
	private String newExerience = "";
	private String newSkill = "";
	private String newEducation = "";
	private String newGroup = "";
	private String newFollowing = "";
	
	Class<UserWall> clazz = UserWall.class;
	User user = null;

	@ManagedProperty(value="#{logInBean}")
	private Login logInBean;
	
	public UserWall(){}
	
	@PostConstruct
	public void init() {
		System.out.println("Initializing: " + clazz);
		
		if(null != logInBean){
			user = new User(logInBean.getU());
			logInBean.init();
			System.out.println(user.toString());
		}
	}
	
	public String addExperience(){
		 this.user.getExperience().add(this.newExerience);
		 System.out.println(user.getExperience().toString());
		 return null;
	}
	
	public String addSkill(){
		 this.user.getSkills().add(this.newSkill);
		 return null;
	}
	
	public String addEducation(){
		 this.user.getEducation().add(this.newEducation);
		 return null;
	}
	
	public String addGroup(){
		 this.user.getGroups().add(this.newGroup);
		 return null;
	}
	
	public String addFollowing(){
		 this.user.getFollowing().add(this.newFollowing);
		 return null;
	}
	
	
	public String getSkills(){
		return this.user.getSkills().toString();
	}
	
	public String getExperience(){
		return this.user.getExperience().toString();
	}
	
	public String getEducation(){
		return this.user.getEducation().toString();
	}
	
	public String getGroups(){
		return this.user.getGroups().toString();
	}
	
	public String getFollowing(){
		return this.user.getFollowing().toString();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Login getLogInBean() {
		return logInBean;
	}

	public void setLogInBean(Login logInBean) {
		this.logInBean = logInBean;
	}

	public String getNewExerience() {
		return newExerience;
	}

	public void setNewExerience(String newExerience) {
		this.newExerience = newExerience;
	}

	public String getNewSkill() {
		return newSkill;
	}

	public void setNewSkill(String newSkill) {
		this.newSkill = newSkill;
	}

	public String getNewEducation() {
		return newEducation;
	}

	public void setNewEducation(String newEducation) {
		this.newEducation = newEducation;
	}

	public String getNewGroup() {
		return newGroup;
	}

	public void setNewGroup(String newGroup) {
		this.newGroup = newGroup;
	}

	public String getNewFollowing() {
		return newFollowing;
	}

	public void setNewFollowing(String newFollowing) {
		this.newFollowing = newFollowing;
	}
	
	
}
