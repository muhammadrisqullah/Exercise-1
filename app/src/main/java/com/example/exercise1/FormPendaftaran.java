package com.example.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class FormPendaftaran extends AppCompatActivity {
    EditText edtNama, edtAlamat, edtEmail, edtPassword, edtRepass;
    String Nama,alamat,email,password,repass;
    Button back,lgn;
    TextInputLayout ln,la,le,lp,lr;
    RadioGroup a,b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pendaftaran);
        edtNama = findViewById(R.id.ednama);
        edtAlamat = findViewById(R.id.edalamat);
        edtEmail = findViewById(R.id.edemail);
        edtPassword =findViewById(R.id.edpass);
        edtRepass=findViewById(R.id.edrepass);
        back =findViewById(R.id.button2);
        lgn =findViewById(R.id.button);
        ln=findViewById(R.id.layna);
        la=findViewById(R.id.layal);
        le=findViewById(R.id.layem);
        lp=findViewById(R.id.laypa);
        lr=findViewById(R.id.layre);
        a=findViewById(R.id.radioGroup);
        b=findViewById(R.id.radioGroup2);

        lgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nama= edtNama.getText().toString();
                alamat= edtAlamat.getText().toString();
                email= edtEmail.getText().toString();
                password= edtPassword.getText().toString();
                repass= edtRepass.getText().toString();

                if (Nama.isEmpty()||alamat.isEmpty()||email.isEmpty()||password.isEmpty()||repass.isEmpty()||a.getCheckedRadioButtonId() == -1||b.getCheckedRadioButtonId() == -1)
                {
                    if (edtNama.getText().toString().length() == 0)
                        ln.setError("Nama Tidak boleh kosong");
                    else ln.setError(null);
                    if (edtAlamat.getText().toString().length() == 0)
                        la.setError("Alamat Tidak Boleh kosong");
                    else la.setError(null);
                    if (edtEmail.getText().toString().length() == 0)
                        le.setError("Email Tidak Boleh Kosong");
                    else le.setError(null);
                    if (edtPassword.getText().toString().length() == 0)
                        lp.setError("Password tidak boleh Kosong");
                    else lp.setError(null);
                    if (edtRepass.getText().toString().length() == 0)
                        lr.setError("Re-Password tidak boleh kosong");
                    else lr.setError(null);
                    Toast t = Toast.makeText(getApplicationContext(),
                            "DATA HARUS DI ISI SEMUA!!!",
                            Toast.LENGTH_LONG);
                    t.show();
                }
                else {
                    if (edtPassword.getText().toString().equals(edtRepass.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Pendaftaran Berhasill...",
                                Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Password dan repassword harus sama!",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}