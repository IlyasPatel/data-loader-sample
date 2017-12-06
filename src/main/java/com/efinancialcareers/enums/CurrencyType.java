package com.efinancialcareers.enums;

public enum CurrencyType  {

    GBP(1,"Pound Sterling (GBP)"),
    USD(2,"US Dollar (USD)"),
    EUR(3,"Euro (EUR)"),
    CHF(4,"Swiss Franc (CHF)"),
    JPY(5,"Yen (JPY)"),
    AUD(6,"Australian Dollar (AUD)"),
    SGD(7,"Singapore Dollar (SGD)"),
    HKD(8,"Hong Kong Dollar (HKD)"),
    CNY(9,"Yuan Renminbi (CNY)"),
    CAD(10,"Canadian Dollar (CAD)"),
    SEK(11,"Swedish Krona (SEK)"),
    DKK(12,"Danish Krone (DKK)"),
    NOK(13,"Norwegian Krone (NOK)"),
    ISK(14,"Iceland Krona (ISK)"),
    ZAR(15,"Rand (ZAR)"),
    AED(16,"UAE Dirham (AED)"),
    QAR(17,"Qatari Rial (QAR)"),
    BHD(18,"Bahraini Dinar (BHD)"),
    SAR(19,"Saudi Riyal (SAR)"),
    KWD(20,"Kuwaiti Dinar (KWD)"),
    OMR(21,"Rial Omani (OMR)"),
    NZD(22,"New Zealand Dollar (NZD)"),
    NGN(23,"Naira (NGN)"),
    INR(24,"Indian Rupee (INR)"),
    RUB(25,"Russian Ruble (RUB)"),
    MYR(115,"Malaysian Ringgit (MYR)");

    private final String name;
    private Integer id;

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    private CurrencyType(Integer id, String name) {
        this.name = name;
        this.id = id;
    }
}
