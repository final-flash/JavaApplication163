        package javaapplication163;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;


        public class DatabaseConnection {
            public static Connection getConnection() {
                Connection connection = null;
                try {
                    // Ganti dengan URL, username, dan password Anda
                    String url = "jdbc:oracle:thin:@LAPTOP-VD81OGE9:1521:XE"; // Pastikan konfigurasi benar
                    String user = "arunika";
                    String password = "123";
                    connection = DriverManager.getConnection(url, user, password);
                    System.out.println("Koneksi berhasil!"); // Debug log
                } catch (SQLException e) {
                    System.out.println("Koneksi gagal!");
                    e.printStackTrace();
                }
                return connection;
            }
        }
