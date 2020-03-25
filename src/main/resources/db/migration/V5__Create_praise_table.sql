CREATE TABLE `praise` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creator` bigint(20) DEFAULT NULL COMMENT '点赞者id',
  `like_id` bigint(20) DEFAULT NULL COMMENT '点赞的问题/评论id',
  `type` int(11) DEFAULT NULL COMMENT '类型：0表示问题/1表评论',
  `gmt_create` bigint(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;