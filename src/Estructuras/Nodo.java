/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Erick
 */
public class Nodo {
    public Nodo siguiente;
    public Nodo anterior;
    public Object dato;
    
    public Nodo()
    {
        this.siguiente=null;
        this.anterior=null;
        this.dato=null;
    }
    public Nodo(Nodo siguiente,Nodo anterior, Object dato)
    {
        this.siguiente=siguiente;
        this.anterior=anterior;
        this.dato=dato;
    }
    public Nodo(Object dato)
    {
        this.dato=dato;
        this.siguiente=this.anterior=null;
    }
}
