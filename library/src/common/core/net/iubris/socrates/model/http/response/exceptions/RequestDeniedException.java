/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * RequestDeniedException.java is part of 'Socrates'.
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
package net.iubris.socrates.model.http.response.exceptions;

/** 
 * Map "REQUEST_DENIED" from GooglePlacesAPI request
 * 
 * @author "Massimiliano Leone - massimiliano.leone@iubris.net"
 * 
 * @see https://developers.google.com/maps/documentation/places/index#PlaceSearchStatusCodes
 */
public class RequestDeniedException extends StatusException {

	private static final long serialVersionUID = -2394114252710231525L;

	public RequestDeniedException() {
		super();
	}
	public RequestDeniedException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}
	public RequestDeniedException(String detailMessage) {
		super(detailMessage);
	}
	public RequestDeniedException(Throwable throwable) {
		super(throwable);
	}
}
