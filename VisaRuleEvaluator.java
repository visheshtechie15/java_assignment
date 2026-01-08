package com.trip;

import java.util.*;

class VisaRuleEvaluator {

    private final RuleRepository repository;

    VisaRuleEvaluator(RuleRepository repository) {
        this.repository = repository;
    }

    Visa evaluate(Input_details input) {

        Map<Country, List<Visa>> countryMap =
                repository.getRules().get(input.p1);

        if (countryMap == null) {
            return null;
        }

        List<Visa> visas = countryMap.get(input.c1);
        if (visas == null) {
            return null;
        }

        for (Visa v : visas) {
            if (v.t == input.t1 && input.stay_duartion <= v.stayduration) {
                return v;
            }
        }

        return null;
    }

}
