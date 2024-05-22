/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.User;
import view.MenuPage;
import view.HewanPage;
import view.PegawaiPage;

public class MenuController {
    private MenuPage menuPage;
/**
 *
 * @author Lenovo
 */
    public MenuController(MenuPage menuPage) {
        this.menuPage = menuPage;
        initController();
    }

    private void initController() {
        menuPage.getHewanButton().addActionListener(e -> openHewanPage());
        menuPage.getPegawaiButton().addActionListener(e -> openPegawaiPage());
        menuPage.getLogoutButton().addActionListener(e -> logout());
    }

    private void openHewanPage() {
        new HewanController(new HewanPage());
        menuPage.dispose();
    }

    private void openPegawaiPage() {
        new PegawaiController(new PegawaiPage());
        menuPage.dispose();
    }

    private void logout() {
        menuPage.dispose();

    }
}
 

