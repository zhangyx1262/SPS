
-- drop table if EXISTS req_order;
CREATE TABLE `req_order` (
`ID` VARCHAR(64) NOT NULL COMMENT '主键',
    PRIMARY KEY (`ID`),
    `ro_no` VARCHAR(64) DEFAULT NULL COMMENT '订单编号',
    `rl_no` VARCHAR(64) DEFAULT NULL COMMENT '审核编号',
    `postate` VARCHAR(64) DEFAULT NULL COMMENT '采购状态',
        `TENANT_ID` varchar(64) DEFAULT NULL,
        `DR` int(11) DEFAULT NULL COMMENT '是否删除',
        `TS` varchar(64) DEFAULT NULL COMMENT '时间戳',
        `LAST_MODIFIED` varchar(64) DEFAULT NULL COMMENT '修改时间',
        `LAST_MODIFY_USER` varchar(64) DEFAULT NULL COMMENT '修改人',
        `CREATE_TIME` varchar(64) DEFAULT NULL COMMENT '创建时间',
        `CREATE_USER` varchar(64) DEFAULT NULL COMMENT '创建人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

alter table req_order add unique(ro_no);
alter table req_order add unique(rl_no);



