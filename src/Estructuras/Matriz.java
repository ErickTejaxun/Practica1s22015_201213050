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

public class Matriz 
{
    Matriz adelante;
    Matriz atras;
    Matriz arriba;
    Matriz abajo;
    Matriz primero, ultimo;//primero y ultimo de las columnas
    Matriz Fprimero, Fultimo;//primero y ultimo de las filas
    String dato;//es el dato de cada celda
    int columna;//es el nuemero de columna
    int fila;//es el numero de fila
    int numero=0;//numero que se va a guardar en la celda
    
    /** Creates a new instance of Nodo */
    public Matriz(){} 

    public Matriz(int columna)
    {
        this.columna=columna;                 
        adelante=null;
        atras=null;
    }
    public Matriz(int fila,String f)
    {
        this.fila=fila;
        abajo=null;
        arriba=null;
    }
    public Matriz(int columna,int fila, String dato)//este me sirve para enlazar los nodos
    /*pero cuando sean de tipo string*/
    {
        this.columna=columna;
        this.fila=fila;
        this.dato=dato;
        /*por medio de este voy a generar los nodos en cada una de las celdas*/        
    }
    /*Este es para poder guardar los datos en las celdas pero cuando sea de tipo
     *numerico*/
    public Matriz(int columna, int fila, int numero)
    {
        this.columna=columna;
        this.fila=fila;
        this.numero=numero;
    }
    /*Este es para los de tipo cadena*/
    public Matriz crearMatriz(int columna,int fila, String dato,int numero)
    {
        this.insertarColumna(columna,fila,dato,numero);
        return this;
    }                    
    
    public Matriz insertarColumna(int columna, int fila, String dato, int numero)
    {
        Matriz nuevo;
        nuevo=new Matriz(columna);
        if(primero==null && ultimo==null)//si la lista est� vacia creo los nodos
        {
            primero=nuevo;
            ultimo=nuevo;                        
        }
        
        else if(columna<primero.columna)//si el nodo nuevo est� antes del primero
        {
            nuevo.adelante=primero;
            primero.atras=nuevo;
            primero=nuevo;            
        }
        else 
        {
            Matriz anterior, p;
            anterior=p=primero;
            while((p.adelante!=null)&&(columna>p.columna))
            {           //nos toca ingresar al nodo
                anterior=p;                
                p=p.adelante;
            }
            if(columna>p.columna)
            {
                anterior=p;
                ultimo=nuevo;
                ultimo.atras=anterior;
                anterior.adelante=ultimo;               
            }
            else if(columna<p.columna)
            {
                anterior.adelante=nuevo;
                nuevo.atras=anterior;
                nuevo.adelante=p;
                p.atras=nuevo;
            }
            else if(columna==p.columna)
            {
                System.out.println("la columna ya existe");                
            }
        }
        this.InsertarFila(fila);
        if(dato.compareToIgnoreCase(" ")!=0)
        {
            this.insertar_Nodo_columna(columna,fila,dato);
        }
        else
        {
            this.insertar_Nodo_columna(columna,fila,numero);
        }

        System.out.println("my matriz es "+this);
       return this;
    }
            
    // ************************************** /
    public Matriz InsertarFila(int fila)  
    {
        Matriz nuevo;
        nuevo=new Matriz(fila,"fila");
        if(Fprimero==null && Fultimo==null)//si la lista est� vacia creo los nodos
        {
            Fprimero=nuevo;
            Fultimo=nuevo;                        
        }
        
        else if(fila<Fprimero.fila)//si el nodo nuevo est� antes del primero
        {
            nuevo.abajo=Fprimero;
            Fprimero.arriba=nuevo;
            Fprimero=nuevo;            
        }
        else 
        {
            Matriz anterior, p;
            anterior=p=Fprimero;
            while((p.abajo!=null)&&(fila>p.fila))
            {           //nos toca ingresar al nodo
                anterior=p;                
                p=p.abajo;
            }
            if(fila>p.fila)
            {
                anterior=p;
                Fultimo=nuevo;
                Fultimo.arriba=anterior;
                anterior.abajo=Fultimo;               
            }
            else if(fila<p.fila)
            {
                anterior=p;
                anterior.abajo=nuevo;
                nuevo.arriba=anterior;
                nuevo.abajo=p;
                p.arriba=nuevo;
            }
            else if(fila==p.fila)///////////revisar esto
            {
                System.out.println("la columna ya existe");                
            }
        } 
        return this;
    }       
    
