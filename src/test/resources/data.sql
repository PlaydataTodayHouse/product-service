drop table if exists brands cascade;
drop table if exists products cascade;
drop table if exists options cascade;
drop table if exists option_details cascade;
drop table if exists reviews cascade;


create table brands
(
    id                 bigint auto_increment primary key,
    review_count       int          null,
    star               double       null,
    brand_name         varchar(30)  not null,
    brand_introduction varchar(100) not null,
    brand_image_url    varchar(255) not null
);

create table products
(
    id                          bigint auto_increment      primary key,
    category_id                 varchar(8)               not null,
    discount_rate               int                        null,
    is_selling                  bit                        null,
    is_sold_out                 bit                        null,
    original_price              int                        not null,
    purchase_count              int                        null,
    review_avg                  double                     null,
    review_count                int                        null,
    sales_count                 int                        null,
    total_quantity              int                        not null,
    wish_count                  int                        null,
    brand_id                    bigint                     not null,
    created_at                  datetime(6)                not null,
    modified_at                 datetime(6)                not null,
    product_name                varchar(50)                not null,
    company                     varchar(255)               not null,
    company_registration_number varchar(255)               not null,
    delivery                    enum ('EXPRESS', 'NORMAL') not null,
    product_image_url           varchar(255)               not null,
    product_content             tinytext                   not null,
    constraint fk_product_brand foreign key (brand_id) references brands (id)
);

create table options
(
    id          bigint auto_increment primary key,
    is_required bit         null,
    product_id  bigint      not null,
    option_name varchar(20) not null,
    constraint fk_option_product
        foreign key (product_id) references products (id)
);

create table option_details
(
    id            bigint auto_increment primary key,
    is_sold_out   bit         null,
    option_price  int         null,
    quantity      int         null,
    option_id     bigint      not null,
    option_detail varchar(30) not null,
    constraint fk_option_detail_option
        foreign key (option_id) references options (id)
);

create table reviews
(
    star_grade          int          not null,
    created_at          datetime(6)  not null,
    id                  bigint auto_increment primary key,
    modified_at         datetime(6)  not null,
    product_id          bigint       not null,
    review_content      varchar(300) not null,
    product_option_name varchar(255) not null,
    review_image_url    varchar(255) null,
    constraint fk_review_product
        foreign key (product_id) references products (id)
);

insert into brands(id, review_count, star, brand_name, brand_introduction, brand_image_url)
    values (1, 0, 4.2, '삼성전자', '삼성전자 소개', 'https://cdn.pixabay.com/photo/2016/11/29/05/45/astronomy-1867616_960_720.jpg'),
           (2, 3, 1.5, 'LG전자', 'LG전자 소개', 'https://cdn.pixabay.com/photo/2016/11/29/05/45/astronomy-1867616_960_720.jpg'),
           (3, 1, 0, '리셈', '리셈 소개', 'https://cdn.pixabay.com/photo/2016/11/29/05/45/astronomy-1867616_960_720.jpg'),
           (4, 0, 4.9, '베디스', '베디스 소개', 'https://cdn.pixabay.com/photo/2016/11/29/05/45/astronomy-1867616_960_720.jpg'),
           (5, 5, 3.2, '이니띠움', '이니띠움 소개', 'https://cdn.pixabay.com/photo/2016/11/29/05/45/astronomy-1867616_960_720.jpg');

insert into products(id, category_id, discount_rate, is_selling, is_sold_out,
                     original_price, review_avg, review_count,
                     sales_count, total_quantity, wish_count, brand_id, created_at, modified_at,
                     product_name, company, company_registration_number, delivery, product_image_url, product_content)
    values (1, '11000000', 0, true, false, 10000, 4.2, 19, 100, 2340, 90, 1, NOW(), NOW(), 'product1', 'company1', '02131', 'EXPRESS', 'https://image1', 'content1'),
           (2, '11000000', 0, true, false, 50000, 4.1, 56, 10, 432, 64, 1, NOW(), NOW(), 'product2', 'company1', '02131', 'EXPRESS', 'https://image2', 'content2'),
           (3, '12000000', 10, true, false, 79300, 4.9, 88, 900, 10000, 94, 2, NOW(), NOW(), 'product3', 'company2', '12145', 'NORMAL', 'https://image3', 'content3'),
           (4, '13000000', 7, true, false, 601110, 3.9, 8, 897, 100000, 189, 2, NOW(), NOW(), 'product4', 'company2', '12145', 'EXPRESS', 'https://image4', 'content4');


insert into products(id, category_id, discount_rate, is_selling, is_sold_out,
                     original_price, review_avg, review_count,
                     sales_count, total_quantity, wish_count, brand_id, created_at, modified_at,
                     product_name, company, company_registration_number, delivery, product_image_url, product_content)
