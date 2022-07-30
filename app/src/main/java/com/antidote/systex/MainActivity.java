package com.antidote.systex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.antidote.systex.Adapter.RecyclerviewAdapter;
import com.antidote.systex.RecycleViewOnClick.RecycleViewInterface;
import com.antidote.systex.RecycleViewOnClick.RecycleView_On_Click;
import com.antidote.systex.ViewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity implements RecycleViewInterface{

    MainActivityViewModel mainActivityViewModel;
    RecyclerView recyclerView;

    RecyclerviewAdapter adapter;
    RecyclerView.LayoutManager layoutManager;


    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycview);

        mainActivityViewModel = new MainActivityViewModel();

        mainActivityViewModel.getList().observe(this,model -> {
            adapter = new RecyclerviewAdapter(MainActivity.this, model, this);
            adapter.notifyDataSetChanged();
            recyclerView.setAdapter(adapter);
        });
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }
    @Override
    public void OnClick(int position) {
        Intent i = new Intent(MainActivity.this, RecycleView_On_Click.class);
        Log.e("123", String.valueOf(position));
        i.putExtra("position",position);
        startActivity(i);
    }
}