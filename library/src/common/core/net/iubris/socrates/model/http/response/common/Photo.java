package net.iubris.socrates.model.http.response.common;

import com.google.api.client.util.Key;

public class Photo {

	@Key("height")
	private int height;
	
	@Key("width")
	private int width;
	
	@Key("photo_reference")
	private String photoReference;
	
//	@Key("html_attributions")
//	private List<String> comments;
	
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public String getPhotoReference() {
		return photoReference;
	}
//	public List<String> getComments() {
//		return comments;
//	}
}
