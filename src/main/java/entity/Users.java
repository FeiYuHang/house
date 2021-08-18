package entity;

public class Users {
 private int uid;
 private String name;
 private String password;
 private String telephone;
 private String username;
 
 
 
public Users() {
	super();
	// TODO Auto-generated constructor stub
}
public Users(int uid, String name, String password, String telephone, String username) {
	super();
	this.uid = uid;
	this.name = name;
	this.password = password;
	this.telephone = telephone;
	this.username = username;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
 
 
}
