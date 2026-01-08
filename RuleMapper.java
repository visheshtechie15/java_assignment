
package com.trip;
import java.util.ArrayList;
import java.util.List;


import java.util.List;

class Visa {

    final Country c;
    final PassportCountry p;
    final TravelPurpose t;
    final int stayduration;
    final boolean visaRequired;
    final VisaType visaType;
    final int estimatedDays;
    final List<DocumentType> documents;
    final List<String> warnings;

    Visa(Country c,
         PassportCountry p,
         TravelPurpose t,
         int stayduration,
         boolean visaRequired,
         VisaType visaType,
         int estimatedDays,
         List<DocumentType> documents,
         List<String> warnings) {

        this.c = c;
        this.p = p;
        this.t = t;
        this.stayduration = stayduration;
        this.visaRequired = visaRequired;
        this.visaType = visaType;
        this.estimatedDays = estimatedDays;
        this.documents = documents;
        this.warnings = warnings;
    }
}

enum Country
{
    AUSTRALIA, CANADA, DUBAI, FRANCE, GERMANY, IRELAND, ITALY
    , JAPAN, MALAYSIA, MEXICO, NETHERLANDS, NEW_ZEALAND, SINGAPORE, SOUTH_KOREA, SPAIN, SWITZERLAND, THAILAND, UK, USA
}
enum PassportCountry
{
    INDIA, USA, CHINA, BRAZIL, JAPAN, CANADA
}
enum TravelPurpose
{
    TOURISM, BUSINESS, STUDENT
}
enum VisaType
{
    NONE, SCHENGEN_TOURIST, SCHENGEN_BUSINESS, STANDARD_VISITOR, TEMPORARY_VISITOR, TEMPORARY_RESIDENT,
    ELECTRONIC_TRAVEL_AUTHORITY, VISIT_PASS, VISA_EXEMPT, VISA_ON_ARRIVAL,STUDY_VISA,
    TOURIST, VISITOR, F1_STUDENT, TIER4_STUDENT, STUDY_PERMIT, SUBCLASS_500_STUDENT, STUDENT_VISA, STUDENT_PASS
}
enum DocumentType {
    PASSPORT, PHOTOGRAPH, BANK_STATEMENT, TRAVEL_INSURANCE, RETURN_TICKET,
    ACCOMMODATION_PROOF, APPLICATION_FORM, EMPLOYMENT_LETTER, EMAIL_ADDRESS,
    CREDIT_CARD, HOTEL_BOOKING, BUSINESS_LETTER, COMPANY_REGISTRATION,
    ACADEMIC_TRANSCRIPTS, ENGLISH_PROFICIENCY_TEST, ENGLISH_LANGUAGE_TEST, I20_FORM,
    SEVIS_FEE_RECEIPT, FINANCIAL_PROOF,
    CAS_LETTER, TUBERCULOSIS_TEST, ACCEPTANCE_LETTER,
    MEDICAL_EXAMINATION, COE_CERTIFICATE, HEALTH_INSURANCE,
    HEALTH_EXAMINATION, UNIVERSITY_ADMISSION, BLOCKED_ACCOUNT_PROOF,
    GERMAN_LANGUAGE_CERTIFICATE, CAMPUS_FRANCE_APPROVAL, FRENCH_LANGUAGE_TEST,
    IPA_LETTER, MEDICAL_CERTIFICATE,OFFER_LETTER
}

