package com.udemy.java.test;

import com.udemy.java.assignment.PaymentScreenPage;
import org.testng.Assert;

import java.util.function.Consumer;

public class PaymentScreenActions {

    public static final Consumer<PaymentScreenPage> freeCoupon = (p) -> p.applyPromocode("FREEUDEMY");
    public static final Consumer<PaymentScreenPage> discountedCoupon = (p) -> p.applyPromocode("PARTIALUDEMY");
    public static final Consumer<PaymentScreenPage> valiadCC = (p) -> p.enterCC("4111111111111111", "2023", "123");
    public static final Consumer<PaymentScreenPage> invaliadCC = (p) -> p.enterCC("4111111111111111", "2020", "123");
    public static final Consumer<PaymentScreenPage> buy = (p) -> p.buyProduct();

   //validations

    public static final Consumer<PaymentScreenPage> successfulPurchase = (p) -> Assert.assertEquals(p.getStatus(), "PASS");
    public static final Consumer<PaymentScreenPage> failedPurchase = (p) -> Assert.assertEquals(p.getStatus(), "FAIL");
}
