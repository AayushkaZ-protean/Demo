package com.protean.openfinance.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "igm_issue")
@Data
public class IgmIssue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "issue_id")
	private String issueId;

	@ManyToOne
	@JoinColumn(name = "applicant_id")
	private ApplicantDetails applicantDetails;

	@Column(name = "status")
	private String status;

	@Column(name = "action")
	private String action;

	@Column(name = "request")
	private String request;

	@Column(name = "response")
	private String response;

	@Column(name = "status_response")
	private String statusResponse;

	@Column(name = "created_on")
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;
	
	@Column(name = "transaction_id")
	private String transactionId;
	
}
