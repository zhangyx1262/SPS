

CREATE TABLE [warehousing] (

[ID] varchar(64)   NOT NULL ,
[TS] varchar(64)   NULL ,
[CREATE_TIME] varchar(64)   NULL ,
[CREATE_USER] varchar(64)   NULL ,
[LAST_MODIFIED] varchar(64)   NULL ,
[LAST_MODIFY_USER] varchar(64)   NULL ,

[wh_no] VARCHAR(64)   NULL ,
[qc_no] VARCHAR(64)   NULL ,
[whstate] VARCHAR(64)   NULL ,
   PRIMARY KEY ([ID])
)
ON [PRIMARY]
GO

EXEC sp_addextendedproperty 'MS_Description',N'入库编号','user','dbo','TABLE','warehousing','COLUMN','wh_no'
GO
EXEC sp_addextendedproperty 'MS_Description',N'质检编号','user','dbo','TABLE','warehousing','COLUMN','qc_no'
GO
EXEC sp_addextendedproperty 'MS_Description',N'入库状态','user','dbo','TABLE','warehousing','COLUMN','whstate'
GO


EXEC sp_addextendedproperty 'MS_Description',N'主键 ID','user','dbo','TABLE','warehousing','COLUMN','ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'乐观锁时间戳','user','dbo','TABLE','warehousing','COLUMN','TS'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改时间','user','dbo','TABLE','warehousing','COLUMN','LAST_MODIFIED'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改人','user','dbo','TABLE','warehousing','COLUMN','LAST_MODIFY_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建时间','user','dbo','TABLE','warehousing','COLUMN','CREATE_TIME'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建人','user','dbo','TABLE','warehousing','COLUMN','CREATE_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'租户标识','user','dbo','TABLE','warehousing','COLUMN','TENANT_ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'是否删除','user','dbo','TABLE','warehousing','COLUMN','DR'
GO

ALTER TABLE [dbo].[warehousing] ADD CONSTRAINT [UNIQ_WH_NO] UNIQUE ([wh_no])
GO
ALTER TABLE [dbo].[warehousing] ADD CONSTRAINT [UNIQ_QC_NO] UNIQUE ([qc_no])
GO


 


--------------------------------------------------------

