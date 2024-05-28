package com.mycompany.restaurantepp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class MainMenu2 extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu2
     */
    private Usuario usuario;
    
    public MainMenu2(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        customizeComponents();
    }

    MainMenu2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void customizeComponents() {
        setTitle("Menú Principal");
        setLocationRelativeTo(null);

        welcomeLabel.setText("Bienvenido, " + usuario.getUsername());

        if (!usuario.getRol().getNombre().equals("Administrador")) {
            btngestionarMesasButton.setVisible(false);
            btngestionarCategoriasButton.setVisible(false);
            btngestionarPlatosButton.setVisible(false);
            btngestionarUsuariosButton.setVisible(false);
            btngestionarInventarioButton.setVisible(false);
        }
    }

    private JButton createButton(String text, String iconPath) {
        JButton button = new JButton(text);
        URL iconURL = getClass().getResource(iconPath);
        if (iconURL != null) {
            button.setIcon(new ImageIcon(iconURL));
        }
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setPreferredSize(new Dimension(250, 60));
        button.setBackground(new Color(220, 220, 220));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(60, 63, 65)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        return button;
    }

    private void abrirFormularioGestionPedidos() {
        PedidoForm pedidoForm = new PedidoForm(this);
        pedidoForm.setVisible(true);
        setVisible(false); // Ocultar MainMenu2
    }

    private void abrirFormularioGestionMesas() {
        // Implementar lógica para abrir el formulario de gestión de mesas
        JOptionPane.showMessageDialog(this, "Abrir formulario de gestión de mesas");
    }

    private void abrirFormularioGestionCategorias() {
        // Implementar lógica para abrir el formulario de gestión de categorías
        JOptionPane.showMessageDialog(this, "Abrir formulario de gestión de categorías");
    }

    private void abrirFormularioGestionPlatos() {
        FormularioGestionPlatos formPlatos = new FormularioGestionPlatos(this);
        formPlatos.setVisible(true);
        setVisible(false); // Ocultar MainMenu2
    }

    private void abrirFormularioGestionUsuarios() {
        // Implementar lógica para abrir el formulario de gestión de usuarios
        
        //JOptionPane.showMessageDialog(this, "Abrir formulario de gestión de usuarios");
    }

    private void abrirFormularioGestionInventario() {
        // Implementar lógica para abrir el formulario de gestión de inventario
        //JOptionPane.showMessageDialog(this, "Abrir formulario de gestión de inventario");
    }

    /*// Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Rol rol = new Rol(1, "Administrador"); // Crear un rol de prueba
                Usuario usuario = new Usuario("admin", "admin", rol); // Crear un usuario de prueba
                MainMenu2 mainMenu2 = new MainMenu2(usuario);
                mainMenu2.setVisible(true);
            }
        });
    }
    */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        btngestionarPedidosButton = new javax.swing.JButton();
        btngestionarMesasButton = new javax.swing.JButton();
        btngestionarCategoriasButton = new javax.swing.JButton();
        btngestionarPlatosButton = new javax.swing.JButton();
        btngestionarUsuariosButton = new javax.swing.JButton();
        btngestionarInventarioButton = new javax.swing.JButton();
        salirButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal");

        welcomeLabel.setText("welcomeLabel");
        welcomeLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btngestionarPedidosButton.setText("Gestionar Pedidos");
        btngestionarPedidosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngestionarPedidosButtonActionPerformed(evt);
            }
        });

        btngestionarMesasButton.setText("Gestionar Mesas");
        btngestionarMesasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngestionarMesasButtonActionPerformed(evt);
            }
        });

        btngestionarCategoriasButton.setText("Gestionar Categorias");
        btngestionarCategoriasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngestionarCategoriasButtonActionPerformed(evt);
            }
        });

        btngestionarPlatosButton.setText("Gestionar Platos");
        btngestionarPlatosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngestionarPlatosButtonActionPerformed(evt);
            }
        });

        btngestionarUsuariosButton.setText("Gestionar Usuarios");
        btngestionarUsuariosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngestionarUsuariosButtonActionPerformed(evt);
            }
        });

        btngestionarInventarioButton.setText("Gestionar Inventario");
        btngestionarInventarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngestionarInventarioButtonActionPerformed(evt);
            }
        });

        salirButton.setText("Salir");
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btngestionarMesasButton)
                        .addGap(80, 80, 80)
                        .addComponent(btngestionarCategoriasButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btngestionarPlatosButton)
                        .addGap(81, 81, 81)
                        .addComponent(btngestionarUsuariosButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btngestionarInventarioButton)
                        .addGap(60, 60, 60)
                        .addComponent(salirButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(btngestionarPedidosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(welcomeLabel)
                .addGap(18, 18, 18)
                .addComponent(btngestionarPedidosButton)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btngestionarMesasButton)
                    .addComponent(btngestionarCategoriasButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btngestionarPlatosButton)
                    .addComponent(btngestionarUsuariosButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btngestionarInventarioButton)
                    .addComponent(salirButton))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btngestionarPedidosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngestionarPedidosButtonActionPerformed
        //abrirFormularioGestionPedidos(); 
        jfrmGestiondePedidos objGestionPedidos = new jfrmGestiondePedidos();
        objGestionPedidos.setVisible(true);
    }//GEN-LAST:event_btngestionarPedidosButtonActionPerformed

    private void btngestionarMesasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngestionarMesasButtonActionPerformed
        //abrirFormularioGestionMesas();
        jfrmGestionDeMesas objGestionMesas = new jfrmGestionDeMesas();
        objGestionMesas.setVisible(true);
    }//GEN-LAST:event_btngestionarMesasButtonActionPerformed

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        // Confirmar si el usuario realmente quiere salir
        int response = JOptionPane.showConfirmDialog(this, 
            "¿Está seguro de que desea salir?", "Confirmar salida", 
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (response == JOptionPane.YES_OPTION) {
            System.exit(0); // Salir de la aplicación
        }
    }//GEN-LAST:event_salirButtonActionPerformed

    private void btngestionarCategoriasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngestionarCategoriasButtonActionPerformed
        //abrirFormularioGestionCategorias();
        jfrmGestionDeCategorias objGestionCategorias = new jfrmGestionDeCategorias();
        objGestionCategorias.setVisible(true);
    }//GEN-LAST:event_btngestionarCategoriasButtonActionPerformed

    private void btngestionarPlatosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngestionarPlatosButtonActionPerformed
        //abrirFormularioGestionPlatos();
        jfrmGestionDePlatos objGestionPlatos = new jfrmGestionDePlatos();
        objGestionPlatos.setVisible(true);
        
    }//GEN-LAST:event_btngestionarPlatosButtonActionPerformed

    private void btngestionarUsuariosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngestionarUsuariosButtonActionPerformed
        // TODO add your handling code here:
    
        jfrmGestionDeUsuarios objGestionUsuarios = new jfrmGestionDeUsuarios();
        objGestionUsuarios.setVisible(true);
    }//GEN-LAST:event_btngestionarUsuariosButtonActionPerformed

    private void btngestionarInventarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngestionarInventarioButtonActionPerformed
        // TODO add your handling code here:
        jfrmGestionInventario objGestionInventario = new jfrmGestionInventario();
        objGestionInventario.setVisible(true);
    }//GEN-LAST:event_btngestionarInventarioButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Rol rol = new Rol(1, "Administrador"); // Crear un rol de prueba
                Usuario usuario = new Usuario("admin", "admin", rol); // Crear un usuario de prueba
                MainMenu2 mainMenu2 = new MainMenu2(usuario);
                mainMenu2.setVisible(true);
            }
        });
    }
    
    
    /*public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    /*    try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    /*    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu2().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btngestionarCategoriasButton;
    private javax.swing.JButton btngestionarInventarioButton;
    private javax.swing.JButton btngestionarMesasButton;
    private javax.swing.JButton btngestionarPedidosButton;
    private javax.swing.JButton btngestionarPlatosButton;
    private javax.swing.JButton btngestionarUsuariosButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton salirButton;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
