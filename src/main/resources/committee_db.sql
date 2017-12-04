/*
SQLyog v10.2 
MySQL - 5.5.27 : Database - committee_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`committee_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `committee_db`;

/*Table structure for table `banner` */

DROP TABLE IF EXISTS `banner`;

CREATE TABLE `banner` (
  `id` int(11) NOT NULL,
  `name` varchar(300) NOT NULL COMMENT '标题',
  `picUrl` varchar(300) NOT NULL COMMENT '图片地址',
  `jumpLink` varchar(300) NOT NULL COMMENT '跳转链接',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT 'banner类型:0头部大banner图,1底部小图',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='首页头部大banner以及底部小bannner';

/*Data for the table `banner` */

/*Table structure for table `files` */

DROP TABLE IF EXISTS `files`;

CREATE TABLE `files` (
  `id` int(11) NOT NULL,
  `name` varchar(300) NOT NULL COMMENT '文件名',
  `url` varchar(300) NOT NULL COMMENT '文件地址链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='存储新闻中上传的附件，一条新闻可能有多个附件';

/*Data for the table `files` */

/*Table structure for table `nav` */

DROP TABLE IF EXISTS `nav`;

CREATE TABLE `nav` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '标题名称',
  `jumpLink` varchar(300) DEFAULT NULL COMMENT '跳转链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='导航栏标题的内容，例如：首页、规章制度、工作标准、通讯录、风采录';

/*Data for the table `nav` */

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `id` int(11) NOT NULL,
  `title` varchar(300) NOT NULL COMMENT '标题',
  `newsTypeID` int(11) NOT NULL COMMENT '新闻类型ID',
  `picUrl` varchar(300) DEFAULT NULL COMMENT '宣传图片地址',
  `content` text NOT NULL COMMENT '新闻内容',
  `publishTime` datetime NOT NULL COMMENT '发布时间',
  `author` varchar(50) DEFAULT NULL COMMENT '作者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='存储新闻的信息字段，其中包括图片新闻(轮播图)、重点专注、公告栏、文件通知......';

/*Data for the table `news` */

/*Table structure for table `newsfile` */

DROP TABLE IF EXISTS `newsfile`;

CREATE TABLE `newsfile` (
  `id` int(11) NOT NULL,
  `newsID` int(11) DEFAULT NULL COMMENT '新闻ID',
  `fileID` int(11) DEFAULT NULL COMMENT '附件ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `newsfile` */

/*Table structure for table `newstype` */

DROP TABLE IF EXISTS `newstype`;

CREATE TABLE `newstype` (
  `id` int(11) NOT NULL COMMENT '新闻类型ID',
  `name` varchar(100) NOT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `newstype` */

/*Table structure for table `rollimg` */

DROP TABLE IF EXISTS `rollimg`;

CREATE TABLE `rollimg` (
  `newsID` int(11) NOT NULL COMMENT '新闻ID',
  `sort` int(11) DEFAULT NULL COMMENT '显示顺序',
  `isShow` int(11) DEFAULT '0' COMMENT '是否在首页展示:0不展示,1展示',
  PRIMARY KEY (`newsID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `rollimg` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `account` varchar(32) NOT NULL COMMENT '账号',
  `password` varchar(128) DEFAULT NULL COMMENT '密码',
  `realName` varchar(32) DEFAULT NULL COMMENT '账号使用者真实姓名',
  `salt` varchar(64) DEFAULT NULL COMMENT '盐',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `tel` char(11) DEFAULT NULL COMMENT '联系方式',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`account`,`password`,`realName`,`salt`,`sex`,`tel`,`email`) values ('admin','c09460efb9cdebd15fa0dc033c20de44','张三','1511167003013','男','12345678901','357257@qq.com');

/*Table structure for table `webinfo` */

DROP TABLE IF EXISTS `webinfo`;

CREATE TABLE `webinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `logoUrl` varchar(300) DEFAULT NULL COMMENT 'logo地址',
  `titleUrl` varchar(300) DEFAULT NULL COMMENT '标题地址',
  `backgroundUrl` varchar(300) DEFAULT NULL COMMENT '网站背景图地址',
  `field1` varchar(300) DEFAULT NULL COMMENT '底部字段1',
  `field2` varchar(300) DEFAULT NULL COMMENT '底部字段2',
  `field3` varchar(300) DEFAULT NULL COMMENT '底部字段3',
  `field4` varchar(300) DEFAULT NULL COMMENT '底部字段4',
  `field5` varchar(300) DEFAULT NULL COMMENT '底部字段5',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='存储网站logo、标题、网站背景图信息、底部信息等内容';

/*Data for the table `webinfo` */

insert  into `webinfo`(`id`,`logoUrl`,`titleUrl`,`backgroundUrl`,`field1`,`field2`,`field3`,`field4`,`field5`) values (1,'homeLogo.png','homeTitle.png','homeBackground.png','最终解释权归蜀南气矿所有','2010-2020','成都市玉林路520号','0102-1234567','0102-1234568');

/*Table structure for table `webinfonav` */

DROP TABLE IF EXISTS `webinfonav`;

CREATE TABLE `webinfonav` (
  `id` int(11) NOT NULL,
  `webInfoID` int(11) DEFAULT NULL COMMENT '网站基本信息ID',
  `navID` int(11) DEFAULT NULL COMMENT '导航栏ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `webinfonav` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
