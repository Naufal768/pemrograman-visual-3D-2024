/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package modul_5;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class desain5 extends javax.swing.JFrame {
    Connection conn;
    private DefaultTableModel modelKaryawan;
    private DefaultTableModel modelProyek;
    private DefaultTableModel modelTransaksi;
  
    /**
     * Creates new form desain5
     */
    public desain5() {
        initComponents();
        tnama.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { checkButtons(); }
        public void removeUpdate(DocumentEvent e) { checkButtons(); }
        public void changedUpdate(DocumentEvent e) { checkButtons(); }
    });

    tjabatan.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { checkButtons(); }
        public void removeUpdate(DocumentEvent e) { checkButtons(); }
        public void changedUpdate(DocumentEvent e) { checkButtons(); }
    });

    tdepartemen.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { checkButtons(); }
        public void removeUpdate(DocumentEvent e) { checkButtons(); }
        public void changedUpdate(DocumentEvent e) { checkButtons(); }
    });
        
        // Menambahkan DocumentListener setelah inisialisasi komponen
        tid.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { checkField(); }
            public void removeUpdate(DocumentEvent e) { checkField(); }
            public void changedUpdate(DocumentEvent e) { checkField(); }
        });
        
    txt2.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { checkButtons(); }
        public void removeUpdate(DocumentEvent e) { checkButtons(); }
        public void changedUpdate(DocumentEvent e) { checkButtons(); }
    });

    txt3.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { checkButtons(); }
        public void removeUpdate(DocumentEvent e) { checkButtons(); }
        public void changedUpdate(DocumentEvent e) { checkButtons(); }
    });
        
        // Menambahkan DocumentListener setelah inisialisasi komponen
        txt1.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { checkField(); }
            public void removeUpdate(DocumentEvent e) { checkField(); }
            public void changedUpdate(DocumentEvent e) { checkField(); }
        });
        
        conn = koneksi.getConnection();
        initTableModels();
        loadDataKaryawan();
        loadDataProyek();
        loadDataTransaksi();
        loadComboBoxKaryawan();
        loadComboBoxProyek();
    }
      private void initTableModels() {
        // Model untuk tabel karyawan
        modelKaryawan = new DefaultTableModel(new String[] { "ID", "Nama", "Jabatan", "Departemen" }, 0);
        jTable1.setModel(modelKaryawan);

        // Model untuk tabel proyek
        modelProyek = new DefaultTableModel(new String[] { "ID", "Nama Proyek", "Durasi Pengerjaan" }, 0);
        jTable4.setModel(modelProyek);
        
        modelTransaksi = new DefaultTableModel(
        new String[]{"Nama Karyawan", "Nama Proyek", "Durasi (mingguan)", "ID Karyawan", "ID Proyek"}, 
        0
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Membuat tabel tidak bisa diedit
        }
    };
    jTable3.setModel(modelTransaksi);
    
    // Sembunyikan kolom ID (opsional)
    jTable3.getColumnModel().getColumn(3).setMinWidth(0);
    jTable3.getColumnModel().getColumn(3).setMaxWidth(0);
    jTable3.getColumnModel().getColumn(4).setMinWidth(0);
    jTable3.getColumnModel().getColumn(4).setMaxWidth(0);
}

    private void loadDataKaryawan() {
        modelKaryawan.setRowCount(0);
        try {
            String sql = "SELECT * FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelKaryawan.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("jabatan"),
                    rs.getString("departemen")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error Load Data Karyawan: " + e.getMessage());
        }
    }

    private void loadDataProyek() {
        modelProyek.setRowCount(0);
        try {
            String sql = "SELECT * FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelProyek.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nama_proyek"),
                    rs.getString("durasi_pengerjaan")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error Load Data Proyek: " + e.getMessage());
        }
    }
  private void loadDataTransaksi() {
    modelTransaksi.setRowCount(0);
    try {
        String sql = "SELECT k.nama as nama_karyawan, p.nama_proyek, " +
                     "t.durasi, t.id_karyawan, t.id_proyek " +
                     "FROM transaksi t " +
                     "JOIN karyawan k ON t.id_karyawan = k.id " +
                     "JOIN proyek p ON t.id_proyek = p.id " +
                     "ORDER BY k.nama, p.nama_proyek";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            modelTransaksi.addRow(new Object[]{
                rs.getString("nama_karyawan"),
                rs.getString("nama_proyek"),
                rs.getString("durasi"),
                rs.getInt("id_karyawan"),
                rs.getInt("id_proyek")
            });
        }
    } catch (SQLException e) {
        System.out.println("Error Load Data Transaksi: " + e.getMessage());
        JOptionPane.showMessageDialog(null, "Gagal memuat data transaksi: " + e.getMessage());
    }
}

    private void tambahKaryawan() {
    
    if (tnama.getText().isEmpty() || tjabatan.getText().isEmpty() || tdepartemen.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Masukkan data lengkap.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; 
    }
    
    try {
        String sql = "INSERT INTO karyawan (nama, jabatan, departemen) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, tnama.getText());
        ps.setString(2, tjabatan.getText());
        ps.setString(3, tdepartemen.getText());
        ps.executeUpdate();
        
        // Get generated ID
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            tid.setText(String.valueOf(rs.getInt(1)));
        }
        
        JOptionPane.showMessageDialog(this, "Data Karyawan berhasil ditambahkan.");
        loadDataKaryawan();
        loadComboBoxKaryawan();
    } catch (SQLException e) {
        System.out.println("Error Tambah Data Karyawan: " + e.getMessage());
    }
}


   private void updateKaryawan() {
    try {
        int id = Integer.parseInt(tid.getText()); 
        String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tnama.getText());
        ps.setString(2, tjabatan.getText());
        ps.setString(3, tdepartemen.getText());
        ps.setInt(4, id);
        
        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Data Karyawan berhasil diupdate.");
            loadDataKaryawan();
            loadComboBoxKaryawan();
        } else {
            JOptionPane.showMessageDialog(this, "Data Karyawan dengan ID tersebut tidak ditemukan.");
        }
    } catch (SQLException e) {
        System.out.println("Error Update Data Karyawan: " + e.getMessage());
    }
}


   private void hapusKaryawan() {
    try {
        int id = Integer.parseInt(tid.getText());
        
        // Mulai transaksi
        conn.setAutoCommit(false);
        
        try {
            // Hapus data di tabel karyawan
            String sql = "DELETE FROM karyawan WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                // Reset auto increment dan reorder ID
                String resetSql = "SET @count = 0";
                String updateSql = "UPDATE karyawan SET id = @count:= @count + 1";
                String alterSql = "ALTER TABLE karyawan AUTO_INCREMENT = 1";
                
                Statement stmt = conn.createStatement();
                stmt.execute(resetSql);
                stmt.execute(updateSql);
                stmt.execute(alterSql);
                
                // Commit transaksi
                conn.commit();
                
                JOptionPane.showMessageDialog(this, "Data Karyawan berhasil dihapus.");
                loadDataKaryawan();
                loadDataTransaksi();
                loadComboBoxKaryawan();
            } else {
                // Rollback jika tidak ada data yang dihapus
                conn.rollback();
                JOptionPane.showMessageDialog(this, "Data Karyawan dengan ID tersebut tidak ditemukan.");
            }
            
        } catch (SQLException ex) {
            // Rollback jika terjadi error
            conn.rollback();
            throw ex;
        } finally {
            // Kembalikan auto commit ke true
            conn.setAutoCommit(true);
        }
        
    } catch (SQLException e) {
        System.out.println("Error Hapus Data Karyawan: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID tidak valid");
    }
}



   private void tambahProyek() {
    
    if (txt2.getText().isEmpty() || txt3.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Masukkan data proyek lengkap.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; 
    }
    
    try {
        String sql = "INSERT INTO proyek (nama_proyek, durasi_pengerjaan) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, txt2.getText());
        ps.setString(2, txt3.getText());
        ps.executeUpdate();
        
        // Get generated ID
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            txt1.setText(String.valueOf(rs.getInt(1)));
        }
        
        JOptionPane.showMessageDialog(this, "Data Proyek berhasil ditambahkan.");
        loadDataProyek();
        loadComboBoxProyek();
    } catch (SQLException e) {
        System.out.println("Error Tambah Data Proyek: " + e.getMessage());
    }
}

    private void updateProyek() {
    try {
        int id = Integer.parseInt(txt1.getText()); // Ambil ID dari JTextField
        String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, txt2.getText());  // Ambil Nama Proyek dari JTextField
        ps.setString(2, txt3.getText());  // Ambil Durasi Pengerjaan dari JTextField
        ps.setInt(3, id);

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Data Proyek berhasil diupdate.");
            loadDataProyek();
            loadComboBoxProyek();
        } else {
            JOptionPane.showMessageDialog(this, "Data Proyek dengan ID tersebut tidak ditemukan.");
        }
    } catch (SQLException e) {
        System.out.println("Error Update Data Proyek: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Gagal mengupdate data: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID tidak valid.");
    }
}

    private void hapusProyek() {
    try {
        int id = Integer.parseInt(txt1.getText());
        
        // Mulai transaksi
        conn.setAutoCommit(false);
        
        try {
            // Hapus data di tabel proyek
            String sql = "DELETE FROM proyek WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                // Reset auto increment dan reorder ID
                String resetSql = "SET @count = 0";
                String updateSql = "UPDATE proyek SET id = @count:= @count + 1";
                String alterSql = "ALTER TABLE proyek AUTO_INCREMENT = 1";
                
                Statement stmt = conn.createStatement();
                stmt.execute(resetSql);
                stmt.execute(updateSql);
                stmt.execute(alterSql);
                
                // Commit transaksi
                conn.commit();
                
                JOptionPane.showMessageDialog(this, "Data Proyek berhasil dihapus.");
                loadDataProyek();
                loadDataTransaksi();
                loadComboBoxProyek();
            } else {
                // Rollback jika tidak ada data yang dihapus
                conn.rollback();
                JOptionPane.showMessageDialog(this, "Data Proyek dengan ID tersebut tidak ditemukan.");
            }
            
        } catch (SQLException ex) {
            // Rollback jika terjadi error
            conn.rollback();
            throw ex;
        } finally {
            // Kembalikan auto commit ke true
            conn.setAutoCommit(true);
        }
        
    } catch (SQLException e) {
        System.out.println("Error Hapus Data Proyek: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID tidak valid");
    }
}

    private void loadComboBoxKaryawan() {
    cbkaryawan.removeAllItems();
    try {
        String sql = "SELECT id, nama FROM karyawan";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String tampilan = String.format("%d - %s", 
                rs.getInt("id"),
                rs.getString("nama")
            );
            cbkaryawan.addItem(tampilan);
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Memuat Data Karyawan: " + e.getMessage());
    }
}
    
   private void loadComboBoxProyek() {
    cbproyek.removeAllItems();
    try {
        String sql = "SELECT id, nama_proyek FROM proyek";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String tampilan = String.format("%d - %s", 
                rs.getInt("id"),
                rs.getString("nama_proyek")
            );
            cbproyek.addItem(tampilan);
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Memuat Data Proyek: " + e.getMessage());
    }
}
   private int getSelectedId(String comboBoxText) {
    if (comboBoxText == null || comboBoxText.isEmpty()) return -1;
    try {
        // Format combo box: "1 - Nama"
        return Integer.parseInt(comboBoxText.split(" - ")[0]);
    } catch (Exception e) {
        System.out.println("Error parsing ID: " + e.getMessage());
        return -1;
    }
}
    
   private void tambahTransaksi() {
    try {
        if (cbkaryawan.getSelectedItem() == null || cbproyek.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Pilih karyawan dan proyek terlebih dahulu");
            return;
        }
        
        String selectedKaryawan = cbkaryawan.getSelectedItem().toString();
        String selectedProyek = cbproyek.getSelectedItem().toString();
        
        int idKaryawan = getSelectedId(selectedKaryawan);
        int idProyek = getSelectedId(selectedProyek);
        
        if (idKaryawan == -1 || idProyek == -1) {
            JOptionPane.showMessageDialog(null, "ID Karyawan atau ID Proyek tidak valid");
            return;
        }
        // Menghapus pengecekan apakah kombinasi sudah ada
        // Jika belum ada, tambahkan data baru
        String sql ="INSERT INTO transaksi (id_karyawan, id_proyek, durasi) VALUES (?, ?, ?)";
 
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idKaryawan);
        ps.setInt(2, idProyek);
        ps.setString(3, txtperan.getText().trim());
        
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Transaksi berhasil ditambahkan");
        loadDataTransaksi();
        clearTransaksiFields();
        
    } catch (SQLException e) {
        System.out.println("Error Tambah Transaksi: " + e.getMessage());
        JOptionPane.showMessageDialog(null, "Gagal menambah data: " + e.getMessage());
    }
}

