
//----------------

function mostrarSelecao() {
  var opcao = document.getElementById("opcoes").value;
  var cards = document.getElementsByClassName("card");

  for (var i = 0; i < cards.length; i++) {
    cards[i].style.display = "none";
  }

  if (opcao === "1") {
    for (var i = 0; i < 6; i++) {
      cards[i].style.display = "block";
    }
  } else if (opcao === "2") {
    for (var i = 6; i < 12; i++) {
      cards[i].style.display = "block";
    }
  } else if (opcao === "3") {
    for (var i = 12; i < 18; i++) {
      cards[i].style.display = "block";
    }
  } else if (opcao === "4") {
    for (var i = 18; i < cards.length; i++) {
      cards[i].style.display = "block";
    }
  } else 
  {
    cards[i].style.display = "none";
  }

  //------------------------------------------------------------------------------//

  var imagens = document.getElementsByTagName("img");
  var descricoes = document.getElementsByTagName("p");
  for (var i = 0; i < imagens.length; i++) {
    imagens[i].src = "";
    descricoes[i].textContent = "";
  }

  if (opcao === "1") {
    document.getElementById("foto1").src = "img/img1.jpg";
    let descricao = document.getElementById("descricao");
    descricao.textContent = placa_mae[0].Descricao;

    document.getElementById("foto2").src = "img/img2.jpg";
    let descricao2 = document.getElementById("descricao2");
    descricao2.textContent = processador[0].Descricao;

    document.getElementById("foto3").src = "img/img3.jpg";
    let descricao3 = document.getElementById("descricao3");
    descricao3.textContent = placa_de_video[0].Descricao;

    document.getElementById("foto4").src = "img/img4.jpg";
    let descricao4 = document.getElementById("descricao4");
    descricao4.textContent = memoria_ram[0].Descricao;

    document.getElementById("foto5").src = "img/img5.jpg";
    let descricao5 = document.getElementById("descricao5");
    descricao5.textContent = hdd_ssd[0].Descricao;

    document.getElementById("foto6").src = "img/img6.jpg";
    let descricao6 = document.getElementById("descricao6");
    descricao6.textContent = fonte[0].Descricao;
  } else if (opcao === "2") {
    document.getElementById("foto7").src = "img/img7.jpg";
    let descricao7 = document.getElementById("descricao7");
    descricao7.textContent = placa_mae[1].Descricao;

    document.getElementById("foto8").src = "img/img8.jpg";
    let descricao8 = document.getElementById("descricao8");
    descricao8.textContent = processador[1].Descricao;

    document.getElementById("foto9").src = "img/img9.jpg";
    let descricao9 = document.getElementById("descricao9");
    descricao9.textContent = placa_de_video[1].Descricao;

    document.getElementById("foto10").src = "img/img10.jpg";
    let descricao10 = document.getElementById("descricao10");
    descricao10.textContent = memoria_ram[1].Descricao;

    document.getElementById("foto11").src = "img/img11.jpg";
    let descricao11 = document.getElementById("descricao11");
    descricao11.textContent = hdd_ssd[1].Descricao;

    document.getElementById("foto12").src = "img/img12.jpg";
    let descricao12 = document.getElementById("descricao12");
    descricao12.textContent = fonte[1].Descricao;
  } else if (opcao === "3") {
    document.getElementById("foto13").src = "img/img13.jpg";
    let descricao13 = document.getElementById("descricao13");
    descricao13.textContent = placa_mae[2].Descricao;

    document.getElementById("foto14").src = "img/img14.jpg";
    let descricao14 = document.getElementById("descricao14");
    descricao14.textContent = processador[2].Descricao;

    document.getElementById("foto15").src = "img/img15.jpg";
    let descricao15 = document.getElementById("descricao15");
    descricao15.textContent = placa_de_video[2].Descricao;

    document.getElementById("foto16").src = "img/img16.jpg";
    let descricao16 = document.getElementById("descricao16");
    descricao16.textContent = memoria_ram[2].Descricao;

    document.getElementById("foto17").src = "img/img17.jpg";
    let descricao17 = document.getElementById("descricao17");
    descricao17.textContent = hdd_ssd[2].Descricao;

    document.getElementById("foto18").src = "img/img18.jpg";
    let descricao18 = document.getElementById("descricao18");
    descricao18.textContent = fonte[2].Descricao;
  } else if (opcao === "4") {
    document.getElementById("foto19").src = "img/img19.jpg";
    let descricao19 = document.getElementById("descricao19");
    descricao19.textContent = placa_mae[3].Descricao;
   
    document.getElementById("foto20").src = "img/img20.jpg";
    let descricao20 = document.getElementById("descricao20");
    descricao20.textContent = processador[3].Descricao;
   
    document.getElementById("foto21").src = "img/img21.jpg";
    let descricao21 = document.getElementById("descricao21");
    descricao21.textContent = placa_de_video[3].Descricao;
    
    document.getElementById("foto22").src = "img/img22.jpg";
    let descricao22 = document.getElementById("descricao22");
    descricao22.textContent = memoria_ram[3].Descricao;
  
    document.getElementById("foto23").src = "img/img23.jpg";
    let descricao23 = document.getElementById("descricao23");
    descricao23.textContent = hdd_ssd[3].Descricao;

    document.getElementById("foto24").src = "img/img24.jpg";
    let descricao24 = document.getElementById("descricao24");
    descricao24.textContent = fonte[3].Descricao;
    
  }
}

