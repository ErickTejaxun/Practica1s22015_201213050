/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

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
            cola.anterior=null;
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
    
}
