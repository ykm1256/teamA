CREATE TABLE `admin` (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `pw` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cblike` (
  `cbl_nick` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cbl_num` int NOT NULL,
  PRIMARY KEY (`cbl_nick`,`cbl_num`) USING BTREE,
  KEY `FK__pboard` (`cbl_num`) USING BTREE,
  CONSTRAINT `cblike_ibfk_2` FOREIGN KEY (`cbl_nick`) REFERENCES `trainer` (`t_nick`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cblike_ibfk_3` FOREIGN KEY (`cbl_nick`) REFERENCES `user` (`nick`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_cblike_cboard` FOREIGN KEY (`cbl_num`) REFERENCES `cboard` (`cb_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

CREATE TABLE `cboard` (
  `cb_num` int NOT NULL AUTO_INCREMENT,
  `cb_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cb_writer` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cb_head` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cb_pw` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cb_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `cb_hit` int DEFAULT NULL,
  `cb_like` int DEFAULT NULL,
  `cb_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `cb_ref` int DEFAULT NULL,
  `cb_depth` int DEFAULT NULL,
  `cb_pos` int DEFAULT NULL,
  PRIMARY KEY (`cb_num`) USING BTREE,
  KEY `FK_cboard_trainer` (`cb_writer`) USING BTREE,
  CONSTRAINT `FK_cboard_trainer` FOREIGN KEY (`cb_writer`) REFERENCES `trainer` (`t_nick`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_cboard_user` FOREIGN KEY (`cb_writer`) REFERENCES `user` (`nick`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `ccomment` (
  `cb_cnum` int NOT NULL AUTO_INCREMENT,
  `cb_num` int DEFAULT NULL,
  `cb_cnick` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cb_ccontent` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `cb_cdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`cb_cnum`) USING BTREE,
  KEY `FK_comment_mvideo` (`cb_num`) USING BTREE,
  KEY `FK_comment_user` (`cb_cnick`) USING BTREE,
  CONSTRAINT `FK_ccomment_cboard` FOREIGN KEY (`cb_num`) REFERENCES `cboard` (`cb_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_ccomment_trainer` FOREIGN KEY (`cb_cnick`) REFERENCES `trainer` (`t_nick`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_comment_user` FOREIGN KEY (`cb_cnick`) REFERENCES `user` (`nick`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `headcount` (
  `h_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `h_DATE` date NOT NULL,
  `INTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `OUTTIME` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`h_ID`,`h_DATE`) USING BTREE,
  KEY `FK_headcount_user` (`h_ID`) USING BTREE,
  CONSTRAINT `FK_headcount_user` FOREIGN KEY (`h_ID`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `history` (
  `hid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `paydate` varchar(50) NOT NULL,
  `price` int DEFAULT NULL,
  `hcount` int DEFAULT NULL,
  PRIMARY KEY (`hid`) USING BTREE,
  CONSTRAINT `FK_userhistory_user` FOREIGN KEY (`hid`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `inbody` (
  `I_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `I_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MUSCLE` float DEFAULT NULL,
  `FAT` float DEFAULT NULL,
  `HEIGHT` float DEFAULT NULL,
  `WEIGHT` float DEFAULT NULL,
  PRIMARY KEY (`I_ID`,`I_DATE`) USING BTREE,
  KEY `FK_inbody_user` (`I_ID`) USING BTREE,
  CONSTRAINT `FK_inbody_user` FOREIGN KEY (`I_ID`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `pblike` (
  `pbl_nick` varchar(50) NOT NULL,
  `pbl_num` int NOT NULL,
  PRIMARY KEY (`pbl_nick`,`pbl_num`),
  KEY `FK__pboard` (`pbl_num`),
  CONSTRAINT `FK__pboard` FOREIGN KEY (`pbl_num`) REFERENCES `pboard` (`pb_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK__trainer` FOREIGN KEY (`pbl_nick`) REFERENCES `trainer` (`t_nick`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK__user` FOREIGN KEY (`pbl_nick`) REFERENCES `user` (`nick`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `pboard` (
  `pb_num` int NOT NULL AUTO_INCREMENT,
  `pb_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `pb_writer` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `pb_head` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `pb_pw` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `pb_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `pb_hit` int DEFAULT NULL,
  `pb_like` int DEFAULT NULL,
  `pb_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `pb_photo` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`pb_num`) USING BTREE,
  KEY `FK_cboard_trainer` (`pb_writer`) USING BTREE,
  CONSTRAINT `pboard_ibfk_1` FOREIGN KEY (`pb_writer`) REFERENCES `trainer` (`t_nick`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pboard_ibfk_2` FOREIGN KEY (`pb_writer`) REFERENCES `user` (`nick`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

CREATE TABLE `pcomment` (
  `pb_cnum` int NOT NULL AUTO_INCREMENT,
  `pb_cnick` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `pb_cbnum` int DEFAULT NULL,
  `pb_cdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `pb_ccontent` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  PRIMARY KEY (`pb_cnum`) USING BTREE,
  KEY `FK_comment_user` (`pb_cnick`) USING BTREE,
  KEY `FK_pcomment_pboard` (`pb_cbnum`) USING BTREE,
  CONSTRAINT `FK_pcomment_pboard` FOREIGN KEY (`pb_cbnum`) REFERENCES `pboard` (`pb_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_pcomment_trainer` FOREIGN KEY (`pb_cnick`) REFERENCES `trainer` (`t_nick`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_pcomment_user` FOREIGN KEY (`pb_cnick`) REFERENCES `user` (`nick`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

CREATE TABLE `program` (
  `p_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `p_date` date NOT NULL,
  `p_mention` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `p_part` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`p_id`,`p_date`) USING BTREE,
  KEY `FK_program_user` (`p_id`) USING BTREE,
  CONSTRAINT `FK_program_user` FOREIGN KEY (`p_id`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `qboard` (
  `qb_num` int NOT NULL AUTO_INCREMENT,
  `qb_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `qb_writer` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `qb_head` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `qb_pw` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `qb_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `qb_hit` int DEFAULT NULL,
  `qb_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `qb_ref` int DEFAULT NULL,
  `qb_depth` int DEFAULT NULL,
  `qb_pos` int DEFAULT NULL,
  PRIMARY KEY (`qb_num`) USING BTREE,
  KEY `FK_cboard_trainer` (`qb_writer`) USING BTREE,
  CONSTRAINT `qboard_ibfk_1` FOREIGN KEY (`qb_writer`) REFERENCES `trainer` (`t_nick`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `qboard_ibfk_2` FOREIGN KEY (`qb_writer`) REFERENCES `user` (`nick`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

CREATE TABLE `qcomment` (
  `qb_cnum` int NOT NULL AUTO_INCREMENT,
  `qb_num` int DEFAULT NULL,
  `qb_cnick` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `qb_ccontent` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `qb_cdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`qb_cnum`) USING BTREE,
  KEY `FK_comment_user` (`qb_cnick`) USING BTREE,
  KEY `FK_comment_mvideo` (`qb_num`) USING BTREE,
  CONSTRAINT `FK_qcomment_qboard` FOREIGN KEY (`qb_num`) REFERENCES `qboard` (`qb_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_qcomment_trainer` FOREIGN KEY (`qb_cnick`) REFERENCES `trainer` (`t_nick`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `qcomment_ibfk_2` FOREIGN KEY (`qb_cnick`) REFERENCES `user` (`nick`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

CREATE TABLE `schedule` (
  `s_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `s_date` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `s_time` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`s_id`,`s_date`) USING BTREE,
  KEY `FK_schedule_user` (`s_id`) USING BTREE,
  CONSTRAINT `FK_schedule_user` FOREIGN KEY (`s_id`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `trainer` (
  `T_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `t_pw` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `t_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `t_gender` int NOT NULL,
  `t_email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `t_birth` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `t_address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `t_nick` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`T_ID`) USING BTREE,
  UNIQUE KEY `tnick` (`t_nick`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user` (
  `ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `PW` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `GENDER` int NOT NULL,
  `EMAIL` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `BIRTH` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ADDRESS` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `QR` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SIGNDATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `nick` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `STARTDATE` date DEFAULT NULL,
  `ENDDATE` date DEFAULT NULL,
  `PTCOUNT` int DEFAULT NULL,
  `TID` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `EMAIL` (`EMAIL`),
  UNIQUE KEY `nick` (`nick`),
  KEY `FK_user_trainer` (`TID`),
  CONSTRAINT `FK_user_trainer` FOREIGN KEY (`TID`) REFERENCES `trainer` (`T_ID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
