package ib.facmed.unam.mx.logintest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText editTextUser;
    EditText editTextPassword;
    Button buttonLogin;
    Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUser=(EditText)findViewById(R.id.etUsuarioLogin);
        editTextPassword=(EditText)findViewById(R.id.etPasswordLogin);
        buttonLogin=(Button)findViewById(R.id.buttonModificar);
        buttonRegister=(Button)findViewById(R.id.buttonRegister);



    }
}
