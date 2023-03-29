package ma.atos.ma.atos.bankmanagement.services;

import ma.atos.ma.atos.bankmanagement.Dtos.CompteDto;
import ma.atos.ma.atos.bankmanagement.entities.Compte;
import ma.atos.ma.atos.bankmanagement.exceptions.CompteException;
import ma.atos.ma.atos.bankmanagement.exceptions.TierNotFoundExeption;

import java.util.List;

public interface CompteService {
    List<CompteDto> listComptes() throws CompteException;
    CompteDto getCompte(Long ribCompte) throws CompteException;
    List<CompteDto> getCompteByTier(String numClient) throws CompteException, TierNotFoundExeption;
    void createCompte(CompteDto compteDto) throws CompteException;
    void deleteCompte(Long ribCompte) throws CompteException;
}
