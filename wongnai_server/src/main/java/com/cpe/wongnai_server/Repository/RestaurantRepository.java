package com.cpe.wongnai_server.Repository;

import java.util.List;

import com.cpe.wongnai_server.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpe.wongnai_server.entity.Owner;
import com.cpe.wongnai_server.entity.ReOw;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByrid(Long rid);

//    @Query("SELECT Restaurant.rname,Owner.owname FROM Restaurant r,Owner o,ReOw rw WHERE r.rid = rw.reow_id And o.ow_id = rw.owre_id : id")
//    List<Restaurant> findAllReOw(@Param("id") Long rid);
}