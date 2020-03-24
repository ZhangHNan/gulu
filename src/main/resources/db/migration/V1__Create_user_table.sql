CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) DEFAULT NULL COMMENT 'github账户，唯一值。',
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '名称',
  `token` varchar(36) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '登录令牌',
  `avatar_url` varchar(512) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户头像',
  `bio` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户简介',
  `phone` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机号',
  `email` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `password` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '登录密码',
  `like_count` bigint(20) NOT NULL DEFAULT '0' COMMENT '获赞数',
  `fans_count` bigint(20) NOT NULL DEFAULT '0' COMMENT '粉丝数',
  `hot` bigint(20) NOT NULL DEFAULT '0' COMMENT '热度值',
  `power` int(11) NOT NULL DEFAULT '0' COMMENT '权限',
  `gmt_create` bigint(20) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(20) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;