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
public class ListaDoble {
    NodoDoble cabeza;
    NodoDoble cola;
    
    public ListaDoble insertarCabezaLista(Generic entrada)
    {
    NodoDoble nuevo;
    nuevo = new NodoDoble(entrada);
    nuevo.adelante = cabeza;
    if (cabeza != null )
     cabeza.atras = nuevo;
    cabeza = nuevo;
    return this;
    }
    
    public ListaDoble insertaDespues(NodoDoble anterior, Generic entrada)
    {
    NodoDoble nuevo;
    nuevo = new NodoDoble(entrada);
    nuevo.adelante = anterior.adelante;
    if (anterior.adelante != null)
     anterior.adelante.atras = nuevo;
    anterior.adelante = nuevo;
    nuevo.atras = anterior;
    return this;
    }
    
}
