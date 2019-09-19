-- drop table warehousing cascade constraints;
create table warehousing
(
ID VARCHAR2(64) not null,
        constraint PK_warehousing primary key (ID),
        wh_no VARCHAR2(64) null,
        qc_no VARCHAR2(64) null,
        whstate VARCHAR2(64) null,
        TENANT_ID VARCHAR2(64) NULL,
        DR NUMBER(11) NULL,
        TS VARCHAR2(64) NULL,
        LAST_MODIFIED VARCHAR2(64) NULL,
        LAST_MODIFY_USER VARCHAR2(64) NULL,
        CREATE_TIME VARCHAR2(64) NULL,
        CREATE_USER VARCHAR2(64) NULL
);
        comment on column warehousing.wh_no is '入库编号';
        comment on column warehousing.qc_no is '质检编号';
        comment on column warehousing.whstate is '入库状态';
comment on column warehousing.DR is '是否删除';
comment on column warehousing.TS is '时间戳';
comment on column warehousing.LAST_MODIFIED is '修改时间';
comment on column warehousing.LAST_MODIFY_USER is '修改人';
comment on column warehousing.CREATE_TIME is '创建时间';
comment on column warehousing.CREATE_USER is '创建人';



ALTER TABLE warehousing ADD CONSTRAINT C_warehousing_Uwh_no
UNIQUE (wh_no)
ENABLE;
ALTER TABLE warehousing ADD CONSTRAINT C_warehousing_Uqc_no
UNIQUE (qc_no)
ENABLE;



