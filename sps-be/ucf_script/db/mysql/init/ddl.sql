
-- drop table if EXISTS quality;
CREATE TABLE `quality` (
`ID` VARCHAR(64) NOT NULL COMMENT '主键',
    PRIMARY KEY (`ID`),
    `qc_no` VARCHAR(64) DEFAULT NULL COMMENT '质检编号',
    `po_no` VARCHAR(64) DEFAULT NULL COMMENT '订单编号',
    `qc_state` VARCHAR(64) DEFAULT NULL COMMENT '质检状态',
        `TENANT_ID` varchar(64) DEFAULT NULL,
        `DR` int(11) DEFAULT NULL COMMENT '是否删除',
        `TS` varchar(64) DEFAULT NULL COMMENT '时间戳',
        `LAST_MODIFIED` varchar(64) DEFAULT NULL COMMENT '修改时间',
        `LAST_MODIFY_USER` varchar(64) DEFAULT NULL COMMENT '修改人',
        `CREATE_TIME` varchar(64) DEFAULT NULL COMMENT '创建时间',
        `CREATE_USER` varchar(64) DEFAULT NULL COMMENT '创建人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

alter table quality add unique(qc_no);
alter table quality add unique(po_no);



