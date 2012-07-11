package net.iubris.socrates.model.data.details;

import java.util.List;

import com.google.api.client.util.Key;

public class OpeningHours {
	
	@Key("open_now")
	private boolean openNow;
	
	@Key("periods")
	private List<Period> periods;

	public boolean isOpenNow() {
		return openNow;
	}

	public List<Period> getPeriods() {
		return periods;
	}
	
	
	
	/*
	may contain the following information:
		open_now is a boolean value indicating if the Place is open at the current time.
		periods[] is an array of opening periods covering seven days, starting from Sunday, in chronological order. Each period may contain:
		open contains a pair of day and time objects describing when the Place opens:
		day a number from 0–6, corresponding to the days of the week, starting on Sunday. For example, 2 means Tuesday.
		time may contain a time of day in 24-hour hhmm format (values are in the range 0000–2359). The time will be reported in the Place’s timezone.
		close
		*/

}
