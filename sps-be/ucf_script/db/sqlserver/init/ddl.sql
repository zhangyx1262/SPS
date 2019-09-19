

CREATE TABLE [req_order] (

[ID] varchar(64)   NOT NULL ,
[TS] varchar(64)   NULL ,
[CREATE_TIME] varchar(64)   NULL ,
[CREATE_USER] varchar(64)   NULL ,
[LAST_MODIFIED] varchar(64)   NULL ,
[LAST_MODIFY_USER] varchar(64)   NULL ,

[ro_no] VARCHAR(64)   NULL ,
[rl_no] VARCHAR(64)   NULL ,
[postate] VARCHAR(64)   NULL ,
   PRIMARY KEY ([ID])
)
ON [PRIMARY]
GO

EXEC sp_addextendedproperty 'MS_Description',N'订单编号','user','dbo','TABLE','req_order','COLUMN','ro_no'
GO
EXEC sp_addextendedproperty 'MS_Description',N'审核编号','user','dbo','TABLE','req_order','COLUMN','rl_no'
GO
EXEC sp_addextendedproperty 'MS_Description',N'采购状态','user','dbo','TABLE','req_order','COLUMN','postate'
GO


EXEC sp_addextendedproperty 'MS_Description',N'主键 ID','user','dbo','TABLE','req_order','COLUMN','ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'乐观锁时间戳','user','dbo','TABLE','req_order','COLUMN','TS'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改时间','user','dbo','TABLE','req_order','COLUMN','LAST_MODIFIED'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改人','user','dbo','TABLE','req_order','COLUMN','LAST_MODIFY_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建时间','user','dbo','TABLE','req_order','COLUMN','CREATE_TIME'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建人','user','dbo','TABLE','req_order','COLUMN','CREATE_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'租户标识','user','dbo','TABLE','req_order','COLUMN','TENANT_ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'是否删除','user','dbo','TABLE','req_order','COLUMN','DR'
GO

ALTER TABLE [dbo].[req_order] ADD CONSTRAINT [UNIQ_RO_NO] UNIQUE ([ro_no])
GO
ALTER TABLE [dbo].[req_order] ADD CONSTRAINT [UNIQ_RL_NO] UNIQUE ([rl_no])
GO


 


--------------------------------------------------------

