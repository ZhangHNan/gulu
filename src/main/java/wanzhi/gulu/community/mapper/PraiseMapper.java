package wanzhi.gulu.community.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import wanzhi.gulu.community.model.Praise;
import wanzhi.gulu.community.model.PraiseExample;

public interface PraiseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table praise
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int countByExample(PraiseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table praise
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int deleteByExample(PraiseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table praise
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table praise
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int insert(Praise record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table praise
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int insertSelective(Praise record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table praise
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    List<Praise> selectByExampleWithRowbounds(PraiseExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table praise
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    List<Praise> selectByExample(PraiseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table praise
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    Praise selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table praise
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int updateByExampleSelective(@Param("record") Praise record, @Param("example") PraiseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table praise
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int updateByExample(@Param("record") Praise record, @Param("example") PraiseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table praise
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int updateByPrimaryKeySelective(Praise record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table praise
     *
     * @mbggenerated Thu Mar 26 00:55:56 CST 2020
     */
    int updateByPrimaryKey(Praise record);
}