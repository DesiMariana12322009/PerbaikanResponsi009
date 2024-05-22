/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Database;
import model.Hewan;
import view.HewanPage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Lenovo
 */
public class HewanController {
    private HewanPage hewanPage;

    public HewanController(HewanPage hewanPage) {
        this.hewanPage = hewanPage;
        initController();
    }

    private void initController() {
        hewanPage.getAddButton().addActionListener(e -> addHewan());
        hewanPage.getUpdateButton().addActionListener(e -> updateHewan());
        hewanPage.getDeleteButton().addActionListener(e -> deleteHewan());
        hewanPage.getSearchButton().addActionListener(e -> searchHewan());
        loadHewanData();
    }

    private void loadHewanData() {
        List<Hewan> hewanList = fetchHewan();
        DefaultTableModel model = (DefaultTableModel) hewanPage.getHewanTable().getModel();
        model.setRowCount(0);

        for (Hewan hewan : hewanList) {
            model.addRow(new Object[]{hewan.getId(), hewan.getNama(), hewan.getJenis(), hewan.getUmur()});
        }
    }

    private List<Hewan> fetchHewan() {
        List<Hewan> hewanList = new ArrayList<>();
        try (Connection conn = Database.getConnection()) {
            String sql = "SELECT * FROM hewan";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nama = resultSet.getString("nama");
                String jenis = resultSet.getString("jenis");
                int umur = resultSet.getInt("umur");
                hewanList.add(new Hewan(id, nama, jenis, umur));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hewanList;
    }

    private void addHewan() {
        String nama = hewanPage.getNamaField().getText();
        String jenis = hewanPage.getJenisField().getText();
        int umur = Integer.parseInt(hewanPage.getUmurField().getText());

        try (Connection conn = Database.getConnection()) {
            String sql = "INSERT INTO hewan (nama, jenis, umur) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nama);
            statement.setString(2, jenis);
            statement.setInt(3, umur);
            statement.executeUpdate();
            loadHewanData();
            clearFields();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updateHewan() {
        int id = Integer.parseInt(hewanPage.getIdField().getText());
        String nama = hewanPage.getNamaField().getText();
        String jenis = hewanPage.getJenisField().getText();
        int umur = Integer.parseInt(hewanPage.getUmurField().getText());

        try (Connection conn = Database.getConnection()) {
            String sql = "UPDATE hewan SET nama = ?, jenis = ?, umur = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nama);
            statement.setString(2, jenis);
            statement.setInt(3, umur);
            statement.setInt(4, id);
            statement.executeUpdate();
            loadHewanData();
            clearFields();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteHewan() {
        int id = Integer.parseInt(hewanPage.getIdField().getText());

        try (Connection conn = Database.getConnection()) {
            String sql = "DELETE FROM hewan WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            loadHewanData();
            clearFields();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void searchHewan() {
        String keyword = hewanPage.getSearchField().getText();
        List<Hewan> hewanList = new ArrayList<>();
        try (Connection conn = Database.getConnection()) {
            String sql = "SELECT * FROM hewan WHERE nama LIKE ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nama = resultSet.getString("nama");
                String jenis = resultSet.getString("jenis");
                int umur = resultSet.getInt("umur");
                hewanList.add(new Hewan(id, nama, jenis, umur));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        DefaultTableModel model = (DefaultTableModel) hewanPage.getHewanTable().getModel();
        model.setRowCount(0);

        for (Hewan hewan : hewanList) {
            model.addRow(new Object[]{hewan.getId(), hewan.getNama(), hewan.getJenis(), hewan.getUmur()});
        }
    }

    private void clearFields() {
        hewanPage.getIdField().setText("");
        hewanPage.getNamaField().setText("");
        hewanPage.getJenisField().setText("");
        hewanPage.getUmurField().setText("");
    }
}
  
