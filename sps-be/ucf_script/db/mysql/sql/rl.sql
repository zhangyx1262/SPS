
-- drop table if EXISTS rl;
CREATE TABLE `rl` (
`ID` VARCHAR(64) NOT NULL COMMENT '����',
    PRIMARY KEY (`ID`),
    `rl_no` VARCHAR(64) DEFAULT NULL COMMENT '��˱��',
    `pr_no` VARCHAR(64) DEFAULT NULL COMMENT '������',
    `rstute` VARCHAR(64) DEFAULT NULL COMMENT '���״̬',
        `TENANT_ID` varchar(64) DEFAULT NULL,
        `DR` int(11) DEFAULT NULL COMMENT '�Ƿ�ɾ��',
        `TS` varchar(64) DEFAULT NULL COMMENT 'ʱ���',
        `LAST_MODIFIED` varchar(64) DEFAULT NULL COMMENT '�޸�ʱ��',
        `LAST_MODIFY_USER` varchar(64) DEFAULT NULL COMMENT '�޸���',
        `CREATE_TIME` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
        `CREATE_USER` varchar(64) DEFAULT NULL COMMENT '������'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

alter table rl add unique(rl_no);
alter table rl add unique(pr_no);



