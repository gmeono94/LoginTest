package ib.facmed.unam.mx.logintest;

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

    public void createUser(int id, String nombre,String usuario, String email, int edad, String password){
        Usuario user = new Usuario();
        user.setId(id);
        user.setNonbre(nombre);
        user.setEmail(email);
        user.setUsuario(usuario);
        user.setEdad(edad);
        user.setPassword(password);

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(user);
        realm.commitTransaction();

    }

    public Usuario getUserByUsername(String userName){
        return realm.where(Usuario.class).equalTo("nombre",userName).findFirst();
    }

    public RealmResults<Usuario> getAllUsers(){
        RealmResults<Usuario> listaUsers = realm.where(Usuario.class).findAll();
        return listaUsers;

    }
}
