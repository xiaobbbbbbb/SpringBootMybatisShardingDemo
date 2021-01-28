package com.zb.demo.repository;

import com.zb.demo.entity.TOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TOrderRespository extends JpaRepository<TOrder,String>  {
}
