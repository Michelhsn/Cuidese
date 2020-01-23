package com.example.cuide_se;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
import static android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
import static android.view.WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS;


public class HomeActivity extends AppCompatActivity {



    ListView listView;
    String mTitle[] = {"Aids", "HPV", "Herpes", "Sífilis", "Gonorréia"};
    String mDescription[] = {"A aids é a doença causada pela infecção do Vírus da Imunodeficiência Humana.",
            "HPV é um vírus que infecta a pele e as mucosas.",
            "Herpes é uma doença causada por dois tipos de vírus.",
            "A aids é a doença causada pela infecção do Vírus da Imunodeficiência Humana.",
            "A aids é a doença causada pela infecção do Vírus da Imunodeficiência Humana."};
    int images[] = {R.drawable.aids, R.drawable.hpv, R.drawable.herpes, R.drawable.figuralogo, R.drawable.figuralogo};
    // so our images and other things are set in array

    // now paste some images in drawable



    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS |
                    SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR | SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }




        listView = findViewById(R.id.listView);
        // now create an adapter class

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Intent homeIntent = new Intent(HomeActivity.this, MainActivity.class);
                    startActivity(homeIntent);
                }
                if (position ==  1) {
                    Toast.makeText(HomeActivity.this, "A aids é a doença causada pela infecção do Vírus da Imunodeficiência Humana (HIV é a sigla em inglês). Esse vírus ataca o sistema imunológico, que é o responsável por defender o organismo de doenças.", Toast.LENGTH_SHORT).show();
                }
                if (position ==  2) {
                    Toast.makeText(HomeActivity.this, "A aids é a doença causada pela infecção do Vírus da Imunodeficiência Humana (HIV é a sigla em inglês). Esse vírus ataca o sistema imunológico, que é o responsável por defender o organismo de doenças.", Toast.LENGTH_SHORT).show();
                }
                if (position ==  3) {
                    Toast.makeText(HomeActivity.this, "A aids é a doença causada pela infecção do Vírus da Imunodeficiência Humana (HIV é a sigla em inglês). Esse vírus ataca o sistema imunológico, que é o responsável por defender o organismo de doenças.", Toast.LENGTH_SHORT).show();
                }
                if (position ==  4) {
                    Toast.makeText(HomeActivity.this, "A aids é a doença causada pela infecção do Vírus da Imunodeficiência Humana (HIV é a sigla em inglês). Esse vírus ataca o sistema imunológico, que é o responsável por defender o organismo de doenças.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // so item click is done now check list view

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);




            return row;
        }
    }




}


