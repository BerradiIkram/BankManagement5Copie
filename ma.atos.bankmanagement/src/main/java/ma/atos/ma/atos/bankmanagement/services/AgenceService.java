package ma.atos.ma.atos.bankmanagement.services;

import ma.atos.ma.atos.bankmanagement.Dtos.AgenceDto;
import ma.atos.ma.atos.bankmanagement.entities.Agence;
import ma.atos.ma.atos.bankmanagement.exceptions.AgenceException;

import java.util.List;

public interface AgenceService {

    List<AgenceDto> listAgences() throws AgenceException;
    AgenceDto getAgence(String codeAgence) throws AgenceException;

    void createAgence(AgenceDto agenceDto) throws AgenceException;

    public void deleteAgence(String codeAgence ) throws AgenceException;




}
