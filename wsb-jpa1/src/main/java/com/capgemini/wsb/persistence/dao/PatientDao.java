package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.time.LocalDate;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long>
{
    public List<PatientEntity> findByLastName(String lastName);
    public List<PatientEntity> findPatientsWithMoreVisitsThan(Integer cnt);
    public List<PatientEntity> findPatientsWithSpecyficWordInHistory(String word);
    public List<VisitEntity> findVisitsByPatientId(Long patientId);
    List<PatientEntity> findPatientsByCustomField(LocalDate date);
}
