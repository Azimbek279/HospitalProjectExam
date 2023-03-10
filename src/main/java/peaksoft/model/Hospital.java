package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "hospitals")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "hospital_id_gen")
    @SequenceGenerator(name = "hospital_id_gen",
    sequenceName = "hospital_seq",
    allocationSize = 1)
    private Long id;

    private String name;

    private String address;

    @OneToMany(cascade = {ALL},mappedBy = "hospital")
    private List<Patient> patients = new ArrayList<>();

    public void addPatient(Patient patient){
        if (patients == null){
            patients = new ArrayList<>();
        }
        patients.add(patient);
    }

    @OneToMany(cascade = {ALL},fetch = FetchType.EAGER)
    private List<Appointment> appointments = new ArrayList<>();

    @OneToMany(cascade = {ALL},fetch = FetchType.LAZY,mappedBy = "hospital")

    private List<Doctor> doctors = new ArrayList<>();

    @OneToMany(cascade = {ALL},fetch = FetchType.LAZY,mappedBy = "hospital")
    private List<Department> departments = new ArrayList<>();

    public void addDepartment(Department department){
        if (departments == null){
            departments = new ArrayList<>();
        }
        departments.add(department);
    }

    public void addDoctor(Doctor doctor){
        if (doctors == null){
            doctors = new ArrayList<>();
        }
        doctors.add(doctor);
    }
}
