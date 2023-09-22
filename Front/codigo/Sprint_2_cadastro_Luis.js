let tela = document.getElementById('Conteudo_cadastro')
//Função que quando a tela carregar testa se existem as chaves criadas no LocalStorage, e se não armazenam o JSON convertido em string nesse localStorage
window.onload = function armazenarLocalstorage() {
    if(typeof(localStorage.Placa_mae) === 'undefined'){
        let parametros = JSON.stringify(Placa_mae);
        localStorage.setItem("Placa_mae",parametros);
    };
    if (typeof(localStorage.Processador) === 'undefined'){
        let parametros = JSON.stringify(Processador);
        localStorage.setItem("Processador",parametros);
    }
    if (typeof(localStorage.Memória_RAM) === 'undefined'){
        let parametros = JSON.stringify(Memória_RAM);
        localStorage.setItem("Memória_RAM",parametros);
    };
    if (typeof(localStorage.Placa_de_vídeo) === 'undefined'){
        let parametros = JSON.stringify(Placa_de_vídeo);
        localStorage.setItem("Placa_de_vídeo",parametros);
    };
    if (typeof(localStorage.Fonte) === 'undefined'){
        let parametros = JSON.stringify(Fonte);
        localStorage.setItem("Fonte",parametros);
    };
    if (typeof(localStorage.Cooler) === 'undefined'){
        let parametros = JSON.stringify(Cooler);
        localStorage.setItem("Cooler",parametros);
    };
    if (typeof(localStorage.SSD_M2_NVME) === 'undefined'){
        let parametros = JSON.stringify(SSD_M2_NVME);
        localStorage.setItem("SSD_M2_NVME",parametros);
    };
    if (typeof(localStorage.SSD_M2_SATA) === 'undefined'){
        let parametros = JSON.stringify(SSD_M2_SATA);
        localStorage.setItem("SSD_M2_SATA",parametros);
    };
    if (typeof(localStorage.SSD_SATA) === 'undefined'){
        let parametros = JSON.stringify(SSD_SATA);
        localStorage.setItem("SSD_SATA",parametros);
    };
    if (typeof(localStorage.HD_SATA) === 'undefined'){
        let parametros = JSON.stringify(HD_SATA);
        localStorage.setItem("HD_SATA",parametros);
    }; 
}; 

