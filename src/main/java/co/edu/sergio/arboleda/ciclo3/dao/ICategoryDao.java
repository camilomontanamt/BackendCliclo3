package co.edu.sergio.arboleda.ciclo3.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.sergio.arboleda.ciclo3.entity.Category;

public interface ICategoryDao extends JpaRepository<Category, Integer>{

}
