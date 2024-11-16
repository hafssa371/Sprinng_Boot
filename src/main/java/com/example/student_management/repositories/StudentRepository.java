package com.example.student_management.repositories;

import com.example.student_management.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    //Recherche d'1 etudiant par son id
    Student findById(int id);

    // Requête personalisée pr compter les etudiants par année de naissance
    @Query("SELECT YEAR (s.dateNaissance),COUNT(s) FROM Student s GROUP BY YEAR (s.dateNaissance)")
    Collection<Object[]> findNbrStudentByYear();

}
