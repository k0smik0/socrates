/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * AbstractResponse.java is part of 'Socrates'.
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
package net.iubris.socrates.model.http.response.base;

import java.util.List;

import net.iubris.socrates.model.http.response.common.Status;

import com.google.api.client.util.Key;

abstract public class AbstractResponse {

	@Key ("status")
	protected Status status;
	
	@Key("html_attributions")
	protected List<String> htmlAttributions;
	 
	public Status getStatus() {
		return status;
	}
	
	public List<String> getHtmlAttributions() {
		return htmlAttributions;
	}
}
