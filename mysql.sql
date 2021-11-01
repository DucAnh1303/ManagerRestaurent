create table project.customers
(
    id           int auto_increment
        primary key,
    cus_name     varchar(45)                          not null,
    address      varchar(255)                         null,
    email        varchar(255)                         null,
    phone        varchar(45)                          not null,
    descriptions varchar(45)                          not null,
    created_at   datetime default current_timestamp() null
);

create table project.food_menu
(
    id         int auto_increment
        primary key,
    food_name  varchar(45)  not null,
    food_price int          not null,
    food_image varchar(500) null
);

create table project.orders
(
    id          int auto_increment
        primary key,
    cus_id      int                                  not null,
    sum_food    int      default 0                   null,
    numbers     int      default 0                   null,
    total_price int      default 0                   null,
    created_at  datetime default current_timestamp() null,
    constraint orders_customers_id
        foreign key (cus_id) references project.customers (id)
);

create table project.ordersdetails
(
    id          int auto_increment
        primary key,
    cus_name    varchar(255)                         null,
    email       varchar(45)                          null,
    phone       varchar(255)                         null,
    orders_id   int                                  not null,
    food_id     int                                  not null,
    numbers     int(100)                             not null,
    price       int(100)                             null,
    total_price int(100)                             null,
    created_at  datetime default current_timestamp() null,
    constraint ordersdetails_food_id
        foreign key (food_id) references project.food_menu (id),
    constraint ordersdetails_orders_id
        foreign key (orders_id) references project.customers (id)
);

create table project.product
(
    id           int auto_increment
        primary key,
    product_name varchar(255)                         null,
    numbers      int                                  null,
    product_type varchar(255)                         null,
    created_at   datetime default current_timestamp() null
);

create table project.productdetails
(
    id           int auto_increment
        primary key,
    product_name varchar(45)                          null,
    numbers      int(100)                             null,
    product_type varchar(255)                         null,
    price        int(100)                             not null,
    total_price  int(100)                             null,
    place_import varchar(45)                          not null,
    item_code    int                                  not null,
    created_at   datetime default current_timestamp() null,
    constraint productdetails_item_code
        foreign key (item_code) references project.product (id)
);

create table project.promotion
(
    id           int auto_increment
        primary key,
    descriptions varchar(255)                         not null,
    apply        varchar(45)                          not null,
    created_at   datetime default current_timestamp() null
);

create table project.user_login
(
    id       int auto_increment
        primary key,
    username varchar(255) not null,
    password varchar(255) not null
);

create table project.employee
(
    id            int auto_increment
        primary key,
    name          varchar(255)                         not null,
    address       varchar(255)                         not null,
    phone         varchar(255)                         not null,
    contract_date varchar(45)                          not null,
    contract_work varchar(45)                          not null,
    position      varchar(45)                          not null,
    created_at    datetime default current_timestamp() null,
    user_login_id int                                  not null,
    constraint employee_user_id
        foreign key (user_login_id) references project.user_login (id)
);

create table project.employee_salary
(
    id              int auto_increment
        primary key,
    employee_code   int                                       not null,
    employee_name   varchar(45)                               null,
    position        varchar(45)                               null,
    workday         int(2)        default 0                   null,
    fullday         int(2)                                    not null,
    offday          int(2)        default 0                   null,
    hard_salary     int                                       not null,
    position_salary double(11, 2) default 0.00                null,
    overtime        int(3)        default 0                   null,
    worktime        int(1)                                    not null,
    bonus           int           default 0                   null,
    minus_salary    double(14, 2) default 0.00                null,
    total_salary    double(15, 3) default 0.000               null,
    created_at      datetime      default current_timestamp() null,
    constraint employee_salary_employee_code
        foreign key (employee_code) references project.employee (id)
);


