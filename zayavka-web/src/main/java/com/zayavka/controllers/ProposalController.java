package com.zayavka.controllers;

import com.zayavka.services.IProposalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/proposal")
public class ProposalController {

    private final IProposalService proposalService;

    @Autowired
    public ProposalController(IProposalService proposalService) {
        this.proposalService = proposalService;
    }





}
