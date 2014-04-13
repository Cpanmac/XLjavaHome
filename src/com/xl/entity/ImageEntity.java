package com.xl.entity;

public class ImageEntity {
	/** ±ÍÃ‚ */
	private String title;

	/** µÿ÷∑ */
	private String url;

	public ImageEntity(String title, String url) {
		super();
		this.title = title;
		this.url = url;
	}

	public ImageEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
