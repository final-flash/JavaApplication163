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
import oracle.jdbc.OracleTypes;

public class kategori extends javax.swing.JFrame {

  
    
    
    public kategori() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Perpustakaan");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadData();
    }

private void loadData() {
    Connection conn = DatabaseConnection.getConnection();
    
    if (conn != null) {
        String query = "SELECT ID_KATEGORI, NAMA_KATEGORI FROM kategori";  // Query untuk mengambil data kategori
        
        try (Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery(query)) {
            
            // Ambil model JTable untuk menampilkan data
            DefaultTableModel model = (DefaultTableModel) kat.getModel();
            model.setRowCount(0);  // Kosongkan data sebelumnya
            
            // Menambahkan data dari ResultSet ke JTable
            while (rs.next()) {
                String idKategori = rs.getString("ID_KATEGORI");
                String namaKategori = rs.getString("NAMA_KATEGORI");
                
                // Menambahkan baris baru dengan data yang diambil
                model.addRow(new Object[]{idKategori, namaKategori});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memuat data: " + e.getMessage());
            e.printStackTrace();
        }
    } else {
        JOptionPane.showMessageDialog(this, "Koneksi ke database gagal.");
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        kategori = new javax.swing.JScrollPane();
        kat = new javax.swing.JTable();
        nama = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        kategori1 = new javax.swing.JScrollPane();
        jumlahk = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Kategori");

        kat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id_Kategori", "Nama_Kategori"
            }
        ));
        kategori.setViewportView(kat);
        if (kat.getColumnModel().getColumnCount() > 0) {
            kat.getColumnModel().getColumn(0).setHeaderValue("Jumlah Seluruh Kategori");
            kat.getColumnModel().getColumn(1).setHeaderValue("Nama_Kategori");
        }

        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });

        jLabel4.setText("ID_Kategori");

        jLabel5.setText("Nama_Kategori");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jumlahk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Jumlah Kategori"
            }
        ));
        kategori1.setViewportView(jumlahk);

        jButton2.setText("Cari Jumlah Kategori");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Create");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1)))
                                .addGap(27, 27, 27))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(Delete))))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kategori, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                    .addComponent(kategori1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jButton1))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kategori1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tablekoneksi bukuFrame = new tablekoneksi();
        bukuFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                                      
    // Koneksi ke database
    Connection conn = DatabaseConnection.getConnection();
    if (conn != null) {
        String query = "{? = call hitung_jumlah_kategori}"; // Sintaks untuk function
        try (CallableStatement stmt = conn.prepareCall(query)) {
            // Mendaftarkan parameter keluaran
            stmt.registerOutParameter(1, java.sql.Types.NUMERIC);
            
            // Eksekusi function
            stmt.execute();
            
            // Ambil hasilnya
            int totalCategories = stmt.getInt(1);
            
            // Debug log untuk memastikan nilai
            System.out.println("Jumlah Kategori: " + totalCategories);
            
            // Update JTable
            DefaultTableModel model = (DefaultTableModel) jumlahk.getModel();
            
            // Pastikan tabel memiliki 1 kolom
            if (model.getColumnCount() == 0) {
                model.addColumn("Jumlah Kategori");
            }
            
            model.setRowCount(0); // Bersihkan data sebelumnya
            model.addRow(new Object[]{totalCategories}); // Tambahkan hanya angka
            
            // Pesan sukses
            JOptionPane.showMessageDialog(this, "Function berhasil dijalankan. Jumlah kategori: " + totalCategories);
        } catch (SQLException e) {
            // Tangani error jika terjadi kesalahan
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memanggil function: " + e.getMessage());
            e.printStackTrace();
        }
    } else {
        // Menangani kesalahan koneksi
        JOptionPane.showMessageDialog(this, "Koneksi ke database gagal.");
    }



    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                                         
    // Koneksi ke database
    Connection conn = DatabaseConnection.getConnection();
    if (conn != null) {
        String query = "INSERT INTO kategori (ID_KATEGORI, NAMA_KATEGORI) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            // Set nilai parameter untuk insert
            stmt.setString(1, id.getText()); // Ambil nilai dari JTextField
            stmt.setString(2, nama.getText()); // Ambil nilai dari JTextField
            
            // Eksekusi query untuk insert
            stmt.executeUpdate();
            
            // Pesan sukses
            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan.");
            loadData();
        } catch (SQLException e) {
            // Tangani kesalahan yang muncul dari trigger
            String errorMessage = e.getMessage();
            
            // Cek jika error berasal dari trigger
            if (errorMessage.contains("ID Kategori dan Nama Kategori tidak boleh kosong")) {
                System.out.println("Pesan dari Trigger: " + errorMessage);
                JOptionPane.showMessageDialog(this, "Error: " + errorMessage);
            } else {
                // Tangani kesalahan lainnya
                System.out.println("Terjadi kesalahan: " + errorMessage);
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data: " + errorMessage);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Koneksi ke database gagal.");
    }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed

    // Mengambil input ID dan Nama kategori dari JTextField
    String idKategoriToDelete = id.getText();
    String namaKategoriToDelete = nama.getText();

    if (idKategoriToDelete.isEmpty() || namaKategoriToDelete.isEmpty()) {
        JOptionPane.showMessageDialog(this, "ID dan Nama kategori tidak boleh kosong.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Proses penghapusan data
    try (Connection conn = DatabaseConnection.getConnection()) {
        // Query untuk menghapus data berdasarkan ID dan Nama
        String sqlDelete = "DELETE FROM kategori WHERE ID_KATEGORI = ? AND NAMA_KATEGORI = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sqlDelete)) {
            stmt.setString(1, idKategoriToDelete);  // Menetapkan ID kategori yang akan dihapus
            stmt.setString(2, namaKategoriToDelete);  // Menetapkan Nama kategori yang akan dihapus
            int rowsAffected = stmt.executeUpdate();  // Eksekusi query DELETE
            loadData();
            if (rowsAffected > 0) {
                // Jika data berhasil dihapus, tampilkan pesan konfirmasi
                JOptionPane.showMessageDialog(this, "Data dengan ID_KATEGORI " + idKategoriToDelete + " dan Nama " + namaKategoriToDelete + " telah dihapus.", "Penghapusan Berhasil", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Jika tidak ada data yang dihapus
                JOptionPane.showMessageDialog(this, "Data dengan ID_KATEGORI " + idKategoriToDelete + " dan Nama " + namaKategoriToDelete + " tidak ditemukan.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        }

    } catch (SQLException e) {
        // Menangani kesalahan SQL
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus data.", "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }

   

    }//GEN-LAST:event_DeleteActionPerformed

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaActionPerformed

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
            java.util.logging.Logger.getLogger(kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kategori().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTable jumlahk;
    private javax.swing.JTable kat;
    private javax.swing.JScrollPane kategori;
    private javax.swing.JScrollPane kategori1;
    private javax.swing.JTextField nama;
    // End of variables declaration//GEN-END:variables
}
