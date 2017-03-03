package cn.chineseall.constants;

public class Constants {

    /** TOP默认时间格式 **/
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /** UTF-8字符集 **/
    public static final String CHARSET_UTF8 = "UTF-8";

    /** GBK字符集 **/
    public static final String CHARSET_GBK = "GBK";

    /** TOP JSON 应格式 */
    public static final String FORMAT_JSON = "json";

    /* 切分类型：是分表还是分库 */
    public static final int SHARD_DB = 0;
    public static final int SHARD_TABLE = 1;

    /* 数据库类型：可读还是，可读可写 */
    public static final String READ_DB = "r";
    public static final String WRITE_DB = "rw";

}
