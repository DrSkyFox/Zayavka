package com.zayavka.repo;


import com.zayavka.enums.StatusProposal;
import com.zayavka.model.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProposalRepositories extends JpaRepository<Proposal, Long> {

    @Query("select p from Proposal p where p.statusProposal in (:status)")
    List<Proposal> findAll(@Param("status") List<StatusProposal> status);

    @Query("select p from Proposal p where p.id = :id")
    Optional<Proposal> findById(@Param("id") Long id);

    @Query("select p from Proposal p where p.guid = :guid")
    Optional<Proposal> findByGuid(@Param("guid") String guid);

    @Query("select p from Proposal p where p.fullName = :fullName")
    Optional<Proposal> findByFullName(@Param("fullName") String fullName);

    @Query("select p from Proposal p where p.phoneNumber = :phone")
    Optional<Proposal> findByPhoneNumber(@Param("phone") Integer phoneNumber);

    @Query("select p from Proposal p where p.email = :email")
    Optional<Proposal> findByEmail(@Param("email") String email);

    void deleteById(Long id);



}
