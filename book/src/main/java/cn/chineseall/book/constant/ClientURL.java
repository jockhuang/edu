package cn.chineseall.book.constant;

public class ClientURL {

	/**
	 * 上传图片同步目录
	 */
    public final static String PORT = ":80"; 

    public final static String API_PREFIX = "http://api.chineseall.cn";

    // public final static String RESOURCES_PREFIX = "http://125.39.194.43";
 
    public final static String RESOURCES_PREFIX = "http://resources.chineseall.cn";

    // public final static String RESOURCES_PREFIX = "http://125.39.194.43";

    public final static String SHOW_BOOKS = API_PREFIX + PORT + "/listBooksByPage.json";

    /**
     * 机构相关---------------------------------------------------------------------
     */
    public final static String GET_ORG_HOME_PAGE_DYNAMIC = API_PREFIX + PORT + "/getHomePageDynamic.json";
    /**
     * 显示机构统计信息
     */
    public final static String GET_ORG_STATISTICS = API_PREFIX + PORT + "/getOrgStatistics.json";
    /**
     * 获取机构树对象
     */
    public final static String GET_ORG_ORGTREE = API_PREFIX + PORT + "/getOrgTree.json";
    /**
     * 显示机构首页新闻
     */
    public final static String GET_ORG_HOME_PAGE_NEWS = API_PREFIX + PORT + "/getOrgHomePageNews.json";
    /**
     * 显示机构热门图书
     */
    public final static String GET_ORG_HOT_BOOKS = API_PREFIX + PORT + "/getOrgHotBooks.json";
    /**
     * 显示机构推荐图书
     */
    public final static String GET_ORG_RECOMMEND_BOOKS = API_PREFIX + PORT + "/getOrgRecommendBooks.json";
    /**
     * 显示机构最新图书
     */
    public final static String GET_ORG_NEW_BOOKS = API_PREFIX + PORT + "/getOrgNewBooks.json";
    /**
     * 显示机构首页活动信息
     */
    public final static String GET_ORG_HOME_PAGE_ACTIVITYS = API_PREFIX + PORT + "/getOrgHomePageActivitys.json";
    /**
     * 显示机构首页用户信息
     */
    public final static String GET_ORG_HOME_PAGE_NewUSERS = API_PREFIX + PORT + "/getOrgHomePageUsers.json";
    public final static String GET_ORG_HOME_PAGE_ReadBookUSERS = API_PREFIX + PORT
            + "/getOrgHomePageReadBookUsers.json";
    public final static String GET_ORG_HOME_PAGE_BookCommentUSERS = API_PREFIX + PORT
            + "/getOrgHomePageBookCommentUsers.json";
    public final static String GET_ORG_HOME_PAGE_WorksUSERS = API_PREFIX + PORT + "/getOrgHomePageWorksUsers.json";
    public final static String GET_ORG_NEW_TOP_BOOKS = API_PREFIX + PORT + "/getOrgNewTopBooks.json";

    public final static String GET_ORG_SCORE_TOP_BOOKS = API_PREFIX + PORT + "/getOrgScoreTopBooks.json";

    public final static String GET_ORG_READING_TOP_BOOKS = API_PREFIX + PORT + "/getOrgReadingTopBooks.json";

    public final static String GET_ORG_COLLECTION_TOP_BOOKS = API_PREFIX + PORT + "/getOrgCollectionTopBooks.json";

    public final static String GET_ORG_BOOK_SELF_SORTS = API_PREFIX + PORT + "/getOrgBookSelfSorts.json";
    /**
     * 获取新闻页列表新闻信息
     */
    public final static String GET_NEWS_PAGE_ORG_NEWS = API_PREFIX + PORT + "/getNewsPageOrgNews.json";
    /**
     * 获取单条新闻详情信息
     */
    public final static String GET_ORG_NEWS_DETAIL = API_PREFIX + PORT + "/getOrgNewsDetail.json";
    /**
     * 获取 相关组织 页面信息
     */
    public final static String GET_ORG_ORGANIZATION = API_PREFIX + PORT + "/getOrganizationView.json";

    /**
     * 阅览室相关----------------------------------------------------------------------------------------------------
     */
    /**
     * 获取图书信息(多个)
     */
    public final static String GET_BOOKS = API_PREFIX + PORT + "/getBook.json";

    /**
     * 获取图书简介(多个)
     */
    public final static String GET_BOOK_INTROS = API_PREFIX + PORT + "/getBookIntro.json";

    /**
     * 获取图书详细信息(包括简介、点击量、收藏量等统计信息)
     */
    public final static String GET_BOOK_DETAIL = API_PREFIX + PORT + "/getBookDetail.json";
    
    /**
     * 获取图书标签
     */
    public final static String LIST_BOOK_LABEL = API_PREFIX + PORT + "/listBookLabel.json";

    /**
     * 按上架时间获取机构图书
     */
    public final static String LIST_ORG_NEW_TOP_BOOK = API_PREFIX + PORT + "/listOrgNewTopBook.json";

    /**
     * 按用户打分次数获取图书
     */
    public final static String LIST_ORG_SCORE_TOP_BOOK = API_PREFIX + PORT + "/listOrgScoreTopBook.json";

    /**
     * 获取阅读排行榜图书
     */
    public final static String LIST_ORG_READING_TOP_BOOK = API_PREFIX + PORT + "/listOrgReadingTopBook.json";

    /**
     * 获取收藏排行榜图书
     */
    public final static String LIST_ORG_COLLECTION_TOP_BOOK = API_PREFIX + PORT + "/listOrgCollectionTopBook.json";
    
    /**
     * 获取日阅读量排行榜
     */
    public final static String LIST_ORG_DAY_READ_TOP_BOOK = API_PREFIX + PORT + "/listOrgDayReadTopBook.json";

    /**
     * 获取机构图书自定义分类列表
     */
    public final static String LIST_ORG_BOOK_SELF_SORT = API_PREFIX + PORT + "/listOrgBookSelfSort.json";

