INSERT INTO section(user_id, section_name) VALUES(2, '日常メモ');
INSERT INTO section(user_id, section_name) VALUES(2, '技術関連');
INSERT INTO page(section_id, page_name, page_path) VALUES(1, 'myholiday', '/pwds/');
INSERT INTO page(section_id, page_name, page_path) VALUES(1, 'セキュリティ', '/sec/');
INSERT INTO page(section_id, page_name, page_path) VALUES(2, 'java', '/ddd/');
INSERT INTO page(section_id, page_name, page_path) VALUES(2, 'Xml', '/xxxx/');
INSERT INTO page(section_id, page_name, page_path) VALUES(2, 'Xml', '111');

delete from auth_master;
INSERT INTO auth_master (phone_number) VALUES('13332247026');