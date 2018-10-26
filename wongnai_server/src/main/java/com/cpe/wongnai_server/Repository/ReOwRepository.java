package com.cpe.wongnai_server.Repository;

import com.cpe.wongnai_server.entity.ReOw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReOwRepository  extends JpaRepository<ReOw,Long >{
}

