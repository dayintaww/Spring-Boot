/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayinta.store.project.service;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public interface CustomQueryServ {
    public int getData(Map<String, Object> payload, String code);
    
}
