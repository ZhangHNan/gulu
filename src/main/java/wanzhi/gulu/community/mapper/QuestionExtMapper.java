package wanzhi.gulu.community.mapper;

import wanzhi.gulu.community.dto.CountDTO;
import wanzhi.gulu.community.dto.SearchDTO;
import wanzhi.gulu.community.model.Question;

import java.util.List;

public interface QuestionExtMapper {
    //增加浏览数
    void incView(Question record);

    //增加评论数
    void incCommentCount(Question record);

    //相关搜索
    List<Question> selectRelated(Question record);

    //首页查询数量功能
    Integer countBySearch(String regxpSearch);

    //首页查询功能
    List<Question> selectBySearchPage(SearchDTO searchDTO);

    //增加热度值
    void incHot(CountDTO record);

    //减少热度值
    void redHot(CountDTO hotDTO);

    //增加点赞数
    void incPraise(CountDTO record);

    //减少点赞数
    void redPraise(CountDTO countDTO);

    //增加踩数
    void incTread(CountDTO countDTO);

    //减少踩数
    void redTread(CountDTO countDTO);

    //增加收藏数
    void incStar(CountDTO countDTO);

    //减少收藏数
    void redStar(CountDTO countDTO);
}