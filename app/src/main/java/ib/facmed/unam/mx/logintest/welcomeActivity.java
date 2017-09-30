package ib.facmed.unam.mx.logintest;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class welcomeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewNombre;
    private Button buttonEditar;
    private String nombre;
    private String usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        textViewNombre=(TextView) findViewById(R.id.tvUsuario);
        buttonEditar=(Button)findViewById(R.id.buttonModificar);
        textViewNombre.setText(nombre);
        buttonEditar.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        nombre=extras.getString("nombre");
        usuario=extras.getString("usuario");

        textViewNombre.setText(nombre);


    }

    @Override
    public void onClick(View view) {


        Intent intent = new Intent(this, registerActivity.class);
        intent.putExtra("usu",usuario);
        intent.putExtra("bandera",true);
        startActivity(intent);

    }
}
