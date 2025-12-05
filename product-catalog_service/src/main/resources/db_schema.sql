-- H2 schema.sql (local dev)

create table if not exists products
(
    id
    integer
    generated
    by
    default as
    identity
    primary
    key,
    name
    varchar
(
    255
) not null,
    description clob not null,
    price decimal
(
    12,
    2
) not null check
(
    price
    >=
    0
),
    category varchar
(
    64
) not null,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp,
    constraint chk_products_name_not_blank
    check
(
    length (
    trim
(
    name
)) > 0),
    constraint chk_products_category_not_blank
    check
(
    length (
    trim
(
    category
)) > 0)
    );

create table if not exists product_images
(
    product_id
    integer
    not
    null,
    url
    varchar
(
    1024
) not null,
    position integer not null default 0,
    constraint fk_product_images_product
    foreign key
(
    product_id
) references products
(
    id
) on delete cascade,
    constraint chk_product_images_url_scheme
    check
(
    regexp_like
(
    url,
    '^https?://'
)),
    primary key
(
    product_id,
    url
)
    );

create index if not exists idx_products_category on products(category);
create index if not exists idx_images_product on product_images(product_id);

-- No trigger here (H2 doesn't support plpgsql). Let JPA @UpdateTimestamp handle updated_at.
