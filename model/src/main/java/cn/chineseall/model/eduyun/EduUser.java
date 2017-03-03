package cn.chineseall.model.eduyun;

public class EduUser {
    //用户id
    private String personid;
    
    //用户手机号
    private String mobnum;
    
    //用户邮箱
    private String email;
    
    //用户姓名
    private String name;
    
    //昵称
    private String nickname;
    
    //用户归属地区域
    private String areacode;
    
    //性别  0是女，1为男
    private String gender;
    
    //生日
    private String birthday;
    
    //用户类型  学生:0 老师:1 家长:2 机构:3
    private String usertype;
    
    //通信地址
    private String address;
    
    //邮编
    private String postcode;
  
    //头像
    private String logourl;
    
    //兴趣
    private String interests;
    
    //职业
    private String profession;
    
    //证件类型 0：身份证 1:护照 2:军人证 3:其他
    private String credtype;
    
    //证件号码
    private String idcardno;
    
    //用户签名
    private String singature;
    
    //粉丝数量
    private String fnascount;
    
    
    //所教学科
    private String subjectid;
    
    //学科名称
    private String subjectname;
    
    //教材id
    private String teachmaterialid;
    
    //教材名称
    private String teachmaterialname;
    
    //班级id
    private String classid;
    
    //班级名称
    private String classname;
    
    //班级成立年份
    private String foundtime;
    
    //所属机构/学校id
    private String orgaid;
    
    //所属机构/学校名称
    private String organame;
    
    //在机构中的身份 1:管理员  2：成员  3：教研员； 4：教务员； 5：信息员，
    private String[] orgaidentity;
    
    //岗位职称1：初级教师  2：中级教师 3：高级教师
    private String jobtitle;
    
    //帐号
    private String account;
    
    //所教科目
    private String teacherageid;
    
    //所教教材
    private String teachmaterials;
    
    private String[] userlogolist;
    
    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public String getMobnum() {
        return mobnum;
    }

    public void setMobnum(String mobnum) {
        this.mobnum = mobnum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTeacherageid() {
        return teacherageid;
    }

    public void setTeacherageid(String teacherageid) {
        this.teacherageid = teacherageid;
    }

    public String getTeachmaterials() {
        return teachmaterials;
    }

    public void setTeachmaterials(String teachmaterials) {
        this.teachmaterials = teachmaterials;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getLogourl() {
        return logourl;
    }

    public void setLogourl(String logourl) {
        this.logourl = logourl;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCredtype() {
        return credtype;
    }

    public void setCredtype(String credtype) {
        this.credtype = credtype;
    }

    public String getIdcardno() {
        return idcardno;
    }

    public void setIdcardno(String idcardno) {
        this.idcardno = idcardno;
    }

    public String getSingature() {
        return singature;
    }

    public void setSingature(String singature) {
        this.singature = singature;
    }

    public String getFnascount() {
        return fnascount;
    }

    public void setFnascount(String fnascount) {
        this.fnascount = fnascount;
    }

    public String getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getTeachmaterialid() {
        return teachmaterialid;
    }

    public void setTeachmaterialid(String teachmaterialid) {
        this.teachmaterialid = teachmaterialid;
    }

    public String getTeachmaterialname() {
        return teachmaterialname;
    }

    public void setTeachmaterialname(String teachmaterialname) {
        this.teachmaterialname = teachmaterialname;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getFoundtime() {
        return foundtime;
    }

    public void setFoundtime(String foundtime) {
        this.foundtime = foundtime;
    }

    public String getOrgaid() {
        return orgaid;
    }

    public void setOrgaid(String orgaid) {
        this.orgaid = orgaid;
    }

    public String getOrganame() {
        return organame;
    }

    public void setOrganame(String organame) {
        this.organame = organame;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String[] getOrgaidentity() {
        return orgaidentity;
    }

    public void setOrgaidentity(String[] orgaidentity) {
        this.orgaidentity = orgaidentity;
    }

    public String[] getUserlogolist() {
        return userlogolist;
    }

    public void setUserlogolist(String[] userlogolist) {
        this.userlogolist = userlogolist;
    }
}
