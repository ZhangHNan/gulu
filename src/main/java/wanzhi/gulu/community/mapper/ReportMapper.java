package wanzhi.gulu.community.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import wanzhi.gulu.community.model.Report;
import wanzhi.gulu.community.model.ReportExample;

public interface ReportMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    int countByExample(ReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    int deleteByExample(ReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    int insert(Report record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    int insertSelective(Report record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    List<Report> selectByExampleWithRowbounds(ReportExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    List<Report> selectByExample(ReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    Report selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    int updateByExampleSelective(@Param("record") Report record, @Param("example") ReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    int updateByExample(@Param("record") Report record, @Param("example") ReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    int updateByPrimaryKeySelective(Report record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    int updateByPrimaryKey(Report record);
}