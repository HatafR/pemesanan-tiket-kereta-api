package GUI;

import Koneksi.KoneksiDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CariKereta extends javax.swing.JFrame {
    public static int idTiket;
    public static int Harga;
    public static String NamaKereta;
    public static String Rute;
    public static String Jam;
    public static String Tanggal;
    

    public CariKereta(String Berangkat, String Tujuan) {
        initComponents();
        //Menampilkan data Berangkat dan Tujuan ke texField
        berangkat.setText(Berangkat);
        tujuan.setText(Tujuan);
    }

    private CariKereta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        berangkat = new javax.swing.JTextField();
        tujuan = new javax.swing.JTextField();
        cari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        selesai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Berangkat");

        jLabel2.setText("Tujuan");

        cari.setText("Cari Kereta");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Tiket", "Nama Kereta", "Rute", "Tanggal", "Waktu", "Harga"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        selesai.setText("Selesai");
        selesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selesaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(berangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addComponent(tujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cari)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(selesai)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(berangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selesai)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        
    //Membaca data pada textField Berangkat dan Tujuan
    String Berangkat = berangkat.getText();
    String Tujuan = tujuan.getText();
 
    //Mencari kereta dalam database sesuai rute yang diminta 
    try {
        //Membuat koneksi
        Connection conn = KoneksiDB.getKoneksi();
        Statement s = conn.createStatement();
        //Membuat query SELECT
        String sql = "SELECT * FROM tiket INNER JOIN rute ON tiket.id_rute = rute.id_rute WHERE rute.berangkat = '"+ Berangkat +"' AND rute.tujuan = '"+ Tujuan +"'";

        ResultSet r = s.executeQuery(sql);
        //Membaca data di dalam database baris per baris
        while (r.next()) {
        //Membuat objek 'obj' untuk menampung data yang dibaca dari DB
        int IdTiket = r.getInt("id_tiket");
        String _Kereta = r.getString("nama_kereta");
        String _Berangkat = r.getString("berangkat");
        String _Tujuan = r.getString("tujuan");
        String _Tanggal = r.getString("waktu").substring(0,10);
        String _Jam = r.getString("waktu").substring(11,16);
        int _Harga = r.getInt("harga");

        //Menggabungkan string _Berangkat dan _Tujuan
        String _Rute = _Berangkat +" - "+ _Tujuan;
 
    //Membuat tabel model dan menampilkan hasil query ke tabel
    DefaultTableModel model = (DefaultTableModel) tabel.getModel();
    Object [] data = {IdTiket,_Kereta,_Rute,_Tanggal,_Jam,_Harga};
    model.addRow(data);
    }       
    //menutup hasil penelusuran dan koneksi
    r.close();
    s.close();
    } catch (SQLException e) {
        String pesan = "Data tidak ditemukan!";
        JOptionPane.showMessageDialog(null,pesan,"Kesalahan",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,e.getMessage());
    }
    }//GEN-LAST:event_cariActionPerformed

    private void selesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selesaiActionPerformed
        // TODO add your handling code here:
        int idxRow = tabel.getSelectedRow();
        idTiket = Integer.parseInt(tabel.getValueAt(idxRow,0).toString());
        NamaKereta = tabel.getValueAt(idxRow,1).toString();
        Rute = tabel.getValueAt(idxRow,2).toString();
        Tanggal = tabel.getValueAt(idxRow,3).toString();
        Jam = tabel.getValueAt(idxRow,4).toString();
        Harga = Integer.parseInt(tabel.getValueAt(idxRow,5).toString());
        
        FormOperatorTiket fot = new FormOperatorTiket();
        fot.setVisible(true);

        dispose();
    }//GEN-LAST:event_selesaiActionPerformed
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CariKereta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CariKereta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CariKereta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CariKereta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CariKereta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField berangkat;
    private javax.swing.JButton cari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton selesai;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField tujuan;
    // End of variables declaration//GEN-END:variables
}
