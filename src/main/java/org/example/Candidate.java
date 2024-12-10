package org.example;

import java.time.LocalDate;

public class Candidate {
    private String gender;
    private String registrationNumber;
    private LocalDate registrationDate;
    private String aboutYourself;
    private String partnerRequirements;

    public Candidate(String gender, String registrationNumber, LocalDate registrationDate, String aboutYourself, String partnerRequirements) {
        this.gender = gender;
        this.registrationNumber = registrationNumber;
        this.registrationDate = registrationDate;
        this.aboutYourself = aboutYourself;
        this.partnerRequirements = partnerRequirements;
    }

    public String getGender() {
        return gender;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getAboutYourself() {
        return aboutYourself;
    }

    public String getPartnerRequirements() {
        return partnerRequirements;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "gender='" + gender + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", registrationDate=" + registrationDate +
                ", aboutYourself='" + aboutYourself + '\'' +
                ", partnerRequirements='" + partnerRequirements + '\'' +
                '}';
    }
}