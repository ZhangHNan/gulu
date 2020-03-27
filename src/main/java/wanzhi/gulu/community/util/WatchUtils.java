package wanzhi.gulu.community.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wanzhi.gulu.community.dto.CountDTO;
import wanzhi.gulu.community.mapper.UserExtMapper;

@Component
public class WatchUtils {

    @Autowired
    UserExtMapper userExtMapper;

    public void incFans(Long id, long incCount) {
        CountDTO countDTO = new CountDTO();
        countDTO.setId(id);
        countDTO.setCount(incCount);
        userExtMapper.incFans(countDTO);
    }

    public void redFans(Long id, long redCount) {
        CountDTO countDTO = new CountDTO();
        countDTO.setId(id);
        countDTO.setCount(redCount);
        userExtMapper.redFans(countDTO);
    }
}
