create table if not exists owasp_risk (
    id varchar(36),
    year varchar(4),
    name varchar(256),
    description varchar(2048),
    created datetime(3) not null default  CURRENT_TIMESTAMP(3),
    last_modified datetime(3) not null default  CURRENT_TIMESTAMP(3),
    unique(name, year),
    primary key (id)
)