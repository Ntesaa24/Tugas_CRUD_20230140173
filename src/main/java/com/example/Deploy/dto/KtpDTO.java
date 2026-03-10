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

}