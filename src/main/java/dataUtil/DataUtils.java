package dataUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reportModel.MediaScriptData;

import java.io.*;

public class DataUtils {


    private final static Logger logger = LoggerFactory.getLogger(BatchUtils.class);

    public static String nvl(String nvl, String rep){
        if(nvl != null){
            return nvl.trim();
        } else{
            return rep;
        }
    }

    public static String nvl(String nvl){
        return nvl(nvl, "");
    }

    public static String readFile(String destFile){
        BufferedReader fr=null;
        StringBuffer sb=new StringBuffer();
        try{
            File f=new File(destFile);
            if (f.isFile()) {
                //fr = new BufferedReader(new FileReader(f));
                fr = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF8"));
                String line;
                while((line=fr.readLine())!=null){
                    sb.append(line).append("\n");
                }
            } else {
                logger.error("file is not found ############ " + destFile);
                return "";
            }
            return sb.toString();
        }catch(Exception e){
            logger.error(ErrorLog.getStack(e));
            return "";
        }finally{
            try {
                if(fr!=null)fr.close();
            } catch (IOException e) {
                logger.error(ErrorLog.getStack(e));
            }
        }
    }

    /**
     * RS : RS 매체비(총비용*퍼센트)
     * CP : 고정CPC(총클릭*클릭당비용)
     * CM : CPM (총노출,노출당비용)/1000번
     * SV : 매체피 무조건 0 으로
     *
     * @param ms
     * @param params {click, view}
     * @return
     */
    public static float getMpoint(MediaScriptData ms, float... params) {
        if (ms == null) return 0;
        float mpoint = 0;
        try {
            if ("RS".equals(ms.getActype())) {
                mpoint = (params[0] * ms.getAcper()) / 100L;
            } else if ("CP".equals(ms.getActype())) {
                mpoint = ms.getAcprice() * (params.length > 1 ? params[1] : 1L);
            } else if ("CM".equals(ms.getActype())) {
                mpoint = ms.getAcprice() * (params.length > 2 ? params[2] : 1L);
            } else if ("SV".equals(ms.getActype())) {
                mpoint = 0;
            }
            if ("1".equals(ms.getDeduct())) {
                mpoint -= (mpoint * 0.033);
            }
        } catch (Exception e) {
           // logger.error(ErrorLog.getStack(e, "CLASS:getMpoint", ms));
            mpoint = 0;
        }
        return mpoint;
    }
}
