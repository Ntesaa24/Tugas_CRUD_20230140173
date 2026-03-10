package com.example.Deploy.controller;

import com.example.Deploy.dto.KtpDTO;
import com.example.Deploy.model.ApiResponse;
import com.example.Deploy.service.KtpService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ktp")
@CrossOrigin(origins = "*")
public class KtpController {

    @Autowired
    private KtpService ktpService;

    @PostMapping
    public ResponseEntity<ApiResponse<KtpDTO>> createKtp(@Valid @RequestBody KtpDTO ktpDTO) {
        KtpDTO createdKtp = ktpService.createKtp(ktpDTO);
        return new ResponseEntity<>(
                new ApiResponse<>(true, "KTP created successfully", createdKtp),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<KtpDTO>>> getAllKtp() {
        List<KtpDTO> ktpList = ktpService.getAllKtp();
        return ResponseEntity.ok(
                new ApiResponse<>(true, "KTP list retrieved successfully", ktpList)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<KtpDTO>> getKtpById(@PathVariable Long id) {
        KtpDTO ktpDTO = ktpService.getKtpById(id);
        return ResponseEntity.ok(
                new ApiResponse<>(true, "KTP retrieved successfully", ktpDTO)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<KtpDTO>> updateKtp(@PathVariable Long id, @Valid @RequestBody KtpDTO ktpDTO) {
        KtpDTO updatedKtp = ktpService.updateKtp(id, ktpDTO);
        return ResponseEntity.ok(
                new ApiResponse<>(true, "KTP updated successfully", updatedKtp)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteKtp(@PathVariable Long id) {
        ktpService.deleteKtp(id);
        return ResponseEntity.ok(
                new ApiResponse<>(true, "KTP deleted successfully", null)
        );
    }
}
