package com.protean.openfinance.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "\"user\"")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "applicant_name")
	private String applicantName;

	@Column(name = "user_code", unique = true)
	private String userCode;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "dob")
	private String dob;

	@Column(name = "address_line1")
	private String addressLine1;

	@Column(name = "address_line2")
	private String addressLine2;

	@Column(name = "address_line3")
	private String addressLine3;

	@Column(name = "city_town_district")
	private String cityOrTownOrDistrict;

	@Column(name = "city")
	private String city;

	@Column(name = "town")
	private String town;

	@Column(name = "district")
	private String district;

	@Column(name = "pin_code")
	private String pinCode;

	@Column(name = "employment_type")
	private String employmentType;

	@Column(name = "income")
	private String income;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "account_aggregator_id")
	private String accountAggregatorId;











}
