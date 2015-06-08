/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * OpeningHours.java is part of 'Socrates'.
 * 
 * 'Socrates' is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * 'Socrates' is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with 'Socrates'; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
package net.iubris.socrates.model.http.response.data.details;

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
		periods[] is an array of opening periods covering seven days, starting from Sunday, in chronological order. 
		Each period may contain: open contains a pair of day and time objects describing when the Place opens:
		day a number from 0 to 6, corresponding to the days of the week, starting on Sunday. For example, 2 means Tuesday.
		time may contain a time of day in 24-hour hhmm format (values are in the range 0000-2359). 
		The time will be reported in the Places timezone.
		close
		*/

}
