/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lenovo
 */
public class Pegawai {
    private int id;
    private String nama;
    private String posisi;

    public Pegawai(int id, String nama, String posisi) {
        this.id = id;
        this.nama = nama;
        this.posisi = posisi;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getPosisi() {
        return posisi;
    }
}
   

