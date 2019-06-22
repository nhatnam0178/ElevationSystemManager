USE [master]
GO

CREATE DATABASE [ElevationSystemManager]

USE [ElevationSystemManager]
GO

CREATE TABLE [dbo].[ACCOUNT](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[USERNAME] [varchar](100) NOT NULL,
	[PASSWORD] [varchar](100) NOT NULL,
	[NAME] [nvarchar](250) NULL,
	[GENDER] [bit] NULL,
	[EMAIL] [varchar](250) NULL,
	[PHONE] [varchar](12) NULL,
	[ADDRESS] [varchar](250) NULL,
	[ROLE_ID] [int] NULL,
	[DEPARTMENT_ID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CLIENT]    Script Date: 6/20/2019 10:42:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CLIENT](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[NAME] [varchar](250) NULL,
	[PHONE] [varchar](12) NULL,
	[ADDRESS] [varchar](250) NULL,
	[COMPANY_NAME] [varchar](250) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[COMPLAIN]    Script Date: 6/20/2019 10:42:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[COMPLAIN](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ORDER_ID] [int] NOT NULL,
	[ACCOUNT_ID] [int] NOT NULL,
	[IS_CHARGEABLE] [bit] NULL,
	[PROBLEM] [varchar](250) NULL,
	[DATE_COMPLAIN] [date] NULL,
	[STATUS_ID] [int] NOT NULL,
	[TECHNICIAN_PERSON] [varchar](250) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DEPARTMENT]    Script Date: 6/20/2019 10:42:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DEPARTMENT](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[NAME] [varchar](250) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ORDER_DETAIL]    Script Date: 6/20/2019 10:42:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ORDER_DETAIL](
	[ORDERS_ID] [int] NOT NULL,
	[PRODUCT_ID] [int] NOT NULL,
	[NUM_OF_SYSTEM_INSTALLED] [int] NULL,
	[PRICE] [decimal](10, 1) NULL,
	[WARRANTY_PERIOD] [int] NULL,
	[WARRANTY_EXPIRE_DATE] [date] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ORDERS]    Script Date: 6/20/2019 10:42:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ORDERS](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[CLIENT_ID] [int] NOT NULL,
	[ACCOUNT_ID] [int] NOT NULL,
	[TOTAL_PRICE] [decimal](10, 1) NULL,
	[DATE_OF_ORDER] [date] NULL,
	[DATE_OF_SYSTEM_INSTALLED] [date] NULL,
	[DATE_OF_COMPLETE] [date] NULL,
	[STATUS_ID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PRODUCT_ELEVATION]    Script Date: 6/20/2019 10:42:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PRODUCT_ELEVATION](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[NAME] [varchar](250) NULL,
	[TYPE] [varchar](250) NULL,
	[PRICE] [decimal](10, 1) NULL,
	[DATE_OF_ORDER] [date] NULL,
	[WARRANTY] [int] NULL,
	[WARRANTY_EXPIRE_DATE] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ROLE]    Script Date: 6/20/2019 10:42:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ROLE](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[NAME] [varchar](250) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[STATUS_COMPLAIN]    Script Date: 6/20/2019 10:42:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[STATUS_COMPLAIN](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[NAME] [varchar](250) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[STATUS_ORDER]    Script Date: 6/20/2019 10:42:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[STATUS_ORDER](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[NAME] [varchar](250) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ACCOUNT]  WITH CHECK ADD  CONSTRAINT [FK_ACCOUNT_DEPARTMENT] FOREIGN KEY([DEPARTMENT_ID])
REFERENCES [dbo].[DEPARTMENT] ([ID])
GO
ALTER TABLE [dbo].[ACCOUNT] CHECK CONSTRAINT [FK_ACCOUNT_DEPARTMENT]
GO
ALTER TABLE [dbo].[ACCOUNT]  WITH CHECK ADD  CONSTRAINT [FK_ACCOUNT_ROLE] FOREIGN KEY([ROLE_ID])
REFERENCES [dbo].[ROLE] ([ID])
GO
ALTER TABLE [dbo].[ACCOUNT] CHECK CONSTRAINT [FK_ACCOUNT_ROLE]
GO
ALTER TABLE [dbo].[COMPLAIN]  WITH CHECK ADD  CONSTRAINT [FK_COMPLAIN_ACCOUNT] FOREIGN KEY([ACCOUNT_ID])
REFERENCES [dbo].[ACCOUNT] ([ID])
GO
ALTER TABLE [dbo].[COMPLAIN] CHECK CONSTRAINT [FK_COMPLAIN_ACCOUNT]
GO
ALTER TABLE [dbo].[COMPLAIN]  WITH CHECK ADD  CONSTRAINT [FK_COMPLAIN_ORDERS] FOREIGN KEY([ORDER_ID])
REFERENCES [dbo].[ORDERS] ([ID])
GO
ALTER TABLE [dbo].[COMPLAIN] CHECK CONSTRAINT [FK_COMPLAIN_ORDERS]
GO
ALTER TABLE [dbo].[COMPLAIN]  WITH CHECK ADD  CONSTRAINT [FK_COMPLAIN_STATUS_COMPLAIN] FOREIGN KEY([STATUS_ID])
REFERENCES [dbo].[STATUS_COMPLAIN] ([ID])
GO
ALTER TABLE [dbo].[COMPLAIN] CHECK CONSTRAINT [FK_COMPLAIN_STATUS_COMPLAIN]
GO
ALTER TABLE [dbo].[ORDER_DETAIL]  WITH CHECK ADD  CONSTRAINT [FK_ORDER_DETAIL_ORDERS] FOREIGN KEY([ORDERS_ID])
REFERENCES [dbo].[ORDERS] ([ID])
GO
ALTER TABLE [dbo].[ORDER_DETAIL] CHECK CONSTRAINT [FK_ORDER_DETAIL_ORDERS]
GO
ALTER TABLE [dbo].[ORDER_DETAIL]  WITH CHECK ADD  CONSTRAINT [FK_ORDER_DETAIL_PRODUCT_ELEVATION] FOREIGN KEY([PRODUCT_ID])
REFERENCES [dbo].[PRODUCT_ELEVATION] ([ID])
GO
ALTER TABLE [dbo].[ORDER_DETAIL] CHECK CONSTRAINT [FK_ORDER_DETAIL_PRODUCT_ELEVATION]
GO
ALTER TABLE [dbo].[ORDERS]  WITH CHECK ADD  CONSTRAINT [FK_ORDERS_ACCOUNT] FOREIGN KEY([ACCOUNT_ID])
REFERENCES [dbo].[ACCOUNT] ([ID])
GO
ALTER TABLE [dbo].[ORDERS] CHECK CONSTRAINT [FK_ORDERS_ACCOUNT]
GO
ALTER TABLE [dbo].[ORDERS]  WITH CHECK ADD  CONSTRAINT [FK_ORDERS_CLIENT] FOREIGN KEY([CLIENT_ID])
REFERENCES [dbo].[CLIENT] ([ID])
GO
ALTER TABLE [dbo].[ORDERS] CHECK CONSTRAINT [FK_ORDERS_CLIENT]
GO
ALTER TABLE [dbo].[ORDERS]  WITH CHECK ADD  CONSTRAINT [FK_ORDERS_STATUS_ORDER] FOREIGN KEY([STATUS_ID])
REFERENCES [dbo].[STATUS_ORDER] ([ID])
GO
ALTER TABLE [dbo].[ORDERS] CHECK CONSTRAINT [FK_ORDERS_STATUS_ORDER]
GO


	
