package com.example.learnspring.dao;

import com.example.learnspring.models.Mahasiswa;
import com.example.learnspring.services.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class MahasiswaDao implements MahasiswaService {

    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Mahasiswa> listMahasiswa() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from Mahasiswa", Mahasiswa.class).getResultList();
    }

    @Override
    public Mahasiswa store(Mahasiswa mahasiswa) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Mahasiswa dataMahasiswa = entityManager.merge(mahasiswa);
        entityManager.getTransaction().commit();

        return dataMahasiswa;
    }

    @Override
    public Mahasiswa getMahasiswa(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Mahasiswa.class,id);
    }

    @Override
    public void deleteMahasiswa(Long id) {
        EntityManager entityManager =  entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Mahasiswa.class,id));
        entityManager.getTransaction().commit();
    }
}
