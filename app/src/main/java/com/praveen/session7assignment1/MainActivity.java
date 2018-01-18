package com.praveen.session7assignment1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText searchInput;
    Button searchButton;
    String inputString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // References view objects with Layout Objects.
        searchButton = findViewById(R.id.searchButton);
        searchInput = findViewById(R.id.searchInput);

        // Sets Search Button Click Event Listener
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Sets EditText input value into a String variable
                 inputString = searchInput.getText().toString();

                // Validates the search input. If empty string, shows the Toast, else navigates to search.
                 if(inputString.equals("") || inputString.isEmpty())
                 {
                     Toast.makeText(getApplicationContext(), "Empty String, Please type some text and search",Toast.LENGTH_LONG).show();
                     return;
                 }

            // Creates URI with search input
            Uri uriString = Uri.parse("http://www.google.com/#q=" + inputString);

            // Creates an intent and triggers Action_View with URI.
            Intent  intent = new Intent(Intent.ACTION_VIEW, uriString);

            // Starts Activity With required intent.
             startActivity(intent);
            }
        });
    }
}
