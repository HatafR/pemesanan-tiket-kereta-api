package GUI;

import Koneksi.KoneksiDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DaftarAkun extends javax.swing.JFrame {

    public DaftarAkun() {
        initComponents();
    }

     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password1 = new javax.swing.JPasswordField();
        password2 = new javax.swing.JPasswordField();
        daftar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        jLabel3.setText("Ulang Password");

        daftar.setText("Daftar");
        daftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daftarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Daftar Akun Baru ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 91, Short.MAX_VALUE)
                .addComponent(daftar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                    .addComponent(password1)
                                    .addComponent(password2)))
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(password2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(daftar)
                .addGap(34, 34, 34))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void daftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daftarActionPerformed
        // TODO add your handling code here:
        
    //Membaca input dari user
    String Usr = username.getText();
    String Pwd1 = password1.getText();
    String Pwd2 = password2.getText();
    //Mengecek apakah username sudah ada yang pakai atau belum
    String cekUsr = null;
        try {
            //Membuat koneksi
            Connection conn = KoneksiDB.getKoneksi();
            Statement s = conn.createStatement();
            //Membuat query SELECT
            String sql = "SELECT * FROM akun WHERE username = '" + Usr + "'";
            ResultSet r = s.executeQuery(sql);
            //Membaca data di dalam database baris per baris
        while (r.next()) {
            //Membuat objek 'obj' untuk menampung data yang dibaca dari DB
            cekUsr = r.getString("username");
            }
            //menutup hasil penelusuran dan koneksi
            r.close();
            s.close();
            } catch (SQLException e) {
            System.out.println("Terjadi error");
            }
        if (cekUsr != null) {
        String pesan = "Username yang Anda masukkan sudah terdaftar!";
        JOptionPane.showMessageDialog(null, pesan, "Kesalahan", 
        JOptionPane.INFORMATION_MESSAGE);
        }
        //Mengecek apakah Pwd1 sama dengan Pwd2
        if (!Pwd1.equals(Pwd2)) {
        //Jika Pwd1 tidak sama dengan Pwd2
        String pesan = "Password yang Anda ketikkan tidak cocok. Ulangi lagi!";
        JOptionPane.showMessageDialog(null, pesan, "Kesalahan", 
        JOptionPane.INFORMATION_MESSAGE);
        } else {
        //Jika Pwd1 sama dengan Pwd2, simpan data ke dalam database
    try {
        //Membuat koneksi ke MySQL dengan memanggil objek KoneksiDB
        Connection koneksi = KoneksiDB.getKoneksi();
        //Membuat query untuk menyimpan data ke DB
        String query = "INSERT INTO akun (username,password) VALUES  (?,md5(?))";
        PreparedStatement p = koneksi.prepareStatement(query);
        //Menyiapkan data yang ingin disimpan ke Tabel Pegawai
        p.setString(1, Usr);
        p.setString(2, Pwd1);
        //Eksekusi query
        p.executeUpdate();
        //Menutup koneksi
        p.close();
        
    //Tampilkan pesan berhasil
        String pesan = "Selamat! Akun Anda berhasil didaftarkan.";
        JOptionPane.showMessageDialog(null, pesan, "Berhasil", 
        JOptionPane.INFORMATION_MESSAGE);
        //Menutup DaftarAkun dan membuka lagi FormLogin
    dispose();
        FormLogin login = new FormLogin();
        login.setVisible(true);
    } catch (SQLException e) {
   }
  }
    }//GEN-LAST:event_daftarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        //Memanggil kembali kelas FormLogin
        FormLogin login = new FormLogin();
        login.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(DaftarAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DaftarAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DaftarAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DaftarAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DaftarAkun().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton daftar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField password1;
    private javax.swing.JPasswordField password2;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
