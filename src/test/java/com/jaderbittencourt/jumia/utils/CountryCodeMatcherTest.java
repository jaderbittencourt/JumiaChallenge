package com.jaderbittencourt.jumia.utils;


import com.jaderbittencourt.jumia.enums.Country;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CountryCodeMatcherTest {

    @Test
    public void shouldReturnNullForNoCountryCodeMatch() {
        assertNull(CountryCodeMatcher.matchCountryCode("123"));
    }

    @Test
    public void shouldReturnCountryForCountryCodeMatch() {
        assertEquals(Country.MOROCCO, CountryCodeMatcher.matchCountryCode("(212) 6617344445"));
    }

    @Test
    public void shouldReturnNullForPhoneMatch() {
        assertNull(CountryCodeMatcher.matchPhone("123"));
    }

    @Test
    public void shouldReturnCountryForPhoneMatch() {
        assertEquals(Country.MOROCCO, CountryCodeMatcher.matchPhone("(212) 698054317"));
    }
}
