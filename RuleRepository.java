package com.trip;

import java.util.*;

public class RuleRepository {

    private final Map<PassportCountry, Map<Country, List<Visa>>> rules;

    public RuleRepository(Map<PassportCountry, Map<Country, List<Visa>>> rules) {
        this.rules = rules;
    }

    public Map<PassportCountry, Map<Country, List<Visa>>> getRules() {
        return rules;
    }
}
