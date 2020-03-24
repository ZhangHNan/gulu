CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL COMMENT '0表示评论问题，1表示评论评论',
  `target_id` bigint(20) DEFAULT NULL COMMENT '被评论的问题或评论的id',
  `commentator` bigint(20) DEFAULT NULL COMMENT '评论人id',
  `content` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '评论内容',
  `like_count` bigint(20) NOT NULL DEFAULT '0' COMMENT '获赞数',
  `tread_count` bigint(20) NOT NULL DEFAULT '0' COMMENT '踩数',
  `comment_count` bigint(20) NOT NULL DEFAULT '0' COMMENT '一级评论对应的二级评论数',
  `hot` bigint(20) NOT NULL DEFAULT '0' COMMENT '热度值',
  `gmt_create` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` bigint(20) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;