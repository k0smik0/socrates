package net.iubris.socrates_sample.activity;

import java.util.List;

import javax.inject.Inject;

import net.iubris.socrates.engines.search.Searcher;
import net.iubris.socrates.engines.search.exception.PlacesSearcherException;
import net.iubris.socrates.model.http.response.data.search.Place;
import net.iubris.socrates.model.http.response.search.SearchResponse;
import net.iubris.socrates_sample.R;
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

@ContentView(R.layout.main)
public class SocratesSampleActivity extends RoboActivity {
	
	@InjectView(R.id.button_search) Button buttonSearch;
	@InjectView(R.id.text_field_result) TextView textView;
	@Inject private Searcher placeSearcher;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.main);
		
		textView.setMovementMethod(new ScrollingMovementMethod());
	}
	
	
	public void onClickSearch(View v) {
		final Location location = new Location("dummy");
		location.setLatitude(44.494692);
		location.setLongitude(11.342728);
		new RoboAsyncTask<String>(SocratesSampleActivity.this) {
			protected void onPreExecute() throws Exception {
				Toast.makeText(SocratesSampleActivity.this, "...searching...", Toast.LENGTH_SHORT).show();
			};
			@Override
			public String call() throws PlacesSearcherException {
				SearchResponse searchResponse = placeSearcher.search(location);
				return parseResults( searchResponse.getResults() );
			}
			@Override
			protected void onSuccess(String t) throws RuntimeException {
//				Toast.makeText(SocratesSampleActivity.this, t, Toast.LENGTH_LONG).show();
				textView.setText( textView.getText()
						+t+"\n\n");
			};
			@Override
			protected void onException(Exception e) throws RuntimeException {
				e.printStackTrace();
			};
		}.execute();
	}

	private String parseResults(List<Place> places) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Place p: places) {
			stringBuilder.append(p.getName()+" ");
			net.iubris.socrates.model.http.response.data.geocoding.Location loc = p.getGeometry().getLocation();
			stringBuilder.append(loc.getLatitude()+","+loc.getLongitude());
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
}