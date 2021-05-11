package clinic.dao.core;

import clinic.dao.api.PatientDao;
import clinic.entities.Patient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractHibernateDao<Patient> implements PatientDao {

    public PatientDaoImpl() {
        super(Patient.class);
    }

    @Override
    public List<Patient> findAllByName(String name) {
        return em.createQuery(
                "SELECT p FROM Patient p WHERE p.secondName = :name")
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public Patient findPatientByInsurance(String insurance) {
        return (Patient) em.createQuery(
                "SELECT p FROM Patient p WHERE p.insurance = :insurance")
                .setParameter("insurance", insurance)
                .getResultList().get(0);
    }
}