    /**
     * 获取推荐用户阅读图书
     */
    public final static String LIST_RECOMMEND_USER_BOOK = API_PREFIX + PORT + "/listRecommendUserBook.json";

    /**
     * 获取阅读过此书阅读用户其他图书
     */
    public final static String LIST_OTHER_USER_READING_BOOK = API_PREFIX + PORT + "/listOtherUserReadingBook.json";

    /**
     * 获取用户收藏的图书
     */
    public final static String LIST_USER_COLLECTION_BOOK = API_PREFIX + PORT + "/listUserCollectionBook.json";

    /**
     * 获取用户推荐图书
     */
    public final static String LIST_USER_RECOMMEND_BOOK = API_PREFIX + PORT + "/listUserRecommendBook.json";

    /**
     * 获取用户书友推荐图书
     */
    public final static String LIST_FRIEND_RECOMMEND_BOOK = API_PREFIX + PORT + "/listFriendRecommendBook.json";

    /**
     * 获取用户评论过的图书
     */
    public final static String LIST_USER_COMMENT_BOOK = API_PREFIX + PORT + "/listUserCommentBook.json";

    /**
     * 获取图书列表中，用户已收藏的图书
     */
    public final static String LIST_HAVE_COLLECTION_BOOK_ID = API_PREFIX + PORT + "/listHaveCollectionBookId.json";
    
    /**
     * 收藏图书
     */
    public final static String COLLECTION_BOOK = API_PREFIX + PORT + "/collectionBook.json";

    /**
     * 删除收藏图书
     */
    public final static String DELETE_COLLECTION_BOOK = API_PREFIX + PORT + "/deleteCollectionBook.json";

    /**
     * 推荐图书
     */
    public final static String RECOMMEND_BOOK = API_PREFIX + PORT + "/recommendBook.json";

    /**
     * 删除推荐图书
     */
    public final static String DELETE_RECOMMEND_BOOK = API_PREFIX + PORT + "/deleteRecommendBook.json";

    /**
     * 获取用户对图书评价
     */
    public final static String LIST_USER_TO_BOOK_SCORE = API_PREFIX + PORT + "/listUserToBookScore.json";

    /**
     * 删除推荐图书
     */
    public final static String TO_BOOK_SCORE = API_PREFIX + PORT + "/toBookScore.json";

     /**
     * 添加图书评论
     */
    /**
     * html.chineseall.cn 获取书评
     */
    public final static String LIST_BOOK_COMMENT = API_PREFIX + PORT + "/listBookComment.json";

    /**
     * 获取书友书评
     */
    public final static String LIST_FRIEND_BOOK_COMMENT = API_PREFIX + PORT + "/listFriendBookComment.json";

    /**
     * 获取用户书评
     */
    public final static String LIST_USER_BOOK_COMMENT = API_PREFIX + PORT + "/listUserBookComment.json";

    /**
     * 添加图书评论
     */
    public final static String ADD_BOOK_COMMENT = API_PREFIX + PORT + "/addBookComment.json";
    
    /**
     * 删除图书评论
     */
    public final static String DELETE_BOOK_COMMENT = API_PREFIX + PORT + "/deleteBookComment.json";
    
    /**
     * 对书评赞
     */
    public final static String USEFUL_BOOK_COMMENT = API_PREFIX + PORT + "/usefulBookComment.json";

    /**
     * 对书评贬
     */
    public final static String USELESS_BOOK_COMMENT = API_PREFIX + PORT + "/uselessBookComment.json";

    /**
     * 用户书房相关----------------------------------------------------------------------------------------------------
     */
    /**
     * 获取用户信息(界面显示用)
     */
    public final static String GET_USER_INFO = API_PREFIX + PORT + "/getUserInfo.json";

    /**
     * 获取书房设置
     */
    public final static String GET_USER_STUDY = API_PREFIX + PORT + "/getUserStudy.json";
    /**
     * 获取用户详细信息(界面显示用)
     */
    public final static String GET_USER_BASE_INFO = API_PREFIX + PORT + "/getUserBaseInfo.json";
    
    /**
     * 获取用户登录信息(验证用户登录使用)
     */
    public final static String GET_USER = API_PREFIX + PORT +"/getUser.json";
    
    /**
     * 根据用户名获取用户信息
     */
    public final static String IMPORT_EDUYUN_USER = API_PREFIX + PORT +"/importUser.json";
    
    /**
     * 获取书房动态信息
     */
    public final static String LIST_USER_PAGE_DYNAMIC_INFO = API_PREFIX + PORT + "/listUserPageDynamicInfo.json";

    /**
     * 获取未阅读书信数量
     */
    public final static String GET_NOT_READ_LETTER_COUNT = API_PREFIX + PORT + "/getNotReadLetterCount.json";
    
    /**
     * 发送书信
     */
    public final static String SEND_LETTER = API_PREFIX + PORT + "/sendLetter.json";
    
    /**
     * 回复书信
     */
    public final static String REPLY_LETTER = API_PREFIX + PORT + "/replyLetter.json";
    
    /**
     * 删除书信
     */
    public final static String DELETE_LETTER = API_PREFIX + PORT + "/deleteLetter.json";
    
    /**
     * 获取获取书信对话
     */
    public final static String LIST_LETTER_GROUP = API_PREFIX + PORT + "/listLetterGroup.json";
    
    /**
     * 获取展开书信对话
     */
    public final static String LIST_GROUP_LETTER = API_PREFIX + PORT + "/listGroupLetter.json";
    
    /**
     * 获取系统书信
     */
    public final static String LIST_SYS_LETTER = API_PREFIX + PORT + "/listSysLetter.json";
    
    /**
     * 设置用户基本信息
     */
    public final static String SETTING_USER_BASIC = API_PREFIX + PORT + "/settingUserBasic.json";

    /**
     * 设置用户密码
     */
    public final static String SETTING_USER_PASSWORD = API_PREFIX + PORT + "/settingUserPassword.json";

