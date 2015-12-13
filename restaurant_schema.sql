drop table FOOD_ITEM;
drop table INGREDIENTS;
drop table ORDER_FOOD_ITEM_MAP;
drop table ORDERS;

create table FOOD_ITEM (
	ITEM_ID bigint unsigned primary key AUTO_INCREMENT,
	VERSION bigint unsigned,
	NAME varchar(100),
	COST decimal(19,2)	
);

create table INGREDIENTS (
	ITEM_ID bigint,
	INGREDIENTS varchar(100)
);

create table ORDER_FOOD_ITEM_MAP (
	ITEM_ID bigint,
	ORDER_ID bigint
);

create table ORDERS(
	ORDER_ID bigint unsigned primary key AUTO_INCREMENT,
	VERSION bigint unsigned,
	ORDER_NO varchar(100),
	TOTAL_AMOUNT decimal(19,2)	
);


insert into FOOD_ITEM (VERSION,NAME,COST) values (1,"Chicken Curry", 10.00);
insert into INGREDIENTS (ITEM_ID, INGREDIENTS) select ITEM_ID,"Chicken Curry" from FOOD_ITEM where Name="Chicken Curry";
insert into INGREDIENTS (ITEM_ID, INGREDIENTS) select ITEM_ID,"Tomatoes" from FOOD_ITEM where Name="Chicken Curry";
insert into INGREDIENTS (ITEM_ID, INGREDIENTS) select ITEM_ID,"Onions" from FOOD_ITEM where Name="Chicken Curry"; 

insert into FOOD_ITEM (VERSION,NAME,COST) values (1, "Chicken Fried rice", 12.00);
insert into INGREDIENTS (ITEM_ID, INGREDIENTS) select ITEM_ID,"Chicken" from FOOD_ITEM where Name="Chicken Fried rice";
insert into INGREDIENTS (ITEM_ID, INGREDIENTS) select ITEM_ID,"Rice" from FOOD_ITEM where Name="Chicken Fried rice";

insert into FOOD_ITEM (VERSION,NAME,COST) values (1, "Chicken Noodles", 10.00);
insert into INGREDIENTS (ITEM_ID, INGREDIENTS) select ITEM_ID,"Chicken" from FOOD_ITEM where Name="Chicken Noodles";
insert into INGREDIENTS (ITEM_ID, INGREDIENTS) select ITEM_ID,"Noodles" from FOOD_ITEM where Name="Chicken Noodles";

commit;