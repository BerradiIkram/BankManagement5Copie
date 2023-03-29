package ma.atos.ma.atos.bankmanagement.repositories;

import ma.atos.ma.atos.bankmanagement.entities.Agence;
import ma.atos.ma.atos.bankmanagement.entities.Gestionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface GestionnaireRepository extends JpaRepository<Gestionnaire, Long> {

}
