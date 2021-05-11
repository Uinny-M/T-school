package clinic.dao.core;

import clinic.dao.api.CaseDao;
import clinic.entities.Case;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CaseDaoImpl extends AbstractHibernateDao<Case> implements CaseDao {
public CaseDaoImpl(){super(Case.class);}
    @Transactional
    @Override
    public List<Case> findCasesByPatientId(Integer patientId)
    {
        return em.createQuery("SELECT c FROM Case c WHERE c.patient.id =:id")
                .setParameter("id", patientId)
                .getResultList();
    }
}
