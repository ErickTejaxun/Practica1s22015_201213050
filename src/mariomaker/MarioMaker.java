/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariomaker;

import Estructuras.Lista;
import java.io.IOException;

/**
 *
 * @author Erick
 */
public class MarioMaker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Menu_carga ventana=new Menu_carga();
        Lista nueva=new Lista();
        for(int x=0;x<5;x++)
        {
            int n=x;
           nueva.InsertarAlFin(n);
            
        }
        for(int x=1;x<5;x++)
        {
            int n=10*x;
            int m=100*x;
            nueva.InsertarAlFin(n);
            nueva.InsertarAlFrente(m);
            
        }
        //nueva.ImprimirLista("lista");
        for(int x=0;x<10;x++)
        {
            int n=x;
           // System.out.println("Encolada "+ nueva.ExtraerCabeza().dato +" -----"+ nueva.ExtaerCola().dato);
            
        }
        
        
        ventana.show(true);
    }
    
    
    
    
    
    
}
