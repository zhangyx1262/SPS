-- drop table quality cascade constraints;
create table quality
(
ID VARCHAR2(64) not null,
        constraint PK_quality primary key (ID),
        qc_no VARCHAR2(64) null,
        po_no VARCHAR2(64) null,
        qc_state VARCHAR2(64) null,
        TENANT_ID VARCHAR2(64) NULL,
        DR NUMBER(11) NULL,
        TS VARCHAR2(64) NULL,
        LAST_MODIFIED VARCHAR2(64) NULL,
        LAST_MODIFY_USER VARCHAR2(64) NULL,
        CREATE_TIME VARCHAR2(64) NULL,
        CREATE_USER VARCHAR2(64) NULL
);
        comment on column quality.qc_no is '质检编号';
        comment on column quality.po_no is '订单编号';
        comment on column quality.qc_state is '质检状态';
comment on column quality.DR is '是否删除';
comment on column quality.TS is '时间戳';
comment on column quality.LAST_MODIFIED is '修改时间';
comment on column quality.LAST_MODIFY_USER is '修改人';
comment on column quality.CREATE_TIME is '创建时间';
comment on column quality.CREATE_USER is '创建人';



ALTER TABLE quality ADD CONSTRAINT C_quality_Uqc_no
UNIQUE (qc_no)
ENABLE;
ALTER TABLE quality ADD CONSTRAINT C_quality_Upo_no
UNIQUE (po_no)
ENABLE;



