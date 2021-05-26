package clinic.dao.core;

import clinic.dao.api.PrescriptionDao;
import clinic.entities.Prescription;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrescriptionDaoImpl extends AbstractHibernateDao<Prescription> implements PrescriptionDao {
    public PrescriptionDaoImpl() {
        super(Prescription.class);
    }

    @Override
    public List<Prescription> findAllByPatientId(Integer patientId) {
        return em.createQuery(
                "SELECT p FROM Prescription p WHERE p.patient.id = :patientId")
                .setParameter("patientId", patientId)
                .getResultList();
    }

    @Override
    public List<Prescription> findAllByCaseId(Long caseId) {
        return em.createQuery(
                "SELECT p FROM Prescription p WHERE p.patientCase.id = :caseId")
                .setParameter("caseId", caseId)
                .getResultList();
    }
}
