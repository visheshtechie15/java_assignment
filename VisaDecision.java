package com.trip;

import java.util.List;

class VisaDecision {

    final boolean visaRequired;
    final VisaType visaType;
    final List<DocumentType> documents;
    final int processingDays;
    final List<String> warnings;

    VisaDecision(Visa visa)
    {
        this.visaRequired = visa.visaRequired;
        this.visaType = visa.visaType;
        this.documents = visa.documents;
        this.processingDays = visa.estimatedDays;
        this.warnings = visa.warnings;
    }
}
