/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayinta.store.project.service;

import dayinta.store.project.model.ObjectMaster;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public interface ObjectMasterServ {
    public List<ObjectMaster> getAll();
}
