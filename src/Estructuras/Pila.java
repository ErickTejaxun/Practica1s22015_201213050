/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.io.IOException;

/**
 *
 * @author Erick
 */
public class Pila extends Lista {
    
    public Pila(String nombre)
    {
        this.nombre=nombre;
    }
    public Pila()
    {
        
    }
    public void Apilar(Object dato)
    {
        InsertarAlFrente(dato);
    }
    public Nodo DesApilar() throws Exception
    {
       return ExtraerCabeza();
    }
    public void Graficar(String nombre) throws IOException
    {
        ImprimirLista(nombre);
    }
    
}
