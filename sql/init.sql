-- MySQL dump 10.13  Distrib 5.5.44, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: wechat_service
-- ------------------------------------------------------
-- Server version	5.5.44-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_category`
--

DROP TABLE IF EXISTS `t_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sequence` varchar(255) NOT NULL,
  `content` mediumtext NOT NULL,
  `addDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `type` char(255) NOT NULL,
  `answer` mediumtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_category`
--

LOCK TABLES `t_category` WRITE;
/*!40000 ALTER TABLE `t_category` DISABLE KEYS */;
INSERT INTO `t_category` VALUES (1,'1','已注册\"翼机通 \"企业管理员的实际操作','2015-10-25 08:05:30','0',''),(2,'2','已注册\"翼机通 \"企业员工的实际操作','2015-10-25 08:05:52','0',''),(3,'3','了解\"翼机通 ”基本功能','2015-10-25 08:45:35','1','【APP】如果您只想使用手机APP，可直接通过http://yjt.189.cn下载并注册企业，设置通信录，将企业内的相关人员加入使用。即使您不是中国电信的手机用户，也可以使用APP。 【手机的话费和“翼机通 ”账户余额】开通“翼机通 ”业务后，“翼机通 ”使用的是和话费独立的电子账户，和话费无关。  如您的问题尚未解答，请您致电4008989993，客服将为您专程答疑解惑。【功能】可以提供考勤、消费、门禁等线下功能，并通过手机客户端实现通信录、任务、电子公告等线上业务功能，客户结合自身情况可使用其中的部分功能。 【优势】以手机为载体，一部手机即可实现门禁考勤、小额消费等活动，方便了用户的生活，免除了携带各种证件的麻烦；同时，用户可以通过手机客户端实时查询考勤消费信息，还可以进行实时任务派发，发布/获取通知、公告、会议信息等。 【开通】企业客户可携带企业的有效证件和有效身份证件到电信营业厅办理，也可通过当地电信的客户经理进行业务办理。建议您前往办理前，先拨打当地电信客服热线10000号查询离您最近的一个办理点。'),(4,'4','其他问题','2015-10-25 08:46:31','1','【手机或卡丢失】若卡丢失或手机与卡同时丢失，建议您先及时挂失，挂失请先联系企业管理员进行”翼机通 ”功能冻结。同时，可以拨打当地电信客服热线10000号或前往最近的一个有办理挂失业务的电信营业厅办理卡挂失。“翼机通 ”账户挂失后，消费账户内的资金将被冻结，待您前往电信营业厅办理解挂或者补卡后，还需要在前往您所在企业的管理员处重新恢复所有功能，如果开通了消费功能，管理员还应同时将原有“翼机通 ”消费账户的钱转入新补卡账户中。【手机没电】手机没电无法开机时，一般还有一定的残余电量，可以刷手机进行考勤/消费，但是如果手机彻底没电或者电池被拔出，则无法进行刷卡操作，因此，请保持手机电量充足。 如您的问题尚未解答，请您致电4008989993，客服将为您专程答疑解惑。');
/*!40000 ALTER TABLE `t_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_qarecords`
--

DROP TABLE IF EXISTS `t_qarecords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_qarecords` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `question` mediumtext NOT NULL,
  `answer` mediumtext NOT NULL,
  `answerSource` char(255) NOT NULL,
  `addDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_qarecords`
--

LOCK TABLES `t_qarecords` WRITE;
/*!40000 ALTER TABLE `t_qarecords` DISABLE KEYS */;
INSERT INTO `t_qarecords` VALUES (3,'oi-WAuGBXEbN5WvuCIbJLQxmXXbE','翼机通加是什么','“翼机通+”产品是原有翼机通产品在4G NFC时代的升级版本，以4G NFC手机为载体，面向政企客户提供企业通信录、考勤、消费、签到、通知公告、任务等企业管理和协同功能。\n\n 如果这不能解决您的问题，您可以发送【s】进行详细查询~~','1','2015-10-24 15:45:58'),(4,'oi-WAuGBXEbN5WvuCIbJLQxmXXbE','1-1','【创建企业】：点击左上角的人像，点击企业列表，进入创建或加入企业。企业一旦创建后企业名称不可以修改。一个企业管理可创建多个企业。 【创建企业错误后删除】：点击工作台进入企业管理，点击注销企业，确认注销。 【创建后修改企业信息】：点击工作台进入企业管理，点击修改企业信息，修改完成后，保存提交，提示修改企业信息成功。 【多管理员的设置】：一个企业可以有多个管理员。点击工作台进入企业管理，点击企业成员列表，点击指定人员，点击设置管理员。  如您的问题尚未解答，请您致电4008989993，客服人员将为您专程答疑解惑。','1','2015-10-24 14:45:58'),(5,'oi-WAuGBXEbN5WvuCIbJLQxmXXbE','翼机通加是什么','“翼机通+”产品是原有翼机通产品在4G NFC时代的升级版本，以4G NFC手机为载体，面向政企客户提供企业通信录、考勤、消费、签到、通知公告、任务等企业管理和协同功能。\n\n 如果这不能解决您的问题，您可以发送【s】进行详细查询~~','1','2015-10-24 10:45:58'),(6,'oi-WAuGBXEbN5WvuCIbJLQxmXXbE','1-1','【创建企业】：点击左上角的人像，点击企业列表，进入创建或加入企业。企业一旦创建后企业名称不可以修改。一个企业管理可创建多个企业。 【创建企业错误后删除】：点击工作台进入企业管理，点击注销企业，确认注销。 【创建后修改企业信息】：点击工作台进入企业管理，点击修改企业信息，修改完成后，保存提交，提示修改企业信息成功。 【多管理员的设置】：一个企业可以有多个管理员。点击工作台进入企业管理，点击企业成员列表，点击指定人员，点击设置管理员。  如您的问题尚未解答，请您致电4008989993，客服人员将为您专程答疑解惑。','0','2015-10-24 07:45:58'),(7,'oi-WAuDATl9KI1j_5Gpg-jbxyLGI','什么是翼机通？','“翼机通+”产品是原有翼机通产品在4G NFC时代的升级版本，以4G NFC手机为载体，面向政企客户提供企业通信录、考勤、消费、签到、通知公告、任务等企业管理和协同功能。\n\n 如果这不能解决您的问题，您可以发送【s】进行详细查询~~','1','2015-10-24 02:45:58'),(8,'oi-WAuDATl9KI1j_5Gpg-jbxyLGI','S','不好意思您的问题难倒加儿了，您可以回复以下指令进行详细查询~\n【1】 已注册\"翼机通 \"企业管理员的实际操作\n【2】 已注册\"翼机通 \"企业员工的实际操作\n【3】 了解\"翼机通 ”基本功能\n【4】 其他问题\n','1','2015-10-24 02:45:28'),(9,'oi-WAuDATl9KI1j_5Gpg-jbxyLGI','翼机通是什么','“翼机通+”产品是原有翼机通产品在4G NFC时代的升级版本，以4G NFC手机为载体，面向政企客户提供企业通信录、考勤、消费、签到、通知公告、任务等企业管理和协同功能。\n\n 如果这不能解决您的问题，您可以发送【s】进行详细查询~~','1','2015-10-24 02:15:28'),(10,'oi-WAuDATl9KI1j_5Gpg-jbxyLGI','你是谁','“翼机通+”产品是原有翼机通产品在4G NFC时代的升级版本，以4G NFC手机为载体，面向政企客户提供企业通信录、考勤、消费、签到、通知公告、任务等企业管理和协同功能。\n\n 如果这不能解决您的问题，您可以发送【s】进行详细查询~~','1','2015-10-25 02:15:28'),(11,'oi-WAuDATl9KI1j_5Gpg-jbxyLGI','我想我不知道','请不要用微信的二维码扫描下载，因为微信拦截了第三方引用使得下载不成功，请换用其他的二维码扫描工具。\n\n 如果这不能解决您的问题，您可以发送【s】进行详细查询~~','1','2015-10-25 02:25:28'),(12,'oi-WAuDATl9KI1j_5Gpg-jbxyLGI','A','不好意思您的问题难倒加儿了，您可以回复以下指令进行详细查询~\n【1】 已注册\"翼机通 \"企业管理员的实际操作\n【2】 已注册\"翼机通 \"企业员工的实际操作\n【3】 了解\"翼机通 ”基本功能\n【4】 其他问题\n','1','2015-10-25 05:25:28'),(13,'oi-WAuDATl9KI1j_5Gpg-jbxyLGI','S','不好意思您的问题难倒加儿了，您可以回复以下指令进行详细查询~\n【1】 已注册\"翼机通 \"企业管理员的实际操作\n【2】 已注册\"翼机通 \"企业员工的实际操作\n【3】 了解\"翼机通 ”基本功能\n【4】 其他问题\n','1','2015-10-25 05:35:28'),(14,'oi-WAuFe3B3oubjAuyOs8z_TG3rA','翼机通','不好意思您的问题难倒加儿了，您可以回复以下指令进行详细查询~\n【1】 已注册\"翼机通 \"企业管理员的实际操作\n【2】 已注册\"翼机通 \"企业员工的实际操作\n【3】 了解\"翼机通 ”基本功能\n【4】 其他问题\n','1','2015-10-25 05:38:28'),(15,'oi-WAuFe3B3oubjAuyOs8z_TG3rA','什么是翼机通','“翼机通+”产品是原有翼机通产品在4G NFC时代的升级版本，以4G NFC手机为载体，面向政企客户提供企业通信录、考勤、消费、签到、通知公告、任务等企业管理和协同功能。\n\n 如果这不能解决您的问题，您可以发送【s】进行详细查询~~','1','2015-10-25 05:48:28'),(16,'oi-WAuDATl9KI1j_5Gpg-jbxyLGI','什么是翼机通','“翼机通+”产品是原有翼机通产品在4G NFC时代的升级版本，以4G NFC手机为载体，面向政企客户提供企业通信录、考勤、消费、签到、通知公告、任务等企业管理和协同功能。\n\n 如果这不能解决您的问题，您可以发送【s】进行详细查询~~','1','2015-10-27 08:48:28'),(17,'oi-WAuGBXEbN5WvuCIbJLQxmXXbE','你好','不好意思您的问题难倒加儿了，您可以回复以下指令进行详细查询~\n【1】 已注册\"翼机通 \"企业管理员的实际操作\n【2】 已注册\"翼机通 \"企业员工的实际操作\n【3】 了解\"翼机通 ”基本功能\n【4】 其他问题\n','1','2015-10-29 02:41:04'),(18,'oi-WAuGBXEbN5WvuCIbJLQxmXXbE','天气怎么样','不好意思您的问题难倒加儿了，您可以回复以下指令进行详细查询~\n【1】 已注册\"翼机通 \"企业管理员的实际操作\n【2】 已注册\"翼机通 \"企业员工的实际操作\n【3】 了解\"翼机通 ”基本功能\n【4】 其他问题\n','1','2015-10-29 02:41:24'),(19,'oi-WAuGBXEbN5WvuCIbJLQxmXXbE','你好','不好意思您的问题难倒加儿了，您可以回复以下指令进行详细查询~\n【1】 已注册\"翼机通 \"企业管理员的实际操作\n【2】 已注册\"翼机通 \"企业员工的实际操作\n【3】 了解\"翼机通 ”基本功能\n【4】 其他问题\n','1','2015-11-01 04:12:56'),(20,'oi-WAuGBXEbN5WvuCIbJLQxmXXbE','你好','不好意思您的问题难倒加儿了，您可以回复以下指令进行详细查询~\n【1】 已注册\"翼机通 \"企业管理员的实际操作\n【2】 已注册\"翼机通 \"企业员工的实际操作\n【3】 了解\"翼机通 ”基本功能\n【4】 其他问题\n','1','2015-11-01 09:23:09'),(21,'oi-WAuGBXEbN5WvuCIbJLQxmXXbE','翼机通加是什么','“翼机通+”产品是原有翼机通产品在4G NFC时代的升级版本，以4G NFC手机为载体，面向政企客户提供企业通信录、考勤、消费、签到、通知公告、任务等企业管理和协同功能。\n\n 如果这不能解决您的问题，您可以发送【s】进行详细查询~~','1','2015-11-01 09:23:29'),(22,'oi-WAuGBXEbN5WvuCIbJLQxmXXbE','电信套餐','如果企业内部员工想使用“翼机通+”所提供的线下业务功能，包括刷手机实现机具考勤、消费、门禁等功能，则必须使用支持电信NFC功能的手机。不想更换为电信手机的用户，可以使用白卡进行刷卡考勤和消费，并通过手机客户端使用任务派发，通知公告等线上业务功能。\n\n 如果这不能解决您的问题，您可以发送【s】进行详细查询~~','1','2015-11-01 09:23:49');
/*!40000 ALTER TABLE `t_qarecords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_question`
--

DROP TABLE IF EXISTS `t_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `subcategory_id` int(11) NOT NULL,
  `sequence` varchar(255) NOT NULL,
  `content` mediumtext NOT NULL,
  `answer` mediumtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_question`
--

LOCK TABLES `t_question` WRITE;
/*!40000 ALTER TABLE `t_question` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_subcategory`
--

