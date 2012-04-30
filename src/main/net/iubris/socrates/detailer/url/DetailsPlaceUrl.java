/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * DetailsPlaceUrl.java is part of socrates.
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
package net.iubris.socrates.detailer.url;

import net.iubris.socrates.detailer.url.annotation.PlaceUrlFinalPartDetails;
import net.iubris.socrates.url.AbstractPlaceUrl;
import net.iubris.socrates.url.PlaceUrlFinalPart;

import com.google.api.client.http.GenericUrl;
import com.google.inject.Inject;

public class DetailsPlaceUrl extends AbstractPlaceUrl {

	@Inject
	public DetailsPlaceUrl(GenericUrl genericUrl, 
			@PlaceUrlFinalPartDetails PlaceUrlFinalPart placeUrlFinalPart) {
		super(genericUrl, placeUrlFinalPart);
	}
}
