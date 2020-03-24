CREATE TABLE `tread` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creator` bigint(20) DEFAULT NULL COMMENT '踩者',
  `tread_id` bigint(20) DEFAULT NULL COMMENT '被踩的id',
  `type` int(11) DEFAULT NULL COMMENT '类型：问题/评论',
  `gmt_create` bigint(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;