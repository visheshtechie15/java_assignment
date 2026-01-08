package com.trip;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.*;

class RuleLoader {

    public RuleRepository load() throws Exception {

        InputStream is = Files.newInputStream(
                Path.of("D:/tripfactory/java_test/resources/rule.json")
        );

        if (is == null) {
            throw new IllegalStateException("rule.json not found in resources");
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(is);
        JsonNode rulesNode = root.get("rules");

        Map<PassportCountry, Map<Country, List<Visa>>> ruleMap = new HashMap<>();

        for (JsonNode rule : rulesNode) {

            Visa visa = new Visa(
                    Country.valueOf(rule.get("destinationCountry").asText()),
                    PassportCountry.valueOf(rule.get("passportCountry").asText()),
                    TravelPurpose.valueOf(rule.get("travelPurpose").asText()),
                    rule.get("stayDuration").get("maxDays").asInt(),
                    rule.get("decision").get("visaRequired").asBoolean(),
                    VisaType.valueOf(rule.get("decision").get("visaType").asText()),
                    rule.get("decision").get("processingDays").asInt(),
                    parseDocuments(rule),
                    parseWarnings(rule)
            );

            ruleMap
                    .computeIfAbsent(visa.p, k -> new HashMap<>())
                    .computeIfAbsent(visa.c, k -> new ArrayList<>())
                    .add(visa);
        }

        return new RuleRepository(ruleMap);
    }

    private List<DocumentType> parseDocuments(JsonNode rule) {
        List<DocumentType> docs = new ArrayList<>();
        for (JsonNode d : rule.get("decision").get("requiredDocuments")) {
            docs.add(DocumentType.valueOf(d.asText()));
        }
        return docs;
    }

    private List<String> parseWarnings(JsonNode rule) {
        List<String> warnings = new ArrayList<>();
        JsonNode w = rule.get("decision").get("warnings");
        if (w != null) {
            for (JsonNode x : w) warnings.add(x.asText());
        }
        return warnings;
    }
}
