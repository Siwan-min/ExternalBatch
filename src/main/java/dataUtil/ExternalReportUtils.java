package dataUtil;

import com.example.demo.dao.CommonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;
import reportModel.ExternalLinkageData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@EnableCaching
public class ExternalReportUtils {

    @Autowired
    private static CommonDAO dao;

    public static List<ExternalLinkageData> externalMatchList(String externalId, String zoneId, int mediaCode) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("externalId", externalId);
        params.put("zoneid", zoneId);

        if(mediaCode != 0) {
            params.put("scriptNo", String.valueOf(mediaCode));
        }
        params.put("type", "batch");

        List<ExternalLinkageData> zoneidList = dao.selectZoneList(params);

        return zoneidList;

    }


    public static void runProc(ArrayList<ExternalLinkageData> apiList, String yyyymmdd, String path){

        try{

            for(ExternalLinkageData apiDataEle : apiList){

                String sdate = yyyymmdd;
                int media_site = apiDataEle.getMedia_site();
                int media_code = apiDataEle.getMedia_code();
                String zoneid = apiDataEle.getZoneid();
                String ad_type = apiDataEle.getAd_type();
                String media_id = apiDataEle.getMedia_id();
                int viewcnt = apiDataEle.getViewcnt();
                float ppoint = apiDataEle.getPoint();
                int viewcnt_mobon = apiDataEle.getViewcnt_mobon();
                int clickcnt = apiDataEle.getClickcnt();
                int clickcnt_mobon = apiDataEle.getClickcnt_mobon();
                float point = ppoint;
                double imv = 0;
                float totalcall = apiDataEle.getTotalcall();
                String gubun = apiDataEle.getGubun();
                String userid = apiDataEle.getUserid();

                HashMap<String, Object> daoMap = new HashMap<>();

                daoMap.put("sdate",sdate);
                daoMap.put("media_site",media_site);
                daoMap.put("media_code",media_code);
                daoMap.put("zoneid",zoneid);
                daoMap.put("media_id",media_id);
                daoMap.put("userid",userid);
                daoMap.put("ad_type",ad_type);
                daoMap.put("viewcnt",viewcnt);
                daoMap.put("viewcnt_mobon",viewcnt_mobon);
                daoMap.put("clickcnt",clickcnt);
                daoMap.put("clickcnt_mobon",clickcnt_mobon);
                daoMap.put("imv",imv);
                daoMap.put("point",point);
                daoMap.put("ppoint",ppoint);
                daoMap.put("gubun",gubun);
                daoMap.put("totalcall",totalcall);
                daoMap.put("product", apiDataEle.getProduct()); // product 코드 추가 20200416

                // kafka 전송 추가
                daoMap.put("site_code",apiDataEle.getSite_code());
//                daoMap.put("mpoint", StringUtils.getMpoint(dao.getMediaScript(daoMap),(int)apiDataEle.getPoint(),apiDataEle.getClickcnt(),apiDataEle.getViewcnt()) );

//                List<ExternalLinkageData> exList = ExternalReportUtils.e



            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
