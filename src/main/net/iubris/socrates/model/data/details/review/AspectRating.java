package net.iubris.socrates.model.data.details.review;

import com.google.api.client.util.Key;

public class AspectRating {
	
	@Key("rating")
	private int rating;
	
	@Key("type")
	private Type type;

	public int getRating() {
		return rating;
	}

	public Type getType() {
		return type;
	}
}