    /**
     * 设置用户书房样式
     */
    public final static String SETTING_USER_UI = API_PREFIX + PORT + "/settingUserUI.json";

    /**
     * 设置用户隐私
     */
    public final static String SETTING_USER_PRIVACY = API_PREFIX + PORT + "/settingUserPrivacy.json";
    
    
    

    /**
     * 获取与用户相关(自己创建，已加入)的读书小组
     */
    public final static String LIST_USER_RELATED_GROUP = API_PREFIX + PORT + "/listUserRelatedGroup.json";

    /**
     * 获取"关注我的书友" 用户列表
     */
    public final static String LIST_CONCERN_ME_USER = API_PREFIX + PORT + "/listConcernMeUser.json";

    /**
     * 获取"我关注的书友" 用户列表
     */
    public final static String LIST_ME_CONCERN_USER = API_PREFIX + PORT + "/listMeConcernUser.json";

    /**
     * 获取"关注记录" 列表
     */
    public final static String LIST_USER_CONCERN_LOG = API_PREFIX + PORT + "/listUserConcernLog.json";
    
    /**
     * 向书友添加关注
     */
    public final static String ADD_USER_CONCERN = API_PREFIX + PORT + "/addUserConcern.json";
    
    /**
     * 删除关注
     */
    public final static String DELETE_USER_CONCERN = API_PREFIX + PORT + "/deleteUserConcern.json";
    
    /**
     * 获取已关注的用户id
     */
    public final static String LIST_HAVE_CONCERN_USER_ID = API_PREFIX + PORT + "/listHaveConcernUserId.json";

    /**
     * 获取"访问我书房的书友" 用户列表
     */
    public final static String LIST_VISIT_ME_USER = API_PREFIX + PORT + "/listVisitMeUser.json";

    /**
     * 添加用户访问书房日志
     */
    public final static String ADD_VISIT_USER_LOG = API_PREFIX + PORT + "/addVisitUserLog.json";
    
    
    
    /**
     * 阅读相关----------------------------------------------------------------------------------------------------
     */
    /**
     * 获取阅读信息
     */
    public final static String GET_READ_INFO = API_PREFIX + PORT + "/cooperation/eduyun/getReadInfo.json";

    /**
     * 获取用户对单本书阅读记录(详细)
     */
    public final static String GET_USER_READING_DETAIL = API_PREFIX + PORT + "/getUserReadingDetail.json";

    /**
     * 获取用户对单本书阅读记录
     */
    public final static String GET_USER_READING_BOOK = API_PREFIX + PORT + "/getUserReadingBook.json";

    /**
     * 获取阅读目录令牌
     */
    public final static String GET_READ_DIRECTORY_TOKEN = API_PREFIX + PORT + "/getReadDirectoryToken.json";

    /**
     * + 获取用户阅读记录
     */
    public final static String LIST_USER_READING_BOOK = API_PREFIX + PORT + "/listUserReadingBook.json";

    /**
     * 获取用户阅读记录(详细)
     */
    public final static String LIST_USER_READING_DETAIL = API_PREFIX + PORT + "/listUserReadingDetail.json";
    
    /**
     * 获取某书阅读用户
     */
    public final static String LIST_READ_BOOK_USER = API_PREFIX + PORT + "/listReadBookUser.json";

    /**
     * 听书馆相关----------------------------------------------------------------------------------------------------
     */
    /**
     * 获取听书明细列表
     */
    public final static String LIST_AUDIO_BOOK_DETAIL = API_PREFIX + PORT + "/listAudioBookDetail.json";

    /**
     * 获取听书一级分类列表(包含二级分类)
     */
    public final static String LIST_AUDIO_CLASS_DETAIL = API_PREFIX + PORT + "/listAudioClassDetail.json";

    /**
     * 获取听书音频列表
     */
    public final static String LIST_AUDIO = API_PREFIX + PORT + "/listAudio.json";
    
    /**
     * 获取听书播放权限
     */
    public final static String GET_AUDIO_PLAYER_FUNC = API_PREFIX + PORT + "/getAudioPlayerFunc.json";
    
    /**
     * 获取听书阅读记录
     */
    public final static String LIST_AUDIO_READ_LOG_DETAIL = API_PREFIX + PORT + "/listAudioReadLogDetail.json";

    /**
     * 随机获取推荐听书
     */
    public final static String LIST_RANDOM_GET_AUDIO_BOOK_INFO = API_PREFIX + PORT + "/listRandomGetAudioBookInfo.json";
    
    /**
     * 获取播放音频令牌
     */
    public final static String GET_AUDIO_TOKEN = API_PREFIX + PORT + "/getAudioToken.json";
    
    

    /**
     * 机构活动相关----------------------------------------------------------------------------------------------------
     */
    /**
     * 获取父机构树列表
     */
    public final static String LIST_PARENTS_ORG_TREE = API_PREFIX + PORT + "/manage/tree/listParentsOrgTree.json";
    
    /**
     * 获取用户参加互动的权限,无权限返回null,有权限,返回其orgTreeId
     */
    public final static String GET_USER_JOIN_LIMIT = API_PREFIX + PORT + "/getUserJoinLimit.json";
    /**
     * 获取活动列表页（机构后台->活动管理）
     */
    public final static String LIST_ORG_ACTIVITYS = API_PREFIX + PORT + "/listOrgActivitys.json";

    /**
     * 获取首页最新活动
     */
    public final static String LIST_ORG_NEW_ACTIVITY = API_PREFIX + PORT + "/listOrgNewActivitys.json";
    
    /**
     * 获取首页最新活动
     */
    public final static String LIST_EDUYUN_NEW_ACTIVITY = API_PREFIX + PORT + "/listEduYunNewActivitys.json";

    /**
     * 获取首页热门活动
     */
    public final static String LIST_ORG_HOT_ACTIVITY = API_PREFIX + PORT + "/listOrgHotActivitys.json";
    
