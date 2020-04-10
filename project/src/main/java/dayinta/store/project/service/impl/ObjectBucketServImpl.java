/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayinta.store.project.service.impl;

import dayinta.store.project.model.ObjectBucket;
import dayinta.store.project.model.repository.ObjectBucketRepo;
import dayinta.store.project.service.ObjectBucketServ;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class ObjectBucketServImpl implements ObjectBucketServ{
    @Autowired
    private ObjectBucketRepo obr;

    @Override
    public List<ObjectBucket> getAllDataBucket() {
        List<ObjectBucket> buckets = obr.getAllDataBucket();
        return buckets;
    }

    @Override
    public List<ObjectBucket> getSingleDataBucket(String oName) {
        List<ObjectBucket> bucketSingle = obr.getSingleDataBucket(oName);
        return bucketSingle;
    }

    @Override
    public int insert(String oName, String price, String sale, String fp) {
        int result=0;
        obr.insert(oName, price, sale, fp);
        return result;
    }
    
}
