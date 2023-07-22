package GUI;

import Koneksi.KoneksiDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormOperatorTiket extends javax.swing.JFrame {

    public FormOperatorTiket() {
        initComponents();
        //Menampilkan semua data pembelian tiket ke dalam tabel
        TampilData();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        nik = new javax.swing.JTextField();
        gender = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        berangkat = new javax.swing.JTextField();
        tujuan = new javax.swing.JTextField();
        cari = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        pesan = new javax.swing.JButton();
        kereta = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Identitas Penumpang");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Informasi Pembelian Tiket");

        jLabel3.setText("Nama Lengkap");

        jLabel4.setText("NIK");

        jLabel5.setText("Kelamin");

        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-Laki", "Perempuan" }));

        jLabel6.setText("Berangkat");

        jLabel7.setText("Tujuan");

        jLabel8.setText("Kereta");

        cari.setText("Cari Kereta");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Informasi Perjalanan");

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Lengkap", "NIK", "Nama Kereta", "Rute", "Tanggal", "Jam"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        pesan.setText("Pesan Tiket");
        pesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesanActionPerformed(evt);
            }
        });

        kereta.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nik, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(berangkat, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                    .addComponent(tujuan)
                                    .addComponent(kereta))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cari))
                            .addComponent(pesan, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(8, 8, 8))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(berangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(tujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cari)
                    .addComponent(kereta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pesan))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
       //Membaca input berangkat dan tujuan dari operator
        String Berangkat = berangkat.getText();
        String Tujuan = tujuan.getText();
        //Memanggil objek dari kelas CariKereta.java
        CariKereta kereta = new CariKereta(Berangkat, Tujuan);
        kereta.setVisible(true);

    }//GEN-LAST:event_cariActionPerformed

    private void pesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesanActionPerformed
        // TODO add your handling code here:
        String Nama = nama.getText();
        String NIK = nik.getText();
        String Gender = gender.getSelectedItem().toString();
        //menampung data kereta
        String NamaKereta = CariKereta.NamaKereta;
        String Rute = CariKereta.Rute;
        String Tanggal = CariKereta.Tanggal;
        String Jam = CariKereta.Jam;
        int Harga = CariKereta.Harga;
        int idTiket = CariKereta.idTiket;
        
        DateTimeFormatter dtf = (DateTimeFormatter.ofPattern("yyyy:MM:dd"));
        LocalDateTime WaktuBeli = LocalDateTime.now();
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Memesan Tiket ?");
        if (ok==0){
        try{
            Connection KONEKSI = KoneksiDB.getKoneksi();
            String QueryInsertpenumpang = "INSERT INTO penumpang (nik, nama, gender) VALUES (?,?,?)";
            String QueryInsertMembeli = "INSERT INTO membeli (id_tiket, nik, nama, tgl_beli) VALUES (?,?,?)";
        
            PreparedStatement P1 = KONEKSI.prepareStatement(QueryInsertpenumpang);
            PreparedStatement P2 = KONEKSI.prepareStatement(QueryInsertMembeli);
        
        P1.setString(1, NIK);
        P1.setString(2, Nama);
        P1.setString(3, Gender);
        
        P2.setInt(1, idTiket);
        P2.setString(2, NIK);
        P2.setString(3, dtf.format(WaktuBeli));
        
        P1.executeUpdate();
        P2.executeUpdate();
        if (kereta!= null) {
            DefaultTableModel model = (DefaultTableModel)tabel.getModel();
            Object [] data ={Nama, NamaKereta, Rute, Tanggal, Jam, Harga};
            model.addRow(data);
            
        }
        P1.close();
        }catch (Exception e) {
            System.out.println("Terjadi Kesalahan" +e.getMessage());
        }
        nik.setText("");
        nama.setText("");
        kereta.setText("");
        berangkat.setText("");
        tujuan.setText("");
        gender.setSelectedIndex(0);
        
            //if (berangkat == null && tujuan == null){
            //    String pesan = "Username atau Password salah!";
            //    JOptionPane.showMessageDialog(null, pesan, "Kesalahan", 
            //    JOptionPane.INFORMATION_MESSAGE);
            // } else{
            //}
             }
    }//GEN-LAST:event_pesanActionPerformed
       
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        kereta.setText(CariKereta.NamaKereta);
    }//GEN-LAST:event_formWindowGainedFocus
   
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
            java.util.logging.Logger.getLogger(FormOperatorTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormOperatorTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormOperatorTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormOperatorTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormOperatorTiket().setVisible(true);
            }
        });
    }
private void TampilData(){
 //Baca data kereta dari database
 try {
    //Membuat koneksi
    Connection conn = KoneksiDB.getKoneksi();
    Statement s = conn.createStatement();
    //Membuat query SELECT
    String sql = "SELECT * FROM kereta INNER JOIN tiket ON tiket.nama_kereta = kereta.nama_kereta INNER JOIN rute ON tiket.id_rute = rute.id_rute INNER JOIN membeli ON tiket.id_tiket = membeli.id_tiket INNER JOIN penumpang ON membeli.nik = penumpang.nik";
    System.out.println(sql);
    ResultSet r = s.executeQuery(sql);
    //Membaca data di dalam database baris per baris
     while (r.next()) {
     //Membuat variabel 'nama_kereta' untuk menampung data dari DB
     String _nama = r.getString("penumpang.nama");
    String _nik = r.getString("penumpang.nik");
    String _kereta = r.getString("kereta.nama_kereta");
    String _berangkat = r.getString("rute.berangkat");
    String _tujuan = r.getString("rute.tujuan");
    String tanggal = r.getString("tiket.waktu").substring(0, 10);
    String jam = r.getString("tiket.waktu").substring(11, 16);
 
    String rute = _berangkat +" - "+ _tujuan;
 
    //Tampilkan dalam tabel
    DefaultTableModel model = (DefaultTableModel) tabel.getModel();
    Object [] data = {_nama,_nik,_kereta,rute,tanggal,jam};
    model.addRow(data);
   }
    //menutup hasil penelusuran dan koneksi
    r.close();
    s.close();
    } catch (SQLException e) {
    System.out.println("Terjadi error");
 }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField berangkat;
    private javax.swing.JButton cari;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField kereta;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nik;
    private javax.swing.JButton pesan;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField tujuan;
    // End of variables declaration//GEN-END:variables
}
