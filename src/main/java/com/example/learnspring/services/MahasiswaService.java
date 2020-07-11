package com.example.learnspring.services;

import com.example.learnspring.models.Mahasiswa;
import java.util.List;

public interface MahasiswaService {

    List<Mahasiswa> listMahasiswa();
    Mahasiswa store(Mahasiswa mahasiswa);
    Mahasiswa getMahasiswa(Long id);
    void deleteMahasiswa(Long id);
}
