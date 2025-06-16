package view;

import javax.swing.*;

public class TrangChuQL extends JFrame {
    public TrangChuQL() {
        setTitle("Trang chủ quản lý");
        setSize(400, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblTitle = new JLabel("Trang chủ quản lý");
        lblTitle.setBounds(120, 30, 200, 30);
        add(lblTitle);

        // Nút Quản lý nguyên liệu
        JButton btnQLNguyenLieu = new JButton("Quản lý nguyên liệu");
        btnQLNguyenLieu.setBounds(120, 100, 150, 30);
        add(btnQLNguyenLieu);
        btnQLNguyenLieu.addActionListener(e -> new QuanLyNguyenLieu().setVisible(true));

        // Nút Quản lý khách hàng
        JButton btnQLKhachHang = new JButton("Quản lý khách hàng");
        btnQLKhachHang.setBounds(120, 150, 150, 30);
        add(btnQLKhachHang);
        btnQLKhachHang.addActionListener(e -> new QLKH().setVisible(true));

        // Nút Quản lý doanh thu
        JButton btnQLDoanhThu = new JButton("Quản lý doanh thu");
        btnQLDoanhThu.setBounds(120, 200, 150, 30);
        add(btnQLDoanhThu);
        btnQLDoanhThu.addActionListener(e -> new QLDT().setVisible(true));

        // Nút Quản lý nhân viên
        JButton btnQLNhanVien = new JButton("Quản lý nhân viên");
        btnQLNhanVien.setBounds(120, 250, 150, 30);
        add(btnQLNhanVien);
        btnQLNhanVien.addActionListener(e -> new QLNV().setVisible(true));

        // Nút Đăng xuất
        JButton btnDangXuat = new JButton("Đăng xuất");
        btnDangXuat.setBounds(120, 320, 150, 30);
        add(btnDangXuat);
        btnDangXuat.addActionListener(e -> {
            new LoginRegisterFrame().setVisible(true);
            this.dispose();
        });
    }

    // ... giữ nguyên phần initComponents() của NetBeans nếu có, nhưng KHÔNG gọi đến nó ...


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TrangChuQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChuQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChuQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChuQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChuQL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
