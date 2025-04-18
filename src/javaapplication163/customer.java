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

public class customer extends javax.swing.JFrame {

    /**
     * Creates new form customer
     */
    public customer() {
        initComponents();
        this.setLocationRelativeTo(null); 
        this.setTitle("Perpustakaan");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        loadTableData();
    }

private void loadTableData() {
    Connection connection = DatabaseConnection.getConnection();
    if (connection != null) {
        try {
            // Query untuk mengambil data dari tabel customer
            String query = "SELECT ID_CUSTOMER, NAMA_CUSTOMER, EMAIL, NOMOR_TELEPON, PASSWORD, JUMLAH_BUKU_DIBELI FROM customer";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Mendapatkan metadata untuk membuat kolom tabel
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Membuat model tabel dan mengosongkan data lama
            DefaultTableModel tableModel = (DefaultTableModel) customer.getModel();
            tableModel.setRowCount(0); // Menghapus data lama dari model tabel

            // Menambahkan kolom hanya jika belum ada kolom di tabel
            if (tableModel.getColumnCount() == 0) {
                for (int i = 1; i <= columnCount; i++) {
                    tableModel.addColumn(metaData.getColumnName(i)); // Menambahkan kolom
                }
            }

            // Menambahkan data baris ke tabel
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(rowData);
            }

            // Tutup resource
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mengambil data!");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Koneksi ke database gagal!");
    }
}

private void searchCustomer(String namaCustomer) {
    // Mendapatkan koneksi ke database
    Connection connection = DatabaseConnection.getConnection();
    
    if (connection != null) {
        String query = "SELECT * FROM customer WHERE NAMA_CUSTOMER LIKE ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, "%" + namaCustomer + "%"); // Pencarian yang tidak case-sensitive
            
            ResultSet rs = stmt.executeQuery();
            
            // Setup model untuk JTable
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Customer");
            model.addColumn("Nama Customer");
            model.addColumn("Email");
            model.addColumn("PASSWORD");
            model.addColumn("Nomor Telepon");
            model.addColumn("Jumlah Buku Dibeli");
            
            // Memasukkan data dari ResultSet ke dalam model JTable
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("ID_CUSTOMER"),
                    rs.getString("NAMA_CUSTOMER"),
                    rs.getString("EMAIL"),
                    rs.getString("PASSWORD"),
                    rs.getString("NOMOR_TELEPON"),
                    rs.getInt("JUMLAH_BUKU_DIBELI")
                });
            }
            
            // Set model tabel ke JTable
            carinama.setModel(model);
            
            // Menutup koneksi
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error executing query.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Database connection failed.");
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        customer = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        email1 = new javax.swing.JTextField();
        jumlah = new javax.swing.JTextField();
        nomor = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        carinama = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        customer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID_CUSTOMER", "NAMA_CUSTOMER", "EMAIL", "NOMOR_TELEPON", "PASSWORD", "JUMLAH_BUKU_DIBELI"
            }
        ));
        customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(customer);

        jLabel1.setText("Customer");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama_Customer");

        jLabel3.setText("Email");

        jLabel5.setText("Nomor_Telepon");

        jLabel6.setText("Password");

        jLabel7.setText("Jumlah_Buku_Dibeli");

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        jButton2.setText("Create");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        carinama.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID_CUSTOMER", "NAMA_CUSTOMER", "EMAIL", "NOMOR_TELEPON", "PASSWORD", "JUMLAH_BUKU_DIBELI"
            }
        ));
        carinama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carinamaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(carinama);

        jButton3.setText("Cari Nama Customer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(99, 99, 99)
                                        .addComponent(jButton2)
                                        .addGap(94, 94, 94))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(email1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(nomor, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(18, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nomor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(email1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      tablekoneksi bukuFrame = new tablekoneksi();
      bukuFrame.setVisible(true);
      this.setVisible(false);  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                                        
    // TODO add your handling code here:
    Connection connection = DatabaseConnection.getConnection();
    if (connection != null) {
        try {
            String sql = "INSERT INTO customer (NAMA_CUSTOMER, EMAIL, NOMOR_TELEPON, PASSWORD, JUMLAH_BUKU_DIBELI) " +
                         "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Set nilai untuk kolom lain (kolom ID_CUSTOMER akan diisi otomatis oleh trigger)
            preparedStatement.setString(1, nama.getText()); // Mengambil data dari form
            preparedStatement.setString(2, email1.getText()); 
            preparedStatement.setLong(3, Long.parseLong(nomor.getText()));
            preparedStatement.setString(4, pass.getText());
            preparedStatement.setInt(5, Integer.parseInt(jumlah.getText()));

            // Menjalankan query insert
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!");
                loadTableData();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal ditambahkan!");
            }

            // Menutup koneksi
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data!");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Koneksi ke database gagal!");
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerMouseClicked
                                 
    // Mendapatkan baris yang diklik
    int row = customer.getSelectedRow();
    
    // Jika baris valid (tidak kosong)
    if (row != -1) {
        // Mengambil data dari tabel
        String idCustomer = customer.getValueAt(row, 0).toString(); // ID_CUSTOMER (kolom pertama)
        String namaCustomer = customer.getValueAt(row, 1).toString(); // NAMA_CUSTOMER (kolom kedua)
        String email = customer.getValueAt(row, 2).toString(); // EMAIL (kolom ketiga)
        String nomorTelepon = customer.getValueAt(row, 3).toString(); // NOMOR_TELEPON (kolom keempat)
        String password = customer.getValueAt(row, 4).toString(); // PASSWORD (kolom kelima)
        String jumlahBukuDibeli = customer.getValueAt(row, 5).toString(); // JUMLAH_BUKU_DIBELI (kolom keenam)
        
        // Menampilkan data pada JTextField yang sesuai
        id.setText(idCustomer); // Pastikan Anda memiliki JTextField untuk ID (meskipun ini otomatis)
        nama.setText(namaCustomer); // Untuk Nama Customer
        email1.setText(email); // Untuk Email
        nomor.setText(nomorTelepon); // Untuk Nomor Telepon
        pass.setText(password); // Untuk Password
        jumlah.setText(jumlahBukuDibeli); // Untuk Jumlah Buku Dibeli
    }


    }//GEN-LAST:event_customerMouseClicked

    private void carinamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carinamaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_carinamaMouseClicked

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                                       
    // Mengambil nama customer dari JTextField
    String namaCustomer = id.getText().trim();
    
    // Pastikan nama customer tidak kosong
    if (!namaCustomer.isEmpty()) {
        // Cari customer berdasarkan nama
        searchCustomer(namaCustomer);
    } else {
        
        JOptionPane.showMessageDialog(null, "Masukkan Nama dari Customer");
    }

    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new customer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable carinama;
    private javax.swing.JTable customer;
    private javax.swing.JTextField email1;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nomor;
    private javax.swing.JTextField pass;
    // End of variables declaration//GEN-END:variables
}
