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
