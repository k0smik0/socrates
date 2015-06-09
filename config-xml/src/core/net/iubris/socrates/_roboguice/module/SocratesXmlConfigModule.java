/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * SocratesXmlConfigModule.java is part of socrates_config-xml.
 * 
 * socrates_config-xml is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * socrates_config-xml is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with socrates_config-xml ; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
package net.iubris.socrates._roboguice.module;
import net.iubris.socrates._roboguice.providers.config.xml.PlaceConfigXmlProvider;
import net.iubris.socrates.config.xml.PlaceConfigXml;


public class SocratesXmlConfigModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(PlaceConfig.class).to(PlaceConfigXml.class);
		bind(PlaceConfigXml.class).toProvider(PlaceConfigXmlProvider.class);		
	}

}
