package com.example.tugas4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder> {
    private ArrayList<Heroes> listHero = new ArrayList<>();
    private Context context;
    private ViewHolder holder;
    private int position;

    public HeroesAdapter(ArrayList<Heroes> listHero, Context context) {
        this.listHero = listHero;
        this.context = context;
    }

    public ArrayList<Heroes> getListHero() {
        return listHero;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_heroes, parent, false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroesAdapter.ViewHolder holder, final int position) {
        this.holder = holder;
        this.position = position;
        holder.ivHeroes.setImageResource(getListHero().get(position).getHeroImage());
        holder.tvHeroes.setText(getListHero().get(position).getHeroName());

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String heroName = getListHero().get(position).getHeroName();
                intent.putExtra(Intent.EXTRA_TEXT, heroName);
                context.startActivity(Intent.createChooser(intent, "Bagikan"));
            }
        });
        holder.btnDetaile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HeroDetail.class);
                intent.putExtra("image", getListHero().get(position).getHeroImage());
                intent.putExtra("title", getListHero().get(position).getHeroName());
                intent.putExtra("desc", getListHero().get(position).getHeroDetail());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return getListHero().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivHeroes;
        TextView tvHeroes;
        Button btnShare, btnDetaile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHeroes = itemView.findViewById(R.id.iv_hero);
            tvHeroes = itemView.findViewById(R.id.tv_hero);
            btnShare = itemView.findViewById(R.id.btn_share);
            btnDetaile = itemView.findViewById(R.id.btn_detail);
        }
    }
}
