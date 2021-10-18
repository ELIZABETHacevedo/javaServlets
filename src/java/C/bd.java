/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Mery Acevedo
 */
public class bd {
    public Connection conn ;
   
   // public DefaultTableModel model;
    
    
    
    public void conectar(){
         try
           
        {
             
              Class.forName("org.postgresql.Driver") ;
               
              conn = DriverManager.getConnection(
                     
                     "jdbc:postgresql://127.0.0.1:5432/tarea_datos",
                    
                     "mery", "mery");
         
                
        }
        catch(Exception e) {
      
        }
    }
    
    public void insertar(String id_libro,String nombre,String autor,String fecha_publicacion,String ubicacion){
        
        try
        {
            String query = " insert into libro (id_libro,nombre, autor, fecha_publicacion, ubicacion)"
                           + " values (?, ?, ?, ?, ?)";
      
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, Integer.valueOf(id_libro));
            pst.setString(2, nombre);
            pst.setString(3, autor);
            pst.setString(4, fecha_publicacion);
            pst.setString(5, ubicacion);
            

            // execute the preparedstatement
            pst.execute();
            
//            //limpiar controles visuales
//            this.txtAlias.setText("");
//            this.txtApellido.setText("");
//            this.txtClave.setText("");
//            this.txtNombre.setText("");
        }
        catch(Exception e) 
        {
             JOptionPane.showMessageDialog(null,"HA OCURRIDO UN ERROR: "+e.toString(),
                "Error", JOptionPane.ERROR_MESSAGE);  
        }
        
    }
    
    public void eliminar(String id_libro){
        System.out.print(id_libro);
        try{
             String query = " DELETE FROM libro WHERE id_libro = ?";
             PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, Integer.valueOf(id_libro));
            pst.execute();
            
        }catch(Exception e){
            
        }
    }
    
    public void actualizar(String ubicacion,int indice){
        try
            {
                String query = "UPDATE libro SET ubicacion=?"
                    
                        + " WHERE id_libro="+String.valueOf(indice);
                           
      
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1,ubicacion);
                
               

                // execute the preparedstatement
                pst.execute();
            
                //limpiar controles visuales
//                this.txtAlias.setText("");
//                this.txtApellido.setText("");
//                this.txtClave.setText("");
//                this.txtNombre.setText("");
//                
                // actualizar la tabla
               // this.consultar();
                
            }
            catch(Exception e) 
            {
                 JOptionPane.showMessageDialog(null,"HA OCURRIDO UN ERROR: "+e.toString(),
                "Error", JOptionPane.ERROR_MESSAGE);  
            }
    }
//    
//    public ArrayList<Object[]> verTodo(){
//         ArrayList<Object[]> lObjects=new ArrayList<>();
//         try
//        {
//          
//          Statement stmt = conn.createStatement() ;
//          String query = "SELECT id_libro, nombre, autor, fecha_publicacion, ubicacion FROM libro ORDER BY nombre;" ;
//          ResultSet rs = stmt.executeQuery(query) ;
//         
//         
//         // ArrayList<Object> lObjects=new ArrayList<>();
//         // Object Datos[]= new Object[6];
//         
//          
//          while (rs.next())
//           { Object Datos[]= new Object[6];
//              for (int i=0;i<5;i++) {Datos[i]=rs.getObject(i+1).toString().trim();}
//             // System.out.print(Datos[i].toString());}
//             lObjects.add(Datos);
//           }
//          
//          
//        }
//        catch(Exception e) 
//        {
//            JOptionPane.showMessageDialog(null,"HA OCURRIDO UN ERROR: "+e.toString(),
//                "Error", JOptionPane.ERROR_MESSAGE);  
//            System.out.print("hol6");
//            
//        }
//        
//        return lObjects;
//        
//        
//    }
    
    public ResultSet consultar()
    {
        try
        {
           Statement stmt = this.conn.createStatement() ;
           return stmt.executeQuery("select id_libro, nombre, autor, "
                   + "fecha_publicacion, ubicacion from libro "
                   + "ORDER BY id_libro;") ; 
        }
        catch(Exception e) 
        {
           return null;  
        }
    } 
    
}
