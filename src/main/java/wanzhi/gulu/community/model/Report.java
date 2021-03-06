package wanzhi.gulu.community.model;

public class Report {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column report.id
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column report.target_id
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    private Long targetId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column report.target_type
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    private Integer targetType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column report.report_type
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    private String reportType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column report.report_reason
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    private String reportReason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column report.reporter
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    private Long reporter;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column report.gmt_create
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    private Long gmtCreate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column report.id
     *
     * @return the value of report.id
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column report.id
     *
     * @param id the value for report.id
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column report.target_id
     *
     * @return the value of report.target_id
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public Long getTargetId() {
        return targetId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column report.target_id
     *
     * @param targetId the value for report.target_id
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column report.target_type
     *
     * @return the value of report.target_type
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public Integer getTargetType() {
        return targetType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column report.target_type
     *
     * @param targetType the value for report.target_type
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public void setTargetType(Integer targetType) {
        this.targetType = targetType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column report.report_type
     *
     * @return the value of report.report_type
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public String getReportType() {
        return reportType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column report.report_type
     *
     * @param reportType the value for report.report_type
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public void setReportType(String reportType) {
        this.reportType = reportType == null ? null : reportType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column report.report_reason
     *
     * @return the value of report.report_reason
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public String getReportReason() {
        return reportReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column report.report_reason
     *
     * @param reportReason the value for report.report_reason
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public void setReportReason(String reportReason) {
        this.reportReason = reportReason == null ? null : reportReason.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column report.reporter
     *
     * @return the value of report.reporter
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public Long getReporter() {
        return reporter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column report.reporter
     *
     * @param reporter the value for report.reporter
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public void setReporter(Long reporter) {
        this.reporter = reporter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column report.gmt_create
     *
     * @return the value of report.gmt_create
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column report.gmt_create
     *
     * @param gmtCreate the value for report.gmt_create
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}