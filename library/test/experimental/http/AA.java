/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * AA.java is part of 'Socrates'
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
 * along with 'Socrates' ; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
package ulysses.test.http;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class AA {

}


final class ApacheHttpTransport implements LowLevelHttpTransportInterface {

	  private final HttpClient httpClient;

	  ApacheHttpTransport() {
	    // Turn off stale checking. Our connections break all the time anyway,
	    // and it's not worth it to pay the penalty of checking every time.
	    HttpParams params = new BasicHttpParams();
	    HttpConnectionParams.setStaleCheckingEnabled(params, false);
	    // Default connection and socket timeout of 20 seconds. Tweak to taste.
	    HttpConnectionParams.setConnectionTimeout(params, 20 * 1000);
	    HttpConnectionParams.setSoTimeout(params, 20 * 1000);
	    HttpConnectionParams.setSocketBufferSize(params, 8192);
	    this.httpClient = new DefaultHttpClient(params);
	  }

	  public boolean supportsPatch() {
	    return true;
	  }

	  public ApacheHttpRequest buildDeleteRequest(String uri) {
	    return new ApacheHttpRequest(this.httpClient, new HttpDelete(uri));
	  }

	  public ApacheHttpRequest buildGetRequest(String uri) {
	    return new ApacheHttpRequest(this.httpClient, new HttpGet(uri));
	  }

	  public ApacheHttpRequest buildPatchRequest(String uri) {
	    return new ApacheHttpRequest(this.httpClient, new HttpPatch(uri));
	  }

	  public ApacheHttpRequest buildPostRequest(String uri) {
	    return new ApacheHttpRequest(this.httpClient, new HttpPost(uri));
	  }

	  public ApacheHttpRequest buildPutRequest(String uri) {
	    return new ApacheHttpRequest(this.httpClient, new HttpPut(uri));
	  }
	}
