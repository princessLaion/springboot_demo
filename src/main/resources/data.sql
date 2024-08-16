insert into user_details (id, birth_Date, name, confidential_data)
values (100001, current_date(), 'John Smith', 'yale');

insert into user_details (id, birth_Date, name, confidential_data)
values (100002, current_date(), 'Jane Smith', 'harvard');

insert into post (id, user_id, message)
values (111112, 100002, 'Hello World, First Post');

insert into post (id, user_id, message)
values (111113, 100002, 'Hello World, Second Post');

