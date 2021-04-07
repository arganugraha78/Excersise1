package com.example.exercise;


import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class  Pendaftaran extends AppCompatActivity {
    Button btnDaftar,btnBatal;
    TextView jeniskelamain,agama;
    TextInputLayout DNamaError,DAlamatError,DafEmailError,DafPwError,DrepwError;
    EditText DNama,DAlamat,DEmai,DPw,Drepass;
    Boolean NamaValid,AlamatValid,EmailValid,PasswordValid,RePasswordValid;
    RadioButton idKepercayaan,Laki,Perempuan,Katolik,Islam,Konghucu,Budha,Hindu,Kristen;
    RadioGroup rgJenisKelamin,rgAgama1,rg2,rg3;
    String jk = "";
    String a = "";
    private boolean isChecking = true;
    private int cekAgama;
    private int cekKelamin;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);
        MenghubungkanKomponen();
        this.rgAgama1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != -1 && Pendaftaran.this.isChecking) {
                    Pendaftaran.this.isChecking = false;
                    Pendaftaran.this.rg2.clearCheck();
                    Pendaftaran.this.rg3.clearCheck();
                    Pendaftaran.this.cekAgama = i;
                }
                Pendaftaran.this.isChecking = true;
            }
        });
        this.rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != -1 && Pendaftaran.this.isChecking) {
                    Pendaftaran.this.isChecking = false;
                    Pendaftaran.this.rgAgama1.clearCheck();
                    Pendaftaran.this.rg3.clearCheck();
                    Pendaftaran.this.cekAgama = i;
                }
                Pendaftaran.this.isChecking = true;
            }
        });
        this.rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != -1 && Pendaftaran.this.isChecking) {
                    Pendaftaran.this.isChecking = false;
                    Pendaftaran.this.rgAgama1.clearCheck();
                    Pendaftaran.this.rg2.clearCheck();
                    Pendaftaran.this.cekAgama = i;
                }
                Pendaftaran.this.isChecking = true;
            }
        });
        this.rgJenisKelamin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != -1 && Pendaftaran.this.isChecking) {
                    Pendaftaran.this.isChecking = false;
                    Pendaftaran.this.cekKelamin = i;
                }
                Pendaftaran.this.isChecking = true;
            }
        });
        this.btnDaftar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Pendaftaran.this.JenisAgama(view);
                Pendaftaran.this.JenisKelamin(view);
                Pendaftaran.this.validasi(view);
            }
        });
        this.btnBatal.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Pendaftaran.this.startActivity(new Intent(Pendaftaran.this.getApplicationContext(), MainActivity.class));
            }
        });
    }

    public void MenghubungkanKomponen() {
        this.DNama = (EditText) findViewById(R.id.DNama);
        this.DAlamat= (EditText) findViewById(R.id.DAlamat);
        this.DEmai = (EditText) findViewById(R.id.DEmail);
        this.DPw = (EditText) findViewById(R.id.DPw);
        this.Drepass = (EditText) findViewById(R.id.Drepass);
        this.rgJenisKelamin = (RadioGroup) findViewById(R.id.rgJenisKelamin);
        this.rgAgama1 = (RadioGroup) findViewById(R.id.rgAgama1);
        this.rg2 = (RadioGroup) findViewById(R.id.rg2);
        this.rg3 = (RadioGroup) findViewById(R.id.rg3);
        this.Laki = (RadioButton) findViewById(R.id.Laki);
        this.Perempuan = (RadioButton) findViewById(R.id.Perempuan);
        this.Islam = (RadioButton) findViewById(R.id.Islam);
        this.Katolik = (RadioButton) findViewById(R.id.Katolik);
        this.Kristen = (RadioButton) findViewById(R.id.Kristen);
        this.Konghucu = (RadioButton) findViewById(R.id.Konghucu);
        this.Hindu = (RadioButton) findViewById(R.id.Hindu);
        this.Budha = (RadioButton) findViewById(R.id.Budha);
        this.idKepercayaan= (RadioButton) findViewById(R.id.idKepercayaan);
        this.DNamaError = (TextInputLayout) findViewById(R.id.DNamaError);
        this.DAlamatError = (TextInputLayout) findViewById(R.id.DNamaError);
        this.DafEmailError = (TextInputLayout) findViewById(R.id.DafEmailError);
        this.DrepwError = (TextInputLayout) findViewById(R.id.DrepwError);
        this.DafPwError = (TextInputLayout) findViewById(R.id.DafPwError);
        this.btnBatal = (Button) findViewById(R.id.btnBatal);
        this.btnDaftar = (Button) findViewById(R.id.btnDaftar);
    }

    public void JenisAgama(View view) {
        int i = this.cekAgama;
        if (i == R.id.Islam) {
            this.agama = Islam;
        } else if (i == R.id.Katolik) {
            this.agama = Katolik;
        } else if (i == R.id.Kristen) {
            this.agama = Kristen;
        } else if (i == R.id.Konghucu) {
            this.agama = Konghucu;
        } else if (i == R.id.Hindu) {
            this.agama = Hindu;
        } else if (i == R.id.Budha) {
            this.agama = Budha;
        } else if (i == R.id.idKepercayaan) {
            this.agama = "Penganut Kepercayaan";
        }
    }

    public void JenisKelamin(View view) {
        int i = this.cekKelamin;
        if (i == R.id.Laki) {
            this.jk = "Laki-Laki";
        } else if (i == R.id.Perempuan) {
            this.jk = "Perempuan";
        }
    }

    public void validasi(View view) {
        if (this.DNama.getText().toString().isEmpty() || DAlamat.getText().toString().isEmpty()
                || DEmai.getText().toString().isEmpty() || DPw.getText().toString().isEmpty()
                || Drepass.getText().toString().isEmpty() || agama.getText().toString().isEmpty() || jeniskelamain.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Data Harus Diisi Semua", Toast.LENGTH_LONG).show();
        }
        if (DNama.getText().toString().isEmpty()) {
            DNamaError.setError("Nama Tidak Boleh Kosong");
            NamaValid = false;
        } else {
            DNamaError.setErrorEnabled(false);
            NamaValid = true;
        }
        if (DAlamat.getText().toString().isEmpty()) {
            DAlamatError.setError("Alamat Tidak Boleh Kosong");
            AlamatValid = false;
        } else {
            DAlamatError.setErrorEnabled(false);
            AlamatValid = true;
        }
        if (DEmai.getText().toString().isEmpty()) {
            DafEmailError.setError("Email Tidak Boleh Kosong");
            EmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(DEmai.getText().toString()).matches()) {
            DafEmailError.setError("Harap Masukkan Email Dengan Benar");
            EmailValid = false;
        } else {
            EmailValid = true;
            DafEmailError.setErrorEnabled(false);
        }
        if (DPw.getText().toString().isEmpty()) {
            DafPwError.setError("Password Tidak Boleh Kosong");
            PasswordValid = false;
        } else if (this.DPw.getText().length() < 6) {
            DafPwError.setError("Panjang Password Minimal 6 Karakter");
            PasswordValid = false;
        } else {
            PasswordValid = true;
            DafPwError.setErrorEnabled(false);
        }
        if (Drepass.getText().toString().isEmpty()) {
            DrepwError.setError("Re-Password Tidak Boleh Kosong");
            RePasswordValid = false;
        } else if (Drepass.getText().length() < 6) {
            DrepwError.setError("Panjang Re-Password Minimal 6 Karakter");
            RePasswordValid = false;
        } else if (!Drepass.getText().toString().equals(DPw.getText().toString())) {
            DrepwError.setError("Password Tidak Sama");
            RePasswordValid = false;
        } else {
            RePasswordValid = true;
            DrepwError.setErrorEnabled(false);
        }
        if (NamaValid && AlamatValid && EmailValid && PasswordValid && RePasswordValid
                && !agama.isEmpty() && ! jeniskelamain.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    }
}
