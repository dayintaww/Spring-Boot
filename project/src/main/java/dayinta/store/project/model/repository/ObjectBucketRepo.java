/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayinta.store.project.model.repository;

import dayinta.store.project.model.ObjectBucket;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface ObjectBucketRepo extends CrudRepository<ObjectBucket, Integer> {
    @Query(value="select object_name, price, diskon, final_price, status from object_bucket where status = 1", nativeQuery = true)
    public List<ObjectBucket> getAllDataBucket();
    
    @Query(value="select object_name, price, diskon, final_price, status from object_bucket where object_name = ?", nativeQuery = true)
    public List<ObjectBucket> getSingleDataBucket(String oName);
    
    @Query(value="insert into object_bucket (object_name, price, diskon, final_price, status) values (?, ?, ?, ?, '1')", nativeQuery = true)
    public int insert(String oName, String price, String sale, String fp);
}
