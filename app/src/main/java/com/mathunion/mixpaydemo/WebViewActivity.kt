package com.mathunion.mixpaydemo

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import org.json.JSONObject

class WebViewActivity: AppCompatActivity() {

    lateinit var webView: WebView


    @SuppressLint("JavascriptInterface")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        webView = findViewById(R.id.webView)

        initWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun initWebView() {
        val mSettings = webView.settings
        mSettings.javaScriptEnabled = true
        mSettings.domStorageEnabled = true

        webView.addJavascriptInterface(MixpayPlus(), "mixpayPlus")

        webView.loadUrl(Constant.URL)

        webView.webViewClient = object : WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                webAddJs()
            }
        }
    }

    fun webAddJs() {
        webView.evaluateJavascript("javascript:window.mixpayPlus.appId='MixPay+', window.mixpayPlus.appName='MixPay+ Pay', window.mixpayPlus.appIcon='https://d1vo6gxh6hbvvc.cloudfront.net/avatars/1666007772MX0PH4zNXqRb6ZR8.jpeg', window.mixpayPlus.themeColor='#ff0000', window.mixpayPlus.assetList=['43d61dcd-e413-450d-80b8-101d5e903357', '4d8c508b-91c5-375b-92b0-ee702ed2dac5', 'c6d0c728-2624-429b-8e0d-d9d19b6592fa' ], window.mixpayPlus.ready=true") {

        }
    }

    inner class MixpayPlus {

        @JavascriptInterface
        fun pay(jsonString: String?) {
            if(jsonString!!.isNotEmpty()) {
                runOnUiThread {
                    val payInfo = Gson().fromJson(jsonString, PayInfo::class.java)
                    AlertDialog.Builder(this@WebViewActivity)
                        .setTitle("MixPay+ Demo")
                        .setMessage(payInfo.toString())
                        .setPositiveButton("OK"
                        ) { dialog, which ->

                        }
                        .show()
                }
            }

        }

    }

}