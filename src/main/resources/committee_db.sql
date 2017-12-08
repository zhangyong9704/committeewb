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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(300) NOT NULL COMMENT '标题',
  `picUrl` varchar(300) NOT NULL COMMENT '图片地址',
  `jumpLink` varchar(300) NOT NULL COMMENT '跳转链接',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT 'banner类型:0头部大banner图,1底部友情链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='首页头部大banner以及底部小bannner';

/*Data for the table `banner` */

insert  into `banner`(`id`,`name`,`picUrl`,`jumpLink`,`type`) values (1,'共青团中央','201712/19c3be11-336b-49be-91de-a030d27a4d9f.jpg','http://www.feicuiedu.com',0),(2,'友情链接-1','201712/76673ba4-f431-4a5b-87c8-fcadb4c806de.jpg','http://www.baidu.com',1),(3,'友情链接-2','201712/de5eb859-5007-4b2c-a5bc-01d1855c79f8.jpg','http://www.baidu.com',1),(4,'友情链接-3','201712/b0597e94-f1de-485c-aa0b-711982b49381.jpg','http://www.baidu.com',1),(5,'友情链接-4','201712/f7dce7c3-cf5a-414c-ae87-becc359c70a2.jpg','http://www.baidu.com',1),(17,'友情链接-5','201712/666644bc-6e62-439c-af7f-9299c45a3fcf.jpg','http://www.baidu.com',1),(19,'1234','201712/b689cfb0-296a-4fd8-92c4-ec6b4c268cbe.jpg','1234',1),(20,'4567','201712/862b598b-0991-40b5-8365-550c6fde1333.jpg','456',1),(22,'1112','201712/ac294bd8-6f11-4f29-9cde-53f13edf62d3.jpg','1112',1);

/*Table structure for table `files` */

DROP TABLE IF EXISTS `files`;

CREATE TABLE `files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(300) NOT NULL COMMENT '文件名',
  `url` varchar(300) NOT NULL COMMENT '文件地址链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='存储新闻中上传的附件，一条新闻可能有多个附件';

/*Data for the table `files` */

/*Table structure for table `nav` */

DROP TABLE IF EXISTS `nav`;

CREATE TABLE `nav` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '标题名称',
  `jumpLink` varchar(300) DEFAULT NULL COMMENT '跳转链接',
  `sort` int(11) DEFAULT '0' COMMENT '显示顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='导航栏标题的内容，例如：首页、规章制度、工作标准、通讯录、风采录';

/*Data for the table `nav` */

insert  into `nav`(`id`,`name`,`jumpLink`,`sort`) values (3,'工作标准','http://www.feicuiedu.com',5),(4,'通讯录','http://www.feicuiedu.com',4),(5,'风采录','http://www.feicuiedu.com',3),(9,'首页','https://www.baidu.com',1);

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(300) NOT NULL COMMENT '标题',
  `newsTypeID` int(11) NOT NULL COMMENT '新闻类型ID',
  `picUrl` varchar(300) DEFAULT NULL COMMENT '宣传图片地址',
  `content` text NOT NULL COMMENT '新闻内容',
  `publishTime` datetime NOT NULL COMMENT '发布时间',
  `author` varchar(50) DEFAULT NULL COMMENT '作者',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '发布状态:0已发布,1草稿',
  `showTime` datetime DEFAULT NULL COMMENT '发布时间',
  `count` bigint(20) DEFAULT '0' COMMENT '浏览量',
  `isHavePic` int(1) DEFAULT '0' COMMENT '是否是图文新闻:0纯文字,1图文',
  PRIMARY KEY (`id`),
  KEY `newsTypeID` (`newsTypeID`),
  CONSTRAINT `news_ibfk_1` FOREIGN KEY (`newsTypeID`) REFERENCES `newstype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='存储新闻的信息字段，其中包括图片新闻(轮播图)、重点专注、公告栏、文件通知......';

/*Data for the table `news` */

