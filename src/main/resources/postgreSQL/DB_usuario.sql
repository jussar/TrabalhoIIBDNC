/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Jussara
 * Created: 23/03/2018
 */

create table usuario(

id SERIAL PRIMARY KEY,
email varchar(60) NOT NULL UNIQUE,
nome varchar(60) NOT NULL UNIQUE,
senha varchar(20) NOT NULL UNIQUE

);
