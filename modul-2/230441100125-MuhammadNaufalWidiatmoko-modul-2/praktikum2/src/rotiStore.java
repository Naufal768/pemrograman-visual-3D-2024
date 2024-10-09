/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.JOptionPane;

public class rotiStore extends javax.swing.JFrame {

    double hargaRoti,hargaTopping;
    int jumlahPesanan;
    
    public rotiStore() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        croissant = new javax.swing.JRadioButton();
        rotisobek = new javax.swing.JRadioButton();
        rotisisir = new javax.swing.JRadioButton();
        cruffin = new javax.swing.JRadioButton();
        koreangarlic = new javax.swing.JRadioButton();
        rotigoreng = new javax.swing.JRadioButton();
        rotikukus = new javax.swing.JRadioButton();
        rotibakar = new javax.swing.JRadioButton();
        breadsticks = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        notopping = new javax.swing.JRadioButton();
        keju = new javax.swing.JRadioButton();
        almond = new javax.swing.JRadioButton();
        sosis = new javax.swing.JRadioButton();
        mayo = new javax.swing.JRadioButton();
        kacang = new javax.swing.JRadioButton();
        tambah = new javax.swing.JButton();
        jumlahpesanan = new javax.swing.JTextField();
        kurang = new javax.swing.JButton();
        hitung = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cash = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        kembali = new javax.swing.JTextField();
        reset = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 3, 36)); // NOI18N
        jLabel1.setText("ANEKA ROTI");

        jLabel2.setFont(new java.awt.Font("Snap ITC", 1, 24)); // NOI18N
        jLabel2.setText("~ Roti Store ~");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images.jpeg"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(51, 255, 51));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Menu :");

        buttonGroup1.add(croissant);
        croissant.setText("Croissant - Rp. 21.000");
        croissant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                croissantActionPerformed(evt);
            }
        });

        buttonGroup1.add(rotisobek);
        rotisobek.setText("Roti Sobek - Rp. 8.000");
        rotisobek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotisobekActionPerformed(evt);
            }
        });

        buttonGroup1.add(rotisisir);
        rotisisir.setText("Roti Sisir - Rp. 10.000");
        rotisisir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotisisirActionPerformed(evt);
            }
        });

        buttonGroup1.add(cruffin);
        cruffin.setText("Cruffin - Rp. 18.000");

        buttonGroup1.add(koreangarlic);
        koreangarlic.setText("Korean Garlic Bread Rp. 17.000");
        koreangarlic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                koreangarlicActionPerformed(evt);
            }
        });

        buttonGroup1.add(rotigoreng);
        rotigoreng.setText("Roti Tawar Goreng - Rp. 11.000");
        rotigoreng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotigorengActionPerformed(evt);
            }
        });

        buttonGroup1.add(rotikukus);
        rotikukus.setText("Roti Tawar Kukus - Rp. 15.000");
        rotikukus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotikukusActionPerformed(evt);
            }
        });

        buttonGroup1.add(rotibakar);
        rotibakar.setText("Roti Bakar - Rp. 17.000");

        buttonGroup1.add(breadsticks);
        breadsticks.setText("Breadsticks - Rp. 18.000");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Topping :");

        buttonGroup2.add(notopping);
        notopping.setText("No Topping - Rp. 0");

        buttonGroup2.add(keju);
        keju.setText("Keju - Rp. 5000");

        buttonGroup2.add(almond);
        almond.setText("Almond - Rp.7.000");
        almond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                almondActionPerformed(evt);
            }
        });

        buttonGroup2.add(sosis);
        sosis.setText("Sosis - Rp. 7.000");

        buttonGroup2.add(mayo);
        mayo.setText("Mayo - Rp. 6.000");

        buttonGroup2.add(kacang);
        kacang.setText("Kacang - Rp. 5.000");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(croissant)
                            .addComponent(rotisobek)
                            .addComponent(rotisisir)))
                    .addComponent(notopping)
                    .addComponent(keju))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(koreangarlic)
                    .addComponent(cruffin)
                    .addComponent(rotigoreng)
                    .addComponent(almond)
                    .addComponent(sosis))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(breadsticks)
                    .addComponent(rotibakar)
                    .addComponent(rotikukus)
                    .addComponent(mayo)
                    .addComponent(kacang))
                .addGap(58, 58, 58))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(croissant)
                    .addComponent(cruffin)
                    .addComponent(rotikukus))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotisobek)
                    .addComponent(koreangarlic)
                    .addComponent(rotibakar))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotisisir)
                    .addComponent(rotigoreng)
                    .addComponent(breadsticks))
                .addGap(36, 36, 36)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(notopping)
                    .addComponent(almond)
                    .addComponent(mayo))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keju)
                    .addComponent(sosis)
                    .addComponent(kacang))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        tambah.setText("+");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        kurang.setText("-");
        kurang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kurangActionPerformed(evt);
            }
        });

        hitung.setText("Hitung");
        hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungActionPerformed(evt);
            }
        });

        jLabel6.setText("Total :");

        jLabel7.setText("Cash :");

        cash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashActionPerformed(evt);
            }
        });

        jLabel8.setText("Kembali / Kurang :");

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        jTextField1.setText("Rp.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(166, 166, 166)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(reset)
                                .addGap(60, 60, 60))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jumlahpesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(kurang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(hitung, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cash, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)
                                        .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jumlahpesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(kurang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hitung, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addComponent(total))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(reset))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rotisobekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotisobekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rotisobekActionPerformed

    private void rotisisirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotisisirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rotisisirActionPerformed

    private void almondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_almondActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_almondActionPerformed

    private void croissantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_croissantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_croissantActionPerformed

    private void koreangarlicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_koreangarlicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_koreangarlicActionPerformed

    private void rotikukusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotikukusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rotikukusActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        jumlahpesanan.setText("1");
        cash.setText("");
        kembali.setText("");
        total.setText("");
