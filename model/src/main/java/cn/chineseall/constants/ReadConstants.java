package cn.chineseall.constants;

public class ReadConstants {

    /**
     * 图书状态: 正常
     */
    public final static int BOOK_STATE_NORMAL = 1;
    /**
     * 图书状态: 隐藏
     */
    public final static int BOOK_STATE_HIDDEN = -1;
    /**
     * 图书状态: 缺少阅读文件
     */
    public final static int BOOK_STATE_NOT_FILE = -2;
    /**
     * 图书状态: 下架
     */
    public final static int BOOK_STATE_PENDING = 0;

    /**
     * 试读最大页数
     */
    public final static int TEST_READ_MAX_PAGE = 10;
    
    /**
     * 阅读方式: 图片
     */
    public final static int READ_MODE_IMG = 0;
    /**
     * 阅读方式: PDF
     */
    public final static int READ_MODE_PDF = 1;
    /**
     * 阅读方式: 文本
     */
    public final static int READ_MODE_TXT = 2;

    /**
     * 阅读权限: 无阅读权限
     */
    public final static int READ_FUNC_NO = 1;
    /**
     * 阅读权限: 试读
     */
    public final static int READ_FUNC_TEST = 2;
    /**
     * 阅读权限: 全本阅读
     */
    public final static int READ_FUNC_ALL = 3;
    /**
     * 阅读权限: 借阅
     */
    public final static int READ_FUNC_BORROW = 4;

    /**
     * 错误码: 不符合阅读年龄
     */
    public final static int READ_ERROR_CODE_RANGE = 1;

    /**
     * 错误码: 未购买
     */
    public final static int READ_ERROR_CODE_NOTBUY = 2;

    /**
     * 错误码: 已下架
     */
    public final static int READ_ERROR_CODE_PENDING = 3;

    /**
     * 错误码: 隐藏
     */
    public final static int READ_ERROR_CODE_HIDDEN = 4;

    /**
     * 错误码: 找不到阅读资源
     */
    public final static int READ_ERROR_CODE_NOT_FOUND = 5;

}
