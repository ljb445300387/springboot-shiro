--此为数据初始文件
delete from springboot_user;
insert into springboot_user (id, name, mobilePhone, telPhone, gender, passwd, emailaddress, birthday, isLocked, salt, passwordExpired, account, createBy, modifyBy, createDate, modifyDate) values ('1', 'admin', '11111', '111', '1', '2478be274cfe01789f068da02c40d36c', 'admin@test.com', '2016-06-16 00:00:00', 'N', '9ed7248fb51285d294bad05395b762c2', 'N', 'admin', null, null, null, null);
insert into springboot_user (id, name, mobilePhone, telPhone, gender, passwd, emailaddress, birthday, isLocked, salt, passwordExpired, account, createBy, modifyBy, createDate, modifyDate) values ('2', 'test', '11111', '111', '1', '948da434187012edd15a9688ce5a22d8', 'test@test.com', '2016-06-16 00:00:00', 'N', 'a55dbbad076aa08e116b177cb8bea4f6', 'N', 'test', null, null, null, null);
insert into springboot_user (id, name, mobilePhone, telPhone, gender, passwd, emailaddress, birthday, isLocked, salt, passwordExpired, account, createBy, modifyBy, createDate, modifyDate) values ('3', 'guest', '11111', '111', '1', '16aeefd6b4e47866fd262c5191025702', 'guest@test.com', '2016-06-16 00:00:00', 'N', '89f30be46c571dd4f526af8a7518d030', 'N', 'guest', null, null, null, null);

delete from springboot_role;
insert into springboot_role (id, roleName, description, roleNumber, createBy, modifyBy, createDate, modifyDate) values ('1', 'admin', 'admin', 'admin', null, null, null, null);
insert into springboot_role (id, roleName, description, roleNumber, createBy, modifyBy, createDate, modifyDate) values ('2', 'test', 'test', 'test', null, null, null, null);
insert into springboot_role (id, roleName, description, roleNumber, createBy, modifyBy, createDate, modifyDate) values ('3', 'guest', 'guest', 'guest', null, null, null, null);

delete from springboot_user_role;
insert into springboot_user_role (id, userId, roleId, description, isWork, createBy, modifyBy, createDate, modifyDate) values ('1', '1', '1', 'adminmap', 'Y', null, null, null, null);
insert into springboot_user_role (id, userId, roleId, description, isWork, createBy, modifyBy, createDate, modifyDate) values ('2', '2', '2', 'testmap', 'Y', null, null, null, null);
insert into springboot_user_role (id, userId, roleId, description, isWork, createBy, modifyBy, createDate, modifyDate) values ('3', '3', '3', 'guestmap', 'Y', null, null, null, null);

delete from springboot_permission;
insert into springboot_permission (id, permissionName, permissionNumber,  description, permissionEnable, createBy, modifyBy, createDate, modifyDate) values ('1', 'adminView', 'adminView',  'adminView', 'Y', null, null, null, null);
insert into springboot_permission (id, permissionName, permissionNumber, description, permissionEnable, createBy, modifyBy, createDate, modifyDate) values ('2', 'testView', 'testView','testView', 'Y', null, null, null, null);
insert into springboot_permission (id, permissionName, permissionNumber, description, permissionEnable, createBy, modifyBy, createDate, modifyDate) values ('3', 'guestView', 'guestView','guestView', 'Y', null, null, null, null);

delete from springboot_role_permission;
insert into springboot_role_permission (id, roleId, permissionid, description, isWork, createBy, modifyBy, createDate, modifyDate) values ('1', '1', '1', 'adminView', 'Y', null, null, null, null);
insert into springboot_role_permission (id, roleId, permissionid, description, isWork, createBy, modifyBy, createDate, modifyDate) values ('2', '2', '2', 'testView', 'Y', null, null, null, null);
insert into springboot_role_permission (id, roleId, permissionid, description, isWork, createBy, modifyBy, createDate, modifyDate) values ('3', '3', '3', 'guestView', 'Y', null, null, null, null);

delete from springboot_menu;
insert into springboot_menu (id, name, code, enable, parentId, createBy, modifyBy, createDate, modifyDate, description, menu_type, isParent) values ('1', 'adminView', '/adminView', 'Y', '15', null, null, null, null, '1', 'permission', 'N');
insert into springboot_menu (id, name, code, enable, parentId, createBy, modifyBy, createDate, modifyDate, description, menu_type, isParent) values ('2', 'testView', '/testView', 'Y', '15', null, null, null, null, '1', 'permission', 'N');
insert into springboot_menu (id, name, code, enable, parentId, createBy, modifyBy, createDate, modifyDate, description, menu_type, isParent) values ('3', 'guestView', '/guestView', 'Y', '15', null, null, null, null, '1', 'permission', 'N');

delete from springboot_permission_menu;
insert into springboot_permission_menu (id,permissionid,menuId,description,isWork,createBy,modifyBy,createDate,modifyDate)values('1','1','1','管理员','Y','1','1',current_date ,current_date);
insert into springboot_permission_menu (id,permissionid,menuId,description,isWork,createBy,modifyBy,createDate,modifyDate)values('2','2','2','测试','Y','1','1',current_date ,current_date);
insert into springboot_permission_menu (id,permissionid,menuId,description,isWork,createBy,modifyBy,createDate,modifyDate)values('3','3','3','游客','Y','1','1',current_date ,current_date);

