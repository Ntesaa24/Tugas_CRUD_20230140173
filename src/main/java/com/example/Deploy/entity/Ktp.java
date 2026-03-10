package com.example.Deploy.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ktp")
public class Ktp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomor_ktp", unique = true, nullable = false)
    private String nomorKtp;

    @Column(name = "nama_lengkap", nullable = false)
    private String namaLengkap;

    @Column(name = "alamat", nullable = false)
    private String alamat;

    @Column(name = "tanggal_lahir", nullable = false)
    private LocalDate tanggalLahir;

    @Column(name = "jenis_kelamin", nullable = false)
    private String jenisKelamin;

    // Constructors
    public Ktp() {}

    public Ktp(Long id, String nomorKtp, String namaLengkap, String alamat, LocalDate tanggalLahir, String jenisKelamin) {
        this.id = id;
        this.nomorKtp = nomorKtp;
        this.namaLengkap = namaLengkap;
        this.alamat = alamat;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomorKtp() {
        return nomorKtp;
    }

    public void setNomorKtp(String nomorKtp) {
        this.nomorKtp = nomorKtp;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    // Builder Pattern Helper (optional, but since I used .builder() in my thought before)
    // Actually, I'll just use the constructor to keep it simple and clean.
}
