package tn.arabsoft.auth.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.arabsoft.auth.entity.LibredemandeEntity;

@Repository


public interface LibredemandeRepository extends JpaRepository<LibredemandeEntity, Long> {


}