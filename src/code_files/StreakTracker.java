package code_files;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.Component;
import java.time.LocalDate;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class StreakTracker {
    
    private static final Preferences PREFS = Preferences.userNodeForPackage(StreakTracker.class);
    private static final String KEY_STREAK = "streak";
    private static final String KEY_LAST_COMPLETED = "lastCompletedDate"; // yyyy-mm-dd
    private static final String KEY_LAST_PROMPT = "lastPromptDate";
    
    private StreakTracker() { }
    
    public static int getStreak(){
        return PREFS.getInt(KEY_STREAK, 0);
    }
    
    public static void promptIfNeeded(Component parent){
        LocalDate today = LocalDate.now();
        
        LocalDate lastPrompt = parseDate(PREFS.get(KEY_LAST_PROMPT,null));
        //for if they have already asked today
        if (today.equals(lastPrompt)){
            return;
        }
        
        int streak = PREFS.getInt(KEY_STREAK, 0);
        LocalDate lastCompleted = parseDate(PREFS.get(KEY_LAST_COMPLETED, null));
        //streak missed more that one day
        
        if (streak > 0 && lastCompleted != null && !lastCompleted.equals(today) && !lastCompleted.equals(today.minusDays(1))){
            streak = 0;
            PREFS.putInt(KEY_STREAK, 0);
        }
        
        int choice = JOptionPane.showConfirmDialog(parent, "Have you read your book today??", "Book Streak", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        //ale prompted tdy mark
        PREFS.put(KEY_LAST_PROMPT, today.toString());
        
        if (choice == JOptionPane.YES_OPTION){
            int newStreak = computeNewStreak(streak, lastCompleted, today);
            PREFS.putInt(KEY_STREAK, newStreak);
            PREFS.put(KEY_LAST_COMPLETED, today.toString());
            
            JOptionPane.showMessageDialog(parent, "Great!!! Your current streak is "+newStreak+" day "+(newStreak == 1 ? "" : "s")+".", "Book Streak", JOptionPane.INFORMATION_MESSAGE );
        } else {
            //closing also counts as saying no
            int oldStreak = streak;
            PREFS.putInt(KEY_STREAK, 0);
            PREFS.remove(KEY_LAST_COMPLETED);
            
            JOptionPane.showMessageDialog(parent, (oldStreak > 0)? "Streak lost! Old streak: "+oldStreak+" day"+(oldStreak == 1 ? "" : "s")+".":" Streak is 0.", "Book Streak", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private static int computeNewStreak(int currentStreak, LocalDate lastCompleted, LocalDate today){
        if (lastCompleted == null){
            return 1;
        }
        if (lastCompleted.equals(today)){
            return currentStreak; //alr counted tdy
        }
        if (lastCompleted.equals(today.minusDays(1))){ //the day after, consecutive day
            return currentStreak + 1;
        }
        
        return 1;//restart
    }
    
    private static LocalDate parseDate(String s){
        if (s == null || s.isBlank()){
            return null;
        }
        try{
            return LocalDate.parse(s);
        }catch (Exception ex){
            return null;
        }
    }
    
}
