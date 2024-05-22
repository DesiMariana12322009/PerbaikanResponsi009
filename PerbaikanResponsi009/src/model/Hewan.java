/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lenovo
 */
public class Hewan {
    private int id;
    private String nama;
    private String jenis;
    private int umur;

    public Hewan(int id, String nama, String jenis, int umur) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.umur = umur;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getJenis() {
        return jenis;
    }

    public int getUmur() {
        return umur;
    }
}
 

