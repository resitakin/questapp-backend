package com.example.questapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user")

public class User {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)

		long id;
		String userName;
		String password;
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getAvatar() {
			// TODO Auto-generated method stub
			return 0;
		}
		

	
	}


