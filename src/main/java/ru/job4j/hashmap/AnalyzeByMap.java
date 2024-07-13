package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int sum = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        return count == 0 ? 0 : (double) sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int sum = 0;
            int count = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
            labels.add(new Label(pupil.name(), count == 0 ? 0 : (double) sum / count));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new LinkedHashMap<>();
        Map<String, Integer> subjectCounts = new LinkedHashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String subjectName = subject.name();
                int score = subject.score();

                subjectScores.put(subjectName, subjectScores.getOrDefault(subjectName, 0) + score);
                subjectCounts.put(subjectName, subjectCounts.getOrDefault(subjectName, 0) + 1);
            }
        }
        List<Label> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : subjectScores.entrySet()) {
            String subjectName = entry.getKey();
            int totalScore = entry.getValue();
            int count = subjectCounts.get(subjectName);
            double averageScore = (double) totalScore / count;

            result.add(new Label(subjectName, averageScore));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        int sum = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
                if (count == 3) {
                    Label label = new Label(pupil.name(), sum);
                    labels.add(label);
                    sum = 0;
                    count = 0;
                }
                labels.sort(Comparator.naturalOrder());
            }
        }
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new LinkedHashMap<>();
        Map<String, Integer> subjectCounts = new LinkedHashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String subjectName = subject.name();
                int score = subject.score();

                subjectScores.put(subjectName, subjectScores.getOrDefault(subjectName, 0) + score);
                subjectCounts.put(subjectName, subjectCounts.getOrDefault(subjectName, 0) + 1);
            }
        }
        List<Label> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : subjectScores.entrySet()) {
            String subjectName = entry.getKey();
            int totalScore = entry.getValue();
            int count = subjectCounts.get(subjectName);
            double averageScore = (double) totalScore / count;

            result.add(new Label(subjectName, totalScore));
            result.sort(Comparator.naturalOrder());
        }
        return result.get(result.size() - 1);
    }
}