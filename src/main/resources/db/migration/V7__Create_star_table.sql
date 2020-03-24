CREATE TABLE `star` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `collector` bigint(20) DEFAULT NULL COMMENT '收藏者',
  `star_id` bigint(20) DEFAULT NULL COMMENT '收藏的问题id',
  `gmt_create` bigint(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;