package net.iubris.socrates.model.http.response.data.details;

import com.google.api.client.util.Key;

public class WorkingTime {
	
	@Key("day")
	private int day;
	
	@Key("time")
	private String timeString;

	private String time;
	
	public int getDay() {
		return day;
	}
	
	public String getTime() {
		if (time==null) {
//			System.out.println(timeString);
//			System.out.println(timeString.substring(0, 2));
//			System.out.println(timeString.substring(2));
			time = timeString.substring(0, 2) + ":"+ timeString.substring(2);
			//System.out.println(time);
		}
		return time;
	}
	

}
