package wanzhi.gulu.community.model;

public class Comment {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.id
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.type
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.target_id
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    private Long targetId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.commentator
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    private Long commentator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.content
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.like_count
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    private Long likeCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.tread_count
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    private Long treadCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.comment_count
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    private Long commentCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.hot
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    private Long hot;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.gmt_create
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    private Long gmtCreate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.gmt_modified
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    private Long gmtModified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.id
     *
     * @return the value of comment.id
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.id
     *
     * @param id the value for comment.id
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.type
     *
     * @return the value of comment.type
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.type
     *
     * @param type the value for comment.type
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.target_id
     *
     * @return the value of comment.target_id
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    public Long getTargetId() {
        return targetId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.target_id
     *
     * @param targetId the value for comment.target_id
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.commentator
     *
     * @return the value of comment.commentator
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    public Long getCommentator() {
        return commentator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.commentator
     *
     * @param commentator the value for comment.commentator
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    public void setCommentator(Long commentator) {
        this.commentator = commentator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.content
     *
     * @return the value of comment.content
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.content
     *
     * @param content the value for comment.content
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.like_count
     *
     * @return the value of comment.like_count
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    public Long getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.like_count
     *
     * @param likeCount the value for comment.like_count
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.tread_count
     *
     * @return the value of comment.tread_count
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    public Long getTreadCount() {
        return treadCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.tread_count
     *
     * @param treadCount the value for comment.tread_count
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    public void setTreadCount(Long treadCount) {
        this.treadCount = treadCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.comment_count
     *
     * @return the value of comment.comment_count
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    public Long getCommentCount() {
        return commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.comment_count
     *
     * @param commentCount the value for comment.comment_count
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.hot
     *
     * @return the value of comment.hot
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    public Long getHot() {
        return hot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.hot
     *
     * @param hot the value for comment.hot
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    public void setHot(Long hot) {
        this.hot = hot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.gmt_create
     *
     * @return the value of comment.gmt_create
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.gmt_create
     *
     * @param gmtCreate the value for comment.gmt_create
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.gmt_modified
     *
     * @return the value of comment.gmt_modified
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.gmt_modified
     *
     * @param gmtModified the value for comment.gmt_modified
     *
     * @mbggenerated Wed Mar 25 14:53:37 CST 2020
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }
}