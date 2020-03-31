package wanzhi.gulu.community.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import wanzhi.gulu.community.model.ReportDeal;
import wanzhi.gulu.community.model.ReportDealExample;

public interface ReportDealMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 23:17:03 CST 2020
     */
    int countByExample(ReportDealExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 23:17:03 CST 2020
     */
    int deleteByExample(ReportDealExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 23:17:03 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 23:17:03 CST 2020
     */
    int insert(ReportDeal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 23:17:03 CST 2020
     */
    int insertSelective(ReportDeal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 23:17:03 CST 2020
     */
    List<ReportDeal> selectByExampleWithRowbounds(ReportDealExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 23:17:03 CST 2020
     */
    List<ReportDeal> selectByExample(ReportDealExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 23:17:03 CST 2020
     */
    ReportDeal selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 23:17:03 CST 2020
     */
    int updateByExampleSelective(@Param("record") ReportDeal record, @Param("example") ReportDealExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 23:17:03 CST 2020
     */
    int updateByExample(@Param("record") ReportDeal record, @Param("example") ReportDealExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 23:17:03 CST 2020
     */
    int updateByPrimaryKeySelective(ReportDeal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 23:17:03 CST 2020
     */
    int updateByPrimaryKey(ReportDeal record);
}