    /**
     * 获取央管热门活动
     */
    public final static String LIST_EDUYUN_HOT_ACTIVITY = API_PREFIX + PORT + "/listEduYunHotActivitys.json";

    /**
     * 获取经典回顾活动
     */
    public final static String LIST_ORG_FINISH_ACTIVITY = API_PREFIX + PORT + "/listOrgFinishActivitys.json";
    
    /**
     * 获取央管经典回顾活动
     */
    public final static String LIST_EDUYUN_FINISH_ACTIVITY = API_PREFIX + PORT + "/listEduYunFinishActivitys.json";

    /**
     * 获取首页最新作品
     */
    public final static String LIST_ORG_NEW_WORKS = API_PREFIX + PORT + "/listOrgNewWorks.json";
    
    /**
     * 获取央管首页最新作品
     */
    public final static String LIST_EDUYUN_NEW_WORKS = API_PREFIX + PORT + "/listEduYunNewWorks.json";

    /**
     * 活动基本信息相关----------------------------------------------------------------------------------------------------
     */
    /**
     * 修改活动基本信息
     */
    public final static String UPDATE_AC_BASEINFO = API_PREFIX + PORT + "/updateAcBaseinfo.json";

    /**
     * 修改活动logo或banner
     */
    public final static String UPDATE_AC_LOGO_OR_BANNER = API_PREFIX + PORT + "/updateAcLogoOrBanner.json";
    /**
     * 添加活动
     */
    public final static String ADD_AC_BASEINFO = API_PREFIX + PORT + "/addAcBaseinfo.json";

    /**
     * 获取活动详细信息
     */
    public final static String GET_ACTIVITY_DETAIL = API_PREFIX + PORT + "/getActivityDetail.json";
    /**
     * 获取作品推荐数限制
     */
    public final static String GET_REC_COUNT_LIMIT = API_PREFIX + PORT + "/getRecCountLimit.json";
    /**
     * 获取活动配置信息
     */
    public final static String GET_AC_CONFIG = API_PREFIX + PORT + "/getAcConfig.json";

    /**
     * 获取活动作品信息
     */
    public final static String GET_ACTIVITY_WORK = API_PREFIX + PORT + "/getActivityWork.json";
    /**
     * 获取活动书单列表
     */
    public final static String LIST_ACTIVITY_BOOKS = API_PREFIX + PORT + "/listActivityBooks.json";
    /**
     * 获取活动作品列表
     */
    public final static String LIST_ACTIVITY_WORKS = API_PREFIX + PORT + "/listActivityWorks.json";
    
    /**
     * 获取用户提交活动作品
     */
    public final static String LIST_USER_WORKS = API_PREFIX + PORT + "/listUserWorks.json";
    
    /**
     * 获取用户书友提交活动作品
     */
    public final static String LIST_USER_CONCERN_WORKS = API_PREFIX + PORT + "/listUserConcernWorks.json";
    
    
    /**
     * 活动公告管理相关----------------------------------------------------------------------------------------------------
     */
    /**
     * 获取活动公告列表
     */
    public final static String LIST_ACTIVITY_BULLETIN = API_PREFIX + PORT + "/listActivityBulletins.json";
    /**
     * 获取活动公告信息
     */
    public final static String GET_AC_BULLETIN = API_PREFIX + PORT + "/getAcBulletin.json";

    /**
     * 添加活动公告信息
     */
    public final static String ADD_AC_BULLETIN = API_PREFIX + PORT + "/addAcBulletin.json";
    /**
     * 修改活动公告信息
     */
    public final static String UPDATE_AC_BULLETIN = API_PREFIX + PORT + "/updateAcBulletin.json";
    /**
     * 删除活动公告信息
     */
    public final static String DEL_AC_BULLETIN = API_PREFIX + PORT + "/delAcBulletin.json";

    /**
     * 活动协办者管理相关----------------------------------------------------------------------------------------------------
     */
    /**
     * 获取活动协办者列表
     */
    public final static String LIST_AC_COLLABORATOR = API_PREFIX + PORT + "/listAcCollaborators.json";
    /**
     * 添加活动活动协办者
     */
    public final static String ADD_AC_COLLABORATORS = API_PREFIX + PORT + "/addAcCollaborators.json";
    /**
     * 删除活动活动协办者
     */
    public final static String DEL_AC_COLLABORATORS = API_PREFIX + PORT + "/delAcCollaborators.json";

    /**
     * 活动评委管理相关----------------------------------------------------------------------------------------------------
     */
    /**
     * 获取活动评委列表
     */
    public final static String LIST_AC_JURYS = API_PREFIX + PORT + "/listAcJurys.json";

    /**
     * 获取历史活动评委列表
     */
    public final static String LIST_AC_HISTORY_JURYS = API_PREFIX + PORT + "/listAcHistoryJurys.json";

    /**
     * 添加活动评委
     */
    public final static String ADD_AC_JURY = API_PREFIX + PORT + "/addAcJury.json";

    /**
     * 删除活动评委
     */
    public final static String DEL_AC_JURY = API_PREFIX + PORT + "/delAcJury.json";

    /**
     * 活动书单管理相关----------------------------------------------------------------------------------------------------
     */
    /**
     * 获取活动书单列表页
     */
    public final static String LIST_AC_BOOKS = API_PREFIX + PORT + "/listAcBooks.json";
    
    /**
     * 添加活动书单
     */
    public final static String ADD_AC_BOOK = API_PREFIX + PORT + "/addAcBook.json";
    
    /**
     * 删除活动书单
     */
    public final static String DEL_AC_BOOK = API_PREFIX + PORT + "/delAcBook.json";
    
