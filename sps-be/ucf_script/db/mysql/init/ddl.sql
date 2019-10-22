
-- drop table if EXISTS pr;
CREATE TABLE `pr` (
`ID` VARCHAR(64) NOT NULL COMMENT '主键',
    PRIMARY KEY (`ID`),
    `pr_no` VARCHAR(64) DEFAULT NULL COMMENT '申请单编号',
    `pname` VARCHAR(64) DEFAULT NULL COMMENT '采购品名',
    `pnum` VARCHAR(64) DEFAULT NULL COMMENT '采购数量',
    `price` VARCHAR(64) DEFAULT NULL COMMENT '采购单价',
    `ptime` VARCHAR(64) DEFAULT NULL COMMENT '申请时间',
    `pstute` VARCHAR(64) DEFAULT NULL COMMENT '申请状态',
        `TENANT_ID` varchar(64) DEFAULT NULL,
        `DR` int(11) DEFAULT NULL COMMENT '是否删除',
        `TS` varchar(64) DEFAULT NULL COMMENT '时间戳',
        `LAST_MODIFIED` varchar(64) DEFAULT NULL COMMENT '修改时间',
        `LAST_MODIFY_USER` varchar(64) DEFAULT NULL COMMENT '修改人',
        `CREATE_TIME` varchar(64) DEFAULT NULL COMMENT '创建时间',
        `CREATE_USER` varchar(64) DEFAULT NULL COMMENT '创建人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

alter table pr add unique(pr_no);



