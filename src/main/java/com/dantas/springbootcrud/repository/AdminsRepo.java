package com.dantas.springbootcrud.repository;

import org.springframework.data.repository.CrudRepository;

import com.dantas.springbootcrud.models.Admin;

public interface AdminsRepo extends CrudRepository<Admin, Integer> {

}
