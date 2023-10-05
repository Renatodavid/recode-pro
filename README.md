<h1 >Segue o banco de dados feito no BrModelo e uma breve explicação. <h1/>
<hr>
<h5> Usuário para Reserva:</h5>
 <p>

Um usuário pode ter zero ou várias reservas. (1:N)
Uma reserva pertence a exatamente um usuário. (N:1)

Reserva para Agência:

Uma reserva pertence a exatamente uma agência. (N:1)
Uma agência pode ter zero ou várias reservas. (1:N)


Cada usuário pode realizar várias reservas, mas cada reserva é associada a apenas um usuário.
Cada reserva está vinculada a uma agência específica, mas uma agência pode ter várias reservas associadas a ela.

 </p>
 <hr>

![entrega modelo conceitual br modelo](https://github.com/Renatodavid/recode-pro/assets/106851081/f2f99353-f8e5-4170-976f-10199cd009a0)

<hr>

![modelo logico fim](https://github.com/Renatodavid/recode-pro/assets/106851081/c090ed62-7dec-4c14-a5b6-197cf354bcc1)

<hr>

![modelo logicosql](https://github.com/Renatodavid/recode-pro/assets/106851081/b5845c78-adc6-4ac8-9618-bb65080fdf18)

![modelo logico sql 2° parte](https://github.com/Renatodavid/recode-pro/assets/106851081/7e3b6ca3-dc31-4dbd-8da7-fb0d35452bf8)

<hr>
<h1>Segue o codigo do modelo fisíco + arquivo </h1>
CREATE TABLE agenciaRr (
agenciaRr_cd_id INTEGER PRIMARY KEY,
data_saida DECIMAL(10),
hora_chegada DATETIME,
hora_partidatime DATETIME,
data_chegada_dt DATETIME,
reserva_cd_id INTEGER
);
CREATE TABLE Usuario (
usu_cd_id INTEGER PRIMARY KEY,
usu_tx_nome_usuario VARCHAR(100),
celular_tx VARCHAR(15),
usu_tx_cpf VARCHAR(11),
usu_tx_email VARCHAR(100),
senha_tx VARCHAR(8),
genero_tx VARCHAR(100)
);
CREATE TABLE reserva (
reserva_cd_ INTEGER PRIMARY KEY,
origem_tx VARCHAR(100),
destino_tx VARCHAR(100),
valor_Double NUMERIC(65),
usu_cd_id INTEGER,
FOREIGN KEY(usu_cd_id) REFERENCES Usuario (usu_cd_id)
);
ALTER TABLE agenciaRr ADD FOREIGN KEY(reserva_cd_id) REFERENCES reserva (reserva_cd_id);
<hr>
[Uploading entregaModeloFisico.sql…]()
