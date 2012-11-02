package com.example.day3.model;

import java.util.List;

public class TwitterModel {
	private List<Tweet> results;

	public List<Tweet> getResults() {
		return results;
	}

	public void setResults(List<Tweet> results) {
		this.results = results;
	}

	public class Tweet {
		private String from_user;
		private String text;
		private String profile_image_url;

		public String getFrom_user() {
			return from_user;
		}
		public void setFrom_user(String from_user) {
			this.from_user = from_user;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public String getProfile_image_url() {
			return profile_image_url;
		}
		public void setProfile_image_url(String profile_image_url) {
			this.profile_image_url = profile_image_url;
		}
	}
}
