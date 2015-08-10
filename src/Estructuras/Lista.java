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
        Nodo resultado=null;
        if(Vacio())
        {
            resultado=null;
            JOptionPane.showMessageDialog(null, "Error, estructura vacia.");
        }
        else
        {
            resultado=cola;
            if(cola.anterior!=null)
            {
                cola=cola.siguiente;
            }else
            {
                cabeza=cola=null;
            }
            
           // cola.anterior=null;
        }
        
        return resultado;
    }
    public Nodo ExtraerCabeza()throws Exception
    {
	 if (Vacio())
	 	 throw new Exception ("Pila vacía, no se puede extraer.");
	 Nodo aux = cabeza;
	 cabeza = cabeza.anterior;
         cabeza.anterior=aux.anterior.anterior;
	 return aux;            
            //cabeza.siguiente=null;
        
        
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
                Nodo temporal=cola;
                
                
                pw.println( "digraph ColaAtencion {"
                        + "node [dir=both,shape=polygon, fontcolor=\"Black\", height=0.5, color=\"Grey\"]"
                        + "edge [color=\"blue\", color=\"blue:red\"]"
                        + "rankdir=BT"
                        + "");
                        if(temporal.siguiente==null)
                        {
                            Generic tmp=(Generic)temporal.dato;
                            String[] tipos={"Suelo","Pared","Goomba","Koopa","Ficha","Hongo","Personaje Principal","Castillo"};
                            pw.println("\"Nombre:"+tmp.nombre+"\nPath:"+ tmp.icono_path +"\nTipo:"+ tipos[tmp.tipo]+"\"");
                            
                        }else
                        {
                            while(temporal.siguiente!=null)
                            {
                                 Generic tmp=(Generic)temporal.dato;
                                 Generic tmp2=(Generic)temporal.siguiente.dato;
                                 String[] tipos={"Suelo","Pared","Goomba","Koopa","Ficha","Hongo","Personaje Principal","Castillo"};
                                 pw.println("\"Nombre:"+tmp.nombre+"\nPath:"+ tmp.icono_path +"\nTipo:"+ tipos[tmp.tipo]+"\"-> \"Nombre:"+tmp2.nombre+"\nPath:"+ tmp2.icono_path +"\nTipo:"+ tipos[tmp2.tipo]+"\"");
                                 pw.println("\"Nombre:"+tmp2.nombre+"\nPath:"+ tmp2.icono_path +"\nTipo:"+ tipos[tmp2.tipo]+"\"-> \"Nombre:"+tmp.nombre+"\nPath:"+ tmp.icono_path +"\nTipo:"+ tipos[tmp.tipo]+"\"");
                                 temporal=temporal.siguiente;
                            }
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
    public Lista clonar()
    {
        Lista lista_temporal=new Lista();
        Nodo nodo_temporal=new Nodo();
        nodo_temporal=cabeza;
        if(!this.Vacio())
        {
            Nodo nuevo_nodo=new Nodo(cola);
            lista_temporal.InsertarAlFrente(nuevo_nodo);
            while(nodo_temporal.anterior!=null)
            {
                nuevo_nodo=new Nodo(nodo_temporal);
                lista_temporal.InsertarAlFrente(nuevo_nodo);
                nodo_temporal=nodo_temporal.anterior;
            }
            
        }

        return lista_temporal;
    }
    public Pila clonarpila()
    {
        Pila pila_temporal=new Pila();
        while(!Vacio())
        {
            pila_temporal.Apilar(this.ExtaerCola());
        }
        
        return pila_temporal;
    }
    public Cola clonarcola()
    {
        Cola cola_temporal=new Cola();
        while(!Vacio())
        {
            cola_temporal.Encolar(this.ExtaerCola());
        }
        
        return cola_temporal;
    }
    public int tamanho()
    {
        int tamanho=0;
        Nodo temporal=cola;
        while(temporal.siguiente!=null)
        {
            tamanho++;
            temporal=temporal.siguiente;
        }     
        return tamanho+1;
    }
 
    public void click(java.awt.event.MouseEvent evt) {                                           
       JOptionPane.showMessageDialog(null, this.nombre);
    } 
    public Nodo RPila(int numero)
    {
        Nodo resultado=null;
        if(Vacio())
        {
            resultado=null;
            JOptionPane.showMessageDialog(null, "Error, estructura vacia.");
        }
        else
        {
            resultado=cabeza;
            for(int n=0;n<numero;n++)
            {
                resultado=resultado.anterior;
            }
        }
        return resultado;
       
    }
    
    public Nodo RCola(int numero)
    {
        Nodo resultado=null;
        if(Vacio())
        {
            resultado=null;
            JOptionPane.showMessageDialog(null, "Error, estructura vacia.");
        }
        else
        {
            resultado=cola;
            for(int n=0;n<numero;n++)
            {
                resultado=resultado.siguiente;
            }
        }
        return resultado;
       
    }
    public void eliminarCola(int indice)
    {
        Nodo temporal=cola;
        
        
        for(int n=0;n<indice;n++)
        {
            temporal=temporal.siguiente;            
        }
        
        if(temporal.siguiente!=null)
        {
            Nodo temporal2=temporal;
            temporal.siguiente=temporal.siguiente.siguiente;
            temporal.anterior=temporal2.anterior;           
        }else
        {
            cabeza=cabeza.anterior;
            cabeza.siguiente=null;
        }
        
    }

    public void eliminarPila(int indice)
    {
        Nodo temporal=cabeza;
        
        
        for(int n=0;n<indice;n++)
        {
            temporal=temporal.anterior;            
        }
        
        if(temporal.anterior!=null)
        {
            Nodo temporal2=temporal;
            temporal.siguiente=temporal.siguiente.siguiente;
            temporal.anterior=temporal2.anterior;           
        }else
        {
            cola=cola.siguiente;
            cola.anterior=null;
        }
        
    }
    
        public void eliminar (Generic dato)
        {
        String nombre=dato.nombre;
        int tipo=dato.tipo;
        String path=dato.icono_path;
        Nodo actual;
        boolean encontrado = false;
        actual = cabeza;
        // Bucle de búsqueda
        while ((actual != null) && (!encontrado))
        {
         
         Generic temp=(Generic)actual.dato;
         encontrado = (temp.nombre.equals(nombre) && temp.tipo==tipo && temp.icono_path.equals(path));
         if (!encontrado)
         actual = actual.siguiente;
        }
         
        if (actual != null)
        {
         
         if (actual == cabeza)
         {
         cabeza = actual.anterior;
         if (actual.siguiente != null)
         actual.siguiente.anterior = null;
         }
         else if (actual.siguiente != null) // No es el último nodo
         {
         actual.anterior.siguiente = actual.siguiente;
         actual.siguiente.anterior = actual.anterior;
         }
         else // último nodo
         actual.anterior.siguiente = null;
         actual = null;
        }
}
    
   
    
}
