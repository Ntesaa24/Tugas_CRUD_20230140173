package com.example.Deploy.service;

import com.example.Deploy.dto.KtpDTO;
import java.util.List;

public interface KtpService {
    KtpDTO createKtp(KtpDTO ktpDTO);
    List<KtpDTO> getAllKtp();
    KtpDTO getKtpById(Long id);
    KtpDTO updateKtp(Long id, KtpDTO ktpDTO);
    void deleteKtp(Long id);
}
