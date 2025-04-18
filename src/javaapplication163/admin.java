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
public class admin extends javax.swing.JFrame {

    /**
     * Creates new form admin
     */
    public admin() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Perpustakaan");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadTableData();
    }
private void searchAdmin(String namaAdmin) {
    // Memeriksa apakah nama admin valid
    if (namaAdmin == null || namaAdmin.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Nama admin tidak boleh kosong!");
        return; // Menghentikan eksekusi jika nama admin tidak valid
    }

    // Menambahkan wildcard untuk pencarian yang fleksibel


    // Mendapatkan koneksi ke database
    try (Connection connection = DatabaseConnection.getConnection()) {
        if (connection != null) {
            // Menyiapkan query pencarian
            String query = "SELECT ID_ADMIN, NAMA_ADMIN, EMAIL, PASSWORD, ID_SALES FROM admin WHERE NAMA_ADMIN LIKE ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, namaAdmin); // Mengatur parameter LIKE untuk pencarian berdasarkan nama admin

                // Menjalankan query
                try (ResultSet rs = stmt.executeQuery()) {
                    // Setup model untuk JTable
                    DefaultTableModel model = new DefaultTableModel();
                    model.addColumn("ID Admin");
                    model.addColumn("Nama Admin");
                    model.addColumn("Email");
                    model.addColumn("Password");
                    model.addColumn("ID Sales");

                    // Memasukkan data dari ResultSet ke dalam model JTable
                    while (rs.next()) {
                        model.addRow(new Object[] {
                            rs.getString("ID_ADMIN"),
                            rs.getString("NAMA_ADMIN"),
                            rs.getString("EMAIL"),
                            rs.getString("PASSWORD"),
                            rs.getString("ID_SALES")
                        });
                    }

                    // Set model tabel ke JTable
                    ADMIN1.setModel(model); // ganti adminTable dengan nama JTable Anda
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error reading data from result set.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error executing query.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Database connection failed.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Database connection error.");
    }
}

private void loadTableData() {
    Connection connection = DatabaseConnection.getConnection();
    if (connection != null) {
        try {
            String query = "SELECT ID_ADMIN, NAMA_ADMIN, EMAIL, PASSWORD, ID_SALES FROM admin";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Mendapatkan metadata untuk membuat kolom tabel
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Membuat model tabel dan mengosongkan data lama
            DefaultTableModel tableModel = (DefaultTableModel) ADMIN.getModel();
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





    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ADMIN = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        NAMA_ADMIN = new javax.swing.JTextField();
        PASSWORD = new javax.swing.JTextField();
        EMAIL = new javax.swing.JTextField();
        ID_SALES = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ADMIN1 = new javax.swing.JTable();
        nadmin = new javax.swing.JTextField();
        h = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ADMIN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID_ADMIN", "NAMA_ADMIN", "EMAIL", "PASSWORD", "ID_SALES"
            }
        ));
        jScrollPane1.setViewportView(ADMIN);

        jLabel1.setText("ADMIN");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("EMAIL");

        jLabel4.setText("NAMA_ADMIN");

        jLabel5.setText("PASSWORD");

        jLabel6.setText("ID_SALES");

        jButton2.setText("Create");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        ADMIN1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID_ADMIN", "NAMA_ADMIN", "EMAIL", "PASSWORD", "ID_SALES"
            }
        ));
        jScrollPane2.setViewportView(ADMIN1);

        nadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nadminActionPerformed(evt);
            }
        });

        h.setText("Cari Nama Admin");
        h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(PASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1))
                                    .addComponent(jButton3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(NAMA_ADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(ID_SALES, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(h)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nadmin))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(NAMA_ADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(ID_SALES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(PASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nadmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      tablekoneksi bukuFrame = new tablekoneksi();
      bukuFrame.setVisible(true);
      this.setVisible(false); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                                     
    // Ambil data dari field input
    String nama =   NAMA_ADMIN.getText();
    String email =  EMAIL.getText();
    String password = PASSWORD.getText();
    String idSales = ID_SALES.getText();

    // Koneksi ke database
    Connection connection = DatabaseConnection.getConnection();
    if (connection != null) {
        try {
            // Query untuk memasukkan data tanpa kolom ID_ADMIN
            String insertQuery = "INSERT INTO admin (NAMA_ADMIN, EMAIL, PASSWORD, ID_SALES) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, idSales);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
                loadTableData();
            }
            
            // Tutup resource
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  int selectedRow = ADMIN.getSelectedRow();
    if (selectedRow != -1) {
        // Mengambil ID_ADMIN dari baris yang dipilih
        String idAdmin = ADMIN.getValueAt(selectedRow, 0).toString(); // Kolom pertama adalah ID_ADMIN
        
        // Konfirmasi penghapusan data
        int confirmation = JOptionPane.showConfirmDialog(this, 
            "Apakah Anda yakin ingin menghapus data dengan ID_ADMIN: " + idAdmin + "?", 
            "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            // Koneksi ke database
            Connection connection = DatabaseConnection.getConnection();
            if (connection != null) {
                try {
                    // Membuat CallableStatement untuk memanggil function delete_admin_by_id
                    String sql = "{? = call delete_admin_by_id(?)}"; // Format untuk function
                    CallableStatement callableStatement = connection.prepareCall(sql);
                    
                    // Menentukan tipe data untuk parameter keluar (NUMBER - INTEGER)
                    callableStatement.registerOutParameter(1, java.sql.Types.INTEGER);
                    
                    // Mengatur parameter input untuk ID_ADMIN (tipe String karena VARCHAR2 di database)
                    callableStatement.setString(2, idAdmin);  // ID_ADMIN bertipe String
                    
                    // Menjalankan function
                    callableStatement.execute();
                    
                    // Mengecek hasil dari function
                    int result = callableStatement.getInt(1);  // Mengambil hasil sebagai integer
                    if (result == 1) {
                        JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Data tidak ditemukan atau kesalahan terjadi!");
                    }

                    // Memuat ulang data setelah penghapusan
                    loadTableData();

                    // Menutup CallableStatement dan koneksi
                    callableStatement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus data! \n" + ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Koneksi ke database gagal!");
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Silakan pilih data yang akan dihapus!");
    }


                                     
    


    }//GEN-LAST:event_jButton3ActionPerformed

    private void hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hActionPerformed

    // Mengambil nama admin dari text field
 String namaAdmin = nadmin.getText().trim(); // Mengambil nama admin dari input pengguna
if (!namaAdmin.isEmpty()) {
    // Menambahkan wildcard di kedua sisi nama admin
    namaAdmin = "%" + namaAdmin + "%";
}
    // Panggil method searchAdmin untuk mencari admin berdasarkan nama
    searchAdmin(namaAdmin);

    }//GEN-LAST:event_hActionPerformed

    private void nadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nadminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nadminActionPerformed

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
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ADMIN;
    private javax.swing.JTable ADMIN1;
    private javax.swing.JTextField EMAIL;
    private javax.swing.JTextField ID_SALES;
    private javax.swing.JTextField NAMA_ADMIN;
    private javax.swing.JTextField PASSWORD;
    private javax.swing.JButton h;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nadmin;
    // End of variables declaration//GEN-END:variables
}