insert  into `news`(`id`,`title`,`newsTypeID`,`picUrl`,`content`,`publishTime`,`author`,`status`,`showTime`,`count`,`isHavePic`) values (1,'寻找最美青工',1,'news.png','最美的青工，青工，青工。牛肉酱，展会，发展的还不错','2016-06-01 10:57:04','美丽的小编',0,'2017-12-03 09:42:55',2000,0),(2,'奋斗的青春最美丽',1,'news.png','美丽美丽美丽，青春奋斗奋斗奋斗，五道口买昂阿拉啦啦啦啦','2017-08-01 10:59:19','阿杜',0,'2017-12-01 13:43:01',0,0),(3,'青春雷锋的榜样',1,'news.png','青春雷锋的榜样导航栏的拉到底大厦的后来打的，大的哈喽动画了的','2017-09-01 11:00:07','阿毛',0,'2017-11-30 09:43:09',0,0),(4,'中国梦“青春汇”',1,'news.png','中国梦，是中国共产党第十八次全国代表大会召开以来[1]  ，习近平总书记所提出的重要指导思想和重要执政理念，正式提出于2012年11月29日。习总书记把“中国梦”定义为“实现中华民族伟大复兴，就是中华民族近代以来最伟大梦想”，并且表示这个梦“一定能实现”。','2017-01-05 11:01:21','飒飒',1,'2017-11-02 05:43:15',1000,0),(5,'青年发展规划',1,'news.png','“中国梦”的核心目标也可以概括为“两个一百年”的目标，也就是：到2021年中国共产党成立100周年和2049年中华人民共和国成立100周年时，逐步并最终顺利实现中华民族的伟大复兴，具体表现是国家富强、民族振兴、人民幸福，实现途径是走中国特色的社会主义道路、坚持中国特色社会主义理论体系、弘扬民族精神、凝聚中国力量，实施手段是政治、经济、文化、社会、生态文明五位一体建设。','2017-10-05 11:02:26','醒醒',0,'2017-10-12 11:43:22',0,0),(6,'青年发展优先战略',1,'news.png','2017年10月18日，习近平同志在十九大报告中指出，实现中华民族伟大复兴是近代以来中华民族最伟大的梦想。','2017-09-09 11:03:19','小编',1,'2017-10-10 09:43:38',200,0),(7,'《规划》为青年发展注入洪荒之力',1,'news.png','中国共产党一经成立，就把实现共产主义作为党的最高理想和最终目标，义无反顾肩负起实现中华民族伟大复兴的历史使命，团结带领人民进行了艰苦卓绝的斗争，谱写了气吞山河的壮丽史诗。','2017-09-27 11:04:12','阿杜',0,'2017-10-15 12:43:41',0,0),(8,'献礼十九大',1,'news.png','习近平指出，实现伟大梦想，必须进行伟大斗争；必须建设伟大工程；必须推进伟大事业。','2011-03-03 11:04:57','阿毛',0,'2017-11-05 11:43:49',0,0),(9,'全民奔小康',1,'news.png','青春雷锋的榜样导航栏的拉到底大厦的后来打的，大的哈喽动画了的','2017-03-09 11:05:43','姗姗',0,'2017-11-02 12:37:56',0,0),(10,'建设法治中国',1,'news.png','中国梦”的核心目标也可以概括为“两个一百年”的目标，也就是：到2021年中国共产党成立100周年和2049年中华人民共和国成立100周年时，逐步并最终顺利实现中华民族的伟大复兴，具体表现是国家富强、民族振兴、人民幸福，实现途径是走中国特色的社会主义道路、坚持中国特色社会主义理论体系、弘扬民族精神、凝聚中国力量，实施手段是政治、经济、文化、社会、生态文明五位一体建设。','2017-02-16 11:06:20','莎莎',1,'2017-11-03 14:33:05',300,0),(11,'军民和谐一家亲',2,'news.png','news.png习近平指出，实现伟大梦想，必须进行伟大斗争；必须建设伟大工程；必须推进伟大事业。','2017-11-09 11:26:23','巧巧',0,'2017-11-05 12:44:18',0,0),(12,'吉隆坡的天气',3,'news.png','吉隆坡的天气也真是任性，说下雨就下雨，说热就热','2017-12-05 14:51:12','包子',0,'2017-12-05 14:51:21',0,0),(13,'国家大剧院',3,'news.png','来国家大剧院看戏剧啦，卡啦啦啦','2017-12-04 14:52:11','阿毛',0,'2017-12-04 14:52:22',100,0),(14,'故宫博物院',4,'news.png','夕阳下的紫金城，安徽卡拉季，格外美丽啦','2017-12-07 14:53:02','姗姗',0,'2017-12-15 14:53:11',0,0),(15,'悉尼',5,'news.png','中国梦”的核心目标也可以概括为“两个一百年”的目标，也就是：到2021年中国共产党成立100周年和2049年中华人民共和国成立100周年时，逐步并最终顺利实现中华民族的伟大复兴，具体表现是国家富强、民族振兴、人民幸福，实现途径是走中国特色的社会主义道路、坚持中国特色社会主义理论体系、弘扬民族精神、凝聚中国力量，实施手段是政治、经济、文化、社会、生态文明五位一体建设。','2017-12-08 14:53:41','叽萝',0,'2017-12-12 14:54:01',800,0),(16,'西雅图',6,'news.png','凤凰海贼团，的教案连接的垃圾袋的，冰海道','2017-12-03 14:55:02','叽萝',0,'2017-12-03 14:55:09',390,0),(17,'国家会议中心',6,'news.png','来参加活动啦啦啦啦','2017-12-06 14:55:53','叽萝',0,'2017-12-20 14:55:59',469,0);

