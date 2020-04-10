/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayinta.store.project.service.impl;

import dayinta.store.project.model.CustomQuery;
import dayinta.store.project.model.repository.CustomQueryRepo;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author HP
 */
@Transactional
public class CustomQueryServImpl {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private CustomQueryRepo cqr;

    public int getData(Map<String, Object> payload, String code) {
        CustomQuery cq = cqr.findByType(code);
        int result = 0;
        Query q = em.createNativeQuery(cq.getValue());
        for (Map.Entry<String, Object> entry : payload.entrySet()) {
            try {
                q.setParameter(entry.getKey(), entry.getValue());
            } catch (Exception e) {
            }
        }
        try {
            result = q.executeUpdate();
        } catch (Exception e) {

        }
        return result;
    }

}
