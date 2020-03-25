package wanzhi.gulu.community.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import wanzhi.gulu.community.model.Star;
import wanzhi.gulu.community.model.StarExample;

public interface StarMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int countByExample(StarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int deleteByExample(StarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int insert(Star record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int insertSelective(Star record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    List<Star> selectByExampleWithRowbounds(StarExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    List<Star> selectByExample(StarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    Star selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int updateByExampleSelective(@Param("record") Star record, @Param("example") StarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int updateByExample(@Param("record") Star record, @Param("example") StarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int updateByPrimaryKeySelective(Star record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int updateByPrimaryKey(Star record);
}