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

}