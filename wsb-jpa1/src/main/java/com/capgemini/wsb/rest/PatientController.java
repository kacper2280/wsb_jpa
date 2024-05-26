package com.capgemini.wsb.rest;

import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.service.PatientService;
import com.capgemini.wsb.dto.PatientTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController
{
    private final PatientService pS;

    public PatientController(PatientService patientService)
    {
        this.pS = patientService;
    }

    @GetMapping("/patient/{id}")
    PatientTO findById(@PathVariable final Long id)
    {
        final PatientTO patient = pS.findById(id);
        var visits = patient.getVisits();
        for(var visit: visits)
        {
            visit.getDoctor().setVisits(null);
            visit.getDoctor().setAddress(null);
            visit.setPatient(null);
        }
        if(patient != null)
        {
            return patient;
        }
        throw new EntityNotFoundException(id);
    }
}
