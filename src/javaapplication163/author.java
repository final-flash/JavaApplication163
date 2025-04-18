/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication163;

import java.awt.*; // Untuk elemen GUI dan layout
import java.awt.event.*; // Untuk event handling seperti ActionListener
import java.sql.*; // Untuk koneksi database dan SQL statement
import javax.swing.*; // Untuk komponen Swing seperti JFrame, JButton, JTable, dll.
import javax.swing.table.*; // Untuk model tabel seperti DefaultTableModel

public class author extends javax.swing.JFrame {
private DefaultTableModel tableModel; //
    /**
     * Creates new form author
     */
    public author() {
        initComponents();
        tableModel = new DefaultTableModel(new Object[]{"ID_AUTHOR", "NAMA"}, 0);
         author.setModel(tableModel); // Hubungkan model ke JTable
        this.setLocationRelativeTo(null); 
        this.setTitle("Perpustakaan");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        loadAuthors();
    }
    
private void loadAuthors() {
    tableModel.setRowCount(0); // Hapus semua data di tabel

    try (Connection conn = DatabaseConnection.getConnection()) {
        String sql = "SELECT * FROM author";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            String idAuthor = rs.getString("id_author");
            String nama = rs.getString("nama");
            tableModel.addRow(new Object[]{idAuthor, nama}); // Tambahkan data ke tabel
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Gagal memuat data!", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NAMA = new javax.swing.JTextField();
        ID_AUTHOR = new javax.swing.JTextField();
        AUTHOR = new javax.swing.JScrollPane();
        author = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("ID_AUTHOR");

        jLabel3.setText("NAMA");

        NAMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NAMAActionPerformed(evt);
            }
        });

        ID_AUTHOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_AUTHORActionPerformed(evt);
            }
        });

        author.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID_AUTHOR", "NAMA"
            }
        ));
        author.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                authorMouseClicked(evt);
            }
        });
        AUTHOR.setViewportView(author);

        jLabel4.setText("AUTHOR");

        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Cancel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Update");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Delete");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ID_AUTHOR, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addComponent(jButton4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NAMA, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AUTHOR, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(21, 21, 21)
                                .addComponent(jButton6)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5)
                                .addGap(12, 12, 12)
                                .addComponent(jButton7)))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ID_AUTHOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(NAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton6)
                    .addComponent(jButton5)
                    .addComponent(jButton7))
                .addGap(18, 18, 18)
                .addComponent(AUTHOR, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NAMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NAMAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NAMAActionPerformed

    private void ID_AUTHORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_AUTHORActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_AUTHORActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                                      
    // Ambil input dari text field
String idAuthor = ID_AUTHOR.getText(); // txtIdAuthor adalah JTextField untuk ID_AUTHOR
String nama = NAMA.getText();         // txtNama adalah JTextField untuk NAMA



try (Connection conn = DatabaseConnection.getConnection()) {
    // SQL untuk memanggil stored procedure
    String sql = "{CALL sp_insert_author(?, ?)}"; 
    CallableStatement stmt = conn.prepareCall(sql);

    // Set parameter input untuk stored procedure
    stmt.setString(1, idAuthor);
    stmt.setString(2, nama);

    // Eksekusi stored procedure
    stmt.execute();
    JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);

    // Refresh tabel untuk menampilkan data terbaru
    loadAuthors();

    // Kosongkan field setelah insert
    ID_AUTHOR.setText("");
    NAMA.setText("");
} catch (SQLException e) {
    // Tangkap pesan error dari Oracle
    String oracleMessage = e.getMessage();

    // Tampilkan pesan error Oracle ke dalam dialog
    JOptionPane.showMessageDialog(this, "Gagal menambahkan data!\n" + oracleMessage, "Error", JOptionPane.ERROR_MESSAGE);

    e.printStackTrace();
}
  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      tablekoneksi bukuFrame = new tablekoneksi();
      bukuFrame.setVisible(true);
      this.setVisible(false);  
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      ID_AUTHOR.setText("");          
      NAMA.setText("");   
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
                                      
   
    String idAuthor = ID_AUTHOR.getText(); 
    String namaBaru = NAMA.getText();     

    if (idAuthor.isEmpty() || namaBaru.isEmpty()) {
        JOptionPane.showMessageDialog(this, "ID Author dan Nama tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try (Connection conn = DatabaseConnection.getConnection()) {
        String sql = "{CALL update_author_name(?, ?)}"; // Panggil procedure

        try (CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setString(1, idAuthor); 
            cstmt.setString(2, namaBaru); 

            cstmt.execute();
            JOptionPane.showMessageDialog(this, "Data berhasil diperbarui!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            loadAuthors(); // Refresh tabel setelah update
        }
    } catch (SQLException e) {
        e.printStackTrace();
        if (e.getMessage().contains("ID Author tidak ditemukan")) {
            JOptionPane.showMessageDialog(this, "ID Author tidak ditemukan!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Gagal memperbarui data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
 String idAuthor = ID_AUTHOR.getText();

    if (idAuthor.isEmpty()) {
        JOptionPane.showMessageDialog(this, "ID_AUTHOR tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Panggil prosedur di database
    try (Connection conn = DatabaseConnection.getConnection()) {
        String sql = "{call delete_author(?)}"; // Panggil prosedur delete_author
        CallableStatement stmt = conn.prepareCall(sql);
        stmt.setString(1, idAuthor); // Kirim parameter ke prosedur
        stmt.execute();
        stmt.close();

        JOptionPane.showMessageDialog(this, "Data berhasil dihapus.", "Informasi", JOptionPane.INFORMATION_MESSAGE);

        // Refresh tabel setelah penghapusan
        loadAuthors(); // Memanggil metode untuk memuat ulang data di tabel
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Gagal menghapus data!", "Error", JOptionPane.ERROR_MESSAGE);
    }

   



    }//GEN-LAST:event_jButton7ActionPerformed

    private void authorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_authorMouseClicked
                                  
    int selectedRow = author.getSelectedRow(); // Ambil baris yang diklik

    if (selectedRow != -1) { // Pastikan ada baris yang dipilih
        String idAuthor = tableModel.getValueAt(selectedRow, 0).toString(); // Ambil ID_AUTHOR dari kolom pertama
        String nama = tableModel.getValueAt(selectedRow, 1).toString(); // Ambil Nama dari kolom kedua

        ID_AUTHOR.setText(idAuthor); // Tampilkan ID_AUTHOR ke JTextField
        NAMA.setText(nama); // Tampilkan Nama ke JTextField
    } else {
        JOptionPane.showMessageDialog(this, "Tidak ada baris yang dipilih!", "Peringatan", JOptionPane.WARNING_MESSAGE);
    }


    }//GEN-LAST:event_authorMouseClicked

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
            java.util.logging.Logger.getLogger(author.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(author.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(author.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(author.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new author().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane AUTHOR;
    private javax.swing.JTextField ID_AUTHOR;
    private javax.swing.JTextField NAMA;
    private javax.swing.JTable author;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
