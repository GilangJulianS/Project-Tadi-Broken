package com.example.tadiproject;

public class DonateItem {

	String title;
	String description;
	int donateImage;
	

	public DonateItem() {
		title = "";
		description = "";
		donateImage = 0;
	}

	public DonateItem(String title, String description, int donateImage) {
		this.title = title;
		this.description = description;
		this.donateImage = donateImage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDonateImage() {
		return donateImage;
	}

	public void setDonateImage(int donateItem) {
		this.donateImage = donateItem;
	}

}
