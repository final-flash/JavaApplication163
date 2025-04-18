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

/**
 *
 * @author GLEN
 */
public class Metode_Pembayaran extends javax.swing.JFrame {



    public Metode_Pembayaran() {
        initComponents();
        this.setLocationRelativeTo(null); 
        this.setTitle("Perpustakaan");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
// Method untuk mencari metode pembayaran berdasarkan ID
 public void searchPaymentMethod(String id) {
        String query = "{ call cari_metode_pembayaran(?, ?) }"; // Memanggil prosedur dengan ID dan SYS_REFCURSOR

        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall(query)) {

            // Set parameter input (ID)
            stmt.setString(1, id);
            
            // Register parameter output (cursor)
            stmt.registerOutParameter(2, OracleTypes.CURSOR);

            // Eksekusi prosedur
            stmt.execute();

            // Ambil cursor hasil query
            ResultSet rs = (ResultSet) stmt.getObject(2);

            // Clear tabel sebelumnya
            DefaultTableModel tableModel = (DefaultTableModel) metode_pembayaran.getModel();
            tableModel.setRowCount(0); // Menghapus baris tabel sebelumnya

            // Proses hasil cursor dan tampilkan di tabel
            while (rs.next()) {
                String idMetodePembayaran = rs.getString("ID_METODE_PEMBAYARAN");
                String namaMetodePembayaran = rs.getString("NAMA_METODE_PEMBAYARAN");
                String used = rs.getString("USED");
                
                // Menambah baris baru ke dalam tabel
                tableModel.addRow(new Object[]{idMetodePembayaran, namaMetodePembayaran, used});
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error executing procedure.");
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        metode_pembayaran = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        cari = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jumlah = new javax.swing.JScrollPane();
        hitungsemua = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Metode Pembayaran");

        metode_pembayaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID_Metode_Pembayaran", "Nama_Metode_Pembayaran", "Used"
            }
        ));
        jScrollPane1.setViewportView(metode_pembayaran);

        jButton2.setText("Cari");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        jButton3.setText("Hitung Jumlah Metode Pembayaran Yang Digunakan");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        hitungsemua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Jumlah Metode Pembayaran Yang Digunakan"
            }
        ));
        jumlah.setViewportView(hitungsemua);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jumlah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                                         
    // Ambil ID dari jTextField
    String id = cari.getText().trim(); // Misalnya jTextField1 adalah tempat untuk input ID

    // Cek apakah ID kosong
    if (id.isEmpty()) {
        JOptionPane.showMessageDialog(this, "ID tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Panggil metode untuk mencari data berdasarkan ID
    searchPaymentMethod(id);

            // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                                    
    Connection connection = null;
    CallableStatement stmt = null;

    try {
        // Mendapatkan koneksi dari DatabaseConnection
        connection = DatabaseConnection.getConnection();

        if (connection == null) {
            JOptionPane.showMessageDialog(this, "Koneksi ke database gagal!", 
                                          "Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Menyiapkan pemanggilan prosedur
        String sql = "{CALL hitung_total_used(?)}";
        stmt = connection.prepareCall(sql);

        // Mendaftarkan parameter output
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);

        // Menjalankan prosedur
        stmt.execute();

        // Mendapatkan hasil dari parameter output
        int totalUsed = stmt.getInt(1);

        // Menampilkan hasil perhitungan di JTable
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Jumlah Metode Pembayaran Yang Digunakan");  // Menambahkan header kolom hanya untuk Total Used

        // Menambahkan data ke JTable, hanya satu kolom Total Used
        model.addRow(new Object[] {totalUsed});

        // Set model ke JTable
        hitungsemua.setModel(model);

        JOptionPane.showMessageDialog(this, "Total semua nilai USED: " + totalUsed, 
                                      "Informasi", JOptionPane.INFORMATION_MESSAGE);

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), 
                                      "Kesalahan", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      tablekoneksi bukuFrame = new tablekoneksi();
      bukuFrame.setVisible(true);
      this.setVisible(false);         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Metode_Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Metode_Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Metode_Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Metode_Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Metode_Pembayaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JTable hitungsemua;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jumlah;
    private javax.swing.JTable metode_pembayaran;
    // End of variables declaration//GEN-END:variables
}
