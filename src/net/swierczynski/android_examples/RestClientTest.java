package net.swierczynski.android_examples;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class RestClientTest extends Activity implements View.OnClickListener {
    protected final static String TAG = RestClientTest.class.getSimpleName();
    public final static String ENDPOINT = "http://search.twitter.com/search.json?q={query}";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button sendRequest = (Button) findViewById(R.id.send_request);
        sendRequest.setOnClickListener(this);
    }

    public void onClick(View view) {
        new TwitterSearchTask().execute();
    }

    private class TwitterSearchTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            try {
                RestTemplate restTemplate = new RestTemplate();
                String result = restTemplate.getForObject(ENDPOINT, String.class, "android");
                return result;
            } catch (RestClientException e) {
                Log.e(TAG, e.getMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            EditText responseEditText = (EditText) findViewById(R.id.response);
            responseEditText.setText(result);
        }
    }
}