/*Table structure for table `newsfile` */

DROP TABLE IF EXISTS `newsfile`;

CREATE TABLE `newsfile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `newsID` int(11) DEFAULT NULL COMMENT '新闻ID',
  `fileID` int(11) DEFAULT NULL COMMENT '附件ID',
  PRIMARY KEY (`id`),
  KEY `newsID` (`newsID`),
  KEY `fileID` (`fileID`),
  CONSTRAINT `newsfile_ibfk_1` FOREIGN KEY (`newsID`) REFERENCES `news` (`id`),
  CONSTRAINT `newsfile_ibfk_2` FOREIGN KEY (`fileID`) REFERENCES `files` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `newsfile` */

/*Table structure for table `newstype` */

DROP TABLE IF EXISTS `newstype`;

CREATE TABLE `newstype` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '新闻类型ID',
  `name` varchar(100) NOT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `newstype` */

insert  into `newstype`(`id`,`name`) values (1,'重点专注'),(2,'公告'),(3,'文件通知'),(4,'团青快讯'),(5,'蜀南青语'),(6,'专题活动');

/*Table structure for table `rollimg` */

DROP TABLE IF EXISTS `rollimg`;

CREATE TABLE `rollimg` (
  `newsID` int(11) NOT NULL COMMENT '新闻ID',
  `sort` int(11) DEFAULT NULL COMMENT '显示顺序',
  `isShow` int(11) DEFAULT '0' COMMENT '是否在首页展示:0不展示,1展示',
  PRIMARY KEY (`newsID`),
  CONSTRAINT `rollimg_ibfk_1` FOREIGN KEY (`newsID`) REFERENCES `news` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `rollimg` */

insert  into `rollimg`(`newsID`,`sort`,`isShow`) values (1,1,1),(2,3,0),(3,4,1),(5,2,1);

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

insert  into `webinfo`(`id`,`logoUrl`,`titleUrl`,`backgroundUrl`,`field1`,`field2`,`field3`,`field4`,`field5`) values (1,'201712/71cfc6ac-80f1-4b85-9c78-bcb43d65968b.jpg','201712/4fe0ceb7-71a2-4bbe-966f-b99eb389e64d.jpg','201712/8252ab2f-5dd4-4814-998c-bf8762c87396.jpg','翡翠教育','翡翠教育','翡翠教育','翡翠教育','翡翠教育');

/*Table structure for table `webinfonav` */

DROP TABLE IF EXISTS `webinfonav`;

CREATE TABLE `webinfonav` (
  `id` int(11) NOT NULL,
  `webInfoID` int(11) DEFAULT NULL COMMENT '网站基本信息ID',
  `navID` int(11) DEFAULT NULL COMMENT '导航栏ID',
  PRIMARY KEY (`id`),
  KEY `webInfoID` (`webInfoID`),
  KEY `navID` (`navID`),
  CONSTRAINT `webinfonav_ibfk_1` FOREIGN KEY (`webInfoID`) REFERENCES `webinfo` (`id`),
  CONSTRAINT `webinfonav_ibfk_2` FOREIGN KEY (`navID`) REFERENCES `nav` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `webinfonav` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
