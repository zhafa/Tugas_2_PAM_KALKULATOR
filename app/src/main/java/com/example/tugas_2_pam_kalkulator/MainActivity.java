package com.example.tugas_2_pam_kalkulator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etAngka1, etAngka2;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAngka1 = findViewById(R.id.angka1);
        etAngka2 = findViewById(R.id.angka2);
        radioGroup = findViewById(R.id.radioGroup);
        Button btnHitung = findViewById(R.id.btnHitung);
        btnHitung.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return WindowInsetsCompat.CONSUMED;
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnHitung) {
            String angka1Str = etAngka1.getText().toString();
            String angka2Str = etAngka2.getText().toString();

            double angka1 = Double.parseDouble(angka1Str);
            double angka2 = Double.parseDouble(angka2Str);

            int selectedId = radioGroup.getCheckedRadioButtonId();
            double hasil = 0;
            if (selectedId == R.id.tambah || selectedId == R.id.kurang || selectedId == R.id.kali || selectedId == R.id.bagi){
                if (selectedId == R.id.tambah) {
                    hasil = angka1 + angka2;
                } else if (selectedId == R.id.kurang) {
                    hasil = angka1 - angka2;
                } else if (selectedId == R.id.kali) {
                    hasil = angka1 * angka2;
                } else if (selectedId == R.id.bagi) {
                    if (angka2 != 0) {
                        hasil = angka1 / angka2;
                    } else {
                        etAngka2.setError("Pembagi tidak boleh nol");
                        return;
                    }
                }
                Intent moveIntent = new Intent(MainActivity.this, Hasil.class);
                moveIntent.putExtra("HASIL", hasil);
                startActivity(moveIntent);
            }
            else{
                Toast.makeText(MainActivity.this, "Silahkan pilih operasi", Toast.LENGTH_SHORT).show();
            }


        }
    }
}