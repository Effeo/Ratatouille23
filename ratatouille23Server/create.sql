
    create table conto (
       id_conto integer not null,
        costo float(23),
        data datetime(6),
        id_tavolo integer,
        primary key (id_conto)
    ) engine=InnoDB;

    create table ordine (
       id_ordine integer not null,
        id_tavolo integer,
        primary key (id_ordine)
    ) engine=InnoDB;

    create table ordine_piatto (
       id_ordine_piatto integer not null,
        qta integer,
        id_ordine integer,
        id_piatto integer,
        primary key (id_ordine_piatto)
    ) engine=InnoDB;

    create table piatto (
       id_piatto integer not null,
        allergeni varchar(255),
        categoria varchar(255),
        costo float(23),
        descrizione varchar(255),
        nome varchar(255),
        posto integer,
        primary key (id_piatto)
    ) engine=InnoDB;

    create table tavolo (
       id_tavolo integer not null,
        primary key (id_tavolo)
    ) engine=InnoDB;

    create table utente (
       user_name varchar(255) not null,
        check_change_password integer,
        password varchar(255),
        ruolo varchar(255),
        primary key (user_name)
    ) engine=InnoDB;

    alter table conto 
       add constraint FKn4resvckejwr6hfsbq1f4rp34 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo);

    alter table ordine 
       add constraint FKeqk4wbgp4bm8pwdcqy32w5xxr 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKaa3kjgxujbc5ow6cycxih82g0 
       foreign key (id_ordine) 
       references ordine (id_ordine) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKnpmeassmyoh23uafh965y5ua0 
       foreign key (id_piatto) 
       references piatto (id_piatto) 
       on delete cascade;

    create table conto (
       id_conto integer not null,
        costo float(23),
        data datetime(6),
        id_tavolo integer,
        primary key (id_conto)
    ) engine=InnoDB;

    create table ordine (
       id_ordine integer not null,
        id_tavolo integer,
        primary key (id_ordine)
    ) engine=InnoDB;

    create table ordine_piatto (
       id_ordine_piatto integer not null,
        qta integer,
        id_ordine integer,
        id_piatto integer,
        primary key (id_ordine_piatto)
    ) engine=InnoDB;

    create table piatto (
       id_piatto integer not null,
        allergeni varchar(255),
        categoria varchar(255),
        costo float(23),
        descrizione varchar(255),
        nome varchar(255),
        posto integer,
        primary key (id_piatto)
    ) engine=InnoDB;

    create table tavolo (
       id_tavolo integer not null,
        primary key (id_tavolo)
    ) engine=InnoDB;

    create table utente (
       user_name varchar(255) not null,
        check_change_password integer,
        password varchar(255),
        ruolo varchar(255),
        primary key (user_name)
    ) engine=InnoDB;

    alter table conto 
       add constraint FKn4resvckejwr6hfsbq1f4rp34 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo);

    alter table ordine 
       add constraint FKeqk4wbgp4bm8pwdcqy32w5xxr 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKaa3kjgxujbc5ow6cycxih82g0 
       foreign key (id_ordine) 
       references ordine (id_ordine) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKnpmeassmyoh23uafh965y5ua0 
       foreign key (id_piatto) 
       references piatto (id_piatto) 
       on delete cascade;

    create table conto (
       id_conto integer not null,
        costo float(23),
        data datetime(6),
        id_tavolo integer,
        primary key (id_conto)
    ) engine=InnoDB;

    create table ordine (
       id_ordine integer not null,
        id_tavolo integer,
        primary key (id_ordine)
    ) engine=InnoDB;

    create table ordine_piatto (
       id_ordine_piatto integer not null,
        qta integer,
        id_ordine integer,
        id_piatto integer,
        primary key (id_ordine_piatto)
    ) engine=InnoDB;

    create table piatto (
       id_piatto integer not null,
        allergeni varchar(255),
        categoria varchar(255),
        costo float(23),
        descrizione varchar(255),
        nome varchar(255),
        posto integer,
        primary key (id_piatto)
    ) engine=InnoDB;

    create table tavolo (
       id_tavolo integer not null,
        primary key (id_tavolo)
    ) engine=InnoDB;

    create table utente (
       user_name varchar(255) not null,
        check_change_password integer,
        password varchar(255),
        ruolo varchar(255),
        primary key (user_name)
    ) engine=InnoDB;

    alter table conto 
       add constraint FKn4resvckejwr6hfsbq1f4rp34 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo);

    alter table ordine 
       add constraint FKeqk4wbgp4bm8pwdcqy32w5xxr 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKaa3kjgxujbc5ow6cycxih82g0 
       foreign key (id_ordine) 
       references ordine (id_ordine) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKnpmeassmyoh23uafh965y5ua0 
       foreign key (id_piatto) 
       references piatto (id_piatto) 
       on delete cascade;

    create table conto (
       id_conto integer not null,
        costo float(23),
        data datetime(6),
        id_tavolo integer,
        primary key (id_conto)
    ) engine=InnoDB;

    create table ordine (
       id_ordine integer not null,
        id_tavolo integer,
        primary key (id_ordine)
    ) engine=InnoDB;

    create table ordine_piatto (
       id_ordine_piatto integer not null,
        qta integer,
        id_ordine integer,
        id_piatto integer,
        primary key (id_ordine_piatto)
    ) engine=InnoDB;

    create table piatto (
       id_piatto integer not null,
        allergeni varchar(255),
        categoria varchar(255),
        costo float(23),
        descrizione varchar(255),
        nome varchar(255),
        posto integer,
        primary key (id_piatto)
    ) engine=InnoDB;

    create table tavolo (
       id_tavolo integer not null,
        primary key (id_tavolo)
    ) engine=InnoDB;

    create table utente (
       user_name varchar(255) not null,
        check_change_password integer,
        password varchar(255),
        ruolo varchar(255),
        primary key (user_name)
    ) engine=InnoDB;

    alter table conto 
       add constraint FKn4resvckejwr6hfsbq1f4rp34 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo);

    alter table ordine 
       add constraint FKeqk4wbgp4bm8pwdcqy32w5xxr 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKaa3kjgxujbc5ow6cycxih82g0 
       foreign key (id_ordine) 
       references ordine (id_ordine) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKnpmeassmyoh23uafh965y5ua0 
       foreign key (id_piatto) 
       references piatto (id_piatto) 
       on delete cascade;

    create table conto (
       id_conto integer not null,
        costo float(23),
        data datetime(6),
        id_tavolo integer,
        primary key (id_conto)
    ) engine=InnoDB;

    create table ordine (
       id_ordine integer not null,
        id_tavolo integer,
        primary key (id_ordine)
    ) engine=InnoDB;

    create table ordine_piatto (
       id_ordine_piatto integer not null,
        qta integer,
        id_ordine integer,
        id_piatto integer,
        primary key (id_ordine_piatto)
    ) engine=InnoDB;

    create table piatto (
       id_piatto integer not null,
        allergeni varchar(255),
        categoria varchar(255),
        costo float(23),
        descrizione varchar(255),
        nome varchar(255),
        posto integer,
        primary key (id_piatto)
    ) engine=InnoDB;

    create table tavolo (
       id_tavolo integer not null,
        primary key (id_tavolo)
    ) engine=InnoDB;

    create table utente (
       user_name varchar(255) not null,
        check_change_password integer,
        password varchar(255),
        ruolo varchar(255),
        primary key (user_name)
    ) engine=InnoDB;

    alter table conto 
       add constraint FKn4resvckejwr6hfsbq1f4rp34 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo);

    alter table ordine 
       add constraint FKeqk4wbgp4bm8pwdcqy32w5xxr 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKaa3kjgxujbc5ow6cycxih82g0 
       foreign key (id_ordine) 
       references ordine (id_ordine) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKnpmeassmyoh23uafh965y5ua0 
       foreign key (id_piatto) 
       references piatto (id_piatto) 
       on delete cascade;

    create table conto (
       id_conto integer not null,
        costo float(23),
        data datetime(6),
        id_tavolo integer,
        primary key (id_conto)
    ) engine=InnoDB;

    create table ordine (
       id_ordine integer not null,
        id_tavolo integer,
        primary key (id_ordine)
    ) engine=InnoDB;

    create table ordine_piatto (
       id_ordine_piatto integer not null,
        qta integer,
        id_ordine integer,
        id_piatto integer,
        primary key (id_ordine_piatto)
    ) engine=InnoDB;

    create table piatto (
       id_piatto integer not null,
        allergeni varchar(255),
        categoria varchar(255),
        costo float(23),
        descrizione varchar(255),
        nome varchar(255),
        posto integer,
        primary key (id_piatto)
    ) engine=InnoDB;

    create table tavolo (
       id_tavolo integer not null,
        primary key (id_tavolo)
    ) engine=InnoDB;

    create table utente (
       user_name varchar(255) not null,
        check_change_password integer,
        password varchar(255),
        ruolo varchar(255),
        primary key (user_name)
    ) engine=InnoDB;

    alter table conto 
       add constraint FKn4resvckejwr6hfsbq1f4rp34 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo);

    alter table ordine 
       add constraint FKeqk4wbgp4bm8pwdcqy32w5xxr 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKaa3kjgxujbc5ow6cycxih82g0 
       foreign key (id_ordine) 
       references ordine (id_ordine) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKnpmeassmyoh23uafh965y5ua0 
       foreign key (id_piatto) 
       references piatto (id_piatto) 
       on delete cascade;

    create table conto (
       id_conto integer not null,
        costo float(23),
        data datetime(6),
        id_tavolo integer,
        primary key (id_conto)
    ) engine=InnoDB;

    create table ordine (
       id_ordine integer not null,
        id_tavolo integer,
        primary key (id_ordine)
    ) engine=InnoDB;

    create table ordine_piatto (
       id_ordine_piatto integer not null,
        qta integer,
        id_ordine integer,
        id_piatto integer,
        primary key (id_ordine_piatto)
    ) engine=InnoDB;

    create table piatto (
       id_piatto integer not null,
        allergeni varchar(255),
        categoria varchar(255),
        costo float(23),
        descrizione varchar(255),
        nome varchar(255),
        posto integer,
        primary key (id_piatto)
    ) engine=InnoDB;

    create table tavolo (
       id_tavolo integer not null,
        primary key (id_tavolo)
    ) engine=InnoDB;

    create table utente (
       user_name varchar(255) not null,
        check_change_password integer,
        password varchar(255),
        ruolo varchar(255),
        primary key (user_name)
    ) engine=InnoDB;

    alter table conto 
       add constraint FKn4resvckejwr6hfsbq1f4rp34 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo);

    alter table ordine 
       add constraint FKeqk4wbgp4bm8pwdcqy32w5xxr 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKaa3kjgxujbc5ow6cycxih82g0 
       foreign key (id_ordine) 
       references ordine (id_ordine) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKnpmeassmyoh23uafh965y5ua0 
       foreign key (id_piatto) 
       references piatto (id_piatto) 
       on delete cascade;

    create table conto (
       id_conto integer not null,
        costo float(23),
        data datetime(6),
        id_tavolo integer,
        primary key (id_conto)
    ) engine=InnoDB;

    create table ordine (
       id_ordine integer not null,
        id_tavolo integer,
        primary key (id_ordine)
    ) engine=InnoDB;

    create table ordine_piatto (
       id_ordine_piatto integer not null,
        qta integer,
        id_ordine integer,
        id_piatto integer,
        primary key (id_ordine_piatto)
    ) engine=InnoDB;

    create table piatto (
       id_piatto integer not null,
        allergeni varchar(255),
        categoria varchar(255),
        costo float(23),
        descrizione varchar(255),
        nome varchar(255),
        posto integer,
        primary key (id_piatto)
    ) engine=InnoDB;

    create table tavolo (
       id_tavolo integer not null,
        primary key (id_tavolo)
    ) engine=InnoDB;

    create table utente (
       user_name varchar(255) not null,
        check_change_password integer,
        password varchar(255),
        ruolo varchar(255),
        primary key (user_name)
    ) engine=InnoDB;

    alter table conto 
       add constraint FKn4resvckejwr6hfsbq1f4rp34 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo);

    alter table ordine 
       add constraint FKeqk4wbgp4bm8pwdcqy32w5xxr 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKaa3kjgxujbc5ow6cycxih82g0 
       foreign key (id_ordine) 
       references ordine (id_ordine) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKnpmeassmyoh23uafh965y5ua0 
       foreign key (id_piatto) 
       references piatto (id_piatto) 
       on delete cascade;

    create table conto (
       id_conto integer not null,
        costo float(23),
        data datetime(6),
        id_tavolo integer,
        primary key (id_conto)
    ) engine=InnoDB;

    create table ordine (
       id_ordine integer not null,
        id_tavolo integer,
        primary key (id_ordine)
    ) engine=InnoDB;

    create table ordine_piatto (
       id_ordine_piatto integer not null,
        qta integer,
        id_ordine integer,
        id_piatto integer,
        primary key (id_ordine_piatto)
    ) engine=InnoDB;

    create table piatto (
       id_piatto integer not null,
        allergeni varchar(255),
        categoria varchar(255),
        costo float(23),
        descrizione varchar(255),
        nome varchar(255),
        posto integer,
        primary key (id_piatto)
    ) engine=InnoDB;

    create table tavolo (
       id_tavolo integer not null,
        primary key (id_tavolo)
    ) engine=InnoDB;

    create table utente (
       user_name varchar(255) not null,
        check_change_password integer,
        password varchar(255),
        ruolo varchar(255),
        primary key (user_name)
    ) engine=InnoDB;

    alter table conto 
       add constraint FKn4resvckejwr6hfsbq1f4rp34 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo);

    alter table ordine 
       add constraint FKeqk4wbgp4bm8pwdcqy32w5xxr 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKaa3kjgxujbc5ow6cycxih82g0 
       foreign key (id_ordine) 
       references ordine (id_ordine) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKnpmeassmyoh23uafh965y5ua0 
       foreign key (id_piatto) 
       references piatto (id_piatto) 
       on delete cascade;

    create table conto (
       id_conto integer not null,
        costo float(23),
        data datetime(6),
        id_tavolo integer,
        primary key (id_conto)
    ) engine=InnoDB;

    create table messaggio (
       id_messaggio integer not null,
        corpo varchar(255),
        primary key (id_messaggio)
    ) engine=InnoDB;

    create table messaggio_ordine (
       id_messaggio_ordine integer not null,
        letto bit,
        id_messaggio integer,
        user_name varchar(255),
        primary key (id_messaggio_ordine)
    ) engine=InnoDB;

    create table ordine (
       id_ordine integer not null,
        id_tavolo integer,
        primary key (id_ordine)
    ) engine=InnoDB;

    create table ordine_piatto (
       id_ordine_piatto integer not null,
        qta integer,
        id_ordine integer,
        id_piatto integer,
        primary key (id_ordine_piatto)
    ) engine=InnoDB;

    create table piatto (
       id_piatto integer not null,
        allergeni varchar(255),
        categoria varchar(255),
        costo float(23),
        descrizione varchar(255),
        nome varchar(255),
        posto integer,
        primary key (id_piatto)
    ) engine=InnoDB;

    create table tavolo (
       id_tavolo integer not null,
        primary key (id_tavolo)
    ) engine=InnoDB;

    create table utente (
       user_name varchar(255) not null,
        check_change_password integer,
        password varchar(255),
        ruolo varchar(255),
        primary key (user_name)
    ) engine=InnoDB;

    alter table conto 
       add constraint FKn4resvckejwr6hfsbq1f4rp34 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo);

    alter table messaggio_ordine 
       add constraint FK82tqfnfxosfkqg6tmo9gas0h 
       foreign key (id_messaggio) 
       references messaggio (id_messaggio) 
       on delete cascade;

    alter table messaggio_ordine 
       add constraint FKhj359xhh2t1bxmgxn0yx1hk5b 
       foreign key (user_name) 
       references utente (user_name) 
       on delete cascade;

    alter table ordine 
       add constraint FKeqk4wbgp4bm8pwdcqy32w5xxr 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKaa3kjgxujbc5ow6cycxih82g0 
       foreign key (id_ordine) 
       references ordine (id_ordine) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKnpmeassmyoh23uafh965y5ua0 
       foreign key (id_piatto) 
       references piatto (id_piatto) 
       on delete cascade;

    create table conto (
       id_conto integer not null,
        costo float(23),
        data datetime(6),
        id_tavolo integer,
        primary key (id_conto)
    ) engine=InnoDB;

    create table messaggio (
       id_messaggio integer not null,
        corpo varchar(255),
        primary key (id_messaggio)
    ) engine=InnoDB;

    create table messaggio_ordine (
       id_messaggio_ordine integer not null,
        letto bit,
        id_messaggio integer,
        user_name varchar(255),
        primary key (id_messaggio_ordine)
    ) engine=InnoDB;

    create table ordine (
       id_ordine integer not null,
        id_tavolo integer,
        primary key (id_ordine)
    ) engine=InnoDB;

    create table ordine_piatto (
       id_ordine_piatto integer not null,
        qta integer,
        id_ordine integer,
        id_piatto integer,
        primary key (id_ordine_piatto)
    ) engine=InnoDB;

    create table piatto (
       id_piatto integer not null,
        allergeni varchar(255),
        categoria varchar(255),
        costo float(23),
        descrizione varchar(255),
        nome varchar(255),
        posto integer,
        primary key (id_piatto)
    ) engine=InnoDB;

    create table tavolo (
       id_tavolo integer not null,
        primary key (id_tavolo)
    ) engine=InnoDB;

    create table utente (
       user_name varchar(255) not null,
        check_change_password integer,
        password varchar(255),
        ruolo varchar(255),
        primary key (user_name)
    ) engine=InnoDB;

    alter table conto 
       add constraint FKn4resvckejwr6hfsbq1f4rp34 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo);

    alter table messaggio_ordine 
       add constraint FK82tqfnfxosfkqg6tmo9gas0h 
       foreign key (id_messaggio) 
       references messaggio (id_messaggio) 
       on delete cascade;

    alter table messaggio_ordine 
       add constraint FKhj359xhh2t1bxmgxn0yx1hk5b 
       foreign key (user_name) 
       references utente (user_name) 
       on delete cascade;

    alter table ordine 
       add constraint FKeqk4wbgp4bm8pwdcqy32w5xxr 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKaa3kjgxujbc5ow6cycxih82g0 
       foreign key (id_ordine) 
       references ordine (id_ordine) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKnpmeassmyoh23uafh965y5ua0 
       foreign key (id_piatto) 
       references piatto (id_piatto) 
       on delete cascade;

    create table conto (
       id_conto integer not null,
        costo float(23),
        data datetime(6),
        id_tavolo integer,
        primary key (id_conto)
    ) engine=InnoDB;

    create table messaggio (
       id_messaggio integer not null,
        corpo varchar(255),
        primary key (id_messaggio)
    ) engine=InnoDB;

    create table messaggio_ordine (
       id_messaggio_ordine integer not null,
        letto bit,
        id_messaggio integer,
        user_name varchar(255),
        primary key (id_messaggio_ordine)
    ) engine=InnoDB;

    create table ordine (
       id_ordine integer not null,
        id_tavolo integer,
        primary key (id_ordine)
    ) engine=InnoDB;

    create table ordine_piatto (
       id_ordine_piatto integer not null,
        qta integer,
        id_ordine integer,
        id_piatto integer,
        primary key (id_ordine_piatto)
    ) engine=InnoDB;

    create table piatto (
       id_piatto integer not null,
        allergeni varchar(255),
        categoria varchar(255),
        costo float(23),
        descrizione varchar(255),
        nome varchar(255),
        posto integer,
        primary key (id_piatto)
    ) engine=InnoDB;

    create table tavolo (
       id_tavolo integer not null,
        primary key (id_tavolo)
    ) engine=InnoDB;

    create table utente (
       user_name varchar(255) not null,
        check_change_password integer,
        password varchar(255),
        ruolo varchar(255),
        primary key (user_name)
    ) engine=InnoDB;

    alter table conto 
       add constraint FKn4resvckejwr6hfsbq1f4rp34 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo);

    alter table messaggio_ordine 
       add constraint FK82tqfnfxosfkqg6tmo9gas0h 
       foreign key (id_messaggio) 
       references messaggio (id_messaggio) 
       on delete cascade;

    alter table messaggio_ordine 
       add constraint FKhj359xhh2t1bxmgxn0yx1hk5b 
       foreign key (user_name) 
       references utente (user_name) 
       on delete cascade;

    alter table ordine 
       add constraint FKeqk4wbgp4bm8pwdcqy32w5xxr 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKaa3kjgxujbc5ow6cycxih82g0 
       foreign key (id_ordine) 
       references ordine (id_ordine) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKnpmeassmyoh23uafh965y5ua0 
       foreign key (id_piatto) 
       references piatto (id_piatto) 
       on delete cascade;

    create table conto (
       id_conto integer not null,
        costo float(23),
        data datetime(6),
        id_tavolo integer,
        primary key (id_conto)
    ) engine=InnoDB;

    create table messaggio (
       id_messaggio integer not null,
        corpo varchar(255),
        primary key (id_messaggio)
    ) engine=InnoDB;

    create table messaggio_ordine (
       id_messaggio_ordine integer not null,
        letto bit,
        id_messaggio integer,
        user_name varchar(255),
        primary key (id_messaggio_ordine)
    ) engine=InnoDB;

    create table ordine (
       id_ordine integer not null,
        id_tavolo integer,
        primary key (id_ordine)
    ) engine=InnoDB;

    create table ordine_piatto (
       id_ordine_piatto integer not null,
        qta integer,
        id_ordine integer,
        id_piatto integer,
        primary key (id_ordine_piatto)
    ) engine=InnoDB;

    create table piatto (
       id_piatto integer not null,
        allergeni varchar(255),
        categoria varchar(255),
        costo float(23),
        descrizione varchar(255),
        nome varchar(255),
        posto integer,
        primary key (id_piatto)
    ) engine=InnoDB;

    create table tavolo (
       id_tavolo integer not null,
        primary key (id_tavolo)
    ) engine=InnoDB;

    create table utente (
       user_name varchar(255) not null,
        check_change_password integer,
        password varchar(255),
        ruolo varchar(255),
        primary key (user_name)
    ) engine=InnoDB;

    alter table conto 
       add constraint FKn4resvckejwr6hfsbq1f4rp34 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo);

    alter table messaggio_ordine 
       add constraint FK82tqfnfxosfkqg6tmo9gas0h 
       foreign key (id_messaggio) 
       references messaggio (id_messaggio) 
       on delete cascade;

    alter table messaggio_ordine 
       add constraint FKhj359xhh2t1bxmgxn0yx1hk5b 
       foreign key (user_name) 
       references utente (user_name) 
       on delete cascade;

    alter table ordine 
       add constraint FKeqk4wbgp4bm8pwdcqy32w5xxr 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKaa3kjgxujbc5ow6cycxih82g0 
       foreign key (id_ordine) 
       references ordine (id_ordine) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKnpmeassmyoh23uafh965y5ua0 
       foreign key (id_piatto) 
       references piatto (id_piatto) 
       on delete cascade;

    create table conto (
       id_conto integer not null,
        costo float(23),
        data datetime(6),
        id_tavolo integer,
        primary key (id_conto)
    ) engine=InnoDB;

    create table messaggio (
       id_messaggio integer not null,
        corpo varchar(255),
        primary key (id_messaggio)
    ) engine=InnoDB;

    create table messaggio_ordine (
       id_messaggio_ordine integer not null,
        letto bit,
        id_messaggio integer,
        user_name varchar(255),
        primary key (id_messaggio_ordine)
    ) engine=InnoDB;

    create table ordine (
       id_ordine integer not null,
        id_tavolo integer,
        primary key (id_ordine)
    ) engine=InnoDB;

    create table ordine_piatto (
       id_ordine_piatto integer not null,
        qta integer,
        id_ordine integer,
        id_piatto integer,
        primary key (id_ordine_piatto)
    ) engine=InnoDB;

    create table piatto (
       id_piatto integer not null,
        allergeni varchar(255),
        categoria varchar(255),
        costo float(23),
        descrizione varchar(255),
        nome varchar(255),
        posto integer,
        primary key (id_piatto)
    ) engine=InnoDB;

    create table tavolo (
       id_tavolo integer not null,
        primary key (id_tavolo)
    ) engine=InnoDB;

    create table utente (
       user_name varchar(255) not null,
        check_change_password integer,
        password varchar(255),
        ruolo varchar(255),
        primary key (user_name)
    ) engine=InnoDB;

    alter table conto 
       add constraint FKn4resvckejwr6hfsbq1f4rp34 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo);

    alter table messaggio_ordine 
       add constraint FK82tqfnfxosfkqg6tmo9gas0h 
       foreign key (id_messaggio) 
       references messaggio (id_messaggio) 
       on delete cascade;

    alter table messaggio_ordine 
       add constraint FKhj359xhh2t1bxmgxn0yx1hk5b 
       foreign key (user_name) 
       references utente (user_name) 
       on delete cascade;

    alter table ordine 
       add constraint FKeqk4wbgp4bm8pwdcqy32w5xxr 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKaa3kjgxujbc5ow6cycxih82g0 
       foreign key (id_ordine) 
       references ordine (id_ordine) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKnpmeassmyoh23uafh965y5ua0 
       foreign key (id_piatto) 
       references piatto (id_piatto) 
       on delete cascade;

    create table conto (
       id_conto integer not null,
        costo float(23),
        data datetime(6),
        id_tavolo integer,
        primary key (id_conto)
    ) engine=InnoDB;

    create table messaggio (
       id_messaggio integer not null,
        corpo varchar(255),
        primary key (id_messaggio)
    ) engine=InnoDB;

    create table messaggio_ordine (
       id_messaggio_ordine integer not null,
        letto bit,
        id_messaggio integer,
        user_name varchar(255),
        primary key (id_messaggio_ordine)
    ) engine=InnoDB;

    create table ordine (
       id_ordine integer not null,
        id_tavolo integer,
        primary key (id_ordine)
    ) engine=InnoDB;

    create table ordine_piatto (
       id_ordine_piatto integer not null,
        qta integer,
        id_ordine integer,
        id_piatto integer,
        primary key (id_ordine_piatto)
    ) engine=InnoDB;

    create table piatto (
       id_piatto integer not null,
        allergeni varchar(255),
        categoria varchar(255),
        costo float(23),
        descrizione varchar(255),
        nome varchar(255),
        posto integer,
        primary key (id_piatto)
    ) engine=InnoDB;

    create table tavolo (
       id_tavolo integer not null,
        primary key (id_tavolo)
    ) engine=InnoDB;

    create table utente (
       user_name varchar(255) not null,
        check_change_password integer,
        password varchar(255),
        ruolo varchar(255),
        primary key (user_name)
    ) engine=InnoDB;

    alter table conto 
       add constraint FKn4resvckejwr6hfsbq1f4rp34 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo);

    alter table messaggio_ordine 
       add constraint FK82tqfnfxosfkqg6tmo9gas0h 
       foreign key (id_messaggio) 
       references messaggio (id_messaggio) 
       on delete cascade;

    alter table messaggio_ordine 
       add constraint FKhj359xhh2t1bxmgxn0yx1hk5b 
       foreign key (user_name) 
       references utente (user_name) 
       on delete cascade;

    alter table ordine 
       add constraint FKeqk4wbgp4bm8pwdcqy32w5xxr 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKaa3kjgxujbc5ow6cycxih82g0 
       foreign key (id_ordine) 
       references ordine (id_ordine) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKnpmeassmyoh23uafh965y5ua0 
       foreign key (id_piatto) 
       references piatto (id_piatto) 
       on delete cascade;

    create table conto (
       id_conto integer not null,
        costo float(23),
        data datetime(6),
        id_tavolo integer,
        primary key (id_conto)
    ) engine=InnoDB;

    create table messaggio (
       id_messaggio integer not null,
        corpo varchar(255),
        primary key (id_messaggio)
    ) engine=InnoDB;

    create table messaggio_ordine (
       id_messaggio_ordine integer not null,
        letto bit,
        id_messaggio integer,
        user_name varchar(255),
        primary key (id_messaggio_ordine)
    ) engine=InnoDB;

    create table ordine (
       id_ordine integer not null,
        id_tavolo integer,
        primary key (id_ordine)
    ) engine=InnoDB;

    create table ordine_piatto (
       id_ordine_piatto integer not null,
        qta integer,
        id_ordine integer,
        id_piatto integer,
        primary key (id_ordine_piatto)
    ) engine=InnoDB;

    create table piatto (
       id_piatto integer not null,
        allergeni varchar(255),
        categoria varchar(255),
        costo float(23),
        descrizione varchar(255),
        nome varchar(255),
        posto integer,
        primary key (id_piatto)
    ) engine=InnoDB;

    create table tavolo (
       id_tavolo integer not null,
        primary key (id_tavolo)
    ) engine=InnoDB;

    create table utente (
       user_name varchar(255) not null,
        check_change_password integer,
        password varchar(255),
        ruolo varchar(255),
        primary key (user_name)
    ) engine=InnoDB;

    alter table conto 
       add constraint FKn4resvckejwr6hfsbq1f4rp34 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo);

    alter table messaggio_ordine 
       add constraint FK82tqfnfxosfkqg6tmo9gas0h 
       foreign key (id_messaggio) 
       references messaggio (id_messaggio) 
       on delete cascade;

    alter table messaggio_ordine 
       add constraint FKhj359xhh2t1bxmgxn0yx1hk5b 
       foreign key (user_name) 
       references utente (user_name) 
       on delete cascade;

    alter table ordine 
       add constraint FKeqk4wbgp4bm8pwdcqy32w5xxr 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKaa3kjgxujbc5ow6cycxih82g0 
       foreign key (id_ordine) 
       references ordine (id_ordine) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKnpmeassmyoh23uafh965y5ua0 
       foreign key (id_piatto) 
       references piatto (id_piatto) 
       on delete cascade;

    create table conto (
       id_conto integer not null,
        costo float(23),
        data datetime(6),
        id_tavolo integer,
        primary key (id_conto)
    ) engine=InnoDB;

    create table messaggio (
       id_messaggio integer not null,
        corpo varchar(255),
        primary key (id_messaggio)
    ) engine=InnoDB;

    create table messaggio_ordine (
       id_messaggio_ordine integer not null,
        letto bit,
        id_messaggio integer,
        user_name varchar(255),
        primary key (id_messaggio_ordine)
    ) engine=InnoDB;

    create table ordine (
       id_ordine integer not null,
        id_tavolo integer,
        primary key (id_ordine)
    ) engine=InnoDB;

    create table ordine_piatto (
       id_ordine_piatto integer not null,
        qta integer,
        id_ordine integer,
        id_piatto integer,
        primary key (id_ordine_piatto)
    ) engine=InnoDB;

    create table piatto (
       id_piatto integer not null,
        allergeni varchar(255),
        categoria varchar(255),
        costo float(23),
        descrizione varchar(255),
        nome varchar(255),
        posto integer,
        primary key (id_piatto)
    ) engine=InnoDB;

    create table tavolo (
       id_tavolo integer not null,
        primary key (id_tavolo)
    ) engine=InnoDB;

    create table utente (
       user_name varchar(255) not null,
        check_change_password integer,
        password varchar(255),
        ruolo varchar(255),
        primary key (user_name)
    ) engine=InnoDB;

    alter table conto 
       add constraint FKn4resvckejwr6hfsbq1f4rp34 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo);

    alter table messaggio_ordine 
       add constraint FK82tqfnfxosfkqg6tmo9gas0h 
       foreign key (id_messaggio) 
       references messaggio (id_messaggio) 
       on delete cascade;

    alter table messaggio_ordine 
       add constraint FKhj359xhh2t1bxmgxn0yx1hk5b 
       foreign key (user_name) 
       references utente (user_name) 
       on delete cascade;

    alter table ordine 
       add constraint FKeqk4wbgp4bm8pwdcqy32w5xxr 
       foreign key (id_tavolo) 
       references tavolo (id_tavolo) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKaa3kjgxujbc5ow6cycxih82g0 
       foreign key (id_ordine) 
       references ordine (id_ordine) 
       on delete cascade;

    alter table ordine_piatto 
       add constraint FKnpmeassmyoh23uafh965y5ua0 
       foreign key (id_piatto) 
       references piatto (id_piatto) 
       on delete cascade;
