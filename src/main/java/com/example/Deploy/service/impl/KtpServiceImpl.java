package com.example.Deploy.service.impl;

import com.example.Deploy.dto.KtpDTO;
import com.example.Deploy.entity.Ktp;
import com.example.Deploy.mapper.KtpMapper;
import com.example.Deploy.repository.KtpRepository;
import com.example.Deploy.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KtpServiceImpl implements KtpService {

    @Autowired
    private KtpRepository ktpRepository;

    @Autowired
    private KtpMapper ktpMapper;

    @Override
    public KtpDTO createKtp(KtpDTO ktpDTO) {
        if (ktpRepository.existsByNomorKtp(ktpDTO.getNomorKtp())) {
            throw new RuntimeException("KTP with number " + ktpDTO.getNomorKtp() + " already exists");
        }
        Ktp ktp = ktpMapper.toEntity(ktpDTO);
        Ktp savedKtp = ktpRepository.save(ktp);
        return ktpMapper.toDTO(savedKtp);
    }

    @Override
    public List<KtpDTO> getAllKtp() {
        List<Ktp> ktpList = ktpRepository.findAll();
        return ktpMapper.toDTOList(ktpList);
    }

    @Override
    public KtpDTO getKtpById(Long id) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KTP not found with id: " + id));
        return ktpMapper.toDTO(ktp);
    }

    @Override
    public KtpDTO updateKtp(Long id, KtpDTO ktpDTO) {
        Ktp existingKtp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KTP not found with id: " + id));
        
        if (!existingKtp.getNomorKtp().equals(ktpDTO.getNomorKtp()) && 
            ktpRepository.existsByNomorKtp(ktpDTO.getNomorKtp())) {
            throw new RuntimeException("KTP with number " + ktpDTO.getNomorKtp() + " already exists");
        }

        existingKtp.setNomorKtp(ktpDTO.getNomorKtp());
        existingKtp.setNamaLengkap(ktpDTO.getNamaLengkap());
        existingKtp.setAlamat(ktpDTO.getAlamat());
        existingKtp.setTanggalLahir(ktpDTO.getTanggalLahir());
        existingKtp.setJenisKelamin(ktpDTO.getJenisKelamin());

        Ktp updatedKtp = ktpRepository.save(existingKtp);
        return ktpMapper.toDTO(updatedKtp);
    }

    @Override
    public void deleteKtp(Long id) {
        if (!ktpRepository.existsById(id)) {
            throw new RuntimeException("KTP not found with id: " + id);
        }
        ktpRepository.deleteById(id);
    }
}
