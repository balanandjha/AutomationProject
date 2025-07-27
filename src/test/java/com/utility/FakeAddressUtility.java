package com.utility;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

import java.util.Locale;

public class FakeAddressUtility {


    public static AddressPOJO getFakeAddress() {
        Faker faker = new Faker(Locale.US);
        String company = faker.company().name();
        AddressPOJO addressPOJO = new AddressPOJO(faker.phoneNumber().cellPhone(), faker.company().name(),
                faker.address().streetAddress(), faker.address().secondaryAddress(),
                faker.address().city(), faker.numerify("#####"), faker.phoneNumber().phoneNumber(),
                faker.lorem().sentence(), faker.address().cityName(), faker.address().state());
        return addressPOJO;

    }


}
