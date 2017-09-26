package com.scott.dev.common;

import java.util.Locale;

import org.joda.time.DateTimeZone;

public class AppConstant {

    public static final String CHARSET_UTF8 = "UTF-8";

    public static final String CHARSET_GBK = "GBK";

    public static final String SCHEME_HTTPS = "https";

    public static final String PROPERTY_OS = "os.name";

    public static final String CONST_YES = "yes";

    public static final String CONST_NO = "no";
    
    public static final String CONST_TRUE = "true";

    public static final String CONST_FALSE = "false";

    public static final String CHROME_USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36";

    public static final String GENDER_MALE = "m";

    public static final String GENDER_FEMALE = "f";

    public static final String TXT_DIRTY = "dirty.txt";

    public static final String CONTENT_TYPE_JSON = "application/json; charset=UTF-8";

    public static final String CONTENT_TYPE_OCTET_STREAM = "application/octet-stream";

    public static final String HTTPS_DEFAULT_SCHEME = "https://";

    public static final String HTTP_DEFAULT_SCHEME = "http://";

    public static final int HTTPS_DEFAULT_PORT = 443;

    public static final int HTTP_DEFAULT_PORT = 80;

    public static final String SYMBOL_SPACE = " ";

    public static final String SYMBOL_EMPTY = "";

    public static final String SYMBOL_TAB = "\t";

    public static final String SYMBOL_NEWLINE = "\n";

    public static final String SYMBOL_RETURN = "\r";

    public static final String SYMBOL_PERCENT = "%";

    public static final String SYMBOL_CNY_RMB = "￥";

    public static final String EXT_CSV = ".csv";

    public static final String EXT_XML = ".xml";

    public static final String EXT_JSON = ".json";

    public static final String EXT_HTML = ".html";

    public static final String EXT_PROP = ".properties";

    public static final int DEFAULT_COOKIE_EXPIRE_TIME = 60 * 60 * 24;

    public static final String DEFAULT_COOKIE_PATH = "/";

    public static final String REQUEST_PREFIX_SP = "__sp_";

    public static final String REQUEST_PREFIX_APP = "__app_";

    /**
     * 列可排序
     */
    public static final String SORTABLE_ENABLED = "1";

    /**
     * 列不可排序
     */
    public static final String SORTABLE_DISABLED = "0";

    /**
     * 异步发送邮件，需采用回调方法获取邮件发送结果
     */
    public static final String CONST_MAIL_SEND_ASYNC = "asynchronous";

    /**
     * 同步发送邮件，通过 result 属性获取邮件发送结果
     */
    public static final String CONST_MAIL_SEND_SYNC = "synchronized";

    public static final String CONST_DATE_PATTERN_YMD_HMS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式： 中国
     */
    public static final String CONST_DATE_PATTERN_YMD = "yyyy-MM-dd";

    /**
     * 地区： 中国
     */
    public static final Locale CONST_DEFAULT_LOCALE = Locale.SIMPLIFIED_CHINESE;

    /**
     * 时区：正八区 / (UTC+08:00)北京，重庆，香港特别行政区，乌鲁木齐
     */
    public static final DateTimeZone CONST_DEFAULT_TIMEZONE = DateTimeZone.forOffsetHours(8);

    /**
     * 结果数据无值或无记录
     */
    public static final String CONST_NONE_STRING = "--";

    /**
     * 分页开始值
     */
    public static final String CONST_DATA_START = "data_start";

    /**
     * 每页显示记录数
     */
    public static final String CONST_DATA_LIMIT = "data_limit";

    /**
     * qiniu key
     */
    public static final String QINIU_ACCESS_KEY = "Jo6nvAOJqeZ1Mb_tgyXLgz8v-sXusiZUm1iwoFof";

    public static final String QINIU_SECRET_KEY = "9-XMQORHtVXklwQi6cQi7z4IvCCrh31dfSbFidqi";

    public static final String QINIU_PUBLIC_NORTH_CN_BUCKET = "cn-north-public-01";

    public static final String QINIU_PRIVATE_NORTH_CN_BUCKET = "cn-north-private-01";

    /**
     * 操作成功标识
     */
    public static final String CONST_PROCESS_SUCCESS = "1";

    /**
     * 操作失败标识
     */
    public static final String CONST_PROCESS_FAILED = "0";

    //DSA.java
    public static final String CONST_DSA_ALGORITHMKEY = "DSA";

    public static final String CONST_DSA_ALGORITHMSIGNATUREKEY = "DSA";

    //RSA.java
    public static final String CONST_RSA_ALGORITHMKEY = "RSA";

