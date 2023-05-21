package com.kodlamaio.commonpackage.utils.dto;

import com.kodlamaio.commonpackage.utils.constants.Paths;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateRentalPaymentRequest extends PaymentRequest {

    private double price;
}