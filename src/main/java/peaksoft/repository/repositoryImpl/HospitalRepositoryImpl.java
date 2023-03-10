package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.model.Hospital;
import peaksoft.repository.HospitalRepository;

import java.util.List;
@Repository
@Transactional
public class HospitalRepositoryImpl implements HospitalRepository {

    @PersistenceContext
    private  EntityManager entityManager;


    @Override
    public List<Hospital> getAllHospitals() {
        return entityManager.createQuery("select h from Hospital h",Hospital.class).getResultList();
    }

    @Override
    public void saveHospital(Hospital hospital) {
        entityManager.persist(hospital);
        System.out.println("siuu");
    }

    @Override
    public Hospital getHospitalById(Long id) {
        return entityManager.find(Hospital.class,id);
    }

    @Override
    public void deleteHospitalById(Long id) {
        entityManager.remove(entityManager.find(Hospital.class,id));
        System.out.println("dede");
    }

    @Override
    public void updateHospital(Hospital hospital) {
        entityManager.merge(hospital);
    }
}
