-- add to typeAuto table

insert into type_auto(id, type)
    values (1, 'седан');
insert into type_auto(id, type)
    values (2, 'купе');
insert into type_auto(id, type)
    values (3, 'джип');
insert into type_auto(id, type)
    values (4, 'хэтчбек');
insert into type_auto(id, type)
    values (5, 'фургон');

-- add to carBrand table

insert into car_brand(id, name)
    values (1, 'Audi');
insert into car_brand(id, name)
    values (2, 'BMW');
insert into car_brand(id, name)
    values (3, 'Mercedes');

-- add to carModel table

insert into car_model(id, name, car_brand_id)
    values (1, 'X5', 2);
insert into car_model(id, name, car_brand_id)
    values (2, 'W124', 3);
insert into car_model(id, name, car_brand_id)
    values (3, 'T1', 3);
insert into car_model(id, name, car_brand_id)
    values (4, '80', 1);
insert into car_model(id, name, car_brand_id)
    values (5, 'M5', 2);
insert into car_model(id, name, car_brand_id)
    values (7, 'A8', 1);

-- add to usr table

insert into usr(id, is_active, login, password)
    values (2, true, 'vodila', '77777');
insert into user_role(user_id , roles)
    values (2, 'USER');
insert into usr(id, is_active, login, password)
    values (3, true, 'yarichek', 'catdog');
insert into user_role(user_id , roles)
    values (3, 'USER');
insert into usr(id, is_active, login, password)
    values (4, true, 'junior', 'innowise');
insert into user_role(user_id , roles)
    values (4, 'USER');

-- add to car table

insert into car (id, active, description, location, mileage , photo_path, price, volume_of_engine, year, car_brand_id, car_model_id, type_auto_id, user_id )
    values (1,
            true,
            'хорошая, резвая машинка. Ест не много, пороги целые. Двигатель не дымит, масло не жрет. По нюансам только салон',
            'Гродно',
            300000,
            null,
            2500,
            2.0,
            1997,
            1,
            4,
            4,
            2
           );
insert into car (id, active, description, location, mileage , photo_path, price, volume_of_engine, year, car_brand_id, car_model_id, type_auto_id, user_id )
values (2,
        false ,
        'Машина для работы. по внутренностям все окей, только с фасадом проблемы.',
        'Минск',
        900000,
        null,
        1800,
        2.3,
        1989,
        3,
        3,
        5,
        3
       );
insert into car (id, active, description, location, mileage , photo_path, price, volume_of_engine, year, car_brand_id, car_model_id, type_auto_id, user_id )
values (3,
        true,
        'Машина премиум-класса. Состояние идеальнейшее. Продаю из-за нехватки денег.',
        'Брест',
        70000,
        null,
        25000,
        4.8,
        2015,
        2,
        1,
        3,
        4
       );
insert into car (id, active, description, location, mileage , photo_path, price, volume_of_engine, year, car_brand_id, car_model_id, type_auto_id, user_id )
values (4,
        false ,
        'на запчачти. не заводится полгода уже как.',
        'Борисов',
        344000,
        null,
        900,
        2.0,
        1998,
        2,
        5,
        2,
        3
       );
