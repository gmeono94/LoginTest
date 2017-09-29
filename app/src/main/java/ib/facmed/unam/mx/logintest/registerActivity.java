package ib.facmed.unam.mx.logintest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import io.realm.Realm;

public class registerActivity extends AppCompatActivity implements View.OnClickListener {

    private Realm realm;
    private EditText editTextUsuario;
    private EditText editTextNombre;
    private EditText editTextEmail;
    private EditText editTextEdad;
    private EditText editTextPassword;
    private Button buttonEnviar;
    private DatabaseManager dm;



    public registerActivity(Realm realm, DatabaseManager dm){
        this.realm=realm;
        this.dm=dm;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextUsuario= (EditText)findViewById(R.id.etUsuario);
        editTextNombre=(EditText)findViewById(R.id.etNombre);
        editTextEmail=(EditText) findViewById(R.id.etEmail);
        editTextPassword= (EditText)findViewById(R.id.etPassword);
        editTextEdad=(EditText)findViewById(R.id.etEdad);
        buttonEnviar=(Button)findViewById(R.id.buttonEnviarDatos);

        buttonEnviar.setOnClickListener(this);






    }


    @Override
    public void onClick(View view) {

        boolean estado;



        estado=dm.createUser(editTextNombre.getText().toString(),editTextUsuario.getText().toString(),
                editTextEmail.getText().toString(),Integer.parseInt(editTextEdad.getText().toString()),
                sha256(editTextPassword.getText().toString()));

        if(estado){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        else{
            Toast.makeText(this, "Usuario o correo electronico ya existente...", Toast.LENGTH_SHORT).show();
        }

    }

    public static String sha256(String base) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }


}
