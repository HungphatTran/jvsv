package view;

import javax.swing.*;

public class TrangChuNV extends JFrame {
    private JButton btnQLBan, btnQLDonGoiMon, btnQuanLyMenu, btnDangXuat;

    public TrangChuNV() {
        setTitle("Trang chủ nhân viên");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblTitle = new JLabel("Trang chủ nhân viên");
        lblTitle.setBounds(120, 30, 200, 30);
        add(lblTitle);

        btnQLBan = new JButton("Quản lý bàn");
        btnQLBan.setBounds(120, 80, 150, 30);
        add(btnQLBan);

        btnQLDonGoiMon = new JButton("Quản lý đơn gọi món");
        btnQLDonGoiMon.setBounds(120, 120, 150, 30);
        add(btnQLDonGoiMon);

        btnQuanLyMenu = new JButton("Quản lý menu");
        btnQuanLyMenu.setBounds(120, 160, 150, 30);
        add(btnQuanLyMenu);

        // Nút Đăng xuất
        btnDangXuat = new JButton("Đăng xuất");
        btnDangXuat.setBounds(120, 210, 150, 30);
        add(btnDangXuat);

        // Sự kiện mở các JFrame chức năng
        btnQLBan.addActionListener(e -> new QLBan().setVisible(true));
        btnQLDonGoiMon.addActionListener(e -> new QLDonGoiMon().setVisible(true));
        btnQuanLyMenu.addActionListener(e -> new QuanLyCF().setVisible(true));
        btnDangXuat.addActionListener(e -> {
            new LoginRegisterFrame().setVisible(true);
            this.dispose();
        });
    }

    // ... giữ nguyên phần initComponents() của NetBeans nếu có, nhưng KHÔNG gọi đến nó ...
    // Hàm initComponents() của NetBeans vẫn giữ nguyên, nhưng KHÔNG gọi đến nó!
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    // ... code NetBeans sinh ra ...
    // </editor-fold>


      
      
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
            java.util.logging.Logger.getLogger(TrangChuNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChuNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChuNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChuNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChuNV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
