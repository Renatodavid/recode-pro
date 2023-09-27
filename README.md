<h1 >Segue o banco de dados feito no BrModelo e uma breve explicação.h1/>
<hr>

 <h2> Tabela <strong>'usuario'</strong>:</h2>

<h3>Cardinalidade para 'pacotes':</h3>
  <p>
  A tabela 'usuario' tem uma relação com a tabela 'pacotes' por meio da coluna 'id_usuario',que é uma chave estrangeira.
  Isso significa que um usuário pode estar associado a vários pacotes de viagem, mas cada pacote está associado a apenas um usuário.
  Portanto, a cardinalidade é "1 para muitos" do lado do usuário e "1 para 1" do lado dos pacotes.
  <p/>

<hr>
  
<h3> Cardinalidade para 'reserva':</h2>
 <p> Da mesma forma, um usuário pode ter várias reservas, mas cada reserva está associada a apenas um usuário.
   A cardinalidade é "1 para muitos" do lado do usuário e "1 para 1" do lado das reservas.
Tabela 'promocoes':
</p>
<hr>

<h3> Cardinalidade para 'pacotes':</h3>
 <p> A tabela 'promocoes' está relacionada com a tabela 'pacotes' por meio da coluna 'id_promocoes', que é uma chave estrangeira.
   Isso implica que várias promoções podem ser associadas a muitos pacotes, mas cada pacote está associado a apenas uma promoção. 
   Portanto, a cardinalidade é "1 para muitos" do lado das promoções e "1 para 1" do lado dos pacotes.
 </p>
 
<hr>

 <h3> Cardinalidade para 'reserva':</h3>
  <p> Similarmente, várias promoções podem estar associadas a muitas reservas, mas cada reserva está associada a apenas uma promoção. 
    A cardinalidade é "1 para muitos" do lado das promoções e "1 para 1" do lado das reservas.
    </p>
    
    <hr>
    
<h2> Tabela <strong> 'pacotes': </strong></h2>

<h3> Cardinalidade para 'usuario':</h3>
<p> Como mencionado anteriormente, um pacote está associado a um único usuário (1) por meio da coluna 'id_usuario'.</p>
<hr>
<h3> Cardinalidade para 'promocoes':</h3> <p>Um pacote também está associado a uma única promoção (1) por meio da coluna 'id_promocoes'.</p>
<hr>
<h3> Cardinalidade para 'reserva':</h3> <p> Vários pacotes podem estar associados a muitas reservas, e muitas reservas podem estar associadas a muitos pacotes. 
  Isso resulta em uma cardinalidade "muitos para muitos" entre pacotes e reservas.</p>
Tabela 'reserva':
<hr>
<h3> Cardinalidade para 'pacotes':</h3> <p> Conforme mencionado anteriormente, muitas reservas podem estar associadas a muitos pacotes, resultando em uma cardinalidade "muitos para muitos" entre reservas e pacotes.
Cardinalidade para 'promocoes': Cada reserva está associada a uma única promoção (1) por meio da coluna 'id_promocoes'.
</P>

<hr>

