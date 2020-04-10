/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayinta.store.project.service.impl;

import dayinta.store.project.model.ObjectMaster;
import dayinta.store.project.model.repository.ObjectMasterRepo;
import dayinta.store.project.service.ObjectMasterServ;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class ObjectMasterServImpl implements ObjectMasterServ{
    
    @Autowired
    private ObjectMasterRepo omr;

    @Override
    public List<ObjectMaster> getAll() {
        List<ObjectMaster> masters = omr.getAll();
        return masters;
    }
    
    
    
}
