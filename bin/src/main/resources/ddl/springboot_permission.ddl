CREATE TABLE
    springboot_permission
    (
        id VARCHAR(32) NOT NULL,
        permissionName VARCHAR(60) COMMENT '权限名称',
        permissionNumber VARCHAR(60) COMMENT '权限编码',
        description VARCHAR(255) COMMENT '权限描述',
        permissionEnable VARCHAR(1) COMMENT '是否可用',
        createBy VARCHAR(32),
        modifyBy VARCHAR(32),
        createDate DATETIME,
        modifyDate DATETIME,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8