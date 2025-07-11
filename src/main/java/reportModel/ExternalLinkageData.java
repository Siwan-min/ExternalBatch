package reportModel;


public class ExternalLinkageData {
    private static final long serialVersionUID = 1L;
    String sdate = "";		// 날짜 : yyyymmdd
    int media_site = 0;	// 매체 key
    int media_code = 0;	// 매체 스크립트 key
    String transmit = "R"; //  S: 송출 , R: 수신
    String zoneid = "1555";		// 와이더플래닛 key
    String external_id;
    String external_name;
    String userid = "widerplanet";		// 와이더플래닛 id
    String site_code = "8bf3b57466094cead02d2ac0226f0c3f";	// 와이더플래닛의 사이트코드
    String ad_type = "";	// 광고 크키 ex) i250_250
    int viewcnt = 0;	// 와이더플래닛 노출
    int viewcnt_mobon = 0;	// 인라이플 노출
    int clickcnt = 0;	// 와이더플래닛 클릭
    int clickcnt_mobon = 0;	// 인라이플 클릭
    int imv = 0;		// CTR * 노출
    int passback_cnt = 0;
    float point = 0;		// 매체비
    String regdate = "";	// 등록날짜
    String gubun = "";		// 광고 구분자
    int totalcall = 0;	// 총 요청 CALL
    int exl_seq = 0;	// 외부연동순서
    String exl_info = "";	// 외부연동 추가 정보
    String send_tp_code =""; // 송출구분코드 (01:송출, 02:수신, 03:미노출)
    String media_id = "";		// 매체ID
    String type = "";		// TYPE : 'P' 패스백
    String etc1;
    String etc2;
    String etc3;
    String etc4;
    String product = "01"; // 디폴트 배너 : 01

    String imgname;
    String imgtype;
    String site_name;


    private String dumpType; // dumpObject type

    private int partition;
    private Long offset;
    private String key;

    /**
     * 객체 생성시 boolean 값이 할당됨.
     */
//    private boolean bHandlingStatsMobon 	 = MobonValue.isHandlingStatsMobon();
//    private boolean bHandlingStatsPointMobon = MobonValue.isHandlingStatsPointMobon();


    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }

    public String getSite_name() {
        return site_name;
    }
    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }
    public String getImgtype() {
        return imgtype;
    }
    public void setImgtype(String imgtype) {
        this.imgtype = imgtype;
    }
    public String getEtc3() {
        return etc3;
    }
    public void setEtc3(String etc3) {
        this.etc3 = etc3;
    }
    public String getEtc4() {
        return etc4;
    }
    public void setEtc4(String etc4) {
        this.etc4 = etc4;
    }
    public String getImgname() {
        return imgname;
    }
    public void setImgname(String imgname) {
        this.imgname = imgname;
    }
    public int getPassback_cnt() {
        return passback_cnt;
    }
    public void setPassback_cnt(int passback_cnt) {
        this.passback_cnt = passback_cnt;
    }
    public String getEtc1() {
        return etc1;
    }
    public void setEtc1(String etc1) {
        this.etc1 = etc1;
    }
    public String getEtc2() {
        return etc2;
    }
    public void setEtc2(String etc2) {
        this.etc2 = etc2;
    }
    public String getZoneid() {
        return zoneid;
    }
    public void setZoneid(String zoneid) {
        this.zoneid = zoneid;
    }
    public String getExternal_id() {
        return external_id;
    }
    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }
    public String getExternal_name() {
        return external_name;
    }
    public void setExternal_name(String external_name) {
        this.external_name = external_name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getMedia_id() {
        return media_id;
    }
    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }
    public String getSdate() {
        return sdate;
    }
    public void setSdate(String sdate) {
        this.sdate = sdate;
    }
    public int getMedia_site() {
        return media_site;
    }
    public void setMedia_site(int media_site) {
        this.media_site = media_site;
    }
    public int getMedia_code() {
        return media_code;
    }
    public void setMedia_code(int media_code) {
        this.media_code = media_code;
    }
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getSite_code() {
        return site_code;
    }
    public void setSite_code(String site_code) {
        this.site_code = site_code;
    }
    public String getAd_type() {
        return ad_type;
    }
    public void setAd_type(String ad_type) {
        this.ad_type = ad_type;
    }
    public int getViewcnt() {
        return viewcnt;
    }
    public void setViewcnt(int viewcnt) {
        this.viewcnt = viewcnt;
    }
    public int getViewcnt_mobon() {
        return viewcnt_mobon;
    }
    public void setViewcnt_mobon(int viewcnt_mobon) {
        this.viewcnt_mobon = viewcnt_mobon;
    }
    public int getClickcnt() {
        return clickcnt;
    }
    public void setClickcnt(int clickcnt) {
        this.clickcnt = clickcnt;
    }
    public int getClickcnt_mobon() {
        return clickcnt_mobon;
    }
    public void setClickcnt_mobon(int clickcnt_mobon) {
        this.clickcnt_mobon = clickcnt_mobon;
    }
    public int getImv() {
        return imv;
    }
    public void setImv(int imv) {
        this.imv = imv;
    }
    public float getPoint() {
        return point;
    }
    public void setPoint(float point) {
        this.point = point;
    }
    public String getRegdate() {
        return regdate;
    }
    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }
    public String getGubun() {
        return gubun;
    }
    public void setGubun(String gubun) {
        this.gubun = gubun;
    }
    public int getTotalcall() {
        return totalcall;
    }
    public void setTotalcall(int totalcall) { this.totalcall = totalcall;}
    public int getExl_seq() {
        return exl_seq;
    }
    public void setExl_seq(int exl_seq) { this.exl_seq = exl_seq;}
    public String getExl_info() {return exl_info;}
    public void setExl_info(String exl_info) {this.exl_info = exl_info;}

    public String getInfo(String s){
        try{
            return s +toString();
        }catch(Exception e){
            return "getInfo:"+e;
        }
    }

    public String getTransmit() {
        return transmit;
    }
    public void setTransmit(String transmit) {
        this.transmit = transmit;
    }
    public void init(){}
    public String getDumpType() {
        return dumpType;
    }
    public void setDumpType(String dumpType) {
        this.dumpType = dumpType;
    }
    public int getPartition() {
        return partition;
    }
    public void setPartition(int partition) {
        this.partition = partition;
    }
    public Long getOffset() {
        return offset;
    }
    public void setOffset(Long offset) {
        this.offset = offset;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getSend_tp_code() {
        return send_tp_code;
    }
    public void setSend_tp_code(String send_tp_code) {
        this.send_tp_code = send_tp_code;
    }

//    public boolean isbHandlingStatsMobon() {
//        return bHandlingStatsMobon;
//    }
//
//    public boolean isbHandlingStatsPointMobon() {
//        return bHandlingStatsPointMobon;
//    }
}