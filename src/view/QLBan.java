/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import model.Ban;
import service.BanDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
/**
 *
 * @author ADMIN
 */
public class QLBan extends javax.swing.JFrame {
    private JTextField txtMaBan, txtTenBan;
    private JComboBox<String> cboTrangThai;
    private JTable tblBan;
    private DefaultTableModel model;
    private BanDAO banDAO = new BanDAO();
    /**
     * Creates new form QLBan
     */
    public QLBan() {
        setTitle("Quản lý bàn phục vụ");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblMaBan = new JLabel("Mã bàn:");
        lblMaBan.setBounds(30, 20, 60, 25);
        add(lblMaBan);

        txtMaBan = new JTextField();
        txtMaBan.setBounds(100, 20, 120, 25);
        add(txtMaBan);

        JLabel lblTenBan = new JLabel("Tên bàn:");
        lblTenBan.setBounds(250, 20, 60, 25);
        add(lblTenBan);

        txtTenBan = new JTextField();
        txtTenBan.setBounds(320, 20, 120, 25);
        add(txtTenBan);

        JLabel lblTrangThai = new JLabel("Trạng thái:");
        lblTrangThai.setBounds(30, 60, 70, 25);
        add(lblTrangThai);

        cboTrangThai = new JComboBox<>(new String[]{"Trống", "Đang phục vụ", "Đã đặt trước"});
        cboTrangThai.setBounds(100, 60, 120, 25);
        add(cboTrangThai);

        JButton btnThem = new JButton("Thêm");
        btnThem.setBounds(470, 20, 90, 25);
        add(btnThem);

        JButton btnSua = new JButton("Sửa");
        btnSua.setBounds(470, 60, 90, 25);
        add(btnSua);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.setBounds(470, 100, 90, 25);
        add(btnXoa);

        JButton btnLamMoi = new JButton("Làm mới");
        btnLamMoi.setBounds(470, 140, 90, 25);
        add(btnLamMoi);

        model = new DefaultTableModel(new String[]{"Mã bàn", "Tên bàn", "Trạng thái"}, 0) {
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tblBan = new JTable(model);
        JScrollPane scroll = new JScrollPane(tblBan);
        scroll.setBounds(30, 100, 420, 230);
        add(scroll);

        // Đổi màu trạng thái bàn
        tblBan.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                          boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                String status = (String) table.getValueAt(row, 2);
                if ("Trống".equals(status)) {
                    c.setBackground(new Color(204, 255, 204)); // Xanh nhạt
                } else if ("Đang phục vụ".equals(status)) {
                    c.setBackground(new Color(255, 255, 153)); // Vàng nhạt
                } else if ("Đã đặt trước".equals(status)) {
                    c.setBackground(new Color(255, 204, 204)); // Hồng nhạt
                } else {
                    c.setBackground(Color.white);
                }
                if (isSelected) c.setBackground(Color.lightGray);
                return c;
            }
        });

        // Load dữ liệu
        loadTable();

        // Sự kiện chọn dòng
        tblBan.getSelectionModel().addListSelectionListener(e -> {
            int row = tblBan.getSelectedRow();
            if (row >= 0) {
                txtMaBan.setText(model.getValueAt(row, 0).toString());
                txtTenBan.setText(model.getValueAt(row, 1).toString());
                cboTrangThai.setSelectedItem(model.getValueAt(row, 2).toString());
                txtMaBan.setEditable(false); // Không cho sửa mã bàn
            }
        });

        // Thêm bàn
        btnThem.addActionListener(e -> {
            String maBan = txtMaBan.getText().trim();
            String tenBan = txtTenBan.getText().trim();
            String trangThai = cboTrangThai.getSelectedItem().toString();
            if (maBan.isEmpty() || tenBan.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không được để trống!");
                return;
            }
            Ban ban = new Ban(maBan, tenBan, trangThai);
            if (banDAO.insert(ban)) {
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
                loadTable();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại hoặc mã bàn đã tồn tại!");
            }
        });

        // Sửa bàn
        btnSua.addActionListener(e -> {
            int row = tblBan.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Chọn bàn để sửa!");
                return;
            }
            String maBan = txtMaBan.getText().trim();
            String tenBan = txtTenBan.getText().trim();
            String trangThai = cboTrangThai.getSelectedItem().toString();
            Ban ban = new Ban(maBan, tenBan, trangThai);
            if (banDAO.update(ban)) {
                JOptionPane.showMessageDialog(this, "Sửa thành công!");
                loadTable();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại!");
            }
        });

        // Xóa bàn
        btnXoa.addActionListener(e -> {
            int row = tblBan.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Chọn bàn để xóa!");
                return;
            }
            String maBan = txtMaBan.getText();
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                if (banDAO.delete(maBan)) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công!");
                    loadTable();
                    clearForm();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại!");
                }
            }
        });

        // Làm mới
        btnLamMoi.addActionListener(e -> clearForm());
    }

    private void loadTable() {
        model.setRowCount(0);
        ArrayList<Ban> list = banDAO.getAll();
        for (Ban ban : list) {
            model.addRow(new Object[]{
                ban.getMaBan(), ban.getTenBan(), ban.getTrangThai()
            });
        }
    }

    private void clearForm() {
        txtMaBan.setText("");
        txtTenBan.setText("");
        cboTrangThai.setSelectedIndex(0);
        txtMaBan.setEditable(true);
        tblBan.clearSelection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
            java.util.logging.Logger.getLogger(QLBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLBan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
