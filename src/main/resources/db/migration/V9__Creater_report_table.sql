CREATE TABLE `report` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `target _id` bigint(20) DEFAULT NULL COMMENT '被举报的问题或评论id',
  `target _type` int(11) DEFAULT NULL COMMENT '类型：问题/评论',
  `repor_type` int(11) DEFAULT NULL COMMENT '举报原因',
  `reporter` bigint(20) DEFAULT NULL COMMENT '举报人id',
  `status` int(11) DEFAULT NULL COMMENT '处理状态',
  `gmt_create` bigint(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;