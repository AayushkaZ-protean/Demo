package com.protean.openfinance.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "\"applicant_details\"")
@Data
public class ApplicantDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dob")
    private String dob;

    @Column(name = "pan")
    private String pan;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "employment_type")
    private String employmentType;

    @Column(name = "income")
    private String income;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "udyam_number")
    private String udyamNumber;

    @Column(name = "address_l1")
    private String addressL1;

    @Column(name = "address_l2")
    private String addressL2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "aa_id")
    private String aa_id;

    @Column(name = "aa_code")
    private String aaCode;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "bureauConsent")
    private String bureauConsent;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @Column(name = "status")
    private String status;

    @Column(name = "igm_issue_id")
    private String igmIssueId;

    @Column(name = "agent_id")
    private String agentId;

    @Column(name = "bpp_id")
    private String bppId;

    @Column(name = "bpp_name")
    private String bppName;

    @OneToMany(mappedBy = "applicantDetails", cascade = CascadeType.ALL)
    private List<IgmIssue> igmIssues;
}
