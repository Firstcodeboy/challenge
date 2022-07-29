package com.antidote.systex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.antidote.systex.Adapter.ModelListAdapter;
import com.antidote.systex.Model.Model;
import com.antidote.systex.RecycleViewOnClick.RecycleViewInterface;
import com.antidote.systex.ViewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity implements RecycleViewInterface{

    Model model;

    MainActivityViewModel mainActivityViewModel;
    RecyclerView recyclerView;

    ModelListAdapter adapter;
    RecyclerView.LayoutManager layoutManager;


    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycview);

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        mainActivityViewModel.getList().observe(this,model -> {
            adapter = new ModelListAdapter(MainActivity.this, model, this);
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