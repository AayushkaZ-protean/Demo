package com.protean.openfinance.service.wrappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nsdl.beckn.api.enums.ContextAction;
import com.nsdl.beckn.api.model.common.*;
import com.nsdl.beckn.api.model.onupdate.OnUpdateRequest;
import com.nsdl.beckn.api.model.update.UpdateMessage;
import com.nsdl.beckn.api.model.update.UpdateRequest;
import com.protean.openfinance.dto.searchwrapper.LoanUpdateDto;
import com.protean.openfinance.exception.GenericException;
import com.protean.openfinance.utill.LoanUpdateEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UpdateService extends BaseService {

    public OnUpdateRequest loanUpdate(LoanUpdateDto loanUpdateDto) throws Exception {

        UpdateRequest updateRequest = new UpdateRequest();
        new OnUpdateRequest();
        OnUpdateRequest onUpdateRequest;

        Context context = openFinanceUtils.prepareRrquestContext(loanUpdateDto.getOnStatusRequest().getContext(), ContextAction.UPDATE.value());
        UpdateMessage updateMessage = prepareUpdateMessage(loanUpdateDto);
        updateRequest.setContext(context);
        updateRequest.setMessage(updateMessage);

        String onUpdateResponseString = consumer.postOnAdaptor(snakeCaseMapper.writeValueAsString(updateRequest),
                ContextAction.UPDATE.value(),
                MessageFormat.format("{0}{1}", "UPDATE_", loanUpdateDto.getUpdateType()),
                updateRequest.getContext());

        onUpdateRequest = snakeCaseMapper.readValue(onUpdateResponseString, OnUpdateRequest.class);

        log.info("on update_ {} response :{}", loanUpdateDto.getUpdateType(), onUpdateResponseString);

        return onUpdateRequest;
    }

    private UpdateMessage prepareUpdateMessage(LoanUpdateDto loanUpdateDto) throws JsonProcessingException {

        UpdateMessage message = new UpdateMessage();
        Order order = new Order();

        String orderId = loanUpdateDto.getOnStatusRequest().getMessage().getOrder().getId();
        message.setUpdateTarget("payments");

        Time time = new Time();
        time.setLabel(loanUpdateDto.getUpdateType());

        Payment payment = new Payment();
        payment.setTime(time);

        setPaymentParams(loanUpdateDto, payment);

        order.setId(orderId);

        List<Payment> paymentList = new ArrayList<>(1);
        paymentList.add(payment);
        order.setPayments(paymentList);
        message.setOrder(order);

        return message;
    }


    /**
     * @param loanUpdateDto
     * @param payment       amount is required if pre_part_payment is selected
     *                      foreclosure and missed_emi_payment amount is not needed
     */
    private void setPaymentParams(LoanUpdateDto loanUpdateDto, Payment payment) {

        if (loanUpdateDto.getUpdateType().equalsIgnoreCase(LoanUpdateEnum.PRE_PART_PAYMENT.value())) {

            PaymentParams params = new PaymentParams();

            if (StringUtils.isNotBlank(loanUpdateDto.getAmount())) {
                params.setAmount(loanUpdateDto.getAmount());
                params.setCurrency(loanUpdateDto.getCurrency());
                payment.setParams(params);
            } else {
                throw new GenericException("amount not provided for pre part payment");
            }

        }
    }
}
