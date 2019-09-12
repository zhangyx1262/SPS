-- drop table rl cascade constraints;
create table rl
(
ID VARCHAR2(64) not null,
        constraint PK_rl primary key (ID),
        rl_no VARCHAR2(64) null,
        pr_no VARCHAR2(64) null,
        rstute VARCHAR2(64) null,
        TENANT_ID VARCHAR2(64) NULL,
        DR NUMBER(11) NULL,
        TS VARCHAR2(64) NULL,
        LAST_MODIFIED VARCHAR2(64) NULL,
        LAST_MODIFY_USER VARCHAR2(64) NULL,
        CREATE_TIME VARCHAR2(64) NULL,
        CREATE_USER VARCHAR2(64) NULL
);
        comment on column rl.rl_no is '审核编号';
        comment on column rl.pr_no is '申请编号';
        comment on column rl.rstute is '审核状态';
comment on column rl.DR is '是否删除';
comment on column rl.TS is '时间戳';
comment on column rl.LAST_MODIFIED is '修改时间';
comment on column rl.LAST_MODIFY_USER is '修改人';
comment on column rl.CREATE_TIME is '创建时间';
comment on column rl.CREATE_USER is '创建人';



ALTER TABLE rl ADD CONSTRAINT C_rl_Url_no
UNIQUE (rl_no)
ENABLE;
ALTER TABLE rl ADD CONSTRAINT C_rl_Upr_no
UNIQUE (pr_no)
ENABLE;



