package com.example.tugas4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHeroes;
    private ArrayList<Heroes> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeroes = findViewById(R.id.rv_main);
        rvHeroes.setHasFixedSize(true);

        list.addAll(HeroesData.getHeroList());
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        HeroesAdapter heroesAdapter = new HeroesAdapter(HeroesData.getHeroList(), this);
        rvHeroes.setAdapter(heroesAdapter);
    }
}
