package com.test.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.WsbJpaApplication;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WsbJpaApplication.class)
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void shouldRetrievePatientsByLastName() {
        List<PatientEntity> patients = patientDao.findByLastName("Jones");
        assertThat(patients).isNotNull();
        assertThat(patients.size()).isEqualTo(1);
    }

    @Transactional
    @Test
    public void shouldReturnPatientsWithMoreThanGivenVisits() {
        List<PatientEntity> patients = patientDao.findPatientsWithMoreVisitsThan(2);
        assertThat(patients).isNotNull();
        assertThat(patients.size()).isGreaterThan(0);
    }

    @Transactional
    @Test
    public void shouldFetchPatientsByHistoryKeyword() {
        List<PatientEntity> patients = patientDao.findPatientsWithSpecyficWordInHistory("diabetes");
        assertThat(patients).isNotNull();
        assertThat(patients.size()).isGreaterThan(0);
    }

    @Transactional
    @Test
    public void shouldFindAllVisitsByPatientId() {
        List<VisitEntity> visits = patientDao.findVisitsByPatientId(1L);
        assertThat(visits).isNotNull();
        assertThat(visits.size()).isGreaterThan(0);
    }

    @Transactional
    @Test
    public void shouldFindPatientsByCustomField() {
        List<PatientEntity> patients = patientDao.findPatientsByCustomField(LocalDate.of(2023, 1, 1));
        assertThat(patients).isNotNull();
        assertThat(patients.size()).isGreaterThan(0);
    }
}