    public static final String CONST_RSA_ALGORITHMSIGNATUREKEY = "MD5withRSA";

    //AsymmetricEncryptor.java
    public static final String CONST_ASY_PUBLIC_KEY = "AsymmetricEncryptorPublicKey";

    public static final String CONST_ASY_PRIVATE_KEY = "AsymmetricEncryptorPrivateKey";

    //Download And Upload
    /**
     * 生产换件下载路径
     */
    public static final String DOWN_PATH = "/home/emarbox/app/download/baidu/";

    public static final String DOWN_PATH_NAME = "filePath";

    /**
     * 测试环境下载路径
     */
    public static final String DOWN_PATH_TEST = "semwinner.baidu.download.csv.path";

    /**
     * 下载文件每次写文件时的最大纪录值
     */
    public static final Long REPORT_DOWNLOAD_MAX = 2000l;

    public static final Long MAX_PAGE_SIZE = 40000L;

    public static final String UPLOAD_TYPE_FLASH = "flash";

    //api properties key
    /**
     * AMAP JavaScript API
     */
    public static final String API_AMAP_JS_JS_URL = "amap.prd.js.js.url";

    /**
     * 地图/位置/路线规划
     */
    public static final String API_AMAP_JS_DITU_URL = "amap.prd.js.ditu.url";

    /**
     * 周边搜索
     */
    public static final String API_AMAP_JS_DITU_PICKER_URL = "amap.prd.js.ditu.picker.url";

    /**
     * 选址组件
     */
    public static final String API_AMAP_JS_DITU_AROUND_URL = "amap.prd.js.ditu.around.url";

    /**
     * 地铁图
     */
    public static final String API_AMAP_JS_SUBWAY_URL = "amap.prd.js.subway.url";

    /**
     * JavaScript Key
     */
    public static final String API_AMAP_JS_KEY = "amap.prd.js.key";

    /**
     * web service api
     */
    /**
     * 地理编码
     */
    public static final String API_AMAP_WS_GEO_URL = "amap.prd.ws.geo.url";

    /**
     * 逆地理编码
     */
    public static final String API_AMAP_WS_REGEO_URL = "amap.prd.ws.regeo.url";

    /**
     * 路径规划
     */
    public static final String API_AMAP_WS_PATH_URL = "amap.prd.ws.path.url";

    /**
     * 行政区域查询
     */
    public static final String API_AMAP_WS_AREA_QUERY_URL = "amap.prd.ws.area.query.url";

    /**
     * 搜索
     */
    public static final String API_AMAP_WS_SEARCH_URL = "amap.prd.ws.search.url";

    /**
     * IP定位
     */
    public static final String API_AMAP_WS_IP_URL = "amap.prd.ws.ip.url";

    /**
     * 抓路服务
     */
    public static final String API_AMAP_WS_AUTOGRASP_URL = "amap.prd.ws.autograsp.url";

    /**
     * 批量请求
     */
    public static final String API_AMAP_WS_BATCH_URL = "amap.prd.ws.batch.url";

    /**
     * 静态地图
     */
    public static final String API_AMAP_WS_STATICMAP_URL = "amap.prd.ws.staticmap.url";

    /**
     * 坐标转换
     */
    public static final String API_AMAP_WS_COORDINATE_CONVERT_URL = "amap.prd.ws.coordinate.convert.url";

    /**
     * 天气查询
     */
    public static final String API_AMAP_WS_WEATHER_URL = "amap.prd.ws.weather.url";

    /**
     * 输入提示
     */
    public static final String API_AMAP_WS_INPUTTIPS_URL = "amap.prd.ws.inputtips.url";

    /**
     * 交通态势
     */
    public static final String API_AMAP_WS_TRAFFIC_STATUS_URL = "amap.prd.ws.traffic.status.url";

    /**
     * 地理围栏
     */
    public static final String API_AMAP_WS_GEOFENCE_URL = "amap.prd.ws.geofence.url";

    /**
     * WebService Key
     */
    public static final String API_AMAP_WS_KEY = "amap.prd.ws.key";

    /**
     * Freemarker Directory Base Path
     */
    public static final String DEFAULT_FREEMARKER_DIR = "/WEB-INF/ftl/";

    public static final String APP_ENV_DEBUG = "app.env.debug";

    public static final String APP_ENV_VERSION = "app.env.version";

    public static final String APP_ENV_TIMESTAMP = "app.env.timestamp";

    public static final String APP_ENV_JS_LOG_ENBALED = "app.env.js_log_enabled";

    public static final String APP_ENV_ENCODING = "app.env.encoding";

}
