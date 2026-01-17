
package code_files;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.ArrayList;


public class Validator {
    
    private boolean changes_made;
    private boolean changes_saved;
    
    /*
    Checks if an input from an option pane is null 
    */
    
    public boolean setChangesMade(boolean value)
    {
        changes_made = value;
        return changes_made;
    }
    
    public boolean setChangesSaved(boolean value)
    {
        changes_saved = value;
        return changes_saved;
    }
    
        public boolean getChangesMade()
    {
        return changes_made;
    }
    
    public boolean getChangesSaved()
    {
        return changes_saved;
    }
    
    public boolean isEmpty(String input)
    {
        try{
            if(input.isBlank() || input.isEmpty() ) { 
            return true;
            }
        }
        catch(NullPointerException e)
        {
                return true;
        }
        return false;
    }
    
    public boolean isEmpty(ArrayList<String> label_texts)
    {
        try{
            for (String text : label_texts)
            {
                if(isEmpty(text))
                       return true;
            }
        }
        catch(NullPointerException e)
        {
            return true;
        }
        return false;
    }
    
    /*
    Checks if an input is a number if required
    */
    public boolean isNumeric(String string_num_value)
    {
        try
        {
            int numeric_val = Integer.parseInt(string_num_value);
            return true;
        }
        catch(NumberFormatException e)
        {
          return false;
        }
    }
    
    
    /*
    Checks if changes were made on the window
    */
       
    public boolean changesMade()
    {
      if(changes_made)
      {
          return true;
      }
      return false;
    }
    
    /*
    Checks if changes were saved on the window
    */
    
    public boolean changesSaved()
    {
        if(changes_saved)
        {
            return true;
        }
        return false;
    }
}
