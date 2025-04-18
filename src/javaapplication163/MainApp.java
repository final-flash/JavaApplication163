package javaapplication163;

public class MainApp {

    public static void main(String[] args) {
        try {
            // Uji koneksi database
            if (DatabaseConnection.getConnection() != null) {
                System.out.println("Koneksi berhasil, membuka JFrame...");
                // Membuka JFrame
                javax.swing.SwingUtilities.invokeLater(() -> {
                    tablekoneksi bukuFrame = new tablekoneksi();
                    bukuFrame.setVisible(true);
                });
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat membuka aplikasi.");
            e.printStackTrace();
        }
    }
}
