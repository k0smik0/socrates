/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * Language.java is part of 'Socrates'.
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
package net.iubris.socrates.model.http.request.url.language;

public enum Language {
	
	arabic("ar"),                                                                                                                                                                            
	basque("eu"),                                                                                                                                                                            
	bulgarian("bg"),                                                                                                                                                                         
	bengali("bn"),                                                                                                                                                                           
	catalan("ca"),                                                                                                                                                                           
	czech("cs"),                                                                                                                                                                             
	danish("da"),                                                                                                                                                                            
	german("de"),                                                                                                                                                                            
	greek("el"),                                                                                                                                                                             
	english("en"),                                                                                                                                                                           
	english_australian("en-au"),                                                                                                                                                             
	english_great_britain("en-gb"),                                                                                                                                                          
	spanish("es"),                                                                                                                                                                                                                                                                                                                                                  
	farsi("fa"),                                                                                                                                                                             
	finnish("fi"),                                                                                                                                                                           
	filipino("fil"),                                                                                                                                                                         
	french("fr"),                                                                                                                                                                            
	galician("gl"),                                                                                                                                                                          
	gujarati("gu"),                                                                                                                                                                          
	hindi("hi"),                                                                                                                                                                             
	croatian("hr"),                                                                                                                                                                          
	hungarian("hu"),                                                                                                                                                                         
	indonesian("id"),                                                                                                                                                                        
	italian("it"),                                                                                                                                                                           
	hebrew("iw"),                                                                                                                                                                            
	japanese("ja"),                                                                                                                                                                          
	kannada("kn"),                                                                                                                                                                           
	korean("ko"),                                                                                                                                                                            
	lithuanian("lt"),                                                                                                                                                                        
	latvian("lv"),                                                                                                                                                                           
	malayalam("ml"),                                                                                                                                                                         
	marathi("mr"),                                                                                                                                                                           
	dutch("nl"),                                                                                                                                                                             
	norwegian_nynorsk("nn"),                                                                                                                                                                 
	norwegian("no"),                                                                                                                                                                         
	oriya("or"),                                                                                                                                                                             
	polish("pl"),                                                                                                                                                                            
	portuguese("pt"),                                                                                                                                                                        
	portuguese_brazil("pt-br"),                                                                                                                                                              
	portuguese_portugal("pt-pt"),                                                                                                                                                            
	romansch("rm"),                                                                                                                                                                          
	romanian("ro"),                                                                                                                                                                          
	russian("ru"),                                                                                                                                                                           
	slovak("sk"),                                                                                                                                                                            
	slovenian("sl"),                                                                                                                                                                         
	serbian("sr"),                                                                                                                                                                           
	swedish("sv"),                                                                                                                                                                           
	tagalog("tl"),                                                                                                                                                                           
	tamil("ta"),                                                                                                                                                                             
	telugu("te"),                                                                                                                                                                            
	thai("th"),                                                                                                                                                                              
	turkish("tr"),                                                                                                                                                                           
	ukrainian("uk"),                                                                                                                                                                         
	vietnamese("vi"),                                                                                                                                                                        
	chinese_simplified("zh-cn"),                                                                                                                                                             
	chinese_traditional("zh-tw");
	
	private final String languageCode;

	private Language(String languageCode) {
		this.languageCode = languageCode;		
	}
	
	public String getLanguageCode() {	
		return languageCode;
	}
}
