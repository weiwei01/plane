package booking.tags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;
import static javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;

public class DisplayUpdateButton extends TagSupport
{
    private String orderNumber;
    
    public void setOrderNumber(String orderNumber)
    {
        this.orderNumber = orderNumber;
    }
    
    public int doStartTag() throws JspException
    {
        if (orderNumber != null && orderNumber != "")
        {
            return EVAL_BODY_INCLUDE;
        }
        else
        {
            return SKIP_BODY;
        }
    }
}


