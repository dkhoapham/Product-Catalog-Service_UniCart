create table if not exists products
(
    id
    integer
    generated
    always as
    identity
    primary
    key,
    name
    varchar
(
    255
) not null,
    description text not null,
    price numeric
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
    created_at timestamptz not null default now
(
),
    updated_at timestamptz not null default now
(
),
    constraint chk_products_name_not_blank check
(
    length (
    btrim
(
    name
)) > 0),
    constraint chk_products_category_not_blank check
(
    length (
    btrim
(
    category
)) > 0)
    );

create table if not exists product_images
(
    product_id
    integer
    not
    null
    references
    products
(
    id
) on delete cascade,
    url varchar
(
    1024
) not null,
    position integer not null default 0,
    constraint chk_product_images_url_scheme check
(
    url
    ~
    '^https?://'
),
    primary key
(
    product_id,
    url
)
    );

create index if not exists idx_products_category on products(category);
create index if not exists idx_images_product on product_images(product_id);

create
or replace function set_updated_at() returns trigger as $$
begin
  new.updated_at
= now();
return new;
end;
$$
language plpgsql;

drop trigger if exists trg_products_set_updated_at on products;
create trigger trg_products_set_updated_at
    before update
    on products
    for each row execute function set_updated_at();