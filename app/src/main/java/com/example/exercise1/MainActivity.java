package com.example.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;


public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText edemail, edpassword;
    String nama, password;
    TextInputLayout emm,pww;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin=findViewById(R.id.btSignIn);
        edemail=findViewById(R.id.edEmail);
        edpassword=findViewById(R.id.edPassword);
        emm=findViewById(R.id.em);
        pww=findViewById(R.id.pw);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama = edemail.getText().toString();
                password = edpassword.getText().toString();

                String email = "admin@mail.com";
                String pass ="123456";
                if (nama.isEmpty() || password.isEmpty())
                {
                    if( edemail.getText().toString().length() == 0 )
                        emm.setError( "Email tidak boleh kosong!" );
                    else emm.setError(null);
                    if( edpassword.getText().toString().length() == 0 )
                        pww.setError( "password tidak boleh kosong!" );
                    else pww.setError(null);
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan password wajib diisi!!!",
                            Toast.LENGTH_LONG);
                    t.show();
                }
                else
                {
                    if(nama.equals(email) && password.equals(pass))
                    {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Sukses",
                                Toast.LENGTH_LONG);
                        t.show();
                        Bundle b = new Bundle();
                        b.putString("a", nama.trim());
                        b.putString("b", password.trim());
                        Intent i = new Intent(getApplicationContext(), Home_Activity.class);
                        i.putExtras(b);
                        startActivity(i);
                    }else
                    {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login GAGAL",
                                Toast.LENGTH_LONG);
                        t.show();
                    }
                }

            }
        });
    }
public void test123(View view)
{
    Intent intent = new Intent(getApplicationContext(), FormPendaftaran.class);
    startActivity(intent);
}


}