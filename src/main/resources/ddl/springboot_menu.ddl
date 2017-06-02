CREATE TABLE
    springboot_menu
    (
        id VARCHAR(32) NOT NULL,
        name VARCHAR(60) COMMENT '菜单名称',
        code VARCHAR(160) COMMENT '菜单url',
        enable VARCHAR(1) COMMENT '菜单是否可用',
        parentId VARCHAR(32) COMMENT '父层菜单id',
        createBy VARCHAR(32) COMMENT '创建人',
        modifyBy VARCHAR(32) COMMENT '修改人',
        createDate DATETIME COMMENT '创建时间',
        modifyDate DATETIME COMMENT '修改时间',
        description VARCHAR(255) COMMENT '菜单描述',
        menu_type VARCHAR(10),
        isParent VARCHAR(1) COMMENT '是否是父亲节点',
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8