    public Matriz insertar_Nodo_columna(int columna, int fila, String dato)
    {
        Matriz n;
        n=primero;
        Matriz actual;
        Matriz primer_col;
        Matriz nuevo = new Matriz(columna,fila,dato);
        Matriz nuevo2=nuevo;
        for(;n.columna!=columna;n=n.adelante)
        {       }
        if(n.columna==columna)
        {
            actual=n;//columna
            if(actual.abajo==null)//la lista está vacia
            {
                actual.abajo=nuevo;//este es el primer nodo de la columna
                nuevo.arriba=actual;
                nuevo.abajo=null;
            }
            else if(actual.abajo!=null)
            {
                primer_col=actual;
                actual=actual.abajo;
                if(fila<actual.fila)
                {
                    nuevo.abajo=actual;
                    nuevo.arriba=primer_col;
                    actual.arriba=nuevo;
                    primer_col.abajo=nuevo;
                }
                else if(fila>actual.fila)
                {
                    Matriz anterior,p;
                    anterior=p=actual;
                    while((p.abajo!=null)&&(fila>p.fila))///revisar esto porque me da clavo
                    {
                        anterior=p;
                        p=p.abajo;
                    }
                    if(fila>p.fila)
                    {
                        anterior=p;
                        nuevo.arriba=anterior;
                        anterior.abajo=nuevo;
                        nuevo.abajo=null;
                    }
                    else if(fila<p.fila)
                    {
                        anterior.abajo=nuevo;
                        nuevo.arriba=anterior;
                        nuevo.abajo=p;
                        p.arriba=nuevo;
                    }                  
                    else if(fila==p.fila)
                    {
                        /*
                         *este es donde tengo que agregar el nuevo valor del nodo                         
                        p.dato=dato;
//                         */
                    }
                }
            }
        }
        this.insertar_nodo_fila(columna,fila,dato,nuevo2);
        return this;
    }
    
     public Matriz insertar_Nodo_columna(int columna, int fila, int numero)
    {
        Matriz n;
        n=primero;
        Matriz actual;
        Matriz primer_col;
        Matriz nuevo = new Matriz(columna,fila,numero);
        Matriz nuevo2=nuevo;
        for(;n.columna!=columna;n=n.adelante)
        {       }
        if(n.columna==columna)
        {
            actual=n;//columna
            if(actual.abajo==null)//la lista está vacia
            {
                actual.abajo=nuevo;//este es el primer nodo de la columna
                nuevo.arriba=actual;
                nuevo.abajo=null;
            }
            else if(actual.abajo!=null)
            {
                primer_col=actual;
                actual=actual.abajo;
                if(fila<actual.fila)
                {
                    nuevo.abajo=actual;
                    nuevo.arriba=primer_col;
                    actual.arriba=nuevo;
                    primer_col.abajo=nuevo;
                }
                else if(fila>actual.fila)
                {
                    Matriz anterior,p;
                    anterior=p=actual;
                    while((p.abajo!=null)&&(fila>p.fila))///revisar esto porque me da clavo
                    {
                        anterior=p;
                        p=p.abajo;
                    }
                    if(fila>p.fila)
                    {
                        anterior=p;
                        nuevo.arriba=anterior;
                        anterior.abajo=nuevo;
                        nuevo.abajo=null;
                    }
                    else if(fila<p.fila)
                    {
                        anterior.abajo=nuevo;
                        nuevo.arriba=anterior;
                        nuevo.abajo=p;
                        p.arriba=nuevo;
                    }                  
                    else if(fila==p.fila)
                    {
                        /*
                         *este es donde tengo que agregar el nuevo valor del nodo                         
                        p.dato=dato;
                         */
                    }
                }
            }
        }
        this.insertar_nodo_fila(columna,fila,numero,nuevo2);
        return this;
    }
    
