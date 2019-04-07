package cdictv.moni.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cdictv.moni.R;

public class WebActivity extends AppCompatActivity {
    ProgressDialog mProgressDialog;
    private ImageView left_menu;
    private TextView mtitle;
    private RelativeLayout tool_bar;
    private WebView web_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initView();
    }

    private void initView() {
        left_menu = (ImageView) findViewById(R.id.left_menu);
        mtitle = (TextView) findViewById(R.id.title);
        tool_bar = (RelativeLayout) findViewById(R.id.tool_bar);
        web_view=findViewById(R.id.web_id);
        web_view.getSettings().setJavaScriptEnabled(true);
        web_view.setWebViewClient(new WebViewClient());
        String uri = getIntent().getStringExtra("uri");
        String title = getIntent().getStringExtra("title");
        mtitle.setTextSize(16);
        mtitle.setText(title);
        mProgressDialog = ProgressDialog.show(
                WebActivity.this,"提示","正在请求");
        web_view.loadUrl(uri);
        mProgressDialog.dismiss();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            default:
        }
        return true;
    }
}
