package protogui;

/**
 *
 * @author Thomas
 */
public class Padding 
{
    Padding()
    {
    }
    public String generatePadding()
    {
        String padding = "";
        for(int j = 0; j < 16; j++)
        {
            padding = padding + "&emsp;";
        }
        
        return padding;
    }
}
