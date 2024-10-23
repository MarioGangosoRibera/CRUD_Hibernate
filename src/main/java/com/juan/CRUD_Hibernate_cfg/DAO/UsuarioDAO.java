package com.juan.CRUD_Hibernate_cfg.DAO;

import com.juan.CRUD_Hibernate_cfg.Modelo.Usuario;
import org.hibernate.Session;

import java.util.List;

public class UsuarioDAO {

    public static void insertar(Session session, Usuario usu) {
        session.beginTransaction();
        session.save(usu);
        session.getTransaction().commit();
    }

    public static Usuario buscarUsuario(Session session, int id){
        Usuario u;
        u = (Usuario)session.get(Usuario.class, id);
        System.out.println(u.getId());
        System.out.println(u.getNombre());
        System.out.println(u.getApellidos());
        System.out.println(u.getFechaNacimiento());
        return u;
    }

    public static void modificar(Session session, Usuario usu){
        session.beginTransaction();
        session.update(usu);
        session.getTransaction().commit();
    }

    public static void eliminar(Session session, Usuario usu){
        session.beginTransaction();
        session.delete(usu);
        session.getTransaction().commit();
    }

    public static void listarUsuarios(Session session){
        List<Usuario> lista = session.createQuery("from Usuario").getResultList();

        for (Usuario u : lista){
            System.out.println(u.toString());
        }
    }

}
