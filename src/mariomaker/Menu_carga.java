/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariomaker;

/**
 *
 * @author Erick
 */
public class Menu_carga extends javax.swing.JFrame {

    /**
     * Creates new form Menu_inicio
     */
    public Menu_carga() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_nombre_objeto = new javax.swing.JTextField();
        txt_path_imagen = new javax.swing.JTextField();
        boton_path_imagen = new javax.swing.JButton();
        boton_agregar_objeto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mario Maker Guatemalteco v.1.0.0");
        getContentPane().setLayout(null);

        jLabel1.setText("Meú de Carga de Objetos");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(112, 11, 260, 40);

        jLabel2.setText("Imagen");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 110, 70, 30);

        jLabel3.setText("Nombre ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 60, 70, 30);
        getContentPane().add(txt_nombre_objeto);
        txt_nombre_objeto.setBounds(90, 60, 190, 30);
        getContentPane().add(txt_path_imagen);
        txt_path_imagen.setBounds(90, 110, 190, 30);

        boton_path_imagen.setText("Elegir");
        getContentPane().add(boton_path_imagen);
        boton_path_imagen.setBounds(280, 110, 130, 30);

        boton_agregar_objeto.setText("Agregar");
        getContentPane().add(boton_agregar_objeto);
        boton_agregar_objeto.setBounds(90, 150, 140, 30);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 200, 570, 260);

        setBounds(0, 0, 648, 611);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu_carga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_carga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_carga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_carga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_carga().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_agregar_objeto;
    private javax.swing.JButton boton_path_imagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_nombre_objeto;
    private javax.swing.JTextField txt_path_imagen;
    // End of variables declaration//GEN-END:variables
}
