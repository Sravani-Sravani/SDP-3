package com.klu.demo;
import org.springframework.data.repository.CrudRepository;

public interface CRepository extends CrudRepository<Student,Integer>
{
  
}