$('#Tipo_peca').change(function () {
    let escolha = $('#Tipo_peca').val();

    //Operador lógico
    if (escolha == 'placa-mae') {
        tela.innerHTML = `
                <br><br><br>
                <input id="Nome_do_componente" class="form-control" type="text" placeholder="Digite o nome do componente" aria-label="default input example">
                <label for="Fabricante">Fabricante:</label>
                <select id="Fabricante" class="form-select form-select-lg mb-3" aria-label=".form-select-m example">
                <option selected disabled></option>
                <option value="ASUS">ASUS</option>
                <option value="AsRock">AsRock</option>
                <option value="Gigabyte">Gigabyte</option>
                <option value="MSI">MSI</option>
                <option value="Biostar">Biostar</option>
                </select>
                <label for="Socket">Tipo de socket da placa-mãe:</label>
                <select id="Socket" class="form-select form-select-lg mb-3" aria-label=".form-select-m example">
                <option selected disabled></option>
                <option value="lga775">LGA 775</option>
                <option value="lga1366">LGA 1366</option>
                <option value="lga1156">LGA 1156</option>
                <option value="lga2011">LGA 2011</option>
                <option value="lga1155">LGA 1155</option>
                <option value="lga1150">LGA 1150</option>
                <option value="lga2011-3">LGA 2011-3</option>
                <option value="lga1151">LGA 1151</option>
                <option value="lga2066">LGA 2066</option>
                <option value="lga1200">LGA 1200</option>
                <option value="lga1700">LGA 1700</option>
                <option value="AM2">AM2</option>
                <option value="AM3">AM3</option>
                <option value="AM3+">AM3+</option>
                <option value="AM4">AM4</option>
                <option value="AM5">AM5</option>
                <option value="FM1">FM1</option>
                <option value="FM2">FM2</option>
                </select>
                <label for="Geração_Compatível">Gerações Compatíveis (separar com vírgula e sem espaço):</label>
                <input id="Geração_Compatível" class="form-control" type="text" placeholder="Digite o nome do componente" aria-label="default input example">
                <label for="Tipo_de_memória_RAM">Tipo de memória RAM:</label>
                <select id="Tipo_de_memória_RAM" class="form-select form-select-lg mb-3" aria-label=".form-select-m example">
                <option selected disabled></option>
                <option value="DDR3">DDR3</option>
                <option value="DDR4">DDR4</option>
                <option value="DDR5">DDR5</option>
                </select>
                <label for="Slots_de_memória_RAM">Quantidade de slots de memória RAM:</label>
                <select id="Slots_de_memória_RAM" class="form-select form-select-lg mb-3" aria-label=".form-select-m example">
                <option selected disabled></option>
                <option value="2">2</option>
                <option value="4">4</option>
                <option value="8">8</option>
                <option value="12">12</option>
                </select>
                <label for="Suporte_para_perfil_XPM">Possui suporte para perfil XPM?:</label>
                <select id="Suporte_para_perfil_XPM" class="form-select form-select-lg mb-3" aria-label=".form-select-m example">
                <option selected disabled></option>
                <option value="true">Sim</option>
                <option value="false">Não</option>
                </select>
                <label for="Frequência_máxima_perfil_XPM">Frequência máxima do perfil XPM (apenas número):</label>
                <input id="Frequência_máxima_perfil_XPM" class="form-control" type="number" placeholder="Digite o valor em Mhz" aria-label="default input example">
                <label for="Entradas_PCIE_X16">Quatidades de entradas PCIE X16:</label>
                <select id="Entradas_PCIE_X16" class="form-select form-select-lg mb-3" aria-label=".form-select-m example">
                <option selected disabled></option>
                <option value="1">1</option>
                <option value="2">2</option>
                </select>
                <label for="Conectores_SATA">Quatidade de conectores SATA:</label>
                <input id="Conectores_SATA" class="form-control" type="number" placeholder="Digite o número" aria-label="default input example">
                <label for="Interface_SATA">Digite a interface SATA da placa mãe:</label>
                <input id="Interface_SATA" class="form-control" type="number" placeholder="Digite o número" aria-label="default input example">
                <label for="Conectores_M2">Digite a quantidade de entradas M2:</label>
                <input id="Conectores_M2" class="form-control" type="number" placeholder="Digite o número" aria-label="default input example">
                <label for="Conectores_NVME">Digite a quantidade de entradas NVME:</label>
                <input id="Conectores_NVME" class="form-control" type="number" placeholder="Digite o número" aria-label="default input example">
                <label for="PCIE_máx_conectores_NVME">Digite o número da tecnologia PCIExpress máxima compativel nas portas NVME:</label>
                <input id="PCIE_máx_conectores_NVME" class="form-control" type="number" placeholder="Digite o número" aria-label="default input example">
                <label for="Preço">Digite o preço do componente:</label>"
                <input id="Preço" class="form-control" type="number" placeholder="Digite o número" aria-label="default input example">
                <label for="Imagem">Digite o link da imagem do componente:</label>
                <input id="Imagem" class="form-control" type="text" placeholder="Digite o link da imagem" aria-label="default input example">
            `;
    }
    else if (escolha == 'processador') {
        console.log('Opção processador selecionada');
    }
    else if (escolha == 'memoria-ram') {
        tela.innerHTML = "<div>cornosssss</div>";
        console.log('Opção memória-ram selecionada');
    }
    else if (escolha == 'placa-de-video') {
        console.log('Opção Placa de viedo selecionada');
    }
    else if (escolha == 'HD') {
        console.log('Opção HD selecionada');
    }
    else if (escolha == 'SSD') {
        console.log('A 5ª opção SSD selecionada!');
    }
    else if (escolha == 'fonte') {
        console.log('A 5ª opção Fonte selecionada!');
    }

});

