package tn.arabsoft.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.arabsoft.auth.entity.Pays;

@Repository
public interface PaysRepository extends JpaRepository<Pays, String> {

}
