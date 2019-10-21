

CREATE TABLE [pr] (

[ID] varchar(64)   NOT NULL ,
[TS] varchar(64)   NULL ,
[CREATE_TIME] varchar(64)   NULL ,
[CREATE_USER] varchar(64)   NULL ,
[LAST_MODIFIED] varchar(64)   NULL ,
[LAST_MODIFY_USER] varchar(64)   NULL ,

[pr_no] VARCHAR(64)   NULL ,
[pname] VARCHAR(64)   NULL ,
[pnum] VARCHAR(64)   NULL ,
[price] VARCHAR(64)   NULL ,
[ptime] VARCHAR(64)   NULL ,
[pstute] VARCHAR(64)   NULL ,
   PRIMARY KEY ([ID])
)
ON [PRIMARY]
GO

EXEC sp_addextendedproperty 'MS_Description',N'申请单编号','user','dbo','TABLE','pr','COLUMN','pr_no'
GO
EXEC sp_addextendedproperty 'MS_Description',N'采购品名','user','dbo','TABLE','pr','COLUMN','pname'
GO
EXEC sp_addextendedproperty 'MS_Description',N'采购数量','user','dbo','TABLE','pr','COLUMN','pnum'
GO
EXEC sp_addextendedproperty 'MS_Description',N'采购单价','user','dbo','TABLE','pr','COLUMN','price'
GO
EXEC sp_addextendedproperty 'MS_Description',N'申请时间','user','dbo','TABLE','pr','COLUMN','ptime'
GO
EXEC sp_addextendedproperty 'MS_Description',N'申请状态','user','dbo','TABLE','pr','COLUMN','pstute'
GO


EXEC sp_addextendedproperty 'MS_Description',N'主键 ID','user','dbo','TABLE','pr','COLUMN','ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'乐观锁时间戳','user','dbo','TABLE','pr','COLUMN','TS'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改时间','user','dbo','TABLE','pr','COLUMN','LAST_MODIFIED'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改人','user','dbo','TABLE','pr','COLUMN','LAST_MODIFY_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建时间','user','dbo','TABLE','pr','COLUMN','CREATE_TIME'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建人','user','dbo','TABLE','pr','COLUMN','CREATE_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'租户标识','user','dbo','TABLE','pr','COLUMN','TENANT_ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'是否删除','user','dbo','TABLE','pr','COLUMN','DR'
GO

ALTER TABLE [dbo].[pr] ADD CONSTRAINT [UNIQ_PR_NO] UNIQUE ([pr_no])
GO


 


--------------------------------------------------------