    /**
     * 活动作品管理相关----------------------------------------------------------------------------------------------------
     */
    /**
     * 某活动所有作品
     */
    public final static String LIST_ALL_AC_WORKS = API_PREFIX + PORT + "/manage/activity/listAllAcWorks.json";
    /**
     * 某活动下级推荐作品
     */
    public final static String LIST_SUB_REC_AC_WORKS = API_PREFIX + PORT + "/manage/activity/listSubRecAcWorks.json";
    /**
     * 某活动评委已打分作品
     */
    public final static String LIST_SCORE_AC_WORKS = API_PREFIX + PORT + "/manage/activity/listScoreAcWorks.json";
    /**
     * 某活动推荐给上级的作品
     */
    public final static String LIST_REC_AC_WORKS = API_PREFIX + PORT + "/manage/activity/listRecAcWorks.json";
    /**
     * 导出搜索到的作品
     */
    public final static String EXPORT_AC_WORKS = API_PREFIX + PORT + "/manage/activity/exportAcWorks.json";
    /**
     * 修改作品审核状态
     */
    public final static String UPDATE_AC_WORKS_STATE = API_PREFIX + PORT + "/manage/activity/updateAcWorksState.json";
    /**
     * 修改每级机构推荐作品数量
     */
    public final static String UPDATE_AC_WORKS_REC_COUNT = API_PREFIX + PORT + "/manage/activity/updateAcWorksRecCount.json";
    
    /**
     * 获取本机构推荐权限
     */
    public final static String GET_PAR_ORG_REC_LIMIT = API_PREFIX + PORT + "/manage/activity/getParOrgRecLimit.json";
    
    /**
     * 获取下级机构推荐权限信息
     */
    public final static String GET_ORG_REC_LIMIT = API_PREFIX + PORT + "/manage/activity/getOrgRecLimit.json";
    
    
    /**
     * 修改下级机构推荐权限
     */
    public final static String UPDATE_REC_LIMIT = API_PREFIX + PORT + "/manage/activity/updateRecLimit.json";
    
    /**
     * 获取友情链接列表
     */
    public final static String LIST_AC_FRIEND_LINK = API_PREFIX + PORT + "/manage/activity/listAcFriendLink.json";
    
    
    /**
     *修改友情链接信息
     */
    public final static String UPDATE_AC_FRIEND_LINK = API_PREFIX + PORT + "/manage/activity/updateAcFriendLink.json";
    /**
     * 获取分组列表
     */
    public final static String LIST_AC_GROUP = API_PREFIX + PORT + "/manage/activity/listAcGroup.json";
    
    /**
     *修改分组列表
     */
    public final static String UPDATE_AC_GROUPS = API_PREFIX + PORT + "/manage/activity/updateAcGroups.json";
    /**
     *修改分组列表
     */
    public final static String DEL_AC_GROUPS = API_PREFIX + PORT + "/manage/activity/delAcGroups.json";
    
    /**
     * 推荐作品
     */
    public final static String REC_AC_WORKS = API_PREFIX + PORT + "/manage/activity/recAcWorks.json";
    /**
     * 删除作品
     */
    public final static String DEL_AC_WORKS = API_PREFIX + PORT + "/manage/activity/delAcWorks.json";
    /**
     * 给作品分配评委
     */
    public final static String ADD_AC_WORKS_JURY = API_PREFIX + PORT + "/manage/activity/addAcWorksJury.json";
    /**
     * 给作品打分,评语
     */
    public final static String ADD_AC_WORKS_SCOR = API_PREFIX + PORT + "/manage/activity/addAcWorksScore.json";
    /**
     * 获取作品评分信息
     */
    public final static String GET_AC_WORKS_SCOR = API_PREFIX + PORT + "/manage/activity/getAcWorksScore.json";
    
    /**
     * 活动统计管理相关----------------------------------------------------------------------------------------------------
     */
    /**
     * 每日投稿数
     */
    public final static String LIST_AC_WORKS_GROUP_BY_DAY = API_PREFIX + PORT + "/listAcWorksGroupByDay.json";
    /**
     * 某机构下级机构的统计数据
     */
    public final static String LIST_AC_WORKS_GROUP_BY_TREEID = API_PREFIX + PORT + "/listAcWorksGroupByOrgTreeId.json";
    
    /**
     * 获取活动主办协办机构
     */
    public final static String LIST_ACTIVITY_ORGS = API_PREFIX + PORT + "/listActivityOrgs.json";
    /**
     * 获取活动参与人
     */
    public final static String LIST_ACTIVITY_JOIN_USERS = API_PREFIX + PORT + "/listActivityJoinUsers.json";
    /**
     * 获取活动作品评论
     */
    public final static String LIST_ACTIVITY_WORK_REVIEWS = API_PREFIX + PORT + "/listActivityWorkReviews.json";
    /**
     * 获取下级机构
     */
    public final static String LIST_SUB_ORGS = API_PREFIX + PORT + "/manage/tree/listSubOrgs.json";
    /**
     * 根据机构名称获取机构信息
     */
    public final static String LIST_ORGS_BYKEY = API_PREFIX + PORT + "/listOrgsByKey.json";
    /**
     * 获取活动组
     */
    public final static String LIST_ACTIVITY_GROUPS = API_PREFIX + PORT + "/listActivityGroups.json";
    /**
     * 添加作品
     */
    public final static String ADD_WORK = API_PREFIX + PORT + "/addWork.json";

    /**
     * 添加作品评论
     */
    public final static String ADD_WORK_REVIEW = API_PREFIX + PORT + "/addWorkReview.json";

    /**
     * 添加作品鲜花数
     */
    public final static String ADD_WORK_FLOWER = API_PREFIX + PORT + "/addWorkFlower.json";

    /**
     * 获取作品内容,标题,评论内容中的过滤词
     */
    public final static String LIST_WORD_UNIT = API_PREFIX + PORT + "/listWorkdUnit.json";
    /**
     * 获取评论提交权限
     */
    public final static String GET_REVIEW_LIMIT = API_PREFIX + PORT + "/getReviewLimit.json";

    /**
     * 添加作品鲜花数
     */
    public final static String UPDATE_ACTIVITY_STATE = API_PREFIX + PORT + "/updateActivityState.json";

