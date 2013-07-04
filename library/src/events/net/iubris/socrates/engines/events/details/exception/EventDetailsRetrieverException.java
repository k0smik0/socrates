/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * EventDetailsRetrieverException.java is part of 'Socrates'.
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
package net.iubris.socrates.engines.events.details.exception;

import net.iubris.socrates.engines.base.exception.PlacesException;

public class EventDetailsRetrieverException extends PlacesException {

	public EventDetailsRetrieverException(String detailMessage,Throwable throwable) {
		super(detailMessage, throwable);
	}
	public EventDetailsRetrieverException(String exception) {
		super(exception);
	}
	public EventDetailsRetrieverException(Throwable cause) {
		super(cause);
	}
	
	private static final long serialVersionUID = 7747563021658995700L;

}
