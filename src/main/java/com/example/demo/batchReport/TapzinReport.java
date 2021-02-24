package com.example.demo.batchReport;

import dataUtil.BatchUtils;
import dataUtil.ExternalReportUtils;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import reportModel.ExternalLinkageData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@EnableCaching
@Component
public class TapzinReport {

    private final String EXTERNALID = "tapzin";
    private final String logPath = "/home/dreamsearch/logs/cron/" + EXTERNALID;
    private final String path = "/home/dreamsearch/logs/cron/" + EXTERNALID + "/check.log";

    public void TapzinStart() {

         ArrayList<String> handlingDate = BatchUtils.handleDate(logPath, -2, EXTERNALID);

        // 데이터가 없으면 return
        if(CollectionUtils.isEmpty(handlingDate)) return;

        for(String dumDate : handlingDate){

            ArrayList<ExternalLinkageData> list = new ArrayList<>();
            HashMap<String, ExternalLinkageData> externalMap = new HashMap<>();

            try{

                List<ExternalLinkageData> externalList = ExternalReportUtils.externalMatchList(EXTERNALID, "", 0);



            }catch (Exception e){
                e.printStackTrace();

            }



        }

        return;
    }
}
