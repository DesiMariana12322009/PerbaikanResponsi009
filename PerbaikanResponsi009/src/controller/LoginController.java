/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Database;
import model.User;
import view.LoginPage;
import view.MenuPage;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Lenovo
 */
public class LoginController {
    private LoginPage loginPage;

    public LoginController(LoginPage loginPage) {
        this.loginPage = loginPage;
        initController();
    }

    private void initController() {
        loginPage.getLoginButton().addActionListener(e -> login());
    }

    private void login() {
        String username = loginPage.getUsernameField().getText();
        String password = new String(loginPage.getPasswordField().getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(loginPage, "Username atau password tidak boleh kosong.");
            return;
        }

        try (Connection conn = Database.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                User user = new User(username, password);
                loginPage.dispose();
            } else {
                JOptionPane.showMessageDialog(loginPage, "Username atau password salah.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

