-- drop table req_order cascade constraints;
create table req_order
(
ID VARCHAR2(64) not null,
        constraint PK_req_order primary key (ID),
        ro_no VARCHAR2(64) null,
        rl_no VARCHAR2(64) null,
        postate VARCHAR2(64) null,
        TENANT_ID VARCHAR2(64) NULL,
        DR NUMBER(11) NULL,
        TS VARCHAR2(64) NULL,
        LAST_MODIFIED VARCHAR2(64) NULL,
        LAST_MODIFY_USER VARCHAR2(64) NULL,
        CREATE_TIME VARCHAR2(64) NULL,
        CREATE_USER VARCHAR2(64) NULL
);
        comment on column req_order.ro_no is '订单编号';
        comment on column req_order.rl_no is '审核编号';
        comment on column req_order.postate is '采购状态';
comment on column req_order.DR is '是否删除';
comment on column req_order.TS is '时间戳';
comment on column req_order.LAST_MODIFIED is '修改时间';
comment on column req_order.LAST_MODIFY_USER is '修改人';
comment on column req_order.CREATE_TIME is '创建时间';
comment on column req_order.CREATE_USER is '创建人';



ALTER TABLE req_order ADD CONSTRAINT C_req_order_Uro_no
UNIQUE (ro_no)
ENABLE;
ALTER TABLE req_order ADD CONSTRAINT C_req_order_Url_no
UNIQUE (rl_no)
ENABLE;



