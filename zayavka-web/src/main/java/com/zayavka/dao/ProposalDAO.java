package com.zayavka.dao;

import com.zayavka.enums.StatusProposal;
import com.zayavka.model.Proposal;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Objects;


@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
public class ProposalDAO {

    private Long id;

    private String guid;

    @NotEmpty
    private String description;

    private StatusProposal statusProposal;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    private String fullName;

    @NotEmpty
    private Integer phoneNumber;

    @Email
    @NotEmpty
    private String email;

    private Date created;

    public ProposalDAO(Proposal proposal) {
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
        ProposalDAO that = (ProposalDAO) o;
        return Objects.equals(id, that.id) && Objects.equals(guid, that.guid) && Objects.equals(description, that.description) && statusProposal == that.statusProposal && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(fullName, that.fullName) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(email, that.email) && Objects.equals(created, that.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, guid, description, statusProposal, firstName, lastName, fullName, phoneNumber, email, created);
    }
}
