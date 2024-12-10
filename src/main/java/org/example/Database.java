package org.example;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private final List<Candidate> candidates;
    private final String filePath;

    public Database(String filePath) {
        this.filePath = filePath;
        this.candidates = new ArrayList<>();
        loadData();
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
        saveData();
    }

    public void removeCandidate(String registrationNumber) {
        candidates.removeIf(candidate -> candidate.getRegistrationNumber().equals(registrationNumber));
        saveData();
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    private void saveData() {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            for (Candidate candidate : candidates) {
                writer.write(candidate.getGender() + "; " +
                        candidate.getRegistrationNumber() + "; " +
                        candidate.getRegistrationDate() + "; " +
                        candidate.getAboutYourself() + "; " +
                        candidate.getPartnerRequirements());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                candidates.add(new Candidate(
                        data[0],
                        data[1],
                        LocalDate.parse(data[2]),
                        data[3],
                        data[4]
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}