DROP TABLE IF EXISTS `t_subcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_subcategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `sequence` varchar(255) NOT NULL,
  `content` mediumtext NOT NULL,
  `type` char(255) NOT NULL,
  `answer` mediumtext,
  `addDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_subcategory`
--

LOCK TABLES `t_subcategory` WRITE;
/*!40000 ALTER TABLE `t_subcategory` DISABLE KEYS */;
INSERT INTO `t_subcategory` VALUES (1,1,'1','企业创建相关操作','1','【创建企业】：点击左上角的人像，点击企业列表，进入创建或加入企业。企业一旦创建后企业名称不可以修改。一个企业管理可创建多个企业。 【创建企业错误后删除】：点击工作台进入企业管理，点击注销企业，确认注销。 【创建后修改企业信息】：点击工作台进入企业管理，点击修改企业信息，修改完成后，保存提交，提示修改企业信息成功。 【多管理员的设置】：一个企业可以有多个管理员。点击工作台进入企业管理，点击企业成员列表，点击指定人员，点击设置管理员。  如您的问题尚未解答，请您致电4008989993，客服人员将为您专程答疑解惑。','2015-10-25 08:07:00'),(2,1,'3','制作考勤标签','1','【功能】可以提供考勤、消费、门禁等线下功能，并通过手机客户端实现通信录、任务、电子公告等线上业务功能，客户结合自身情况可使用其中的部分功能。 【优势】以手机为载体，一部手机即可实现门禁考勤、小额消费等活动，方便了用户的生活，免除了携带各种证件的麻烦；同时，用户可以通过手机客户端实时查询考勤消费信息，还可以进行实时任务派发，发布/获取通知、公告、会议信息等。 【开通】企业客户可携带企业的有效证件和有效身份证件到电信营业厅办理，也可通过当地电信的客户经理进行业务办理。建议您前往办理前，先拨打当地电信客服热线10000号查询离您最近的一个办理点。【APP】如果您只想使用手机APP，可直接通过http://yjt.189.cn下载并注册企业，设置通信录，将企业内的相关人员加入使用。即使您不是中国电信的手机用户，也可以使用APP。 【手机的话费和“翼机通 ”账户余额】开通“翼机通 ”业务后，“翼机通 ”使用的是和话费独立的电子账户，和话费无关。  如您的问题尚未解答，请您致电4008989993，客服将为您专程答疑解惑。','2015-10-25 08:13:15'),(3,1,'4','查看考勤记录','1','两种方式可以查看公司的考勤情况： （1）点击工作台进入企业管理，点击企业成员列表，点击成员名称查看个人考勤记录。 （2）点击工作台进入企业管理，点击考勤报表，下载到手机或者发送到邮箱。考勤记录如果出现如下情况： 【无效打卡记录】表明员工未在有效区域刷手机签到，就会显示打卡无效。 【考勤结果未计算】可能原因：当日考勤结果要在次日才能计算出来、企业管理员未设置关联的考勤规则、企业管理员未设置考勤区域与员工的关联  如您的问题尚未解答，请您致电4008989993，客服人员将为您专程答疑解惑。','2015-10-25 08:14:35'),(4,1,'5','企业管理门户登录及配置','1','【登录】企业管理员可以通过PC机通过登录翼机通 官网：http://yjt.189.cn/，点击企业管理员登录进入。 【配置】企业管理门户相比手机客户端，提供更全面和更复杂的配置操作功能。 【部门设置】管理员登陆pc门户管理员后台，进入组织架构，选定企业，点击添加子部门，输入部门名称，保存成功后，选定部门，点击管理部门成员，把人员添加到该部门里面，部门就设立成功了。 如您的问题尚未解答，请您致电4008989993，客服人员将为您专程答疑解惑。','2015-10-25 08:15:01'),(5,1,'6','设置考勤区域','1','两种方法： (1)采用APP设置：点击工作台进入企业管理，点击考勤设置添加考勤区域，输入名称，选择位置，选择签到范围，确定保存提交。(2)采用PC设置：通过pc登陆企业管理后台，进入考勤设置，考勤区域，点击添加考勤区域，输入区域名称，搜索位置，填写范围，保存，考勤区域设置成功。 考勤区域设置好后，需要设置该考勤区域对应的成员。点击管理考勤区域成员，屏幕上会显示企业职员列表，点中要添加的员工姓名，点击添加，该员工就进入已添加成员列表，点击保存就设置成功了。 如您的问题尚未解答，请您致电4008989993，客服人员将为您专程答疑解惑。','2015-10-25 08:15:18'),(6,1,'7','考勤规则中\"班组\"、\"班次\"、\"班段\"的设置','1','【班次】班次可分为不同的班次，可以设置一个或多个。 登陆企业管理后台进入考勤设置，点击添加考勤班次，输入班次名称，选择班次类型，保存即可。选定班次可实现添加修改和删除。 如您的问题尚未解答，请您致电4008989993，客服将为您专程答疑解惑。【班组】班组可设置多个班组，把成员分到不同的班组中。 登陆企业管理后台进入考勤设置，点击添加考勤班组，输入班组名称保存即可。选定班组点击管理考勤班组成员，可实现该班组成员添加修改和删除。 【班段】班段可设置不同的上班时间段同时存在。 登陆企业管理后台进入考勤设置，点击添加考勤班段，输入班段名称，选择班类型、上下班时间保存即可。选定班段可添加修改和删除。','2015-10-25 08:16:53'),(7,1,'8','设置考勤规则','1','管理员通过pc登陆企业管理后台，点击考勤设置，分别设置考勤区域、考勤班次、考勤班段、考勤规则等。选定考勤规则可对其进行修改和删除。  如您的问题尚未解答，请您致电4008989993，客服将为您专程答疑解惑。','2015-10-25 08:17:18'),(8,2,'1','加入企业','0','点击左上角的人像，点击企业列表，进入创建或加入企业，输入企业名称，下面会弹出自己要找的企业，点击进入，选择加入企业，等待企业管理员审核通过就可以了。 如您的问题尚未解答，请您致电4008989993，客服将为您专程答疑解惑。','2015-10-26 03:28:04'),(9,2,'2','填写推荐人','1','注册的填写推荐人目前尚未有福利赠送。以后会考虑通过多种方式给推荐人予以奖励。  如您的问题尚未解答，请您致电4008989993，客服将为您专程答疑解惑。','2015-10-25 08:42:44'),(10,2,'3','定位考勤','1','【功能】可以提供考勤、消费、门禁等线下功能，并通过手机客户端实现通信录、任务、电子公告等线上业务功能，客户结合自身情况可使用其中的部分功能。 【优势】以手机为载体，一部手机即可实现门禁考勤、小额消费等活动，方便了用户的生活，免除了携带各种证件的麻烦；同时，用户可以通过手机客户端实时查询考勤消费信息，还可以进行实时任务派发，发布/获取通知、公告、会议信息等。 【开通】企业客户可携带企业的有效证件和有效身份证件到电信营业厅办理，也可通过当地电信的客户经理进行业务办理。建议您前往办理前，先拨打当地电信客服热线10000号查询离您最近的一个办理点。【APP】如果您只想使用手机APP，可直接通过http://yjt.189.cn下载并注册企业，设置通信录，将企业内的相关人员加入使用。即使您不是中国电信的手机用户，也可以使用APP。 【手机的话费和“翼机通 ”账户余额】开通“翼机通 ”业务后，“翼机通 ”使用的是和话费独立的电子账户，和话费无关。  如您的问题尚未解答，请您致电4008989993，客服将为您专程答疑解惑。','2015-10-25 08:43:39'),(11,2,'4','标签考勤','1','使用标签考勤需要是中国电信NFC手机，具体手机型号列表可以参见http://nfc.189.cn/；不支持NFC功能的手机也可以通过刷标签上的二维码实现考勤。 即使您使用的不是NFC手机，可以通过扫描标签上的二维码实现考勤，也可以使用定位考勤。  如果您是果粉，抱歉，Iphone6虽然支持NFC功能，但其功能未向外部应用开放。Iphone6可以使用定位考勤和扫码考勤。 如您的问题尚未解答，请您致电4008989993，客服将为您专程答疑解惑。','2015-10-25 08:44:05');
/*!40000 ALTER TABLE `t_subcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `role` char(255) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-08 17:11:08
