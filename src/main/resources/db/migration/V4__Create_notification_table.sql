CREATE TABLE `notification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `notifier` bigint(20) DEFAULT NULL COMMENT '通知的发起人id',
  `receiver` bigint(20) DEFAULT NULL COMMENT '通知的接收者id',
  `outer_id` bigint(20) DEFAULT NULL COMMENT '通知的本体：问题？评论',
  `type` int(11) DEFAULT NULL COMMENT '通知的类型',
  `status` int(11) DEFAULT NULL COMMENT '通知的状态0未读1已读',
  `gmt_create` bigint(20) DEFAULT NULL COMMENT '通知的创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;