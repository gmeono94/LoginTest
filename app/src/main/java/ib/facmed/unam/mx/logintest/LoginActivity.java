package ib.facmed.unam.mx.logintest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.MessageDigest;

import ib.facmed.unam.mx.logintest.Modelos.Usuario;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextUser;
    private EditText editTextPassword;
    private Button buttonLogin;
    private Button buttonRegister;
    private DatabaseManager dm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Realm.init(this);

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("LogTest") //Nombre de la base de datos
                .schemaVersion(1) //Numero de version de la base de datos
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);

        dm = new DatabaseManager(Realm.getDefaultInstance());


        editTextUser=(EditText)findViewById(R.id.etUsuarioLogin);
        editTextPassword=(EditText)findViewById(R.id.etPasswordLogin);
        buttonLogin=(Button)findViewById(R.id.buttonModificar);
        buttonRegister=(Button)findViewById(R.id.buttonRegister);

        buttonLogin.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.butonLogin:
                String user= buttonLogin.getText().toString();
                String password=sha256(buttonRegister.getText().toString());

                Usuario objUsr= dm.getUserByUsername(user);
                //Inician validaciones
                if(!objUsr.isValid()){
                    Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
                else if(objUsr.getPassword().equals(password)){
                    //Metodo que te lleva a la actividad welcome
                }
                else{
                    Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }




                break;
            case R.id.buttonRegister:
                Intent intent = new Intent(this, registerActivity.class);
                startActivity(intent);
                break;

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
