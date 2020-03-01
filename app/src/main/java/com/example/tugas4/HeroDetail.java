package com.example.tugas4;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class HeroDetail extends AppCompatActivity {
    ImageView ivDetail;
    TextView tvDetailnama, tvDesc;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.detail_hero);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tvDetailnama = findViewById(R.id.detail_hero_title);
        tvDesc = findViewById(R.id.detail_hero);
        ivDetail = findViewById(R.id.detail_hero_gambar);
        getIncomingIntent();
    }

    private void getIncomingIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int getImage = bundle.getInt("image");
            Glide.with(getApplicationContext()).load(getImage).into(ivDetail);
            String getTitle = bundle.getString("title");
            String getDesc = bundle.getString("desc");

            tvDetailnama.setText(getTitle);
            tvDesc.setText(getDesc);
            ivDetail.setImageResource(getImage);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
