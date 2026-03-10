package com.example.Deploy.repository;

import com.example.Deploy.entity.Ktp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface KtpRepository extends JpaRepository<Ktp, Long> {
    Optional<Ktp> findByNomorKtp(String nomorKtp);
    boolean existsByNomorKtp(String nomorKtp);
}
