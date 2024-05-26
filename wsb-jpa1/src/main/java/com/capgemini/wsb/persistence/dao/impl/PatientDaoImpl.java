package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import java.time.LocalDate;

import java.util.List;

@Repository
public class PatientDaoImpl extends  AbstractDao<PatientEntity, Long> implements PatientDao
{
    @Override
    public List<PatientEntity> findByLastName(String lastName)
    {
        List<PatientEntity> patients;
        patients = entityManager.createQuery("SELECT p FROM PatientEntity p " +
                                "WHERE p.lastName LIKE :lastName"
                        , PatientEntity.class)
                .setParameter("lastName", "%" + lastName + "%")
                .getResultList();
        return patients;
    }

    @Override
    public List<PatientEntity> findPatientsWithMoreVisitsThan(Integer cnt)
    {
        List<PatientEntity> patients;
        patients = entityManager.createQuery("SELECT DISTINCT p FROM PatientEntity p " +
                        " JOIN p.visits v" +
                        " GROUP BY p HAVING COUNT(v) > :cnt", PatientEntity.class)
                .setParameter("cnt", (long) cnt)
                .getResultList();
        return patients;
    }

    @Override
    public List<PatientEntity> findPatientsWithSpecyficWordInHistory(String word)
    {
        List<PatientEntity> patients;
        patients = entityManager.createQuery("SELECT p FROM PatientEntity p " +
                                "WHERE p.patientHistory LIKE :word"
                        , PatientEntity.class)
                .setParameter("word", "%" + word + "%")
                .getResultList();
        return patients;
    }

    @Override
    public List<VisitEntity> findVisitsByPatientId(Long patientId) {
        List<VisitEntity> visits;
        visits = entityManager.createQuery("SELECT v FROM VisitEntity v WHERE v.patient.id = :patientId", VisitEntity.class)
                .setParameter("patientId", patientId)
                .getResultList();
        return visits;
    }
    @Override
    public List<PatientEntity> findPatientsByCustomField(LocalDate date) {
        List<PatientEntity> patients;
        patients = entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.registeredDate > :date", PatientEntity.class)
                .setParameter("date", date)
                .getResultList();
        return patients;
    }
}