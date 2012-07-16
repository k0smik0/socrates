package net.iubris.socrates.model.http.request.url.parameters.mandatory.events.details;

import net.iubris.socrates.model.http.request.url.ParameterKey;

public enum EventDetailsMandatoryParameters  implements ParameterKey {
	eventid("event_id");
	private final String name;

	private EventDetailsMandatoryParameters(String name){
		this.name = name;		
	}
	
	public String getName(){
		return name;
	}
}
