/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * PlacesOverQuotaException.java is part of 'Socrates'
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
 * along with 'Socrates' ; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
package net.iubris.socrates.model.http.base.exceptions;

/** 
 * Map "OVER_QUERY_LIMIT" from GooglePlacesAPI request
 * 
 * @author "Massimiliano Leone - massimiliano.leone@iubris.net"
 * 
 * @see https://developers.google.com/maps/documentation/places/index#PlaceSearchStatusCodes
 */
public class OverQuotaException extends StatusException {

	public OverQuotaException(String message) {
		super(message);
	}
	public OverQuotaException(Throwable cause) {
		super(cause);
	}
	private static final long serialVersionUID = -8450217144613028959L;
}
