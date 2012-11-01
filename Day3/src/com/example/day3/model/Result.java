package com.example.day3.model;

public class Result {
	private TorestoUser result;
	
	public TorestoUser getResult() {
		return result;
	}

	public void setResult(TorestoUser result) {
		this.result = result;
	}

	public class TorestoUser {
		private String username;
		private String password;
		private String valid;

		public String getUsername() {
			return username;
		}
		public void setUsername(String user) {
			this.username = user;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getValid() {
			return valid;
		}
		public void setValid(String valid) {
			this.valid = valid;
		}
	}
}
