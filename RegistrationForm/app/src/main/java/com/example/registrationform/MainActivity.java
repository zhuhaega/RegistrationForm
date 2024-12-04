package com.example.registrationform;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerFakultas;
    private EditText inputNIM, inputNama, inputEmail, inputPhone, inputJurusan;
    private Button buttonRegister, buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerFakultas = findViewById(R.id.spinnerFakultas);
        inputNIM = findViewById(R.id.inputNIM);
        inputNama = findViewById(R.id.inputNama);
        inputEmail = findViewById(R.id.inputEmail);
        inputPhone = findViewById(R.id.inputPhone);
        inputJurusan = findViewById(R.id.inputJurusan);
        buttonRegister = findViewById(R.id.buttonRegister);
        buttonReset = findViewById(R.id.buttonReset);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    Intent intent = new Intent(MainActivity.this, SummaryActivity.class);
                    intent.putExtra("NIM", inputNIM.getText().toString());
                    intent.putExtra("Nama", inputNama.getText().toString());
                    intent.putExtra("Email", inputEmail.getText().toString());
                    intent.putExtra("Phone", inputPhone.getText().toString());
                    intent.putExtra("Jurusan", inputJurusan.getText().toString());
                    intent.putExtra("Fakultas", spinnerFakultas.getSelectedItem().toString());
                    startActivity(intent);
                }
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearInputs();
            }
        });
    }

    private boolean validateInputs() {
        if (TextUtils.isEmpty(inputNIM.getText())) {
            inputNIM.setError("NIM wajib diisi");
            return false;
        }
        if (TextUtils.isEmpty(inputNama.getText())) {
            inputNama.setError("Nama wajib diisi");
            return false;
        }
        if (TextUtils.isEmpty(inputEmail.getText()) || !android.util.Patterns.EMAIL_ADDRESS.matcher(inputEmail.getText()).matches()) {
            inputEmail.setError("Email tidak valid");
            return false;
        }
        if (TextUtils.isEmpty(inputPhone.getText()) || !TextUtils.isDigitsOnly(inputPhone.getText())) {
            inputPhone.setError("Phone hanya boleh angka");
            return false;
        }
        if (TextUtils.isEmpty(inputJurusan.getText())) {
            inputJurusan.setError("Jurusan wajib diisi");
            return false;
        }
        return true;
    }

    private void clearInputs() {
        inputNIM.setText("");
        inputNama.setText("");
        inputEmail.setText("");
        inputPhone.setText("");
        inputJurusan.setText("");
        spinnerFakultas.setSelection(0);
    }
}