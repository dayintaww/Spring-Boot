/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayinta.store.project.service;

import dayinta.store.project.model.ObjectBucket;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public interface ObjectBucketServ {
    public List<ObjectBucket> getAllDataBucket();
    public List<ObjectBucket> getSingleDataBucket(String oName);
    public int insert(String oName, String price, String sale, String fp);
}
