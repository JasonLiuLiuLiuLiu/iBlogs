package site.iblogs.common.model;

public class ConfigKey {

    public static String Default="Default";
    public static String SiteTitle="SiteTitle";
    public static String AttachUrl="AttachUrl";
    public static String CdnUrl="CdnUrl";
    public static String Description="Description";
    public static String AllowCloudCdn="AllowCloudCdn";
    public static String SiteSubtitle="SiteSubtitle";
    public static String SiteUrl="SiteUrl";
    public static String Keywords="Keywords";
    public static String AllowInstall="AllowInstall";
    public static String Github="Github";
    public static String WeiBo="WeiBo";
    public static String Twitter="Twitter";
    public static String ZhiHu="ZhiHu";
    public static String AllowCommentAudit="AllowCommentAudit";
    public static String Author="Author";
    public static String SideBarTagsCount="SideBarTagsCount";
    public static String SideBarCategoriesCou="SideBarCategoriesCount";
    public static String LoginErrorCount="LoginErrorCount";
    public static String MaxPage="MaxPage";
    public static String PageSize="PageSize";
    public static String MaxTextCount="MaxTextCount";
    public static String MaxTitleCount="MaxTitleCount";
    public static String MaxIntroCount="MaxIntroCount";
    public static String MaxFileSize="MaxFileSize";
    public static String BlockIpList="BlockIpList";
    public static String StaticUrl="StaticUrl";
    public static String TemplesPath="TemplesPath";
    public static String ThemePath="ThemePath";
    public static String GitWebHookSecret="GitWebHookSecret";
    public static String GitProjectCloneUrl="GitProjectCloneUrl";
    public static String GitUerName="GitUerName";
    public static String GitPassword="GitPassword";
    public static String GitCommitter="GitCommitter";
    public static String GitAuthorId="GitAuthorId";
    public static String CnBlogsSyncSwitch="CnBlogsSyncSwitch";
    public static String CnBlogsUserName="CnBlogsUserName";
    public static String CnBlogsPassword="CnBlogsPassword";
    public static String CnBlogsUrl="CnBlogsUrl";
    public static String GoogleAnalyticId="GoogleAnalyticId";
    public static String BaiDuTongJiId="BaiDuTongJiId";
    public static String SiteInstallTime="SiteInstallTime";
    public static String ContentCount="ContentCount";
    public static String CommentCount="CommentCount";
    public static String LastActiveTime="LastActiveTime";
    public static String Announcement="Announcement";
    public static String FootContent1="FootContent1";
    public static String FootContent2="FootContent2";
    public static String EmailFromAccount="EmailFromAccount";
    public static String EmailUserName="EmailUserName";
    public static String EmailPassword="EmailPassword";
    public static String EmailSmtpHost="EmailSmtpHost";
    public static String EmailSmtpHostPort="EmailSmtpHostPort";
    public static String AdminEmail="AdminEmail";
    public static String FtpUrl="FtpUrl";
    public static String FtpUid="FtpUid";
    public static String FtpPwd="FtpPwd";

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
