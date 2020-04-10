/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayinta.store.project.model.repository;

import dayinta.store.project.model.CustomQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface CustomQueryRepo extends JpaRepository<CustomQuery, Integer> {
    @Query("select f from CustomQuery f where f.code = :type")
    public CustomQuery findByType(@Param("code") String code);
}
