package com.example.registrationform;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    private TextView textNIM, textNama, textEmail, textPhone, textJurusan, textFakultas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        textNIM = findViewById(R.id.textNIM);
        textNama = findViewById(R.id.textNama);
        textEmail = findViewById(R.id.textEmail);
        textPhone = findViewById(R.id.textPhone);
        textJurusan = findViewById(R.id.textJurusan);
        textFakultas = findViewById(R.id.textFakultas);

        Intent intent = getIntent();
        textNIM.setText(intent.getStringExtra("NIM"));
        textNama.setText(intent.getStringExtra("Nama"));
        textEmail.setText(intent.getStringExtra("Email"));
        textPhone.setText(intent.getStringExtra("Phone"));
        textJurusan.setText(intent.getStringExtra("Jurusan"));
        textFakultas.setText(intent.getStringExtra("Fakultas"));

        textEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", textEmail.getText().toString(), null));
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });

        textPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + textPhone.getText().toString()));
                startActivity(dialIntent);
            }
        });
    }
}