    /**
     * 创建活动
     */
    public final static String CREATE_ACTIVITY = API_PREFIX + PORT + "/manage/activity/createActivity.json";
    /**
     * 评委相关----------------------------------------------------------------------------------------------------
     */
    /**
     * 获取评委活动列表
     */
    public final static String LIST_JURY_ACTIVITY = API_PREFIX + PORT + "/listJuryActivity.json";
    /**
     * 获取评委活动作品
     */
    public final static String LIST_JURY_AC_WORKS = API_PREFIX + PORT + "/listJuryAcWorks.json";
    
    /**
     * 用户管理相关----------------------------------------------------------------------------------------------------
     */
    /**
     * 获取正常用户列表
     */
    public final static String LIST_NORMAL_USER = API_PREFIX + PORT + "/manage/user/listNormalUser.json";
    /**
     * 踢出用户
     */
    public final static String KICKOUT_USER = API_PREFIX + PORT + "/manage/user/kickoutUser.json";
    /**
     * 获取用户加入设置
     */
    public final static String GET_USER_JOIN_SETTINGS = API_PREFIX + PORT + "/manage/tree/getOrgTreeInfo.json";
    /**
     * 修改用户加入设置
     */
    public final static String UPDATE_USER_JOIN_SETTINGS = API_PREFIX + PORT + "/manage/tree/updateOrgBaseinfo.json";
    /**
     * 获取待审核用户列表
     */
    public final static String LIST_AUDITING_USER = API_PREFIX + PORT + "/manage/user/listAuditingUser.json";
    /**
     * 获取用户审核信息
     */
    public final static String GET_USER_AUDIT = API_PREFIX + PORT + "/manage/user/getUserAudit.json";
    /**
     * 同意加入
     */
    public final static String AGREE_JOIN = API_PREFIX + PORT + "/manage/user/agreeJoin.json";
    /**
     * 修改密码
     */
    public final static String UPDATE_PASSWORD = API_PREFIX + PORT + "/manage/user/updatePassword.json";

    /* 机构相关 */
    public final static String GET_ORG_TREE_INFO = API_PREFIX + PORT + "/manage/tree/getOrgTreeInfo.json";

    public static final String UPDATE_ORG_TREE_BASE_INFO = API_PREFIX + PORT
            + "/manage/tree/updateOrgTreeBaseInfo.json";

    public static final String GET_ORG_TREE_INCHARGE = API_PREFIX + PORT + "/manage/tree/getOrgTreeIncharge.json";

    public static final String UPDATE_ORG_BASE_INFO = API_PREFIX + PORT + "/manage/tree/updateOrgBaseinfo.json";

    public static final String GET_ORG_BASE_INFO = API_PREFIX + PORT + "/manage/tree/getOrgBaseinfo.json";

    public static final String GET_ALL_WEB_TEMPLATE = API_PREFIX + PORT + "/manage/template/getAllWebTemplate.json";

    public static final String SET_WEB_TEMPLATE = API_PREFIX + PORT + "/manage/template/setWebTemplate.json";

    public final static String GET_ORG_TREE = API_PREFIX + PORT + "/manage/tree/g" +
    		"etOrgTree.json";

    public final static String GET_ALL_NAV = API_PREFIX + PORT + "/manage/appendmodel/getAllNav.json";

    public final static String SET_Nav = API_PREFIX + PORT + "/manage/appendmodel/setNav.json";

    public static final String LIST_ORG_BOOK_COMMENT = API_PREFIX + PORT
            + "/org/book/comment/listOrgBookCommentByPage.json";

    public static final String DELETE_ORG_BOOK_COMMENT = API_PREFIX + PORT
            + "/org/book/comment/deleteOrgBookComment.json";

    public static final String LIST_ORG_BOOK = API_PREFIX + PORT + "/manage/orgbook/listOrgBookByPage.json";

    public static final String DELETE_ORG_BOOK = API_PREFIX + PORT + "/manage/orgbook/setOrgBookState.json";

    public static final String LIST_ORG_CHOOSE_BOOK = API_PREFIX + PORT + "/manage/orgbook/listOrgChooseBook.json";

    public static final String LIST_SHOPCART = API_PREFIX + PORT + "/manage/orgbook/listShopCart.json";

    /**
     * 根据当前的机构书id获取整个机构下的所有机构树
     */
    public final static String GET_ORGTREES = API_PREFIX + PORT + "/manage/tree/getOrgTreesByOrgTreeId.json";

    /**
     * 管理员相关----------------------------------------------------------------------------------------------------
     */
    /**
     * 添加管理员
     */
    public final static String ADD_MANAGER = API_PREFIX + PORT + "/manage/user/addManager.json";
    /**
     * 获取管理员列表
     */
    public final static String LIST_MANAGER = API_PREFIX + PORT + "/manage/user/listManager.json";
    /**
     * 获取管理员信息
     */
    public final static String GET_MANAGER = API_PREFIX + PORT + "/manage/user/getManagerByUserId.json";
    /**
     * 修改管理员
     */
    public final static String UPDATE_MANAGER = API_PREFIX + PORT + "/manage/user/updateManager.json";
    /**
     * 检查用户名是否存在
     */
    public final static String CHECK_USERNAME = API_PREFIX + PORT + "/checkUserName.json";

    public static String DELETE_BOOK_FROM_SHOP_CART = API_PREFIX + PORT + "/manage/orgbook/deleteBookFromShopCart.json";

    public static String ADD_BOOK_TO_SHOP_CART = API_PREFIX + PORT + "/manage/orgbook/addBooksToShopCart.json";

    public static String BUY_BOOK_IN_SHOP_CART = API_PREFIX + PORT + "/manage/orgbook/payForBook.json";

