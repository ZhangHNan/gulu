package wanzhi.gulu.community.mapper;

import wanzhi.gulu.community.dto.CountDTO;
import wanzhi.gulu.community.dto.SearchDTO;
import wanzhi.gulu.community.model.Question;

import java.util.List;

public interface QuestionExtMapper {
    void incView(Question record);

    void incCommentCount(Question record);

    List<Question> selectRelated(Question record);

    Integer countBySearch(String regxpSearch);

    List<Question> selectBySearchPage(SearchDTO searchDTO);

    void incHot(CountDTO record);

    void incPraise(CountDTO record);

    void redPraise(CountDTO countDTO);

    void incTread(CountDTO countDTO);

    void redTread(CountDTO countDTO);

    void redHot(CountDTO hotDTO);

    void incStar(CountDTO countDTO);

    void redStar(CountDTO countDTO);
}