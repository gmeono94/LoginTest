package ib.facmed.unam.mx.logintest;

import android.support.annotation.BoolRes;
import android.support.annotation.Nullable;
import android.widget.Toast;

import ib.facmed.unam.mx.logintest.Modelos.Usuario;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by gmeono on 29/09/17.
 */

public class DatabaseManager {

    private Realm realm;

    public DatabaseManager (Realm realm){
        this.realm=realm;

    }

    public Boolean createUser(String nom, String usu, String email, int edad, String password){

        Usuario user = new Usuario();
        user.setId(getNumberId());
        user.setNonbre(nom);
        user.setEmail(email);
        user.setUsuario(usu);
        user.setEdad(edad);
        user.setPassword(password);

        //Inicia bloque de validaciones
        if( getUserByUsername(usu)!=null || getUserByEmail(email)!=null){

            return false;
        }
        
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(user);
        realm.commitTransaction();

        return true;

    }

    public Usuario getUserByUsername(String userName){

        Usuario user=realm.where(Usuario.class).equalTo("nombre",userName).findFirst();
        if(user!=null)
            return user;

        return null;
    }

    public Usuario getUserByEmail(String email){
        return realm.where(Usuario.class).equalTo("email",email).findFirst();
    }

    public RealmResults<Usuario> getAllUsers(){
        RealmResults<Usuario> listaUsers = realm.where(Usuario.class).findAll();
        return listaUsers;

    }

    public int getNumberId(){
        return getAllUsers().size();
    }
}
