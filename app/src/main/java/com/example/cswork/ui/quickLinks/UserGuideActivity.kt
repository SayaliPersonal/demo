package com.example.cswork.ui.quickLinks

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cswork.R
import com.example.cswork.ui.meetingRoom.MeetingRoomListActivity
import com.example.cswork.utils.Constants


class UserGuideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_guide)

        val webView = findViewById<WebView>(R.id.webView)
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        progressBar.visibility = View.VISIBLE
        webView.settings.javaScriptEnabled = true
        webView.settings.loadsImagesAutomatically = true
        webView.settings.allowContentAccess = true
        webView.addJavascriptInterface(object : Any() {
            @JavascriptInterface // For API 17+
            fun meetingRoomClick(string: String) {
                Log.d("TAG", "======= User Guide Book Meeting Room Button Click ======")
                startActivity(Intent(this@UserGuideActivity, MeetingRoomListActivity::class.java))
            }
        }, Constants.USER_GUIDE_BUTTON_ID)

//        webView.addJavascriptInterface(object : Any() {
//            @JavascriptInterface // For API 17+
//            fun backButtonClick(string: String) {
//                Log.d("TAG", "======= User Guide Back Button Click ======== ")
//               finish()
//            }
//        }, Constants.USER_GUIDE_BUTTON_ID)

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                Log.i("TAG", "shouldOverrideUrlLoading...")
                if (progressBar.visibility == View.GONE) {
                    progressBar.visibility = View.VISIBLE
                }
                view.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView, url: String) {
                Log.i("TAG", "onPageFinished: $url")
                if (progressBar.visibility == View.VISIBLE) {
                    progressBar.visibility = View.GONE
                }
            }

            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                if (progressBar.visibility == View.VISIBLE) {
                    progressBar.visibility = View.GONE
                }
                Log.e("TAG", "onReceivedError : $description")
                Toast.makeText(this@UserGuideActivity, "$description", Toast.LENGTH_SHORT).show()
            }
        }
        webView.loadUrl(Constants.USER_GUIDE_HTML_URL)
    }
}