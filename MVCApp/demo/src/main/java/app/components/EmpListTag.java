package app.components;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class EmpListTag extends SimpleTagSupport {
    
    private String empVar;            
    private List<EmpEntry> empSource; //List from DB

    public void setEmpVar(String empVar) {
        this.empVar = empVar;
    }

    public void setEmpSource(List<EmpEntry> empSource) {
        this.empSource = empSource;
    }

    @Override
    public void doTag() throws JspException, IOException {

        var context = super.getJspContext();
        var body = super.getJspBody();

        for(var empVal : empSource){
            context.setAttribute(empVar, empVal);
            body.invoke(null);
        }

    }

    

    
}
