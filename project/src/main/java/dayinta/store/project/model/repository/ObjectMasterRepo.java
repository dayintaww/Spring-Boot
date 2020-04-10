/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayinta.store.project.model.repository;

import dayinta.store.project.model.ObjectMaster;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface ObjectMasterRepo extends CrudRepository<ObjectMaster, Integer> {
    
    @Query("select * from ObejctMaster o")
    public List<ObjectMaster> getAll();
    
}
