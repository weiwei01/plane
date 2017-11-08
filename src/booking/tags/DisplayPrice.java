package booking.tags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import static javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;

public class DisplayPrice extends TagSupport
{
    private Double price;
    
    public void setPrice(Double price)
    {
        this.price = price;
    }
    
    public int doStartTag() throws JspException
    {
        if (price != 0)
        {
            return EVAL_BODY_INCLUDE;
        }
        else
        {
            return SKIP_BODY;
        }
    }
}
