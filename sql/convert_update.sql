CREATE TABLE `dict_charge_type`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `emr_code` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '医疗系统中的代码',
  `emr_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '医疗系统中的名称',
  `hub_code` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '前置软件中的代码',
  `hub_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '前置软件中的名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '信息描述（备注）',
  `is_default` int NULL DEFAULT 1 COMMENT '是否默认值（0默认 1其他）',
  `code_status` int NULL DEFAULT 0 COMMENT '状态（0正常 1停用）',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '付费方式转码表' ROW_FORMAT = Dynamic;

INSERT INTO `dict_charge_type` VALUES (1, 'A', '军队医改', '99', '其他', NULL, 1, 0, '2025-06-25 09:12:22', NULL);
INSERT INTO `dict_charge_type` VALUES (2, 'B', '省医保', '01', '城镇职工基本医疗保险', NULL, 1, 0, '2025-06-25 09:12:22', NULL);
INSERT INTO `dict_charge_type` VALUES (3, 'C', '市医保', '01', '城镇职工基本医疗保险', NULL, 1, 0, '2025-06-25 09:12:22', NULL);
INSERT INTO `dict_charge_type` VALUES (4, 'D', '自费', '07', '全自费', NULL, 1, 0, '2025-06-25 09:12:22', NULL);
INSERT INTO `dict_charge_type` VALUES (5, 'E', '省内异地', '13', '国家补助或其它', NULL, 1, 0, '2025-06-25 09:12:22', NULL);
INSERT INTO `dict_charge_type` VALUES (6, 'F', '花溪农合', '03', '新型农村合作医疗', NULL, 1, 1, '2025-06-25 09:12:22', NULL);
INSERT INTO `dict_charge_type` VALUES (7, 'G', '小河农合', '03', '新型农村合作医疗', NULL, 1, 1, '2025-06-25 09:12:22', NULL);
INSERT INTO `dict_charge_type` VALUES (8, 'H', '轻工合医', '03', '新型农村合作医疗', NULL, 1, 1, '2025-06-25 09:12:22', NULL);
INSERT INTO `dict_charge_type` VALUES (9, 'I', '市保居民', '01', '城镇职工基本医疗保险', NULL, 1, 1, '2025-06-25 09:12:22', NULL);
INSERT INTO `dict_charge_type` VALUES (10, 'J', '医疗救助', '04', '贫困救助', NULL, 1, 0, '2025-06-25 09:12:22', NULL);
INSERT INTO `dict_charge_type` VALUES (11, 'K', '新农医', '03', '新型农村合作医疗', NULL, 1, 1, '2025-06-25 09:12:22', NULL);
INSERT INTO `dict_charge_type` VALUES (12, 'L', '省级农合', '03', '新型农村合作医疗', NULL, 1, 0, '2025-06-25 09:12:22', NULL);
INSERT INTO `dict_charge_type` VALUES (13, 'M', '优抚', '13', '国家补助或其它', NULL, 1, 0, '2025-06-25 09:12:22', NULL);
INSERT INTO `dict_charge_type` VALUES (14, 'N', '市伤保', '13', '国家补助或其它', NULL, 1, 0, '2025-06-25 09:12:22', NULL);
INSERT INTO `dict_charge_type` VALUES (15, 'O', '军改保障', '13', '国家补助或其它', NULL, 1, 0, '2025-06-25 09:12:22', NULL);

