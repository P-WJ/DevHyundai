package org.example;

import java.util.ArrayList;
import java.util.List;

public class StudentScores {

   private List<Integer> scores = new ArrayList<>();

   public void addScore(int score) {
       scores.add(score);
   }

   public int getScoreCount() {
       return scores.size();
   }

   public boolean isEmpty() {
       return scores.isEmpty();
   }

   public Integer[] getScoresAsArray() {
       return scores.toArray(new Integer[scores.size()]);
   }
}
