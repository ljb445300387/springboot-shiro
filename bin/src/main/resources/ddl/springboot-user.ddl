CREATE TABLE
    springboot_user
    (
        id VARCHAR(32) NOT NULL,
        name VARCHAR(60) NOT NULL COMMENT '显示名称，可以重复',
        mobilePhone VARCHAR(55) COMMENT '手机号,多个手机号用逗号隔开',
        telPhone VARCHAR(20) COMMENT '座机号',
        gender VARCHAR(1) COMMENT '性别',
        passwd VARCHAR(150) COMMENT '密码',
        emailaddress VARCHAR(50) COMMENT ' 邮箱',
        birthday DATETIME COMMENT '出生日期',
        isLocked VARCHAR(1) COMMENT '是否被锁定',
        salt VARCHAR(50) COMMENT '密码随机盐',
        passwordExpired VARCHAR(1) COMMENT '密码是否失效',
        account VARCHAR(20) COMMENT '登陆名',
        createBy VARCHAR(32) COMMENT '创建人',
        modifyBy VARCHAR(32) COMMENT '修改人',
        createDate DATETIME COMMENT '创建时间',
        modifyDate DATETIME COMMENT '修改时间',
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8