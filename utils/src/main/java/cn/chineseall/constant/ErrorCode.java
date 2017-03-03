package cn.chineseall.constant;

public class ErrorCode {

    /* 总体定义，返回码是否正确 1~10 */
    public static final String EC001 = "1"; // 正确返回码
    public static final String EC000 = "0"; // 错误返回码

    /* 请求与json传递参数结果类型 11~100 */
    public static final String EC011 = "11"; // 业务端传入的参数不对
    public static final String EC012 = "12"; // 请求的JSON串为空
    public static final String EC013 = "13"; // JSON解析成MAP对象出错
    public static final String EC014 = "14"; // 由JSON串解析出的MAP对象为空
    public static final String EC015 = "15"; // 非POST方式提交
    public static final String EC016 = "16"; // 输入的JSON字符串语法有误
    public static final String EC017 = "17"; // 解析json-xml流为JSON对象出错
    public static final String EC018 = "18"; // map为null或size为0
    public static final String EC019 = "19"; // content-type不支持
    public static final String EC020 = "20"; // 缺少必要参数
}
