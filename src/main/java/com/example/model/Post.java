package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="posts")
public class Post 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int postid;
   @Column
   @Size(min = 4 , message = "Post title Length should be of minimum 4 character")
   private String posttitle;
   
   @Size(min = 10 ,max = 150,message = "message Length should be of minimun 10-150 character")
   private String message;
   
   @ManyToOne(fetch =FetchType.EAGER)
   User user;

		public int getPostid() {
			return postid;
		}
		
		public void setPostid(int postid) {
			this.postid = postid;
		}
		
		public String getPosttitle() {
			return posttitle;
		}
		
		public void setPosttitle(String posttitle) {
			this.posttitle = posttitle;
		}
		
		public String getMessage() {
			return message;
		}
		
		public void setMessage(String message) {
			this.message = message;
		}
		
		public User getUser() {
			return user;
		}
		
		public void setUser(User user) {
			this.user = user;
		}
   
   
}
