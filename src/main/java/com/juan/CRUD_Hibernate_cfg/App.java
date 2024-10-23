package com.juan.CRUD_Hibernate_cfg;



import com.juan.CRUD_Hibernate_cfg.DAO.UsuarioDAO;
import com.juan.CRUD_Hibernate_cfg.Modelo.Profesor;
import com.juan.CRUD_Hibernate_cfg.Modelo.Usuario;
import com.juan.CRUD_Hibernate_cfg.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.juan.CRUD_Hibernate_cfg.DAO.ProfesorDAO;

import java.time.LocalDate;
import java.util.List;


public class App 
{
	static SessionFactory factory = null;
    public static void main( String[] args )
    {
    	//SessionFactoryes una instancia que creará objetos de tipo Sessiono(fabrica sessiones).
    	
    	SessionFactory factory = HibernateUtil.getSessionFactory();
    	
    	//Ahora que ya tenemos el objeto SessionFactory podemos obtener la Session 
    	//para trabajar con Hibernate.
    	
    	//Una sesión se utiliza para obtener una conexión física con una base de datos. 
    	//El objeto Session es liviano y está diseñado para ser instanciado
    	//cada vez que se necesita una interacción con la base de datos. 
    	//Los objetos persistentes se guardan y recuperan a través de un objeto de sesión.

    	//Los objetos de la sesión no deben mantenerse abiertos durante mucho tiempo 
    	//porque generalmente no son seguros para subprocesos y deben crearse y destruirse 
    	//según sea necesario. La función principal de la sesión 
    	//es ofrecer, crear, leer y eliminar operaciones para instancias 
    	//de clases de entidades asignadas.
    	
		Session session = HibernateUtil.getSession();
    	
    	
         Profesor profesor1=new Profesor(102, "Carlos", "González", "Oltra");
         Profesor profesor2=new Profesor(103, "Ana", "Sanchez", "Velasco");
         Profesor profesor3=new Profesor(104, "Luis", "Colinas", "Alonso");

         //INSERTAR
         ProfesorDAO.insertar(session, profesor1);
         ProfesorDAO.insertar(session, profesor2);
         ProfesorDAO.insertar(session, profesor3);

         //BUSCAR
         Profesor profesor_aux=ProfesorDAO.buscarProfesor(session, 102);

         //MODIFICAR
         profesor_aux.setNombre("Carlos");
         ProfesorDAO.modificar(session, profesor_aux);

         //BORRAR
         ProfesorDAO.eliminar(session, profesor2);

         //CONSULTA
         ProfesorDAO.listarProfesores(session);


         //Crear nuevos usuarios
         Usuario usuario1=new Usuario(201, "Belen", "Gonzalez", LocalDate.parse("2001-07-13"));
         Usuario usuario2=new Usuario(202, "Andres", "Alonso", LocalDate.parse("1999-04-14"));
         Usuario usuario3=new Usuario(203, "Pedro", "Ferreras", LocalDate.parse("1982-02-23"));

         //INSERTAR
         UsuarioDAO.insertar(session, usuario1);
         UsuarioDAO.insertar(session, usuario2);
         UsuarioDAO.insertar(session, usuario3);

         //BUSCAR
         Usuario usuario_aux = UsuarioDAO.buscarUsuario(session, 203);

         //MODIFICAR
          usuario_aux.setNombre("Mario");
          UsuarioDAO.modificar(session, usuario_aux);

          //BORRAR
         UsuarioDAO.eliminar(session, usuario_aux);

         //CONSULTA
         UsuarioDAO.listarUsuarios(session);

         session.close();
         factory.close();
    }
}
