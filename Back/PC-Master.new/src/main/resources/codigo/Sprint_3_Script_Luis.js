//Função que quando a tela carregar testa se existem as chaves criadas no LocalStorage, e se não armazenam o JSON convertido em string nesse localStorage
window.onload = function armazenarLocalstorage() {
    if(typeof(localStorage.Placa_mae) === 'undefined'){
        let parametros = JSON.stringify(Placa_mae);
        localStorage.setItem("Placa_mae",parametros);
        console.log("Sucesso1");
    };
    if (typeof(localStorage.Processador) === 'undefined'){
        let parametros = JSON.stringify(Processador);
        localStorage.setItem("Processador",parametros);
        console.log("Sucesso1");
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

    imprimirJSON(localStorage.Placa_mae);
    imprimirJSON(localStorage.Processador);
    imprimirJSON(localStorage.Memória_RAM);
    imprimirJSON(localStorage.Placa_de_vídeo);
    imprimirJSON(localStorage.Fonte);
    imprimirJSON(localStorage.Cooler);
    imprimirJSON(localStorage.SSD_M2_NVME);
    imprimirJSON(localStorage.SSD_M2_SATA);
    imprimirJSON(localStorage.SSD_SATA);
    imprimirJSON(localStorage.HD_SATA);    
};

//Função que adiciona os produtos do JSON armazenado no localStorage na div "cards"
function imprimirJSON(stringJSON){
    let tela = document.getElementById("cards");
    let stringLS = stringJSON;
    let JSONLocalStorage = JSON.parse(stringLS);

    for (let c=0; c<JSONLocalStorage.length; c++){
        let divNova = document.createElement("div");
        divNova.innerHTML = `
        <div class="col">
            <div class="card h-100">
                <img src="${JSONLocalStorage[c].imagem}" class="card-img-top" alt="...">
                <div class="card-body">
                    <a id="tituloCards" href="#">
                        <h5 class="card-title">${JSONLocalStorage[c].Nome_do_componente}</h5>
                    </a>
                    <p class="card-text"> R$ ${JSONLocalStorage[c].Preco}${JSONLocalStorage[c].Promocao !== 0 ? `<span> R$ ${JSONLocalStorage[c].Promocao}</span>` : ''}</p>
                    <p class="card-text">À vista ou no pix</p>
                </div>
                <button class="card-footer" onclick="maisDetalhes('${JSONLocalStorage[c].id[0]}', ${JSONLocalStorage[c].id[1]})">
                    <div class="text-card-body">Mais detlhes</div>
                </button>
            </div>
        </div>
        `;
        
        // adiciona o novo elemento criado e seu conteúdo ao DOM
        var divAtual = document.getElementById("cards");
        divAtual.appendChild(divNova);
    }
}

function maisDetalhes(tipoPeca, posicao){
    const detalhesTela = document.getElementById("detalhes");
    const detalhesConteudo = document.getElementById("detalhesProduto");
    const cards = document.getElementById("precos");
    detalhesConteudo.innerHTML = '';
    
    let divNova = document.createElement("div");

    switch (tipoPeca){
        case 'mb'://Mother board (Placa mãe)
            let placaMaeInfo = JSON.parse(localStorage.Placa_mae);
            placaMaeInfo = placaMaeInfo[posicao];

            divNova.innerHTML = `
            <img src="${placaMaeInfo.imagem}" alt="Imagem da Placa-Mãe">
            <div class="descricao"> 
                <h2>${placaMaeInfo.Nome_do_componente}</h2>
                <p class="especification">Fabricante: ${placaMaeInfo.Fabricante}</p>
                <p class="especification">Socket: ${placaMaeInfo.Socket}</p>
                <p class="especification">Geração Compatível: ${placaMaeInfo.Geração_Compatível}</p>
                <p class="especification">Tipo de memória RAM: ${placaMaeInfo.Tipo_de_memória_RAM}</p>
                <p class="especification">Slots de memória RAM: ${placaMaeInfo.Slots_de_memória_RAM}</p>
                <p class="especification">Suporte para perfil XPM: ${placaMaeInfo.Suporte_para_perfil_XPM ? 'Sim' : 'Não'}</p>
                <p class="especification">Frequência máxima perfil XPM: ${placaMaeInfo.Frequência_máxima_perfil_XPM} MHz</p>
                <p class="especification">Entradas PCIE X16: ${placaMaeInfo.Entradas_PCIE_X16}</p>
                <p class="especification">Conectores SATA: ${placaMaeInfo.Conectores_SATA}</p>
                <p class="especification">Interface SATA: ${placaMaeInfo.Interface_SATA} Gb/s</p>
                <p class="especification">Conectores M.2: ${placaMaeInfo.Conectores_M2}</p>
                <p class="especification">Conectores NVME: ${placaMaeInfo.Conectores_NVME}</p>
                <p class="especification">PCIE máx. conectores NVME: ${placaMaeInfo.PCIE_máx_conectores_NVME}</p>
                <p class="especification">Preço: R$ ${placaMaeInfo.Preco}</p>
                <p class="especification">Promoção: R$ ${placaMaeInfo.Promocao}</p>
            </div>

            <a href="#">Ir para a loja</a>
            
            </div>
            `;
            break;

        case 'pro'://Processador
            let processadorInfo = JSON.parse(localStorage.Processador);
            processadorInfo = processadorInfo[posicao];
            
            divNova.innerHTML = `
            <img src="${processadorInfo.imagem}" alt="Imagem do Processador">
            <div>
                <h2>${processadorInfo.Nome_do_componente}</h2>
                <p class="especification">Fabricante: ${processadorInfo.Fabricante}</p>
                <p class="especification">Socket: ${processadorInfo.Socket}</p>
                <p class="especification">Geração: ${processadorInfo.Geração}</p>
                <p class="especification">Frequência máxima de memória RAM: ${processadorInfo.Frequência_máxima_de_memória_RAM.join(" / ")}</p>
                <p class="especification">Frequência Base: ${processadorInfo.Frequência_Base} GHz</p>
                <p class="especification">Frequência Turbo: ${processadorInfo.Frequência_Turbo} GHz</p>
                <p class="especification">Potência básica do processador: ${processadorInfo.Potência_básica_do_processador} W</p>
                <p class="especification">Núcleos: ${processadorInfo.Núcleos}</p>
                <p class="especification">Threads: ${processadorInfo.Threads}</p>
                <p class="especification">Memória cache: ${processadorInfo.Memória_cache} MB</p>
                <p class="especification">Gráfico integrado: ${processadorInfo.Gráfico_integrado ? 'Sim' : 'Não'}</p>
                <p class="especification">Desbloqueado para overclock: ${processadorInfo.Desbloqueado_para_overclock ? 'Sim' : 'Não'}</p>
                <p class="especification">Preço: R$ ${processadorInfo.Preco}</p>
                <p class="especification">Promoção: R$ ${processadorInfo.Promocao}</p>
            </div>
            <a href="#">Ir para a loja</a>
            `;
            break;
        case 'ram'://Memória ram
            let memoriaRamInfo = JSON.parse(localStorage.Memória_RAM);
            memoriaRamInfo = memoriaRamInfo[posicao];

            divNova.innerHTML = `
            <img src="${memoriaRamInfo.imagem}" alt="Imagem da Memória RAM">
            <div>
                <h2>${memoriaRamInfo.Nome_do_componente}</h2>
                <p class="especification">Fabricante: ${memoriaRamInfo.Fabricante}</p>
                <p class="especification">Modelo: ${memoriaRamInfo.Modelo}</p>
                <p class="especification">Tipo de memória RAM: ${memoriaRamInfo.Tipo_de_memoria_RAM}</p>
                <p class="especification">Velocidade da Memória: ${memoriaRamInfo.Velocidade_Memória} MHz</p>
                <p class="especification">Latência (CL): ${memoriaRamInfo.LatênciaCl}</p>
                <p class="especification">Capacidade: ${memoriaRamInfo.Capacidade} GB</p>
                <p class="especification">Suporta oficialmente Overclock: ${memoriaRamInfo.Suporta_oficialmente_Overclock ? 'Sim' : 'Não'}</p>
                <p class="especification">Possui dissipador de calor: ${memoriaRamInfo.Possui_dissipador_de_calor ? 'Sim' : 'Não'}</p>
                <p class="especification">Preço: R$ ${memoriaRamInfo.Preco}</p>
                <p class="especification">Promoção: R$ ${memoriaRamInfo.Promocao}</p>
            </div>
            <a href="#">Ir para a loja</a>
            `;
            break;
        case 'vid'://Placa de vídeo
            let placaVideoInfo = JSON.parse(localStorage.Placa_de_vídeo);
            placaVideoInfo = placaVideoInfo[posicao];

            divNova.innerHTML = `
            <img src="${placaVideoInfo.imagem}" alt="Imagem da Placa de Vídeo">
            <div>
                <h2>${placaVideoInfo.Nome_do_componente}</h2>
                <p class="especification">Fabricante do chipset: ${placaVideoInfo.Fabricante_do_chipset}</p>
                <p class="especification">Marca: ${placaVideoInfo.Marca}</p>
                <p class="especification">Potência de fonte recomendada: ${placaVideoInfo.Potência_de_fonte_recomendada} W</p>
                <p class="especification">Potência da placa de vídeo: ${placaVideoInfo.Potência_da_placa_de_vídeo} W</p>
                <p class="especification">Tecnologia PCIE: ${placaVideoInfo.Tecnologia_PCIE}</p>
                <p class="especification">Quantidade de VRAM: ${placaVideoInfo.Quantidade_de_Vram} GB</p>
                <p class="especification">Tecnologia VRAM: ${placaVideoInfo.Tecnologia_Vram}</p>
                <p class="especification">Interface: ${placaVideoInfo.Interface} bits</p>
                <p class="especification">Quantidade de CUDA cores: ${placaVideoInfo.Quantidade_de_CUDA_cores}</p>
                <p class="especification">Base clock: ${placaVideoInfo.Base_clock} GHz</p>
                <p class="especification">Boost clock: ${placaVideoInfo.Boost_clock} GHz</p>
                <p class="especification">Número de fans: ${placaVideoInfo.Número_de_fans}</p>
                <p class="especification">Preço: R$ ${placaVideoInfo.Preco}</p>
                <p class="especification">Promoção: R$ ${placaVideoInfo.Promocao}</p>
            </div>
            <a href="#">Ir para a loja</a>
            `;
            break;
        case 'fnt'://Fonte
            let fonteInfo = JSON.parse(localStorage.Fonte);
            fonteInfo = fonteInfo[posicao];

            divNova.innerHTML = `
            <img src="${fonteInfo.imagem}" alt="Imagem da Fonte de Alimentação">
            <div>
                <h2>${fonteInfo.Nome_do_componente}</h2>
                <p class="especification">Modelo: ${fonteInfo.Modelo}</p>
                <p class="especification">Fabricante: ${fonteInfo.Fabricante}</p>
                <p class="especification">Potência: ${fonteInfo.Potência} W</p>
                <p class="especification">Fonte modular: ${fonteInfo.Fonte_modular ? 'Sim' : 'Não'}</p>
                <p class="especification">Classificação de eficiência: ${fonteInfo.Classificação_de_eficiência}</p>
                <p class="especification">Preço: R$ ${fonteInfo.Preco}</p>
                <p class="especification">Promoção: R$ ${fonteInfo.Promocao}</p>
            </div>
            <a href="#">Ir para a loja</a>
            `;
            break;
        case 'cool'://Cooler
            let coolerInfo = JSON.parse(localStorage.Cooler);
            coolerInfo = coolerInfo[posicao];
            
            divNova.innerHTML = `
            <img src="${coolerInfo.imagem}" alt="Imagem do Cooler">
            <div>
                <h2>${coolerInfo.Nome_do_componente}</h2>
                <p class="especification">Modelo: ${coolerInfo.Modelo}</p>
                <p class="especification">Fabricante: ${coolerInfo.Fabricante}</p>
                <p class="especification">Tipo de Socket: ${coolerInfo.Tipo_de_socket.join(", ")}</p>
                <p class="especification">Water Cooler: ${coolerInfo.Water_cooler ? 'Sim' : 'Não'}</p>
                <p class="especification">Tamanho das Fans: ${coolerInfo.Tamanho_das_fans} mm</p>
                <p class="especification">Número de Fans: ${coolerInfo.Número_de_fans}</p>
                <p class="especification">Preço: R$ ${coolerInfo.Preco}</p>
                <p class="especification">Promoção: R$ ${coolerInfo.Promocao}</p>
            </div>
            <a href="#">Ir para a loja</a>
            `;
            break;
        case 'nvme'://SSD M2-NVME
            let ssdInfo = JSON.parse(localStorage.SSD_M2_NVME);
            ssdInfo = ssdInfo[posicao];

            divNova.innerHTML = `
            <img src="${ssdInfo.imagem}" alt="Imagem do SSD M.2 NVMe">
            <div>
                <h2>${ssdInfo.Nome_do_componente}</h2>
                <p class="especification">Modelo: ${ssdInfo.Modelo}</p>
                <p class="especification">Fabricante: ${ssdInfo.Fabricante}</p>
                <p class="especification">Tipo de PCIe: ${ssdInfo.Tipo_de_PCIE}</p>
                <p class="especification">Leitura Sequencial: ${ssdInfo.Leitura_sequencial} MB/s</p>
                <p class="especification">Gravação Sequencial: ${ssdInfo.Gravação_sequencial} MB/s</p>
                <p class="especification">Armazenamento: ${ssdInfo.Armazenamento} GB</p>
                <p class="especification">Possui Dissipador de Calor: ${ssdInfo.Possui_dissipador_de_calor ? 'Sim' : 'Não'}</p>
                <p class="especification">Expectativa de Vida Útil: ${ssdInfo.Expectativa_de_vida_útil} milhões de horas MTB</p>
                <p class="especification">Preço: R$ ${ssdInfo.Preco}</p>
                <p class="especification">Promoção: R$ ${ssdInfo.Promocao}</p>
            </div>
            <a href="#">Ir para a loja</a>
            `;
            break;
        case 'm2sata'://SSD M2-SATA
            let ssdInfo2 = JSON.parse(localStorage.SSD_M2_SATA);
            ssdInfo2 = ssdInfo2[posicao];
            divNova.innerHTML = `
            <img src="${ssdInfo2.imagem}" alt="Imagem do SSD M.2 SATA">
            <div>
                <h2>${ssdInfo2.Nome_do_componente}</h2>
                <p class="especification">Modelo: ${ssdInfo2.Modelo}</p>
                <p class="especification">Fabricante: ${ssdInfo2.Fabricante}</p>
                <p class="especification">Interface SATA: ${ssdInfo2['Interface SATA'].join(', ')}</p>
                <p class="especification">Leitura Sequencial: ${ssdInfo2.Leitura_sequencial} MB/s</p>
                <p class="especification">Gravação Sequencial: ${ssdInfo2.Gravação_sequencial} MB/s</p>
                <p class="especification">Armazenamento: ${ssdInfo2.Armazenamento} GB</p>
                <p class="especification">Possui Dissipador de Calor: ${ssdInfo2.Possui_dissipador_de_calor ? 'Sim' : 'Não'}</p>
                <p class="especification">Expectativa de Vida Útil: ${ssdInfo2.Expectativa_de_vida_útil} milhões de horas MTB</p>
                <p class="especification">Preço: R$ ${ssdInfo2.Preco}</p>
                <p class="especification">Promoção: R$ ${ssdInfo2.Promocao}</p>
            </div>    
            <a href="#">Ir para a loja</a>        
            `;
            break;
        case 'ssdsata'://SSD SATA
            let ssdInfo3 = JSON.parse(localStorage.SSD_SATA);
            ssdInfo3 = ssdInfo3[posicao];
            divNova.innerHTML = `
            <img src="${ssdInfo3.imagem}" alt="Imagem do SSD SATA">
            <div>
                <h2>${ssdInfo3.Nome_do_componente}</h2>
                <p class="especification">Modelo: ${ssdInfo3.Modelo}</p>
                <p class="especification">Fabricante: ${ssdInfo3.Fabricante}</p>
                <p class="especification">Leitura Sequencial: ${ssdInfo3.Leitura_sequencial} MB/s</p>
                <p class="especification">Gravação Sequencial: ${ssdInfo3.Gravação_sequencial} MB/s</p>
                <p class="especification">Armazenamento: ${ssdInfo3.Armazenamento} GB</p>
                <p class="especification">Expectativa de Vida Útil: ${ssdInfo3.Expectativa_de_vida_útil} milhões de horas MTB</p>
                <p class="especification">Preço: R$ ${ssdInfo3.Preco}</p>
                <p class="especification">Promoção: R$ ${ssdInfo3.Promocao}</p>
            </div>
            <a href="#">Ir para a loja</a>
            `;
            break;
        case 'hd'://HD (hard drive)
            let hdInfo = JSON.parse(localStorage.HD_SATA);
            hdInfo = hdInfo[posicao];
            divNova.innerHTML = `
            <img src="${hdInfo.imagem}" alt="Imagem do HD SATA">
            <div>
                <h2>${hdInfo.Nome_do_componente}</h2>
                <p class="especification">Fabricante: ${hdInfo.Fabricante}</p>
                <p class="especification">Cache: ${hdInfo.Cache} MB</p>
                <p class="especification">Velocidade: ${hdInfo.Velocidade} RPM</p>
                <p class="especification">Interface SATA: ${hdInfo.Interface_SATA}"</p>
                <p class="especification">Armazenamento: ${hdInfo.Armazenamento} GB</p>
                <p class="especification">Taxa de Transferência da Interface SATA: ${hdInfo.Taxa_de_transferência_da_interface_SATA} MB/s</p>
                <p class="especification">Taxa Máxima de Transferência de Dados: ${hdInfo.Taxa_máxima_de_transferência_de_dados} Mb/s</p>
                <p class="especification">Preço: R$ ${hdInfo.Preco}</p>
                <p class="especification">Promoção: R$ ${hdInfo.Promocao}</p>
            </div>
            <a href="#">Ir para a loja</a>
            `;
            break;
    }

    detalhesConteudo.appendChild(divNova);
    detalhesTela.style.display = 'block';
    cards.style.display = 'none';

}

function mostrarTodosProdutos(){
    const detalhesTela = document.getElementById("detalhes");
    const cards = document.getElementById("precos");

    detalhesTela.style.display = 'none';
    cards.style.display = 'block';
}

function pesquisar(){
    var divAtual = document.getElementById("cards");
    divAtual.innerHTML = '';
    imprimirPesquisa(localStorage.Placa_mae);
    imprimirPesquisa(localStorage.Processador);
    imprimirPesquisa(localStorage.Memória_RAM);
    imprimirPesquisa(localStorage.Placa_de_vídeo);
    imprimirPesquisa(localStorage.Fonte);
    imprimirPesquisa(localStorage.Cooler);
    imprimirPesquisa(localStorage.SSD_M2_NVME);
    imprimirPesquisa(localStorage.SSD_M2_SATA);
    imprimirPesquisa(localStorage.SSD_SATA);
    imprimirPesquisa(localStorage.HD_SATA);   
    
}

function imprimirPesquisa(stringJSON){
    let input = document.getElementById("pesquisaNome");
    let texto = input.value.toLowerCase();
    let stringLS = stringJSON;
    let JSONLocalStorage = JSON.parse(stringLS);
    stringLS = stringJSON.toLowerCase();
    let JSONPesquisa = JSON.parse(stringLS);
    
    for (let c=0; c<JSONLocalStorage.length; c++){
        console.log(JSONLocalStorage[c].Nome_do_componente.indexOf(texto) !== -1);
        if (JSONPesquisa[c].nome_do_componente.indexOf(texto) !== -1){
        divNova = document.createElement("div");
        divNova.innerHTML = `
        <div class="col">
            <div class="card h-100">
                <img src="${JSONLocalStorage[c].imagem}" class="card-img-top" alt="...">
                <div class="card-body">
                    <a id="tituloCards" href="#">
                        <h5 class="card-title">${JSONLocalStorage[c].Nome_do_componente}</h5>
                    </a>
                    <p class="card-text"> R$ ${JSONLocalStorage[c].Preco}${JSONLocalStorage[c].Promocao !== 0 ? `<span> R$ ${JSONLocalStorage[c].Promocao}</span>` : ''}</p>
                    <p class="card-text">À vista ou no pix</p>
                </div>
                <button class="card-footer" onclick="maisDetalhes('${JSONLocalStorage[c].id[0]}', ${JSONLocalStorage[c].id[1]})">
                    <div class="text-body-secondary">Mais detlhes</div>
                </button>
            </div>
        </div>
        `;
        
        // adiciona o novo elemento criado e seu conteúdo ao DOM

        var divAtual = document.getElementById("cards");
        divAtual.appendChild(divNova);
        }
    }
}
