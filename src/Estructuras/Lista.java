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
    
    
    public  void ImprimirLista(String nombre){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(this.PathActual()+"\\"+nombre+".dot");
            pw = new PrintWriter(fichero);
 
            
                pw.println( "digraph ColaAtencion {"
                        + "node [shape=polygon, fontcolor=\"blue\", height=0.5, color=\"red\"]"
                        + "edge [color=\"blue\"]"
                        + "rankdir=BT"
                        + "\" Inicio \"-> \""+cola.dato+"\""
                        + "");
               Nodo temporal=cola;
                        while(temporal.siguiente!=null)
                        {
                             pw.println("\""+temporal.dato+"\"-> \""+temporal.siguiente.dato+"\"");
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
           
//        
//        
//    File fp=new File("\\aqui.dot");
//    
//    fp = fopen("VENTANILLA.dot","a");
//    fprintf(fp,"subgraph ");
//    fprintf(fp,"ColaAtencion {\n");
//    fprintf(fp,"\tnode [fontcolor=\"blue\", height=0.5, color=\"red\"]\n");
//    fprintf(fp,"\tedge [color=\"blue\"]\n");
//    fprintf(fp,"\trankdir=LR\n");
//    struct clienteAtencion *temp;
//    temp=ultimoclienteAtencion;
//    //char *estado;
//
//    fprintf(fp," \"Cola Atencion\" -> ");
//   // fprintf(fp," \"Ventanillas\" -> \"De Atencion\" ");
//   // fprintf(fp,"\"Ventanillas\"->\"Normales\" ");
//    fprintf(fp,"\"Numero:%d \n Edad:%d \n Transaccion: \" ",
//            temp->numero,temp->edad);
//
//    while(temp!=NULL)
//    {
//
//        if(temp->anterior != NULL){
//            fprintf(fp,"\"Numero:%d \n Edad:%d \n Transaccion: \" -> ",
//                    temp->numero,temp->edad);
//        }else{
//              //fprintf(fp,"\"Numero:%d \n Dinero \n retirado:Q%f \n depositado:Q%f \" ",temp->numero,temp->dinero_retirado,temp->dinero_depositado);
//            fprintf(fp,"\"Numero:%d \n Edad:%d \n Transaccion: \" ",
//                    temp->numero,temp->edad);
//        }
//
//        temp=temp->anterior;
//    }
//    fprintf(fp,"\n}");
//    fclose(fp);
        }
    }
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
