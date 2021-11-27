package com.satyajit.booklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BooksAdapter itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button searchButton = findViewById(R.id.search_Button);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View loadingIndicator = findViewById(R.id.loading_indicator);
                loadingIndicator.setVisibility(View.VISIBLE);
                EditText searchBook = (EditText) findViewById(R.id.search_option);
                String message = searchBook.getText().toString();
                final String SAMPLE_JSON_RESPONSE = "https://www.googleapis.com/books/v1/volumes?q="+message+"&maxResults=20";
                itemsAdapter = new BooksAdapter(MainActivity.this, new ArrayList<>());
                ListView listItems = (ListView) findViewById(R.id.list_of_books);
                listItems.setAdapter(itemsAdapter);

                listItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Books currentBook = itemsAdapter.getItem(position);
                        Uri booksUri = Uri.parse(currentBook.getMurl());

                        Intent intent = new Intent(Intent.ACTION_VIEW,booksUri);
                        startActivity(intent);
                    }
                });

                BooksAsyncTask task = new BooksAsyncTask();
                task.execute(SAMPLE_JSON_RESPONSE);
            }
        });


    }

    private class BooksAsyncTask extends AsyncTask<String,Void, List<Books>> {

        @Override
        protected List<Books> doInBackground(String... urls) {
            // Don't perform the request if there are no URLs, or the first URL is null.
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            List<Books> result = QueryUtils.fetchEarthquakeData(urls[0]);
            return result;
        }

        @Override
        protected void onPostExecute(List<Books> data) {
            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);
            // Clear the adapter of previous earthquake data
            itemsAdapter.clear();

            // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
            // data set. This will trigger the ListView to update.
            if (data != null && !data.isEmpty()) {
                itemsAdapter.addAll(data);
            }
        }
    }
}