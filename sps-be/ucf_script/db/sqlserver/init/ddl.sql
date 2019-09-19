

CREATE TABLE [rejected] (

[ID] varchar(64)   NOT NULL ,
[TS] varchar(64)   NULL ,
[CREATE_TIME] varchar(64)   NULL ,
[CREATE_USER] varchar(64)   NULL ,
[LAST_MODIFIED] varchar(64)   NULL ,
[LAST_MODIFY_USER] varchar(64)   NULL ,

[rj_no] VARCHAR(64)   NULL ,
[qc_no] VARCHAR(64)   NULL ,
[rjstate] VARCHAR(64)   NULL ,
   PRIMARY KEY ([ID])
)
ON [PRIMARY]
GO

EXEC sp_addextendedproperty 'MS_Description',N'退货单编号','user','dbo','TABLE','rejected','COLUMN','rj_no'
GO
EXEC sp_addextendedproperty 'MS_Description',N'质检单编号','user','dbo','TABLE','rejected','COLUMN','qc_no'
GO
EXEC sp_addextendedproperty 'MS_Description',N'退货状态','user','dbo','TABLE','rejected','COLUMN','rjstate'
GO


EXEC sp_addextendedproperty 'MS_Description',N'主键 ID','user','dbo','TABLE','rejected','COLUMN','ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'乐观锁时间戳','user','dbo','TABLE','rejected','COLUMN','TS'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改时间','user','dbo','TABLE','rejected','COLUMN','LAST_MODIFIED'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改人','user','dbo','TABLE','rejected','COLUMN','LAST_MODIFY_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建时间','user','dbo','TABLE','rejected','COLUMN','CREATE_TIME'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建人','user','dbo','TABLE','rejected','COLUMN','CREATE_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'租户标识','user','dbo','TABLE','rejected','COLUMN','TENANT_ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'是否删除','user','dbo','TABLE','rejected','COLUMN','DR'
GO

ALTER TABLE [dbo].[rejected] ADD CONSTRAINT [UNIQ_RJ_NO] UNIQUE ([rj_no])
GO
ALTER TABLE [dbo].[rejected] ADD CONSTRAINT [UNIQ_QC_NO] UNIQUE ([qc_no])
GO


 


--------------------------------------------------------

