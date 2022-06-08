-- NFTS
INSERT INTO TB_NFT(name,description,price,stars,img,location,created_at,updated_at,type_id, is_popular, is_recommended) VALUES ('Prime Ape','description prime ape',123.00,5,'link image','Brazil','2021-12-27 06:35:34','2020-10-10',2,true,false)
INSERT INTO TB_NFT(name,description,price,stars,img,location,created_at,updated_at,type_id, is_popular, is_recommended) VALUES ('Prime Ape 2','description prime ape 2',123.00,5,'link image 2','Brazil','2021-12-27 06:35:34','2020-10-10',2,true,false)
INSERT INTO TB_NFT(name,description,price,stars,img,location,created_at,updated_at,type_id, is_popular, is_recommended) VALUES ('Prime Ape','description prime ape',123.00,5,'link image','Brazil','2021-12-27 06:35:34','2021-12-27 06:35:34',2,true,false)
INSERT INTO TB_NFT(name,description,price,stars,img,location,created_at,updated_at,type_id, is_popular, is_recommended) VALUES ('Prime Ape','description prime ape',123.00,5,'link image','Brazil','2021-12-27 06:35:34','2021-12-27 06:35:34',2,true,false)
INSERT INTO TB_NFT(name,description,price,stars,img,location,created_at,updated_at,type_id, is_popular, is_recommended) VALUES ('Prime Ape','description prime ape',123.00,5,'link image','Brazil','2021-12-27 06:35:34','2021-12-27 06:35:34',2,true,false)
INSERT INTO TB_NFT(name,description,price,stars,img,location,created_at,updated_at,type_id, is_popular, is_recommended) VALUES ('Prime Ape','description prime ape',123.00,5,'link image','Brazil','2021-12-27 06:35:34','2021-12-27 06:35:34',2,true,false)

-- USERS
INSERT INTO TB_USER(name,username,password,phone) VALUES ('Bruno Cesar', 'user@test.br','$2a$10$jeCpm3XuyQeZtArBeAc6Tu9Uvg1SB2V4xIUxut/rqURweGZVSJME6','+55 (15) 99999-9999')

-- ROLE
INSERT INTO TB_ROLE(name) VALUES ('admin')

-- USER ROLES
INSERT INTO TB_USER_ROLES(user_id,roles_id) VALUES (1,1)

-- ORDER
INSERT INTO TB_ORDER(user_id,date) VALUES (1,'2022-06-07 14:15:00')
INSERT INTO TB_ORDER(user_id,date) VALUES (1,'2022-06-07 15:15:00')

-- ITEM
INSERT INTO TB_ITEM(amount,nft_id,quantity,order_id) VALUES (123.00,1,1,1)
