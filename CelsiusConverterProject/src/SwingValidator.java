

import javax.swing.*;
import javax.swing.text.JTextComponent;
/**
 * Katie S. Johnston
 * ITDEV-140 -- Programming in JAVA
 * Spring 2015
 * 4 -24 - 15 */
public class SwingValidator
{
    public boolean isPresent(JTextComponent c, String fieldName)
    {
        if (c.getText().length() == 0)
        {
            showMessage(c, fieldName + " is a required field.");
            c.requestFocusInWindow();
            return false;
        }
        return true;
    }

    public boolean isInteger(JTextComponent c, String fieldName)
    {
        try
        {
            int i = Integer.parseInt(c.getText());
            return true;
        }
        catch (NumberFormatException e)
        {
            showMessage(c, fieldName + " must be an integer.");
            c.requestFocusInWindow();
            return false;
        }
    }

    public boolean isDouble(JTextComponent c, String fieldName)
    {
        try
        {
            double d = Double.parseDouble(c.getText());
            return true;
        }
        catch (NumberFormatException e)
        {
            showMessage(c, fieldName + " must be a valid number.");
            c.requestFocusInWindow();
            return false;
        }
    }

    private void showMessage(JTextComponent c, String message)
    {
            JOptionPane.showMessageDialog(c, message, "Invalid Entry",
                JOptionPane.ERROR_MESSAGE);
    }
}