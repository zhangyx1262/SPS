
-- drop table if EXISTS pr;
CREATE TABLE `pr` (
`ID` VARCHAR(64) NOT NULL COMMENT '����',
    PRIMARY KEY (`ID`),
    `pr_no` VARCHAR(64) DEFAULT NULL COMMENT '���뵥���',
    `pname` VARCHAR(64) DEFAULT NULL COMMENT '�ɹ�Ʒ��',
    `pnum` VARCHAR(64) DEFAULT NULL COMMENT '�ɹ�����',
    `price` VARCHAR(64) DEFAULT NULL COMMENT '�ɹ�����',
    `ptime` VARCHAR(64) DEFAULT NULL COMMENT '����ʱ��',
    `pstute` VARCHAR(64) DEFAULT NULL COMMENT '����״̬',
        `TENANT_ID` varchar(64) DEFAULT NULL,
        `DR` int(11) DEFAULT NULL COMMENT '�Ƿ�ɾ��',
        `TS` varchar(64) DEFAULT NULL COMMENT 'ʱ���',
        `LAST_MODIFIED` varchar(64) DEFAULT NULL COMMENT '�޸�ʱ��',
        `LAST_MODIFY_USER` varchar(64) DEFAULT NULL COMMENT '�޸���',
        `CREATE_TIME` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
        `CREATE_USER` varchar(64) DEFAULT NULL COMMENT '������'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

alter table pr add unique(pr_no);



