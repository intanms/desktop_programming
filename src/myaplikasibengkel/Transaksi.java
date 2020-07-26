/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myaplikasibengkel;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import javax.naming.spi.DirStateFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.ir.BreakNode;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ubuntu
 */
public class Transaksi extends javax.swing.JFrame {
public String gantiformat="";
public StringTokenizer token;
    /**
     * Creates new form Transaksi
     */
    public Transaksi() {
        initComponents();
        loadTabelProduk();
        loadTabelTransaksi();
        TbProduk.setDefaultEditor(Object.class, null);
        loadTotal();
    }
    Connection conn = Koneksi.connectDB();
    public  void loadTabelProduk() {
    String sql = "SELECT * FROM produk";
    Object [] kolom = {"ID", "Item", "Harga"};
    DefaultTableModel dataModel = new DefaultTableModel(null,kolom);
    TbProduk.setModel(dataModel);
    TbProduk.getColumnModel().getColumn(0).setMaxWidth(30);
    TbProduk.getColumnModel().getColumn(2).setMaxWidth(50);
    try {
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
    
    while (rs.next()) {
     int id = rs.getInt("id_produk");
     String nama = rs.getString("nm_produk");
     int harga = rs.getInt("harga_produk");
     
     Object [] data={id,nama, harga};
     dataModel.addRow(data);
    }
    
    }catch(SQLException e) {
        System.out.println(e.getMessage());    
    }
    }
    
    public  void loadTabelProduk(String teks) {
    String sql = "SELECT * FROM produk WHERE id_produk like '%" + teks +"%' OR nm_produk like '%"+teks+"%'";
    Object [] kolom = {"ID", "Item", "Harga"};
    DefaultTableModel dataModel = new DefaultTableModel(null,kolom);
    TbProduk.setModel(dataModel);
    TbProduk.getColumnModel().getColumn(0).setMaxWidth(30);
    TbProduk.getColumnModel().getColumn(2).setMaxWidth(50);
    try {
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
    
    while (rs.next()) {
     int id = rs.getInt("id_produk");
     String nama = rs.getString("nm_produk");
     int harga = rs.getInt("harga_produk");
     
     Object [] data={id,nama, harga};
     dataModel.addRow(data);
    }
    
    }catch(SQLException e) {
        System.out.println(e.getMessage());    
    }
    }
    
    public  void loadTabelTransaksi() {
    String sql = "SELECT * FROM transaksi_temp";
    Object [] kolom = {"No", "Item", "Qty","Harga", "Total"};
    DefaultTableModel dataModel = new DefaultTableModel(null,kolom);
    
    tbTransaksi.setModel(dataModel);
    tbTransaksi.getColumnModel().getColumn(0).setMaxWidth(30);
    tbTransaksi.getColumnModel().getColumn(2).setMaxWidth(30);
    tbTransaksi.getColumnModel().getColumn(3).setMaxWidth(90);
    tbTransaksi.getColumnModel().getColumn(4).setMaxWidth(100);
    
    try {
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
    int no =1;
     while (rs.next()) {
     DecimalFormat df = (DecimalFormat)
     DecimalFormat.getCurrencyInstance();
     DecimalFormatSymbols dfs = new DecimalFormatSymbols();
     dfs.setCurrencySymbol("");
     dfs.setMonetaryDecimalSeparator(',');
     dfs.setGroupingSeparator('.');
     df.setDecimalFormatSymbols(dfs);
     String nama = rs.getString("nm_produk");
     int harga = rs.getInt("harga_produk");
     int jml = rs.getInt("total_item");
     int total = harga * jml ; 
     String hasil = "Rp. " + df.format(harga);
     String jumlah = "Rp. " + df.format(total);
     Object [] data={no,nama, jml, hasil, jumlah};
     dataModel.addRow(data);
     no++;
    }
    
    }catch(SQLException e) {
        System.out.println(e.getMessage());    
    }
    }
    
    public void loadTotal () {
    String sql = "SELECT * from transaksi_temp";
    int total_item = 0;
    int total_bayar = 0;
    
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
               
               int jml = rs.getInt("total_item");
               int hrg = rs.getInt("harga_produk");
               total_item += jml;
               total_bayar += jml *hrg;
               
       
            }
            
            lbJumlah.setText(String.valueOf(total_item));
            lbTotal.setText(String.valueOf(total_bayar));
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TbProduk = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbTransaksi = new javax.swing.JTable();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbJumlah = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbJumlah1 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBayar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lbJumlah2 = new javax.swing.JLabel();
        lbKembali = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transaksi");
        setLocation(new java.awt.Point(450, 0));
        setResizable(false);

        TbProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        TbProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TbProdukMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TbProduk);

        jLabel1.setText("Cari");

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
        });

        tbTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane2.setViewportView(tbTransaksi);

        btnHapus.setText("Hapus Item");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jLabel2.setText("Jumlah :");

        lbJumlah.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbJumlah.setText("0");

        jLabel3.setText("Total :");

        lbJumlah1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbJumlah1.setText("Rp.");

        lbTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbTotal.setText("0");

        jLabel4.setText("Dibayar :");

        txtBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBayarActionPerformed(evt);
            }
        });
        txtBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBayarKeyPressed(evt);
            }
        });

        jLabel5.setText("Kembali :");

        lbJumlah2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbJumlah2.setText("Rp.");

        lbKembali.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbKembali.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBayar)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbJumlah2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbKembali))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(lbJumlah1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTotal)
                                    .addComponent(lbJumlah))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSimpan)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbJumlah)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTotal)
                            .addComponent(lbJumlah1))
                        .addGap(34, 34, 34)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbJumlah2)
                            .addComponent(lbKembali)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
        // TODO add your handling code here:
        String cari = txtCari.getText();
        int l = cari.length();
        if ( (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'||evt.getKeyChar() >= 'a' && evt.getKeyChar() <= 'z')&& l< 9||evt.getKeyChar() == KeyEvent.VK_ENTER || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_DELETE) {
                    txtCari.setEditable(true);
                } else {
                    txtCari.setEditable(false);
                    if ( l == 9 ) {
                    JOptionPane.showMessageDialog(this, "Inputan tidak valid");
                    }else{
                    JOptionPane.showMessageDialog(this, "Pencarian berdasarkan nama produk");
                    }
                }
        if(evt.getKeyCode() ==  KeyEvent.VK_ENTER) {
        String teks = txtCari.getText();
        loadTabelProduk(teks);
        }
    }//GEN-LAST:event_txtCariKeyPressed
int selectedID;

    private void TbProdukMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbProdukMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            if (TbProduk.isRowSelected(TbProduk.getSelectedRow())== true) {
            selectedID = (int)TbProduk.getValueAt(TbProduk.getSelectedRow(),0);
            String namaProduk = TbProduk.getValueAt(TbProduk.getSelectedRow(),1).toString();
            int hargaProduk = (int)TbProduk.getValueAt(TbProduk.getSelectedRow(), 2);
            
            JTextField txtJml = new JTextField(15);
            txtJml.setHorizontalAlignment(SwingConstants.RIGHT);
            txtJml.addKeyListener(new KeyAdapter() {
  
            public void keyPressed(KeyEvent ke) {
            
            String value = txtJml.getText();
            int l = value.length();
            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == KeyEvent.VK_DELETE) {
                    txtJml.setEditable(true);
                } else {
                    txtJml.setEditable(false);
                }
            }
            }
            );
            
            JPanel myPanel = new JPanel();
            myPanel.setLayout(new GridLayout(2,2,0,10));
            myPanel.add(new JLabel("Jumlah item "  + namaProduk));
            myPanel.add(txtJml);
            
            int result = JOptionPane.showConfirmDialog(this, myPanel, "Konfirmasi jumlah item ", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
            
                if (result ==  JOptionPane.OK_OPTION) {
                    try {
                        String sqlf = "SELECT * FROM transaksi_temp WHERE id_produk='" +selectedID + "'";
                        Statement stmtf =  conn.createStatement();
                        ResultSet rs = stmtf.executeQuery(sqlf);
                        if (rs.first() == true) {
                            int newJml =  Integer.valueOf(txtJml.getText()) + rs.getInt("total_item");
                            Statement stmt = conn.createStatement();
                            stmt.executeUpdate("UPDATE transaksi_temp SET total_item='" + newJml+ "' WHERE id_produk='" +selectedID+"'" );
                            
                        } else {
                            Statement stmt = conn.createStatement();
                            stmt.executeUpdate("INSERT INTO transaksi_temp" +"(id_produk,nm_produk,harga_produk,total_item) VALUES ('" + selectedID+ "', '"+namaProduk+ "', '" + hargaProduk + "', '" + txtJml.getText()+ "')");
                            
                        }
                        loadTabelTransaksi();
                        loadTotal();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                JOptionPane.showMessageDialog(this,"Tidak ada yang dipilih");
                }
            
            }
        }
    }
