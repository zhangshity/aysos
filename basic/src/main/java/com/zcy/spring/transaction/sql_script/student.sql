truncate table student;

select * from student;

        CREATE TABLE student (
            id int(11) NOT NULL AUTO_INCREMENT,
            name varchar(255) DEFAULT NULL,
            age int(11) DEFAULT NULL,
            create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
            version int(11) NOT NULL DEFAULT 0,
            PRIMARY KEY (id)
        )

create table op_test.student
(
	id int auto_increment
		primary key,
	name varchar(255) null,
	age int null,
	create_time timestamp default CURRENT_TIMESTAMP not null,
	version int default 0 not null
);

-- MySql Group by 测试
select id, name, age, count(*)
from student
group by age
order by age desc
