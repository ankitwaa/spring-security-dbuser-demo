INSERT INTO authorities(username, authority) VALUES ('john', 'write');
INSERT INTO users(username, password, enabled) VALUES ('john', '12345', '1');
INSERT INTO authorities(username, authority) VALUES ('ankit', 'read');
INSERT INTO users(username, password, enabled) VALUES ('ankit', 'ankit', '1');
commit;