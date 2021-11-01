create table customers
(
    id           serial       not null
        constraint customers_pk
            primary key,
    cus_name     varchar(255) not null,
    address      varchar(255) not null,
    email        varchar(255) not null,
    phone        varchar(255) not null,
    descriptions varchar(255) not null,
    created_at   timestamp default now()
);

alter table customers
    owner to vnryrqhkmcwehp;

create table employee
(
    id            serial       not null
        constraint employee_pk
            primary key,
    name          varchar(255) not null,
    address       varchar(255) not null,
    phone         varchar(255) not null,
    contract_date varchar(45)  not null,
    contract_work varchar(45)  not null,
    position      varchar(45)  not null,
    created_at    timestamp default now(),
    user_login_id integer
);

alter table employee
    owner to vnryrqhkmcwehp;

create table employee_salary
(
    id              serial                     not null
        constraint employee_salary_pk
            primary key,
    employee_code   integer
        constraint employee_code_id
            references employee,
    employee_name   varchar(45),
    position        integer,
    workday         integer,
    fullday         integer                    not null,
    offday          integer,
    hard_salary     integer                    not null,
    position_salary double precision default 0 not null,
    overtime        integer,
    worktime        integer                    not null,
    bonus           integer          default 0,
    minus_salary    timestamp        default now()
);

alter table employee_salary
    owner to vnryrqhkmcwehp;

create table food_menu
(
    id         serial      not null
        constraint food_menu_pk
            primary key,
    food_name  varchar(45) not null,
    food_price integer     not null,
    food_image varchar(500)
);

alter table food_menu
    owner to vnryrqhkmcwehp;

create table orders
(
    id          serial  not null
        constraint orders_pk
            primary key,
    cus_id      integer not null
        constraint orders__cus_id
            references customers,
    sum_food    integer   default 0,
    numbers     integer   default 0,
    total_price integer   default 0,
    created_at  timestamp default now()
);

alter table orders
    owner to vnryrqhkmcwehp;

create table ordersdetails
(
    id          serial  not null
        constraint ordersdetails_pk
            primary key,
    cus_name    varchar(255),
    column_3    integer,
    email       varchar(45),
    phone       varchar(255),
    orders_id   integer not null
        constraint ordersdetails_order_id
            references customers,
    food_id     integer not null
        constraint ordersdetails_food_id
            references food_menu,
    numbers     integer not null,
    price       integer,
    total_price integer,
    created_at  integer
);

alter table ordersdetails
    owner to vnryrqhkmcwehp;

create table product
(
    id           serial       not null
        constraint product_pk
            primary key,
    product_name varchar(255) not null,
    numbers      integer      not null,
    product_type integer      not null,
    created_at   timestamp default now()
);

alter table product
    owner to vnryrqhkmcwehp;

create table productdetails
(
    id           serial  not null
        constraint productdetails_pk
            primary key,
    product_name varchar(45),
    numbers      integer,
    product_type varchar(255),
    price        integer not null,
    total_price  integer,
    item_code    integer not null
        constraint productdetails_code_id
            references product,
    created_at   timestamp default now()
);

alter table productdetails
    owner to vnryrqhkmcwehp;

create table promotion
(
    id           serial       not null
        constraint promotion_pk
            primary key,
    descriptions varchar(255) not null,
    apply        varchar(45)  not null,
    created_at   timestamp default now()
);

alter table promotion
    owner to vnryrqhkmcwehp;

create table user_login
(
    username varchar(255) not null,
    password varchar(255) not null
);

alter table user_login
    owner to vnryrqhkmcwehp;


