DROP TABLE IF EXISTS test_user;
CREATE TABLE test_user (
  userid varchar(32) DEFAULT NULL,
  username varchar(50) DEFAULT NULL,
  age int(11) DEFAULT NULL,
  createtime timestamp NULL DEFAULT CURRENT_TIMESTAMP
);