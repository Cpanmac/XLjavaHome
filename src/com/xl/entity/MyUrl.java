package com.xl.entity;

public class MyUrl {
	private String name;
	private String imageUrl;
	private String url;

	public MyUrl() {
		super();
	}

	public MyUrl(String imageName, String imageUrl, String url) {
		super();
		this.name = imageName;
		this.imageUrl = imageUrl;
		this.url = url;
	}

	public String getImageName() {
		return name;
	}

	public void setImageName(String imageName) {
		this.name = imageName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
