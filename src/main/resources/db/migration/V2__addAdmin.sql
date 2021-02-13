insert into usr(id, is_active, login, password)
    values (1, true, 'admin', '12345');
insert into user_role(user_id , roles)
    values (1, 'ADMIN'), (1, 'USER');