/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * EventDetailsMandatoryParameters.java is part of 'Socrates'.
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
