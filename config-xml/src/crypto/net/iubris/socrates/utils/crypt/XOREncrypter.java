/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * XOREncrypter.java is part of socrates_config-xml.
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
package net.iubris.socrates.utils.crypt;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class XOREncrypter {
	public static final String DEFAULT_ENCODING = Charset.defaultCharset().toString().equals("UTF-8") ? Charset.defaultCharset().toString() : "UTF-8";
    
   /*static Base64Encoder enc=new BASE64Encoder();
   static BASE64Decoder dec=new BASE64Decoder();*/
/*
   public static String base64encode(String text){
      try {
         String rez = enc.encode( text.getBytes( DEFAULT_ENCODING ) );
         return rez;         
      }
      catch ( UnsupportedEncodingException e ) {
         return null;
      }
   }//base64encode

   public static String base64decode(String text){

         try {
            return new String(dec.decodeBuffer( text ),DEFAULT_ENCODING);
         }
         catch ( IOException e ) {
           return null;
         }

      }//base64decode*/
/*
      public static void main(String[] args){
	   String txt = "some text to be encrypted" ;
	   String key = "key phrase used for XOR-ing";
	   System.out.println(txt+" XOR-ed to: "+(txt=xorString( txt, key )));
	   String encoded = Base64.encodeToString(txt.getBytes(), Base64.DEFAULT);       
	   System.out.println( " is encoded to: "+encoded+" and that is decoding to: "+ (txt=Base64.decode(encoded, Base64.DEFAULT).toString() ) );
	   System.out.print( "XOR-ing back to original: "+xorString( txt, key ) );

      }*/
      
      public static String xorBytes(byte[] message, byte[] key) {
    	  
    	  final int ml = message.length;
    	  final int kl = key.length;
    	  final char[] xoredMessage = new char[ml];
	      
	      for (int i=0; i<ml; i++){
	    	  xoredMessage[i]= (char) (message[i]^key[i%kl]);
	      }//for i	         
	      //mesg=null; keys=null;
	      //return int2byte(xoredMessage);
	      return new String(xoredMessage);
      }
      
      public static String xorBytes(byte[] message, String key) throws UnsupportedEncodingException {
    	  return xorBytes(message, key.getBytes());	
      }
      
      public static String xorString(String message, String key) throws UnsupportedEncodingException{
    	  return xorBytes(message.getBytes(), key);
      }

      /*
      public static String xorStringOld(String message, String key){
    	  try {
	          if (message==null || key==null ) return null;
	
	         char[] keys=key.toCharArray();
	         char[] mesg=message.toCharArray();
	
	         int ml=mesg.length;
	         int kl=keys.length;
	         char[] newmsg=new char[ml];
	
	         for (int i=0; i<ml; i++){
	            newmsg[i]=(char)(mesg[i]^keys[i%kl]);
	         }//for i	         
	         mesg=null; keys=null;
	         return new String(newmsg);
    	  }
    	  catch ( Exception e ) {
    		  return null;
    	  }  
      }//xorMessage
      
      
      public static byte[] int2byte(int[]src) {
    	int srcLength = src.length;
    	byte[]dst = new byte[srcLength << 2];
    	    
    	for (int i=0; i<srcLength; i++) {
    		int x = src[i];
    	    int j = i << 2;
    	    dst[j++] = (byte) ((x >>> 0) & 0xff);           
    	    dst[j++] = (byte) ((x >>> 8) & 0xff);
    	    dst[j++] = (byte) ((x >>> 16) & 0xff);
    	    dst[j++] = (byte) ((x >>> 24) & 0xff);
    	}
    	return dst;
      }*/

}//class
