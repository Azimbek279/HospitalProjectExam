package peaksoft.repository;

import peaksoft.model.Doctor;
import peaksoft.model.Patient;

import java.util.List;

public interface DoctorRepository {
    List<Doctor> getAllDoctors(Long doctorId);

    void saveDoctor(Doctor doctor,Long hospital);

    void saveDoctorInfo(Doctor doctor);

    Doctor getDoctorById(Long id);

    void deleteDoctorById(Long id);

    void updateDoctor(Long doctorId,Doctor doctor);
}
