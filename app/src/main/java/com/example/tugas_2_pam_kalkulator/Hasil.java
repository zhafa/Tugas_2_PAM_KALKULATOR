package com.example.tugas_2_pam_kalkulator;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Hasil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        double hasil = getIntent().getDoubleExtra("HASIL", 0);

        DecimalFormat df = new DecimalFormat("#.##");
        String hasilStr = df.format(hasil);

        TextView tvHasil = findViewById(R.id.hasil);
        tvHasil.setText("Hasil: " + hasilStr);
    }
}