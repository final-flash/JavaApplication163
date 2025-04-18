/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication163;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;



public class Buku extends javax.swing.JFrame {

   
        public Buku() {
        initComponents();
        this.setLocationRelativeTo(null); 
        this.setTitle("Perpustakaan");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         loadTableData();
    }
private void loadTableData() {
    String sql = "SELECT * FROM BUKU"; // Query untuk mendapatkan semua data dari tabel buku

    try (Connection conn = DatabaseConnection.getConnection()) {
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        // Hapus data lama pada model tabel
        DefaultTableModel model = (DefaultTableModel) BUKU.getModel();
        model.setRowCount(0);

        // Tambahkan data ke model tabel
        while (rs.next()) {
            Object[] row = {
                rs.getString("ID_BUKU"),
                rs.getString("JUDUL_BUKU"),
                rs.getInt("HARGA"),
                rs.getInt("JUMLAH_TERJUAL"),
                rs.getString("ID_AUTHOR"),
                rs.getString("ID_KATEGORI"),
                rs.getString("ID_PUBLISHER")
            };
            model.addRow(row);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

private void searchBukuByJudul(String judulBuku) {
    // Memeriksa apakah judul buku valid
    if (judulBuku == null || judulBuku.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Judul buku tidak boleh kosong!");
        return; // Menghentikan eksekusi jika judul buku tidak valid
    }

    // Menambahkan wildcard untuk pencarian yang fleksibel
    try (Connection connection = DatabaseConnection.getConnection()) {
        if (connection != null) {
            // Menyiapkan query pencarian
            String query = "SELECT ID_BUKU, JUDUL_BUKU, HARGA, JUMLAH_TERJUAL, ID_AUTHOR, ID_KATEGORI,ID_PUBLISHER FROM buku WHERE JUDUL_BUKU LIKE ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, "%" + judulBuku + "%"); // Mengatur parameter LIKE untuk pencarian berdasarkan judul buku

                // Menjalankan query
                try (ResultSet rs = stmt.executeQuery()) {
                    // Setup model untuk JTable
                    DefaultTableModel model = new DefaultTableModel();
                    model.addColumn("ID_BUKU");
                    model.addColumn("JUDUL_BUKU");
                    model.addColumn("HARGA");
                    model.addColumn("JUMLAH_TERJUAL");
                    model.addColumn("ID_AUTHOR");
                    model.addColumn("ID_KATEGORI");
                    model.addColumn("ID_PUBLISHER");

                    // Memasukkan data dari ResultSet ke dalam model JTable
                    while (rs.next()) {
                        model.addRow(new Object[] {
                            rs.getString("ID_BUKU"),
                            rs.getString("JUDUL_BUKU"),
                            rs.getInt("HARGA"), // Mengambil harga sebagai integer
                            rs.getInt("JUMLAH_TERJUAL"),
                            rs.getString("ID_AUTHOR"),
                            rs.getString("ID_KATEGORI"),
                            rs.getString("ID_PUBLISHER")
                        });
                    }

                    // Set model tabel ke JTable
                    BUKU1.setModel(model); // ganti dengan nama JTable Anda
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




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        BUKU = new javax.swing.JTable();
        ID_BUKU = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JUDUL_BUKU = new javax.swing.JTextField();
        ID_KATEGORI = new javax.swing.JTextField();
        ID_AUTHOR = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        caribuku = new javax.swing.JTextField();
        JUMLAH_TERJUAL = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        BUKU1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        HARGA = new javax.swing.JTextField();
        publish = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BUKU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_BUKU", "JUDUL_BUKU", "HARGA", "JUMLAH_TERJUAL", "ID_AUTHOR", "ID_KATEGORI", "ID_Publisher"
            }
        ));
        BUKU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BUKUMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(BUKU);

        ID_BUKU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_BUKUActionPerformed(evt);
            }
        });

        jLabel1.setText("JUMLAH TERJUAL");

        jLabel2.setText("ID_BUKU");

        jLabel3.setText("JUDUL_BUKU");

        JUDUL_BUKU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JUDUL_BUKUActionPerformed(evt);
            }
        });

        ID_KATEGORI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_KATEGORIActionPerformed(evt);
            }
        });

        ID_AUTHOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_AUTHORActionPerformed(evt);
            }
        });

        jLabel4.setText("ID_AUTHOR");

        jLabel5.setText("ID PUBLISHER");

        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Update.setText("Cancel");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setText("HARGA");

        caribuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caribukuActionPerformed(evt);
            }
        });

        JUMLAH_TERJUAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JUMLAH_TERJUALActionPerformed(evt);
            }
        });

        jButton4.setText("Cari Judul Buku");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        BUKU1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_BUKU", "JUDUL_BUKU", "HARGA", "JUMLAH_TERJUAL", "ID_AUTHOR", "ID_KATEGORI", "ID_PUBLISHER"
            }
        ));
        BUKU1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BUKU1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(BUKU1);

        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        HARGA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HARGAActionPerformed(evt);
            }
        });

        publish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publishActionPerformed(evt);
            }
        });

        jLabel7.setText("ID KATEGORI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(caribuku, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(JUDUL_BUKU, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(108, 108, 108)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addComponent(jLabel4))
                                .addComponent(jLabel1)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel5)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JUMLAH_TERJUAL, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ID_AUTHOR, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                        .addComponent(ID_KATEGORI)
                        .addComponent(publish)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(ID_BUKU, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(HARGA, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(Update)))))
                .addGap(31, 31, 31)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(106, 106, 106))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(ID_BUKU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JUMLAH_TERJUAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID_AUTHOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(JUDUL_BUKU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ID_KATEGORI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(HARGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(publish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(Update)
                    .addComponent(jButton2)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(caribuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ID_BUKUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_BUKUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_BUKUActionPerformed

    private void JUDUL_BUKUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JUDUL_BUKUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JUDUL_BUKUActionPerformed

    private void ID_KATEGORIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_KATEGORIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_KATEGORIActionPerformed

    private void ID_AUTHORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_AUTHORActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_AUTHORActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                                         
    // Create and run a SwingWorker to handle the background operation
    SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
        @Override
        protected Void doInBackground() throws Exception {
            // Get data from input fields
            String idBuku = ID_BUKU.getText();
            String judulBuku = JUDUL_BUKU.getText();
            String idAuthor = ID_AUTHOR.getText();
            String idKategori = ID_KATEGORI.getText();
            String hargaText = HARGA.getText();
            String jumlahText = JUMLAH_TERJUAL.getText();
            String publisher = publish.getText();
            

            // Validate inputs
            if (idBuku.isEmpty() || judulBuku.isEmpty() || idAuthor.isEmpty() || idKategori.isEmpty() || hargaText.isEmpty() || jumlahText.isEmpty() || publisher.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                return null; // Return early if validation fails
            }

            try {
                // Convert harga and jumlah to integers
                int harga = Integer.parseInt(hargaText);
                int jumlahTerjual = Integer.parseInt(jumlahText);

                // SQL query to insert data into 'BUKU' table
                String sql = "INSERT INTO BUKU (ID_BUKU, JUDUL_BUKU, HARGA, JUMLAH_TERJUAL, ID_AUTHOR, ID_KATEGORI,ID_PUBLISHER) VALUES (?, ?, ?, ?, ?, ?, ?)";

                try (Connection conn = DatabaseConnection.getConnection()) {
                    // Prepare the SQL statement
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, idBuku);
                    stmt.setString(2, judulBuku);
                    stmt.setInt(3, harga);
                    stmt.setInt(4, jumlahTerjual);
                    stmt.setString(5, idAuthor);
                    stmt.setString(6, idKategori);
                    stmt.setString(7, publisher);

                    // Execute the statement
                    stmt.executeUpdate();

                    // Reload table data after insertion
                    loadTableData();

                    JOptionPane.showMessageDialog(null, "Book added successfully!");

                } catch (SQLException e) {
                // Catch and display Oracle error messages
                String errorMessage = e.getMessage();
                if (errorMessage.contains("ORA-20006")) {
                    JOptionPane.showMessageDialog(null, errorMessage, "Oracle Trigger Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error inserting data into database: " + errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            } catch (NumberFormatException e) {
                // Handle number format exceptions for harga and jumlah
                JOptionPane.showMessageDialog(null, "Please enter valid numeric values for Harga and Jumlah Terjual.");
            }

            return null;
        }

        @Override
        protected void done() {
            // Enable UI components after background task is done
            super.done();
        }
    };

    // Execute the background task
    worker.execute();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
    ID_BUKU.setText("");           // Menghapus ID_BUKU
    JUDUL_BUKU.setText("");        // Menghapus JUDUL_BUKU
    caribuku.setText("");             // Menghapus HARGA
    JUMLAH_TERJUAL.setText("");    // Menghapus JUMLAH_TERJUAL
    ID_AUTHOR.setText("");        // Menghapus ID_AUTHOR
    ID_KATEGORI.setText("");
    
  
    }//GEN-LAST:event_UpdateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 
    // Mengambil ID_Buku dari JTextField
    String idBuku = ID_BUKU.getText();

    if (idBuku.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please select a record to delete.");
        return;  // Jika ID_Buku kosong, jangan lanjutkan proses delete
    }

    // SQL untuk menghapus data berdasarkan ID_Buku
    String sqlDeleteQuery = "DELETE FROM BUKU WHERE ID_BUKU = ?";

    try (Connection conn = DatabaseConnection.getConnection(); 
         PreparedStatement pstmt = conn.prepareStatement(sqlDeleteQuery)) {

        // Menyusun query dan set parameter
        pstmt.setString(1, idBuku);

        // Mengeksekusi query
        int rowsAffected = pstmt.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Data deleted successfully!");

            // Setelah menghapus, kita akan memperbarui tabel untuk mencerminkan perubahan
            loadTableData(); // Memuat ulang data pada tabel

            // Mengosongkan JTextField
            ID_BUKU.setText("");
            JUDUL_BUKU.setText("");
            caribuku.setText("");
            JUMLAH_TERJUAL.setText("");
            ID_AUTHOR.setText("");
            ID_KATEGORI.setText("");
            publish.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "No record found with the given ID.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error deleting record: " + e.getMessage());
    }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                                     
Connection conn = DatabaseConnection.getConnection();
    
    if (conn != null) {
        String query = "UPDATE BUKU SET JUDUL_BUKU = ?, HARGA = ?, JUMLAH_TERJUAL = ?, ID_AUTHOR = ?, ID_KATEGORI = ?, ID_PUBLISHER = ? WHERE ID_BUKU = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            // Ambil nilai dari JTextField
            String idBuku = ID_BUKU.getText().trim(); 
            String judulBuku = JUDUL_BUKU.getText().trim();  
            String harga = HARGA.getText().trim();           
            String jumlahTerjual = JUMLAH_TERJUAL.getText().trim();  
            String idAuthor = ID_AUTHOR.getText().trim();    
            String idKategori = ID_KATEGORI.getText().trim();
            String publisherText = publish.getText().trim();

            // Validasi input, pastikan harga, jumlahTerjual, dan idBuku tidak kosong
            if (harga.isEmpty() || jumlahTerjual.isEmpty() || idBuku.isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID Buku, Harga, dan Jumlah Terjual tidak boleh kosong.");
                return;
            }

            // Pastikan ID_PUBLISHER berupa angka dan valid
            int idPublisher = 0; // Inisialisasi idPublisher
            try {
                idPublisher = Integer.parseInt(publisherText); // Konversi ID_PUBLISHER ke int
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID Publisher harus berupa angka.");
                return;
            }

            // Set nilai parameter untuk query
            stmt.setString(1, judulBuku);
            stmt.setDouble(2, Double.parseDouble(harga)); // Konversi harga ke double
            stmt.setInt(3, Integer.parseInt(jumlahTerjual)); // Konversi jumlahTerjual ke int
            stmt.setString(4, idAuthor);
            stmt.setString(5, idKategori);
            stmt.setInt(6, idPublisher); // Set ID_PUBLISHER sebagai integer
            stmt.setString(7, idBuku);  // Set ID_BUKU untuk WHERE clause

            // Eksekusi query untuk update
            stmt.executeUpdate();
            
            // Pesan sukses
            JOptionPane.showMessageDialog(this, "Data berhasil diperbarui.");
            loadTableData(); // Memuat data terbaru dari tabel
        } catch (NumberFormatException e) {
            // Tangani kesalahan format angka
            JOptionPane.showMessageDialog(this, "Harga atau Jumlah Terjual tidak valid. Pastikan Anda memasukkan angka.");
        } catch (SQLException e) {
            // Tangani kesalahan dari trigger atau database lainnya
            String errorMessage = e.getMessage();
            
            // Cek jika error berasal dari trigger dan menampilkan pesan yang relevan
            if (errorMessage.contains("ID Buku tidak boleh kosong saat update")) {
                System.out.println("Pesan dari Trigger: " + errorMessage);
                JOptionPane.showMessageDialog(this, "Error: " + errorMessage);
            } else {
                // Tangani kesalahan lainnya
                System.out.println("Terjadi kesalahan: " + errorMessage);
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memperbarui data: " + errorMessage);
            }
        }
    } else {
        // Menampilkan pesan jika koneksi ke database gagal
        JOptionPane.showMessageDialog(this, "Koneksi ke database gagal.");
    }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void caribukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caribukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caribukuActionPerformed

    private void JUMLAH_TERJUALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JUMLAH_TERJUALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JUMLAH_TERJUALActionPerformed

    private void BUKUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BUKUMouseClicked
         int row = BUKU.rowAtPoint(evt.getPoint());

        // Pastikan baris valid (jika baris di klik adalah header, misalnya)
        if (row >= 0) {
            // Mendapatkan data dari baris yang dipilih
            String idBuku = (String) BUKU.getValueAt(row, 0);
            String judulBuku = (String) BUKU.getValueAt(row, 1);
            int harga = (int) BUKU.getValueAt(row, 2);
            int jumlahTerjual = (int) BUKU.getValueAt(row, 3);
            String idAuthor = (String) BUKU.getValueAt(row, 4);
            String idKategori = (String) BUKU.getValueAt(row, 5);
            String publisher = (String) BUKU.getValueAt(row, 6);

            // Menampilkan data ke dalam text field
            ID_BUKU.setText(idBuku);
            JUDUL_BUKU.setText(judulBuku);
            HARGA.setText(String.valueOf(harga));
            JUMLAH_TERJUAL.setText(String.valueOf(jumlahTerjual));
            ID_AUTHOR.setText(idAuthor);
            ID_KATEGORI.setText(idKategori);
            publish.setText(publisher);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_BUKUMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
                                           
    // Mengambil teks dari JTextField untuk nama buku yang akan dicari
    String judulBuku = caribuku.getText().trim();

    // Memanggil method searchBukuByJudul dengan parameter judul buku
    searchBukuByJudul(judulBuku);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void BUKU1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BUKU1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BUKU1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      tablekoneksi bukuFrame = new tablekoneksi();
      bukuFrame.setVisible(true);
      this.setVisible(false);  
    }//GEN-LAST:event_jButton5ActionPerformed

    private void HARGAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HARGAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HARGAActionPerformed

    private void publishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publishActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_publishActionPerformed

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
            java.util.logging.Logger.getLogger(Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BUKU;
    private javax.swing.JTable BUKU1;
    private javax.swing.JTextField HARGA;
    private javax.swing.JTextField ID_AUTHOR;
    private javax.swing.JTextField ID_BUKU;
    private javax.swing.JTextField ID_KATEGORI;
    private javax.swing.JTextField JUDUL_BUKU;
    private javax.swing.JTextField JUMLAH_TERJUAL;
    private javax.swing.JButton Update;
    private javax.swing.JTextField caribuku;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField publish;
    // End of variables declaration//GEN-END:variables
}
