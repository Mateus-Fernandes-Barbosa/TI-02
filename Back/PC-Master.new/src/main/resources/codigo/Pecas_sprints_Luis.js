
    let Placa_mae = [
                {
                    "id" : ["mb", 0], //primeiro parâmetro utilizado no switch case para saber qual JSON ser utilizado e o segundo valor para a posição do JSON
                    "Nome_do_componente" : "Placa Mãe Gigabyte Z690 Aorus Elite AX",
                    "Fabricante": "Gigabyte",
                    "Socket": "lga1700",
                    "Geração_Compatível": [12],    //fiz assim pois uma placa mãe pode suportar mais de uma geração, então imagino que assim dá pra fazer um array com as gerações surpotadas
                    "Tipo_de_memória_RAM": "DDR4",
                    "Slots_de_memória_RAM": 4,
                    "Suporte_para_perfil_XPM": true,
                    "Frequência_máxima_perfil_XPM": 5333,   //Dado em Mhz
                    "Entradas_PCIE_X16": 1,   //Se 0 não funciona placa de video
                    "Conectores_SATA": 6,
                    "Interface_SATA": 3.0, //3.0 = 6gb/s  2.0 = 3Gb/s 
                    "Conectores_M2": 4,
                    "Conectores_NVME": 4,
                    "PCIE_máx_conectores_NVME": 4.0,
                    "Preco": 2599.99,
                    "Promocao": 0,
                    "imagem": "https://images.kabum.com.br/produtos/fotos/241911/placa-mae-gigabyte-z690-aorus-elite-rev-1-0-intel-lga-1700-atx-ddr4-m-2-nvme-z690-aorus-elite-ddr4_1635946191_gg.jpg",
                    "Descricao": "",
                    "link": "",
                },
                {
                    "id" : ["mb", 1],
                    "Nome_do_componente" : "Placa Mãe MSI A520M-A PRO mATX",
                    "Fabricante" : "MSI",
                    "Socket" : "AM4",
                    "Geração_Compatível" : [1,2,3,4],   
                    "Tipo_de_memória_RAM" : "DDR4",
                    "Slots_de_memória_RAM" : 2,
                    "Suporte_para_perfil_XPM": true,
                    "Frequência_máxima_perfil_XPM": 4600,   
                    "Entradas_PCIE_X16": 1,    
                    "Conectores_SATA": 4,
                    "Interface_SATA": 3.0,
                    "Conectores_M2": 1,
                    "Conectores_NVME": 1,
                    "PCIE_máx_conectores_NVME": 3.0,
                    "Preco": 499.99,
                    "Promocao": 519.99,
                    "imagem": "https://images.kabum.com.br/produtos/fotos/280890/placa-mae-msi-a520m-a-pro-amd-am4-matx-ddr4_1646852577_gg.jpg",
                    "Descricao": "",
                    "link": "",
                }
                
            ]
    let Processador =  [
                {
                    "id" : ["pro", 0],
                    "Nome_do_componente": "Intel Core i7-12700K",
                    "Fabricante" : "Intel",
                    "Socket": "lga1700",
                    "Geração":  12,
                    "Frequência_máxima_de_memória_RAM" : ["DDR4", 3200,"DDR5", 4800],   //Dado em Mhz
                    "Frequência_Base": 3.6, //Dado em Ghz
                    "Frequência_Turbo": 5.0,    //Dado em Ghz
                    "Potência_básica_do_processador": 125,  //Dado em W
                    "Núcleos": 12,
                    "Threads": 20,
                    "Memória_cache": 25,    //Dado em Mb
                    "Gráfico_integrado": true,
                    "Desbloqueado_para_overclock": true,
                    "Preco": 2199.99,
                    "Promocao": 2444.43,
                    "imagem": "https://images.kabum.com.br/produtos/fotos/241048/processador-intel-core-i7-12700k-cache-25mb-3-6ghz-5-0ghz-max-turbo-lga-1700-bx8071512700k_1634830258_gg.jpg", 
                    "Descricao": "",
                    "link": "",
                },
                {
                    "id" : ["pro", 1],
                    "Nome_do_componente": "AMD Ryzen™ 5 4600G",
                    "Fabricante" : "AMD",
                    "Socket": "AM4",
                    "Geração":  3,
                    "Frequência_máxima_de_memória_RAM" : ["DDR4", 3200],  
                    "Frequência_Base": 3.7, 
                    "Frequência_Turbo": 4.2,   
                    "Potência_básica_do_processador": 65, 
                    "Núcleos": 6,
                    "Threads": 12,
                    "Memória_cache": 11,    
                    "Gráfico_integrado": true,
                    "Desbloqueado_para_overclock": true,
                    "Preco": 599.99,
                    "Promocao": 706.96,
                    "imagem": "https://images.kabum.com.br/produtos/fotos/333145/processador-amd-ryzen-5-4600g-cache-11mb-3-7ghz-4-2ghz-max-turbo-am4-video-integrado-100-100000147box_1653338732_gg.jpg", 
                    "Descricao": "",
                    "link": "",
                },
                {
                    "id" : ["pro", 2],
                    "Nome_do_componente": "AMD Ryzen™ 3 3200G",
                    "Fabricante" : "AMD",
                    "Socket": "AM4",
                    "Geração":  3,
                    "Frequência_máxima_de_memória_RAM" : ["DDR4", 2933],  
                    "Frequência_Base": 3.6, 
                    "Frequência_Turbo": 4,   
                    "Potência_básica_do_processador": 65, 
                    "Núcleos": 4,
                    "Threads": 4,
                    "Memória_cache": 4,    
                    "Gráfico_integrado": true,
                    "Desbloqueado_para_overclock": true,
                    "Preco": 499.99,
                    "Promocao": 0,
                    "imagem": "https://images.kabum.com.br/produtos/fotos/102248/processador-amd-ryzen-3-3200g-cache-4mb-3-6ghz-4ghz-max-turbo-am4-yd3200c5fhbox_1607691191_gg.jpg", 
                    "Descricao": "",
                    "link": "",
                }

            ]

    let Memória_RAM = [
                {
                    "id" : ["ram", 0],
                    "Nome_do_componente": "Kingston Fury Beast",
                    "Modelo": "KF432C16BB/8",
                    "Fabricante": "Kingston",
                    "Tipo_de_memoria_RAM": "DDR4",
                    "Velocidade_Memória": 3200, //Dado em Mhz
                    "LatênciaCl": 16,    //Latência, não tem nenhuma unidade de medida específica
                    "Capacidade": 8,    //Dado em Gb
                    "Suporta_oficialmente_Overclock": true,
                    "Possui_dissipador_de_calor":  true,
                    "Preco": 165.99,
                    "Promocao": 211.75,
                    "imagem": "https://images.kabum.com.br/produtos/fotos/172365/memoria-kingston-fury-beast-8gb-3200mhz-ddr4-cl16-preto-kf432c16bb-8_1626270523_gg.jpg", 
                    "Descricao": "",
                    "link": "",
                },
                {
                    "id" : ["ram", 1],
                    "Nome_do_componente": "Memória Corsair Vengeance LPX",
                    "Modelo": "CMK8GX4M1Z3200C16",
                    "Fabricante": "Corsair",
                    "Tipo_de_memoria_RAM": "DDR4",
                    "Velocidade_Memória": 3200, 
                    "LatênciaCl": 16,    
                    "Capacidade": 8,   
                    "Suporta_oficialmente_Overclock": true,
                    "Possui_dissipador_de_calor":  true,
                    "Preco": 159.99,
                    "Promocao": 189.99,
                    "imagem": "https://images.kabum.com.br/produtos/fotos/429166/memoria-corsair-vengeance-lpx-8gb-1x8gb-3200mhz-ddr4-c16-preto-cmk8gx4m1z3200c16_1678907003_gg.jpg", 
                    "Descricao": "",
                    "link": "",
                },
                {
                    "id" : ["ram", 2],
                    "Nome_do_componente": "Memória XPG Lancer",
                    "Modelo": "AX5U6000C4016G-CLARBK",
                    "Fabricante": "XPG",
                    "Tipo_de_memoria_RAM": "DDR5",
                    "Velocidade_Memória": 6000, 
                    "LatênciaCl": 40,  
                    "Capacidade": 16,   
                    "Suporta_oficialmente_Overclock": true,
                    "Possui_dissipador_de_calor":  true,
                    "Preco": 717.64,
                    "Promocao": 0,
                    "imagem": "https://images.kabum.com.br/produtos/fotos/304035/memoria-xpg-lancer-rgb-16gb-6000mhz-ddr5-cl40-preto-ax5u6000c4016g-clarbk_1642605898_gg.jpg", 
                    "Descricao": "",
                    "link": "",
                },

    ]
    
    let Placa_de_vídeo = [
                {
                    "id" : ["vid", 0],
                    "Nome_do_componente": "RTX 4090 Gaming Trio MSI NVIDIA",
                    "Fabricante_do_chipset": "Nvidea",
                    "Marca": "MSI",
                    "Potência_de_fonte_recomendada": 850,   //Dado em W
                    "Potência_da_placa_de_vídeo": 350,  //Dado em W
                    "Tecnologia_PCIE": 4.0,
                    "Quantidade_de_Vram": 24,   //Dado em Gb
                    "Tecnologia_Vram": "GDDR6X",
                    "Interface": 384,   //Dado em bits
                    "Quantidade_de_CUDA_cores": 16384,
                    "Base_clock": 1.40, //Dado em Ghz
                    "Boost_clock": 1.70,    //Gado em Ghz
                    "Número_de_fans": 3,
                    "Preco": 10499.99,
                    "Promocao": 12511.10,
                    "imagem": "https://images.kabum.com.br/produtos/fotos/388013/placa-de-video-msi-nvidia-geforce-rtx-4090-gaming-trio-24-gb-gddr6x-dlss-ray-tracing-geforce-rtx-4090-24g-geforce-rtx-4090-gaming-trio-24g_1665586454_gg.jpg", 
                    "Descricao": "",
                    "link": "",
                },
                {
                    "id" : ["vid", 1],
                    "Nome_do_componente": "Placa de Vídeo RTX 2060 Ventus MSI ",
                    "Fabricante_do_chipset": "Nvidea",
                    "Marca": "MSI",
                    "Potência_de_fonte_recomendada": 500,   //Dado em W
                    "Potência_da_placa_de_vídeo": 350,  //Dado em W
                    "Tecnologia_PCIE": 4.0,
                    "Quantidade_de_Vram": 24,   //Dado em Gb
                    "Tecnologia_Vram": "GDDR6X",
                    "Interface": 384,   //Dado em bits
                    "Quantidade_de_CUDA_cores": 16384,
                    "Base_clock": 1.40, //Dado em Ghz
                    "Boost_clock": 1.70,    //Gado em Ghz
                    "Número_de_fans": 2,
                    "Preco": 1799.00,
                    "Promocao": 0,
                    "imagem": "https://images.kabum.com.br/produtos/fotos/391124/placa-de-video-msi-nvidia-geforce-rtx-2060-ventus-12-gb-gddr6-ray-tracing-rtx-2060-ventus-12g-oc_1667570594_gg.jpg", 
                    "Descricao": "",
                    "link": "",
                }
            ]

    let Fonte = [
        {
            "id" : ["fnt", 0],
            "Nome_do_componente": "MSI MPG A850G PCIE5",
            "Modelo": "306-7ZP7B12-CE0",
            "Fabricante": "MSI",
            "Potência": 850, //Dado em W
            "Fonte_modular": true,
            "Classificação_de_eficiência": "80 Plus Gold", //80PLUS < 80PLUS BRONZE < 80PLUS siLVER < 80PLUS GOLD < 80PLUS PLATINUM < 80PLUS TITANIUM
            "Preco": 999.99,
            "Promocao": 0,
            "imagem": "https://images.kabum.com.br/produtos/fotos/397723/fonte-msi-mpg-a850g-pcie5-850w-80-plus-gold-modular-pfc-ativo-bivolt-sem-cabo-preto-306-7zp7b12-ce0_1667314048_gg.jpg", 
            "Descricao": "",
            "link": "",
        },
        {
            "id" : ["fnt", 1],
            "Nome_do_componente": "Fonte Corsair CV550",
            "Modelo": "CP-9020210-BR",
            "Fabricante": "Corsair",
            "Potência": 550, 
            "Fonte_modular": false,
            "Classificação_de_eficiência": "80 Plus Bronze",
            "Preco": 549.99,
            "Promocao": 0,
            "imagem": "https://images.kabum.com.br/produtos/fotos/sync_mirakl/456713/Fonte-Corsair-Cv550-550w-Pfc-Ativo-80-Plus-Bronze-Sem-Cabo-De-For-a-Cp-9020210-ww_1681480092_gg.jpg", 
            "Descricao": "",
            "link": "",
        }
    ]
    let Cooler = [
        {
            "id" : ["cool", 0],
            "Nome_do_componente": "Water Cooler Corsair H150",
            "Modelo": "CW-9060053-WW",
            "Fabricante": "Corsair",
            "Tipo_de_socket":  ["AM5", "AM4","lga1700", "lga1200", "lga1150", "lga1151", "lga1155", "lga1156", "lga1366", "lg2011", "lga2066"],
            "Water_cooler": true,
            "Tamanho_das_fans": 360, //Dado em mm
            "Número_de_fans": 3,
            "Preco": 804.99,
            "Promocao": 0,
            "imagem": "https://images.kabum.com.br/produtos/fotos/162466/water-cooler-corsair-h150-rgb-intel-amd-360mm-3x-120mm-preto-cw-9060054-ww_1636559275_gg.jpg", 
            "Descricao": "",
            "link": "",
        },
        {
            "id" : ["cool", 1],
            "Nome_do_componente": "Cooler para Processador Cooler Master HYPER H410R",
            "Modelo": "RR-H410-20PK-R1",
            "Fabricante": "Cooler Master",
            "Tipo_de_socket":  ["AM4", "AM3", "AM2", "FM2", "FM1", "lga1200", "lga1150", "lga1151", "lga1155", "lga1156", "lga775"],
            "Water_cooler": false,
            "Tamanho_das_fans": 92, //Dado em mm
            "Número_de_fans": 1,
            "Preco": 143.86,
            "Promocao": 0,
            "imagem": "https://images.kabum.com.br/produtos/fotos/sync_mirakl/170430/Cooler-Para-Processador-Cooler-Master-Hyper-H410R-LED-Vermelho-4-Heat-Pipes-RR-H410-20PK-R1_1679672931_gg.jpg", 
            "Descricao": "",
            "link": "",
        }
    ]

    //Apartir daqui é a área de armazenamento
    let SSD_M2_NVME = [
        {
            "id" : ["nvme", 0],
            "Nome_do_componente": "Adata Legend 710",
            "Modelo": "ALEG-710-512GCS",
            "Fabricante": "Adata",
            "Tipo_de_PCIE": 3.0,
            "Leitura_sequencial": 2400,//Dado em Mb/s
            "Gravação_sequencial": 1800,// Dado em Mb/s
            "Armazenamento": 512, //Dadp em Gb
            "Possui_dissipador_de_calor": true,
            "Expectativa_de_vida_útil": 1.5, //Dado em milhões de horas MTB
            "Preco": 174.99,
            "Promocao": 270.58,
            "imagem": "https://images.kabum.com.br/produtos/fotos/415885/ssd-adata-legend-710-512gb-m-2-2280-pcie-gen3x4-nvme-1-4-leitura-2-400-mb-s-e-gravacao-1-800-mb-s-azul-aleg-710-512gcs_1675085973_gg.jpg", 
            "Descricao": "",
            "link": "",
        },
        {
            "id" : ["nvme", 1],
            "Nome_do_componente": "SSD Kingston Fury Renegade",
            "Modelo": "SFYRS/1000G",
            "Fabricante": "Kingston",
            "Tipo_de_PCIE": 4.0,
            "Leitura_sequencial": 7300,
            "Gravação_sequencial": 6000,
            "Armazenamento": 1024, 
            "Possui_dissipador_de_calor": true,
            "Expectativa_de_vida_útil": 1.8, 
            "Preco": 699.99,
            "Promocao": 910.05,
            "imagem": "https://images.kabum.com.br/produtos/fotos/272356/ssd-kingston-fury-renegade-1000gb-m-2-2280-pcie-nvme-leituras-7-300mb-s-gravacao-6-000mb-s-sfyrs-1000g_1637328670_gg.jpg", 
            "Descricao": "",
            "link": "",
        }
    ]

    let SSD_M2_SATA = [
        {
            "id" : ["m2sata", 0],
            "Nome_do_componente": "SSD 250 GB WD Blue, M.2",
            "Modelo": "WDS250G3B0B",
            "Fabricante": "Western digital",
            "Interface SATA": [3.0, 2.0],
            "Leitura_sequencial": 555,//Dado em Mb/s
            "Gravação_sequencial": 440,// Dado em Mb/s
            "Armazenamento": 250, //Dadp em Gb
            "Possui_dissipador_de_calor": true,
            "Expectativa_de_vida_útil": 1.75, //Dado em milhões de horas MTB
            "Preco": 252.99,
            "Promocao": 0,
            "imagem": "https://images.kabum.com.br/produtos/fotos/351528/ssd-wd-blue-250gb-m-2-leitura-555mb-s-gravacao-440mb-s-wds250g3b0b-8203-_1657309381_gg.jpg", 
            "Descricao": "",
            "link": "",
        }
        
    ]
    let SSD_SATA = [
        {
            "id" : ["ssdsata", 0],
            "Nome_do_componente": "SSD 240 GB Kingston A400",
            "Modelo": "SA400S37/240G",
            "Fabricante": "Kingston",
            "Leitura_sequencial": 500,//Dado em Mb/s
            "Gravação_sequencial": 300,// Dado em Mb/s
            "Armazenamento": 240, //Dadp em Gb
            "Expectativa_de_vida_útil": 1, //Dado em milhões de horas MTB
            "Preco": 129.99,
            "Promocao": 204.55,
            "imagem": "https://images.kabum.com.br/produtos/fotos/85197/85197_1484306076_gg.jpg", 
            "Descricao": "",
            "link": "",
        }
    ]

    let HD_SATA = [
        {
            "id" : ["hd", 0],
            "Nome_do_componente": "HD Seagate BarraCuda, 3.5', SATA - ST4000DM004",
            "Fabricante": "Seagate",
            "Cache": 256, //Dado em Mb
            "Velocidade": 5400, //Dado em rpm
            "Interface_SATA": 3.5,
            "Armazenamento": 4096, //Dadp em Gb
            "Taxa_de_transferência_da_interface_SATA": 600, //Dado em MB/s
            "Taxa_máxima_de_transferência_de_dados": 190, //Dado em Mb/s
            "Preco": 449.99,
            "Promocao": 705.85,
            "imagem": "https://images.kabum.com.br/produtos/fotos/95803/95803_1522867513_index_gg.jpg", 
            "Descricao": "",
            "link": "",
        },
    ]
    