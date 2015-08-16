package net.iubris.socrates.model.http.response.common;

import com.google.api.client.util.Key;

public class Photo {

	@Key("height")
	private int height;
	
	@Key("width")
	private int width;
	
	@Key("photo_reference")
	private String photoReference;
	
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public String getPhotoReference() {
		return photoReference;
	}
}
