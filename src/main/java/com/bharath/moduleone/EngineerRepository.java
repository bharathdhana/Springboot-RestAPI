package com.bharath.moduleone;

import org.springframework.data.jpa.repository.JpaRepository;

//Can Either use CrudRepository
public interface EngineerRepository extends JpaRepository<Engineer,Integer> {

}
