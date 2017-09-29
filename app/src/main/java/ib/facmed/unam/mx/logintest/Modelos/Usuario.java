package ib.facmed.unam.mx.logintest.Modelos;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by gmeono on 29/09/17.
 */

public class Usuario extends RealmObject {


    @PrimaryKey
    private int id;
    private String nonbre;
    private String usuario;
    private String email;
    private int edad;
    private String password;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNonbre() {
        return nonbre;
    }

    public void setNonbre(String nonbre) {
        this.nonbre = nonbre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
