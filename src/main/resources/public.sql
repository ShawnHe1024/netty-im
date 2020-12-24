/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : PostgreSQL
 Source Server Version : 130000
 Source Host           : localhost:5432
 Source Catalog        : private_chat
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 130000
 File Encoding         : 65001

 Date: 04/12/2020 18:52:11
*/


-- ----------------------------
-- Table structure for sys_message
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_message";
CREATE TABLE "public"."sys_message" (
  "id" int8 NOT NULL,
  "sender" int8 NOT NULL,
  "receiver" int8 NOT NULL,
  "content" varchar(256) COLLATE "pg_catalog"."default" NOT NULL,
  "type" int2 NOT NULL,
  "send_time" timestamptz(0) NOT NULL,
  "del_flag" bool
)
;
COMMENT ON COLUMN "public"."sys_message"."id" IS '主键';
COMMENT ON COLUMN "public"."sys_message"."sender" IS '发送人';
COMMENT ON COLUMN "public"."sys_message"."receiver" IS '接收人';
COMMENT ON COLUMN "public"."sys_message"."content" IS '内容';
COMMENT ON COLUMN "public"."sys_message"."type" IS '消息类型';
COMMENT ON COLUMN "public"."sys_message"."send_time" IS '发送时间';
COMMENT ON COLUMN "public"."sys_message"."del_flag" IS '删除标识';

