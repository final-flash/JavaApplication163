/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication163;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class publisher extends javax.swing.JFrame {

    /**
     * Creates new form publisher
     */
    public publisher() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Perpustakaan");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadData();
    }

private void loadData() {
    // Membuka koneksi ke database
    Connection conn = DatabaseConnection.getConnection();
    
    // Cek apakah koneksi berhasil
    if (conn != null) {
        // Query SQL untuk mengambil data publisher
        String query = "SELECT ID_PUBLISHER, NAMA_PUBLISHER, ID_BUKU FROM publisher";
        
        try (Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery(query)) {
            
            // Mendapatkan model JTable yang sudah ada (publisherTable adalah nama JTable)
            DefaultTableModel model = (DefaultTableModel) publis.getModel();
            model.setRowCount(0);  // Mengosongkan data lama sebelum menambah data baru
            
            // Jika ResultSet kosong (tidak ada data di tabel publisher)
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Data publisher tidak ditemukan.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Mengambil data dari ResultSet dan menambahkannya ke JTable
                do {
                    String idPublisher = rs.getString("ID_PUBLISHER");
                    String namaPublisher = rs.getString("NAMA_PUBLISHER");
                    String idBuku = rs.getString("ID_BUKU");
                    
                    // Menambahkan data ke dalam JTable
                    model.addRow(new Object[]{idPublisher, namaPublisher, idBuku});
                } while (rs.next());
            }
        } catch (SQLException e) {
            // Menampilkan pesan error jika terjadi SQLException
            JOptionPane.showMessageDialog(this, 
                "Terjadi kesalahan saat memuat data dari database: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Untuk debug
        }
    } else {
        // Menampilkan pesan jika koneksi gagal
        JOptionPane.showMessageDialog(this, "Koneksi ke database gagal. Periksa koneksi Anda.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        publis = new javax.swing.JTable();
        Back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        s = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        publis1 = new javax.swing.JTable();
        s1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        publis2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        publis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id_Publisher", "Nama_Publisher", "Id_Buku"
            }
        ));
        jScrollPane1.setViewportView(publis);
        if (publis.getColumnModel().getColumnCount() > 0) {
            publis.getColumnModel().getColumn(1).setHeaderValue("Nama_Publisher");
            publis.getColumnModel().getColumn(2).setHeaderValue("Id_Buku");
        }

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jLabel1.setText("Publisher");

        s.setText("Cari Nama_Publisher");
        s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sActionPerformed(evt);
            }
        });

        publis1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id_Publisher", "Nama_Publisher", "Id_Buku"
            }
        ));
        jScrollPane2.setViewportView(publis1);
        if (publis1.getColumnModel().getColumnCount() > 0) {
            publis1.getColumnModel().getColumn(1).setHeaderValue("Nama_Publisher");
            publis1.getColumnModel().getColumn(2).setHeaderValue("Id_Buku");
        }

        s1.setText("Cari Jumlah Publisher");
        s1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1ActionPerformed(evt);
            }
        });

        publis2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Jumlah Publisher"
            }
        ));
        jScrollPane3.setViewportView(publis2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Back))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(s)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(s1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(Back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(s1)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
      tablekoneksi bukuFrame = new tablekoneksi();
        bukuFrame.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_BackActionPerformed

    private void sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sActionPerformed
                                
    // Ambil Nama Publisher dari JTextField atau komponen lain
    String namaPublisher = id.getText();
    
    if (namaPublisher.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Masukkan Nama Publisher", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    Connection conn = DatabaseConnection.getConnection();
    
    if (conn != null) {
        try {
            // Menyiapkan callable statement untuk memanggil Function
            String query = "{? = call get_publisher_by_name(?)}"; // Pastikan Function ada
            CallableStatement stmt = conn.prepareCall(query);
            
            // Menetapkan parameter Function
            stmt.registerOutParameter(1, Types.VARCHAR);  // Output parameter untuk hasil pencarian
            stmt.setString(2, namaPublisher);  // Input parameter Nama Publisher
            
            // Menjalankan query
            stmt.execute();
            
            // Mendapatkan hasil dari output parameter
            String result = stmt.getString(1);
            
            // Jika hasil ditemukan
            if (result != null && !result.isEmpty()) {
                DefaultTableModel model = (DefaultTableModel) publis1.getModel(); // JTable Anda
                model.setRowCount(0); // Kosongkan isi tabel
                
                // Split hasil jika ada banyak data (misalnya formatnya dipisahkan oleh koma atau karakter lain)
                String[] rows = result.split(";"); // Misalkan hasil dipisahkan dengan ';'
                for (String row : rows) {
                    String[] columns = row.split(","); // Misalkan kolom dipisahkan dengan ','
                    model.addRow(columns); // Tambahkan ke JTable
                }
            } else {
                JOptionPane.showMessageDialog(this, "Publisher tidak ditemukan.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
            
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memanggil Function: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();  // Debugging
        }
    } else {
        JOptionPane.showMessageDialog(this, "Koneksi ke database gagal", "Error", JOptionPane.ERROR_MESSAGE);
    }


    }//GEN-LAST:event_sActionPerformed

    private void s1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1ActionPerformed
     
    Connection conn = DatabaseConnection.getConnection(); // Membuka koneksi ke database

if (conn != null) {
    try {
        // Menyiapkan callable statement untuk memanggil Procedure
        String query = "{call search_total_publishers(?)}"; // Procedure untuk mendapatkan jumlah publisher
        CallableStatement stmt = conn.prepareCall(query);
        
        // Register output parameter untuk jumlah publisher
        stmt.registerOutParameter(1, Types.INTEGER);
        
        // Menjalankan Procedure
        stmt.execute();
        
        // Mendapatkan hasil dari output parameter
        int totalPublishers = stmt.getInt(1);
        
        // Menampilkan hasil di JTable
        DefaultTableModel model = (DefaultTableModel) publis2.getModel(); // publis adalah nama JTable
        model.setRowCount(0); // Kosongkan tabel sebelum menambah data baru
        
        // Menambahkan jumlah publisher ke JTable
        model.addRow(new Object[]{totalPublishers}); // Baris baru di JTable
        
        stmt.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memanggil Procedure: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace(); // Debugging
    }
} else {
    JOptionPane.showMessageDialog(this, "Koneksi ke database gagal", "Error", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_s1ActionPerformed

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
            java.util.logging.Logger.getLogger(publisher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(publisher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(publisher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(publisher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new publisher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable publis;
    private javax.swing.JTable publis1;
    private javax.swing.JTable publis2;
    private javax.swing.JButton s;
    private javax.swing.JButton s1;
    // End of variables declaration//GEN-END:variables
}
