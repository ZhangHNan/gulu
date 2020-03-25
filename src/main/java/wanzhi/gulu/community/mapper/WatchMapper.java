package wanzhi.gulu.community.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import wanzhi.gulu.community.model.Watch;
import wanzhi.gulu.community.model.WatchExample;

public interface WatchMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table watch
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int countByExample(WatchExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table watch
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int deleteByExample(WatchExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table watch
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table watch
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int insert(Watch record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table watch
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int insertSelective(Watch record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table watch
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    List<Watch> selectByExampleWithRowbounds(WatchExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table watch
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    List<Watch> selectByExample(WatchExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table watch
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    Watch selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table watch
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int updateByExampleSelective(@Param("record") Watch record, @Param("example") WatchExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table watch
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int updateByExample(@Param("record") Watch record, @Param("example") WatchExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table watch
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int updateByPrimaryKeySelective(Watch record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table watch
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int updateByPrimaryKey(Watch record);
}