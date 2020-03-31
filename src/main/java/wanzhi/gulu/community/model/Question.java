package wanzhi.gulu.community.model;

public class Question {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.id
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.title
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.tag
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    private String tag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.creator
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    private Long creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.view_count
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    private Long viewCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.praise_count
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    private Long praiseCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.tread_count
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    private Long treadCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.comment_count
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    private Long commentCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.hot
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    private Long hot;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.gmt_create
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    private Long gmtCreate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.gmt_modified
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    private Long gmtModified;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.star_count
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    private Long starCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.ban
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    private Integer ban;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.description
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.id
     *
     * @return the value of question.id
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.id
     *
     * @param id the value for question.id
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.title
     *
     * @return the value of question.title
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.title
     *
     * @param title the value for question.title
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.tag
     *
     * @return the value of question.tag
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public String getTag() {
        return tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.tag
     *
     * @param tag the value for question.tag
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.creator
     *
     * @return the value of question.creator
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.creator
     *
     * @param creator the value for question.creator
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.view_count
     *
     * @return the value of question.view_count
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public Long getViewCount() {
        return viewCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.view_count
     *
     * @param viewCount the value for question.view_count
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.praise_count
     *
     * @return the value of question.praise_count
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public Long getPraiseCount() {
        return praiseCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.praise_count
     *
     * @param praiseCount the value for question.praise_count
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public void setPraiseCount(Long praiseCount) {
        this.praiseCount = praiseCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.tread_count
     *
     * @return the value of question.tread_count
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public Long getTreadCount() {
        return treadCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.tread_count
     *
     * @param treadCount the value for question.tread_count
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public void setTreadCount(Long treadCount) {
        this.treadCount = treadCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.comment_count
     *
     * @return the value of question.comment_count
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public Long getCommentCount() {
        return commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.comment_count
     *
     * @param commentCount the value for question.comment_count
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.hot
     *
     * @return the value of question.hot
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public Long getHot() {
        return hot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.hot
     *
     * @param hot the value for question.hot
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public void setHot(Long hot) {
        this.hot = hot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.gmt_create
     *
     * @return the value of question.gmt_create
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.gmt_create
     *
     * @param gmtCreate the value for question.gmt_create
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.gmt_modified
     *
     * @return the value of question.gmt_modified
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.gmt_modified
     *
     * @param gmtModified the value for question.gmt_modified
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.star_count
     *
     * @return the value of question.star_count
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public Long getStarCount() {
        return starCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.star_count
     *
     * @param starCount the value for question.star_count
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public void setStarCount(Long starCount) {
        this.starCount = starCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.ban
     *
     * @return the value of question.ban
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public Integer getBan() {
        return ban;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.ban
     *
     * @param ban the value for question.ban
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public void setBan(Integer ban) {
        this.ban = ban;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.description
     *
     * @return the value of question.description
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.description
     *
     * @param description the value for question.description
     *
     * @mbggenerated Tue Mar 31 15:22:09 CST 2020
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}