/*
*  Author: Min Siwan
*  Date : 2021-02-16
*  Description: This class is that we can get data ( date, ZoneId etc) we needed from local
* */
package dataUtil;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class BatchUtils {

    public static ArrayList<String> handleDate(String logPath, int batchDate, String externalId){

        ArrayList<String> dateArr = new ArrayList<>();
        String localDate = DataUtils.nvl(DataUtils.readFile(logPath + "/batchdate.log")).trim();
        String lastDate = DataUtils.nvl(DataUtils.readFile(logPath + "/check.log")).trim();

        if(!StringUtils.isEmpty(localDate)){
            if(dateArr != null){
                dateArr.clear();
            }
            dateArr = new ArrayList<>(Arrays.asList(localDate.split(",")));
        } else{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            SimpleDateFormat dateFormatH = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            Calendar cal = Calendar.getInstance();
            if ("dable".equals(externalId)) {
                int today = date.getDate();
                if (today >= (cal.getActualMaximum(Calendar.DAY_OF_MONTH) - 3) || today == 1) {
                    cal.add(Calendar.DATE, -1);
                    date.setTime(cal.getTimeInMillis());
                    dateArr.add(dateFormat.format(date));
                    cal.add(Calendar.DATE, -5);
                } else if (today >= 2 && today <= 6) {
                    return null;
                } else {
                    cal.add(Calendar.DATE, batchDate);
                }
                date.setTime(cal.getTimeInMillis());
                dateArr.add(dateFormat.format(date));
            } else if ("inbnet".equals(externalId)) {
                cal.setTime(date);
                int dayNum = cal.get(Calendar.DAY_OF_WEEK);
                switch(dayNum){
                    case 1 : case 2 : break;
                    case 3 : case 4 : cal.add(Calendar.DATE, -2); date.setTime(cal.getTimeInMillis()); dateArr.add(dateFormat.format(date)); cal.add(Calendar.DATE, -2); date.setTime(cal.getTimeInMillis()); dateArr.add(dateFormat.format(date));break;
                    default : cal.add(Calendar.DATE, -2); date.setTime(cal.getTimeInMillis()); dateArr.add(dateFormat.format(date)); break;
                }
            } else if ("sspadop".equals(externalId) || "phaserep".equals(externalId) || "priel".equals(externalId) || "taboola".equals(externalId) || "adsense".equals(externalId) || "tapzin".equals(externalId)) {
                cal.add(Calendar.DATE, batchDate);
                date.setTime(cal.getTimeInMillis());
                dateArr.add(dateFormatH.format(date));
            } else {
                cal.add(Calendar.DATE, batchDate);
                date.setTime(cal.getTimeInMillis());
                dateArr.add(dateFormat.format(date));
            }
        }

        for (String dumpDate : dateArr) {
            if (dumpDate.equals(lastDate)) {
                System.out.println("이미 리포트가 처리된 상태입니다. 다시한번 확인해주시기 바랍니다.");
                return null;
            }
        }

        return dateArr;
    }

}