    /**
     * 内容管理相关----------------------------------------------------------------------------------------------------
     */
    /**
     * 获取机构新闻
     */
    public final static String GET_ORG_NEWS = API_PREFIX + PORT + "/manage/orgNews/getOrgNews.json";
    /**
     * 添加机构新闻
     */
    public final static String ADD_ORG_NEWS = API_PREFIX  +PORT+ "/manage/orgNews/addOrgNews.json";
    /**
     * 移动机构新闻
     */
    public final static String MOVE_ORG_NEWS = API_PREFIX  +PORT+ "/manage/orgNews/moveOrgNews.json";

    /**
     * 根据id获取机构新闻
     */
    public static final String GET_ORG_NEWS_BY_ID = API_PREFIX  +PORT+ "/manage/orgNews/getOrgNewsById.json";
    /**
     * 修改机构新闻
     */
    public static String UPDATE_ORG_NEWS = API_PREFIX  +PORT+ "/manage/orgNews/updateOrgNews.json";
    /**
     * 批量删除机构新闻
     */
    public static final String DELETE_ORG_NEWS = API_PREFIX  +PORT+ "/manage/orgNews/deleteOrgNews.json";
    
    public static final String GET_ORG_BOOK_DETAIL = API_PREFIX  +PORT+ "/manage/orgbook/getOrgBookDetail.json";

    public static final String GET_CHOOSE_BOOK_DETAIL = API_PREFIX + PORT + "/manage/orgbook/getChooseBookDetail.json";

    public static String LIST_ALL_ORG_CHOOSE_BOOK = API_PREFIX + PORT + "/manage/orgbook/listAllOrgChooseBook.json";

    public static String LIST_All_ORG_BOOK = API_PREFIX + PORT + "/manage/orgbook/listAllOrgBook.json";
    
    //检查域名接口
    public static final String CHECK_ORG_TREE_DOMAIN =  API_PREFIX  +PORT+ "/getOrgTreeIdByDomain.json";

    //域名跳转接口
    public static String GET_ORG_TREE_By_DOMAIN = API_PREFIX  +PORT+ "/getOrgTreeIdByDomain.json";

    //域名跳转接口
    public static String GET_ORG_TREE_By_DOMAIN_AND_ID = API_PREFIX  +PORT+ "/getOrgTreeIdByDomainAndId.json";

    /**
     * 注册新用户
     */
	public static String REGISTER_USER = API_PREFIX  +PORT+ "/registerUser.json";

	/**
	 * 获取本机构用户推荐的图书
	 */
	public static String LIST_ORG_BOOK_RECOMMEND = API_PREFIX  +PORT+ "/manage/orgbook/listOrgBookRecommend.json";

	/**
	 * 获取本机构图书统计信息
	 */
	public static String GET_ORG_BOOK_RANDKING = API_PREFIX  +PORT+ "/manage/orgbook/getOrgBookStatisticsRanking.json";

    /**
     * 获取活动推荐列表
     */
    public static final String GET_ACTIVITY_RECOMMEND = API_PREFIX  +PORT+ "/manage/orgActivity/listActivityRecommend.json";

    /**
     * 根据机构树id和活动id获取推荐信息
     */
	public static final String GET_ACTIVITY_RECOMMEND_INFO = API_PREFIX  +PORT+ "/manage/orgActivity/getActivityRecommendInfo.json";

	/**
	 * 添加活动推荐
	 */
	public static final String ADD_ACTIVITY_RECOMMEND = API_PREFIX  +PORT+ "/manage/orgActivity/addActivityRecommend.json";

	/**
	 * 根据id获取活动推荐
	 */
	public static final String GET_ACRECOMMEND_BY_ID = API_PREFIX  +PORT+ "/manage/orgActivity/getActivityRecommendById.json";


	public static final String UPDATE_ACRECOMMEND = API_PREFIX  +PORT+ "/manage/orgActivity/updateActivityRecommend.json";


	public static final String MOVE_ACTIVITY_RECOMMEND = API_PREFIX  +PORT+ "/manage/orgActivity/moveActivityRecommend.json";


	public static final String DELETE_ACTIVITY_RECOMMEND = API_PREFIX  +PORT+ "/manage/orgActivity/batchDeleteActivityRecommend.json";

	/**
	 * 热门图书推荐
	 */
	public static final String LIST_HOT_BOOK = API_PREFIX  +PORT+ "/manage/orgbook/listHotBook.json";

	public static final String ADD_WEB_BOOK_CONTENT = API_PREFIX  +PORT+ "/manage/orgbook/addHotBook.json";

	public static final String GET_WEB_BOOK_CONTENT_BY_ID = API_PREFIX  +PORT+ "/manage/orgbook/getHotBookById.json";

	public static final String UPDATE_HOT_BOOK = API_PREFIX  +PORT+ "/manage/orgbook/updateHotBook.json";

	public static final String MOVE_BOOK_RECOMMEND = API_PREFIX  +PORT+ "/manage/orgbook/moveHotBook.json";

	public static final String DELETE_BOOK_RECOMMEND = API_PREFIX  +PORT+ "/manage/orgbook/batckDeleteHotBook.json";

	/**
	 * 返回地域信息
	 */
	public static final String GET_REGION = API_PREFIX  +PORT+ "/getRegion.json";

	/**
	 * 根据地域信息和机构名称查询机构树
	 */
	public static final String SEARCH_ORG = API_PREFIX  +PORT+ "/searchOrg.json";

    public static final String GET_ORG_TREE_APPEND_MODEL_ID =  API_PREFIX  +PORT+ "/listNavMenus.json";

    /**
     * 随机提取用户记录
     */
	public static final String RAND_GET_USER = API_PREFIX  +PORT+ "/randGetUser.json";

	/**
	 * 添加书友
	 */
	public static final String ADD_USER_CONCERNS = API_PREFIX  +PORT+ "/addUserConcerns.json";

	/**
	 * 随机提取图书
	 */
	public static final String RAND_GET_BOOK = API_PREFIX  +PORT+ "/randGetBook.json";

