/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.awt.Image;
import javax.swing.JLabel;

/**
 *
 * @author Erick
 */
public class Generic extends JLabel{
    public String nombre;
    public String icono_path;
    public int tipo;
    public Image icono;
    public Generic(String nombre, String path,int tipo)
    {
        this.nombre=nombre;
        this.icono_path=path;
        this.tipo=tipo;
    }
    
}
