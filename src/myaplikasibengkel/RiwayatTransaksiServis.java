/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myaplikasibengkel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author ubuntu
 */
public class RiwayatTransaksiServis extends javax.swing.JFrame {

    /**
     * Creates new form RiwayatTransaksi
     */
    public RiwayatTransaksiServis() {
        initComponents();
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnTampilkan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbRiwayatTransaksi = new javax.swing.JTable();
        dpINit = new com.github.lgooddatepicker.components.DatePicker();
        dpEnd = new com.github.lgooddatepicker.components.DatePicker();
        lbtotalpenjualan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Riwayat Servis");
        setLocation(new java.awt.Point(600, 0));

        jLabel1.setText("Periode Transaksi Servis : ");
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel2.setText("Tanggal Awal ");

        jLabel3.setText("Tanggal Akhir");

        btnTampilkan.setText("Tampilkan");
        btnTampilkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTampilkanActionPerformed(evt);
            }
        });

        tbRiwayatTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbRiwayatTransaksi);

        lbtotalpenjualan.setText("Total Harga");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(btnTampilkan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dpINit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dpEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtotalpenjualan)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(dpINit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dpEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(btnTampilkan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbtotalpenjualan)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 Connection conn = Koneksi.connectDB();
    private void btnTampilkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTampilkanActionPerformed
        // TODO add your handling code here:
        LocalDate initalDate = dpINit.getDate();
        LocalDate endDate = dpEnd.getDate();
        loadTabelRiwayat(initalDate,endDate);
        
        int valueharga = 0;
        for (int y = 0; y < tbRiwayatTransaksi.getRowCount();y++){
        valueharga += Integer.parseInt(tbRiwayatTransaksi.getValueAt(y, 3).toString());
        }
        int item = tbRiwayatTransaksi.getRowCount();
        String jmlitem = String.valueOf(item);
        
        DecimalFormat df = (DecimalFormat)
        DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setCurrencySymbol("");
        dfs.setMonetaryDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        df.setDecimalFormatSymbols(dfs);
        String hasil = df.format(valueharga);
        lbtotalpenjualan.setText(jmlitem + "Item /Rp. " + hasil);
    }//GEN-LAST:event_btnTampilkanActionPerformed
 public  void loadTabelRiwayat(LocalDate initialDate, LocalDate endDate) {
//    String sql = "SELECT *, SUM(p.harga_produk * t.total_item) AS total\n" + "FROM transaksi t JOIN produk p ON t.id_produk=p.id_produk\n" +"WHERE t.tgl_transaksi between '" + initialDate +"' AND '"+ endDate +"' GROUP BY t.id_transaksi";
    String sql = "SELECT *, SUM(p.harga * t.jml_item) AS total\n" + "FROM isi t JOIN data_service p ON t.id_service=p.id_service\n" +"WHERE t.tgl_servis between '" + initialDate +"' AND '"+ endDate +"' GROUP BY t.id_services";
    Object [] kolom = {"ID", "Tanggal","Qty", "Harga"};
    DefaultTableModel dataModel = new DefaultTableModel(null,kolom);
    tbRiwayatTransaksi.setModel(dataModel);
    tbRiwayatTransaksi.getColumnModel().getColumn(0).setMaxWidth(30);
    
    try {
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
    
    while (rs.next()) {
     int id = rs.getInt("id_services");
     String tanggal = rs.getString("tgl_servis");
     String total = rs.getString("jml_item");
     String jml_harga =  rs.getString("jml_bayar");
     
     
     
     Object [] data={id,tanggal, total, jml_harga};
     dataModel.addRow(data);
   
    }
    
    }catch(SQLException e) {
        System.err.println(e.getMessage());    
    }
    
    }
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
            java.util.logging.Logger.getLogger(RiwayatTransaksiServis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RiwayatTransaksiServis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RiwayatTransaksiServis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RiwayatTransaksiServis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RiwayatTransaksiServis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTampilkan;
    private com.github.lgooddatepicker.components.DatePicker dpEnd;
    private com.github.lgooddatepicker.components.DatePicker dpINit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbtotalpenjualan;
    private javax.swing.JTable tbRiwayatTransaksi;
    // End of variables declaration//GEN-END:variables
}
