package ma.atos.ma.atos.bankmanagement.repositories;

import ma.atos.ma.atos.bankmanagement.Dtos.PersonneMoraleDto;
import ma.atos.ma.atos.bankmanagement.entities.PersonneMorale;
import ma.atos.ma.atos.bankmanagement.entities.PersonnePhysique;
import ma.atos.ma.atos.bankmanagement.entities.Tier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TierRepository extends JpaRepository<Tier, Long> {
    Tier findByNumClient(String numClient);


    List<PersonnePhysique> findPPByTierType(String type, PageRequest pageable);

    List<PersonneMorale> findPMByTierType(String type, PageRequest pageable);

    Tier findByTierTypeEqualsAndIdClientEquals(String type, Long idClient);
    Tier findByTierTypeEqualsAndNumClientEquals(String type,String num);
    void deleteTierByNumClient(String num);

    List<PersonneMorale> findByTierTypeEqualsAndNumClientContains(String type, String numClient);

    /*
        @Query("select c from PersonneMorale c where c.raionSociale like :kw " )
        List<PersonneMorale> findByTierTypeEqualsAndkeywordEquals(@Param("kw") String keywords,@Param("PM")String type);

     */
    Long countAllByTierTypeEquals(String type);

    Page<PersonneMorale> findByTierTypeEqualsAndNumClientContains(String type, String numClient, PageRequest pageable);


    Page<PersonnePhysique> findPPByTierTypeEqualsAndNumClientContains(String type, String numClient,PageRequest pageable);
}