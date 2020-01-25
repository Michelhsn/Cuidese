package com.example.cuide_se;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;
import static android.view.View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
import static android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
import static android.view.WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //TextView textView = findViewById(R.id.textId);
        /*String textoDoenca1 = "<h2 style=\"margin-left:'50px'\">Doença 1</h2><p style=\"text-align:justify;\" >"+ getString(R.string.doenca_1) +"</p>";

        WebView view = (WebView) findViewById(R.id.textContent);
        String text;
        text = "<html><body><p align=\"justify\">";
        text+= textoDoenca1;
        text+= "</p></body></html>";
        view.loadData(text, "text/html", "utf-8");*/




       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(textoDoenca1, Html.FROM_HTML_MODE_COMPACT));
        } else {
            textView.setText(Html.fromHtml(textoDoenca1));
        }*/

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS |
                    SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR | SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }


        //bg.devlabs.fullscreenvideoview.FullscreenVideoView videoView = findViewById(R.id.fullscreenVideoView);
        final VideoView videoView = findViewById(R.id.video_view);
        String video = "";

        String doenca = getIntent().getStringExtra("doenca");

        String videoPath = "";
        if (doenca.equals("doenca1")){
            videoPath = "android.resource://" + getPackageName() + "/" + R.raw.d1;


            //TextView textView = findViewById(R.id.textId);
            String textoDoenca1 = "<h2 style=\"margin-left:'50px'\">Doença 1</h2><p style=\"text-align:justify;\" >"+ getString(R.string.doenca_1) +"</p>";

            WebView view = (WebView) findViewById(R.id.textContent);
            String text;
            text = "<html><body><p align=\"justify\">";
            text+= textoDoenca1;
            text+= "</p></body></html>";
            view.loadData(text, "text/html", "utf-8");


        }
        if (doenca.equals("doenca2")){
            videoPath = "android.resource://" + getPackageName() + "/" + R.raw.d1;


            //TextView textView = findViewById(R.id.textId);
            String textoDoenca1 = "<h2 style=\"margin-left:'50px'\">Doença 2</h2><p style=\"text-align:justify;\" >"+ getString(R.string.doenca_2) +"</p>";

            WebView view = (WebView) findViewById(R.id.textContent);
            String text;
            text = "<html><body><p align=\"justify\">";
            text+= textoDoenca1;
            text+= "</p></body></html>";
            view.loadData(text, "text/html", "utf-8");
        }
        if (doenca.equals("doenca3")){
            videoPath = "android.resource://" + getPackageName() + "/" + R.raw.d1;


            //TextView textView = findViewById(R.id.textId);
            String textoDoenca1 = "<h2 style=\"margin-left:'50px'\">Doença 3</h2><p style=\"text-align:justify;\" >"+ getString(R.string.doenca_3) +"</p>";

            WebView view = (WebView) findViewById(R.id.textContent);
            String text;
            text = "<html><body><p align=\"justify\">";
            text+= textoDoenca1;
            text+= "</p></body></html>";
            view.loadData(text, "text/html", "utf-8");
        }
        if (doenca.equals("doenca4")){
            videoPath = "android.resource://" + getPackageName() + "/" + R.raw.d1;


            //TextView textView = findViewById(R.id.textId);
            String textoDoenca1 = "<h2 style=\"margin-left:'50px'\">Doença 4</h2><p style=\"text-align:justify;\" >"+ getString(R.string.doenca_4) +"</p>";

            WebView view = (WebView) findViewById(R.id.textContent);
            String text;
            text = "<html><body><p align=\"justify\">";
            text+= textoDoenca1;
            text+= "</p></body></html>";
            view.loadData(text, "text/html", "utf-8");
        }
        if (doenca.equals("doenca5")){
            videoPath = "android.resource://" + getPackageName() + "/" + R.raw.d1;


            //TextView textView = findViewById(R.id.textId);
            String textoDoenca1 = "<h2 style=\"margin-left:'50px'\">Doença 5</h2><p style=\"text-align:justify;\" >"+ getString(R.string.doenca_5) +"</p>";

            WebView view = (WebView) findViewById(R.id.textContent);
            String text;
            text = "<html><body><p align=\"justify\">";
            text+= textoDoenca1;
            text+= "</p></body></html>";
            view.loadData(text, "text/html", "utf-8");
        }

        //videoPath = "android.resource://" + getPackageName() + "/" + R.raw.doenca2;
        /*Uri uri = Uri.parse(http://clips.vorwaerts-gmbh.de/VfE_html5.mp4);*/
        //videoView.videoUrl("http://clips.vorwaerts-gmbh.de/VfE_html5.mp4").enableAutoStart();

        //File file = new File(videoPath);
        //videoView.videoFile(file).enableAutoStart();

        //VideoView videoView1 = findViewById(R.id.video_view);
        //String videoPath1 = "android.resource://" + getPackageName() + "/" + R.raw.a;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);



        Runnable r = new Runnable() {
            @Override
            public void run(){
                videoView.start();//<-- put your code in here.
            }
        };

        Handler h = new Handler();
        h.postDelayed(r, 500);




        //MediaController mediaController = new MediaController(this);
        //videoView1.setMediaController(mediaController);
        //mediaController.setAnchorView(videoView1);




        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }


    public void inicio(View view){
        Intent homeIntent = new Intent(VideoActivity.this, HomeActivity.class);
        startActivity(homeIntent);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        int id = item.getItemId();


        if (id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}

