package net.iubris.socrates.model.http.response.data.details;

import com.google.api.client.util.Key;

public class Period {
	
	@Key("close")
	private WorkingTime close;	
	
	@Key("open")
	private WorkingTime open;
	
	public WorkingTime getClose() {
		return close;
	}
	public WorkingTime getOpen() {
		return open;
	}

}
