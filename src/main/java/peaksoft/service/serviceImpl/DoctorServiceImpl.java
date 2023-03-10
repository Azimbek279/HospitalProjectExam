package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Doctor;
import peaksoft.model.Hospital;
import peaksoft.repository.DoctorRepository;
import peaksoft.repository.HospitalRepository;
import peaksoft.service.DoctorService;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    private final HospitalRepository hospitalRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, HospitalRepository hospitalRepository) {
        this.doctorRepository = doctorRepository;
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public List<Doctor> getAllDoctors(Long doctorId) {
        return doctorRepository.getAllDoctors(doctorId);
    }

    @Transactional
    @Override
    public void saveDoctor(Doctor doctor, Long hospitalId) {
        Doctor doctor1 = new Doctor();
//        doctor1.setId(doctor.getId());
        doctor1.setFirstName(doctor.getFirstName());
        doctor1.setLastName(doctor.getLastName());
        doctor1.setEmail(doctor.getEmail());
        doctor1.setPosition(doctor.getPosition());
//        doctorRepository.saveDoctorInfo(doctor1);
//        doctor1.setHospital(hospitalRepository.getHospitalById(doctor.getHospital().getId()));
        doctorRepository.saveDoctor(doctor1,hospitalId);
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.getDoctorById(id);
    }

    @Override
    public void deleteDoctorById(Long id) {
        doctorRepository.deleteDoctorById(id);
    }

    @Override
    public void updateDoctor(Long doctorId, Doctor doctor) {
        doctorRepository.updateDoctor(doctorId,doctor);
    }
}
