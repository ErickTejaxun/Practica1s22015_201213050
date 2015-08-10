/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import mariomaker.Menu_carga;

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
    public void click(java.awt.event.MouseEvent evt) {                                           
       JOptionPane.showMessageDialog(this, nombre);
       Menu_carga.nombre_objeto.setText(nombre);
    } 
    
//    private JLabel getLabelTitulo() {
//        if (labelTitulo == null) {
//         labelTitulo = new JLabel();
//         labelTitulo.setText("Soy una etiqueta clicable: ");
//         labelTitulo.addMouseListener(new MouseListener() {
//          public void mouseClicked(MouseEvent arg0) {
//           campoClickado.setText("La etiqueta ha sido clickeada");
//           areaTexto.setVisible(false);
//          }
//
//          public void mouseEntered(MouseEvent arg0) {
//           areaTexto.setText("El ratón se ha situado sobre la etiqueta");
//          }
//
//          public void mouseExited(MouseEvent arg0) {
//           areaTexto.setText(mensageAreaTexto);
//          }
//          public void mousePressed(MouseEvent arg0) {}
//          public void mouseReleased(MouseEvent arg0) {}
//         });
//        }
//        return labelTitulo;
//       }
    
}
