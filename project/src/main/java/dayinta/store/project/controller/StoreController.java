/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayinta.store.project.controller;

import dayinta.store.project.model.ObjectBucket;
import dayinta.store.project.model.ObjectMaster;
import dayinta.store.project.service.CustomQueryServ;
import dayinta.store.project.service.ObjectBucketServ;
import dayinta.store.project.service.ObjectMasterServ;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author HP
 */
@Component
@RestController
public class StoreController {

    @Autowired
    private ObjectBucketServ obs;

    @Autowired
    private ObjectMasterServ oms;
    
    @Autowired
    private CustomQueryServ cqs;

    @RequestMapping(value = "/getDataBucket", method = RequestMethod.GET)
    public List<ObjectBucket> getDataBucket(@RequestParam("objectName") String oName) throws Exception {
        List<ObjectBucket> buckets = new ArrayList<ObjectBucket>();
        if (oName == null || oName.equalsIgnoreCase("")) {
            buckets = obs.getAllDataBucket();
        } else if (oName != null || !oName.equalsIgnoreCase("")) {
            buckets = obs.getSingleDataBucket(oName);
        }

        return buckets;
    }

    @RequestMapping(value = "/masterToBucket", method = RequestMethod.POST, produces = "application/json")
    public String masterToBucket(@RequestParam("objectName") String oName, @RequestParam("sale") String sale) throws Exception {
        JSONObject output = new JSONObject();
        int result = 0;
        List<ObjectMaster> masters = oms.getAll();
        for (ObjectMaster master : masters) {
            int finalPrice = (master.getHarga() * Integer.parseInt(sale)) / 100;
            try {
                result = obs.insert(master.getNamaBarang(), String.valueOf(master.getHarga()), sale, String.valueOf(finalPrice));
                output.put("responseCode", "1");
                output.put("message", "Insert Success");
            } catch (Exception e) {
                output.put("responseCode", "0");
                output.put("message", "Insert Failed"+ e);
            }

        }
        return "";
    }
    
        @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String getData(@RequestBody Map<String, Object> payload, @RequestParam String code) {
        int result;
        JSONObject output = new JSONObject();
        result = cqs.getData(payload, code);
        if (result != 0) {
            output.put("responseCode", "1");
            output.put("message", "Data updated");
        } else {
            output.put("responseCode", "0");
            output.put("message", "No data updated");
        }
        return output.toString();
    }

}
