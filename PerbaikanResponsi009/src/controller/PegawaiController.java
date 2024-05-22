/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Database;
import model.Pegawai;
import view.PegawaiPage;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class PegawaiController {
    private PegawaiPage pegawaiPage;

    public PegawaiController(PegawaiPage pegawaiPage) {
        this.pegawaiPage = pegawaiPage;
        initController();
    }

    private void initController() {
        loadPegawaiData();
    }

    private void loadPegawaiData() {
        List<Pegawai> pegawaiList = fetchPegawai();
        DefaultTableModel model = (DefaultTableModel) pegawaiPage.getPegawaiTable().getModel();
        model.setRowCount(0);

        for (Pegawai pegawai : pegawaiList) {
            model.addRow(new Object[]{pegawai.getId(), pegawai.getNama(), pegawai.getPosisi()});
        }
    }

    private List<Pegawai> fetchPegawai() {
        List<Pegawai> pegawaiList = new ArrayList<>();
        try (Connection conn = Database.getConnection()) {
            String sql = "SELECT * FROM pegawai";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nama = resultSet.getString("nama");
                String posisi = resultSet.getString("posisi");
                pegawaiList.add(new Pegawai(id, nama, posisi));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pegawaiList;
    }
}
 

