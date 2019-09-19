-- drop table rejected cascade constraints;
create table rejected
(
ID VARCHAR2(64) not null,
        constraint PK_rejected primary key (ID),
        rj_no VARCHAR2(64) null,
        qc_no VARCHAR2(64) null,
        rjstate VARCHAR2(64) null,
        TENANT_ID VARCHAR2(64) NULL,
        DR NUMBER(11) NULL,
        TS VARCHAR2(64) NULL,
        LAST_MODIFIED VARCHAR2(64) NULL,
        LAST_MODIFY_USER VARCHAR2(64) NULL,
        CREATE_TIME VARCHAR2(64) NULL,
        CREATE_USER VARCHAR2(64) NULL
);
        comment on column rejected.rj_no is '退货单编号';
        comment on column rejected.qc_no is '质检单编号';
        comment on column rejected.rjstate is '退货状态';
comment on column rejected.DR is '是否删除';
comment on column rejected.TS is '时间戳';
comment on column rejected.LAST_MODIFIED is '修改时间';
comment on column rejected.LAST_MODIFY_USER is '修改人';
comment on column rejected.CREATE_TIME is '创建时间';
comment on column rejected.CREATE_USER is '创建人';



ALTER TABLE rejected ADD CONSTRAINT C_rejected_Urj_no
UNIQUE (rj_no)
ENABLE;
ALTER TABLE rejected ADD CONSTRAINT C_rejected_Uqc_no
UNIQUE (qc_no)
ENABLE;



