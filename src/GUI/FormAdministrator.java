package GUI;

import Koneksi.KoneksiDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormAdministrator extends javax.swing.JFrame {
    public FormAdministrator() {
        initComponents();
         //Tampilkan nama-nama kereta di dalam jComboBox 'Kereta'
        TampilNamaKereta();
        //Tampilkan semua rute kereta di dalam jComboBox 'Rute'
        TampilRuteKereta();
 
        //Tampilkan data yang tersimpan di dalam database
         TampilDatabase();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        harga = new javax.swing.JTextField();
        tanggal = new javax.swing.JFormattedTextField();
        jam = new javax.swing.JFormattedTextField();
        kereta = new javax.swing.JComboBox<>();
        rute = new javax.swing.JComboBox<>();
        simpan = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        hapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nama Kereta");

        jLabel2.setText("Rute Perjalanan");

        jLabel3.setText("Harga Tiket");

        jLabel4.setText("Tanggal");

        jLabel5.setText("Jam");

        tanggal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy:MM:dd"))));

        jam.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("HH:mm"))));

        kereta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Nama Kereta Api" }));
        kereta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keretaActionPerformed(evt);
            }
        });

        rute.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Rute Perjalanan" }));

        simpan.setText("SIMPAN");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        ubah.setText("UBAH");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Kereta", "Rute Perjalanan", "Tanggal", "Jam", "Harga Tiket"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        hapus.setText("HAPUS");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(harga)
                                    .addComponent(rute, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(kereta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jam)
                                    .addComponent(tanggal)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(simpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(kereta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan)
                    .addComponent(ubah)
                    .addComponent(hapus))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed

    //Membaca input data dari semua field
    String Kereta = kereta.getSelectedItem().toString();
    String Rute = rute.getSelectedItem().toString();
    String Tanggal = tanggal.getText();
    int Harga = Integer.parseInt(harga.getText());
    String Jam = jam.getText();
    //membaca id_rute dari String Rute
    int IdRute = BacaIdRute(Rute);
    System.out.println(IdRute + " " + Rute);
 
    //Simpan data ke dalam database
    try {
        //Membuat koneksi ke MySQL dengan memanggil objek KoneksiDB
        Connection koneksi = KoneksiDB.getKoneksi();
        //Membuat query untuk menyimpan data ke DB
        String query = "INSERT INTO tiket (nama_kereta,id_rute,waktu,harga) VALUES (?,?,?,?)";
        PreparedStatement p = koneksi.prepareStatement(query);
        
        p.setString(1, Kereta);
        p.setInt(2, IdRute);
        p.setString(3, (Tanggal +" "+ Jam));
        p.setInt(4, Harga);
        
        //Membuat tabel model
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        //Menampilkan data ke dalam tabel
        Object [] data = {Kereta,Rute,Tanggal,Jam,Harga};
        model.addRow(data);
 
    //Eksekusi query
    p.executeUpdate();
    //Menutup koneksi
    p.close();
        } catch (SQLException e) {
       String pesan = "Data gagal disimpan!";
       JOptionPane.showMessageDialog(null, pesan, "Kesalahan", 
       JOptionPane.INFORMATION_MESSAGE);
 }
   

    }//GEN-LAST:event_simpanActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        if (kereta.getSelectedItem().equals("")){
            hapus.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Pilih Nama Kereta Pada Tabel Untuk Menghapus Data ");
            
        } else{
           int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin menghapus data kereta ini?");
            if (ok==0){
                try {
                   String query = "Delete FROM tiket WHERE kereta = ' "+kereta.getSelectedItem()+"";
                   Connection con = new KoneksiDB().getKoneksi();
                   PreparedStatement ps = con.prepareStatement(query);
                   ps.executeUpdate();
                   JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                  ps.close();
                    
               } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus"+e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null,"Apakah anda yakin ingin mengubah data ini?");
        if (ok==0){
        String Kereta = kereta.getSelectedItem().toString();
        String Rute = rute.getSelectedItem().toString();
        String Tanggal = tanggal.getText();
        int Harga = Integer.parseInt(harga.getText());
        String Jam = jam.getText();
        //membaca id_rute dari String Rute
        int IdRute = BacaIdRute(Rute);
        System.out.println(IdRute + " " + Rute);
        try {
            Connection conn = KoneksiDB.getKoneksi();
            Statement s = conn.createStatement();            
            String QueryUpdate = "UPDATE tiket SET nama_kereta = '"+Kereta+"',id_rute = '"+Rute+"',waktu = '"+Tanggal+"',harga = '"+Harga+"' WHERE id_rute = '"+Rute+"'";
        s.executeUpdate(QueryUpdate);
        s.close();
        int idxRow =tabel.getSelectedRow();
            DefaultTableModel model;
            model = (DefaultTableModel)tabel.getModel();
            model.setValueAt(Kereta, idxRow, 0);
            model.setValueAt(Rute, idxRow, 1); 
            model.setValueAt(Tanggal, idxRow, 2); 
            model.setValueAt(Harga, idxRow, 3); 
            String pesan ="Data berhasil di update";
            JOptionPane.showMessageDialog(null,pesan,"Sukses",JOptionPane.INFORMATION_MESSAGE);
            
            } catch (SQLException e) {
            String pesan ="Data gagal diubah";
            JOptionPane.showMessageDialog(null,pesan,"Kesalahan",JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null,e.getMessage());
        } 
        }
        
    }//GEN-LAST:event_ubahActionPerformed

    private void keretaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keretaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keretaActionPerformed

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
            java.util.logging.Logger.getLogger(FormAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAdministrator().setVisible(true);
            }
        });
}
    private void TampilNamaKereta() {
      //Baca data kereta dari database
        try {
        //Membuat koneksi
        Connection conn = KoneksiDB.getKoneksi();
        Statement s = conn.createStatement();
        //Membuat query SELECT
        String sql = "SELECT nama_kereta FROM kereta";
        ResultSet r = s.executeQuery(sql);
        //Membaca data di dalam database baris per baris
        while (r.next()) {
            //Membuat variabel 'nama_kereta' untuk menampung data dari DB
            String nama_kereta = r.getString("nama_kereta");
            //Tambahkan nama kereta ke dalam jComboBox
            kereta.addItem(nama_kereta);
        }
        //menutup hasil penelusuran dan koneksi
        r.close();
        s.close();

        } catch (SQLException e) {
            System.out.println("Terjadi error");
 }
}
    private void TampilRuteKereta() {
    //Baca data kereta dari database
        try {
        //Membuat koneksi
        Connection conn = KoneksiDB.getKoneksi();
        Statement s = conn.createStatement();
        //Membuat query SELECT
        String sql = "SELECT berangkat,tujuan FROM rute";
        ResultSet r = s.executeQuery(sql);
        //Membaca data di dalam database baris per baris
        while (r.next()) {
         //Membuat variabel 'nama_kereta' untuk menampung data dari DB
        String Berangkat = r.getString("berangkat");
        String Tujuan = r.getString("tujuan");
        //Menyambungkan rute Berangkat dan Tujuan
        String Rute = Berangkat + " - " + Tujuan;
        //Tambahkan nama kereta ke dalam jComboBox
        rute.addItem(Rute);
        }
        //menutup hasil penelusuran dan koneksi
        r.close();
        s.close();
        } catch (SQLException e) {
        System.out.println("Terjadi error");
  }
}
    private void TampilDatabase(){
    //Baca isi tabel TIKET dan tampilkan ke dalam tabel
        try {
        //Membuat koneksi
        Connection conn = KoneksiDB.getKoneksi();
        Statement s = conn.createStatement();
         //Membuat query SELECT
        String sql = "SELECT * FROM tiket";
        ResultSet r = s.executeQuery(sql);
    //Membaca data di dalam database baris per baris
        while (r.next()) {
        //Membuat variabel 'nama_kereta' untuk menampung data dari DB
        String Kereta = r.getString("nama_kereta");
        String IdRute = r.getString("id_rute");
        String Tanggal = r.getString("waktu").substring(0,10); 
        String Jam = r.getString("waktu").substring(11, 16); 
        int Harga = r.getInt("harga");
 
 //Baca rute berdasarkan id_rute
        Statement s2 = conn.createStatement();
        String sql2 = "SELECT berangkat,tujuan FROM rute WHERE id_rute = '"+ IdRute +"'";
        ResultSet r2 = s2.executeQuery(sql2);
 
    String Berangkat = null, Tujuan = null;
    while (r2.next()){
    Berangkat = r2.getString("berangkat");
    Tujuan = r2.getString("tujuan");
    }
 
    String Rute = Berangkat +" - "+ Tujuan;
 
    r2.close();
    s2.close();
 
    //Membuat tabel model
    DefaultTableModel model = (DefaultTableModel) tabel.getModel();
 
    //Menampilkan data ke dalam tabel
    Object [] data = {Kereta,Rute,Tanggal,Jam,Harga};
    model.addRow(data);
   }
    //menutup hasil penelusuran dan koneksi
     r.close();
    s.close();
    } catch (SQLException e) {
    System.out.println("Terjadi error");
  }
}private int BacaIdRute(String rute) {
    int IdRute = 0;
    //Baca PK dari database
        try {
        //Membuat koneksi
            Connection conn = KoneksiDB.getKoneksi();
            Statement s = conn.createStatement();
            //Membuat query SELECT
            String querySelect = "SELECT id_rute FROM rute WHERE concat (berangkat,' –',tujuan) = '" + rute + "'";
            ResultSet r = s.executeQuery(querySelect);
            //Membaca data di dalam database baris per baris
            while (r.next()) {
            //Membuat variabel 'nama_kereta' untuk menampung data dari DB
            IdRute = r.getInt("id_rute");
            }
        //menutup hasil penelusuran dan koneksi
    r.close();
    s.close();
            } catch (SQLException e) {
            System.out.println("Gagal mengeksekusi query");
    }
    return IdRute;

}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hapus;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField jam;
    private javax.swing.JComboBox<String> kereta;
    private javax.swing.JComboBox<String> rute;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel;
    private javax.swing.JFormattedTextField tanggal;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
