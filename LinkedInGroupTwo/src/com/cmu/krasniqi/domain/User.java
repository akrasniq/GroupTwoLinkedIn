package com.cmu.krasniqi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{

	private String firstName;
	private String lastName;
	private String emailAddress;
	private String password;
	private List<String> experience = new ArrayList<String>();
	private List<String> skills = new ArrayList<String>();
	private List<String> education = new ArrayList<String>();
	private List<String> groups = new ArrayList<String>();
	private List<String> following = new ArrayList<String>();
	
	public User(){
		
	}
	
	public User(String emailAddress, String password) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
	}
	
	public User(String firstName, String lastName, String emailAddress,
			String password, List<String> experience, List<String> skills,
			List<String> education, List<String> groups, List<String> following) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.password = password;
		this.experience = experience;
		this.skills = skills;
		this.education = education;
		this.groups = groups;
		this.following = following;
	}
	
	public User(User u){
		this.firstName = u.getFirstName();
		this.lastName = u.getLastName();
		this.emailAddress = u.getEmailAddress();
		this.password = u.getPassword();
		this.experience = u.getExperience();
		this.skills = u.getSkills();
		this.education = u.getEducation();
		this.groups = u.getGroups();
		this.following = u.getFollowing();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		
		if(emailAddress.equals(other.emailAddress) && password.equals(other.password))
		    return true;
		else
		    return false;
	}

	@Override
	public String toString() {
	    return "User [firstName=" + firstName + ", lastName=" + lastName
		    + ", emailAddress=" + emailAddress + ", password="
		    + password + ", experience=" + experience + ", skills="
		    + skills + ", education=" + education + ", groups="
		    + groups + ", following=" + following + "]";
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getExperience() {
		return experience;
	}
	public void setExperience(List<String> experience) {
		this.experience = experience;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public List<String> getEducation() {
		return education;
	}
	public void setEducation(List<String> education) {
		this.education = education;
	}
	public List<String> getGroups() {
		return groups;
	}
	public void setGroups(List<String> groups) {
		this.groups = groups;
	}
	public List<String> getFollowing() {
		return following;
	}
	public void setFollowing(List<String> following) {
		this.following = following;
	}
}
