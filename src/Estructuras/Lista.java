/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick
 */
public class Lista {
    public Nodo cabeza;
    public Nodo cola;
    public String nombre;
    public Lista()
    {
        this.nombre="Lista Doble";
        this.cabeza=this.cola=null;
    }
    
    
    public void InsertarAlFrente(Object dato)
    {
        if((Vacio()))
        {
         cabeza=cola=new Nodo(dato);  
        }
        else
        {
           Nodo temp=new Nodo(dato);
           temp.siguiente=null;
           temp.anterior=cabeza;
           cabeza.siguiente=temp;
           cabeza=temp;
        }
    }
    public void InsertarAlFin(Object dato)
    {
        if((Vacio()))
        {
         cabeza=cola=new Nodo(dato);  
        }
        else
        {
           Nodo temp=new Nodo(dato);
           temp.siguiente=cola;
           temp.anterior=null;
           cola.anterior=temp;
           cola=temp;
        }
    }
    public Nodo ExtaerCola()
    {
        Nodo resultado=new Nodo();
        if(Vacio())
        {
            resultado=null;
            JOptionPane.showMessageDialog(null, "Error, estructura vacia.");
        }
        else
        {
            resultado=cola;
            cola=cola.siguiente;
           // cola.anterior=null;
        }
        
        return resultado;
    }
    public Nodo ExtraerCabeza()
    {
        Nodo resultado=new Nodo();
        if(Vacio())
        {
            resultado=null;
            JOptionPane.showMessageDialog(null, "Error, estructura vacia.");
        }
        else
        {
            resultado=cabeza;
            cabeza=cabeza.anterior;
            cabeza.siguiente=null;
        }
        return resultado;
    }
    public boolean Vacio()
    {
        boolean resultado=false;
        if((cola==null)&&(cabeza==null))
        {
            resultado=true;
        }
        return resultado;
    }
    
    
    public  void ImprimirLista(String nombre) throws IOException{
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(this.PathActual()+"\\"+nombre+".dot");
            pw = new PrintWriter(fichero);
                //dir=both
            
                pw.println( "digraph ColaAtencion {"
                        + "node [dir=both,shape=polygon, fontcolor=\"Black\", height=0.5, color=\"Grey\"]"
                        + "edge [color=\"blue\", color=\"blue:red\"]"
                        + "rankdir=BT"
                        + "");
               Nodo temporal=cola;
                        while(temporal.siguiente!=null)
                        {
                             Generic tmp=(Generic)temporal.dato;
                             Generic tmp2=(Generic)temporal.siguiente.dato;
                             String[] tipos={"Suelo","Pared","Goomba","Koopa","Ficha","Hongo","Personaje Principal","Castillo"};
                             pw.println("\""+tmp.nombre+"\n"+ tmp.icono_path +"\n"+ tipos[tmp.tipo]+"\"-> \""+tmp2.nombre+"\n"+ tmp2.icono_path +"\n"+ tipos[tmp2.tipo]+"\"");
                             temporal=temporal.siguiente;
                        }
                pw.println("}");
                
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
              
     
        }
    }

                   String  cmd = "dot "+PathActual()+"\\"+nombre+".dot "+"-Tpng "+"-o "+PathActual()+"\\"+nombre+".png"; //Crear imagen.
                   Runtime.getRuntime().exec(cmd);
   
    
}
    public String PathActual(){
    String path="";
     File miDir = new File (".");
     try {
       //System.out.println (miDir.getCanonicalPath());
       path=miDir.getCanonicalPath();
     }
     catch(Exception e) {
       e.printStackTrace();
       }
     return path;
}
    
}
