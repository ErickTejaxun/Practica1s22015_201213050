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
public class Cola extends Lista{
    public Cola()
    {
    }
    public Cola(String nombre)
    {
        this.nombre=nombre;
    }
    public void Encolar(Object dato)
    {
        InsertarAlFin(dato);
    }
    public Nodo DesColar()
    {
        return  ExtaerCola();
    }
    public void Graficar(String nombre) throws IOException
    {
        ImprimirLista(nombre);
    }
    
}
