package com.zayavka.services;

import com.zayavka.dao.ProposalDAO;
import com.zayavka.enums.StatusProposal;

import java.util.List;

public interface IProposalService {

    void createNewProposal(ProposalDAO proposal);

    void removeProposalById(Long id);

    List<ProposalDAO> findAllProposals(List<StatusProposal> statusProposalList);

    ProposalDAO updateProposal(ProposalDAO proposal);

    ProposalDAO findProposalById(Long id);

    ProposalDAO findProposalByFullName(String fullName);

    ProposalDAO findProposalByPhoneNumber(Integer phoneNumber);

    ProposalDAO findProposalByGuid(String guid);


}
