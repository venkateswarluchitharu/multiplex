package com.multiplex.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiplex.entity.MultiplexEntity;


public interface MultiplexRepository extends JpaRepository<MultiplexEntity, Serializable> {

}
