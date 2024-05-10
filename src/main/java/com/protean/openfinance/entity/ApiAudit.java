package com.protean.openfinance.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "api_audit")
@Data
public class ApiAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "action")
	private String action;

	@Column(name = "transaction_id")
	private String transactionId;

	@Column(name = "aa_id")
	private String aa_id;
	
	@Column(name = "message_id")
	private String messageId;
	
	@Column(name = "contact_number")
	private String contactNumber;
	
	//@Column(name = "json", columnDefinition = "TEXT")
	//@Type(type = "jsonb")
	//@Column(name = "json")
	//@Column(name = "json", columnDefinition = "jsonb")

	private String json;
	
	@Column(name = "request", columnDefinition = "TEXT")
	private String request;
	
	@Column(name = "response", columnDefinition = "TEXT")
	private String response;

	@Column(name = "buyer_id")
	private String buyerId;

	@Column(name = "seller_id")
	private String sellerId;

	@Column(name = "event_descriptor")
	private String eventDescriptor;
	
	@Column(name = "added_on")
	private LocalDateTime createdOn;
	
}
