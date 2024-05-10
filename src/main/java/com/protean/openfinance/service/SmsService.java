package com.protean.openfinance.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.protean.openfinance.model.SmsRequest;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SmsService {

//	private static final String TWILIO_USERNAME = "AC11b47d2a6cc635641393b915ea73d356";
//	private static final String TWILIO_PWD = "5f2131eb498059845f4366ee6cc11dcc";
//	private static final String TWILIO_SENDER_PHONE_NO =  "+14124246427";
	
	@Value("${twilio.account-id}")
	private String twilioUsername;
	
	@Value("${twilio.account-secret}")
	private String twilioPassword;
	
	@Value("${twilio.sender-phone-no}")
	private String twilioSenderPhoneNo;
	
	
//	public static void main(String[] args) {
//		Twilio.init("AC0afceef8564c910175e78ac212130249", "edb5291dd2c01ed5ecfbd48c1517d496");
//		Message.creator(new PhoneNumber("+918872477774"), new PhoneNumber("+18662410364"), "Hello from Twilio 📞")
//				.create();
//	}

	public String sendSms(SmsRequest request) {
		String status = "SUCCESS";
		sendTwilioMsg(request);
		return status;
	}
	
	private void sendTwilioMsg(SmsRequest request) {
		Twilio.init(twilioUsername, twilioPassword);
		Message.creator(new PhoneNumber(request.getMobile()), new PhoneNumber(twilioSenderPhoneNo), request.getMsg())
				.create();
	}
	

}
