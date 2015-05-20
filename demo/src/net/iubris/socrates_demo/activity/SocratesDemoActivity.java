/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * SocratesSampleActivity.java is part of Socrates.
 * 
 * 'Socrates' is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * 'Socrates' is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with 'Socrates' ; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
package net.iubris.socrates_demo.activity;

import java.util.List;

import net.iubris.socrates.engines.search.Searcher;
import net.iubris.socrates.engines.search.exception.PlacesSearcherException;
import net.iubris.socrates.model.http.response.common.Status;
import net.iubris.socrates.model.http.response.data.search.Place;
import net.iubris.socrates.model.http.response.search.SearchResponse;
import net.iubris.socrates_demo.R;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import roboguice.util.RoboAsyncTask;
import android.location.Location;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.inject.Inject;


@ContentView(R.layout.main)
public class SocratesDemoActivity extends RoboActivity {
	
	@InjectView(R.id.button_search) Button buttonSearch;
	@InjectView(R.id.text_field_result) TextView textView;
	@Inject private Searcher placeSearcher;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
//Debug.startMethodTracing(Environment.getExternalStorageDirectory().getPath()+"/traces/socrates__startup");
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.main);
		
		textView.setMovementMethod(new ScrollingMovementMethod());
	}
	
	@Override
	protected void onResume() {
		super.onResume();
//		Debug.stopMethodTracing();
	}
	
	
	public void onClickSearch(View v) {
		final Location location = new Location("dummy");
		location.setLatitude(44.494692);
		location.setLongitude(11.342728);
		new RoboAsyncTask<String>(SocratesDemoActivity.this) {
			private long start;
			protected void onPreExecute() throws Exception {
//Debug.startMethodTracing(Environment.getExternalStorageDirectory().getPath()+"/traces/socrates__search_task");
				start = System.currentTimeMillis();
				Toast.makeText(SocratesDemoActivity.this, "...searching...", Toast.LENGTH_SHORT).show();
			};
			@Override
			public String call() throws PlacesSearcherException {
				SearchResponse searchResponse = placeSearcher.search(location);
				Status status = searchResponse.getStatus();
				if (!status.equals(Status.OK))
					throw new PlacesSearcherException(status.getReason());
				return parseResults( searchResponse.getResults() );
			}
			@Override
			protected void onSuccess(String t) throws RuntimeException {
//				Toast.makeText(SocratesSampleActivity.this, t, Toast.LENGTH_LONG).show();
				long end = System.currentTimeMillis();
				long delta = (end-start);
				textView.setText( textView.getText()
						+t+"\n\n"
						+"\nin: "+delta+" ms\n\n\n");
//Debug.stopMethodTracing();
			};
			@Override
			protected void onException(Exception e) throws RuntimeException {
				Toast.makeText(SocratesDemoActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
				e.printStackTrace();
			};
		}.execute();
	}

	private String parseResults(List<Place> places) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Place p: places) {
			stringBuilder.append(p.getName()+" at: ");
			net.iubris.socrates.model.http.response.data.geocoding.Location loc = p.getGeometry().getLocation();
			stringBuilder.append(loc.getLatitude()+","+loc.getLongitude());
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
}
