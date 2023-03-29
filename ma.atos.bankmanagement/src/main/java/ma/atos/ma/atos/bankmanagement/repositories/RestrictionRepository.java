package ma.atos.ma.atos.bankmanagement.repositories;

import ma.atos.ma.atos.bankmanagement.entities.Compte;
import ma.atos.ma.atos.bankmanagement.entities.Restriction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RestrictionRepository extends JpaRepository<Restriction, Long> {

}
