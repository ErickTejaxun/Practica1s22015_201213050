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
public class NodoDoble {
    Generic dato;
    NodoDoble adelante;
    NodoDoble atras;
    
    public NodoDoble(Generic entrada)
    {
    dato = entrada;
    adelante = atras = null;
    }
    
}
