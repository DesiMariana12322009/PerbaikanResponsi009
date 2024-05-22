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


public class HewanPage extends JFrame {
    private JTextField idField;
    private JTextField namaField;
    private JTextField jenisField;
    private JTextField umurField;
    private JTextField searchField;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JTable hewanTable;

    public HewanPage() {
        setTitle("Hewan");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        formPanel.add(idField);
        formPanel.add(new JLabel("Nama:"));
        namaField = new JTextField();
        formPanel.add(namaField);
        formPanel.add(new JLabel("Jenis:"));
        jenisField = new JTextField();
        formPanel.add(jenisField);
        formPanel.add(new JLabel("Umur:"));
        umurField = new JTextField();
        formPanel.add(umurField);

        addButton = new JButton("Tambah");
        updateButton = new JButton("Ubah");
        deleteButton = new JButton("Hapus");

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(formPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

   
        JScrollPane tableScrollPane = new JScrollPane(hewanTable);

        searchField = new JTextField();
        searchButton = new JButton("Cari");

        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);
        add(searchPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public JTextField getIdField() {
        return idField;
    }

    public JTextField getNamaField() {
        return namaField;
    }

    public JTextField getJenisField() {
        return jenisField;
    }

    public JTextField getUmurField() {
        return umurField;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JTable getHewanTable() {
        return hewanTable;
    }
}
   
