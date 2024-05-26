INSERT INTO ADDRESS (id, address_line1, address_line2, city, postal_code)
VALUES
    (1, '123 Main St', 'Apt 5', 'Springfield', '11-111'),
    (2, '456 Elm St', 'Lok 8', 'Shelbyville', '22-222'),
    (3, '789 Oak St', 'Suite 10', 'Capital City', '33-333'),
    (4, '101 Pine St', 'Nice 10', 'Ogdenville', '44-444'),
    (5, '202 Maple St', 'Room 15', 'North Haverbrook', '55-555');

INSERT INTO DOCTOR (id, first_name, last_name, telephone_number, email, specialization, doctor_number, address_id)
VALUES
    (1, 'John', 'Doe', '5551234567', 'john.doe@example.com', 'ORTHOPEDIST', 'D001', 1),
    (2, 'Jane', 'Smith', '5559876543', 'jane.smith@example.com', 'DERMATOLOGIST', 'D002', 2),
    (3, 'Robert', 'Johnson', '5555678901', 'robert.johnson@example.com', 'NEUROLOGIST', 'D003', 3),
    (4, 'Mary', 'Brown', '5553456789', 'mary.brown@example.com', 'PEDIATRICIAN', 'D004', 4),
    (5, 'David', 'White', '5552345678', 'david.white@example.com', 'CARDIOLOGIST', 'D005', 5);

INSERT INTO PATIENT (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, patient_history)
VALUES
    (1, 'Michael', 'Jones', '5554321098', 'michael.jones@example.com', 'P1001', '1978-03-14', 'diabetes'),
    (2, 'Catherine', 'Taylor', '5555432109', 'catherine.taylor@example.com', 'P1002', '1982-06-23', 'allergies'),
    (3, 'Thomas', 'Anderson', '5556543210', 'thomas.anderson@example.com', 'P1003', '1995-08-19', 'asthma'),
    (4, 'Julia', 'Williams', '5557654321', 'julia.williams@example.com', 'P1004', '1980-02-11', 'hypertension'),
    (5, 'Daniel', 'Martinez', '5558765432', 'daniel.martinez@example.com', 'P1005', '1975-11-30', 'migraine');

INSERT INTO VISIT (id, description, time, doctor_id, patient_id)
VALUES
    (1, 'Teeth cleaning', '2024-05-20 10:00:00', 1, 1),
    (2, 'Eye examination', '2024-05-21 11:00:00', 2, 2),
    (3, 'Physical therapy session', '2024-05-22 14:00:00', 3, 3),
    (4, 'Cardiology consultation', '2024-05-23 09:00:00', 4, 4),
    (5, 'Neurology consultation', '2024-05-24 12:00:00', 5, 5);

INSERT INTO MEDICAL_TREATMENT (id, description, visit_id)
VALUES
    (1, 'Routine check-up', 1),
    (2, 'Vision screening', 2),
    (3, 'Rehabilitation therapy', 3),
    (4, 'Electrocardiogram', 4),
    (5, 'CT scan', 5);

INSERT INTO VISIT (id, description, time, doctor_id, patient_id)
VALUES
    (6, 'Check-up', '2024-05-25 10:00:00', 1, 1),
    (7, 'Follow-up', '2024-05-26 11:00:00', 2, 2),
    (8, 'Therapy session', '2024-05-27 14:00:00', 3, 3);