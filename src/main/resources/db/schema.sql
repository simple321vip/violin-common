create TABLE IF NOT EXISTS `auth_master`(
   `phone_number` CHAR(20) NOT NULL,
   PRIMARY KEY ( `phone_number` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create TABLE IF NOT EXISTS `g_user`(
   `user_id` CHAR(20) NOT NULL,
   `user_name` VARCHAR(100) NOT NULL,
   `user_password` VARCHAR(40) NOT NULL,
   `create_date` DATE,
   PRIMARY KEY ( `user_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table IF EXISTS bookmark;
create table bookmark(
         bk_id long primary key AUTO_INCREMENT,
         bk_type_id long default 0 not null,
         comment varchar(25) default '' not null,
         delete_flg char(1) default '0' not null,
         url varchar(250)
  );

drop table IF EXISTS bookmark_type;
create table bookmark_type(
         bk_type_id long primary key AUTO_INCREMENT,
         bk_type_name char(20) default '' not null
  );
drop table IF EXISTS section;
create table section(
         section_id long primary key AUTO_INCREMENT,
         user_id long default 0 not null,
         section_name char(20) default '未分类' not null
  );

drop table IF EXISTS page;
create table page(
         page_id long primary key AUTO_INCREMENT,
         section_id long default 0 not null,
         page_name char(20) default '未分类' not null,
         page_path char(20) default '' not null
  );
drop table IF EXISTS t_blog;
create table t_blog(
         blog_id CHAR(16) primary key,
         blog_type_id CHAR(16) default '' not null,
         blog_title char(20) default '' not null,
         blog_prex char(250) default '' not null,
         delete_flg char(1) default '0' not null,
         blog_text_path char(250) default '' not null,
         updater_id CHAR(20) default '' not null,
         update_time DATETIME default CURRENT_TIMESTAMP not null
  );

drop table IF EXISTS blog_type;
create table blog_type(
         blog_type_id CHAR(16) primary key,
         blog_type_name char(20) default '' not null,
         updater_id CHAR(20) default '' not null,
         update_time DATETIME default CURRENT_TIMESTAMP not null
  );
drop table IF EXISTS t_blog_seq;
create table t_blog_seq (
    blog_seq_id INT primary key AUTO_INCREMENT NOT NULL
  );
drop table IF EXISTS t_blog_type_seq;
create table t_blog_type_seq (
    blog_type_seq_id INT primary key AUTO_INCREMENT NOT NULL
  );
drop table IF EXISTS t_bookmark_seq;
create table t_bookmark_seq (
    bk_seq_id INT primary key AUTO_INCREMENT NOT NULL
  );
drop table IF EXISTS t_blog_seq;
create table t_blog_seq (
    blog_seq_id INT primary key AUTO_INCREMENT NOT NULL
  );

