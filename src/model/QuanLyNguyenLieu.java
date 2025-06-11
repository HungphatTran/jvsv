/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import stuffs.NguyenLieu;
import stuffs.NguyenLieuDAO;

/**
 *
 * @author ADMIN
 */
public class QuanLyNguyenLieu extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    NguyenLieuDAO nlDAO = new NguyenLieuDAO();
    int i = -1;

    /**
     * Creates new form QuanLyNguyenLieu
     */
    public QuanLyNguyenLieu() {
        initComponents();
        initTable();
        fillTable();
    }

    public void initTable() {
        String[] cols = new String[]{"MÃ NL", "Tên NL", "Ngày Nhập", "Giá Nhập", "Mã SP"};
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(cols);
        tblNL.setModel(tableModel);
    }

    public void fillTable() {
        tableModel.setRowCount(0);
        for (NguyenLieu nl : nlDAO.getAll()) {
            tableModel.addRow(nlDAO.getRow(nl));
        }
    }

    public void addNL() throws ParseException {
        String maNL = txtMaNL.getText();
        String ten = txtTenNL.getText();

        String ngayNhapStr = txtNgayNhap.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = sdf.parse(ngayNhapStr);
        java.sql.Date ngayNhap = new java.sql.Date(utilDate.getTime());

        double giaNhap = Double.parseDouble(txtGiaNhap.getText());
        String maSP = txtMaSP.getText();
        NguyenLieu nl = new NguyenLieu(maNL, ten, ngayNhap, giaNhap, maSP);

        int result = nlDAO.addNL(nl);
        if (result == 1) {
            fillTable();
            JOptionPane.showMessageDialog(this, "Thêm SP mới thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra!");
        }

    }

    public void showDetails() {
        i = tblNL.getSelectedRow();
        if (i >= 0) {
            NguyenLieu nl = nlDAO.getAll().get(i);

            txtMaNL.setText(nl.getMaNL());
            txtTenNL.setText(nl.getTenNL());
            txtNgayNhap.setText(nl.getNgayNhap().toString());
            txtGiaNhap.setText(String.valueOf(nl.getGiaNhap()));
            txtMaSP.setText(nl.getMaSP());
        }
    }

    public void suaNL() {
    i = tblNL.getSelectedRow();
    if (i >= 0) {
        int choice = JOptionPane.showConfirmDialog(this, "Bạn có thực sự muốn sửa?", 
                "Xác nhận", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            // Lấy bản ghi cũ từ danh sách
            NguyenLieu nlCu = nlDAO.getAll().get(i);
            String maCu = nlCu.getMaNL(); // MaNL cũ (primary key)

            // Lấy dữ liệu mới từ form
            String maNL = txtMaNL.getText();
            String tenNL = txtTenNL.getText();
            
            // Chuyển đổi ngày nhập
            String ngayNhapStr = txtNgayNhap.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = null;
            try {
                utilDate = sdf.parse(ngayNhapStr);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Ngày nhập không hợp lệ!");
                return;
            }
            java.sql.Date ngayNhap = new java.sql.Date(utilDate.getTime());
            
            double giaNhap = Double.parseDouble(txtGiaNhap.getText());
            String maSP = txtMaSP.getText();

            // Tạo đối tượng NguyenLieu mới
            NguyenLieu nlMoi = new NguyenLieu(maNL, tenNL, ngayNhap, giaNhap, maSP);

            // Gọi DAO để sửa
            int result = nlDAO.editNL(nlMoi, maCu);

            if (result == 1) {
                fillTable();
                JOptionPane.showMessageDialog(this, "Sửa nguyên liệu thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra!");
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Chọn nguyên liệu để sửa!");
    }
}


    public void xoaNL() {
    i = tblNL.getSelectedRow();
    if (i >= 0) {
        int choice = JOptionPane.showConfirmDialog(this, "Bạn có thực sự muốn xóa?",
                "Xác nhận", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            NguyenLieu nl = nlDAO.getAll().get(i);
            String maNL = nl.getMaNL(); // MaNL là String
            int result = nlDAO.deleteNL(maNL);
            if (result == 1) {
                fillTable();
                JOptionPane.showMessageDialog(this, "Xóa nguyên liệu thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra!");
            }
        }

    } else {
        JOptionPane.showMessageDialog(this, "Chọn nguyên liệu để xóa!");
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaNL = new javax.swing.JTextField();
        txtTenNL = new javax.swing.JTextField();
        txtNgayNhap = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        txtMaSP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnadd = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNL = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Quản Lý Cà Phê");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mã  Nguyên Liệu:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tên Nguyên Liệu:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Ngày Nhập:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Giá Nhập:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Mã Sản Phẩm:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("Quản Lý Nguyên Liệu");

        btnadd.setText("Thêm");
        btnadd.setMaximumSize(new java.awt.Dimension(90, 35));
        btnadd.setMinimumSize(new java.awt.Dimension(90, 35));
        btnadd.setPreferredSize(new java.awt.Dimension(90, 35));
        btnadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnaddMouseClicked(evt);
            }
        });
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnedit.setText("Sửa");
        btnedit.setMaximumSize(new java.awt.Dimension(90, 35));
        btnedit.setMinimumSize(new java.awt.Dimension(90, 35));
        btnedit.setPreferredSize(new java.awt.Dimension(90, 35));
        btnedit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneditMouseClicked(evt);
            }
        });
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btndelete.setText("Xóa");
        btndelete.setMaximumSize(new java.awt.Dimension(90, 35));
        btndelete.setMinimumSize(new java.awt.Dimension(90, 35));
        btndelete.setPreferredSize(new java.awt.Dimension(90, 35));
        btndelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndeleteMouseClicked(evt);
            }
        });

        tblNL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã NL", "Tên NL", "Ngày Nhập", "Giá Nhập", "Mã SP"
            }
        ));
        tblNL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNLMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaNL, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenNL, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 180, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMaNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btneditActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddMouseClicked
        try {
            // TODO add your handling code here:
            addNL();
        } catch (ParseException ex) {
            Logger.getLogger(QuanLyNguyenLieu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnaddMouseClicked

    private void btneditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditMouseClicked
        // TODO add your handling code here:
        suaNL();
    }//GEN-LAST:event_btneditMouseClicked

    private void btndeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseClicked
        // TODO add your handling code here:
        xoaNL();
    }//GEN-LAST:event_btndeleteMouseClicked

    private void tblNLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNLMouseClicked
        // TODO add your handling code here:
        showDetails();
    }//GEN-LAST:event_tblNLMouseClicked

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
            java.util.logging.Logger.getLogger(QuanLyNguyenLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyNguyenLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyNguyenLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyNguyenLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyNguyenLieu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnedit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNL;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMaNL;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtNgayNhap;
    private javax.swing.JTextField txtTenNL;
    // End of variables declaration//GEN-END:variables
}
