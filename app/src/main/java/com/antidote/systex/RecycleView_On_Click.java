package com.antidote.systex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.antidote.systex.ViewModel.MainActivityViewModel;

import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.json.JSONException;


public class RecycleView_On_Click extends AppCompatActivity{

    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_on_click);

        ImageView imgOnClick = findViewById(R.id.imgOnClick);
        TextView txtTitle = findViewById(R.id.txtTitleClicked);
        TextView txtContent = findViewById(R.id.txtContent);

        int pos = getIntent().getIntExtra("position",1);

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        mainActivityViewModel.getList().observe(this, model -> {

            txtContent.setText(model.getDataList().get(pos).getContent());
            txtTitle.setText(model.getDataList().get(pos).getTitle());
            Picasso.get().load(model.getDataList().get(pos).getImg())
                    .into(imgOnClick, new Callback() {
                        @Override
                        public void onSuccess() {
                        }
                        @Override
                        public void onError(Exception e) {
                            Picasso.get().load(model.getDataList().get(pos).getDefaultUrl()).into(imgOnClick);
                            Toast.makeText(RecycleView_On_Click.this,"加載失敗",Toast.LENGTH_LONG).show();
                        }
                    });


        });
    }
}