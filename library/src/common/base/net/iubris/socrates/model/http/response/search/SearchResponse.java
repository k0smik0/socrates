/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * SearchResponse.java is part of 'Socrates'.
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
package net.iubris.socrates.model.http.response.search;

import java.util.List;

import net.iubris.socrates.model.http.response.base.AbstractResponse;
import net.iubris.socrates.model.http.response.data.search.Place;

import com.google.api.client.util.Key;

public class SearchResponse extends AbstractResponse {
	
	@Key ("results")
	private List<Place> results;
	
	@Key("next_page_token")
	private String nextPageToken;	
	
	public List<Place> getResults() {		
		return results;
	}
	
	public String getNextPageToken() {
		return nextPageToken;
	}
}
