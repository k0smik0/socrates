/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * PlacesZeroResultException.java is part of socrates.
 * 
 * socrates is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * socrates is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with socrates ; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
package net.iubris.socrates.model.http.exceptions;

/** 
 * Map "ZERO_RESULTS" from GooglePlacesAPI request
 * 
 * @author "Massimiliano Leone - massimiliano.leone@iubris.net"
 * 
 * @see https://developers.google.com/maps/documentation/places/index#PlaceSearchStatusCodes
 */
public class PlacesZeroResultException extends PlacesStatusException {

	private static final long serialVersionUID = 326224504515929176L;

	public PlacesZeroResultException(String reason) {
		super(reason);
	}
	public PlacesZeroResultException(Throwable cause) {
		super(cause);
	}
}