function cadastrar() {
    let escolha = $('#Tipo_peca').val();

    if (escolha == 'placa-mae') {
          // Verifica se todos os campos estão preenchidos
  if (
    $('#Nome_do_Componente').val() !== null &&
    $('#Fabricante').val() !== null &&
    $('#Socket').val() !== null &&
    $('#Geração_Compatível').val() !== null &&
    $('#Tipo_de_memória_RAM').val() !== null &&
    $('#Slots_de_memória_RAM').val() !== null &&
    $('#Suporte_para_perfil_XPM').val() !== null &&
    $('#Frequência_máxima_perfil_XPM').val() !== null &&
    $('#Entradas_PCIE_X16').val() !== null &&
    $('#Conectores_SATA').val() !== null &&
    $('#Interface_SATA').val() !== null &&
    $('#Conectores_M2').val() !== null &&
    $('#Conectores_NVME').val() !== null &&
    $('#PCIE_máx_conectores_NVME').val() !== null &&
    $('#Preço').val() !== null &&
    $('#Imagem').val() !== null 
  ) {
    
    let id = JSON.parse(localStorage.Placa_mae).length
    id = JSON.stringify(id);
    id = parseInt(id);

    let tempObj = [
        {
          "id": ["mb", $(id)[0]],
          "Nome_do_componente": $('#Nome_do_componente').val(),
          "Fabricante": $('#Fabricante').val(),
          "Socket": $('#Socket').val(),
          "Geração_Compatível": $('#Geração_Compatível').val().split(','),
          "Tipo_de_memória_RAM": $('#Tipo_de_memória_RAM').val(),
          "Slots_de_memória_RAM": $('#Slots_de_memória_RAM').val(),
          "Suporte_para_perfil_XPM": $('#Suporte_para_perfil_XPM').val(),
          "Frequência_máxima_perfil_XPM": $('#Frequência_máxima_perfil_XPM').val(),
          "Entradas_PCIE_X16": $('#Entradas_PCIE_X16').val(),
          "Conectores_SATA": $('#Conectores_SATA').val(),
          "Interface_SATA": $('#Interface_SATA').val(),
          "Conectores_M2": $('#Conectores_M2').val(),
          "Conectores_NVME": $('#Conectores_NVME').val(),
          "PCIE_máx_conectores_NVME": $('#PCIE_máx_conectores_NVME').val(),
          "Preco": $('#Preço').val(),
          "Promocao": 0,
          "imagem": $('#Imagem').val(),
        }
      ];
    
    Temp1 = localStorage.getItem('Placa_mae');
    Temp1 = Temp1.substring(0, Temp1.length - 1);
    tempObj = JSON.stringify(tempObj);
    tempObj =  Temp1 + ',' + tempObj.substring(1, tempObj.length -0);

    localStorage.setItem("Placa_mae", tempObj);
  } else {
    // Exiba uma mensagem de erro ou faça algo quando os campos não estiverem preenchidos
    alert('Por favor, preencha todos os campos antes de cadastrar.');
  }

    }

}

function pecasRegistradas() {
    // Obtém a div pelo ID
    const divPlacaMaeInfo = document.getElementById("cards");
    // Limpa o conteúdo da div
    divPlacaMaeInfo.innerHTML = "";


    // Itera sobre cada objeto no array placaMae
    for (let i = 0; i < JSON.parse(localStorage.Placa_mae).length; i++) {
        const PlacaMae = JSON.parse(localStorage.Placa_mae);
        const placaMaeInfo = PlacaMae[i];

        // Cria um elemento de parágrafo para cada informação e adiciona ao div
        let p = document.createElement("p");
        p.innerHTML = `
        <div class="col">
            <div class="card h-100">
                <b>Nome do Componente:</b> ${placaMaeInfo.Nome_do_componente} <br>
                <b>Fabricante:</b> ${placaMaeInfo.Fabricante} <br>
                <b>Socket:</b> ${placaMaeInfo.Socket} <br>
                <b>Geração Compatível:</b> ${placaMaeInfo.Geração_Compatível} <br>
                <b>Tipo de Memória RAM:</b> ${placaMaeInfo.Tipo_de_memória_RAM} <br>
                <b>Slots de Memória RAM:</b> ${placaMaeInfo.Slots_de_memória_RAM} <br>
                <b>Suporte para Perfil XPM:</b> ${placaMaeInfo.Suporte_para_perfil_XPM} <br>
                <b>Frequência Máxima do Perfil XPM:</b> ${placaMaeInfo.Frequência_máxima_perfil_XPM} MHz <br>
                <b>Entradas PCIe X16:</b> ${placaMaeInfo.Entradas_PCIE_X16} <br>
                <b>Conectores SATA:</b> ${placaMaeInfo.Conectores_SATA} <br>
                <b>Interface SATA:</b> ${placaMaeInfo.Interface_SATA} <br>
                <b>Conectores M2:</b> ${placaMaeInfo.Conectores_M2} <br>
                <b>Conectores NVME:</b> ${placaMaeInfo.Conectores_NVME} <br>
                <b>PCI-E Máximo de Conectores NVME:</b> ${placaMaeInfo.PCIE_máx_conectores_NVME} <br>
                <b>Preço:</b> R$ ${placaMaeInfo.Preco} <br>
                <b>Preço sem promoção:</b> R$ ${placaMaeInfo.Promocao} <br>
                <img src="${placaMaeInfo.imagem}" alt="Imagem da Placa Mãe" width="400">
            </div>
        </div>
        `;

        divPlacaMaeInfo.appendChild(p);
    }
}