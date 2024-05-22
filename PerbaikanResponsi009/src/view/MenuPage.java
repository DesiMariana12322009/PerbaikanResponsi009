/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.User;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Lenovo
 */

public class MenuPage extends JFrame {
    private JButton hewanButton;
    private JButton pegawaiButton;
    private JButton logoutButton;

    public MenuPage(User user) {
        setTitle("Menu");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel welcomeLabel = new JLabel("Selamat datang, " + user.getUsername());
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        hewanButton = new JButton("Hewan");
        pegawaiButton = new JButton("Pegawai");
        logoutButton = new JButton("Logout");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(welcomeLabel);
        panel.add(hewanButton);
        panel.add(pegawaiButton);
        panel.add(logoutButton);

        add(panel);
        setVisible(true);
    }

    public JButton getHewanButton() {
        return hewanButton;
    }

    public JButton getPegawaiButton() {
        return pegawaiButton;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }
}
 
