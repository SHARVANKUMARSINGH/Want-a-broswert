package com.example.tinyweb;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.OnBackPressedCallback;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Find the WebView from our layout file
        myWebView = findViewById(R.id.webview);

        // 2. Enable JavaScript (Required for YouTube, Facebook, Google, etc.)
        myWebView.getSettings().setJavaScriptEnabled(true);

        // 3. Keep links inside this app
        // If we don't do this, clicking a link will open Google Chrome!
        myWebView.setWebViewClient(new WebViewClient());

        // 4. Load the homepage
        myWebView.loadUrl("https://www.google.com");

        // 5. Handle the "Back" button
        // If the browser can go back, go back. If not, close the app.
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (myWebView.canGoBack()) {
                    myWebView.goBack();
                } else {
                    finish(); // Closes the app
                }
            }
        });
    }
}
