/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Random;
import javax.swing.JOptionPane;
import modelo.CleaningArticle;
import modelo.User;

/**
 *
 * @author Usuario
 */
public class VtnAdministrador extends javax.swing.JFrame {

    private int adminCode;
    private boolean isEditing;
    private CleaningArticle article, articleToDelete;
    private User admin;
    private Alert alert;
    private DeleteArticle deleteModal;
    
    /**
     * Creates new form VtnAdministrador
     */
    public VtnAdministrador() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.adminCode = 0;
        this.isEditing = false;
    }
    
    public VtnAdministrador(int adminCode) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.adminCode = adminCode;
        this.isEditing = false;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        lblAdmin = new javax.swing.JLabel();
        lblInventarios = new javax.swing.JLabel();
        JTPinventario = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        filterArticles = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        articleToDeleteTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        searchButtonDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        codeTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        articleNameTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        articleCodeTextField = new javax.swing.JTextField();
        searchButtonAddOrEdit = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMINISTRADOR");

        jPanel4.setBackground(new java.awt.Color(240, 204, 252));

        lblAdmin.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdmin.setText("ADMINISTRADOR");

        lblInventarios.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        lblInventarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInventarios.setText("Inventarios");

        JTPinventario.setBackground(new java.awt.Color(240, 168, 247));
        JTPinventario.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(240, 168, 247));

        filterArticles.setBackground(new java.awt.Color(255, 210, 252));
        filterArticles.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        filterArticles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Ocupado", "Disponible" }));
        filterArticles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterArticlesActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(255, 153, 255));
        jTable1.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Estatus"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(249, 169, 242));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filterArticles, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(filterArticles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addContainerGap())
        );

        JTPinventario.addTab("General", jPanel1);

        jPanel3.setBackground(new java.awt.Color(240, 168, 247));

        articleToDeleteTextField.setBackground(new java.awt.Color(255, 211, 244));
        articleToDeleteTextField.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        jLabel6.setText("Buscar por código para eliminar:");

        searchButtonDelete.setBackground(new java.awt.Color(240, 179, 242));
        searchButtonDelete.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        searchButtonDelete.setText("Buscar");
        searchButtonDelete.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchButtonDelete.setBorderPainted(false);
        searchButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(articleToDeleteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButtonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(articleToDeleteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButtonDelete))
                .addContainerGap(189, Short.MAX_VALUE))
        );

        JTPinventario.addTab("Quitar", jPanel3);

        jPanel2.setBackground(new java.awt.Color(240, 168, 247));

        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        jLabel3.setText("Código:");

        codeTextField.setBackground(new java.awt.Color(255, 211, 244));
        codeTextField.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        jLabel4.setText("Nombre:");

        articleNameTextField.setBackground(new java.awt.Color(255, 211, 244));
        articleNameTextField.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        jLabel5.setText("Buscar para editar:");

        articleCodeTextField.setBackground(new java.awt.Color(255, 211, 244));
        articleCodeTextField.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 12)); // NOI18N

        searchButtonAddOrEdit.setBackground(new java.awt.Color(240, 179, 242));
        searchButtonAddOrEdit.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        searchButtonAddOrEdit.setText("Buscar");
        searchButtonAddOrEdit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchButtonAddOrEdit.setBorderPainted(false);
        searchButtonAddOrEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonAddOrEditActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 269, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(articleCodeTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                                .addComponent(codeTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(articleNameTextField)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchButtonAddOrEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButtonAddOrEdit))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(articleCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(articleNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        codeTextField.getAccessibleContext().setAccessibleName("");

        JTPinventario.addTab("Agregar/editar", jPanel2);

        btnRegresar.setBackground(new java.awt.Color(240, 179, 242));
        btnRegresar.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegresar.setBorderPainted(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAdmin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblInventarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(JTPinventario)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInventarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTPinventario, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnRegresar)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonDeleteActionPerformed
        this.articleToDelete = new CleaningArticle();
        this.articleToDelete.consultFromTable(Integer.parseInt(this.articleToDeleteTextField.getText()));
        if(this.articleToDelete.getCode() != 0) {
            this.deleteModal = new DeleteArticle(this, "¿Esta seguro que desea eliminar el articulo '" + this.articleToDelete.getName() + "' con el codigo " + this.articleToDelete.getCode() + "?");
            this.deleteModal.setVisible(true);
        }
        else {
            this.alert = new Alert("Articulo no encontrado");
            this.alert.setVisible(true);
        }
    }//GEN-LAST:event_searchButtonDeleteActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        VtnPrincipal main = new VtnPrincipal();
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void searchButtonAddOrEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonAddOrEditActionPerformed
        this.article = new CleaningArticle();
        this.article.consultFromTable(Integer.parseInt(this.codeTextField.getText()));
        this.isEditing = true;
        this.articleCodeTextField.setText(String.valueOf(this.article.getCode()));
        this.articleNameTextField.setText(this.article.getName());
    }//GEN-LAST:event_searchButtonAddOrEditActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(this.isEditing) this.UpdateArticle();
        else this.CreateArticle();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void filterArticlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterArticlesActionPerformed
        String selectedFilter = this.filterArticles.getSelectedItem().toString().toLowerCase();
        System.out.println(selectedFilter);
        
        switch (selectedFilter) {
            case "todos":
                break;
            case "ocupado":
                break;
            case "disponible":
                break;
            default:
        }
    }//GEN-LAST:event_filterArticlesActionPerformed

    private void CreateArticle() {
        this.article = new CleaningArticle(Integer.parseInt(this.articleCodeTextField.getText()), this.articleNameTextField.getText());
        if(this.article.insertInTable()) {
            this.alert = new Alert("Articulo agregado correctamente");
        }
        else {
            this.alert = new Alert("Error al agregar el articulo");
        }
        this.alert.setVisible(true);
        this.CleanTextFields();
    }
    
    private void UpdateArticle() {
    }
    
    public void DeleteArticle() {
        if(this.articleToDelete.DeleteFromTable()) {
            this.alert = new Alert("Articulo eliminado");
            this.articleToDeleteTextField.setText("");
        }
        else this.alert = new Alert("Error al eliminar articulo");
        this.alert.setVisible(true);
    }
    
    private void CleanTextFields() {
        this.codeTextField.setText("");
        this.articleCodeTextField.setText("");
        this.articleNameTextField.setText("");
    }
    
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
            java.util.logging.Logger.getLogger(VtnAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VtnAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VtnAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTPinventario;
    private javax.swing.JTextField articleCodeTextField;
    private javax.swing.JTextField articleNameTextField;
    private javax.swing.JTextField articleToDeleteTextField;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JTextField codeTextField;
    private javax.swing.JComboBox<String> filterArticles;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblInventarios;
    private javax.swing.JButton searchButtonAddOrEdit;
    private javax.swing.JButton searchButtonDelete;
    // End of variables declaration//GEN-END:variables
}
