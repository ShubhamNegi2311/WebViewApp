package com.example.webviewapp

import android.os.Build
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val backButton : ImageButton = findViewById(R.id.backward_btn)
        val forwardButton : ImageButton = findViewById(R.id.forward_btn)
        val goButton : ImageButton = findViewById(R.id.go_btn)
        val urlEditText : EditText = findViewById(R.id.url_editText)
        val webView : WebView = findViewById(R.id.webView)


        webView.webViewClient = MyWebViewClient()

        goButton.setOnClickListener {
            webView.loadUrl("https://${urlEditText.text}")
        }

        backButton.setOnClickListener {
            if (webView.canGoBack()){
                webView.goBack()
            }
            else{
                Toast.makeText(this,"No page available", Toast.LENGTH_LONG).show()
            }
        }

        forwardButton.setOnClickListener {
            if (webView.canGoForward()){
                webView.goForward()
            }
            else{
                Toast.makeText(this,"No page available", Toast.LENGTH_LONG).show()
            }
        }
    }


    override fun onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack()
        }else{
            super.onBackPressed()
        }
    }


    class MyWebViewClient : WebViewClient() {

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            view?.loadUrl(request?.url.toString())
            return true
        }


        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url)
            return true
        }


        /**
         * this is for testing github push
         * another tag added
         * testing for pull request
         * this is master branch
         */

    }
}
