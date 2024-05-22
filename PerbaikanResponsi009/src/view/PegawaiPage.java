/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Lenovo
 */
public class PegawaiPage extends JFrame {
    private JTable pegawaiTable;

    public PegawaiPage() {
        setTitle("Pegawai");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JScrollPane tableScrollPane = new JScrollPane(pegawaiTable);

        add(tableScrollPane, BorderLayout.CENTER);
        setVisible(true);
    }

    public JTable getPegawaiTable() {
        return pegawaiTable;
    }
}
  

