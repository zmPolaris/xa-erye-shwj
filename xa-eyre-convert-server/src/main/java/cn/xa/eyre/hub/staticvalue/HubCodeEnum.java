package cn.xa.eyre.hub.staticvalue;

/**
 * 前置软件接口中，在HIS找不到对应码获无需转码的，固定值
 */
public enum HubCodeEnum {
    ID_CARD_TYPE("01", "居民身份证"),
    ID_CARD_TYPE_OTHER("99", "其他法定有效证件"),
    ORG_CODE("520111021", "中国人民解放军联勤保障部队第九二五医院"),
    NATIONALITY_CODE("156", "中国"),
    NATION_CODE("97", "其他"),
    DISEASE_ICD10_CODE("143", "其他"),
    PAY_TYPE_OTHER("99", "其他"),
    EXAM_RESULT_ABNORMAL("01", "阳性"),
    EXAM_RESULT_OTHER("07", "未检出"),
    SEX_OTHER("0", "未知的性别"),
    TREAT_RESULT_OTHER("9", "其他"),


    DIAGNOSIS_ACTIVITIES_OUTPATIENT("1", "门诊"),
    DIAGNOSIS_ACTIVITIES_EMERGENCY("2", "急诊"),
    DIAGNOSIS_ACTIVITIES_STAY_ENTER("3", "留观入观"),
    DIAGNOSIS_ACTIVITIES_STAY_LEAVE("4", "留观出观"),
    DIAGNOSIS_ACTIVITIES_ADMISSION("5", "入院"),
    DIAGNOSIS_ACTIVITIES_HOSPITALIZATION("6", "住院"),
    DIAGNOSIS_ACTIVITIES_FIRST_COURSE("7", "首次病程"),
    DIAGNOSIS_ACTIVITIES_DAILY_COURSE("8", "日常病程"),
    DIAGNOSIS_ACTIVITIES_DISCHARGE("9", "出院"),


    ;

    private final String code;

    private final String name;

    HubCodeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
