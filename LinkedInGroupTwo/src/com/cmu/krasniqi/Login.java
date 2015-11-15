package com.cmu.krasniqi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.cmu.krasniqi.domain.User;

@ManagedBean(name = Login.BEAN_NAME)
@SessionScoped
public class Login implements Serializable{

    public static final String BEAN_NAME = "logInBean";

    private boolean dialogVisible = true;
    private boolean showPassword;
    private User u = new User();
    private User newUser = new User();

    List<User> users = new ArrayList<User>();

    public Login() {
    };

    @PostConstruct
    public void init() {
	System.out.println("inside pre costruct");
	u = new User();
    }

    public String executeLogIn() {
	System.out.println("inside: executeLogIn");
	String message = null;

	System.out.println("user = " + u.toString());

	if (users.isEmpty()) {
	    message = "FAIL";
	    System.out.println("no users");

	}

	for (User user : users) {
	    if (user.equals(u)) {
		u = user;
		message = "SUCCESS";
		return "SUCCESS";
	    } else {
		message = "FAIL";
		System.out.println("FAIL");
	    }
	}

	System.out.println(users.toString());

	if ("FAIL".equalsIgnoreCase(message)) {
	    addErrorMessage("User does not exist. Create new user, then sign in. This is how it works");
	    return null;
	}

	return message;
    }

    public String clearUser() {
	this.u.setFirstName(null);
	this.u.setLastName(null);
	this.u.setEmailAddress(null);
	this.u.setPassword(null);
	return null;
    }

    public void createNewUser(ActionEvent event) {

	users.add(newUser);
	addSuccessMessage("User: " + newUser.getEmailAddress()
		+ " has been created");
	clearUser();
	newUser = new User();

    }

    public static void addErrorMessage(String message) {
	addMessage(FacesMessage.SEVERITY_ERROR, message);
    }

    public static void addSuccessMessage(String message) {
	addMessage(FacesMessage.SEVERITY_INFO, message);
    }

    private static void addMessage(FacesMessage.Severity severity,
	    String message) {
	FacesMessage facesMessage = new FacesMessage(severity, message, message);
	FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

    public User getU() {
	return u;
    }

    public void setU(User u) {
	this.u = u;
    }

    public User getNewUser() {
	return newUser;
    }

    public void setNewUser(User newUser) {
	this.newUser = newUser;
    }

    public boolean isDialogVisible() {
	return dialogVisible;
    }

    public void setDialogVisible(boolean dialogVisible) {
	this.dialogVisible = dialogVisible;
    }

    public boolean isShowPassword() {
	return showPassword;
    }

    public void setShowPassword(boolean showPassword) {
	this.showPassword = showPassword;
    }

}
