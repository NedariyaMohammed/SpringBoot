package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int userid;
	
    @Column
    @Size(min = 4 ,message = "Username Length should be of minimum 4 character")
    String username;
     
    @Pattern(regexp = "^[a-z0-9\\.]+@[a-z]+\\.[a-z]{3}$" , message = "Email is invalid ")
    String email;
    
    @Pattern(regexp = "^\\d{10}$" , message = "Mobile Number is invalid")
    String mobile;
    
    @Size(min=4,message="password length should be of minimum 4 ")
    String password;
    String authority;
    boolean enabled;
    
    @Embedded
    Address add;
    
    @OneToMany(fetch = FetchType.LAZY ,cascade = CascadeType.ALL ,mappedBy = "user")
    List<Post> posts;
    
    
   
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public Address getAdd() {
		return add;
	}
	public void setAdd(Address add) {
		this.add = add;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
