package dataUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorLog {

    static Logger logger = LoggerFactory.getLogger(ErrorLog.class);

    /**
     * 오류메세지
     * @param e
     * @return
     */
    public static String getStack(Exception e){
        StringBuffer stack = new StringBuffer("\n###### ERROR LOG ######\n");
        StackTraceElement[] stacks = e.getStackTrace();
        int i = 0;
        boolean check = true;
        for(StackTraceElement element : stacks){
            if(element.getMethodName().equals("doGet")){
                stack.append("CLASS_NAME : ");
                stack.append(element.getFileName());
                stack.append(" / ");
                stack.append("LINE : ");
                stack.append(element.getLineNumber());
                stack.append(" / MESSAGE : ");
                stack.append(e);
                stack.append("\n");
                i++;
                break;
            }else{
                stack.append("CLASS_NAME : ");
                stack.append(element.getFileName());
                stack.append(" / ");
                stack.append("LINE : ");
                stack.append(element.getLineNumber());
                stack.append(" / MESSAGE : ");
                stack.append(e);
                stack.append("\n");
                i++;
            }
            if(i>1){
                break;
            }
            if(i > 0){
                check = false;
            }
        }
        if(check){
            stack.append(e);
            stack.append("\n");
        }
        stack.append("###### END ERROR LOG ######");
        return stack.toString();
    }


}
