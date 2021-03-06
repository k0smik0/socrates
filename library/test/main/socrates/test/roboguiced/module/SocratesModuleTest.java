/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * SocratesModuleTest.java is part of 'Socrates'.
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
package socrates.test.roboguiced.module;


import net.iubris.socrates._di._roboguice.modules.AbstractSocratesBaseModule;
import net.iubris.socrates.config.ConfigMandatory;
import net.iubris.socrates.config.SearchOptions;
import socrates.test.config.ConfigMandatoryImpl;
import socrates.test.config.SearchOptionsImpl;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

public class SocratesModuleTest extends AbstractSocratesBaseModule {

	@Override
	public HttpTransport providesHttpTransport() {
		return  new NetHttpTransport(); // robolectric don't like AndroidHttpTransport ;/	
	}

	@Override
	protected void bindConfigMandatory() {
		bind(ConfigMandatory.class).to(ConfigMandatoryImpl.class);
		bind(ConfigMandatoryImpl.class).asEagerSingleton();
	}

	@Override
	protected void bindSearchOptions() {
		bind(SearchOptions.class)/*.annotatedWith(Config.class)*/.to(SearchOptionsImpl.class);
		bind(SearchOptionsImpl.class).asEagerSingleton();		
	}

}
