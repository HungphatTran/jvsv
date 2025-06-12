package UI;

import javax.swing.*;
import java.awt.*;

public class ChiTietForm extends JFrame {

    
    
    public ChiTietForm(String tenSP, String moTa, String hinhAnh, double gia) {
        setTitle("Chi tiết sản phẩm");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Load ảnh
        JLabel lblAnh = new JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource(hinhAnh));
        Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        lblAnh.setIcon(new ImageIcon(img));
        lblAnh.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblTen = new JLabel("Tên: " + tenSP);
        lblTen.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel lblGia = new JLabel("Giá: " + gia + " VND");
        JLabel lblMoTa = new JLabel("<html>Mô tả: " + moTa + "</html>");

        JPanel thongTin = new JPanel(new GridLayout(3, 1, 10, 10));
        thongTin.add(lblTen);
        thongTin.add(lblGia);
        thongTin.add(lblMoTa);

        panel.add(lblAnh, BorderLayout.NORTH);
        panel.add(thongTin, BorderLayout.CENTER);

        add(panel);
        
        
    }
}