values (5,'21000000', 0, true, false, 10000, 4.2, 19, 100, 2340, 90, 3, NOW(), NOW(), 'product5', 'company3', '78573', 'EXPRESS', 'https://image5', 'content5'),
       (6, '22000000', 0, true, false, 50000, 4.1, 56, 10, 432, 64, 3, NOW(), NOW(), 'product6', 'company3', '78573', 'EXPRESS', 'https://image6', 'content6'),
       (7, '23000000', 10, true, false, 79300, 4.9, 88, 900, 10000, 94, 3, NOW(), NOW(), 'product7', 'company3', '78573', 'NORMAL', 'https://image7', 'content7'),
       (8, '23000000', 7, true, false, 601110, 3.9, 8, 897, 100000, 189, 4, NOW(), NOW(), 'product8', 'company4', '45654', 'EXPRESS', 'https://image8', 'content8');

insert into products(id, category_id, discount_rate, is_selling, is_sold_out,
                     original_price, review_avg, review_count,
                     sales_count, total_quantity, wish_count, brand_id, created_at, modified_at,
                     product_name, company, company_registration_number, delivery, product_image_url, product_content)
values (9, '31000000', 0, true, false, 10000, 4.2, 19, 100, 2340, 90, 5, NOW(), NOW(), 'product9', 'company4', '23241', 'EXPRESS', 'https://image9', 'content9'),
       (10, '31000000', 0, true, false, 50000, 4.1, 56, 10, 432, 64, 5, NOW(), NOW(), 'product10', 'company5', '09885', 'EXPRESS', 'https://image10', 'content10'),
       (11, '32000000', 10, true, false, 79300, 4.9, 88, 900, 10000, 94, 5, NOW(), NOW(), 'product11', 'company6', '23422', 'NORMAL', 'https://image11', 'content11'),
       (12, '33000000', 7, true, false, 601110, 3.9, 8, 897, 100000, 189, 5, NOW(), NOW(), 'product12', 'company6', '23422', 'EXPRESS', 'https://image12', 'content12');

insert into options(id, is_required, product_id, option_name)
    values (1, true, 1, 'option1'),
           (2, true, 1, 'option2'),
           (3, true, 2, 'option1'),
           (4, true, 2, 'option2'),
           (5, true, 3, 'option1'),
           (6, true, 3, 'option2'),
           (7, true, 4, 'option1'),
           (8, true, 4, 'option2'),
           (9, true, 5, 'option1'),
           (10, true, 5, 'option2'),
           (11, true, 6, 'option1'),
           (12, true, 6, 'option2'),
           (13, true, 7, 'option1'),
           (14, true, 7, 'option2'),
           (15, true, 8, 'option1'),
           (16, true, 8, 'option2'),
           (17, true, 8, 'option3'),
           (18, true, 8, 'option4');

insert into option_details(id, is_sold_out, option_price, quantity, option_id, option_detail)
    values (1, false, 1000, 100, 1, 'option1_detail1'),
           (2, false, 2000, 200, 1, 'option1_detail2'),
           (3, false, 3000, 300, 2, 'option1_detail3'),
           (4, false, 4000, 400, 2, 'option1_detail4'),
           (5, true, 5000, 500, 3, 'option1_detail5'),
           (6, false, 6000, 600, 3, 'option1_detail6'),
           (7, false, 7000, 700, 4, 'option1_detail7'),
           (8, true, 8000, 800, 4, 'option1_detail8'),
           (9, false, 9000, 900, 5, 'option1_detail9'),
           (10, false, 10000, 1000, 5, 'option1_detail10'),
           (11, false, 11000, 1100, 6, 'option1_detail11'),
           (12, false, 12000, 1200, 6, 'option1_detail12'),
           (13, true, 13000, 1300, 7, 'option1_detail13'),
           (14, false, 14000, 1400, 7, 'option1_detail14'),
           (15, false, 15000, 1500, 8, 'option1_detail15'),
           (16, false, 16000, 1600, 8, 'option1_detail16'),
           (17, false, 17000, 1700, 8, 'option1_detail17'),
           (18, false, 20000, 1800, 9, 'option1_detail18'),
           (19, false, 20000, 1800, 9, 'option1_detail19'),
           (20, false, 20000, 1800, 10, 'option1_detail20'),
           (21, false, 20000, 1800, 11, 'option1_detail21'),
           (22, false, 20000, 1800, 12, 'option1_detail22'),
           (23, true, 20000, 1800, 13, 'option1_detail23'),
           (24, false, 20000, 1800, 14, 'option1_detail24'),
           (25, false, 20000, 1800, 15, 'option1_detail25'),
           (26, false, 20000, 1800, 16, 'option1_detail26'),
           (27, true, 20000, 1800, 17, 'option1_detail27'),
           (28, false, 20000, 1800, 18, 'option1_detail28');

insert into reviews(star_grade, created_at, id, modified_at, product_id, review_content, product_option_name, review_image_url)
    values (4, NOW(), 1, NOW(), 1, 'content1', 'option1_detail1', 'https://reviewImage1'),
           (3, NOW(), 2, NOW(), 5, 'content2', 'option1_detail5', 'https://reviewImage2'),
           (5, NOW(), 3, NOW(), 9, 'content3', 'option1_detail9', 'https://reviewImage3');