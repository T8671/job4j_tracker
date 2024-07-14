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
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            labels.add(new Label(pupil.name(), (double) sum / pupil.subjects().size()));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, ScoreData> subjectDataMap = new LinkedHashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {

                if (!subjectDataMap.containsKey(subject.name())) {
                    subjectDataMap.put(subject.name(), new ScoreData());
                }

                ScoreData subjectData = subjectDataMap.get(subject.name());
                subjectData.totalScore += subject.score();
                subjectData.count++;
            }
        }

        List<Label> result = new ArrayList<>();
        for (Map.Entry<String, ScoreData> entry : subjectDataMap.entrySet()) {
            result.add(new Label(entry.getKey(), (double) entry.getValue().totalScore / entry.getValue().count));
        }

        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            labels.add(new Label(pupil.name(), sum));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, ScoreData> subjectData = new LinkedHashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {

                if (!subjectData.containsKey(subject.name())) {
                    subjectData.put(subject.name(), new ScoreData());
                }

                ScoreData data = subjectData.get(subject.name());
                data.totalScore += subject.score();
                data.count++;
            }
        }

        String bestSubjectName = null;
        double highestAverageScore = -1;

        for (Map.Entry<String, ScoreData> entry : subjectData.entrySet()) {
            double averageScore = (double) entry.getValue().totalScore / entry.getValue().count;

            if (averageScore > highestAverageScore) {
                highestAverageScore = averageScore;
                bestSubjectName = entry.getKey();
            }
        }

        return new Label(bestSubjectName, subjectData.get(bestSubjectName).totalScore);
    }

    private static class ScoreData {
        int totalScore = 0;
        int count = 0;
    }
}