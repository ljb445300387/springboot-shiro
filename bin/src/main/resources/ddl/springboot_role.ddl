CREATE TABLE
    springboot_role
    (
        id VARCHAR(32) NOT NULL,
        roleName VARCHAR(60) COMMENT '角色名称',
        description VARCHAR(255) COMMENT '描述',
        roleNumber VARCHAR(60) COMMENT '编码',
        createBy VARCHAR(32) COMMENT '创建人',
        modifyBy VARCHAR(32) COMMENT '修改人',
        createDate DATETIME COMMENT '创建日期',
        modifyDate DATETIME COMMENT '修改日期',
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8