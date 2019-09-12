

CREATE TABLE [rl] (

[ID] varchar(64)   NOT NULL ,
[TS] varchar(64)   NULL ,
[CREATE_TIME] varchar(64)   NULL ,
[CREATE_USER] varchar(64)   NULL ,
[LAST_MODIFIED] varchar(64)   NULL ,
[LAST_MODIFY_USER] varchar(64)   NULL ,

[rl_no] VARCHAR(64)   NULL ,
[pr_no] VARCHAR(64)   NULL ,
[rstute] VARCHAR(64)   NULL ,
   PRIMARY KEY ([ID])
)
ON [PRIMARY]
GO

EXEC sp_addextendedproperty 'MS_Description',N'审核编号','user','dbo','TABLE','rl','COLUMN','rl_no'
GO
EXEC sp_addextendedproperty 'MS_Description',N'申请编号','user','dbo','TABLE','rl','COLUMN','pr_no'
GO
EXEC sp_addextendedproperty 'MS_Description',N'审核状态','user','dbo','TABLE','rl','COLUMN','rstute'
GO


EXEC sp_addextendedproperty 'MS_Description',N'主键 ID','user','dbo','TABLE','rl','COLUMN','ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'乐观锁时间戳','user','dbo','TABLE','rl','COLUMN','TS'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改时间','user','dbo','TABLE','rl','COLUMN','LAST_MODIFIED'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改人','user','dbo','TABLE','rl','COLUMN','LAST_MODIFY_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建时间','user','dbo','TABLE','rl','COLUMN','CREATE_TIME'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建人','user','dbo','TABLE','rl','COLUMN','CREATE_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'租户标识','user','dbo','TABLE','rl','COLUMN','TENANT_ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'是否删除','user','dbo','TABLE','rl','COLUMN','DR'
GO

ALTER TABLE [dbo].[rl] ADD CONSTRAINT [UNIQ_RL_NO] UNIQUE ([rl_no])
GO
ALTER TABLE [dbo].[rl] ADD CONSTRAINT [UNIQ_PR_NO] UNIQUE ([pr_no])
GO


 


--------------------------------------------------------

