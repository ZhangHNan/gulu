package wanzhi.gulu.community.model;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.account_id
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    private Long accountId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.name
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.token
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    private String token;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.avatar_url
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    private String avatarUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.bio
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    private String bio;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.phone
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.email
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.like_count
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    private Long likeCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.fans_count
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    private Long fansCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.hot
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    private Long hot;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.power
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    private Integer power;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.gmt_create
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    private Long gmtCreate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.gmt_modified
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    private Long gmtModified;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.illegal_count
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    private Integer illegalCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.ban
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    private Integer ban;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.account_id
     *
     * @return the value of user.account_id
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.account_id
     *
     * @param accountId the value for user.account_id
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.name
     *
     * @return the value of user.name
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.name
     *
     * @param name the value for user.name
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.token
     *
     * @return the value of user.token
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public String getToken() {
        return token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.token
     *
     * @param token the value for user.token
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.avatar_url
     *
     * @return the value of user.avatar_url
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.avatar_url
     *
     * @param avatarUrl the value for user.avatar_url
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.bio
     *
     * @return the value of user.bio
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public String getBio() {
        return bio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.bio
     *
     * @param bio the value for user.bio
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public void setBio(String bio) {
        this.bio = bio == null ? null : bio.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.phone
     *
     * @return the value of user.phone
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.phone
     *
     * @param phone the value for user.phone
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.email
     *
     * @return the value of user.email
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.email
     *
     * @param email the value for user.email
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.like_count
     *
     * @return the value of user.like_count
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public Long getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.like_count
     *
     * @param likeCount the value for user.like_count
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.fans_count
     *
     * @return the value of user.fans_count
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public Long getFansCount() {
        return fansCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.fans_count
     *
     * @param fansCount the value for user.fans_count
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public void setFansCount(Long fansCount) {
        this.fansCount = fansCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.hot
     *
     * @return the value of user.hot
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public Long getHot() {
        return hot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.hot
     *
     * @param hot the value for user.hot
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public void setHot(Long hot) {
        this.hot = hot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.power
     *
     * @return the value of user.power
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public Integer getPower() {
        return power;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.power
     *
     * @param power the value for user.power
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public void setPower(Integer power) {
        this.power = power;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.gmt_create
     *
     * @return the value of user.gmt_create
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.gmt_create
     *
     * @param gmtCreate the value for user.gmt_create
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.gmt_modified
     *
     * @return the value of user.gmt_modified
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.gmt_modified
     *
     * @param gmtModified the value for user.gmt_modified
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.illegal_count
     *
     * @return the value of user.illegal_count
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public Integer getIllegalCount() {
        return illegalCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.illegal_count
     *
     * @param illegalCount the value for user.illegal_count
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public void setIllegalCount(Integer illegalCount) {
        this.illegalCount = illegalCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.ban
     *
     * @return the value of user.ban
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public Integer getBan() {
        return ban;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.ban
     *
     * @param ban the value for user.ban
     *
     * @mbggenerated Wed Apr 01 23:10:45 CST 2020
     */
    public void setBan(Integer ban) {
        this.ban = ban;
    }
}