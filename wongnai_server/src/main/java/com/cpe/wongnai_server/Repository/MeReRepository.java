package com.cpe.wongnai_server.Repository;

import com.cpe.wongnai_server.entity.MeRe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeReRepository  extends JpaRepository< MeRe,Long >{
}
