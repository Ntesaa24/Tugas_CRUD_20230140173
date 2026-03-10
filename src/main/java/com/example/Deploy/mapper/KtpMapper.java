package com.example.Deploy.mapper;

import com.example.Deploy.dto.KtpDTO;
import com.example.Deploy.entity.Ktp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class KtpMapper {

    @Autowired
    private ModelMapper modelMapper;

    public KtpDTO toDTO(Ktp ktp) {
        return modelMapper.map(ktp, KtpDTO.class);
    }

    public Ktp toEntity(KtpDTO ktpDTO) {
        return modelMapper.map(ktpDTO, Ktp.class);
    }

    public List<KtpDTO> toDTOList(List<Ktp> ktpList) {
        return ktpList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}

