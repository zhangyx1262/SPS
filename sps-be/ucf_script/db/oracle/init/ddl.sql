-- drop table pr cascade constraints;
create table pr
(
ID VARCHAR2(64) not null,
        constraint PK_pr primary key (ID),
        pr_no VARCHAR2(64) null,
        pname VARCHAR2(64) null,
        pnum VARCHAR2(64) null,
        price VARCHAR2(64) null,
        ptime VARCHAR2(64) null,
        pstute VARCHAR2(64) null,
        TENANT_ID VARCHAR2(64) NULL,
        DR NUMBER(11) NULL,
        TS VARCHAR2(64) NULL,
        LAST_MODIFIED VARCHAR2(64) NULL,
        LAST_MODIFY_USER VARCHAR2(64) NULL,
        CREATE_TIME VARCHAR2(64) NULL,
        CREATE_USER VARCHAR2(64) NULL
);
        comment on column pr.pr_no is '申请单编号';
        comment on column pr.pname is '采购品名';
        comment on column pr.pnum is '采购数量';
        comment on column pr.price is '采购单价';
        comment on column pr.ptime is '申请时间';
        comment on column pr.pstute is '申请状态';
comment on column pr.DR is '是否删除';
comment on column pr.TS is '时间戳';
comment on column pr.LAST_MODIFIED is '修改时间';
comment on column pr.LAST_MODIFY_USER is '修改人';
comment on column pr.CREATE_TIME is '创建时间';
comment on column pr.CREATE_USER is '创建人';



ALTER TABLE pr ADD CONSTRAINT C_pr_Upr_no
UNIQUE (pr_no)
ENABLE;



