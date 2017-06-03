CREATE TABLE
    springboot_role_permission
    (
        id VARCHAR(32) NOT NULL,
        roleId VARCHAR(32) COMMENT '角色id',
        permissionid VARCHAR(32) COMMENT '权限id',
        description VARCHAR(255) COMMENT '描述',
        isWork VARCHAR(1),
        createBy VARCHAR(32) COMMENT '创建人',
        modifyBy VARCHAR(32) COMMENT '修改时间',
        createDate DATETIME COMMENT '新增时间',
        modifyDate DATETIME COMMENT '修改时间',
        PRIMARY KEY (id),
        INDEX rolepermissionfkid (permissionid),
        INDEX rolepermissionfkid2 (roleId)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8