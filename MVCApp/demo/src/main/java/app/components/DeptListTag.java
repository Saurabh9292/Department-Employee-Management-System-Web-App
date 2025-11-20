package app.components;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class DeptListTag extends SimpleTagSupport{

    private String deptVar ;
    private List<DeptEntry> deptSource;

    public void setDeptVar(String deptVar) {
        this.deptVar = deptVar;
    }

    public void setDeptSource(List<DeptEntry> deptSource) {
        this.deptSource = deptSource;
    }

    @Override
    public void doTag() throws JspException, IOException {
        
        var context = super.getJspContext();
        var body = super.getJspBody();
        
        for(var deptVal : deptSource){
            context.setAttribute(deptVar, deptVal);
            body.invoke(null); 
        }
    }

    
    
    
}
