package code.heitao.small.framework.constant;

public enum ErrorEnum {
    PARAM_IS_NULL("SYS001", "参数不能为空"),
    FILE_UPLOAD_ERROR("SYS002", "文件上传失败"),
    FILE_UPLOAD_LENGTH_ERROR("SYS016", "附件上传大小不能超过30M，请重新上传"),
    FILE_UPLOAD_EXTENSION_ERROR("SYS017", "附件上传格式不正确，请重新上传zip格式文件"),
    VERIFY_CODE_NULL("SYS003", "验证码不能为空"),
    VERIFY_CODE_EXPIRED("SYS004", "验证码已经过期"),
    VERIFY_CODE_ERROR("SYS005", "验证码错误"),
    TEAM_NAME_REPEAT("SYS006", "队伍名称重复"),
    TEAM_NAME_BLANK("SYS007", "队伍名称不能为空"),
    PHONE_REPEAT("SYS008", "该手机号已经使用"),
    PHONE_WRONG("SYS009", "手机号码不正确"),
    ID_IS_NULL("SYS010", "Id 不能为空"),
    SYSTEM_ERROR("SYS999", "系统未知错误,请重试"), 
    LEADER_PHONE_NULL("SYS011", "手机号码不能为空"),
    SIGN_CODE_NULL("SYS012", "参赛码不能为空"),
    FILE_DOWNLOAD_LIMIT("SYS014", "文件太大超过30M最大限制"),
    JOIN_FROM_LENGTH_ERROR("SYS015", "邀请码长度不正确，请输入四位邀请码"),
    UPDATE_TEAMINFO_ERROR("SYS018", "更新报名信息失败"),
    FILE_NAME_EMPTY("SYS019", "文件名不存在"),
	FILE_DOWNLOAD_ERROR("SYS013", "文件下载失败"),;
    private String code;
    private String msg;

    ErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }
    public String getMsg(){
        return msg;
    }
}
