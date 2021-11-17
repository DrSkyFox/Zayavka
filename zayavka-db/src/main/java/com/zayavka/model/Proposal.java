package com.zayavka.model;


import com.zayavka.dao.ProposalDAO;
import com.zayavka.enums.StatusProposal;
import lombok.*;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@Entity
@Table(name = "proposal")
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "guid", nullable = false, unique = true)
    private String guid;

    @Column(name ="description", nullable = false)
    private String description;

    @Enumerated(EnumType.ORDINAL)
    private StatusProposal statusProposal;

    @Column(name = "firstName", nullable = false, length = 64)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 64)
    private String lastName;

    @Column(name = "fullName", nullable = false, length = 128)
    private String fullName;

    @Column(name = "phoneNumber", nullable = false, length = 15)
    private Integer phoneNumber;

    @Column(name = "email", length = 64)
    private String email;

    @Column(name = "created", nullable = false)
    private Date created;


    public Proposal() {
    }

    public void setDateCreated() {
        this.created = Calendar.getInstance().getTime();
    }

    public Proposal(ProposalDAO proposal) {
        this.id = proposal.getId();
        this.guid = proposal.getGuid();
        this.description = proposal.getDescription();
        this.statusProposal = proposal.getStatusProposal();
        this.firstName = proposal.getFirstName();
        this.lastName = proposal.getLastName();
        this.fullName = proposal.getFullName();
        this.phoneNumber = proposal.getPhoneNumber();
        this.email = proposal.getEmail();
        this.created = proposal.getCreated();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proposal proposal = (Proposal) o;
        return Objects.equals(id, proposal.id) && Objects.equals(guid, proposal.guid) && Objects.equals(description, proposal.description) && statusProposal == proposal.statusProposal && Objects.equals(firstName, proposal.firstName) && Objects.equals(lastName, proposal.lastName) && Objects.equals(fullName, proposal.fullName) && Objects.equals(phoneNumber, proposal.phoneNumber) && Objects.equals(email, proposal.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, guid, description, statusProposal, firstName, lastName, fullName, phoneNumber, email);
    }
}
