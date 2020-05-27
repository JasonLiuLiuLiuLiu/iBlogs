package site.iblogs.common.model;

public enum ConfigKey {

    Default("默认"),
    SiteTitle("网站标题", "iBlogs", true),
    AttachUrl("附件地址"),
    CdnUrl("CdnUrl,谨慎设置", true),
    Description("站点描述", "a blogs system power by asp.net core", true),
    AllowCloudCdn("是否允许使用云CDN加速,如果启用公共的静态js,css会从公共CND加载", true),
    SiteSubtitle("站点子标题", true),
    SiteUrl("网站地址", true),
    Keywords("网站关键字", true),
    AllowInstall("是否允许重新安装", "true"),
    Github("Github地址", true),
    WeiBo("微博地址", true),
    Twitter("Twitter地址", true),
    ZhiHu("知乎地址", true),
    AllowCommentAudit("评论是否需要审核", true),
    Author("博客署名作者名称,显示在文章底部", "iBlogs", true),
    SideBarTagsCount("首页侧边栏标签显示数目", true),
    SideBarCategoriesCount("首页侧边栏分类显示数目", true),
    LoginErrorCount("登录失败次数限制,尚未启用"),
    MaxPage("每页显示的最大数量", "100", true),
    PageSize("每页显示的内容的大小", "20", true),
    MaxTextCount("文章的最大字数", "2147483647", true),
    MaxTitleCount("标题最大字数", "200", true),
    MaxIntroCount("摘要字数", "1000", true),
    MaxFileSize("上传文件大小限制", true),
    BlockIpList("限制ip列表(,)分隔,该功能未生效", true),
    StaticUrl("静态文件地址", true),
    TemplesPath("模板地址"),
    ThemePath("主题地址"),
    GitWebHookSecret("Git钩子暗号"),
    GitProjectCloneUrl("Git文章仓库地址"),
    GitUerName("Git用户名"),
    GitPassword("Git密码"),
    GitCommitter("Git提交者名称,该用户提交后Git钩子通知本系统不再重复处理", "iBlogs"),
    GitAuthorId("Git文章提交以该用户为作者", "1"),
    CnBlogsSyncSwitch("博客园同步开关", "false"),
    CnBlogsUserName("博客园用户名"),
    CnBlogsPassword("博客园密码"),
    CnBlogsUrl("博客园同步地址", "https://rpc.cnblogs.com/metaweblog/{YourBlogName}"),
    GoogleAnalyticId("谷歌站点统计跟踪Id,https://analytics.google.com", true),
    BaiDuTongJiId("百度统计Id,https://tongji.baidu.com", true),
    SiteInstallTime("站点安装时间,用于首页显示网站运行时间", true),
    ContentCount("文章数目"),
    CommentCount("评论数目"),
    LastActiveTime("最后活动时间"),
    Announcement("通知公告,支持HTML", "请在后台管理系统中配置您的公告信息", true),
    FootContent1("页脚信息1,支持HTML", "请在后台管理系统中配置您的页脚信息1", true),
    FootContent2("页脚信息2,支持HTML", "请后台管理系统中配置您的页脚信息2", true),
    EmailFromAccount("邮件通知From邮箱地址", true),
    EmailUserName("邮箱服务器用户名", true),
    EmailPassword("邮箱服务器密码", true),
    EmailSmtpHost("邮件服务器地址", true),
    EmailSmtpHostPort("邮件服务器端口", "587", true),
    AdminEmail("管理员邮箱"),
    FtpUrl("Ftp服务器地址", "v0.ftp.upyun.com", true),
    FtpUid("Ftp用户名", true),
    FtpPwd("Ftp密码", true);

    public String getDescription() {
        return description;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public Boolean getEditable() {
        return editable;
    }

    private String description;
    private String defaultValue;
    private Boolean editable;

    ConfigKey(String description) {
        this(description, false);
    }

    ConfigKey(String description, Boolean editable) {
        this(description, null, editable);
    }

    ConfigKey(String description, String defaultValue) {
        this(description, defaultValue, false);
    }

    ConfigKey(String description, String defaultValue, Boolean editable) {
        this.description = description;
        this.defaultValue = defaultValue;
        this.editable = editable;
    }


}