//        jumlahPesanan = 1;
    }//GEN-LAST:event_resetActionPerformed

    private void hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungActionPerformed
        // TODO add your handling code here:
        if (!croissant.isSelected() && !rotisobek.isSelected() && !rotisisir.isSelected() && !cruffin.isSelected() && !koreangarlic.isSelected() && !rotigoreng.isSelected() &&
        !rotikukus.isSelected() && !rotibakar.isSelected() && !breadsticks.isSelected()) {
        JOptionPane.showMessageDialog(this, "Silakan pilih jenis roti terlebih dahulu!");
        return;
        }
        
        if (!notopping.isSelected() && !keju.isSelected() && !almond.isSelected() && !sosis.isSelected() && !mayo.isSelected() && !kacang.isSelected()) {
        JOptionPane.showMessageDialog(this, "Silakan pilih topping terlebih dahulu!");
        return;
        }
        
        if(croissant.isSelected()){
            hargaRoti = 21000;
        }else if(rotisobek.isSelected()){
            hargaRoti = 8000;
        }else if(rotisisir.isSelected()){
            hargaRoti = 10000;
        }else if(cruffin.isSelected()){
            hargaRoti = 18000;
        }else if(koreangarlic.isSelected()){
            hargaRoti = 17000;
        }else if(rotigoreng.isSelected()){
            hargaRoti = 11000;
        }else if(rotikukus.isSelected()){
            hargaRoti = 15000;
        }else if(rotibakar.isSelected()){
            hargaRoti = 17000;
        }else if(breadsticks.isSelected()){
            hargaRoti = 18000;
        }
        
        if(notopping.isSelected()){
            hargaTopping = 0;
        }else if(keju.isSelected()){
            hargaTopping = 5000;
        }else if(almond.isSelected()){
            hargaTopping = 7000;
        }else if(sosis.isSelected()){
            hargaTopping = 7000;
        }else if(mayo.isSelected()){
            hargaTopping = 6000;
        }else if(kacang.isSelected()){
            hargaTopping = 7000;
        }
        
        double totalHarga = (hargaRoti + hargaTopping)*jumlahPesanan;
        
        if(totalHarga > 100000){
            totalHarga*=0.95;
        }
        
//        total.setText(String.format("Rp","%.2f",totalHarga));
        total.setText(String.format("Rp %.2f", totalHarga));
        total.setEditable(false);
        
        // Validasi input uang
        if (cash.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan uang terlebih dahulu!");
            return;
        }

        // Menghitung kembalian
        try {
            double uangPembeli = Double.parseDouble(cash.getText());
            double kembalian = uangPembeli - totalHarga;

            // Menampilkan kembalian dengan 2 angka di belakang koma
            kembali.setText(String.format("Rp %.2f", kembalian));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan jumlah uang yang valid!");
        }
    }//GEN-LAST:event_hitungActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        jumlahPesanan++;
        jumlahpesanan.setText(String.valueOf(jumlahPesanan));
    }//GEN-LAST:event_tambahActionPerformed

    private void kurangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kurangActionPerformed
        // TODO add your handling code here:
        if (jumlahPesanan > 0){
            jumlahPesanan--;
            jumlahpesanan.setText(String.valueOf(jumlahPesanan));
        }
    }//GEN-LAST:event_kurangActionPerformed

    private void rotigorengActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotigorengActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rotigorengActionPerformed

    private void cashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cashActionPerformed

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
            java.util.logging.Logger.getLogger(rotiStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rotiStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rotiStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rotiStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rotiStore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton almond;
    private javax.swing.JRadioButton breadsticks;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField cash;
    private javax.swing.JRadioButton croissant;
    private javax.swing.JRadioButton cruffin;
    private javax.swing.JButton hitung;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jumlahpesanan;
    private javax.swing.JRadioButton kacang;
    private javax.swing.JRadioButton keju;
    private javax.swing.JTextField kembali;
    private javax.swing.JRadioButton koreangarlic;
    private javax.swing.JButton kurang;
    private javax.swing.JRadioButton mayo;
    private javax.swing.JRadioButton notopping;
    private javax.swing.JButton reset;
    private javax.swing.JRadioButton rotibakar;
    private javax.swing.JRadioButton rotigoreng;
    private javax.swing.JRadioButton rotikukus;
    private javax.swing.JRadioButton rotisisir;
    private javax.swing.JRadioButton rotisobek;
    private javax.swing.JRadioButton sosis;
    private javax.swing.JButton tambah;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}