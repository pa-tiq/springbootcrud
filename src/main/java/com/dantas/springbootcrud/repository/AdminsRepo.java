package com.dantas.springbootcrud.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dantas.springbootcrud.models.Admin;

public interface AdminsRepo extends CrudRepository<Admin, Integer> {
    @Query(value = "SELECT CASE WHEN COUNT(1) > 0 THEN 'true' else 'false' END FROM admins WHERE id = :id", nativeQuery = true)
    public boolean exist(int id);
}
