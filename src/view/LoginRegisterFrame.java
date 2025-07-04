package view;

import javax.swing.*;
import model.User;
import service.UserDAO;

public class LoginRegisterFrame extends javax.swing.JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword, txtConfirmPassword;
    private JButton btnLogin, btnSwitchToRegister, btnRegister, btnSwitchToLogin;
    private JPanel panelLogin, panelRegister;
    private UserDAO userDAO = new UserDAO();

    public LoginRegisterFrame() {
        setTitle("Đăng nhập/Đăng ký");
        setSize(370, 270);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Panel Đăng nhập
        panelLogin = new JPanel(null);
        panelLogin.setBounds(0, 0, 370, 250);

        JLabel lblUser = new JLabel("Username:");
        lblUser.setBounds(30, 30, 80, 25);
        panelLogin.add(lblUser);

        txtUsername = new JTextField();
        txtUsername.setBounds(120, 30, 180, 25);
        panelLogin.add(txtUsername);

        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(30, 70, 80, 25);
        panelLogin.add(lblPass);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(120, 70, 180, 25);
        panelLogin.add(txtPassword);

        btnLogin = new JButton("Đăng nhập");
        btnLogin.setBounds(50, 120, 110, 30);
        panelLogin.add(btnLogin);

        btnSwitchToRegister = new JButton("Đăng ký");
        btnSwitchToRegister.setBounds(180, 120, 110, 30);
        panelLogin.add(btnSwitchToRegister);

        // Panel Đăng ký
        panelRegister = new JPanel(null);
        panelRegister.setBounds(0, 0, 370, 250);

        JLabel lblUserReg = new JLabel("Username:");
        lblUserReg.setBounds(30, 30, 80, 25);
        panelRegister.add(lblUserReg);

        JTextField txtUsernameReg = new JTextField();
        txtUsernameReg.setBounds(120, 30, 180, 25);
        panelRegister.add(txtUsernameReg);

        JLabel lblPassReg = new JLabel("Password:");
        lblPassReg.setBounds(30, 70, 80, 25);
        panelRegister.add(lblPassReg);

        JPasswordField txtPasswordReg = new JPasswordField();
        txtPasswordReg.setBounds(120, 70, 180, 25);
        panelRegister.add(txtPasswordReg);

        JLabel lblConfirm = new JLabel("Xác nhận:");
        lblConfirm.setBounds(30, 110, 80, 25);
        panelRegister.add(lblConfirm);

        JPasswordField txtConfirmPasswordReg = new JPasswordField();
        txtConfirmPasswordReg.setBounds(120, 110, 180, 25);
        panelRegister.add(txtConfirmPasswordReg);

        JLabel lblRole = new JLabel("Quyền:");
        lblRole.setBounds(30, 150, 80, 25);
        panelRegister.add(lblRole);

        String[] roles = {"admin", "staff"};
        JComboBox<String> cboRole = new JComboBox<>(roles);
        cboRole.setBounds(120, 150, 180, 25);
        panelRegister.add(cboRole);

        btnRegister = new JButton("Đăng ký");
        btnRegister.setBounds(50, 190, 110, 30);
        panelRegister.add(btnRegister);

        btnSwitchToLogin = new JButton("Đăng nhập");
        btnSwitchToLogin.setBounds(180, 190, 110, 30);
        panelRegister.add(btnSwitchToLogin);

        add(panelLogin);
        add(panelRegister);
        panelRegister.setVisible(false);

        // Sự kiện chuyển panel
        btnSwitchToRegister.addActionListener(e -> {
            panelLogin.setVisible(false);
            panelRegister.setVisible(true);
            txtUsernameReg.setText("");
            txtPasswordReg.setText("");
            txtConfirmPasswordReg.setText("");
        });

        btnSwitchToLogin.addActionListener(e -> {
            panelRegister.setVisible(false);
            panelLogin.setVisible(true);
            txtUsername.setText("");
            txtPassword.setText("");
        });

        // Validate đăng nhập
        btnLogin.addActionListener(e -> {
            String user = txtUsername.getText().trim();
            String pass = new String(txtPassword.getPassword());

            if (user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không được để trống tài khoản hoặc mật khẩu!");
                return;
            }
            if (!user.matches("^[a-zA-Z0-9_]{4,}$")) {
                JOptionPane.showMessageDialog(this, "Tên tài khoản phải từ 4 ký tự, chỉ gồm chữ, số, dấu gạch dưới!");
                return;
            }
            User loginUser = userDAO.checkLogin(user, pass);
            if (loginUser != null) {
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
                if ("admin".equalsIgnoreCase(loginUser.getRole())) {
                    new TrangChuQL().setVisible(true);
                } else {
                    new TrangChuNV().setVisible(true);
                }
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu!");
            }
        });

        // Validate đăng ký
        btnRegister.addActionListener(e -> {
            String user = txtUsernameReg.getText().trim();
            String pass = new String(txtPasswordReg.getPassword());
            String confirm = new String(txtConfirmPasswordReg.getPassword());
            String role = cboRole.getSelectedItem().toString();

            if (user.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không được để trống bất kỳ trường nào!");
                return;
            }
            if (!user.matches("^[a-zA-Z0-9_]{4,}$")) {
                JOptionPane.showMessageDialog(this, "Tên tài khoản phải từ 4 ký tự, chỉ gồm chữ, số, dấu gạch dưới!");
                return;
            }
            if (pass.length() < 6) {
                JOptionPane.showMessageDialog(this, "Mật khẩu phải từ 6 ký tự trở lên!");
                return;
            }
            if (pass.contains(" ")) {
                JOptionPane.showMessageDialog(this, "Mật khẩu không được chứa khoảng trắng!");
                return;
            }
            if (!pass.equals(confirm)) {
                JOptionPane.showMessageDialog(this, "Mật khẩu xác nhận không khớp!");
                return;
            }
            if (userDAO.findByUsername(user) != null) {
                JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại!");
                return;
            }
            if (userDAO.insert(new User(user, pass, role))) {
                JOptionPane.showMessageDialog(this, "Đăng ký thành công!");
                panelRegister.setVisible(false);
                panelLogin.setVisible(true);
                txtUsername.setText(user);
                txtPassword.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Đăng ký thất bại! Vui lòng thử lại.");
            }
        });
    }

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
            java.util.logging.Logger.getLogger(LoginRegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginRegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginRegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginRegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginRegisterFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
