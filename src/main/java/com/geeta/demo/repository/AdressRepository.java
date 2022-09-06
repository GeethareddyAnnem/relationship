package com.geeta.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.geeta.demo.entity.Adress;
public interface AdressRepository extends JpaRepository<Adress,Integer>{
    
}