-- ----------------------------
-- Records of sys_message
-- ----------------------------
INSERT INTO "public"."sys_message" VALUES (1332569943849021442, 1606544401654, 1606544339261, 'gchcycuc', 1, '2020-11-28 14:20:05+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332572851793473537, 1606545092281, 1606545041394, 'hcjcucic', 1, '2020-11-28 14:31:39+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332572981078700034, 1606545041394, 1606545092281, '哈哈哈', 1, '2020-11-28 14:32:11+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332573444620595202, 1606545092281, 1606545041394, '583838383', 1, '2020-11-28 14:34:01+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332573530440249346, 1606545041394, 1606545092281, '顺序反了', 1, '2020-11-28 14:34:22+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332573641689968641, 1606545041394, 1606545092281, '111', 1, '2020-11-28 14:34:49+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332577419877068802, 1606546175613, 1606545041394, 'ufufuc', 1, '2020-11-28 14:49:49+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332577489460572161, 1606545041394, 1606545092281, '哈哈哈', 1, '2020-11-28 14:50:06+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332589016230047745, 1606545041394, 1606548933133, 'aaa', 1, '2020-11-28 15:35:54+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332589199110090753, 1606548933133, 1606545041394, 'fgg', 1, '2020-11-28 15:36:37+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332589244618289154, 1606548933133, 1606545041394, '回来了', 1, '2020-11-28 15:36:48+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332589361236717570, 1606545041394, 1606548933133, '对啊', 1, '2020-11-28 15:37:17+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332592013202862082, 1606548933133, 1606545041394, '回来准备做什么', 1, '2020-11-28 15:47:48+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332592114839236609, 1606545041394, 1606548933133, '还没想好呢', 1, '2020-11-28 15:48:13+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332592191259455489, 1606545041394, 1606548933133, '你呢，现在在做什么', 1, '2020-11-28 15:48:31+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332592241242976257, 1606548933133, 1606545041394, '我还不是天天打酱油', 1, '2020-11-28 15:48:42+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332592444545085442, 1606548933133, 1606545041394, '好吧', 1, '2020-11-28 15:49:31+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332592489596104706, 1606548933133, 1606545041394, '我觉得去开个店不错', 1, '2020-11-28 15:49:41+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332592501335961602, 1606548933133, 1606545041394, '你说呢', 1, '2020-11-28 15:49:44+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332592568058949633, 1606545041394, 1606548933133, '我觉得ojbk', 1, '2020-11-28 15:50:01+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332592639852851202, 1606545041394, 1606548933133, '挺好的', 1, '2020-11-28 15:50:18+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332592690603929602, 1606548933133, 1606545041394, '确实舒服啊', 1, '2020-11-28 15:50:29+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332593290880135170, 1606549964731, 1606545041394, '哈哈哈，我又回来了', 1, '2020-11-28 15:52:52+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332593402264072194, 1606545041394, 1606549964731, '欢迎欢迎', 1, '2020-11-28 15:53:20+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332597620362358786, 1606549964731, 1606545041394, '谢谢', 1, '2020-11-28 16:10:04+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332597635356995585, 1606549964731, 1606545041394, '你在干嘛呢', 1, '2020-11-28 16:10:08+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332597665555984385, 1606549964731, 1606545041394, '塞尔达好玩吗', 1, '2020-11-28 16:10:15+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332597680823250945, 1606549964731, 1606545041394, '太好玩了我的天', 1, '2020-11-28 16:10:19+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332597694618316801, 1606549964731, 1606545041394, '强烈安利', 1, '2020-11-28 16:10:22+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332597724188160001, 1606549964731, 1606545041394, '非常推荐你玩', 1, '2020-11-28 16:10:29+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332598589179473922, 1606549964731, 1606545041394, '特别好玩的游戏', 1, '2020-11-28 16:13:55+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332603850313084930, 1606549964731, 1606545041394, '呵呵了我就', 1, '2020-11-28 16:34:50+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332605530047950850, 1606549964731, 1606545041394, '哈哈哈', 1, '2020-11-28 16:41:30+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334777910618939394, 1328273287825465346, 1328280802986496001, '呵呵了', 1, '2020-12-04 16:33:46+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332577705182015489, 1328280802986496001, 1328273287825465346, '哈哈哈', 1, '2020-11-28 14:50:58+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332577725901877249, 1328273287825465346, 1328280802986496001, 'hcufu', 1, '2020-11-28 14:51:02+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332577757237522434, 1328273287825465346, 1328280802986496001, '服服服', 1, '2020-11-28 14:51:09+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332578035722530817, 1328273287825465346, 1328280802986496001, '我真是醉了', 1, '2020-11-28 14:52:15+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332578112922890241, 1328280802986496001, 1328273287825465346, '我也是啊，竟然还有UTF8的问题', 1, '2020-11-28 14:52:35+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332578178559553537, 1328273287825465346, 1328280802986496001, '对啊对啊', 1, '2020-11-28 14:52:50+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332578227121205249, 1328280802986496001, 1328273287825465346, '佛了', 1, '2020-11-28 14:53:02+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1332582853023281153, 1328273287825465346, 1328280802986496001, '发个表情试试😁😁😁', 1, '2020-11-28 15:11:24+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334448492448980994, 1328273287825465346, 1328280802986496001, '哈哈哈', 1, '2020-12-03 18:44:48+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334449009300480001, 1328273287825465346, 1328280802986496001, '嗨嗨嗨', 1, '2020-12-03 18:46:51+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334450176352985089, 1328273287825465346, 1328280802986496001, '哈哈', 1, '2020-12-03 18:51:29+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334450402555994113, 1328273287825465346, 1328280802986496001, '干嘛呢', 1, '2020-12-03 18:52:23+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334451146180927489, 1328273287825465346, 1328280802986496001, '嘿嘿', 1, '2020-12-03 18:55:21+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334451456546840577, 1328273287825465346, 1328280802986496001, '哈哈', 1, '2020-12-03 18:56:35+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334451483419746305, 1328273287825465346, 1328280802986496001, '好不好', 1, '2020-12-03 18:56:41+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334451514524704769, 1328273287825465346, 1328280802986496001, '够刺激', 1, '2020-12-03 18:56:48+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334451541045288961, 1328273287825465346, 1328280802986496001, '舒服了', 1, '2020-12-03 18:56:55+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334451573374984194, 1328273287825465346, 1328280802986496001, '测试测试', 1, '2020-12-03 18:57:03+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334451614298808321, 1328273287825465346, 1328280802986496001, '再来', 1, '2020-12-03 18:57:12+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334451625971556353, 1328273287825465346, 1328280802986496001, '继续继续', 1, '2020-12-03 18:57:15+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334451643084316674, 1328273287825465346, 1328280802986496001, '不够不够', 1, '2020-12-03 18:57:19+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334452681761759234, 1328273287825465346, 1328280802986496001, '继续测试', 1, '2020-12-03 19:01:27+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334452694260785154, 1328273287825465346, 1328280802986496001, '继续继续', 1, '2020-12-03 19:01:30+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334452707632226306, 1328273287825465346, 1328280802986496001, '再来再来', 1, '2020-12-03 19:01:33+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334452718063460354, 1328273287825465346, 1328280802986496001, '哈哈哈哈', 1, '2020-12-03 19:01:35+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334452732533809154, 1328273287825465346, 1328280802986496001, '嘿嘿嘿嘿', 1, '2020-12-03 19:01:39+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334452753182367746, 1328273287825465346, 1328280802986496001, '哼哼哼哼', 1, '2020-12-03 19:01:44+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334452768873259010, 1328273287825465346, 1328280802986496001, '呵呵呵呵', 1, '2020-12-03 19:01:48+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334702221882482689, 1328273287825465346, 1328280802986496001, '哈哈', 1, '2020-12-04 11:33:02+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334703645563478018, 1328273287825465346, 1328280802986496001, '呵呵', 1, '2020-12-04 11:38:41+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334713218999443458, 1328273287825465346, 1328280802986496001, '嘿嘿', 1, '2020-12-04 12:16:43+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334752831327625218, 1328280802986496001, 1328273287825465346, '哈哈哈', 1, '2020-12-04 14:54:07+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334756817317322754, 1328273287825465346, 1328280802986496001, '呵呵了我就', 1, '2020-12-04 15:09:57+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334758261256806401, 1328273287825465346, 1328280802986496001, '哈哈', 1, '2020-12-04 15:15:42+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334758278931603457, 1328273287825465346, 1328280802986496001, '你是傻子吗', 1, '2020-12-04 15:15:46+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334758295339720706, 1328273287825465346, 1328280802986496001, '我不够', 1, '2020-12-04 15:15:50+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334758311496179713, 1328273287825465346, 1328280802986496001, '再试试', 1, '2020-12-04 15:15:54+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334758345285492738, 1328273287825465346, 1328280802986496001, '不信你就试试', 1, '2020-12-04 15:16:02+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334758366961655809, 1328273287825465346, 1328280802986496001, '我前不信', 1, '2020-12-04 15:16:07+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334770614203506689, 1328273287825465346, 1328280802986496001, '哈哈', 1, '2020-12-04 16:04:47+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334773835554807809, 1328273287825465346, 1328280802986496001, '哈哈', 1, '2020-12-04 16:17:34+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334773848997552130, 1328273287825465346, 1328280802986496001, '好像可以了', 1, '2020-12-04 16:17:38+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334773861081341954, 1328273287825465346, 1328280802986496001, '我再试试', 1, '2020-12-04 16:17:41+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334773875824320513, 1328273287825465346, 1328280802986496001, '😁😁😁', 1, '2020-12-04 16:17:44+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334773882715561986, 1328273287825465346, 1328280802986496001, '😅😅😅', 1, '2020-12-04 16:17:46+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334773890743459841, 1328273287825465346, 1328280802986496001, '🤣🤣🤣', 1, '2020-12-04 16:17:48+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334778622727872514, 1328280802986496001, 1328273287825465346, '干嘛呢?', 1, '2020-12-04 16:36:37+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334778650775183361, 1328273287825465346, 1328280802986496001, '你说呢', 1, '2020-12-04 16:36:42+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334779758830608385, 1328280802986496001, 1328273287825465346, '我不说', 1, '2020-12-04 16:41:08+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334779783065296897, 1328273287825465346, 1328280802986496001, '呵呵', 1, '2020-12-04 16:41:12+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334779799918010370, 1328273287825465346, 1328280802986496001, '我去', 1, '2020-12-04 16:41:16+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334796673875632130, 1328273287825465346, 1328280802986496001, '测试', 1, '2020-12-04 17:48:19+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334797656684945410, 1328273287825465346, 1328280802986496001, '呵呵', 1, '2020-12-04 17:52:13+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334797669376909313, 1328273287825465346, 1328280802986496001, '哈哈', 1, '2020-12-04 17:52:17+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334797716034347009, 1328273287825465346, 1328280802986496001, '嘿嘿', 1, '2020-12-04 17:52:28+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334797726239088641, 1328273287825465346, 1328280802986496001, '555', 1, '2020-12-04 17:52:30+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334797735521083394, 1328273287825465346, 1328280802986496001, '333', 1, '2020-12-04 17:52:32+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334797743565758466, 1328273287825465346, 1328280802986496001, '6666', 1, '2020-12-04 17:52:34+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334797756979142657, 1328273287825465346, 1328280802986496001, '999', 1, '2020-12-04 17:52:37+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334797764348534785, 1328273287825465346, 1328280802986496001, '666', 1, '2020-12-04 17:52:39+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334797769373310978, 1328273287825465346, 1328280802986496001, '333', 1, '2020-12-04 17:52:40+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334797775807373314, 1328273287825465346, 1328280802986496001, '5555', 1, '2020-12-04 17:52:42+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334797781205442561, 1328273287825465346, 1328280802986496001, '333', 1, '2020-12-04 17:52:43+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334798875834900482, 1328280802986496001, 1328273287825465346, 'woxinnigegui', 1, '2020-12-04 17:57:06+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334798955207909378, 1328280802986496001, 1328273287825465346, '你个糟老头子坏得很', 1, '2020-12-04 17:57:25+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334802912449847298, 1328273287825465346, 1328280802986496001, '嘿嘿', 1, '2020-12-04 18:13:06+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334803026916597761, 1328273287825465346, 1328280802986496001, '测试下', 1, '2020-12-04 18:13:34+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334803039705030657, 1328273287825465346, 1328280802986496001, '再来', 1, '2020-12-04 18:13:37+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334803051063205889, 1328273287825465346, 1328280802986496001, '哈哈', 1, '2020-12-04 18:13:40+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334803111977082881, 1328280802986496001, 1328273287825465346, '你好啊', 1, '2020-12-04 18:13:56+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334803149511909378, 1328280802986496001, 1328273287825465346, '大sb', 1, '2020-12-04 18:14:05+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334803180549758978, 1328273287825465346, 1328280802986496001, '你放屁', 1, '2020-12-04 18:14:10+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334803210761330690, 1328273287825465346, 1328280802986496001, '在骂人老子打死你', 1, '2020-12-04 18:14:18+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334803249848049665, 1328280802986496001, 1328273287825465346, 'nihaokuanga', 1, '2020-12-04 18:14:29+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334803268630142977, 1328273287825465346, 1328280802986496001, '说人话', 1, '2020-12-04 18:14:31+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334803286866976770, 1328273287825465346, 1328280802986496001, '看不懂你这', 1, '2020-12-04 18:14:36+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334803334233251841, 1328280802986496001, 1328273287825465346, '你是智障', 1, '2020-12-04 18:14:49+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334803402562658306, 1328280802986496001, 1328273287825465346, '智障就看不懂', 1, '2020-12-04 18:15:05+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334803438629478402, 1328273287825465346, 1328280802986496001, '你再骂？？？', 1, '2020-12-04 18:15:12+08', NULL);
INSERT INTO "public"."sys_message" VALUES (1334812250736353282, 1328273287825465346, 1328280802986496001, '嘿嘿', 1, '2020-12-04 18:50:13+08', NULL);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user";
CREATE TABLE "public"."sys_user" (
  "id" int8 NOT NULL,
  "username" varchar(16) COLLATE "pg_catalog"."default",
  "nickname" varchar(16) COLLATE "pg_catalog"."default",
  "password" varchar(32) COLLATE "pg_catalog"."default",
  "avatar" varchar(128) COLLATE "pg_catalog"."default",
  "create_time" timestamptz(0),
  "del_flag" bool
)
;
COMMENT ON COLUMN "public"."sys_user"."id" IS '主键';
COMMENT ON COLUMN "public"."sys_user"."username" IS '用户名';
COMMENT ON COLUMN "public"."sys_user"."nickname" IS '昵称';
COMMENT ON COLUMN "public"."sys_user"."password" IS '密码';
COMMENT ON COLUMN "public"."sys_user"."avatar" IS '头像';
COMMENT ON COLUMN "public"."sys_user"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_user"."del_flag" IS '删除标识';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO "public"."sys_user" VALUES (1328273287825465346, 'hx', '何湘', '123', '', '2020-11-16 17:46:45+08', 'f');
INSERT INTO "public"."sys_user" VALUES (1328280802986496001, 'wwy', 'wwy', '123', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3065335715,4197701299&fm=26&gp=0.jpg', '2020-11-16 18:16:36+08', 'f');

-- ----------------------------
-- Table structure for user_relationship
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_relationship";
CREATE TABLE "public"."user_relationship" (
  "id" int8 NOT NULL,
  "inviter" int8,
  "invitee" int8,
  "create_time" timestamptz(6),
  "del_flag" bool
)
;
COMMENT ON COLUMN "public"."user_relationship"."id" IS '主键';
COMMENT ON COLUMN "public"."user_relationship"."inviter" IS '邀请人';
COMMENT ON COLUMN "public"."user_relationship"."invitee" IS '被邀请人';
COMMENT ON COLUMN "public"."user_relationship"."create_time" IS '邀请时间';
COMMENT ON COLUMN "public"."user_relationship"."del_flag" IS '删除关系标识';

-- ----------------------------
-- Records of user_relationship
-- ----------------------------
INSERT INTO "public"."user_relationship" VALUES (1, 1328273287825465346, 1328280802986496001, '2020-11-30 17:16:35+08', 'f');
INSERT INTO "public"."user_relationship" VALUES (2, 1328280802986496001, 1328273287825465346, NULL, 'f');

-- ----------------------------
-- Indexes structure for table sys_message
-- ----------------------------
CREATE INDEX "index_message_senderANDrecevier" ON "public"."sys_message" USING btree (
  "sender" "pg_catalog"."int8_ops" ASC NULLS LAST,
  "receiver" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table sys_message
-- ----------------------------
ALTER TABLE "public"."sys_message" ADD CONSTRAINT "sys_message_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_user
-- ----------------------------
ALTER TABLE "public"."sys_user" ADD CONSTRAINT "sys_user_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user_relationship
-- ----------------------------
CREATE UNIQUE INDEX "index_user_relationship_unique" ON "public"."user_relationship" USING btree (
  "inviter" "pg_catalog"."int8_ops" ASC NULLS LAST,
  "invitee" "pg_catalog"."int8_ops" ASC NULLS LAST
);
COMMENT ON INDEX "public"."index_user_relationship_unique" IS '关系唯一';

-- ----------------------------
-- Primary Key structure for table user_relationship
-- ----------------------------
ALTER TABLE "public"."user_relationship" ADD CONSTRAINT "user_relationship_pkey" PRIMARY KEY ("id");