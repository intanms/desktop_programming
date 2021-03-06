/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myaplikasibengkel;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author intan
 */
public class Manajemen extends javax.swing.JFrame {

    /**
     * Creates new form Manajemen
     */
    public Manajemen() {
        initComponents();
        loadTabel();
    }
     Connection conn = Koneksi.connectDB();
    public void loadTabel(){
        String sql = "SELECT * FROM login";
        Object[] kolom = {"username"};
        DefaultTableModel dataModel = new DefaultTableModel(null, kolom);
        tbTabel.setModel(dataModel);
        tbTabel.getColumnModel().getColumn(0);
        
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs =  stmt.executeQuery(sql);
            
            while (rs.next()){
               
                String username = rs.getString("username");
             
                
                Object[] data={username};
                dataModel.addRow(data);
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public String hashSHA256(String plainteks){
        StringBuilder sb = new StringBuilder();
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashInBytes = md.digest(plainteks.getBytes(StandardCharsets.UTF_8));
            
            for(byte b : hashInBytes){
                sb.append(String.format("%02x",b));
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return sb.toString();
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTambah = new javax.swing.JButton();
        txtUbah = new javax.swing.JButton();
        txtHapus = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTabel = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manajemen User");
        setLocation(new java.awt.Point(800, 0));

        txtTambah.setText("Tambah");
        txtTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTambahActionPerformed(evt);
            }
        });

        txtUbah.setText("Ubah");
        txtUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUbahActionPerformed(evt);
            }
        });

        txtHapus.setText("Hapus");
        txtHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHapusActionPerformed(evt);
            }
        });

        jLabel1.setText("Cari:");

        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
        });

        tbTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane1.setViewportView(tbTabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addComponent(txtUbah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(txtTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUbah)
                        .addGap(18, 18, 18)
                        .addComponent(txtHapus)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void txtTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTambahActionPerformed
        // TODO add your handling code here:
      String[] jabatan = {"admin","user"};
      JTextField txtUsername = new JTextField(15);
      JPasswordField txtPassword = new JPasswordField(15);
      JComboBox cbjabatan = new JComboBox(jabatan);
     
      
      JPanel myPanel = new JPanel();
      myPanel.setLayout(new GridLayout(3,3,0,10));
      myPanel.add(new JLabel("Username"));
      myPanel.add(txtUsername);
      myPanel.add(new JLabel("Jabatan"));
      myPanel.add(cbjabatan);
      myPanel.add(new JLabel("Password"));
      myPanel.add(txtPassword);
   
      
      int result = JOptionPane.showConfirmDialog(this, myPanel,
              "Input Akun Baru",
              JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
      String uuid = UUID.randomUUID().toString();
        String salt = uuid.replace("-", "");
      
      if(result==JOptionPane.OK_OPTION){
          try{
              String jb_tn;
              if(cbjabatan.getSelectedIndex() == 0){
               jb_tn = "admin";
              }else{
              jb_tn = "user";
              }
              
              String sql =  "INSERT INTO login (username,jb_tn,password,salt)" + " VALUES(?, ?, ?, ?) ; ";
              PreparedStatement stmt = conn.prepareStatement(sql);
              stmt.setString(1, txtUsername.getText());
              stmt.setString(2, jb_tn);
              stmt.setString(3, hashSHA256(salt+txtPassword.getText()));
              stmt.setString(4, salt);
              stmt.executeUpdate();
              loadTabel();
                      } catch(SQLException e){
          System.out.println(e.getMessage());
      }
      }
    }//GEN-LAST:event_txtTambahActionPerformed
String selectedID;
    private void txtUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUbahActionPerformed
        // TODO add your handling code here:
          
          if(tbTabel.isRowSelected(tbTabel.getSelectedRow())==true){
              try {
                  selectedID = (String)tbTabel.getValueAt(tbTabel.getSelectedRow(), 0);
                  String[] jabatan = {"admin","user"};
                  JTextField txtUsername = new JTextField(15);
                   JComboBox cbjabatan = new JComboBox(jabatan);
                  JPasswordField txtPassword = new JPasswordField(15);
                
                  txtUsername.setText(tbTabel.getValueAt(tbTabel.getSelectedRow(), 0).toString());
                  JPanel myPanel = new JPanel();
                  myPanel.setLayout(new GridLayout(3,3,0,10));
                  myPanel.add(new JLabel("Username"));
                  myPanel.add(txtUsername);
                  myPanel.add(new JLabel("Jabatan"));
                  myPanel.add(cbjabatan);
                  myPanel.add(new JLabel("Password"));
                  myPanel.add(txtPassword);
                 
                  String sql = "SELECT * FROM login WHERE username= ? ;";
                  PreparedStatement stmt = conn.prepareStatement(sql);
                  stmt.setString(1, txtUsername.getText());
                  ResultSet rs = stmt.executeQuery();
                  int result = JOptionPane.showConfirmDialog(this, myPanel,
                          "Ubah Akun",
                          JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
                  
                  if(result==JOptionPane.OK_OPTION){
                      try{
                          rs.next();
                          String jb_tn;
                          if(cbjabatan.getSelectedIndex() == 0){
                          jb_tn = "admin";
                          }else{
                          jb_tn = "user";
                          }
                          String salt = rs.getString("salt");
                          String sql1 = "UPDATE login SET username= ? ,jb_tn= ? , password= ?, salt = ? WHERE username= ? ;";
                          PreparedStatement stmt1 = conn.prepareStatement(sql1);
                          stmt1.setString(1, txtUsername.getText());
                          stmt1.setString(2, jb_tn);
                          stmt1.setString(3, hashSHA256(salt+txtPassword.getText()));
                          stmt1.setString(4, salt);
                          stmt1.setString(5, selectedID);
                          stmt1.executeUpdate();
                          
                          loadTabel();
                          
                      } catch(SQLException e){
                          System.out.println(e.getMessage());
                      }
                  }   } catch (SQLException ex) {
                  Logger.getLogger(Manajemen.class.getName()).log(Level.SEVERE, null, ex);
              }
      } else {
              JOptionPane.showMessageDialog(this, "Tidak ada yang dipilih");
          }
    }//GEN-LAST:event_txtUbahActionPerformed

    private void txtHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHapusActionPerformed
        // TODO add your handling code here:
        if(tbTabel.isRowSelected(tbTabel.getSelectedRow())==true){
 selectedID =  (String)tbTabel.getValueAt(tbTabel.getSelectedRow(), 0);
            
            int result = JOptionPane.showConfirmDialog(this, 
                    "Kamu akan menghapus data " 
            + tbTabel.getValueAt(tbTabel.getSelectedRow(), 0).toString(),
                    "peringatan!",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
            
            if (result == JOptionPane.YES_OPTION){
                try{
                    String sql = "DELETE FROM login WHERE username= ? ;";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, selectedID);
                    stmt.executeUpdate();
                    loadTabel();
                } catch (SQLException e){
                    System.out.println(e.getMessage());
                }
            }
        } else{
            JOptionPane.showConfirmDialog(this, "tidak ada yang dipilih");
        }
    }//GEN-LAST:event_txtHapusActionPerformed

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
        // TODO add your handling code here:
         String cari = txtCari.getText();
         int l = cari.length();
         if ( (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9' ||evt.getKeyChar() >= 'a' && evt.getKeyChar() <= 'z') && l < 9||evt.getKeyChar() == KeyEvent.VK_ENTER || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_DELETE)
         {
            String teks = txtCari.getText();
            loadTabel(teks);
        } else{
             if( l == 9){
                 JOptionPane.showMessageDialog(this, "Username tidak valid");
                    }else
             {
                    JOptionPane.showMessageDialog(this, "Username terdiri dari angka dan huruf");
             }
         }
    }//GEN-LAST:event_txtCariKeyPressed
  public void loadTabel(String teks){
        String sql = "SELECT * FROM login WHERE username like '%"+ teks +"%'";
        Object[] kolom={"username"};
        DefaultTableModel dataModel = new DefaultTableModel(null,kolom);
        tbTabel.setModel(dataModel);
        tbTabel.getColumnModel().getColumn(0);
               
    try{
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
    
    while(rs.next()){
       
        String username = rs.getString("username");
        
        
        Object[] data={username};
        dataModel.addRow(data);
        
    }
} catch (SQLException e){
    System.out.println(e.getMessage());
}}                             
   
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
            java.util.logging.Logger.getLogger(Manajemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manajemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manajemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manajemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manajemen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbTabel;
    private javax.swing.JTextField txtCari;
    private javax.swing.JButton txtHapus;
    private javax.swing.JButton txtTambah;
    private javax.swing.JButton txtUbah;
    // End of variables declaration//GEN-END:variables
}
