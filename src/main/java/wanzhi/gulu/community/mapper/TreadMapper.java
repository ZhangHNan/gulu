package wanzhi.gulu.community.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import wanzhi.gulu.community.model.Tread;
import wanzhi.gulu.community.model.TreadExample;

public interface TreadMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tread
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    int countByExample(TreadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tread
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    int deleteByExample(TreadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tread
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tread
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    int insert(Tread record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tread
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    int insertSelective(Tread record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tread
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    List<Tread> selectByExampleWithRowbounds(TreadExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tread
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    List<Tread> selectByExample(TreadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tread
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    Tread selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tread
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    int updateByExampleSelective(@Param("record") Tread record, @Param("example") TreadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tread
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    int updateByExample(@Param("record") Tread record, @Param("example") TreadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tread
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    int updateByPrimaryKeySelective(Tread record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tread
     *
     * @mbggenerated Fri Apr 03 00:29:56 CST 2020
     */
    int updateByPrimaryKey(Tread record);
}