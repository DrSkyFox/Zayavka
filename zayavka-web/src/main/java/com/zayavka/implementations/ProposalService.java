package com.zayavka.implementations;

import com.zayavka.dao.ProposalDAO;
import com.zayavka.enums.StatusProposal;
import com.zayavka.model.Proposal;
import com.zayavka.repo.ProposalRepositories;
import com.zayavka.services.IProposalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
public class ProposalService implements IProposalService {

    private final ProposalRepositories repositories;

    @Autowired
    public ProposalService(ProposalRepositories repositories) {
        this.repositories = repositories;
    }

    @Override
    public void createNewProposal(ProposalDAO proposal) {
      log.info("Create new proposal: {}", proposal);
      proposal.setCreated(Calendar.getInstance().getTime());
      proposal.setStatusProposal(StatusProposal.NEW);
      repositories.save(new Proposal(proposal));
    }

    @Override
    public void removeProposalById(Long id) {
        if(repositories.findById(id).isPresent()) {
            repositories.deleteById(id);
        }
    }

    @Override
    public List<ProposalDAO> findAllProposals(List<StatusProposal> statusProposalList) {
        return repositories.findAll(statusProposalList).stream().map(ProposalDAO::new).collect(Collectors.toList());
    }

    @Override
    public ProposalDAO updateProposal(ProposalDAO proposal) {
        proposal = new ProposalDAO(repositories.save(new Proposal(proposal)));
        return proposal;
    }

    @Override
    public ProposalDAO findProposalById(Long id) {
        return repositories.findById(id).map(ProposalDAO::new).orElse(null);
    }

    @Override
    public ProposalDAO findProposalByFullName(String fullName) {
        return repositories.findByFullName(fullName).map(ProposalDAO::new).orElse(null);
    }

    @Override
    public ProposalDAO findProposalByPhoneNumber(Integer phoneNumber) {
        return repositories.findByPhoneNumber(phoneNumber).map(ProposalDAO::new).orElse(null);
    }

    @Override
    public ProposalDAO findProposalByGuid(String guid) {
        return repositories.findByGuid(guid).map(ProposalDAO::new).orElse(null);
    }
}
