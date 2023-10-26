
/*----------------ALERTA--------------------------- */

function exibirAlerta() {
  alert("Quando o trabalho estiver pronto, clicar aqui te levará para o Home!");
}

/*------------------------COMPATIBILIDADE--------------------------*/ 

function verificarCompatibilidade() {
  var peca1 = document.getElementById("peca1").value;
  var peca2 = document.getElementById("peca2").value;

  var compatibilidade = "";

  // ---------------------  PRIMEIRA PEÇA COM A SEGUNDA ---------------//
  if (peca1 === peca2) {
    compatibilidade = "Essas peças são iguais";
  } else if (peca1 === "placa-mae" && peca2 === "processador") {
    compatibilidade = "Compatíveis";
  } else if (peca1 === "placa-mae" && peca2 === "memoria-ram") {
    compatibilidade = "Compatíveis";
  } else if (peca1 === "placa-mae" && peca2 === "placa-de-video") {
    compatibilidade = "Compatíveis";
  } else if (peca1 === "placa-mae" && peca2 === "HD") {
    compatibilidade = "Compatíveis";
  } else if (peca1 === "placa-mae" && peca2 === "SSD") {
    compatibilidade = "Compatíveis";
  } else if (peca1 === "placa-mae" && peca2 === "fonte") {
    compatibilidade = "Compatíveis";
  }

  // ------------------------------- INVERSÃO DE DA ORDEM DAS PEÇAS SEGUINDO O MESMO RACIOCINIO ---------------------------------
  else if (peca1 === "processador" && peca2 === "placa-mae") {
    compatibilidade = "Compatíveis";
  } else if (peca1 === "memoria-ram" && peca2 === "placa-mae") {
    compatibilidade = "Compatíveis";
  } else if (peca1 === "placa-de-video" && peca2 === "placa-mae") {
    compatibilidade = "Compatíveis";
  } else if (peca1 === "HD" && peca2 === "placa-mae") {
    compatibilidade = "Compatíveis";
  } else if (peca1 === "SSD" && peca2 === "placa-mae") {
    compatibilidade = "Compatíveis";
  } else if (peca1 === "fonte" && peca2 === "placa-mae") {
    compatibilidade = "Compatíveis";
  } else {
    compatibilidade = "Incompatíveis";
  }

  document.getElementById("compatibilidade").textContent =
    "Compatibilidade: " + compatibilidade;
}
