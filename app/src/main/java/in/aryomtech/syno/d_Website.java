package in.aryomtech.syno;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.airbnb.lottie.Lottie;
import com.airbnb.lottie.LottieAnimationView;

public class d_Website extends AppCompatActivity {

    String weblink;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dwebsite);

        Window window = d_Website.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(d_Website.this, R.color.white));

        weblink=getIntent().getStringExtra("link_send");
        //Get a reference to your WebView//
        WebView webView = findViewById(R.id.webview);
        LottieAnimationView load=findViewById(R.id.load);

        //Specify the URL you want to display//
        webView.loadUrl(weblink);
        webView.setWebViewClient(new MyBrowser());

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageCommitVisible (WebView view,
                                             String url){
                load.setVisibility(View.GONE);
            }
        });
    }
    private static class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}