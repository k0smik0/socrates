package net.iubris.socrates.model.http.response.common;

import net.iubris.socrates.model.http.response.common.Scope;

import com.google.api.client.util.Key;

public class ScopedID {

	@Key("place_id")
	private String placeId;
	
	@Key("scope")
	private Scope scope;
}
