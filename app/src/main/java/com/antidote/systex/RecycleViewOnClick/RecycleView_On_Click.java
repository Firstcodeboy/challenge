package com.antidote.systex.RecycleViewOnClick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.antidote.systex.R;
import com.antidote.systex.ViewModel.MainActivityViewModel;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


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
            ProgressBar progressBar = findViewById(R.id.progressBar);
            progressBar.setVisibility(View.VISIBLE);
            Picasso.get().load(model.getDataList().get(pos).getImg())
                    .into(imgOnClick, new Callback() {
                        @Override
                        public void onSuccess() {
                            progressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(RecycleView_On_Click.this,"msgTime:  "+model.getDataList().get(pos).getMsgTime()
                                    +"\n                 加載成功",Toast.LENGTH_SHORT).show();
                        }
                        @Override
                        public void onError(Exception e) {
                            progressBar.setVisibility(View.INVISIBLE);
                            Picasso.get().load(model.getDataList().get(pos).getDefaultUrl()).into(imgOnClick);
                            Toast.makeText(RecycleView_On_Click.this,"msgTime:  "+model.getDataList().get(pos).getMsgTime()+
                                    "\n                 加載失敗",Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }
}