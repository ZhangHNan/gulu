CREATE TABLE `question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '帖子标题',
  `description` text COLLATE utf8_unicode_ci COMMENT '帖子内容文本',
  `tag` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '帖子标签（分类）',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `view_count` bigint(20) NOT NULL DEFAULT '0' COMMENT '浏览量',
  `like_count` bigint(20) NOT NULL DEFAULT '0' COMMENT '获赞数',
  `tread_count` bigint(20) NOT NULL DEFAULT '0' COMMENT '踩数',
  `comment_count` bigint(20) NOT NULL DEFAULT '0' COMMENT '评论数',
  `hot` bigint(20) NOT NULL DEFAULT '0' COMMENT '热度值',
  `gmt_create` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` bigint(20) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;