package com.example.baitap10_firebase_webview.activity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitap10_firebase_webview.R;
import com.example.baitap10_firebase_webview.databinding.ActivityWebViewBinding;

public class WebViewActivity extends AppCompatActivity {
    private ActivityWebViewBinding binding;

    @SuppressLint({"SetJavaScriptEnabled", "WebViewApiAvailable"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityWebViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Thiết lập padding hệ thống nếu có
        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Ẩn ActionBar (nếu có)
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Cấu hình WebView
        WebSettings webSettings = binding.webview.getSettings();
        webSettings.setJavaScriptEnabled(true); // Bật JavaScript

        binding.webview.setWebViewClient(new WebViewClient());

        // Load trang web
        binding.webview.loadUrl("https://www.youtube.com/");
    }
}