	/**
	 * 收藏图书
	 */
	public static final String ADD_USER_COLLECTION = API_PREFIX  +PORT+ "/addUserCollection.json";
	
	/**
	 * 获取错误信息
	 */
	public static final String GET_ERROR_BY_CODE = API_PREFIX  +PORT+ "/getErrorByCode.json";
	
	/**
	 * 查看用户是否是机构管理员
	 */
	public static final String IS_ORG_MANAGER = API_PREFIX  +PORT+ "/manage/user/isOrgManager.json";
	
	
	/**
     * 登录时发送获取用户系统短消息的队列
     */
    public static final String FETCH_LETTER = API_PREFIX  +PORT+ "/sendFetchLetterMessage.json";

    public static final String Add_USER_LOGIN_LOG = API_PREFIX  +PORT+ "/user/addUserLoginLog.json";
    
    public static final String GET_LOGIN_USER_INFO = API_PREFIX  +PORT+ "/getLoginUserInfo.json";
    
    public static final String GET_USER_PASS_INFO_BY_USERNAME = API_PREFIX  +PORT+ "/getUserPassInfoByUserName.json";

    public static final String SEND_EMAIL = API_PREFIX  +PORT+ "/mail/sendMail.json";

    public static final String GET_USER_LAST_READ_BOOK = API_PREFIX  +PORT+ "/getUserLastReadingBook.json";

    public static final String GET_USER_ORGS = API_PREFIX  +PORT+ "/getUserOrgTreeList.json";

    /**
     * 解除管理员权限
     */
	public static final String REMOVE_PERMISSION = API_PREFIX  +PORT+ "/manage/user/removePermission.json";

	/**
	 * 用户名是否包含关键词
	 */
	public static final String IS_IN_WORDUNIT = API_PREFIX  +PORT+ "/isInWordUnit.json";
	
	/**
	 * 教育云平台相关----------------------------------------------------------------------------------------------
	 */
	/**
	 * 导入用户
	 */
	public static final String EDU_YUN_IMPORT_USER = API_PREFIX  +PORT+ "/importUser.json";
	/**
	 * 精选图书专辑
	 */
	public static final String LIST_BOOK_PACKAGES_BY_TYPE = API_PREFIX  +PORT+ "/cooperation/bookpackage/listBookPackagesByType.json";
	/**
	 * 其他图书专辑
	 */
	public static final String LIST_OTHER_BOOK_PACKAGES = API_PREFIX  +PORT+ "/cooperation/bookpackage/listOtherBookPackages.json";
	/**
	 * 按类别获取图书专辑
	 */
	public static final String LIST_BOOK_PACKAGES_BY_CATEGORY = API_PREFIX  +PORT+ "/cooperation/bookpackage/listBookPackagesByCategory.json";
	/**
	 * 根据id获取图书专辑
	 */
	public static final String GET_BOOK_PACKAGE_BY_ID = API_PREFIX  +PORT+ "/cooperation/bookpackage/getBookPackageById.json";
	/**
	 * 根据id获取图书专辑
	 */
	public static final String GET_BOOK_PACKAGE_BY_BOOKID = API_PREFIX  +PORT+ "/cooperation/bookpackage/getBookPackageByBookId.json";
	/**
	 * 获取购物车列表
	 */
    public static final String LIST_SHOP_CART =  API_PREFIX  +PORT + "/cooperation/shopcart/listShopCart.json";

    /**
     * 往购物车里添加物品
     */
    public static final String Add_EDUYUN_SHOP_CART = API_PREFIX  +PORT + "/cooperation/shopcart/addShopCart.json";

    /**
     * 删除购物车里的条目
     */
    public static final String DETELE_SHOP_CART_ITEMS =  API_PREFIX  +PORT + "/cooperation/shopcart/deleteItem.json";

    /**
     * 我的订单列表
     */
    public static final String LIST_EDUYUN_MY_ORDERS = API_PREFIX  +PORT + "/cooperation/orders/listMyOrders.json";

    /**
     * 从购物车添加订单
     */
    public static final String ADD_EDUYUN_ORDERS = API_PREFIX  +PORT + "/cooperation/orders/addUserOrders.json";
    
    /**
     * 商品直接添加订单
     */
    public static final String ADD_EDUYUN_USER_ORDERS = API_PREFIX  +PORT + "/cooperation/orders/addEduYunUserOrders.json";

    /**
     *  显示订单详情
     */
    public static final String SHOW_ORDERS_DETAIL = API_PREFIX  +PORT + "/cooperation/orders/showOrdersDetail.json";

    /**
     * 根据订单id获取订单信息
     */
    public static final String GET_EDU_ODERS_BY_ID = API_PREFIX  +PORT + "/cooperation/orders/getOrders.json";

    /**
     * 根据异步通知信息更新订单信息
     */
    public static final String UPDATE_ORDERS_STATUS = API_PREFIX  +PORT + "/cooperation/orders/updateOrdersStatus.json";
    /**
     * 获取用户已购买的图书
     */
	public static String GET_USER_BUY_BOOK = API_PREFIX  +PORT + "/cooperation/study/getUserBuyBook.json";
	/**
	 * 获取用户已购买的图书包
	 */
	public static String GET_USER_BUY_PACKAGE = API_PREFIX  +PORT + "/cooperation/study/getUserBuyPackage.json";

	
	/**
	 * 根据分类获取首页推荐图书
	 */
	public static String LIST_BOOK_RECOMMEND_BY_TYPE = API_PREFIX  +PORT + "/cooperation/book/getBookRecommendByType.json";
	

    /**
     * 央管专题接口   --  获取图书列表（根据图书包名称）
     */
    public static final String GET_BOOK_LIST_BY_NAME = API_PREFIX + PORT + "/cooperation/bookpackage/getBookListByName.json";

    /**
     * 央管- 获取用户购买图书信息
     */
	public static final String GET_USER_BUY_BOOK_INFO = API_PREFIX + PORT + "/cooperation/book/getUserBuyBookInfo.json";
}
