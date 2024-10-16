/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pembayaranSPP;
import javax.swing.JOptionPane;
/**
 *
 * @author LENOVO
 */
public class spp extends javax.swing.JFrame {
private boolean[] statusPembayaran = new boolean[12]; // Status pembayaran untuk tiap bulan

    private int totalPembayaranDihitung = 0;
    public spp() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        nama = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        namasiswa = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        sppbulanan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        button = new javax.swing.JPanel();
        btncek = new javax.swing.JButton();
        btnbayar = new javax.swing.JButton();
        btnhitung = new javax.swing.JButton();
        heading = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        jan = new javax.swing.JCheckBox();
        feb = new javax.swing.JCheckBox();
        mar = new javax.swing.JCheckBox();
        apr = new javax.swing.JCheckBox();
        mei = new javax.swing.JCheckBox();
        jun = new javax.swing.JCheckBox();
        jul = new javax.swing.JCheckBox();
        agu = new javax.swing.JCheckBox();
        sep = new javax.swing.JCheckBox();
        okto = new javax.swing.JCheckBox();
        nov = new javax.swing.JCheckBox();
        des = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 400));

        nama.setPreferredSize(new java.awt.Dimension(300, 150));
        nama.setRequestFocusEnabled(false);

        jLabel3.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel3.setText("Nama :");

        jLabel4.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel4.setText("SPP/Bulan :");

        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Swis721 Hv BT", 3, 18)); // NOI18N
        jLabel2.setText("Total :");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pembayaranSPP/a-removebg-preview.png"))); // NOI18N

        javax.swing.GroupLayout namaLayout = new javax.swing.GroupLayout(nama);
        nama.setLayout(namaLayout);
        namaLayout.setHorizontalGroup(
            namaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, namaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(namaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(namaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sppbulanan, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
            .addGroup(namaLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        namaLayout.setVerticalGroup(
            namaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(namaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(namaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sppbulanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(43, 43, 43)
                .addGroup(namaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(77, 77, 77))
        );

        getContentPane().add(nama, java.awt.BorderLayout.LINE_END);

        button.setBackground(new java.awt.Color(153, 204, 255));
        button.setPreferredSize(new java.awt.Dimension(234, 50));
        button.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 100, 15));

        btncek.setText("Cek");
        btncek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekActionPerformed(evt);
            }
        });
        button.add(btncek);

        btnbayar.setText("Bayar");
        btnbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbayarActionPerformed(evt);
            }
        });
        button.add(btnbayar);

        btnhitung.setText("Hitung");
        btnhitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhitungActionPerformed(evt);
            }
        });
        button.add(btnhitung);

        getContentPane().add(button, java.awt.BorderLayout.PAGE_END);

        heading.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Square721 BT", 1, 36)); // NOI18N
        jLabel1.setText("PEMBAYARAN SPP SMAN 1 KARANGBINANGUN");
        heading.add(jLabel1);

        getContentPane().add(heading, java.awt.BorderLayout.PAGE_START);

        menu.setBackground(new java.awt.Color(204, 255, 204));
        menu.setAlignmentX(0.1F);
        menu.setAlignmentY(0.1F);
        menu.setPreferredSize(new java.awt.Dimension(300, 400));
        menu.setLayout(new java.awt.GridLayout(3, 4, 2, 2));

        jan.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jan.setText("Januari");
        jan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                janActionPerformed(evt);
            }
        });
        menu.add(jan);

        feb.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        feb.setText("Februari");
        menu.add(feb);

        mar.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        mar.setText("Maret");
        menu.add(mar);

        apr.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        apr.setText("April");
        menu.add(apr);

        mei.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        mei.setText("Mei");
        mei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meiActionPerformed(evt);
            }
        });
        menu.add(mei);

        jun.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jun.setText("Juni");
        menu.add(jun);

        jul.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jul.setText("Juli");
        menu.add(jul);

        agu.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        agu.setText("Agustus");
        menu.add(agu);

        sep.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        sep.setText("September");
        menu.add(sep);

        okto.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        okto.setText("Oktober");
        menu.add(okto);

        nov.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        nov.setText("November");
        menu.add(nov);

        des.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        des.setText("Desember");
        menu.add(des);

        getContentPane().add(menu, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void janActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_janActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_janActionPerformed

    private void meiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meiActionPerformed

    private void btnbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbayarActionPerformed
        // TODO add your handling code here:
        boolean terpilih = false;

    // Periksa apakah user telah memilih bulan yang ingin dibayar
    if (jan.isSelected()) {
        statusPembayaran[0] = true;
        terpilih = true;
    }
    if (feb.isSelected()) {
        statusPembayaran[1] = true;
        terpilih = true;
    }
    if (mar.isSelected()) {
        statusPembayaran[2] = true;
        terpilih = true;
    }
    if (apr.isSelected()) {
        statusPembayaran[3] = true;
        terpilih = true;
    }
    if (mei.isSelected()) {
        statusPembayaran[4] = true;
        terpilih = true;
    }
    if (jun.isSelected()) {
        statusPembayaran[5] = true;
        terpilih = true;
    }
    if (jul.isSelected()) {
        statusPembayaran[6] = true;
        terpilih = true;
    }
    if (agu.isSelected()) {
        statusPembayaran[7] = true;
        terpilih = true;
    }
    if (sep.isSelected()) {
        statusPembayaran[8] = true;
        terpilih = true;
    }
    if (okto.isSelected()) {
        statusPembayaran[9] = true;
        terpilih = true;
    }
    if (nov.isSelected()) {
        statusPembayaran[10] = true;
        terpilih = true;
    }
    if (des.isSelected()) {
        statusPembayaran[11] = true;
        terpilih = true;
    }

    // Periksa apakah ada bulan yang dipilih dan apakah total pembayaran sudah dihitung
    if (terpilih) {
        if (totalPembayaranDihitung > 0) {
            JOptionPane.showMessageDialog(this, "Pembayaran berhasil!");
        } else {
            JOptionPane.showMessageDialog(this, "Silakan hitung total pembayaran sebelum membayar.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Pilih minimal satu bulan untuk melakukan pembayaran.");
    }

    }//GEN-LAST:event_btnbayarActionPerformed

    private void btnhitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhitungActionPerformed
        // TODO add your handling code here:
        int sppPerBulan = Integer.parseInt(sppbulanan.getText());
        totalPembayaranDihitung = 0;  // Reset total pembayaran dihitung setiap kali tombol hitung ditekan

        // Hitung hanya untuk bulan yang belum dibayar
        if (jan.isSelected() && !statusPembayaran[0]) totalPembayaranDihitung += sppPerBulan;
        if (feb.isSelected() && !statusPembayaran[1]) totalPembayaranDihitung += sppPerBulan;
        if (mar.isSelected() && !statusPembayaran[2]) totalPembayaranDihitung += sppPerBulan;
        if (apr.isSelected() && !statusPembayaran[3]) totalPembayaranDihitung += sppPerBulan;
        if (mei.isSelected() && !statusPembayaran[4]) totalPembayaranDihitung += sppPerBulan;
        if (jun.isSelected() && !statusPembayaran[5]) totalPembayaranDihitung += sppPerBulan;
        if (jul.isSelected() && !statusPembayaran[6]) totalPembayaranDihitung += sppPerBulan;
        if (agu.isSelected() && !statusPembayaran[7]) totalPembayaranDihitung += sppPerBulan;
        if (sep.isSelected() && !statusPembayaran[8]) totalPembayaranDihitung += sppPerBulan;
        if (okto.isSelected() && !statusPembayaran[9]) totalPembayaranDihitung += sppPerBulan;
        if (nov.isSelected() && !statusPembayaran[10]) totalPembayaranDihitung += sppPerBulan;
        if (des.isSelected() && !statusPembayaran[11]) totalPembayaranDihitung += sppPerBulan;

        // Tampilkan total pembayaran di field "total"
        total.setText(String.valueOf(totalPembayaranDihitung));
        total.setEditable(false);
    }//GEN-LAST:event_btnhitungActionPerformed

    private void btncekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekActionPerformed
        // TODO add your handling code here:
