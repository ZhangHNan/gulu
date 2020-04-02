package wanzhi.gulu.community.model;

public class Notification {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification.id
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification.notifier
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    private Long notifier;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification.receiver
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    private Long receiver;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification.outer_id
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    private Long outerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification.outer_title
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    private String outerTitle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification.source_id
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    private Long sourceId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification.type
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification.type_name
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    private String typeName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification.status
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification.gmt_create
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    private Long gmtCreate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification.id
     *
     * @return the value of notification.id
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification.id
     *
     * @param id the value for notification.id
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification.notifier
     *
     * @return the value of notification.notifier
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public Long getNotifier() {
        return notifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification.notifier
     *
     * @param notifier the value for notification.notifier
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public void setNotifier(Long notifier) {
        this.notifier = notifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification.receiver
     *
     * @return the value of notification.receiver
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public Long getReceiver() {
        return receiver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification.receiver
     *
     * @param receiver the value for notification.receiver
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification.outer_id
     *
     * @return the value of notification.outer_id
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public Long getOuterId() {
        return outerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification.outer_id
     *
     * @param outerId the value for notification.outer_id
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public void setOuterId(Long outerId) {
        this.outerId = outerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification.outer_title
     *
     * @return the value of notification.outer_title
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public String getOuterTitle() {
        return outerTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification.outer_title
     *
     * @param outerTitle the value for notification.outer_title
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public void setOuterTitle(String outerTitle) {
        this.outerTitle = outerTitle == null ? null : outerTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification.source_id
     *
     * @return the value of notification.source_id
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public Long getSourceId() {
        return sourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification.source_id
     *
     * @param sourceId the value for notification.source_id
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification.type
     *
     * @return the value of notification.type
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification.type
     *
     * @param type the value for notification.type
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification.type_name
     *
     * @return the value of notification.type_name
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification.type_name
     *
     * @param typeName the value for notification.type_name
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification.status
     *
     * @return the value of notification.status
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification.status
     *
     * @param status the value for notification.status
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification.gmt_create
     *
     * @return the value of notification.gmt_create
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification.gmt_create
     *
     * @param gmtCreate the value for notification.gmt_create
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}