     public Matriz insertar_nodo_fila(int columna,int fila,int numero, Matriz m)
    {    
        Matriz n;
        n=Fprimero;
        Matriz actual;
        Matriz primer_fila;        
        for(;n.fila!=fila;n=n.abajo){/*solo es para que haga el ciclo*/ }
        if(n.fila==fila)
        {
            actual=n;//fila
            if(actual.adelante==null)//la lista está vacia
            {
                actual.adelante=m;//este es el primer nodo de la columna
                m.atras=actual;
                m.adelante=null;
            }
            else if(actual.adelante!=null)
            {
                primer_fila=actual;
                actual=actual.adelante;
                if(columna<actual.columna)
                {
                    m.adelante=actual;
                    m.atras=primer_fila;
                    actual.atras=m;
                    primer_fila.adelante=m;
                }
                else if(columna>actual.columna)
                {
                    Matriz anterior,p;
                    anterior=p=actual;
                    while((p.adelante!=null)&&(columna>p.columna))
                    {
                        anterior=p;
                        p=p.adelante;
                    }
                    if(columna>p.columna)
                    {
                        anterior=p;
                        m.atras=anterior;
                        anterior.adelante=m;
                        m.adelante=null;
                    }
                    else if(columna<p.columna)
                    {
                        anterior.adelante=m;
                        m.atras=anterior;
                        m.adelante=p;
                        p.atras=m;
                    }                  
                    else if(columna==p.columna)
                    {
//                        m.numero=numero;
                        /*
                         *este es donde tengo que agregar el nuevo valor del nodo                         
                        p.dato=dato;
                         */
                    }
                }
            }
        }
        return this;
    }   
        
    public Matriz insertar_nodo_fila(int columna,int fila,String dato, Matriz m)
    { 
        Matriz n;
        n=Fprimero;
        Matriz actual;
        Matriz primer_fila;        
        for(;n.fila!=fila;n=n.abajo){/*solo es para que haga el ciclo*/ }
        if(n.fila==fila)
        {
            actual=n;//fila
            if(actual.adelante==null)//la lista está vacia
            {
                actual.adelante=m;//este es el primer nodo de la columna
                m.atras=actual;
                m.adelante=null;
            }
            else if(actual.adelante!=null)
            {
                primer_fila=actual;
                actual=actual.adelante;
                if(columna<actual.columna)
                {
                    m.adelante=actual;
                    m.atras=primer_fila;
                    actual.atras=m;
                    primer_fila.adelante=m;
                }
                else if(columna>actual.columna)
                {
                    Matriz anterior,p;
                    anterior=p=actual;
                    while((p.adelante!=null)&&(columna>p.columna))
                    {
                        anterior=p;
                        p=p.adelante;
                    }
                    if(columna>p.columna)
                    {
                        anterior=p;
                        m.atras=anterior;
                        anterior.adelante=m;
                        m.adelante=null;
                    }
                    else if(columna<p.columna)
                    {
                        anterior.adelante=m;
                        m.atras=anterior;
                        m.adelante=p;
                        p.atras=m;
                    }                  
                    else if(columna==p.columna)
                    {
//                        m.dato=dato;
                        /*
                         *este es donde tengo que agregar el nuevo valor del nodo                         
                        p.dato=dato;
                         */
                    }
                }
            }
        }
        return this;
    }   
    
    public Matriz Buscar(int fila, int col2)
    {
        Matriz n;
        n=primero;
        Matriz anterior;
        Matriz primer_col = null;    
        while((n.adelante!=null)&&(col2>n.columna))
        {
            anterior=n;
            n=n.adelante;
        }
        if(n.columna==col2)
        {
            while((n.abajo!=null)&&(fila<=n.fila))
            {
                anterior =n;
                n=n.abajo;
            }
            n=n.abajo;
            if(n.fila==fila)
            {
                primer_col=n;  
                System.out.println("hola ya retorno");
            }
        }                  
//        System.out.println("retorno a "+primer_col.dato+" numero "+primer_col.numero);
        return primer_col;
    }        
}
