/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * WorkingTime.java is part of 'Socrates'.
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

import java.io.Serializable;

import com.google.api.client.util.Key;

public class WorkingTime implements Serializable {
	
	private static final long serialVersionUID = 3961296520630613724L;

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