//        new cek(statusPembayaran).setVisible(true);
        statusPembayaran[0] = jan.isSelected();  // contoh jika ada checkbox Januari
        statusPembayaran[1] = feb.isSelected(); // contoh jika ada checkbox Februari
        statusPembayaran[2] = mar.isSelected();
        statusPembayaran[3] = apr.isSelected();
        statusPembayaran[4] = mei.isSelected();
        statusPembayaran[5] = jun.isSelected();
        statusPembayaran[6] = jul.isSelected();
        statusPembayaran[7] = agu.isSelected();
        statusPembayaran[8] = sep.isSelected();
        statusPembayaran[9] = okto.isSelected();
        statusPembayaran[10] = nov.isSelected();
        statusPembayaran[11] = des.isSelected();
        
        cek Cek = new cek(statusPembayaran);
        Cek.setVisible(true);
        this.dispose(); // Tutup JFrame1 jika diinginkan
    }//GEN-LAST:event_btncekActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

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
            java.util.logging.Logger.getLogger(spp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(spp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(spp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(spp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new spp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox agu;
    private javax.swing.JCheckBox apr;
    private javax.swing.JButton btnbayar;
    private javax.swing.JButton btncek;
    private javax.swing.JButton btnhitung;
    private javax.swing.JPanel button;
    private javax.swing.JCheckBox des;
    private javax.swing.JCheckBox feb;
    private javax.swing.JPanel heading;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JCheckBox jan;
    private javax.swing.JCheckBox jul;
    private javax.swing.JCheckBox jun;
    private javax.swing.JCheckBox mar;
    private javax.swing.JCheckBox mei;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel nama;
    private javax.swing.JTextField namasiswa;
    private javax.swing.JCheckBox nov;
    private javax.swing.JCheckBox okto;
    private javax.swing.JCheckBox sep;
    private javax.swing.JTextField sppbulanan;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
