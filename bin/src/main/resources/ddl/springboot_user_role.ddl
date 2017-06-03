CREATE TABLE
    springboot_user_role
    (
        id VARCHAR(32) NOT NULL,
        userId VARCHAR(32) COMMENT '用户id',
        roleId VARCHAR(32) COMMENT '角色id',
        description VARCHAR(255) COMMENT '描述',
        isWork VARCHAR(1) COMMENT '是否可用',
        createBy VARCHAR(32) COMMENT '新增人',
        modifyBy VARCHAR(32) COMMENT '修改人',
        createDate DATETIME COMMENT '新增时间',
        modifyDate DATETIME COMMENT '修改时间',
        PRIMARY KEY (id),
        INDEX useridfk (userId),
        INDEX roleidfk (roleId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8