/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * PlaceDetailsRetrieverException.java is part of 'Socrates'.
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
package net.iubris.socrates.detailer.exception;

import net.iubris.socrates.exceptions.PlacesException;

public class PlaceDetailsRetrieverException extends PlacesException {

	public PlaceDetailsRetrieverException(String exception) {
		super(exception);
	}
	public PlaceDetailsRetrieverException(Throwable cause) {
		super(cause);
	}
	
	private static final long serialVersionUID = 2284346095645962921L;

}
