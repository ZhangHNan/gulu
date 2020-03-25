package wanzhi.gulu.community.cache;

import org.apache.commons.lang3.StringUtils;
import wanzhi.gulu.community.dto.TagDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//规范标签：只有这里定义的标签可以正常提交
public class TagCache {

    public static List<TagDTO> get() {
        List<TagDTO> tagDTOS = new ArrayList<>();
        TagDTO cate = new TagDTO();
        cate.setCategoryName("美食做法");
        cate.setTags(Arrays.asList("美食做法", "秘制菜肴", "懒人菜谱", "川菜", "鲁菜", "粤菜", "湘菜", "浙菜", "闽菜", "苏菜", "徽菜", "地方特色菜", "创新菜肴"));
        tagDTOS.add(cate);

        TagDTO skill = new TagDTO();
        skill.setCategoryName("美食技巧");
        skill.setTags(Arrays.asList("美食技巧", "原料选购","颠勺", "调味", "火候", "秘制酱料", "独门配方",  "独特技巧"));
        tagDTOS.add(skill);


        TagDTO culture = new TagDTO();
        culture.setCategoryName("美食文化");
        culture.setTags(Arrays.asList("美食文化","美食历史","川菜文化", "鲁菜文化", "粤菜文化", "湘菜文化", "浙菜文化", "闽菜文化", "苏菜文化", "徽菜文化","地方特色文化","创新文化","其他文化"));
        tagDTOS.add(culture);

        TagDTO tool = new TagDTO();
        tool.setCategoryName("厨具使用");
        tool.setTags(Arrays.asList("厨具使用", "炊具", "刀具", "厨房器具", "打蛋器", "电饭煲", "厨房家电", "厨房安全"));
        tagDTOS.add(tool);

        TagDTO help = new TagDTO();
        help.setCategoryName("问题求助");
        help.setTags(Arrays.asList("问题求助", "制作疑问", "十万个为什么", "这是什么", "其他疑问"));
        tagDTOS.add(help);

        TagDTO els = new TagDTO();
        els.setCategoryName("其他");
        els.setTags(Arrays.asList("其他"));
        tagDTOS.add(els);


        return tagDTOS;
    }

    //判断客户端输入的标签是不是有非规范的标签，返回有问题标签字段
    public static String filterInvalid(String tags) {
        //将前端传入的标签字符串以，分割分裂成数组
        String[] split = StringUtils.split(tags, ",");
        //获取合法标签对象
        List<TagDTO> tagDTOS = get();
        //获取所有标签转为List集合
        List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        //如果传入标签是空或者合法标签库不存在该标签，加入返回的字符串后面
        String invalid = Arrays.stream(split).filter(t -> StringUtils.isBlank(t) || !tagList.contains(t)).collect(Collectors.joining(","));
        //如果前端传入的标签合法，应该返回空字符串
        return invalid;
    }
}
