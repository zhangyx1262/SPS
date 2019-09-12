
-- drop table if EXISTS rl;
CREATE TABLE `rl` (
`ID` VARCHAR(64) NOT NULL COMMENT '主键',
    PRIMARY KEY (`ID`),
    `rl_no` VARCHAR(64) DEFAULT NULL COMMENT '审核编号',
    `pr_no` VARCHAR(64) DEFAULT NULL COMMENT '申请编号',
    `rstute` VARCHAR(64) DEFAULT NULL COMMENT '审核状态',
        `TENANT_ID` varchar(64) DEFAULT NULL,
        `DR` int(11) DEFAULT NULL COMMENT '是否删除',
        `TS` varchar(64) DEFAULT NULL COMMENT '时间戳',
        `LAST_MODIFIED` varchar(64) DEFAULT NULL COMMENT '修改时间',
        `LAST_MODIFY_USER` varchar(64) DEFAULT NULL COMMENT '修改人',
        `CREATE_TIME` varchar(64) DEFAULT NULL COMMENT '创建时间',
        `CREATE_USER` varchar(64) DEFAULT NULL COMMENT '创建人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

alter table rl add unique(rl_no);
alter table rl add unique(pr_no);



