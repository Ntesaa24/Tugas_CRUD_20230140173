package com.example.Deploy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class KtpDTO {

    private Long id;

    @NotBlank(message = "Nomor KTP is required")
    @Size(min = 16, max = 16, message = "Nomor KTP must be 16 digits")
    private String nomorKtp;

    @NotBlank(message = "Nama Lengkap is required")
    private String namaLengkap;

    @NotBlank(message = "Alamat is required")
    private String alamat;

    @NotNull(message = "Tanggal Lahir is required")
    private LocalDate tanggalLahir;

    @NotBlank(message = "Jenis Kelamin is required")
    private String jenisKelamin;

    // Constructors
    public KtpDTO() {}

    public KtpDTO(Long id, String nomorKtp, String namaLengkap, String alamat, LocalDate tanggalLahir, String jenisKelamin) {
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
}
