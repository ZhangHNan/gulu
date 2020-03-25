package wanzhi.gulu.community.mapper;

import wanzhi.gulu.community.dto.HotDTO;
import wanzhi.gulu.community.dto.PraiseDTO;
import wanzhi.gulu.community.dto.SearchDTO;
import wanzhi.gulu.community.model.Question;

import java.util.List;

public interface QuestionExtMapper {
    void incView(Question record);

    void incCommentCount(Question record);

    List<Question> selectRelated(Question record);

    Integer countBySearch(String regxpSearch);

    List<Question> selectBySearchPage(SearchDTO searchDTO);

    void incHot(HotDTO record);

    void incPraise(PraiseDTO record);

    void redPraise(PraiseDTO praiseDTO);
}