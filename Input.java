package com.trip;
import java.util.Scanner;
import java.sql.SQLOutput;
import java.util.ArrayList;

class Input_details
{
    public Country c1;
    public PassportCountry p1;
    public TravelPurpose t1;
    public int stay_duartion;


    public Input_details(Country c,PassportCountry p,TravelPurpose t, int days)
    {
        this.c1=c;
        this.p1=p;
        this.t1=t;
        this.stay_duartion=days;
    }

}

public class Input {
    public static void main(String[] args) {



                Scanner sc = new Scanner(System.in);

                System.out.println(
                        "Enter the country you want to visit:\n" +
                                "AUSTRALIA, CANADA, DUBAI, FRANCE, GERMANY, IRELAND, ITALY,\n" +
                                "JAPAN, MALAYSIA, MEXICO, NETHERLANDS, NEW_ZEALAND,\n" +
                                "SINGAPORE, SOUTH_KOREA, SPAIN, SWITZERLAND,\n" +
                                "THAILAND, UK, USA"
                );

                Country country = Country.valueOf(sc.next().toUpperCase());

                System.out.println("Enter your passport country (INDIA, USA, CHINA, BRAZIL, JAPAN, CANADA):");
                PassportCountry passportCountry =
                        PassportCountry.valueOf(sc.next().toUpperCase());

                System.out.println("Enter travel purpose (TOURISM, BUSINESS, STUDENT):");
                TravelPurpose travelPurpose =
                        TravelPurpose.valueOf(sc.next().toUpperCase());

                System.out.println("Enter stay duration (days):");
                int stayDuration = sc.nextInt();


                Input_details i = new Input_details(
                        country,
                        passportCountry,
                        travelPurpose,
                        stayDuration
                );

                try {

                    RuleLoader loader = new RuleLoader();
                    RuleRepository repository = loader.load();


                    VisaRuleEvaluator evaluator = new VisaRuleEvaluator(repository);
                    Visa result = evaluator.evaluate(i);

                    if (result != null) {
                        VisaDecision decision = new VisaDecision(result);

                        System.out.println("Visa Required: " + decision.visaRequired);
                        System.out.println("Visa Type: " + decision.visaType);
                        System.out.println("Documents: " + decision.documents);
                        System.out.println("Processing Days: " + decision.processingDays);
                        System.out.println("Warnings: " + decision.warnings);
                    } else {
                        System.out.println("No matching visa rule found");
                    }


                } catch (Exception e) {
                    System.out.println("Error loading visa rules: " + e.getMessage());
                }

                sc.close();
            }
        }


