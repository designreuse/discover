-- --------------------------------------------------------
-- 主机:                           192.168.0.199
-- 服务器版本:                        5.7.10-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5168
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 正在导出表  umall.menu 的数据：~9 rows (大约)
DELETE FROM `menu`;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `catalog`, `icon`, `nums`, `path`, `permission`, `pid`) VALUES
	(1, '2017-09-25 14:25:39', '', '1', '2017-09-25 14:25:39', 1, 1, '根节点', 20, 0, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, '2017-09-25 14:34:01', NULL, '1,2', '2017-09-25 14:34:01', 2, 2, '系统设置', 19, 0, 0, 'fa  fa-gear', 0, '', '2', 1),
	(3, '2017-09-25 14:34:37', NULL, '1,2,3', '2017-09-25 14:34:37', 3, 3, '菜单管理', 4, 0, 0, 'fa  fa-reorder', 0, 'admin/menu/view_list.htm', 'menu', 2),
	(4, '2017-09-25 14:36:59', NULL, '1,2,4', '2017-09-25 14:36:59', 3, 5, '角色管理', 6, 0, 0, 'fa  fa-tree', 0, 'admin/userrole/view_list.htm', 'userrole', 2),
	(5, '2017-09-25 14:38:29', NULL, '1,2,5', '2017-09-25 14:38:29', 3, 7, '第三方登陆配置', 8, 0, 0, 'fa  fa-connectdevelop', 0, 'admin/useroauthconfig/view_list.htm', 'useroauthconfig', 2),
	(6, '2017-09-25 14:35:30', NULL, '1,2,6', '2017-09-25 14:35:30', 3, 9, '友情链接分类管理', 10, 0, 0, 'fa  fa-link', 0, 'admin/linktype/view_list.htm', 'linktype', 2),
	(7, '2017-09-25 14:37:37', NULL, '1,2,7', '2017-09-25 14:37:37', 3, 11, '友情链接管理', 12, 0, 0, 'fa  fa-link', 0, 'admin/link/view_list.htm', 'link', 2),
	(8, '2017-09-25 14:48:04', NULL, '1,2,8', '2017-09-25 14:48:04', 3, 13, '角色分类配置', 14, 0, 0, 'fa  fa-user-secret', 0, 'admin/userrolecatalog/view_list.htm', 'userrolecatalog', 2),
	(9, '2017-09-25 14:47:35', NULL, '1,2,9', '2017-09-25 14:47:35', 3, 15, '移动app配置', 16, 0, 0, 'fa  fa-life-ring', 0, 'admin/app/view_list.htm', 'app', 2),
	(10, '2017-09-25 15:22:17', NULL, '1,2,10', '2017-09-25 15:22:17', 3, 17, '网站主题配置', 18, 0, 0, 'fa  fa-sitemap', 0, 'admin/theme.htm', '10', 2);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;

-- 正在导出表  umall.user_account 的数据：~0 rows (大约)
DELETE FROM `user_account`;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` (`id`, `addDate`, `lastDate`, `accountType`, `loginSize`, `password`, `salt`, `username`, `user_id`) VALUES
	(1, '2017-09-25 14:14:56', '2017-09-25 15:54:39', 2, 27, '9bf876c77352cf2f852892f4da1e041622bd5f1e', 'df02ab36fed44aa5', 'admin', 1);
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;

-- 正在导出表  umall.user_info 的数据：~0 rows (大约)
DELETE FROM `user_info`;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` (`id`, `addDate`, `lastDate`, `avatar`, `catalog`, `loginSize`, `name`, `password`, `phone`, `registerType`, `salt`, `state`, `username`) VALUES
	(1, '2017-09-25 14:14:56', '2017-09-25 15:54:40', NULL, NULL, 38, 'admin', NULL, NULL, '账号', NULL, NULL, NULL);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;

-- 正在导出表  umall.user_info_attribute 的数据：~0 rows (大约)
DELETE FROM `user_info_attribute`;
/*!40000 ALTER TABLE `user_info_attribute` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_info_attribute` ENABLE KEYS */;

-- 正在导出表  umall.user_login_log 的数据：~0 rows (大约)
DELETE FROM `user_login_log`;
/*!40000 ALTER TABLE `user_login_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_login_log` ENABLE KEYS */;

-- 正在导出表  umall.user_role 的数据：~1 rows (大约)
DELETE FROM `user_role`;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`id`, `addDate`, `lastDate`, `alias`, `description`, `name`, `roleType`, `catalog_id`) VALUES
	(1, '2017-09-25 15:17:45', '2017-09-25 15:17:45', 'admin', 'admin', 'admin', 0, 2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

-- 正在导出表  umall.user_role_authority 的数据：~7 rows (大约)
DELETE FROM `user_role_authority`;
/*!40000 ALTER TABLE `user_role_authority` DISABLE KEYS */;
INSERT INTO `user_role_authority` (`role_id`, `permission`) VALUES
	(1, '2'),
	(1, 'menu'),
	(1, 'userrole'),
	(1, 'useroauthconfig'),
	(1, 'linktype'),
	(1, 'link'),
	(1, 'userrolecatalog'),
	(1, 'app'),
	(1, '10');
/*!40000 ALTER TABLE `user_role_authority` ENABLE KEYS */;

-- 正在导出表  umall.user_role_catalog 的数据：~2 rows (大约)
DELETE FROM `user_role_catalog`;
/*!40000 ALTER TABLE `user_role_catalog` DISABLE KEYS */;
INSERT INTO `user_role_catalog` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `pid`) VALUES
	(1, '2017-09-25 14:42:08', '', '1', '2017-09-25 14:42:08', 1, 1, '根节点', 4, 0, NULL),
	(2, '2017-09-25 14:42:56', '001', '1,2', '2017-09-25 14:42:56', 2, 2, '系统角色', 3, NULL, 1);
/*!40000 ALTER TABLE `user_role_catalog` ENABLE KEYS */;

-- 正在导出表  umall.user_role_links 的数据：~1 rows (大约)
DELETE FROM `user_role_links`;
/*!40000 ALTER TABLE `user_role_links` DISABLE KEYS */;
INSERT INTO `user_role_links` (`user_id`, `roles_id`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `user_role_links` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