public int getNextKode(){
    String sql = "SELECT * FROM transaksi order by " + " kode_transaksi DESC LIMIT 1";
    int lastKode = 0;
    
    try {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.first()==true){
        lastKode = rs.getInt("kode_transaksi");
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
return lastKode+1;
    }//GEN-LAST:event_TbProdukMousePressed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
       bayar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtBayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBayarKeyPressed
        String nilai = txtBayar.getText();
        int l = nilai.length();
        if ((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9')&& l < 9 ||evt.getKeyChar() == KeyEvent.VK_ENTER || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_DELETE) {
                    txtBayar.setEditable(true);
                } else {
                    txtBayar.setEditable(false);
                    if (l==9){
                     JOptionPane.showMessageDialog(this, "Inputan tidak valid");
                    }else {
                    JOptionPane.showMessageDialog(this, "Inputan hanya untuk data numerik");
                    }
                }
        
        if (evt.getKeyCode()== KeyEvent.VK_ENTER) {
            bayar();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBayarKeyPressed
   String select;
    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        if(tbTransaksi.isRowSelected(tbTransaksi.getSelectedRow())== true) {
        select = (String)tbTransaksi.getValueAt(tbTransaksi.getSelectedRow(),1);
      
      int result = JOptionPane.showConfirmDialog(this, 
              "Kamu akan menghapus data "
              + tbTransaksi.getValueAt(tbTransaksi.getSelectedRow(),1).toString(),
              "Peringatan",
              JOptionPane.YES_NO_OPTION,
              JOptionPane.QUESTION_MESSAGE);
       
     if (result ==  JOptionPane.YES_OPTION) {
            try {
                String query = "DELETE FROM transaksi_temp WHERE nm_produk = ? ;";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, select);
                stmt.executeUpdate();
                loadTabelTransaksi();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }else {
         JOptionPane.showMessageDialog(this, "Tidak ada yang dipilih");
        }
     }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(this, 
              "Anda akan melakukan reset transaksi",
              "Peringatan",
              JOptionPane.YES_NO_OPTION,
              JOptionPane.QUESTION_MESSAGE);
       
     if (result ==  JOptionPane.YES_OPTION) {
            try {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("DELETE FROM transaksi_temp");
                loadTabelTransaksi();
                lbJumlah.setText("0");
                lbTotal.setText("0");
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }else {
         JOptionPane.showMessageDialog(this, "Tidak ada yang dipilih");
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBayarActionPerformed

public void bayar(){
    if (txtBayar.getText().isEmpty()|| txtBayar.getText().equals("0")) {
    JOptionPane.showMessageDialog(this, "Pelanggan Belum Bayar");
    
    } else {
    int totalBayar =  Integer.valueOf(lbTotal.getText());
    int pembayaran = Integer.valueOf(txtBayar.getText());
    int kembali =  pembayaran -  totalBayar;
    int kurang = 0;
    if(pembayaran < totalBayar){
    JOptionPane.showMessageDialog(this, "Uang anda kurang");
    lbKembali.setText(String.valueOf(kurang));
    }else {
    lbKembali.setText(String.valueOf(kembali));
    
    int result = JOptionPane.showConfirmDialog(this, "Transaksi akan diakhiri","Peringatan!", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    
        if (result == JOptionPane.YES_OPTION) {
            int nextKode = getNextKode();
            try {
                cetak(String.format("%05d", nextKode));
                Statement stmt =  conn.createStatement();
                stmt.executeUpdate("INSERT INTO transaksi(kode_transaksi," + "id_produk,total_item) SELECT '"+nextKode+"',id_produk,total_item FROM transaksi_temp");
                stmt.executeUpdate("DELETE FROM transaksi_temp");
                loadTabelTransaksi();
                loadTotal();
                txtBayar.setText("");
                lbKembali.setText("0");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
   }
}

public int getTotal() {
String sql = "SELECT * FROM transaksi_temp";
int total_item = 0;
int total_bayar = 0;

try {
    Statement stmt =  conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
   while(rs.next()) {
    int jml = rs.getInt("total_item");  
    int hrg = rs.getInt("harga_produk");
    total_item += jml;
    total_bayar += jml * hrg;
   }
    }catch(SQLException e) {
    System.out.println(e.getMessage());
}
return total_bayar;
}

public void cetak(String txid){
int total = getTotal();
int bayar = Integer.valueOf(txtBayar.getText());
int kembali = bayar - total;
DecimalFormat df = (DecimalFormat)
     DecimalFormat.getCurrencyInstance();
     DecimalFormatSymbols dfs = new DecimalFormatSymbols();
     dfs.setCurrencySymbol("");
     dfs.setMonetaryDecimalSeparator(',');
     dfs.setGroupingSeparator('.');
     df.setDecimalFormatSymbols(dfs);
     String ttl = "Rp. " + df.format(total);
     String byr = "Rp. " + df.format(bayar);
     String kmb = "Rp. " + df.format(kembali);
     
    Map<String, Object> parameters =  new HashMap<String , Object>();
    
    parameters.put("TX_ID", txid);
    parameters.put("TOTAL", ttl);
    parameters.put("BAYAR", byr);
    parameters.put("KEMBALI", kmb);
    
    try {
        JasperPrint jp =  JasperFillManager.fillReport(getClass().getResourceAsStream("../report/strukpenjualan.jasper"), parameters,conn);
        JasperViewer.viewReport(jp, false);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, e);
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
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TbProduk;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbJumlah;
    private javax.swing.JLabel lbJumlah1;
    private javax.swing.JLabel lbJumlah2;
    private javax.swing.JLabel lbKembali;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JTable tbTransaksi;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables

    Object getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