// Tambahkan method untuk membersihkan field
private void clearTransaksiFields() {
    txtperan.setText("");
    cbkaryawan.setSelectedIndex(0);
    cbproyek.setSelectedIndex(0);
} 

   private void updateTransaksi() {
    try {
        String sql = "UPDATE transaksi SET durasi = ? WHERE id_karyawan = ? AND id_proyek = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        int idKaryawan = getSelectedId(cbkaryawan.getSelectedItem().toString());
        int idProyek = getSelectedId(cbproyek.getSelectedItem().toString());
        
        ps.setString(1, txtperan.getText());
        ps.setInt(2, idKaryawan);
        ps.setInt(3, idProyek);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Transaksi berhasil diperbarui");
        loadDataTransaksi();
    } catch (SQLException e) {
        System.out.println("Kesalahan Memperbarui Data Transaksi: " + e.getMessage());
    }
}

   private void hapusTransaksi() {
    try {
        // Memastikan pengguna sudah memilih karyawan dan proyek dari ComboBox
        if (cbkaryawan.getSelectedItem() == null || cbproyek.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Pilih karyawan dan proyek terlebih dahulu");
            return;
        }

        // Mendapatkan ID karyawan dan proyek dari ComboBox
        int idKaryawan = getSelectedId(cbkaryawan.getSelectedItem().toString());
        int idProyek = getSelectedId(cbproyek.getSelectedItem().toString());

        int confirm = JOptionPane.showConfirmDialog(this,
                "Apakah Anda yakin ingin menghapus data transaksi ini?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idKaryawan);
            ps.setInt(2, idProyek);

            int result = ps.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Data Transaksi berhasil dihapus");
                loadDataTransaksi();
                clearTransaksiFields();  // Membersihkan field setelah menghapus data
            } else {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan atau sudah terhapus");
            }
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Menghapus Data Transaksi: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
}
   

private void checkButtons() {
    int filledFields = 0;
    boolean isTidFilled = !tid.getText().trim().isEmpty();
    boolean isTxt1Filled = !txt1.getText().trim().isEmpty();
    if (!tnama.getText().trim().isEmpty()) filledFields++;
    if (!tjabatan.getText().trim().isEmpty()) filledFields++;
    if (!tdepartemen.getText().trim().isEmpty()) filledFields++;
    if (!txt2.getText().trim().isEmpty()) filledFields++;
    if (!txt3.getText().trim().isEmpty()) filledFields++;

    btnupdate.setEnabled(filledFields >= 1 && isTidFilled);
    btnupdate2.setEnabled(filledFields >= 1 && isTxt1Filled);
    btnhapus.setEnabled(!tid.getText().trim().isEmpty());
    btnhapus1.setEnabled(!txt1.getText().trim().isEmpty());
}

private void checkField() {
        btntambah.setEnabled(tid.getText().trim().isEmpty());
        btntambah1.setEnabled(txt1.getText().trim().isEmpty());
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btntambah = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tnama = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tjabatan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tdepartemen = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btntambah1 = new javax.swing.JButton();
        btnupdate2 = new javax.swing.JButton();
        btnhapus1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt3 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        cbkaryawan = new javax.swing.JComboBox<>();
        cbproyek = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        btnsimpan3 = new javax.swing.JButton();
        btnhapus3 = new javax.swing.JButton();
        btnupdate3 = new javax.swing.JButton();
        txtperan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 420, 204));

        jPanel5.setBackground(new java.awt.Color(0, 102, 255));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        btntambah.setText("tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        jPanel5.add(btntambah, gridBagConstraints);

        btnupdate.setText("update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel5.add(btnupdate, new java.awt.GridBagConstraints());

        btnhapus.setText("hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        jPanel5.add(btnhapus, gridBagConstraints);

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 240, 40));

        jPanel8.setBackground(new java.awt.Color(0, 102, 255));
        jPanel8.setLayout(null);

        jLabel4.setText("ID :");
        jPanel8.add(jLabel4);
        jLabel4.setBounds(16, 15, 30, 16);

        tid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidActionPerformed(evt);
            }
        });
        jPanel8.add(tid);
        tid.setBounds(60, 10, 71, 30);

        jLabel5.setText("Nama : ");
        jPanel8.add(jLabel5);
        jLabel5.setBounds(16, 66, 50, 16);

        tnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnamaActionPerformed(evt);
            }
        });
        jPanel8.add(tnama);
        tnama.setBounds(60, 60, 71, 30);

        jLabel6.setText("Jabatan :");
        jPanel8.add(jLabel6);
        jLabel6.setBounds(150, 10, 60, 30);

        tjabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tjabatanActionPerformed(evt);
            }
        });
        jPanel8.add(tjabatan);
        tjabatan.setBounds(220, 10, 71, 30);

        jLabel7.setText("Departemen :");
        jPanel8.add(jLabel7);
        jLabel7.setBounds(140, 60, 80, 30);

        tdepartemen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tdepartemenActionPerformed(evt);
            }
        });
        jPanel8.add(tdepartemen);
        tdepartemen.setBounds(220, 60, 71, 30);

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 290, 100));

        jTabbedPane1.addTab("Karyawan", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable4);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 420, 204));

        jPanel6.setBackground(new java.awt.Color(0, 153, 255));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        btntambah1.setText("Tambah");
        btntambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambah1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel6.add(btntambah1, gridBagConstraints);

        btnupdate2.setText("Update");
        btnupdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdate2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(13, 13, 13, 13);
        jPanel6.add(btnupdate2, gridBagConstraints);

        btnhapus1.setText("Hapus");
        btnhapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapus1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(14, 14, 14, 14);
        jPanel6.add(btnhapus1, gridBagConstraints);

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 280, 40));

        jPanel7.setBackground(new java.awt.Color(0, 153, 255));
        jPanel7.setLayout(null);

        jLabel1.setText("id");
        jPanel7.add(jLabel1);
        jLabel1.setBounds(40, 10, 37, 16);
        jPanel7.add(txt1);
        txt1.setBounds(110, 10, 120, 22);

        jLabel2.setText("nama proyek");
        jPanel7.add(jLabel2);
        jLabel2.setBounds(10, 50, 69, 16);
        jPanel7.add(txt2);
        txt2.setBounds(110, 50, 120, 30);

        jLabel3.setText("durasi pengerjaan");
        jPanel7.add(jLabel3);
        jLabel3.setBounds(0, 100, 100, 16);
        jPanel7.add(txt3);
        txt3.setBounds(110, 100, 120, 30);

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 250, 140));

        jTabbedPane1.addTab("Proyek", jPanel3);

        jPanel4.setBackground(new java.awt.Color(51, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 23, 440, 204));

        jPanel9.setBackground(new java.awt.Color(102, 255, 102));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.add(cbkaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 230, -1));

        cbproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbproyekActionPerformed(evt);
            }
        });
        jPanel9.add(cbproyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 230, -1));

        jPanel4.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 280, 100));

        jPanel10.setLayout(new java.awt.GridLayout(1, 0));

        btnsimpan3.setText("simpan");
        btnsimpan3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpan3ActionPerformed(evt);
            }
        });
        jPanel10.add(btnsimpan3);

        btnhapus3.setText("hapus");
        btnhapus3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapus3ActionPerformed(evt);
            }
        });
        jPanel10.add(btnhapus3);

        btnupdate3.setText("update");
        btnupdate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdate3ActionPerformed(evt);
            }
        });
        jPanel10.add(btnupdate3);

        jPanel4.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 250, 40));
        jPanel4.add(txtperan, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 140, -1));

        jLabel8.setText("Durasi : ");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, -1, -1));

        jTabbedPane1.addTab("Transaksi", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 740, 280));

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel9.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("APLIKASI MANAJEMEN KARYAWAN DAN PROYEK");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel9)
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel9)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        // TODO add your handling code here:
          tambahKaryawan();
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
         updateKaryawan();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
         hapusKaryawan();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnhapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapus1ActionPerformed
        // TODO add your handling code here:
        hapusProyek();
    }//GEN-LAST:event_btnhapus1ActionPerformed

    private void btntambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambah1ActionPerformed
        // TODO add your handling code here:
              tambahProyek();  
        
    }//GEN-LAST:event_btntambah1ActionPerformed

    private void btnupdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdate2ActionPerformed
        // TODO add your handling code here:
          updateProyek();
    }//GEN-LAST:event_btnupdate2ActionPerformed

    private void tnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamaActionPerformed

    private void tjabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tjabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tjabatanActionPerformed

    private void tdepartemenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tdepartemenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tdepartemenActionPerformed

    private void btnsimpan3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpan3ActionPerformed
        // TODO add your handling code here:
       tambahTransaksi();
    }//GEN-LAST:event_btnsimpan3ActionPerformed

    private void btnhapus3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapus3ActionPerformed
        // TODO add your handling code here:
        hapusTransaksi();
    }//GEN-LAST:event_btnhapus3ActionPerformed

    private void btnupdate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdate3ActionPerformed
        // TODO add your handling code here:
           updateTransaksi();
    }//GEN-LAST:event_btnupdate3ActionPerformed

    private void tidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tidActionPerformed

    private void cbproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbproyekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbproyekActionPerformed

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
            java.util.logging.Logger.getLogger(desain5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(desain5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(desain5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(desain5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new desain5().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnhapus1;
    private javax.swing.JButton btnhapus3;
    private javax.swing.JButton btnsimpan3;
    private javax.swing.JButton btntambah;
    private javax.swing.JButton btntambah1;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton btnupdate2;
    private javax.swing.JButton btnupdate3;
    private javax.swing.JComboBox<String> cbkaryawan;
    private javax.swing.JComboBox<String> cbproyek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField tdepartemen;
    private javax.swing.JTextField tid;
    private javax.swing.JTextField tjabatan;
    private javax.swing.JTextField tnama;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    private javax.swing.JTextField txtperan;
    // End of variables declaration//GEN-END:variables
}